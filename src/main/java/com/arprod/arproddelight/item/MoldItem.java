
package com.arprod.arproddelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class MoldItem extends ConsumableItem {
	public MoldItem() {
		super(new Properties().food((new FoodProperties.Builder()).nutrition(1).saturationMod(0f).effect(() ->new MobEffectInstance(MobEffects.POISON,200,0),1).build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 10;
	}
}
