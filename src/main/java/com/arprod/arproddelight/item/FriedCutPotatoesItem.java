
package com.arprod.arproddelight.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class FriedCutPotatoesItem extends ConsumableItem {
	public FriedCutPotatoesItem() {
		super(new Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(1f).build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 10;
	}
}
