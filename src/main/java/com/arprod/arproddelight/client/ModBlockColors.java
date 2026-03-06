package com.arprod.arproddelight.client;

import com.arprod.arproddelight.init.ArproddelightModBlocks;
import com.arprod.arproddelight.block.GelatinBlockBlock;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.world.item.DyeColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        modid = "arproddelight",
        value = Dist.CLIENT,
        bus = Mod.EventBusSubscriber.Bus.MOD
)
public class ModBlockColors {

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {

        event.register(
                (state, level, pos, tintIndex) -> {
                    if (state.getValue(GelatinBlockBlock.DYED)) {
                        float[] c = state.getValue(GelatinBlockBlock.COLOR)
                                .getTextureDiffuseColors();

                        return ((int)(c[0] * 255) << 16)
                                | ((int)(c[1] * 255) << 8)
                                |  (int)(c[2] * 255);
                    }
                    return 0xFFFFFFFF;
                },
                ArproddelightModBlocks.GELATIN_BLOCK.get()
        );
    }
}
