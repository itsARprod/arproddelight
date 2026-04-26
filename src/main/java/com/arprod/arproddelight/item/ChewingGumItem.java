
package com.arprod.arproddelight.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class ChewingGumItem extends ConsumableItem {
	public ChewingGumItem() {
		super(new Item.Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(1).saturationMod(5f).alwaysEat().build()));
	}
}
