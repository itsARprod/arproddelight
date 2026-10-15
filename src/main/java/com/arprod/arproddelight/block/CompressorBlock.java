package com.arprod.arproddelight.block;

import com.arprod.arproddelight.block_entity.CompressorBlockEntity;
import com.simibubi.create.content.kinetics.base.KineticBlock;
import com.simibubi.create.content.kinetics.simpleRelays.ICogWheel;
import com.simibubi.create.foundation.block.IBE;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class CompressorBlock extends KineticBlock implements IBE<CompressorBlockEntity>, ICogWheel {
    public CompressorBlock() {
        super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(1f, 10f).noOcclusion());
    }

    @Override
    public Axis getRotationAxis(BlockState state) {
        return Axis.Y;
    }

    @Override
    public boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face) {
        return false;
    }

    @Override
    public Class<CompressorBlockEntity> getBlockEntityClass() {
        return CompressorBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends CompressorBlockEntity> getBlockEntityType() {
        return com.arprod.arproddelight.registry.ArproddelightModBlockEntities.COMPRESSOR.get();
    }
}
