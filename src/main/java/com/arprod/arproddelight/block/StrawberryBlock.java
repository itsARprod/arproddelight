package com.arprod.arproddelight.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;

public class StrawberryBlock extends SweetBerryBushBlock {

    public StrawberryBlock() {
        super(Properties.of()
                .mapColor(MapColor.PLANT)
                .sound(SoundType.SWEET_BERRY_BUSH)
                .noCollission()
                .randomTicks()
                .instabreak()
                .pushReaction(PushReaction.DESTROY)
        );
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        // Disable damage and slowdown
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState state) {
        return new ItemStack(this);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
        int age = state.getValue(AGE);

        if (age < 2) {
            return List.of();
        }

        int count = (age == 2) ? 1 : 2 + builder.getLevel().random.nextInt(2);
        return List.of(new ItemStack(this, count));
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {
        int age = state.getValue(AGE);

        if (!level.isClientSide && age >= 2) {
            int count = (age == 2) ? 1 : 2 + level.random.nextInt(2);
            popResource(level, pos, new ItemStack(this, count));
            level.setBlock(pos, state.setValue(AGE, 1), 2);
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }
}