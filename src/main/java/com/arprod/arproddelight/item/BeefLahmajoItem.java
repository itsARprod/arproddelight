
package com.arprod.arproddelight.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class BeefLahmajoItem extends ConsumableItem {
	public BeefLahmajoItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.3f).meat().build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 24;
	}
}
