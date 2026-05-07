package com.arprod.arproddelight.block;

import com.arprod.arproddelight.registry.ArproddelightModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class CoffeeBeanBlock extends CropBlock {

    public CoffeeBeanBlock() {
        super(Properties.of()
                .mapColor(MapColor.PLANT)
                .sound(SoundType.CROP)
                .noCollission()
                .randomTicks()
                .instabreak());
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ArproddelightModItems.COFFEE_BEAN.get();
    }
}
