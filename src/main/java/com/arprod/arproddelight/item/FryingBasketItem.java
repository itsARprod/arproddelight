
package com.arprod.arproddelight.item;

import com.arprod.arproddelight.init.ArproddelightModBlocks;
import com.simibubi.create.foundation.item.ItemDescription;
import net.createmod.catnip.lang.FontHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.Palette;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import java.util.List;

public class FryingBasketItem extends BlockItem {
    public FryingBasketItem() {
        super(ArproddelightModBlocks.FRYING_BASKET.get(), new Properties());
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);

        if (level == null) return; // ensures client context

        ItemDescription description = ItemDescription.create(this, FontHelper.Palette.STANDARD_CREATE);

        if (description != null) {
            tooltip.addAll(description.getCurrentLines());
        }
    }
}
