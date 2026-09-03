
package com.arprod.arproddelight.item;

import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class DonutItem extends ConsumableItem {
	public DonutItem() {
		super(new Properties().food((new FoodProperties.Builder()).nutrition(6).saturationMod(1f).build()));
	}
}
