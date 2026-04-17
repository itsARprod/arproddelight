
package com.arprod.arproddelight.item;

import net.minecraft.ChatFormatting;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.network.chat.Component;

import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.registry.ModEffects;

import java.util.List;

public class IceCreamHoneyItem extends ConsumableItem {
	public IceCreamHoneyItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(8).saturationMod(0.3f).alwaysEat()
                .effect(() -> new MobEffectInstance(
                        ModEffects.COMFORT.get(),
                1800, // duration in ticks
                0    // amplifier
        ), 1.0f).build()),true);
	}

    @Override
    public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, level, list, flag);
        list.add(Component.translatable("fluid.create.honey").withStyle(ChatFormatting.GOLD));

    }

    @Override
    public Component getName(ItemStack p_41458_) {
        return Component.translatable("item.arproddelight.ice_cream");
    }

}
