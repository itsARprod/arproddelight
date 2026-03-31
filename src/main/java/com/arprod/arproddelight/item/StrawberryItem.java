package com.arprod.arproddelight.item;

import com.arprod.arproddelight.init.ArproddelightModBlocks;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class StrawberryItem extends BlockItem {
    public StrawberryItem() {
        super(ArproddelightModBlocks.STRAWBERRY.get(), new Properties()
                .food(new FoodProperties.Builder()
                        .nutrition(2)
                        .saturationMod(0.3f)
                        .build()));
    }
}
