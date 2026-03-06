
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package com.arprod.arproddelight.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import com.arprod.arproddelight.potion.LactoseIntoleranceMobEffect;
import com.arprod.arproddelight.ArproddelightMod;

public class ArproddelightModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ArproddelightMod.MODID);
	public static final RegistryObject<MobEffect> LACTOSE_INTOLERANCE = REGISTRY.register("lactose_intolerance", () -> new LactoseIntoleranceMobEffect());
}
