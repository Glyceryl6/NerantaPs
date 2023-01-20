package com.nerantaps.level.levelgen.feature;

import com.nerantaps.NerantaPs;
import com.nerantaps.registry.NPDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.CountConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import java.util.List;

public class UniversalVolcano extends Feature<CountConfiguration> {

    private final List<Block> baseBlocks = List.of(Blocks.SMOOTH_BASALT, Blocks.GRAVEL);

    public UniversalVolcano() {
        super(CountConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<CountConfiguration> context) {
        ServerLevel level = context.level().getLevel();
        if (level.dimension() == NPDimensions.NERANTA_SURFACE) {
            ResourceLocation resource = NerantaPs.prefix("volcano_" + context.config().count());
            StructureTemplate template = level.getStructureManager().getOrCreate(resource);
            if (context.random().nextInt(100000) <= 4000) {
                int i = context.origin().getX() + context.random().nextInt(16);
                int k = context.origin().getZ() + context.random().nextInt(16);
                int j = context.level().getHeight(Heightmap.Types.OCEAN_FLOOR_WG, i, k);
                BlockPos pos = new BlockPos(i, j, k), pos1 = pos.below(5);
                if (!this.baseBlocks.contains(context.level().getBlockState(pos).getBlock())) {
                    boolean flag1 = level.getBlockState(pos1).isAir();
                    boolean flag2 = flag1 && level.getBlockState(pos1.west(8).north(8)).isAir();
                    BlockPos spawnTo = new BlockPos(i - 8, j - 4, k - 8);
                    switch (Integer.parseInt(String.valueOf(context.config().count()))) {
                        case 1 -> {
                            spawnTo = new BlockPos(i - 6, j - 4, k - 6);
                            flag2 = flag1 && level.getBlockState(pos1.west(8).north(8)).isAir();
                        }
                        case 2 -> {
                            spawnTo = new BlockPos(i - 6, j - 4, k - 6);
                            flag2 = flag1 && level.getBlockState(pos1.west(6).north(6)).isAir();
                        }
                        case 3 -> {
                            spawnTo = new BlockPos(i - 4, j - 3, k - 4);
                            flag1 = level.getBlockState(pos1.above()).isAir();
                            flag2 = flag1 && level.getBlockState(pos1.west(4).north(4).above()).isAir();
                        }
                    }
                    return flag2 && template.placeInWorld(context.level(), spawnTo, spawnTo, new StructurePlaceSettings()
                            .setMirror(Mirror.NONE).setRotation(Rotation.NONE).setRandom(context.random())
                            .addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK).setIgnoreEntities(false), context.random(), 2);
                }
            }
        }
        return false;
    }

}