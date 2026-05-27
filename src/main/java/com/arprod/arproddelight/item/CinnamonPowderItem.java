package com.arprod.arproddelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class CinnamonPowderItem extends ConsumableItem {
    public CinnamonPowderItem() {
        super(new Properties().food((new FoodProperties.Builder()).nutrition(1)
                .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 1), 1)
                .effect(() -> new MobEffectInstance(MobEffects.WITHER, 200, 0), 1)
                .build()), false);
    }

}
