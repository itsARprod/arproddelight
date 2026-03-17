
package com.arprod.arproddelight.item;

import com.arprod.arproddelight.init.ArproddelightModBlocks;
import com.simibubi.create.foundation.item.ItemDescription;
import net.createmod.catnip.lang.FontHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class GelatinBlockItem extends BlockItem {
    public GelatinBlockItem() {
        super(ArproddelightModBlocks.GELATIN_BLOCK.get(), new Properties());
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);

        if (level == null) return;

        ItemDescription description = ItemDescription.create(this, FontHelper.Palette.STANDARD_CREATE);

        if (description != null) {
            tooltip.addAll(description.getCurrentLines());
        }
    }
}
