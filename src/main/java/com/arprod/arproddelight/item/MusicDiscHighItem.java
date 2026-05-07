package com.arprod.arproddelight.item;

import com.arprod.arproddelight.registry.ArproddelightModSounds;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;

public class MusicDiscHighItem extends RecordItem {
    public MusicDiscHighItem() {
        super(1, ArproddelightModSounds.MUSIC_DISC_HIGH, (new Item.Properties()).stacksTo(1).rarity(Rarity.RARE), 7440);
    }

}
