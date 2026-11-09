
package com.arprod.arproddelight.item;

import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class GlazedDonutItem extends ConsumableItem {
	public GlazedDonutItem() {
		super(new Properties().food((new FoodProperties.Builder()).nutrition(9).saturationMod(1.2f).build()));
	}
}
