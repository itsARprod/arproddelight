
package com.arprod.arproddelight.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class MarshmallowOnStickItem extends ConsumableItem {
	public MarshmallowOnStickItem() {
		super(new Item.Properties().craftRemainder(Items.STICK).stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.3f).build()));
	}

//	@Override
//	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
//		ItemStack retval = new ItemStack(Items.STICK);
//		super.finishUsingItem(itemstack, world, entity);
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
