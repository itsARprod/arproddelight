
package com.arprod.arproddelight.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class DeviledEggsItem extends BowlFoodItem {
	public DeviledEggsItem() {
        super(new Properties()
                .food(new FoodProperties.Builder()
                        .nutrition(8)
                        .saturationMod(1f)
                        .build()
                )
        );
	}
}
