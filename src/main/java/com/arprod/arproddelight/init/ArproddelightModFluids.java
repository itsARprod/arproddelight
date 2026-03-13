
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package com.arprod.arproddelight.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import com.arprod.arproddelight.fluid.MeltedCheeseFluid;
import com.arprod.arproddelight.fluid.SunflowerOilFluid;
//import com.arprod.arproddelight.fluid.CreamFluid;
import com.arprod.arproddelight.ArproddelightMod;

public class ArproddelightModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, ArproddelightMod.MODID);
	public static final RegistryObject<FlowingFluid> MELTED_CHEESE = REGISTRY.register("melted_cheese", MeltedCheeseFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_MELTED_CHEESE = REGISTRY.register("flowing_melted_cheese", MeltedCheeseFluid.Flowing::new);
	public static final RegistryObject<FlowingFluid> SUNFLOWER_OIL = REGISTRY.register("sunflower_oil", SunflowerOilFluid.Source::new);
	public static final RegistryObject<FlowingFluid> FLOWING_SUNFLOWER_OIL = REGISTRY.register("flowing_sunflower_oil", SunflowerOilFluid.Flowing::new);

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(MELTED_CHEESE.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_MELTED_CHEESE.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(SUNFLOWER_OIL.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_SUNFLOWER_OIL.get(), RenderType.translucent());
		}
	}
}
