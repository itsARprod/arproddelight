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
import vectorwing.farmersdelight.common.block.PieBlock;

public class MargheritaPizzaBlock extends PieBlock {

    
    private static final VoxelShape SHAPE = Block.box(2.0F, 0.0F, 2.0F, 14.0F, 3.0F, 14.0F);

    public MargheritaPizzaBlock() {
        super(
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.WOOL)
                        .strength(0.5F)
                        .sound(SoundType.WOOL)
                        .noOcclusion(),
                ArproddelightModItems.MARGHERITA_PIZZA_SLICE
        );
    }

    @Override
    public  VoxelShape getShape( BlockState state,  BlockGetter world,  net.minecraft.core.BlockPos pos,  CollisionContext context) {
        return SHAPE;
    }

}
