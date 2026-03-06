
package com.arprod.arproddelight.fluid;

import com.arprod.arproddelight.fluid.types.MeltedCheeseFluidType;
import com.arprod.arproddelight.item.MeltedCheeseItem;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

import com.arprod.arproddelight.init.ArproddelightModItems;
import com.arprod.arproddelight.init.ArproddelightModFluids;
import com.arprod.arproddelight.init.ArproddelightModFluidTypes;
import com.arprod.arproddelight.init.ArproddelightModBlocks;

public abstract class MeltedCheeseFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> ArproddelightModFluidTypes.MELTED_CHEESE_TYPE.get(), () -> ArproddelightModFluids.MELTED_CHEESE.get(),
			() -> ArproddelightModFluids.FLOWING_MELTED_CHEESE.get()).explosionResistance(100f).bucket(() -> ArproddelightModItems.MELTED_CHEESE_BUCKET.get()).block(() -> (LiquidBlock) ArproddelightModBlocks.MELTED_CHEESE.get());

	private MeltedCheeseFluid() {
		super(PROPERTIES);
	}

	public static class Source extends MeltedCheeseFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends MeltedCheeseFluid {
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
