package com.arprod.arproddelight.compat.jei.category;

import com.arprod.arproddelight.ArproddelightMod;
import com.arprod.arproddelight.compat.jei.category.animations.AnimatedTonir;
import com.arprod.arproddelight.init.ArproddelightModBlocks;
import com.arprod.arproddelight.recipe.TonirCookingRecipe;
import com.simibubi.create.compat.jei.category.CreateRecipeCategory;
import com.simibubi.create.foundation.gui.AllGuiTextures;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.gui.drawable.IDrawable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import java.util.Locale;

public class TonirCookingCategory implements IRecipeCategory<TonirCookingRecipe> {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(ArproddelightMod.MODID, "tonir_cooking");
    public static final RecipeType<TonirCookingRecipe> RECIPE_TYPE = new RecipeType<>(UID, TonirCookingRecipe.class);

    private static final int WIDTH = 116;
    private static final int HEIGHT = 76;

    private final AnimatedTonir tonir = new AnimatedTonir();
    private final IDrawable background;
    private final IDrawable icon;
    private final Component title;
    public TonirCookingCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.createBlankDrawable(WIDTH, HEIGHT);
        this.icon = guiHelper.createDrawableItemStack(new ItemStack(ArproddelightModBlocks.TONIR.get()));
        this.title = Component.translatable("recipe.arproddelight.tonir_cooking");
    }

    @Override
    public RecipeType<TonirCookingRecipe> getRecipeType() {
        return RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return title;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, TonirCookingRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 10, 2)
                .addIngredients(recipe.getInput())
                .setBackground(CreateRecipeCategory.getRenderedSlot(), -1, -1);

        builder.addSlot(RecipeIngredientRole.OUTPUT, 88, 2)
                .addItemStack(recipe.getResult())
                .setBackground(CreateRecipeCategory.getRenderedSlot(), -1, -1);
    }

    @Override
    public void createRecipeExtras(IRecipeExtrasBuilder builder, TonirCookingRecipe recipe, IFocusGroup focuses) {
        builder.addDrawable(background, 0, 0);
    }

    @Override
    public void draw(TonirCookingRecipe recipe, mezz.jei.api.gui.ingredient.IRecipeSlotsView recipeSlotsView, GuiGraphics graphics, double mouseX, double mouseY) {
        tonir.draw(graphics, getWidth() / 2 - 16, 32);

        var font = Minecraft.getInstance().font;
        int textY = HEIGHT - 9;
        int color = 0xFF7F7F7F;
        AllGuiTextures.JEI_ARROW.render(graphics, getWidth() / 2 - 21, 6);
        Component timeText = Component.literal(formatCookTime(recipe.getCookTime()));
        graphics.drawString(font, timeText, 2, textY, color, false);

        if (recipe.getExperience() > 0) {
            Component expText = Component.translatable("jei.arproddelight.tonir.experience", formatExperience(recipe.getExperience()));
            int expWidth = font.width(expText);
            graphics.drawString(font, expText, WIDTH - 2 - expWidth, textY, color, false);
        }
    }

    private static String formatExperience(int experience) {
        return Integer.toString(experience);
    }

    private static String formatCookTime(int cookTime) {
        if (cookTime <= 0) {
            return "0s";
        }
        double seconds = cookTime / 20.0;
        if (seconds == Math.floor(seconds)) {
            return (int) seconds + "s";
        }
        return String.format(Locale.ROOT, "%.1fs", seconds);
    }
}
