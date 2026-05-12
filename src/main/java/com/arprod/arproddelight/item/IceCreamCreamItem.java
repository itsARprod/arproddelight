
package com.arprod.arproddelight.item;

import com.arprod.arproddelight.item.template.IceCreamItem;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.network.chat.Component;

public class IceCreamCreamItem extends IceCreamItem {
	public IceCreamCreamItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.3f).alwaysEat().build()),
				Component.translatable("fluid_type.minecraft.milk"),
				ChatFormatting.GRAY);
	}
}
