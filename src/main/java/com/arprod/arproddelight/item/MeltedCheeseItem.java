
package com.arprod.arproddelight.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import com.arprod.arproddelight.init.ArproddelightModFluids;

public class MeltedCheeseItem extends BucketItem {
	public MeltedCheeseItem() {
		super(ArproddelightModFluids.MELTED_CHEESE, new Item.Properties().stacksTo(1));
	}
}
