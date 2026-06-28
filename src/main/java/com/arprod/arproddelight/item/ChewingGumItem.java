package com.arprod.arproddelight.item;

import com.arprod.arproddelight.registry.ArproddelightModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class ChewingGumItem extends ConsumableItem {
    public ChewingGumItem() {
        super(new Item.Properties().stacksTo(16)
                .food((new FoodProperties.Builder())
                        .nutrition(1)
                        .alwaysEat()
                        .effect(() -> new MobEffectInstance(ArproddelightModMobEffects.REFRESHING.get(), 3600, 0), 1)
                        .build()));
    }
}
