
package com.arprod.arproddelight.item;

import com.arprod.arproddelight.item.template.SpecialContainerConsumableItem;
import com.arprod.arproddelight.registry.ArproddelightModItems;
import net.minecraft.world.food.FoodProperties;

public class BananaItem extends SpecialContainerConsumableItem {
	public BananaItem() {
		super(new Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.3f).build()),ArproddelightModItems.BANANA_PEEL.get());
	}
}
