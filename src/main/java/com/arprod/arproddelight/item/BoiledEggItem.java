
package com.arprod.arproddelight.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class BoiledEggItem extends ConsumableItem {
	public BoiledEggItem() {
		super(new Properties().stacksTo(16).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.5f).build()));
	}
}
