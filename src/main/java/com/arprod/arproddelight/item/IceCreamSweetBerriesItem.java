
package com.arprod.arproddelight.item;

import com.arprod.arproddelight.item.template.IceCreamItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class IceCreamSweetBerriesItem extends IceCreamItem {
    public IceCreamSweetBerriesItem() {
        super(new Properties().food((new FoodProperties.Builder()).nutrition(8).saturationMod(0.3f).alwaysEat()
                .effect(() -> new MobEffectInstance(
                        MobEffects.REGENERATION,
                        600,
                        0
                ), 1.0f).build()),Component.translatable("item.minecraft.sweet_berries"), ChatFormatting.LIGHT_PURPLE);
    }
}
