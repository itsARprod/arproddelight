
package com.arprod.arproddelight.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class DoubleHamburgerItem extends ConsumableItem {
	public DoubleHamburgerItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(20).saturationMod(0.8f).build()));
	}
}
