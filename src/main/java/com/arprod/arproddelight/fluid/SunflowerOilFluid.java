
package com.arprod.arproddelight.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

import com.arprod.arproddelight.init.ArproddelightModItems;
import com.arprod.arproddelight.init.ArproddelightModFluids;
import com.arprod.arproddelight.init.ArproddelightModFluidTypes;
import com.arprod.arproddelight.init.ArproddelightModBlocks;

public abstract class SunflowerOilFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> ArproddelightModFluidTypes.SUNFLOWER_OIL_TYPE.get(), () -> ArproddelightModFluids.SUNFLOWER_OIL.get(),
			() -> ArproddelightModFluids.FLOWING_SUNFLOWER_OIL.get()).explosionResistance(100f).bucket(() -> ArproddelightModItems.SUNFLOWER_OIL_BUCKET.get()).block(() -> (LiquidBlock) ArproddelightModBlocks.SUNFLOWER_OIL.get());

	private SunflowerOilFluid() {
		super(PROPERTIES);
	}

	public static class Source extends SunflowerOilFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends SunflowerOilFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
