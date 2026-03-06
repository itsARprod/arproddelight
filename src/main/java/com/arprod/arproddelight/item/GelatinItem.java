
package com.arprod.arproddelight.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class GelatinItem extends ConsumableItem {
	public GelatinItem() {
		super(new Properties().food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.3f).build()));
	}
}
