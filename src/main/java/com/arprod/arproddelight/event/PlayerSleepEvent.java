package com.arprod.arproddelight.event;

import com.arprod.arproddelight.registry.ArproddelightModMobEffects;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PlayerSleepEvent {

    @SubscribeEvent
    public static void onPlayerWakeUp(PlayerWakeUpEvent event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) {
            return;
        }

        if (event.wakeImmediately()) {
            return;
        }

        if (player.level().isClientSide) {
            return;
        }

        player.getPersistentData().putInt("caffeine", 0);

        player.removeEffect(ArproddelightModMobEffects.LACTOSE_INTOLERANCE.get());
    }
}
