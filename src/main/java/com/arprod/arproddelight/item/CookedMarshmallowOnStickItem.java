
package com.arprod.arproddelight.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class CookedMarshmallowOnStickItem extends ConsumableItem {
    public CookedMarshmallowOnStickItem() {
        super(new Item.Properties().craftRemainder(Items.STICK).food((new FoodProperties.Builder()).nutrition(1).saturationMod(0.3f)
                .build()));
    }
}
