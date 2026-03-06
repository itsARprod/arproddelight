package com.arprod.arproddelight.block;

import com.arprod.arproddelight.init.ArproddelightModFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class SunflowerOilBlock extends LiquidBlock {

    public SunflowerOilBlock() {
        super(
                () -> ArproddelightModFluids.SUNFLOWER_OIL.get(),
                Properties.of()
                        .mapColor(MapColor.WATER)
                        .strength(100f)
                        .noCollission()
                        .noLootTable()
                        .liquid()
                        .replaceable()
                        .pushReaction(PushReaction.DESTROY)
                        .sound(SoundType.EMPTY)
        );
    }
}
