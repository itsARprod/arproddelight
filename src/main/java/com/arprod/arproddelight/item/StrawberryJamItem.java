
package com.arprod.arproddelight.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.registry.ModEffects;

import java.util.List;

public class StrawberryJamItem extends HoneyBottleItem {
    public StrawberryJamItem() {
        super(new Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.3f).effect(() -> new MobEffectInstance(
                        ModEffects.COMFORT.get(),
                1200, // duration in ticks
                1    // amplifier
                ), 1.0f)
                .build()));
    }

    @Override
    public void appendHoverText(ItemStack stack, Level world, @NotNull List<Component> tooltip, TooltipFlag flag) {
        // Use translation key from en_us.json
        tooltip.add(Component.translatable("item.arproddelight.strawberry_jam.tooltip").withStyle(ChatFormatting.BLUE));
    }
}
