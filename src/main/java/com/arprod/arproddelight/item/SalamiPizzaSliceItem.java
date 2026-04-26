
package com.arprod.arproddelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class SalamiPizzaSliceItem extends ConsumableItem {
	public SalamiPizzaSliceItem() {
		super(new Properties()
                .stacksTo(64)
                .rarity(Rarity.COMMON)
                .food((new FoodProperties.Builder())
                        .nutrition(8)
                        .saturationMod(0.6f)
                        .effect(() -> new MobEffectInstance(
								ModEffects.NOURISHMENT.get(),
                            1200, // duration in ticks
                            0    // amplifier
                        ), 1.0f)
                .build()),true);
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 24;
	}
}
