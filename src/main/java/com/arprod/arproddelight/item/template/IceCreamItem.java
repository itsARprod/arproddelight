package com.arprod.arproddelight.item.template;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import java.util.List;

public class IceCreamItem extends ConsumableItem {
    protected MutableComponent description;
    protected ChatFormatting color;
    public IceCreamItem(Properties properties, MutableComponent description, ChatFormatting color) {
        super(properties);
        this.description = description;
        this.color = color;
    }
    @Override
    public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
        list.add(description.withStyle(color));
        super.appendHoverText(itemstack, level, list, flag);
    }

    @Override
    public Component getName(ItemStack p_41458_) {
        return Component.translatable("item.arproddelight.ice_cream");
    }
}
