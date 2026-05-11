
package com.arprod.arproddelight.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BowlFoodItem;

public class DeviledEggsItem extends BowlFoodItem {
	public DeviledEggsItem() {
        super(new Properties()
                .food(new FoodProperties.Builder()
                        .nutrition(8)
                        .saturationMod(0.6f)
                        .build()
                )
        );
	}
}
