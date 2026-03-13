
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package com.arprod.arproddelight.init;

import com.arprod.arproddelight.fluid.types.SunflowerOilFluidType;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fluids.FluidType;

import com.arprod.arproddelight.fluid.types.MeltedCheeseFluidType;
//import com.arprod.arproddelight.fluid.types.CreamFluidType;
import com.arprod.arproddelight.ArproddelightMod;

public class ArproddelightModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, ArproddelightMod.MODID);
	public static final RegistryObject<FluidType> MELTED_CHEESE_TYPE = REGISTRY.register("melted_cheese", MeltedCheeseFluidType::new);
	public static final RegistryObject<FluidType> SUNFLOWER_OIL_TYPE = REGISTRY.register("sunflower_oil", SunflowerOilFluidType::new);

}
