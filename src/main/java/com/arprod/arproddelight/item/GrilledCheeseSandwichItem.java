
package com.arprod.arproddelight.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class GrilledCheeseSandwichItem extends ConsumableItem {
	public GrilledCheeseSandwichItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(7).build()));
	}
}
