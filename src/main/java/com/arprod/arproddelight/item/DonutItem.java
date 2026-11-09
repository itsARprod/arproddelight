
package com.arprod.arproddelight.item;

import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class DonutItem extends ConsumableItem {
	public DonutItem() {
		super(new Properties().food((new FoodProperties.Builder()).nutrition(7).saturationMod(1.2f).build()));
	}
}
