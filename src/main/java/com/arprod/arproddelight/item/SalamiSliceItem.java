
package com.arprod.arproddelight.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.registry.ModEffects;

import java.util.List;
import java.util.Objects;

public class SalamiSliceItem extends ConsumableItem {
	public SalamiSliceItem() {
		super(new Properties()
                .stacksTo(64)
                .rarity(Rarity.COMMON)
                .food((new FoodProperties.Builder())
                        .nutrition(8)
                        .saturationMod(0.6f)
                        .effect(() -> new MobEffectInstance(
								ModEffects.NOURISHMENT.get(),
                            1200, // duration in ticks
                            0    // amplifier
                        ), 1.0f)
                .build()),true);
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 24;
	}
}
