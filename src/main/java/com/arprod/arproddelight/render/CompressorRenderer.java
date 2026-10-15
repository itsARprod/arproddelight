package com.arprod.arproddelight.render;

import com.arprod.arproddelight.block_entity.CompressorBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.simibubi.create.AllPartialModels;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.createmod.catnip.render.CachedBuffers;
import net.createmod.catnip.render.SuperByteBuffer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.core.Direction;

public class CompressorRenderer implements BlockEntityRenderer<CompressorBlockEntity> {
    public CompressorRenderer() {}

    @Override
    public void render(CompressorBlockEntity be, float partialTicks, PoseStack poseStack,
                       MultiBufferSource buffer, int light, int overlay) {
        if (be.getLevel() == null)
            return;

        float time = AnimationTickHolder.getRenderTime(be.getLevel());
        float angle = (time * be.getRenderedCogSpeed() * 3f / 10f) % 360f;
        SuperByteBuffer cog = CachedBuffers.partial(AllPartialModels.MECHANICAL_PUMP_COG, be.getBlockState());
        VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.solid());
        cog.rotateCentered(angle * ((float) Math.PI / 180f), Direction.SOUTH)
                .light(light)
                .renderInto(poseStack, vertexConsumer);
        cog.rotateCentered(0.5f * (float)Math.PI, Direction.WEST);
    }
}
