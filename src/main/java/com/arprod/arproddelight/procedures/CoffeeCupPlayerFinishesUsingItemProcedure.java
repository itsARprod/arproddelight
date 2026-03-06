package com.arprod.arproddelight.procedures;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import com.arprod.arproddelight.init.ArproddelightModMobEffects;

public class CoffeeCupPlayerFinishesUsingItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("caffeine") >= 3) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.MOVEMENT_SPEED);
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.DIG_SPEED);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 6000, 4, false, true));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 6000, 4, false, true));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(ArproddelightModMobEffects.LACTOSE_INTOLERANCE.get(), 6000, 0, false, true));
            /* ADVANCEMENT */
            if (entity instanceof ServerPlayer _player) {
                Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("arproddelight:main/coffee"));
                AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                if (!_ap.isDone()) {
                    for (String criteria : _ap.getRemainingCriteria())
                        _player.getAdvancements().award(_adv, criteria);
                }
            }
		} else {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1800, (int) entity.getPersistentData().getDouble("caffeine"), false, true));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 2400, (int) entity.getPersistentData().getDouble("caffeine"), false, true));
			entity.getPersistentData().putDouble("caffeine", (entity.getPersistentData().getDouble("caffeine") + 1));
		}
	}
}
