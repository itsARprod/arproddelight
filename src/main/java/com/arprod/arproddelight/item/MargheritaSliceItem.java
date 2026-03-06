
package com.arprod.arproddelight.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class MargheritaSliceItem extends ConsumableItem {
	public MargheritaSliceItem() {
		super(new Properties().food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.6f).build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 24;
	}
}
