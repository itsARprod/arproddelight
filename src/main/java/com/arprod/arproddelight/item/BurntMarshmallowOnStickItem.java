
package com.arprod.arproddelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class BurntMarshmallowOnStickItem extends ConsumableItem {
	public BurntMarshmallowOnStickItem() {
		super(new Item.Properties().craftRemainder(Items.STICK).food((new FoodProperties.Builder()).nutrition(1).saturationMod(0.3f)
                .effect(()-> new MobEffectInstance(MobEffects.HUNGER, 600, 0),1.0f)
                .build()));
	}

//	@Override
//	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
//		ItemStack retval = new ItemStack(Items.STICK);
//		if (itemstack.isEmpty()) {
//			return retval;
//		} else {
//			if (entity instanceof Player player && !player.getAbilities().instabuild) {
//				if (!player.getInventory().add(retval))
//					player.drop(retval, false);
//			}
//			return itemstack;
//		}
//	}
}
