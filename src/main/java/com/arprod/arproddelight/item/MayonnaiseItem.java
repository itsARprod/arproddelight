
package com.arprod.arproddelight.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import vectorwing.farmersdelight.common.item.DrinkableItem;

public class MayonnaiseItem extends DrinkableItem {
	public MayonnaiseItem() {
		super(new Properties().craftRemainder(Items.BOWL).food((new FoodProperties.Builder()).alwaysEat()
                .build()));
	}

	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.DRINK;
	}

	public SoundEvent getDrinkingSound() {
		return SoundEvents.HONEY_DRINK;
	}
}
