
package com.arprod.arproddelight.item;

import com.arprod.arproddelight.item.template.SpecialContainerConsumableItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

import com.arprod.arproddelight.registry.ArproddelightModItems;

public class CoffeeBerryItem extends SpecialContainerConsumableItem {
	public CoffeeBerryItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(1).saturationMod(0.3f).build()),
				ArproddelightModItems.COFFEE_BEAN.get());
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 8;
	}
}
