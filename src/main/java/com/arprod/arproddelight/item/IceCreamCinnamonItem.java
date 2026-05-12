
package com.arprod.arproddelight.item;

import com.arprod.arproddelight.item.template.IceCreamItem;
import net.minecraft.ChatFormatting;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.network.chat.Component;

import vectorwing.farmersdelight.common.registry.ModEffects;

public class IceCreamCinnamonItem extends IceCreamItem {
    public IceCreamCinnamonItem() {
        super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(8).saturationMod(0.3f).alwaysEat()
                .effect(() -> new MobEffectInstance(
                        ModEffects.NOURISHMENT.get(),
                        300,
                        0
                ), 1.0f).build()),Component.translatable("item.arproddelight.cinnamon"), ChatFormatting.YELLOW);
    }
}
