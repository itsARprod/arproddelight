package com.arprod.arproddelight.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;

import com.arprod.arproddelight.init.ArproddelightModFluids;

public class MeltedCheeseBlock extends LiquidBlock {

    public MeltedCheeseBlock() {
        super(
                ArproddelightModFluids.MELTED_CHEESE,
                BlockBehaviour.Properties.of()
                        .strength(100f)
                        .noCollission()
                        .noLootTable()
                        .liquid()
                        .replaceable()
                        .pushReaction(PushReaction.DESTROY)
                        .sound(SoundType.EMPTY)
        );
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos,
                        BlockState oldState, boolean moving) {
        if (!this.checkForMixing(level, pos)) {
            super.onPlace(state, level, pos, oldState, moving);
        }
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos,
                                Block block, BlockPos fromPos, boolean moving) {
        if (!this.checkForMixing(level, pos)) {
            super.neighborChanged(state, level, pos, block, fromPos, moving);
        }
    }

    private boolean checkForMixing(Level level, BlockPos pos) {
        for (Direction dir : Direction.values()) {
            if (level.getFluidState(pos.relative(dir)).is(Fluids.LAVA)) {

                // Replace the cheese, not the lava
                level.setBlock(pos, Blocks.GRANITE.defaultBlockState(), 3);

                // Vanilla fizz
                level.levelEvent(1501, pos, 0);

                return true;
            }
        }
        return false;
    }

    @Override
    public BlockState updateShape(BlockState state,
                                  Direction direction,
                                  BlockState neighborState,
                                  net.minecraft.world.level.LevelAccessor level,
                                  BlockPos pos,
                                  BlockPos neighborPos) {

        if (this.checkForMixing((Level) level, pos)) {
            return Blocks.GRANITE.defaultBlockState();
        }

        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }
}
