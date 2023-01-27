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

public class MegaCycasFoliagePlacer extends FoliagePlacer {

    public static final Codec<MegaCycasFoliagePlacer> CODEC = RecordCodecBuilder.create((placer) -> foliagePlacerParts(placer).apply(placer, MegaCycasFoliagePlacer::new));

    public MegaCycasFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return NPFoliagePlacer.MEGA_CYCAS_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader reader, BiConsumer<BlockPos, BlockState> blockSetter, RandomSource random, TreeConfiguration config,
                                 int maxFreeTreeHeight, FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset) {
        BlockPos startingPos = attachment.pos(), offsetPos = startingPos.east().south();
        this.placeLeavesRow(reader, blockSetter, random, config, startingPos, 0, 0, attachment.doubleTrunk());
        this.placeLeavesRow(reader, blockSetter, random, config, offsetPos.below(3).west(4), 0, 0, false);
        this.placeLeavesRow(reader, blockSetter, random, config, offsetPos.below(3).south(3), 0, 0, false);
        this.placeLeavesRow(reader, blockSetter, random, config, startingPos.below(3).east(4), 0, 0, false);
        this.placeLeavesRow(reader, blockSetter, random, config, startingPos.below(3).north(3), 0, 0, false);
        for (Direction direction : Direction.values()) {
            boolean flag1 = direction == Direction.EAST || direction == Direction.SOUTH;
            int j = !flag1 ? 2 : 1, k = flag1 ? 2 : 1;
            if (direction.getAxis().isHorizontal()) {
                this.placeLeavesRow(reader, blockSetter, random, config, offsetPos.above().relative(direction, j), 0, 0, false);
                this.placeLeavesRow(reader, blockSetter, random, config, offsetPos.below().relative(direction, j), 0, 0, false);
                this.placeLeavesRow(reader, blockSetter, random, config, startingPos.above().relative(direction, k), 0, 0, false);
                this.placeLeavesRow(reader, blockSetter, random, config, startingPos.below().relative(direction, k), 0, 0, false);
                this.placeLeavesRow(reader, blockSetter, random, config, offsetPos.below().relative(direction, j + 2), 0, 0, false);
                this.placeLeavesRow(reader, blockSetter, random, config, offsetPos.below(2).relative(direction, j + 2), 0, 0, false);
                this.placeLeavesRow(reader, blockSetter, random, config, startingPos.below().relative(direction, k + 2), 0, 0, false);
                this.placeLeavesRow(reader, blockSetter, random, config, startingPos.below(2).relative(direction, k + 2), 0, 0, false);
                this.placeLeavesRow(reader, blockSetter, random, config, startingPos.relative(direction), 0, 0, attachment.doubleTrunk());
                this.placeLeavesRow(reader, blockSetter, random, config, startingPos.relative(direction, 2), 0, 0, attachment.doubleTrunk());
                this.placeLeavesRow(reader, blockSetter, random, config, startingPos.relative(direction).relative(direction.getClockWise()), 0, 0, attachment.doubleTrunk());
                if (direction.getAxis() == Direction.Axis.X) {
                    int j1 = direction == Direction.EAST ? 2 : 3, k1 = direction == Direction.WEST ? 2 : 3;
                    this.placeLeavesRow(reader, blockSetter, random, config, offsetPos.south(2).relative(direction, j1), 0, 0, false);
                    this.placeLeavesRow(reader, blockSetter, random, config, offsetPos.below().south(2).relative(direction, j1), 0, 0, false);
                    this.placeLeavesRow(reader, blockSetter, random, config, offsetPos.below().south(3).relative(direction, j1), 0, 0, false);
                    this.placeLeavesRow(reader, blockSetter, random, config, offsetPos.below().south(2).relative(direction, j1 + 1), 0, 0, false);
                    this.placeLeavesRow(reader, blockSetter, random, config, offsetPos.below(2).south(3).relative(direction, j1 + 1), 0, 0, false);
                    this.placeLeavesRow(reader, blockSetter, random, config, offsetPos.below(3).south(3).relative(direction, j1 + 1), 0, 0, false);
                    this.placeLeavesRow(reader, blockSetter, random, config, startingPos.north(2).relative(direction, k1), 0, 0, false);
                    this.placeLeavesRow(reader, blockSetter, random, config, startingPos.below().north(2).relative(direction, k1), 0, 0, false);
                    this.placeLeavesRow(reader, blockSetter, random, config, startingPos.below().north(3).relative(direction, k1), 0, 0, false);
                    this.placeLeavesRow(reader, blockSetter, random, config, startingPos.below().north(2).relative(direction, k1 + 1), 0, 0, false);
                    this.placeLeavesRow(reader, blockSetter, random, config, startingPos.below(2).north(3).relative(direction, k1 + 1), 0, 0, false);
                    this.placeLeavesRow(reader, blockSetter, random, config, startingPos.below(3).north(3).relative(direction, k1 + 1), 0, 0, false);
                }
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