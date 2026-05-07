
package com.arprod.arproddelight.item;

import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class BoiledPotatoItem extends ConsumableItem{
	public BoiledPotatoItem() {
		super(new Properties().food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.6f).build()));
	}
}
