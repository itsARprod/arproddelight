package com.arprod.arproddelight.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ArproddelightModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS;
    public static final RegistryObject<SoundEvent> MUSIC_DISC_HIGH;

    static {
        SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "arproddelight");
        MUSIC_DISC_HIGH = SOUNDS.register("music_disc_high", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("arproddelight", "music_disc_high")));
    }
}
