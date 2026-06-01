package com.arprod.arproddelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class MacNCheeseItem extends ConsumableItem {
    public MacNCheeseItem() {
        super(new Item.Properties()
                .craftRemainder(Items.BOWL)
                .food((new FoodProperties.Builder())
                        .nutrition(10)
                        .saturationMod(0.8f)
                        .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1)
                        .build()));
    }
}