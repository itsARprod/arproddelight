
package com.arprod.arproddelight.item;

import com.arprod.arproddelight.registry.ArproddelightModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class BirdsMilkItem extends ConsumableItem {
	public BirdsMilkItem() {
		super(new Properties().food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.3f).effect(() -> new MobEffectInstance(ArproddelightModMobEffects.REFRESHING.get(), 300, 0), 1.0f).build()));
	}
}
