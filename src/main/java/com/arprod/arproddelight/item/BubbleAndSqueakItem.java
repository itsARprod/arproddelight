
package com.arprod.arproddelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class BubbleAndSqueakItem extends ConsumableItem {
	public BubbleAndSqueakItem() {
        super(new Properties().stacksTo(16).craftRemainder(Items.BOWL)
                .food(new FoodProperties.Builder()
                        .nutrition(10)
                        .saturationMod(0.6f)
                        .effect(()-> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 1200, 0 ), 1)
                        .build()
                ));
	}
}
