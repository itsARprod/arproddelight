
package com.arprod.arproddelight.item;

import com.arprod.arproddelight.init.ArproddelightModItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class BoiledPotatoItem extends ConsumableItem{
	public BoiledPotatoItem() {
		super(new Properties().food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.6f).build()));
	}
}
