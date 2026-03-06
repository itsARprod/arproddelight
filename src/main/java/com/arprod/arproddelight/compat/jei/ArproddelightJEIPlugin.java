package com.arprod.arproddelight.compat.jei;

import com.arprod.arproddelight.ArproddelightMod;
import com.arprod.arproddelight.compat.jei.category.DeepFryingCategory;
import com.arprod.arproddelight.init.ArproddelightModBlocks;
import com.arprod.arproddelight.init.ArproddelightModRecipes;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.compat.jei.DoubleItemIcon;
import com.simibubi.create.compat.jei.EmptyBackground;
import com.simibubi.create.compat.jei.category.CreateRecipeCategory;
import com.simibubi.create.content.processing.basin.BasinRecipe;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

@JeiPlugin
public class ArproddelightJEIPlugin implements IModPlugin {

    private static ResourceLocation id(String path) {
        return Objects.requireNonNull(ResourceLocation.tryParse(ArproddelightMod.MODID + ":" + path));
    }

    private static final ResourceLocation PLUGIN_ID = id("jei_plugin");

    private final List<CreateRecipeCategory<?>> categories = new ArrayList<>();

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return PLUGIN_ID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        categories.clear();
        categories.add(createDeepFryingCategory());
        registration.addRecipeCategories(categories.toArray(new CreateRecipeCategory[0]));
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registration) {
        categories.forEach(c -> c.registerRecipes(registration));
    }

    @Override
    public void registerRecipeCatalysts(@NotNull IRecipeCatalystRegistration registration) {
        categories.forEach(c -> c.registerCatalysts(registration));
    }

    private DeepFryingCategory createDeepFryingCategory() {
        mezz.jei.api.recipe.RecipeType<BasinRecipe> type = new mezz.jei.api.recipe.RecipeType<>(id("deep_frying"), BasinRecipe.class);
        Component title = Component.translatable("recipe.arproddelight.deep_frying");
        Supplier<List<BasinRecipe>> recipes = () -> {
            if (Minecraft.getInstance().getConnection() == null) {
                return Collections.emptyList();
            }
            return new ArrayList<>(Minecraft.getInstance().getConnection().getRecipeManager()
                    .getAllRecipesFor(ArproddelightModRecipes.DEEP_FRYING_TYPE.get()));
        };
        List<Supplier<? extends ItemStack>> catalysts = List.of(
                () -> new ItemStack(ArproddelightModBlocks.FRYING_BASKET.get()),
                AllBlocks.BASIN::asStack
        );

        CreateRecipeCategory.Info<BasinRecipe> info = new CreateRecipeCategory.Info<>(
                type,
                title,
                new EmptyBackground(177, 103),
                new DoubleItemIcon(() -> new ItemStack(ArproddelightModBlocks.FRYING_BASKET.get()), AllBlocks.BASIN::asStack),
                recipes,
                catalysts
        );
        return new DeepFryingCategory(info);
    }
}
