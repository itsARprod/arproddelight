
package com.arprod.arproddelight.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class CinnamonRollItem extends ConsumableItem {
    public CinnamonRollItem() {
        super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(8).saturationMod(0.625f).build()));
    }
}
