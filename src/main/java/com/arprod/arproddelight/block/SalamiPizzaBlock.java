package com.arprod.arproddelight.block;

import com.arprod.arproddelight.init.ArproddelightModItems;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.block.PieBlock;

public class SalamiPizzaBlock extends PieBlock {

    // Example voxel shape: slightly taller than default
    private static final VoxelShape SHAPE = Block.box(2.0F, 0.0F, 2.0F, 14.0F, 3.0F, 14.0F);

    public SalamiPizzaBlock() {
        super(
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.WOOL)
                        .strength(0.5F)
                        .sound(SoundType.WOOL)
                        .noOcclusion(),
                ArproddelightModItems.SALAMI_PIZZA_SLICE
        );
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter world, net.minecraft.core.@NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE;
    }
}
