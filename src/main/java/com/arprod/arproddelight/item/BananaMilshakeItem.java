
package com.arprod.arproddelight.item;

import com.arprod.arproddelight.registry.ArproddelightModMobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;
import vectorwing.farmersdelight.common.item.DrinkableItem;

public class BananaMilshakeItem extends DrinkableItem {
	public BananaMilshakeItem() {
		super(new Properties().stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.5f)
                .effect(() -> new MobEffectInstance(ArproddelightModMobEffects.REFRESHING.get(), 600, 0), 1.0f)
                .build()));
	}
}
