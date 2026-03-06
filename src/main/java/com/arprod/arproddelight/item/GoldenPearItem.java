
package com.arprod.arproddelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class GoldenPearItem extends ConsumableItem {
	public GoldenPearItem() {
		super(new Properties().food((new FoodProperties.Builder()).nutrition(8).saturationMod(1f).alwaysEat()
                .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 1), 1.0f)
                .effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 600, 0), 1.0f)
                .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 1), 1.0f)
                .build()));
	}
}
