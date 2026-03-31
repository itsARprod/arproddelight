
package com.arprod.arproddelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class SunflowerOilBottleItem extends DrinkableItem {
	public SunflowerOilBottleItem() {
		super(new Properties().stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).food((new FoodProperties.Builder())
                .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 60, 4), 1.0f)
                .build()));
	}
}
