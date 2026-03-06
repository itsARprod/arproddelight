
package com.arprod.arproddelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.*;
import net.minecraft.world.food.FoodProperties;

import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class UzbekRiceItem extends ConsumableItem {
	public UzbekRiceItem() {
        super(new Item.Properties().stacksTo(16).craftRemainder(Items.BOWL)
                .food(new FoodProperties.Builder()
                        .nutrition(8)
                        .saturationMod(0.3f)
                        .effect(()-> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 1800, 0 ), 1)
                        .build()
                )
        ,true );
	}
}
