package com.arprod.arproddelight.block.grower;

import javax.annotation.Nullable;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class CinnamonTreeGrower extends AbstractTreeGrower {
    public static final ResourceKey<ConfiguredFeature<?,?>> CINNAMON_TREE =
            ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath("arproddelight", "cinnamon_tree"));

    @Nullable
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_222924_, boolean p_222925_) {
        return CINNAMON_TREE;
    }

}