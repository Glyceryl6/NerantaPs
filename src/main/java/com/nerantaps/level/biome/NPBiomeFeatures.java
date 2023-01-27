package com.nerantaps.level.biome;

import com.nerantaps.data.worldgen.placement.NPMiscPlacements;
import com.nerantaps.data.worldgen.placement.NPVegetationPlacements;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public abstract class NPBiomeFeatures {

    public static BiomeGenerationSettings.Builder fluorescentForestFeature() {
        BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder();
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NPVegetationPlacements.TREES_FLUORESCENT_FOREST);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NPVegetationPlacements.PATCH_GLOW_GRASS_2);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NPVegetationPlacements.PATCH_GLOW_MOSS);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NPVegetationPlacements.PATCH_ELDEN_FERN);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.FLOWER_DEFAULT);
        builder.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, MiscOverworldPlacements.SPRING_WATER);
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND);
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CANYON);
        BiomeDefaultFeatures.addDefaultOres(builder);
        return builder;
    }

    public static BiomeGenerationSettings.Builder ancientJungleFeature() {
        BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder();
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.BROWN_MUSHROOM_NORMAL);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.RED_MUSHROOM_NORMAL);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_JUNGLE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NPVegetationPlacements.TREE_ANCIENT_JUNGLE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NPVegetationPlacements.TREES_CYCAS);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NPVegetationPlacements.NORMAL_OAK);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NPVegetationPlacements.ELDEN_TREES);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NPMiscPlacements.JUNGLE_MUSHROOM);
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND);
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CANYON);
        BiomeDefaultFeatures.addDefaultOres(builder);
        return builder;
    }

    public static BiomeGenerationSettings.Builder magnetDesertFeature() {
        BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder();
        builder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, NPMiscPlacements.MAGNETIC_STORM_VENT_PILLAR);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, NPVegetationPlacements.PATCH_DESERT_BUSH);
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addFossilDecoration(builder);
        BiomeDefaultFeatures.addDefaultOres(builder);
        return builder;
    }

    public static BiomeGenerationSettings.Builder boneReefFeature() {
        BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.addFossilDecoration(builder);
        BiomeDefaultFeatures.addMossyStoneBlock(builder);
        BiomeDefaultFeatures.addDefaultSeagrass(builder);
        BiomeDefaultFeatures.addDefaultOres(builder);
        return builder;
    }

    public static BiomeGenerationSettings.Builder volcanoFeature() {
        BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder();
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, NPMiscPlacements.DISK_GRAVEL);
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
        BiomeDefaultFeatures.addDefaultOres(builder);
        return builder;
    }

}