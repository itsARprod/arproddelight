
package com.arprod.arproddelight.item;

import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class CookedChevonItem extends ConsumableItem {
	public CookedChevonItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(6).saturationMod(1).meat().build()));
	}
}
