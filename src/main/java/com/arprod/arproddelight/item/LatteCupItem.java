package com.arprod.arproddelight.item;

import com.arprod.arproddelight.item.template.CoffeeItem;
import net.minecraft.world.effect.MobEffects;

import java.util.List;

public class LatteCupItem extends CoffeeItem {
    public LatteCupItem() {
        super(4,                              // caffeineLimit
                1200,                           // negativeEffectDuration
                3,                              // negativeEffectStrength
                List.of(MobEffects.MOVEMENT_SPEED, MobEffects.REGENERATION), //effects
                List.of(600, 600)); //durations
    }

}
