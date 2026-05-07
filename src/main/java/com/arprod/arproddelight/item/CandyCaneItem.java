
package com.arprod.arproddelight.item;

import com.simibubi.create.foundation.item.ItemDescription;
import net.createmod.catnip.lang.FontHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;

import com.arprod.arproddelight.registry.ArproddelightModItems;

import java.util.List;
import java.util.Objects;

public class CandyCaneItem extends Item {
	public CandyCaneItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.3f).build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = new ItemStack(ArproddelightModItems.CANDY_SPEAR.get());

		if (!entity.isShiftKeyDown()){
			super.finishUsingItem(itemstack, world, entity);
			return itemstack;
		}

		if (itemstack.isEmpty()) {
			return retval;
		} else {
			itemstack.shrink(1);
			if (entity instanceof Player player && !player.getAbilities().instabuild) {
				if (!player.getInventory().add(retval)) {
					player.drop(retval, false);
				}
			}
			return itemstack;
		}
	}

	@Override
	public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
		super.appendHoverText(stack, level, tooltip, flag);
		tooltip.addAll(Objects.requireNonNull(ItemDescription.create(this, FontHelper.Palette.STANDARD_CREATE)).getCurrentLines());
	}
}
