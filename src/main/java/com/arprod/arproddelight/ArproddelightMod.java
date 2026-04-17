package com.arprod.arproddelight;

import com.arprod.arproddelight.init.*;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import java.util.AbstractMap;

@Mod("arproddelight")
public class ArproddelightMod {
	public static final String MODID = "arproddelight";

	public ArproddelightMod(FMLJavaModLoadingContext context) {
		MinecraftForge.EVENT_BUS.register(this);

		IEventBus bus = context.getModEventBus();

		ArproddelightModBlocks.REGISTRY.register(bus);

		ArproddelightModItems.REGISTRY.register(bus);

		ArproddelightModTabs.REGISTRY.register(bus);

		ArproddelightModMobEffects.REGISTRY.register(bus);

		ArproddelightModFluids.REGISTRY.register(bus);

		ArproddelightModFluidTypes.REGISTRY.register(bus);

		ArproddelightModSounds.SOUNDS.register(bus);

        ArproddelightModRecipes.register(context.getModEventBus());

        ArproddelightModBlockEntities.register(context.getModEventBus());

	}

    private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	@SubscribeEvent
	public void tick(TickEvent.ServerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
			workQueue.forEach(work -> {
				work.setValue(work.getValue() - 1);
				if (work.getValue() == 0)
					actions.add(work);
			});
			actions.forEach(e -> e.getKey().run());
			workQueue.removeAll(actions);
		}
	}
}
