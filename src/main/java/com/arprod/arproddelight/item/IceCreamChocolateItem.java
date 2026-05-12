
package com.arprod.arproddelight.item;

import com.arprod.arproddelight.item.template.IceCreamItem;
import net.minecraft.ChatFormatting;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.network.chat.Component;

public class IceCreamChocolateItem extends IceCreamItem {
	public IceCreamChocolateItem() {
        super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(8).saturationMod(0.3f).alwaysEat()
                .effect(() -> new MobEffectInstance(
                        MobEffects.MOVEMENT_SPEED,
                        600,
                        0
                ), 1.0f).build()),Component.translatable("fluid.create.chocolate"), ChatFormatting.DARK_PURPLE);
    }
}
