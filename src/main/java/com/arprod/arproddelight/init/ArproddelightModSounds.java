package com.arprod.arproddelight.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ArproddelightModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS;
    public static final RegistryObject<SoundEvent> FRYING_BASKET_SIZZLING;

    static {
        SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "arproddelight");
        FRYING_BASKET_SIZZLING = SOUNDS.register("frying_basket_sizzling", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("arproddelight", "frying_basket_sizzling")));
    }
}

