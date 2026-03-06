
package com.arprod.arproddelight.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class MoldItem extends Item {
	public MoldItem() {
		super(new Properties().food((new FoodProperties.Builder()).nutrition(1).saturationMod(0f).build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 10;
	}
}
