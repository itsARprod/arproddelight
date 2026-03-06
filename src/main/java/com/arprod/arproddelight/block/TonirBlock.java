package com.arprod.arproddelight.block;

import net.minecraft.world.Containers;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;

import com.arprod.arproddelight.block_entity.TonirBlockEntity;
import com.arprod.arproddelight.init.ArproddelightModBlockEntities;

public class TonirBlock extends BaseEntityBlock {

    public TonirBlock() {
        super(BlockBehaviour.Properties.of()
                .strength(2f, 8f)
                .sound(SoundType.STONE)
        );
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TonirBlockEntity(pos, state);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) return InteractionResult.SUCCESS;

        TonirBlockEntity tonir = (TonirBlockEntity) level.getBlockEntity(pos);
        if (tonir == null) return InteractionResult.PASS;

        // MAIN HAND FIRST, THEN OFFHAND
        ItemStack main = player.getMainHandItem();
        ItemStack off = player.getOffhandItem();
        ItemStack held = main.isEmpty() ? off : main;

        // EMPTY HAND -> EXTRACT + COLLECT STORED XP
        if (held.isEmpty()) {
            ItemStack out = tonir.extractItem();
            boolean awardedXp = tonir.awardStoredExperience(player);
            if (!out.isEmpty()) {
                player.addItem(out);
                return InteractionResult.CONSUME;
            }
            return awardedXp ? InteractionResult.CONSUME : InteractionResult.PASS;
        }

        // INSERT
        int inserted = tonir.insertFromPlayer(held);
        if (inserted > 0) {
            held.shrink(inserted);
            return InteractionResult.CONSUME;
        }

        return InteractionResult.PASS;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(
            Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide ? null :
                createTickerHelper(type, ArproddelightModBlockEntities.TONIR.get(), TonirBlockEntity::tick);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos,
                         BlockState newState, boolean moved) {
        if (!state.is(newState.getBlock())) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof TonirBlockEntity tonir) {
                Containers.dropItemStack(level,
                        pos.getX(), pos.getY(), pos.getZ(),
                        tonir.getStack());
            }
        }
        super.onRemove(state, level, pos, newState, moved);
    }
}
