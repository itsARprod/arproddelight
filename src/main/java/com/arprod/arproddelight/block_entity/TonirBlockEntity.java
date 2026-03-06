package com.arprod.arproddelight.block_entity;

import com.arprod.arproddelight.recipe.TonirCookingRecipe;
import com.arprod.arproddelight.init.ArproddelightModBlockEntities;
import com.arprod.arproddelight.init.ArproddelightModRecipes;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TonirBlockEntity extends BlockEntity implements WorldlyContainer {

    private static final int TONIR_STACK_CAP = 16;
    private static final int[] SLOTS = new int[]{0};

    private ItemStack stack = ItemStack.EMPTY;
    private int cookTime = 0;
    private int cookTimeTotal = 100; // default 5s
    private int storedExperience = 0;
    private final LazyOptional<IItemHandler> itemHandler = LazyOptional.of(() -> new InvWrapper(this));

    public TonirBlockEntity(BlockPos pos, BlockState state) {
        super(ArproddelightModBlockEntities.TONIR.get(), pos, state);
    }

    /* ---------------------------------------------------------
       PLAYER INSERT / EXTRACT
       --------------------------------------------------------- */

    // returns amount actually inserted
    public int insertFromPlayer(ItemStack incoming) {
        if (incoming.isEmpty()) return 0;
        if (!canStackWithCurrent(incoming)) return 0;

        int limit = getLimitFor(incoming);
        int amount = Math.min(limit - stack.getCount(), incoming.getCount());
        if (amount <= 0) return 0;

        if (stack.isEmpty()) {
            stack = incoming.copyWithCount(amount);
        } else {
            stack.grow(amount);
        }
        setChanged();
        return amount;
    }

    public ItemStack extractItem() {
        if (stack.isEmpty()) return ItemStack.EMPTY;
        ItemStack out = stack.copy();
        stack = ItemStack.EMPTY;
        setChanged();
        return out;
    }

    public ItemStack getStack() {
        return stack;
    }

    /* ---------------------------------------------------------
       TICK
       --------------------------------------------------------- */

    public static void tick(Level level, BlockPos pos, BlockState state, TonirBlockEntity be) {
        if (level.isClientSide) return;

        if (be.stack.isEmpty()) {
            be.cookTime = 0;
            return;
        }

        if (!hasHeat(level, pos)) {
            be.cookTime = 0;
            return;
        }

        TonirCookingRecipe recipe = be.getRecipe(level);
        if (recipe == null) {
            be.cookTime = 0;
            return;
        }

        be.cookTimeTotal = recipe.getCookTime();
        be.cookTime++;

        if (be.cookTime >= be.cookTimeTotal) {
            be.finishCooking(level, pos, recipe);
            be.cookTime = 0;
        }
    }

    private static boolean hasHeat(Level level, BlockPos pos) {
        BlockState below = level.getBlockState(pos.below());
        return below.is(TagKey.create(
                Registries.BLOCK,
                new ResourceLocation("farmersdelight", "heat_sources")
        ));
    }

    private TonirCookingRecipe getRecipe(Level level) {
        return level.getRecipeManager()
                .getRecipeFor(ArproddelightModRecipes.TONIR_TYPE.get(),
                        new SimpleContainer(stack), level)
                .orElse(null);
    }

    private void finishCooking(Level level, BlockPos pos, TonirCookingRecipe recipe) {
        int inputCount = stack.getCount();
        ItemStack result = recipe.getResult().copy();

        // Cook the whole stack in one cycle and keep output in internal inventory.
        int totalOutput = inputCount * result.getCount();
        stack = result.copyWithCount(Math.min(getLimitFor(result), totalOutput));

        // Store XP for later player collection (furnace-like behavior).
        storedExperience += Math.max(0, recipe.getExperience()) * inputCount;

        setChanged();
    }

    public boolean awardStoredExperience(Player player) {
        if (storedExperience <= 0) return false;
        player.giveExperiencePoints(storedExperience);
        storedExperience = 0;
        setChanged();
        return true;
    }

    /* ---------------------------------------------------------
       NBT SAVE / LOAD
       --------------------------------------------------------- */

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        if (!stack.isEmpty()) {
            tag.put("Item", stack.save(new CompoundTag()));
        }
        tag.putInt("CookTime", cookTime);
        tag.putInt("StoredExperience", storedExperience);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        if (tag.contains("Item")) {
            stack = ItemStack.of(tag.getCompound("Item"));
        } else {
            stack = ItemStack.EMPTY;
        }
        cookTime = tag.getInt("CookTime");
        storedExperience = tag.getInt("StoredExperience");
    }

    /* ---------------------------------------------------------
       WORLDLY CONTAINER (HOPPERS)
       --------------------------------------------------------- */

    @Override
    public int[] getSlotsForFace(Direction side) {
        return SLOTS;
    }

    @Override
    public boolean canPlaceItemThroughFace(int slot, ItemStack incoming, Direction dir) {
        return canStackWithCurrent(incoming);
    }

    @Override
    public boolean canTakeItemThroughFace(int slot, ItemStack stack, Direction dir) {
        return true;
    }

    @Override
    public int getContainerSize() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public ItemStack getItem(int slot) {
        return stack;
    }

    @Override
    public ItemStack removeItem(int slot, int amount) {
        ItemStack result = stack.split(amount);
        if (stack.isEmpty()) stack = ItemStack.EMPTY;
        setChanged();
        return result;
    }

    @Override
    public ItemStack removeItemNoUpdate(int slot) {
        ItemStack s = stack;
        stack = ItemStack.EMPTY;
        return s;
    }

    @Override
    public void setItem(int slot, ItemStack s) {
        stack = s.copy();
        int limit = stack.isEmpty() ? TONIR_STACK_CAP : getLimitFor(stack);
        if (stack.getCount() > limit) {
            stack.setCount(limit);
        }
        setChanged();
    }

    @Override
    public boolean canPlaceItem(int slot, ItemStack incoming) {
        return canStackWithCurrent(incoming);
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public void clearContent() {
        stack = ItemStack.EMPTY;
        setChanged();
    }

    private boolean canStackWithCurrent(ItemStack incoming) {
        if (incoming.isEmpty()) return false;
        if (stack.isEmpty()) return incoming.getCount() > 0;
        return ItemStack.isSameItemSameTags(stack, incoming) && stack.getCount() < getLimitFor(stack);
    }

    private int getLimitFor(ItemStack itemStack) {
        return Math.min(TONIR_STACK_CAP, itemStack.getMaxStackSize());
    }

    @Override
    public int getMaxStackSize() {
        return TONIR_STACK_CAP;
    }

    @Override
    public <T> @NotNull LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return itemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        itemHandler.invalidate();
    }
}
