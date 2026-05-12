package com.arprod.arproddelight.item.template;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class SpecialContainerConsumableItem extends ConsumableItem {
	protected Item containerItem;

	public SpecialContainerConsumableItem(Properties properties, Item containerItem) {
		super(properties);
		this.containerItem = containerItem;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity consumer) {
		if (!level.isClientSide) {
			this.affectConsumer(stack, level, consumer);
		}

		ItemStack containerStack = new ItemStack(containerItem);
		if (stack.isEdible()) {
			super.finishUsingItem(stack, level, consumer);
		} else {
			Player player = consumer instanceof Player ? (Player)consumer : null;
			if (player instanceof ServerPlayer) {
				CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, stack);
			}

			if (player != null) {
				player.awardStat(Stats.ITEM_USED.get(this));
				if (!player.getAbilities().instabuild) {
					stack.shrink(1);
				}
			}
		}

		if (stack.isEmpty()) {
			return containerStack;
		} else {
			if (consumer instanceof Player player) {
                if (!player.getAbilities().instabuild && !player.getInventory().add(containerStack)) {
					player.drop(containerStack, false);
				}
			}

			return stack;
		}
	}
}