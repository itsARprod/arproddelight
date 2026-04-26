
package com.arprod.arproddelight.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class MargheritaPizzaSliceItem extends ConsumableItem {
	public MargheritaPizzaSliceItem() {
		super(new Properties().food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.6f).build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 24;
	}
}
