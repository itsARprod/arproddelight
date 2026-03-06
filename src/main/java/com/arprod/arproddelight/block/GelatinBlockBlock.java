package com.arprod.arproddelight.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.phys.BlockHitResult;

public class GelatinBlockBlock extends Block {

    public static final EnumProperty<DyeColor> COLOR =
            EnumProperty.create("color", DyeColor.class);
    public static final BooleanProperty DYED =
            BooleanProperty.create("dyed");

    public GelatinBlockBlock() {
        super(Properties.of()
                .instrument(NoteBlockInstrument.BASEDRUM)
                .sound(SoundType.SLIME_BLOCK)
                .instabreak()
                .noOcclusion());

        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(DYED, false)
                        .setValue(COLOR, DyeColor.WHITE)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DYED, COLOR);
    }

    /* Dyeing */

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {

        ItemStack stack = player.getItemInHand(hand);

        if (stack.getItem() instanceof DyeItem dye) {
            if (!level.isClientSide) level.setBlock(
                    pos,
                    state.setValue(DYED, true).setValue(COLOR, dye.getDyeColor()),
                    3
            );
            level.playSound(null, pos, SoundEvents.DYE_USE, SoundSource.BLOCKS,
                    1.2f, 0.95f + level.random.nextFloat() * 0.1f);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }else if (stack.getItem() == Items.WATER_BUCKET) {
            if (!level.isClientSide) level.setBlock(
                    pos,
                    state.setValue(DYED, false),
                    3
            );
            level.playSound(null, pos, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS,
                    1.2f, 0.95f + level.random.nextFloat() * 0.1f);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return InteractionResult.PASS;
    }

    /* Less-bouncy slime behavior */

    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        entity.causeFallDamage(fallDistance, 0.3F, level.damageSources().fall());
    }

    @Override
    public void updateEntityAfterFallOn(BlockGetter level, Entity entity) {
        if (entity.isSuppressingBounce()) return;

        double y = entity.getDeltaMovement().y;
        if (y < 0.0D) {
            entity.setDeltaMovement(
                    entity.getDeltaMovement().x,
                    -y * 0.4D,
                    entity.getDeltaMovement().z
            );
        }
    }

//    @Override
//    public int getLightBlock(BlockState state, BlockGetter level, BlockPos pos) {
//        return 15;
//    }
}