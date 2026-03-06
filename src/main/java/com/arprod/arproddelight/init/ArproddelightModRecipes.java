package com.arprod.arproddelight.init;

import com.arprod.arproddelight.ArproddelightMod;
import com.arprod.arproddelight.recipe.DeepFryingRecipe;
import com.arprod.arproddelight.recipe.TonirCookingRecipe;
import com.arprod.arproddelight.recipe.TonirCookingRecipeSerializer;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeSerializer;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import java.util.Objects;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ArproddelightModRecipes {
    private static ResourceLocation id(String path) {
        return Objects.requireNonNull(ResourceLocation.tryParse(ArproddelightMod.MODID + ":" + path));
    }

    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ArproddelightMod.MODID);

    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, ArproddelightMod.MODID);

    // ---- TYPE ----
    public static final RegistryObject<RecipeType<TonirCookingRecipe>> TONIR_TYPE =
            TYPES.register("tonir_cooking", () -> new RecipeType<>() {
                @Override
                public String toString() {
                    return id("tonir_cooking").toString();
                }
            });

    // ---- SERIALIZER ----
    public static final RegistryObject<RecipeSerializer<TonirCookingRecipe>> TONIR_SERIALIZER =
            SERIALIZERS.register("tonir_cooking", TonirCookingRecipeSerializer::new);

    public static final RegistryObject<RecipeType<DeepFryingRecipe>> DEEP_FRYING_TYPE =
            TYPES.register("deep_frying", () -> RecipeType.simple(id("deep_frying")));

    public static final RegistryObject<RecipeSerializer<DeepFryingRecipe>> DEEP_FRYING_SERIALIZER =
            SERIALIZERS.register("deep_frying", () -> new ProcessingRecipeSerializer<>(DeepFryingRecipe::new));

    public static final IRecipeTypeInfo DEEP_FRYING_RECIPE_INFO = new IRecipeTypeInfo() {
        private final ResourceLocation id = id("deep_frying");

        @Override
        public ResourceLocation getId() {
            return id;
        }

        @Override
        @SuppressWarnings("unchecked")
        public <T extends RecipeSerializer<?>> T getSerializer() {
            return (T) DEEP_FRYING_SERIALIZER.get();
        }

        @Override
        @SuppressWarnings("unchecked")
        public <T extends RecipeType<?>> T getType() {
            return (T) DEEP_FRYING_TYPE.get();
        }
    };

    public static void register(net.minecraftforge.eventbus.api.IEventBus bus) {
        SERIALIZERS.register(bus);
        TYPES.register(bus);
    }
}
