
package com.arprod.arproddelight.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.Component;

import com.arprod.arproddelight.procedures.FriedDragonEggPlayerFinishesUsingItemProcedure;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import java.util.List;

public class FriedDragonEggItem extends ConsumableItem {
	public FriedDragonEggItem() {
		super(new Properties().fireResistant().rarity(Rarity.EPIC).food((new FoodProperties.Builder()).nutrition(20).saturationMod(50f).alwaysEat().build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		FriedDragonEggPlayerFinishesUsingItemProcedure.execute(world, x, y, z, entity);
		return retval;
	}
}
