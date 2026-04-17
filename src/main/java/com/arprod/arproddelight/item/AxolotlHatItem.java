
package com.arprod.arproddelight.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import net.minecraft.world.entity.EquipmentSlot;

public class AxolotlHatItem extends Item implements Equipable{
	public AxolotlHatItem() {
		super(new Properties());
	}

	@Override
	public EquipmentSlot getEquipmentSlot() {
		return EquipmentSlot.HEAD;
	}

	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
		return swapWithEquipmentSlot(this, worldIn, playerIn, handIn);
	}
}
