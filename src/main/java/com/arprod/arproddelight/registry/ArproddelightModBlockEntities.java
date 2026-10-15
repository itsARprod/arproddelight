package com.arprod.arproddelight.registry;

import com.arprod.arproddelight.ArproddelightMod;
import com.arprod.arproddelight.block_entity.CompressorBlockEntity;
import com.arprod.arproddelight.block_entity.FryingBasketBlockEntity;
import com.arprod.arproddelight.block_entity.TonirBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ArproddelightModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ArproddelightMod.MODID);

    public static final RegistryObject<BlockEntityType<TonirBlockEntity>> TONIR =
            BLOCK_ENTITIES.register("tonir",
                    () -> BlockEntityType.Builder.of(
                            TonirBlockEntity::new,
                            ArproddelightModBlocks.TONIR.get()
                    ).build(null)
            );

    public static final RegistryObject<BlockEntityType<FryingBasketBlockEntity>> FRYING_BASKET =
            BLOCK_ENTITIES.register("frying_basket",
                    () -> BlockEntityType.Builder.of(
                            FryingBasketBlockEntity::new,
                            ArproddelightModBlocks.FRYING_BASKET.get()
                    ).build(null)
            );

    public static final RegistryObject<BlockEntityType<CompressorBlockEntity>> COMPRESSOR =
            BLOCK_ENTITIES.register("compressor",
                    () -> BlockEntityType.Builder.of(
                            ArproddelightModBlockEntities::createCompressor,
                            ArproddelightModBlocks.COMPRESSOR.get()
                    ).build(null)
            );

    private static CompressorBlockEntity createCompressor(net.minecraft.core.BlockPos pos,
                                                           net.minecraft.world.level.block.state.BlockState state) {
        return new CompressorBlockEntity(COMPRESSOR.get(), pos, state);
    }

    public static void register(net.minecraftforge.eventbus.api.IEventBus bus) {
        BLOCK_ENTITIES.register(bus);
    }
}
