
package com.arprod.arproddelight.item;

import com.arprod.arproddelight.init.ArproddelightModItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;

import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class BananaItem extends ConsumableItem {
	public BananaItem() {
		super(new Properties().food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.3f).build()));
	}

	public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, Level level, @NotNull LivingEntity consumer) {
        if (!level.isClientSide) {
            this.affectConsumer(stack, level, consumer);
        }

        ItemStack containerStack = new ItemStack(ArproddelightModItems.BANANA_PEEL.get());
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
