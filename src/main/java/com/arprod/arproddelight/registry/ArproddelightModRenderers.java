package com.arprod.arproddelight.registry;

import com.arprod.arproddelight.ArproddelightMod;
import com.arprod.arproddelight.render.CompressorRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ArproddelightMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ArproddelightModRenderers {
    private ArproddelightModRenderers() {}

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ArproddelightModBlockEntities.COMPRESSOR.get(), context -> new CompressorRenderer());
    }
}
