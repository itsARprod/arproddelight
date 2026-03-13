
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
import org.jetbrains.annotations.NotNull;

public abstract class MeltedCheeseFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(ArproddelightModFluidTypes.MELTED_CHEESE_TYPE, ArproddelightModFluids.MELTED_CHEESE,
            ArproddelightModFluids.FLOWING_MELTED_CHEESE).explosionResistance(100f).bucket(ArproddelightModItems.MELTED_CHEESE_BUCKET).block(() -> (LiquidBlock) ArproddelightModBlocks.MELTED_CHEESE.get());

	private MeltedCheeseFluid() {
		super(PROPERTIES);
	}

	public static class Source extends MeltedCheeseFluid {
		public int getAmount(@NotNull FluidState state) {
			return 8;
		}

		public boolean isSource(@NotNull FluidState state) {
			return true;
		}
	}

	public static class Flowing extends MeltedCheeseFluid {
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
