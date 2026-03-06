
package com.arprod.arproddelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class PepperItem extends ConsumableItem {
	public PepperItem() {
		super(new Properties().food((new FoodProperties.Builder()).nutrition(8).saturationMod(1f)
                .effect(() -> new MobEffectInstance(MobEffects.HARM, 1, 0), 1.0f)
                .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, 0), 1.0f)
                .build()));
	}

}
