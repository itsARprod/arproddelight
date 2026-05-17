
package com.arprod.arproddelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class MoldItem extends Item {
	public MoldItem() {
		super(new Properties().food((new FoodProperties.Builder()).nutrition(1).saturationMod(0f).effect(() ->new MobEffectInstance(MobEffects.POISON,0,10),1).build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 10;
	}
}
