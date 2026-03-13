package com.arprod.arproddelight.client;

import com.arprod.arproddelight.ArproddelightMod;
import com.arprod.arproddelight.init.ArproddelightModBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ArproddelightMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ArproddelightModClientSetup {
	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event) {
		event.enqueueWork(() -> ItemBlockRenderTypes.setRenderLayer(ArproddelightModBlocks.STRAWBERRY_CHEESECAKE.get(), RenderType.translucent()));
	}
}
