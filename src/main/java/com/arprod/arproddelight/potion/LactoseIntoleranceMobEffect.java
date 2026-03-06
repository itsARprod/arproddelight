package com.arprod.arproddelight.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class LactoseIntoleranceMobEffect extends MobEffect {

    public LactoseIntoleranceMobEffect() {
        super(MobEffectCategory.HARMFUL, -1052673);
    }

    // Prevent milk and ALL cure items from working
    @Override
    public List<ItemStack> getCurativeItems() {
        return List.of();
    }
}