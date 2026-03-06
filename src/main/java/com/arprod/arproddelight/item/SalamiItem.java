
package com.arprod.arproddelight.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class SalamiItem extends Item {
	public SalamiItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.3f).meat().build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 40;
	}
}
