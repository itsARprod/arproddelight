
package com.arprod.arproddelight.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class StrawberryJellyItem extends ConsumableItem {
	public StrawberryJellyItem() {
		super(new Properties().food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.8f).build()));
	}
}
