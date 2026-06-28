package com.arprod.arproddelight.item;

import com.arprod.arproddelight.item.template.CoffeeItem;
import net.minecraft.world.effect.MobEffects;

import java.util.List;

public class CoffeeCupItem extends CoffeeItem {
    public CoffeeCupItem() {
        super(3,                              // caffeineLimit
                1200,                           // negativeEffectDuration
                2,                              // negativeEffectStrength
                List.of(MobEffects.MOVEMENT_SPEED, MobEffects.DIG_SPEED),
                List.of(2400, 3000));
    }


}
