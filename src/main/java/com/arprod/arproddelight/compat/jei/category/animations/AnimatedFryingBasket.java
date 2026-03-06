package com.arprod.arproddelight.compat.jei.category.animations;

import com.arprod.arproddelight.init.ArproddelightModBlocks;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.compat.jei.category.animations.AnimatedKinetics;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.util.Mth;

public class AnimatedFryingBasket extends AnimatedKinetics {

    public void draw(GuiGraphics graphics, int xOffset, int yOffset) {
        PoseStack matrixStack = graphics.pose();
        matrixStack.pushPose();
        matrixStack.translate(xOffset, yOffset, 200);
        matrixStack.mulPose(Axis.XP.rotationDegrees(-15.5f));
        matrixStack.mulPose(Axis.YP.rotationDegrees(22.5f));

        int scale = 23;
        float basketYOffset = (Mth.sin(getCurrentAngle() / 32f) + 1f) * 0.015f;

        blockElement(AllBlocks.BASIN.getDefaultState())
                .atLocal(0, 1.65, 0)
                .scale(scale)
                .render(graphics);

        blockElement(ArproddelightModBlocks.FRYING_BASKET.get().defaultBlockState())
                .atLocal(0, 0.65, 0)
                .scale(scale)
                .render(graphics);

        matrixStack.popPose();
    }
}
