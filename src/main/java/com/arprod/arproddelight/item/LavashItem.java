
package com.arprod.arproddelight.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class LavashItem extends ConsumableItem {
	public LavashItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(1).saturationMod(0.3f).build()));
	}


	@Override
    public int getUseDuration(ItemStack itemstack) {
		return 16;
	}
}
