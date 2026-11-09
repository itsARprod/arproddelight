
package com.arprod.arproddelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import vectorwing.farmersdelight.common.item.DrinkableItem;

public class BerryTeaItem extends DrinkableItem {
	public BerryTeaItem() {
		super(new Properties().stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).food((new FoodProperties.Builder()).alwaysEat()
                .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1800, 0), 1.0f)
                .build()),true);
	}
}
