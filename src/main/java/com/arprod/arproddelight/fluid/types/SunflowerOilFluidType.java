
package com.arprod.arproddelight.fluid.types;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;

import java.util.function.Consumer;

public class SunflowerOilFluidType extends FluidType {
	public SunflowerOilFluidType() {
		super(FluidType.Properties.create().fallDistanceModifier(0F).canExtinguish(false).supportsBoating(true).canHydrate(false).motionScale(0.007D).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
				.sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH));
	}

	@Override
	public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
		consumer.accept(new IClientFluidTypeExtensions() {
			private static final ResourceLocation STILL_TEXTURE = new ResourceLocation("arproddelight:block/sunflower_oil_still");
			private static final ResourceLocation FLOWING_TEXTURE = new ResourceLocation("arproddelight:block/sunflower_oil_flow");

			@Override
			public ResourceLocation getStillTexture() {
				return STILL_TEXTURE;
			}

			@Override
			public ResourceLocation getFlowingTexture() {
				return FLOWING_TEXTURE;
			}
		});
	}
}
