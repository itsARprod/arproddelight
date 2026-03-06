package com.arprod.arproddelight.item;

import com.arprod.arproddelight.init.ArproddelightModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class BananaCrateItem extends BlockItem {
    public BananaCrateItem(Block block) {
        super(block, new Item.Properties().craftRemainder(ArproddelightModItems.BANANA_PEEL.get()));
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack stack) {
        ItemStack remainder = stack.copy();
        remainder.setCount(9);
        return remainder;
    }
}
