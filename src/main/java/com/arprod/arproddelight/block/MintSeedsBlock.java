package com.arprod.arproddelight.block;

import com.arprod.arproddelight.init.ArproddelightModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

public class MintSeedsBlock extends CropBlock {

    public MintSeedsBlock() {
        super(Properties.of()
                .mapColor(MapColor.PLANT)
                .sound(SoundType.CROP)
                .noCollission()
                .randomTicks()
                .instabreak());
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ArproddelightModItems.MINT_SEEDS.get();
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 100;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 60;
    }
}
