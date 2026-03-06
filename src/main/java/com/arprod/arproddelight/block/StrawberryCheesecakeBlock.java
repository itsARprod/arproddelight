package com.arprod.arproddelight.block;

import com.arprod.arproddelight.init.ArproddelightModItems;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import vectorwing.farmersdelight.common.block.PieBlock;

public class StrawberryCheesecakeBlock extends PieBlock {
    public StrawberryCheesecakeBlock() {
        super(BlockBehaviour.Properties.of()
                .strength(0.5F)
                .sound(SoundType.WOOL)
                .noOcclusion(), ArproddelightModItems.STRAWBERRY);
    }
}
