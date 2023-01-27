package com.nerantaps.level.levelgen.feature.tree.trunk;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.nerantaps.registry.NPTrunkPlacer;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class FlatTopGiantTrunkPlacer extends TrunkPlacer {

    public static final Codec<FlatTopGiantTrunkPlacer> CODEC = RecordCodecBuilder.create((placer) ->
            trunkPlacerParts(placer).apply(placer, FlatTopGiantTrunkPlacer::new));

    public FlatTopGiantTrunkPlacer(int baseHeight, int heightRandA, int heightRandB) {
        super(baseHeight, heightRandA, heightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return NPTrunkPlacer.FLAT_TOP_GIANT_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader reader, BiConsumer<BlockPos, BlockState> blockSetter, RandomSource random, int maxFreeTreeHeight, BlockPos blockPos, TreeConfiguration config) {
        BlockPos blockpos = blockPos.below();
        setDirtAt(reader, blockSetter, random, blockpos, config);
        setDirtAt(reader, blockSetter, random, blockpos.east(), config);
        setDirtAt(reader, blockSetter, random, blockpos.south(), config);
        setDirtAt(reader, blockSetter, random, blockpos.south().east(), config);
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        for(int i = 0; i < maxFreeTreeHeight; ++i) {
            this.placeLogIfFreeWithOffset(reader, blockSetter, random, mutableBlockPos, config, blockPos, 0, i, 0);
            this.placeLogIfFreeWithOffset(reader, blockSetter, random, mutableBlockPos, config, blockPos, 1, i, 0);
            this.placeLogIfFreeWithOffset(reader, blockSetter, random, mutableBlockPos, config, blockPos, 1, i, 1);
            this.placeLogIfFreeWithOffset(reader, blockSetter, random, mutableBlockPos, config, blockPos, 0, i, 1);
        }

        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(blockPos.above(maxFreeTreeHeight), 0, true));
    }

    private void placeLogIfFreeWithOffset(LevelSimulatedReader reader, BiConsumer<BlockPos, BlockState> blockSetter,
                                          RandomSource random, BlockPos.MutableBlockPos mutableBlockPos, TreeConfiguration config,
                                          BlockPos blockPos, int offsetX, int offsetY, int offsetZ) {
        mutableBlockPos.setWithOffset(blockPos, offsetX, offsetY, offsetZ);
        this.placeLogIfFree(reader, blockSetter, random, mutableBlockPos, config);
    }

}