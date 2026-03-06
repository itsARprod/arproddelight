
package com.arprod.arproddelight.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class PearItem extends ConsumableItem {
	public PearItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.5f).build()));
	}
}
