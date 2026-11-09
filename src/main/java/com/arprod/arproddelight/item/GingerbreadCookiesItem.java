
package com.arprod.arproddelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class GingerbreadCookiesItem extends ConsumableItem {
	public GingerbreadCookiesItem() {
		super(new Properties().food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.3f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 300, 0), 1.0f).build()));
	}
}
