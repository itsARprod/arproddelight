package com.arprod.arproddelight.block.template;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.block.PieBlock;

import java.util.function.Supplier;

public class PizzaBlock extends PieBlock {
    protected static final VoxelShape SHAPE = Block.box(2.0F, 0.0F, 2.0F, 14.0F, 3.0F, 14.0F);

    public PizzaBlock(Supplier<Item> pieSlice) {
        super(BlockBehaviour.Properties.of()
                .strength(0.5F)
                .sound(SoundType.WOOL)
                .noOcclusion(),
                pieSlice);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, net.minecraft.core.BlockPos pos, CollisionContext context) {
        return SHAPE;
    }


}
