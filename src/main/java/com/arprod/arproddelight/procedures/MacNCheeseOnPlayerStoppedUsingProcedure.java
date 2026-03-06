package com.arprod.arproddelight.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class MacNCheeseOnPlayerStoppedUsingProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(
			    ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation("farmersdelight:nourishment")), 
			    3600, // Duration in ticks (3600 ticks = 3 minutes)
			    0,    // Amplifier (level 1)
			    false, 
			    true
			));
	}
}
