
package com.arprod.arproddelight.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class KhinkaliItem extends ConsumableItem {
	public KhinkaliItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.3f).build()));
	}
}
