
package com.arprod.arproddelight.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class BananaCrateBlock extends Block {
	public BananaCrateBlock() {
		super(BlockBehaviour.Properties.of().ignitedByLava().sound(SoundType.WOOD).strength(1f, 10f));
	}
}
