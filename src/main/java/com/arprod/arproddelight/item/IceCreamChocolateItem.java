
package com.arprod.arproddelight.item;

import net.minecraft.ChatFormatting;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.network.chat.Component;

import vectorwing.farmersdelight.common.item.ConsumableItem;

import java.util.List;

public class IceCreamChocolateItem extends ConsumableItem {
	public IceCreamChocolateItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(8).saturationMod(0.3f).alwaysEat().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED,600,1),1).build()),true);
	}

    @Override
    public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, level, list, flag);
        list.add(Component.translatable("fluid.create.chocolate").withStyle(ChatFormatting.DARK_PURPLE));
    }

    @Override
    public Component getName(ItemStack p_41458_) {
        return Component.translatable("item.arproddelight.ice_cream");
    }
}
