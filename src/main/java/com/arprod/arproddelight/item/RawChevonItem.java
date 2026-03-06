
package com.arprod.arproddelight.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class RawChevonItem extends ConsumableItem {
	public RawChevonItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(2).saturationMod(1.2f).meat().build()));
	}
}
