
package com.arprod.arproddelight.item;

import net.minecraft.ChatFormatting;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.network.chat.Component;

import vectorwing.farmersdelight.common.item.ConsumableItem;

import java.util.List;

public class IceCreamItem extends ConsumableItem {
	public IceCreamItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(6).saturationMod(0.3f).alwaysEat().build()));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.translatable("fluid_type.minecraft.milk").withStyle(ChatFormatting.GRAY));
	}

	@Override
	public Component getName(ItemStack p_41458_) {
		return Component.translatable("item.arproddelight.ice_cream");
	}
}
