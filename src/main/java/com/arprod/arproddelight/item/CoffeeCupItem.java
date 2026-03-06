package com.arprod.arproddelight.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CoffeeCupItem extends CoffeeItem{
    public CoffeeCupItem() {
        super(3,                              // caffeineLimit
                1200,                           // negativeEffectDuration
                6,                              // negativeEffectStrength
                List.of(MobEffects.MOVEMENT_SPEED, MobEffects.DIG_SPEED),
                List.of(2400, 3000));
    }


}
