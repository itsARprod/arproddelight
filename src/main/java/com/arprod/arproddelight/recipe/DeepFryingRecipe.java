package com.arprod.arproddelight.recipe;

import com.arprod.arproddelight.init.ArproddelightModRecipes;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.simibubi.create.content.processing.basin.BasinRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder.ProcessingRecipeParams;
import com.simibubi.create.foundation.fluid.FluidIngredient;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class DeepFryingRecipe extends BasinRecipe {

    private FluidIngredient fuel = FluidIngredient.EMPTY;

    public DeepFryingRecipe(ProcessingRecipeParams params) {
        super(ArproddelightModRecipes.DEEP_FRYING_RECIPE_INFO, params);
    }

    @Override
    protected int getMaxInputCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    protected int getMaxOutputCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    protected int getMaxFluidInputCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    protected int getMaxFluidOutputCount() {
        return Integer.MAX_VALUE;
    }

    public FluidIngredient getFuel() {
        return fuel;
    }

    public boolean hasFuel() {
        return fuel != FluidIngredient.EMPTY;
    }

    public int getProcessingTime() {
        int duration = getProcessingDuration();
        return duration > 0 ? duration * 20 : 100;
    }

    public int getFuelAmountToConsume() {
        if (!hasFuel()) {
            return 0;
        }
        int required = fuel.getRequiredAmount();
        return Math.max(1, (required + 9) / 10);
    }

    @Override
    public void readAdditional(JsonObject json) {
        if (!json.has("fuel")) {
            fuel = FluidIngredient.EMPTY;
            return;
        }

        JsonElement fuelElement = json.get("fuel");
        if (!FluidIngredient.isFluidIngredient(fuelElement)) {
            throw new JsonParseException("deep_frying recipe fuel must be a fluid ingredient");
        }

        FluidIngredient parsedFuel = FluidIngredient.deserialize(fuelElement);
        if (parsedFuel.getRequiredAmount() <= 0) {
            throw new JsonParseException("deep_frying recipe fuel amount must be greater than 0");
        }
        fuel = parsedFuel;
    }

    @Override
    public void writeAdditional(@NotNull JsonObject json) {
        if (hasFuel()) {
            json.add("fuel", fuel.serialize());
        }
    }

    @Override
    public void readAdditional(FriendlyByteBuf buffer) {
        fuel = buffer.readBoolean() ? FluidIngredient.read(buffer) : FluidIngredient.EMPTY;
    }

    @Override
    public void writeAdditional(FriendlyByteBuf buffer) {
        boolean hasFuel = hasFuel();
        buffer.writeBoolean(hasFuel);
        if (hasFuel) {
            fuel.write(buffer);
        }
    }

    @Override
    public boolean matches(Container inv, @NotNull Level worldIn) {
        return false;
    }
}
