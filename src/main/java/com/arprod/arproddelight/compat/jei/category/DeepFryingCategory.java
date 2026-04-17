package com.arprod.arproddelight.compat.jei.category;

import com.arprod.arproddelight.compat.jei.category.animations.AnimatedFryingBasket;
import com.arprod.arproddelight.recipe.DeepFryingRecipe;
import com.simibubi.create.compat.jei.category.BasinCategory;
import com.simibubi.create.compat.jei.category.CreateRecipeCategory;
import com.simibubi.create.compat.jei.category.animations.AnimatedBlazeBurner;
import com.simibubi.create.content.processing.basin.BasinRecipe;
import com.simibubi.create.content.processing.recipe.HeatCondition;

import com.simibubi.create.foundation.gui.AllGuiTextures;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

public class DeepFryingCategory extends BasinCategory {
    private final AnimatedFryingBasket fryer = new AnimatedFryingBasket();
    private final AnimatedBlazeBurner heater = new AnimatedBlazeBurner();

    public DeepFryingCategory(CreateRecipeCategory.Info<BasinRecipe> info) {
        super(info, true);
    }

    @Override
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull BasinRecipe recipe, @NotNull IFocusGroup focuses) {
        super.setRecipe(builder, recipe, focuses);

        if (!(recipe instanceof DeepFryingRecipe deepFryingRecipe) || !deepFryingRecipe.hasFuel()) {
            return;
        }

        CreateRecipeCategory.addFluidSlot(builder, 70, 8, RecipeIngredientRole.INPUT)
                .addIngredients(mezz.jei.api.forge.ForgeTypes.FLUID_STACK, deepFryingRecipe.getFuel().getMatchingFluidStacks())
                .addRichTooltipCallback((view, tooltip) -> {
                    tooltip.add(Component.translatable("jei.arproddelight.deep_frying.fuel_required", deepFryingRecipe.getFuel().getRequiredAmount())
                            .withStyle(ChatFormatting.BLUE));
                    tooltip.add(Component.translatable("jei.arproddelight.deep_frying.fuel_consumed", deepFryingRecipe.getFuelAmountToConsume())
                            .withStyle(ChatFormatting.AQUA));
                });
    }

    @Override
    public void draw(@NotNull BasinRecipe recipe, @NotNull IRecipeSlotsView recipeSlotsView, @NotNull GuiGraphics graphics, double mouseX, double mouseY) {
        super.draw(recipe, recipeSlotsView, graphics, mouseX, mouseY);

        AllGuiTextures.JEI_DOWN_ARROW.render(graphics, 94, 12);
        HeatCondition requiredHeat = recipe.getRequiredHeat();
        if (requiredHeat != HeatCondition.NONE) {
            heater.withHeat(requiredHeat.visualizeAsBlazeBurner())
                    .draw(graphics, getBackground().getWidth() / 2 + 3, 55);
        }
        fryer.draw(graphics, getBackground().getWidth() / 2 + 3, 34);
    }
}
