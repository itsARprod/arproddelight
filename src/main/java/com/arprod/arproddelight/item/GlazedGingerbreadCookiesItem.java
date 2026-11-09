
package com.arprod.arproddelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class GlazedGingerbreadCookiesItem extends ConsumableItem {
	public GlazedGingerbreadCookiesItem() {
		super(new Properties().food((new FoodProperties.Builder()).nutrition(7).saturationMod(0.4f).effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 300, 0), 1.0f).build()));
	}
}
