package com.arprod.arproddelight.block_entity;

import java.util.Optional;

import com.arprod.arproddelight.recipe.CompressingRecipe;
import com.simibubi.create.content.processing.basin.BasinBlockEntity;
import com.simibubi.create.content.processing.basin.BasinOperatingBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class CompressorBlockEntity extends BasinOperatingBlockEntity {
    private static final Object COMPRESSING_RECIPE_CACHE_KEY = new Object();
    private static final int CYCLE_TICKS = 40;

    public int runningTicks;
    public boolean running;

    public CompressorBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public float getRenderedCogSpeed() {
        return getSpeed();
    }

    @Override
    public void tick() {
        super.tick();
        if (!running || level == null)
            return;

        runningTicks++;
        if (runningTicks == CYCLE_TICKS / 2 && (!level.isClientSide || isVirtual())) {
            applyBasinRecipe();
            sendData();
        }
        if (runningTicks >= CYCLE_TICKS) {
            running = false;
            runningTicks = 0;
            basinChecker.scheduleUpdate();
            sendData();
        }
    }

    @Override
    public void startProcessingBasin() {
        running = true;
        runningTicks = 0;
    }

    @Override
    protected Optional<BasinBlockEntity> getBasin() {
        if (level == null)
            return Optional.empty();
        BlockEntity below = level.getBlockEntity(worldPosition.below());
        return below instanceof BasinBlockEntity basin ? Optional.of(basin) : Optional.empty();
    }

    @Override
    protected boolean isRunning() {
        return running;
    }

    @Override
    protected void onBasinRemoved() {
        running = false;
        runningTicks = 0;
    }

    @Override
    protected <C extends Container> boolean matchStaticFilters(Recipe<C> recipe) {
        return recipe instanceof CompressingRecipe;
    }

    @Override
    protected Object getRecipeCacheKey() {
        return COMPRESSING_RECIPE_CACHE_KEY;
    }

    @Override
    protected void read(CompoundTag tag, boolean clientPacket) {
        running = tag.getBoolean("Running");
        runningTicks = tag.getInt("RunningTicks");
        super.read(tag, clientPacket);
    }

    @Override
    public void write(CompoundTag tag, boolean clientPacket) {
        tag.putBoolean("Running", running);
        tag.putInt("RunningTicks", runningTicks);
        super.write(tag, clientPacket);
    }
}
