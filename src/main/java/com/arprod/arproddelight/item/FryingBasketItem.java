
package com.arprod.arproddelight.item;

import com.arprod.arproddelight.item.template.ItemTooltipHelper;
import com.arprod.arproddelight.registry.ArproddelightModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class FryingBasketItem extends BlockItem{
    public FryingBasketItem() {
        super(ArproddelightModBlocks.FRYING_BASKET.get(), new Properties());
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        ItemTooltipHelper.addCreateDescription(this, tooltip);
    }
}
