package com.arprod.arproddelight.event;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraft.world.entity.LivingEntity;

import com.arprod.arproddelight.registry.ArproddelightModMobEffects;

@Mod.EventBusSubscriber
public class EffectRemovalEvent {

    @SubscribeEvent
    public static void onEffectRemove(MobEffectEvent.Remove event) {
        LivingEntity entity = event.getEntity();

        if (event.getEffect() == ArproddelightModMobEffects.LACTOSE_INTOLERANCE.get()) return;

        // If entity has Lactose Intolerance
        if (entity.hasEffect(ArproddelightModMobEffects.LACTOSE_INTOLERANCE.get())) event.setCanceled(true);
    }
}
