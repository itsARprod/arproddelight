package com.arprod.arproddelight.block_entity;

import com.arprod.arproddelight.init.ArproddelightModBlockEntities;
import com.arprod.arproddelight.init.ArproddelightModRecipes;
import com.arprod.arproddelight.recipe.DeepFryingRecipe;
import com.simibubi.create.AllParticleTypes;
import com.simibubi.create.content.processing.basin.BasinBlockEntity;
import com.simibubi.create.content.processing.burner.BlazeBurnerBlock.HeatLevel;
import com.simibubi.create.content.fluids.particle.FluidParticleData;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import com.simibubi.create.foundation.fluid.FluidIngredient;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler.FluidAction;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.registry.ModSounds;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FryingBasketBlockEntity extends BlockEntity {
    private final ItemStackHandler noDropInventory = new ItemStackHandler(0);

    private int progress;
    private int maxProgress;
    @Nullable
    private DeepFryingRecipe activeRecipe;

    public FryingBasketBlockEntity(BlockPos pos, BlockState state) {
        super(ArproddelightModBlockEntities.FRYING_BASKET.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, FryingBasketBlockEntity be) {
        if (level.isClientSide) {
            return;
        }

        BasinBlockEntity basin = be.getBasin(level, pos);
        if (basin == null) {
            be.resetProgress();
            return;
        }

        DeepFryingRecipe recipe = be.findMatchingRecipe(level, basin);
        if (recipe == null) {
            be.resetProgress();
            return;
        }

        if (be.activeRecipe == null || !be.activeRecipe.getId().equals(recipe.getId())) {
            be.activeRecipe = recipe;
            be.progress = 0;
        }

        be.maxProgress = recipe.getProcessingTime();
        be.progress++;
        be.emitProcessingEffects(level, pos, recipe, basin);

        if (be.progress >= be.maxProgress) {
            if (be.canCompleteRecipe(recipe, basin)) {
                be.executeRecipe(recipe, basin);
            }
            be.progress = 0;
        }
    }

    private void resetProgress() {
        progress = 0;
        maxProgress = 0;
        activeRecipe = null;
    }

    @Nullable
    private BasinBlockEntity getBasin(Level level, BlockPos pos) {
        BlockEntity below = level.getBlockEntity(pos.below());
        return below instanceof BasinBlockEntity basin ? basin : null;
    }


    @Nullable
    private DeepFryingRecipe findMatchingRecipe(Level level, BasinBlockEntity basin) {
        List<DeepFryingRecipe> recipes = getSortedRecipes(level);
        for (DeepFryingRecipe recipe : recipes) {
            if (canCompleteRecipe(recipe, basin)) {
                return recipe;
            }
        }
        return null;
    }

    private List<DeepFryingRecipe> getSortedRecipes(Level level) {
        List<DeepFryingRecipe> recipes = new ArrayList<>(level.getRecipeManager().getAllRecipesFor(ArproddelightModRecipes.DEEP_FRYING_TYPE.get()));
        recipes.sort(Comparator.comparingInt((DeepFryingRecipe r) -> r.getIngredients().size() + r.getFluidIngredients().size()).reversed());
        return recipes;
    }

    private boolean canCompleteRecipe(DeepFryingRecipe recipe, BasinBlockEntity basin) {
        return checkRecipe(recipe, basin).success();
    }

    private RecipeCheck checkRecipe(DeepFryingRecipe recipe, BasinBlockEntity basin) {
        if (level == null) {
            return new RecipeCheck(recipe.getId().toString(), false, "level is null");
        }

        HeatLevel heat = BasinBlockEntity.getHeatLevelOf(level.getBlockState(worldPosition.below(2)));
        if (!recipe.getRequiredHeat().testBlazeBurner(heat)) {
            return new RecipeCheck(recipe.getId().toString(), false,
                    "heat mismatch: required=" + recipe.getRequiredHeat().serialize() + " actual=" + heat.name().toLowerCase());
        }

        IItemHandler itemHandler = basin.getCapability(ForgeCapabilities.ITEM_HANDLER).orElse(null);
        IFluidHandler fluidHandler = basin.getCapability(ForgeCapabilities.FLUID_HANDLER).orElse(null);

        String itemFailure = getItemIngredientFailure(recipe, itemHandler);
        if (itemFailure != null) {
            return new RecipeCheck(recipe.getId().toString(), false, itemFailure);
        }
        String fluidFailure = getFluidIngredientFailure(recipe, fluidHandler);
        if (fluidFailure != null) {
            return new RecipeCheck(recipe.getId().toString(), false, fluidFailure);
        }

        if (recipe.hasFuel()) {
            FluidIngredient fuel = recipe.getFuel();
            if (!canSatisfyFluidAmount(fuel, fuel.getRequiredAmount(), fluidHandler)) {
                return new RecipeCheck(recipe.getId().toString(), false,
                        "not enough fuel present; requires " + fuel.getRequiredAmount() + "mB to start");
            }
        }

        if (!basin.acceptOutputs(recipe.getRollableResultsAsItemStacks(), recipe.getFluidResults(), true)) {
            return new RecipeCheck(recipe.getId().toString(), false, "outputs do not fit basin output");
        }

        return new RecipeCheck(recipe.getId().toString(), true, "ok");
    }

    @Nullable
    private String getItemIngredientFailure(DeepFryingRecipe recipe, IItemHandler itemHandler) {
        int[] simulatedUsage = new int[itemHandler.getSlots()];
        int idx = 1;
        for (Ingredient ingredient : recipe.getIngredients()) {
            boolean matched = false;
            for (int slot = 0; slot < itemHandler.getSlots(); slot++) {
                ItemStack stack = itemHandler.getStackInSlot(slot);
                if (stack.isEmpty() || !ingredient.test(stack)) {
                    continue;
                }
                int available = stack.getCount() - simulatedUsage[slot];
                if (available <= 0) {
                    continue;
                }
                simulatedUsage[slot]++;
                matched = true;
                break;
            }
            if (!matched) {
                return "missing item ingredient #" + idx;
            }
            idx++;
        }
        return null;
    }

    @Nullable
    private String getFluidIngredientFailure(DeepFryingRecipe recipe, IFluidHandler fluidHandler) {
        int[] simulatedUsage = new int[fluidHandler.getTanks()];

        int idx = 1;
        for (FluidIngredient ingredient : recipe.getFluidIngredients()) {
            if (!consumeFluidSimulation(ingredient, ingredient.getRequiredAmount(), fluidHandler, simulatedUsage)) {
                return "missing fluid ingredient #" + idx + " amount=" + ingredient.getRequiredAmount() + "mB";
            }
            idx++;
        }

        if (recipe.hasFuel()) {
            if (!consumeFluidSimulation(recipe.getFuel(), recipe.getFuelAmountToConsume(), fluidHandler, simulatedUsage)) {
                return "not enough fuel for consumption step; needs " + recipe.getFuelAmountToConsume() + "mB";
            }
        }

        return null;
    }

    private boolean canSatisfyFluidAmount(FluidIngredient ingredient, int amountRequired, IFluidHandler fluidHandler) {
        int[] simulatedUsage = new int[fluidHandler.getTanks()];
        return consumeFluidSimulation(ingredient, amountRequired, fluidHandler, simulatedUsage);
    }

    private boolean consumeFluidSimulation(FluidIngredient ingredient, int amountRequired, IFluidHandler fluidHandler, int[] simulatedUsage) {
        int remaining = amountRequired;
        for (int tank = 0; tank < fluidHandler.getTanks(); tank++) {
            FluidStack stack = fluidHandler.getFluidInTank(tank);
            if (stack.isEmpty() || !ingredient.test(stack)) {
                continue;
            }
            int available = stack.getAmount() - simulatedUsage[tank];
            if (available <= 0) {
                continue;
            }
            int consume = Math.min(available, remaining);
            simulatedUsage[tank] += consume;
            remaining -= consume;
            if (remaining <= 0) {
                return true;
            }
        }
        return false;
    }

    private void executeRecipe(DeepFryingRecipe recipe, BasinBlockEntity basin) {
        IItemHandler itemHandler = basin.getCapability(ForgeCapabilities.ITEM_HANDLER).orElse(null);
        IFluidHandler fluidHandler = basin.getCapability(ForgeCapabilities.FLUID_HANDLER).orElse(null);

        if (!consumeItemIngredients(recipe, itemHandler)) {
            return;
        }
        if (!consumeFluidIngredients(recipe, fluidHandler)) {
            return;
        }

        basin.acceptOutputs(recipe.rollResults(), recipe.getFluidResults(), false);
        setChanged();
    }

    private boolean consumeItemIngredients(DeepFryingRecipe recipe, IItemHandler itemHandler) {
        for (Ingredient ingredient : recipe.getIngredients()) {
            boolean consumed = false;
            for (int slot = 0; slot < itemHandler.getSlots(); slot++) {
                ItemStack stack = itemHandler.getStackInSlot(slot);
                if (stack.isEmpty() || !ingredient.test(stack)) {
                    continue;
                }
                ItemStack extracted = itemHandler.extractItem(slot, 1, false);
                if (!extracted.isEmpty()) {
                    consumed = true;
                    break;
                }
            }
            if (!consumed) {
                return false;
            }
        }
        return true;
    }

    private boolean consumeFluidIngredients(DeepFryingRecipe recipe, IFluidHandler fluidHandler) {
        for (FluidIngredient ingredient : recipe.getFluidIngredients()) {
            if (!consumeFluidAmount(ingredient, ingredient.getRequiredAmount(), fluidHandler)) {
                return false;
            }
        }

        if (recipe.hasFuel()) {
            return consumeFluidAmount(recipe.getFuel(), recipe.getFuelAmountToConsume(), fluidHandler);
        }

        return true;
    }

    private boolean consumeFluidAmount(FluidIngredient ingredient, int amountRequired, IFluidHandler fluidHandler) {
        int remaining = amountRequired;
        for (int tank = 0; tank < fluidHandler.getTanks(); tank++) {
            FluidStack stack = fluidHandler.getFluidInTank(tank);
            if (stack.isEmpty() || !ingredient.test(stack)) {
                continue;
            }

            int toDrain = Math.min(stack.getAmount(), remaining);
            FluidStack drainRequest = stack.copy();
            drainRequest.setAmount(toDrain);
            FluidStack drained = fluidHandler.drain(drainRequest, FluidAction.EXECUTE);
            if (drained.isEmpty()) {
                continue;
            }
            remaining -= drained.getAmount();
            if (remaining <= 0) {
                return true;
            }
        }
        return false;
    }

    private void emitProcessingEffects(Level level, BlockPos pos, DeepFryingRecipe recipe, BasinBlockEntity basin) {
        if (progress % 24 == 0 && recipe.getRequiredHeat() != HeatCondition.NONE) {
            level.playSound(null, pos, ModSounds.BLOCK_SKILLET_SIZZLE.get(), SoundSource.BLOCKS,
                    1.2f, 0.95f + level.random.nextFloat() * 0.1f);
        }

        if (!(level instanceof ServerLevel serverLevel)) {
            return;
        }

        FluidStack fuelSample = getFuelSampleStack(recipe, basin);
        if (fuelSample.isEmpty()) {
            return;
        }
        FluidParticleData fluidParticle = new FluidParticleData(AllParticleTypes.BASIN_FLUID.get(), fuelSample);

        int count = 2 + level.random.nextInt(2);
        for (int i = 0; i < count; i++) {
            double x = pos.getX() + 0.3 + level.random.nextDouble() * 0.4;
            double y = pos.getY() - 0.15 + level.random.nextDouble() * 0.15;
            double z = pos.getZ() + 0.3 + level.random.nextDouble() * 0.4;
            serverLevel.sendParticles(ParticleTypes.BUBBLE, x, y, z, 1, 0.0, 0.03, 0.0, 0.0);
            serverLevel.sendParticles(fluidParticle, x, y, z, 1, 0.01, 0.03, 0.01, 0.0);
        }
    }

    private FluidStack getFuelSampleStack(DeepFryingRecipe recipe, BasinBlockEntity basin) {
        if (!recipe.hasFuel()) {
            return FluidStack.EMPTY;
        }
        IFluidHandler fluidHandler = basin.getCapability(ForgeCapabilities.FLUID_HANDLER).orElse(null);
        FluidIngredient fuel = recipe.getFuel();
        for (int tank = 0; tank < fluidHandler.getTanks(); tank++) {
            FluidStack stack = fluidHandler.getFluidInTank(tank);
            if (stack.isEmpty() || !fuel.test(stack)) continue;
            FluidStack sample = stack.copy();
            sample.setAmount(1);
            return sample;
        }
        return FluidStack.EMPTY;
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("Progress", progress);
        tag.putInt("MaxProgress", maxProgress);
    }

    @Override
    public void load(@NotNull CompoundTag tag) {
        super.load(tag);
        progress = tag.getInt("Progress");
        maxProgress = tag.getInt("MaxProgress");
    }

    private record RecipeCheck(String recipeId, boolean success, String reason) {
    }
}
