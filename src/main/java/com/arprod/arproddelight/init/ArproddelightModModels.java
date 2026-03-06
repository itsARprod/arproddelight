
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.arprod.arproddelight.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import com.arprod.arproddelight.client.model.Modelaxolotlarmor;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ArproddelightModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelaxolotlarmor.LAYER_LOCATION, Modelaxolotlarmor::createBodyLayer);
	}
}
