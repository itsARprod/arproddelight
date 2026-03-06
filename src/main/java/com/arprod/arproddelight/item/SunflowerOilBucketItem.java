package com.arprod.arproddelight.item;

import com.arprod.arproddelight.init.ArproddelightModFluids;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;

public class SunflowerOilBucketItem extends BucketItem {
    public SunflowerOilBucketItem() {
        super(ArproddelightModFluids.SUNFLOWER_OIL, new Item.Properties().stacksTo(1));
    }
}
