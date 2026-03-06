package com.arprod.arproddelight.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.registry.ModEffects;

import java.util.List;

public class LatteCupItem extends CoffeeItem{
    public LatteCupItem() {
        super(4,                              // caffeineLimit
                1200,                           // negativeEffectDuration
                3,                              // negativeEffectStrength
                List.of(MobEffects.MOVEMENT_SPEED, ModEffects.COMFORT.get()), //effects
                List.of(300, 600)); //durations
    }

}
