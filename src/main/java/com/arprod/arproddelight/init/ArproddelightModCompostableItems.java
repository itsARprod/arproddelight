
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.arprod.arproddelight.init;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.block.ComposterBlock;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ArproddelightModCompostableItems {
	@SubscribeEvent
	public static void addComposterItems(FMLCommonSetupEvent event) {
		ComposterBlock.COMPOSTABLES.put(ArproddelightModItems.BANANA_PEEL.get(), 0.5f);
        ComposterBlock.COMPOSTABLES.put(ArproddelightModItems.BANANA.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ArproddelightModItems.PEAR.get(), 0.5f);
        ComposterBlock.COMPOSTABLES.put(ArproddelightModItems.MINT_SEEDS.get(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(ArproddelightModItems.MINT.get(), 0.5f);
        ComposterBlock.COMPOSTABLES.put(ArproddelightModItems.WILD_MINT.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ArproddelightModItems.COFFEE_BERRY.get(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(ArproddelightModItems.MOLD.get(), 1);
        ComposterBlock.COMPOSTABLES.put(ArproddelightModItems.COTTON.get(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(ArproddelightModItems.COTTON_SEEDS.get(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(ArproddelightModItems.CHERRY.get(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(ArproddelightModItems.WILD_COTTON.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ArproddelightModItems.WILD_COFFEA.get(), 0.65f);
	}
}
