
package com.arprod.arproddelight.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import vectorwing.farmersdelight.common.item.DrinkableItem;

public class MayonnaiseJarItem extends DrinkableItem {
	public MayonnaiseJarItem() {
		super(new Properties().stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).food((new FoodProperties.Builder()).alwaysEat()
                .build()));
	}

	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.DRINK;
	}

	public SoundEvent getDrinkingSound() {
		return SoundEvents.HONEY_DRINK;
	}

	public SoundEvent getEatingSound() {
		return SoundEvents.HONEY_DRINK;
	}
}
