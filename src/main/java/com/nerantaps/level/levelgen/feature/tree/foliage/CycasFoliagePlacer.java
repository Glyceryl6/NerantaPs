package com.nerantaps.level.levelgen.feature.tree.foliage;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.nerantaps.registry.NPFoliagePlacer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

import java.util.function.BiConsumer;

public class CycasFoliagePlacer extends FoliagePlacer {

    public static final Codec<CycasFoliagePlacer> CODEC = RecordCodecBuilder.create((placer) -> foliagePlacerParts(placer).apply(placer, CycasFoliagePlacer::new));

    public CycasFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return NPFoliagePlacer.CYCAS_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader reader, BiConsumer<BlockPos, BlockState> blockSetter, RandomSource random, TreeConfiguration config,
                                 int maxFreeTreeHeight, FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset) {
        BlockPos startingPos = attachment.pos();
        for (BlockPos pos : BlockPos.withinManhattan(startingPos, 1, 0, 1)) {
            tryPlaceLeaf(reader, blockSetter, random, config, pos);
        }
        for (Direction direction : Direction.values()) {
            if (direction.getAxis().isHorizontal()) {
                tryPlaceLeaf(reader, blockSetter, random, config, startingPos.above().relative(direction));
                tryPlaceLeaf(reader, blockSetter, random, config, startingPos.below().relative(direction));
                tryPlaceLeaf(reader, blockSetter, random, config, startingPos.relative(direction, 2));
                tryPlaceLeaf(reader, blockSetter, random, config, startingPos.below().relative(direction, 3));
                tryPlaceLeaf(reader, blockSetter, random, config, startingPos.below(2).relative(direction, 3));
                tryPlaceLeaf(reader, blockSetter, random, config, startingPos.below()
                        .relative(direction, 2).relative(direction.getClockWise(), 2));
                tryPlaceLeaf(reader, blockSetter, random, config, startingPos.below(2)
                        .relative(direction, 2).relative(direction.getClockWise(), 2));
            }
        }
    }

    @Override
    public int foliageHeight(RandomSource random, int height, TreeConfiguration config) {
        return 2;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int localX, int localY, int localZ, int range, boolean large) {
        return false;
    }

}