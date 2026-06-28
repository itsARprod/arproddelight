package com.arprod.arproddelight.effect;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import java.util.ArrayList;

public class RefreshingMobEffect extends MobEffect {
    private static final int EFFECT_REMOVAL_INTERVAL = 100;
    private static final int SATURATION_PER_EFFECT = 2;

    public RefreshingMobEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x3df493);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity.level().isClientSide || entity.tickCount % (EFFECT_REMOVAL_INTERVAL / amplifier) != 0) {
            return;
        }

        for (MobEffectInstance effectInstance : new ArrayList<>(entity.getActiveEffects())) {
            MobEffect effect = effectInstance.getEffect();
            if (effect.getCategory() == MobEffectCategory.HARMFUL) {
                if (entity.removeEffect(effect)) {

                    spawnRemovalEffect(entity);
                    restoreSaturation(entity, effectInstance.getAmplifier());
                    return;
                }
            }
        }

    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }

    private static void spawnRemovalEffect(LivingEntity entity) {
        if (entity.level() instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(
                    ParticleTypes.COMPOSTER,
                    entity.getX(),
                    entity.getY() + entity.getBbHeight() * 0.5D,
                    entity.getZ(),
                    36,
                    entity.getBbWidth() *0.6,
                    entity.getBbHeight() * 0.6,
                    entity.getBbWidth() * 0.6,
                    0.02D
            );
            serverLevel.playSound(
                    null,
                    entity.blockPosition(),
                    SoundEvents.EXPERIENCE_ORB_PICKUP,
                    SoundSource.NEUTRAL,
                    1.0F,
                    1.0F
            );
        }
    }

    private static void restoreSaturation(LivingEntity entity, int amplifier) {
        if (entity instanceof Player player) {
            player.getFoodData().setSaturation(Math.min(
                    player.getFoodData().getSaturationLevel() + SATURATION_PER_EFFECT + amplifier,
                    player.getFoodData().getFoodLevel()
            ));
        }
    }
}
