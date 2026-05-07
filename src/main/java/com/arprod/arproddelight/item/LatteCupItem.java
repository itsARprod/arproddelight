package com.arprod.arproddelight.item;

import com.arprod.arproddelight.item.template.CoffeeItem;
import net.minecraft.world.effect.MobEffects;
import vectorwing.farmersdelight.common.registry.ModEffects;

import java.util.List;

public class LatteCupItem extends CoffeeItem {
    public LatteCupItem() {
        super(4,                              // caffeineLimit
                1200,                           // negativeEffectDuration
                3,                              // negativeEffectStrength
                List.of(MobEffects.MOVEMENT_SPEED, ModEffects.COMFORT.get()), //effects
                List.of(300, 600)); //durations
    }

}
