
package com.arprod.arproddelight.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class BatteredCodItem extends ConsumableItem {
    public BatteredCodItem() {
        super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(5).fast().saturationMod(0.6f).build()));
    }


}
