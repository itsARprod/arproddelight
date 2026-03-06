package com.arprod.arproddelight.recipe;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonArray;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;

public class TonirCookingRecipeSerializer implements RecipeSerializer<TonirCookingRecipe> {

    @Override
    public TonirCookingRecipe fromJson(ResourceLocation id, JsonObject json) {
        // INGREDIENT
        if (!json.has("ingredient"))
            throw new JsonParseException("Missing ingredient for tonir recipe");

        Ingredient ingredient = Ingredient.fromJson(
                GsonHelper.getAsJsonObject(json, "ingredient")
        );

        // RESULT (supports both "result" and legacy "results": [ ... ])
        ItemStack result;
        if (json.has("result")) {
            result = ShapedRecipe.itemStackFromJson(
                    GsonHelper.getAsJsonObject(json, "result")
            );
        } else if (json.has("results")) {
            JsonArray results = GsonHelper.getAsJsonArray(json, "results");
            if (results.size() == 0) {
                throw new JsonParseException("Empty results array for tonir recipe");
            }
            result = ShapedRecipe.itemStackFromJson(results.get(0).getAsJsonObject());
        } else {
            throw new JsonParseException("Missing result for tonir recipe");
        }

        // OPTIONALS
        int cookTime = GsonHelper.getAsInt(json, "cookTime", 100);
        int xp = GsonHelper.getAsInt(json, "experience", 0);

        return new TonirCookingRecipe(id, ingredient, result, cookTime, xp);
    }

    @Override
    public TonirCookingRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
        Ingredient ingredient = Ingredient.fromNetwork(buf);
        ItemStack result = buf.readItem();
        int cookTime = buf.readInt();
        int xp = buf.readInt();

        return new TonirCookingRecipe(id, ingredient, result, cookTime, xp);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buf, TonirCookingRecipe recipe) {
        recipe.getInput().toNetwork(buf);
        buf.writeItem(recipe.getResult());
        buf.writeInt(recipe.getCookTime());
        buf.writeInt(recipe.getExperience());
    }
}
