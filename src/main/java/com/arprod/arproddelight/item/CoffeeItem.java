package com.arprod.arproddelight.item;

import com.arprod.arproddelight.init.ArproddelightModItems;
import com.arprod.arproddelight.init.ArproddelightModMobEffects;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import java.util.List;

public class CoffeeItem extends DrinkableItem {
	public int caffeineLimit = 3;
	public int negativeEffectDuration = 6000;
	public int negativeEffectStrength = 4;
	public List<MobEffect> positiveEffects = List.of(MobEffects.MOVEMENT_SPEED, MobEffects.DIG_SPEED);
	public List<Integer> positiveEffectDurations = List.of(1600, 2000);

	public CoffeeItem(int caffeineLimit,
					  int negativeEffectDuration,
					  int negativeEffectStrength,
					  List<MobEffect> positiveEffects,
					  List<Integer> positiveEffectDurations) {
		super(new Item.Properties().stacksTo(16).food((new FoodProperties.Builder()).nutrition(0).saturationMod(0f).alwaysEat().build()).craftRemainder(ArproddelightModItems.CLAY_CUP.get()));
		this.caffeineLimit = caffeineLimit;
		this.negativeEffectDuration = negativeEffectDuration;
		this.negativeEffectStrength = negativeEffectStrength;
		this.positiveEffects = positiveEffects;
		this.positiveEffectDurations = positiveEffectDurations;
	}


	@Override
	public int getUseDuration(@NotNull ItemStack itemstack) {
		return 50;
	}

	@Override
	public @NotNull ItemStack finishUsingItem(@NotNull ItemStack itemstack, @NotNull Level world, @NotNull LivingEntity entity) {
		int caffeine = entity.getPersistentData().getInt("caffeine");
		ItemStack result = super.finishUsingItem(itemstack, world, entity);
		if (caffeine >= caffeineLimit) {
			//NEGATIVE EFFECTS
			entity.removeEffect(MobEffects.MOVEMENT_SPEED);
			entity.removeEffect(MobEffects.DIG_SPEED);
			entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, negativeEffectDuration, negativeEffectStrength, false, true));
			entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, negativeEffectDuration, negativeEffectStrength, false, true));
			entity.addEffect(new MobEffectInstance(ArproddelightModMobEffects.LACTOSE_INTOLERANCE.get(), 6000, 0, false, true));
			//ADVANCEMENT
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("arproddelight:main/coffee"));
                assert _adv != null;
                AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}

		} else {
			//POSITIVE EFFECTS
			for (int i = 0; i < positiveEffects.size(); i++) {
				entity.addEffect(new MobEffectInstance(positiveEffects.get(i), positiveEffectDurations.get(i) - caffeine * 400, caffeine, false, true));
			}

			entity.getPersistentData().putInt("caffeine", (caffeine + 1));

		}

		return result;
	}

	@Override
	public void appendHoverText(@NotNull ItemStack stack, Level world, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
		tooltip.add(Component.translatable("gui.arproddelight.limit")
				.append(Component.literal(Integer.toString(caffeineLimit)))
				.withStyle(ChatFormatting.DARK_GRAY));

		for (int i = 0; i < Math.min(positiveEffects.size(), positiveEffectDurations.size()); i++) {
			MobEffect effect = positiveEffects.get(i);
			int durationTicks = positiveEffectDurations.get(i);
			String durationText = formatDuration(durationTicks);

			tooltip.add(Component.translatable(effect.getDescriptionId())
					.append(Component.literal(" (" + durationText + ")"))
					.withStyle(ChatFormatting.BLUE));
		}
	}

	private static String formatDuration(int ticks) {
		int totalSeconds = Math.max(ticks, 0) / 20;
		int minutes = totalSeconds / 60;
		int seconds = totalSeconds % 60;
		return String.format("%d:%02d", minutes, seconds);
	}

}
