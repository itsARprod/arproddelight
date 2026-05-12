
package com.arprod.arproddelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class BurntMarshmallowOnStickItem extends ConsumableItem {
	public BurntMarshmallowOnStickItem() {
		super(new Item.Properties().craftRemainder(Items.STICK).food((new FoodProperties.Builder()).nutrition(1).saturationMod(0.3f)
                .effect(()-> new MobEffectInstance(MobEffects.HUNGER, 600, 0),1.0f)
                .build()));
	}
}
