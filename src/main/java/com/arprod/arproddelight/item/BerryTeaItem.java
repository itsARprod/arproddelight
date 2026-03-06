
package com.arprod.arproddelight.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import java.util.List;

public class BerryTeaItem extends DrinkableItem {
	public BerryTeaItem() {
		super(new Properties().stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).food((new FoodProperties.Builder()).alwaysEat()
                .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1800, 0), 1.0f)
                .build()),true);
	}

//    @Override
//    public void appendHoverText(ItemStack stack, Level world, @NotNull List<Component> tooltip, TooltipFlag flag) {
//        // Use translation key from en_us.json
//        tooltip.add(Component.translatable("item.arproddelight.berry_tea.tooltip").withStyle(ChatFormatting.BLUE));
//    }
}
