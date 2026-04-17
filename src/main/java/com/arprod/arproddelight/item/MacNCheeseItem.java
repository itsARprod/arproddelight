
package com.arprod.arproddelight.item;

import net.minecraft.world.item.*;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class MacNCheeseItem extends ConsumableItem {
	public MacNCheeseItem() {
		super(new Item.Properties().stacksTo(16).craftRemainder(Items.BOWL).food((new FoodProperties.Builder()).nutrition(9).saturationMod(0.3f).build()));
	}
}
