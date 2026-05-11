
package com.arprod.arproddelight.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class PotatoSaladItem extends ConsumableItem {
	public PotatoSaladItem() {
        super(new Properties().stacksTo(16).craftRemainder(Items.BOWL)
                .food(new FoodProperties.Builder()
                        .nutrition(6)
                        .saturationMod(0.3f)
                        .build()
                ));
	}
}
