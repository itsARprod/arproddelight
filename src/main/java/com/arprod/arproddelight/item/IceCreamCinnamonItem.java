
package com.arprod.arproddelight.item;

import com.arprod.arproddelight.procedures.Speed2Procedure;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.registry.ModEffects;

import java.util.List;

public class IceCreamCinnamonItem extends ConsumableItem {
	public IceCreamCinnamonItem() {
		super(new Properties().food((new FoodProperties.Builder()).nutrition(8).saturationMod(0.3f).alwaysEat().effect(new MobEffectInstance(ModEffects.NOURISHMENT.get()),1).build()),true);
	}

    @Override
    public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, level, list, flag);
        list.add(Component.translatable("item.arproddelight.cinnamon").withStyle(ChatFormatting.YELLOW));
    }
}
