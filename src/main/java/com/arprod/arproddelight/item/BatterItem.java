
package com.arprod.arproddelight.item;

import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class BatterItem extends ConsumableItem {
	public BatterItem() {
		super(new Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(1.0F).build()));
	}
}
