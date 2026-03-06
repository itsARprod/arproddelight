package com.arprod.arproddelight.recipe;

import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.List;

import com.arprod.arproddelight.init.ArproddelightModRecipes;


public class TonirCookingRecipe implements Recipe<Container> {

    private final ResourceLocation id;
    private final Ingredient input;
    private final ItemStack result;
    private final int cookTime;
    private final int xp;

    public TonirCookingRecipe(ResourceLocation id, Ingredient input,
                              ItemStack result, int cookTime, int xp) {
        this.id = id;
        this.input = input;
        this.result = result;
        this.cookTime = cookTime <= 0 ? 100 : cookTime;
        this.xp = Math.max(0, xp);
    }


    @Override
    public boolean matches(Container container, Level level) {
        return input.test(container.getItem(0));
    }

    @Override
    public ItemStack assemble(Container p_44001_, RegistryAccess p_267165_) {
        return result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int p_43999_, int p_44000_) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess p_267052_) {
        return result;
    }

    public Ingredient getInput() {
        return this.input;
    }
    public int getCookTime() {
        return cookTime;
    }

    public int getExperience() {
        return xp;
    }

    @Override public ResourceLocation getId() { return id; }
    @Override public RecipeSerializer<?> getSerializer() { return ArproddelightModRecipes.TONIR_SERIALIZER.get(); }
    @Override public RecipeType<?> getType() { return ArproddelightModRecipes.TONIR_TYPE.get(); }

    public ItemStack getResult() {
        return result;
    }
}
