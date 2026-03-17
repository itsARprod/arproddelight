
package com.arprod.arproddelight.fluid;

import com.arprod.arproddelight.init.ArproddelightModBlocks;
import com.arprod.arproddelight.init.ArproddelightModFluidTypes;
import com.arprod.arproddelight.init.ArproddelightModFluids;
import com.arprod.arproddelight.init.ArproddelightModItems;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import org.jetbrains.annotations.NotNull;

public abstract class MayonnaiseFluid extends ForgeFlowingFluid {
	public static final Properties PROPERTIES = new Properties(ArproddelightModFluidTypes.MAYONNAISE_TYPE, ArproddelightModFluids.MAYONNAISE,
            ArproddelightModFluids.FLOWING_MAYONNAISE);

	private MayonnaiseFluid() {
		super(PROPERTIES);
	}

	public static class Source extends MayonnaiseFluid {
		public int getAmount(@NotNull FluidState state) {
			return 8;
		}

		public boolean isSource(@NotNull FluidState state) {
			return true;
		}
	}

	public static class Flowing extends MayonnaiseFluid {
		protected void createFluidStateDefinition(StateDefinition.@NotNull Builder<Fluid, FluidState> builder) {
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
