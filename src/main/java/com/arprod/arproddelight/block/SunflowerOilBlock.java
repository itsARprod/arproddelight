package com.arprod.arproddelight.block;

import com.arprod.arproddelight.registry.ArproddelightModFluids;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
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
