package com.arprod.arproddelight.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class MoldPlayerFinishesUsingItemProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide()) {
            _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 1, false, false));
            _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 600, 0, false, false));
            _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 1, false, false));
        }
    }
}
 