package com.arprod.arproddelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class StrawberryCheesecakeSlice extends ConsumableItem {
    public StrawberryCheesecakeSlice() {
        super(new Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3F).fast().effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600, 0, false, false), 1.0F).build()));
    }
}
