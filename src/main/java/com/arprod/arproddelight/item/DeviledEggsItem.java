
package com.arprod.arproddelight.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class DeviledEggsItem extends ConsumableItem {
	public DeviledEggsItem() {
        super(new Properties()
                .craftRemainder(Items.BOWL)
                .food(new FoodProperties.Builder()
                        .nutrition(8)
                        .saturationMod(0.6f)
                        .build()
                )
        );
	}
}
