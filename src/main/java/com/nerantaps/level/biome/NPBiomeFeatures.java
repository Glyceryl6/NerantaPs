package com.nerantaps.level.biome;

import com.nerantaps.data.worldgen.placement.*;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.*;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

import static net.minecraft.world.level.levelgen.GenerationStep.Decoration.*;

public abstract class NPBiomeFeatures {

    public static BiomeGenerationSettings.Builder fluorescentForestFeature() {
        BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder();
        builder.addFeature(VEGETAL_DECORATION, NPVegetationPlacements.TREES_FLUORESCENT_FOREST);
        builder.addFeature(VEGETAL_DECORATION, NPVegetationPlacements.PATCH_GLOW_GRASS_2);
        builder.addFeature(VEGETAL_DECORATION, NPVegetationPlacements.PATCH_GLOW_MOSS);
        builder.addFeature(VEGETAL_DECORATION, NPVegetationPlacements.PATCH_ELDEN_FERN);
        builder.addFeature(VEGETAL_DECORATION, VegetationPlacements.FLOWER_DEFAULT);
        builder.addFeature(FLUID_SPRINGS, MiscOverworldPlacements.SPRING_WATER);
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND);
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CANYON);
        BiomeDefaultFeatures.addDefaultOres(builder);
        return builder;
    }

    public static BiomeGenerationSettings.Builder ancientJungleFeature() {
        BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder();
        builder.addFeature(VEGETAL_DECORATION, VegetationPlacements.BROWN_MUSHROOM_NORMAL);
        builder.addFeature(VEGETAL_DECORATION, VegetationPlacements.RED_MUSHROOM_NORMAL);
        builder.addFeature(VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_JUNGLE);
        builder.addFeature(VEGETAL_DECORATION, NPVegetationPlacements.TREE_ANCIENT_JUNGLE);
        builder.addFeature(VEGETAL_DECORATION, NPVegetationPlacements.TREES_CYCAS);
        builder.addFeature(VEGETAL_DECORATION, NPVegetationPlacements.NORMAL_OAK);
        builder.addFeature(VEGETAL_DECORATION, NPVegetationPlacements.ELDEN_TREES);
        builder.addFeature(VEGETAL_DECORATION, NPMiscPlacements.JUNGLE_MUSHROOM);
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND);
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CANYON);
        BiomeDefaultFeatures.addDefaultOres(builder);
        return builder;
    }

    public static BiomeGenerationSettings.Builder magnetDesertFeature() {
        BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder();
        builder.addFeature(SURFACE_STRUCTURES, NPMiscPlacements.MAGNETIC_STORM_VENT_PILLAR);
        builder.addFeature(VEGETAL_DECORATION, NPVegetationPlacements.PATCH_DESERT_BUSH);
        builder.addFeature(UNDERGROUND_ORES, NPOrePlacements.ORE_ENRICHED_IRON);
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addFossilDecoration(builder);
        BiomeDefaultFeatures.addDefaultOres(builder);
        return builder;
    }

    public static BiomeGenerationSettings.Builder boneReefFeature() {
        BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder();
        builder.addFeature(SURFACE_STRUCTURES, NPMiscPlacements.BONE_REEF_SMALL);
        builder.addFeature(VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_RIVER);
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CANYON);
        BiomeDefaultFeatures.addColdOceanExtraVegetation(builder);
        BiomeDefaultFeatures.addFossilDecoration(builder);
        BiomeDefaultFeatures.addMossyStoneBlock(builder);
        BiomeDefaultFeatures.addDefaultSeagrass(builder);
        BiomeDefaultFeatures.addDefaultOres(builder);
        return builder;
    }

    public static BiomeGenerationSettings.Builder volcanoFeature() {
        BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder();
        builder.addFeature(UNDERGROUND_ORES, NPOrePlacements.ORE_KIMBERLITE);
        builder.addFeature(UNDERGROUND_ORES, NPOrePlacements.ORE_SULFUR);
        builder.addFeature(UNDERGROUND_ORES, NPOrePlacements.ORE_BASALT);
        builder.addFeature(UNDERGROUND_ORES, NPMiscPlacements.DISK_GRAVEL);
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
        BiomeDefaultFeatures.addDefaultOres(builder);
        return builder;
    }

}