package com.arprod.arproddelight.item;

import com.arprod.arproddelight.item.template.IceCreamItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class IceCreamHoneyItem extends IceCreamItem {
    public IceCreamHoneyItem() {
        super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(8).saturationMod(0.3f).alwaysEat()
                        .effect(() -> new MobEffectInstance(
                                MobEffects.ABSORPTION,
                                1200,
                                0
                        ), 1.0f).build()),
                Component.translatable("fluid.create.honey"),
                ChatFormatting.GOLD);
    }

}
