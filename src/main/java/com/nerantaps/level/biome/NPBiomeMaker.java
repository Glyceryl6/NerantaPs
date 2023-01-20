package com.nerantaps.level.biome;

import com.google.common.collect.ImmutableMap;
import com.nerantaps.registry.NPBiomes;
import com.nerantaps.registry.NPEntities;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;

import java.util.Map;

public class NPBiomeMaker extends NPBiomeFeatures {

    public static final Map<ResourceKey<Biome>, Biome> BIOMES = generateBiomes();

    private static Map<ResourceKey<Biome>, Biome> generateBiomes() {
        final ImmutableMap.Builder<ResourceKey<Biome>, Biome> biomes = ImmutableMap.builder();
        generateFluorescentForest(biomes);
        generateAncientJungle(biomes);
        generateMagnetDesert(biomes);
        generateBoneReef(biomes);
        generateVolcano(biomes);
        return biomes.build();
    }

    private static void generateFluorescentForest(ImmutableMap.Builder<ResourceKey<Biome>, Biome> biomes) {
        MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-8716328).waterColor(4159204).waterFogColor(329011)
                .skyColor(-8716328).foliageColorOverride(-16673694).grassColorOverride(-16540054).build();
        mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.STRAY, 10, 4, 4));
        mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 10, 4, 4));
        mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIE, 10, 4, 4));
        mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 10, 4, 4));
        mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 10, 4, 4));
        mobSpawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 10, 4, 4));
        mobSpawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 10, 4, 4));
        mobSpawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        biomes.put(NPBiomes.FLUORESCENT_FOREST, new Biome.BiomeBuilder().temperature(0.1F).downfall(0.2F).precipitation(Biome.Precipitation.RAIN)
                .specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build()).generationSettings(fluorescentForestFeature().build()).build());
    }

    private static void generateAncientJungle(ImmutableMap.Builder<ResourceKey<Biome>, Biome> biomes) {
        MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-9653384).waterColor(4159204).waterFogColor(329011)
                .skyColor(-9653384).foliageColorOverride(-9653384).grassColorOverride(-9653384).build();
        mobSpawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CAT, 3, 1, 4));
        mobSpawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 5, 1, 4));
        mobSpawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PARROT, 5, 1, 4));
        mobSpawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 1, 4));
        mobSpawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(NPEntities.DICYNODON.get(), 8, 2, 4));
        biomes.put(NPBiomes.ANCIENT_JUNGLE, new Biome.BiomeBuilder().temperature(1.5F).downfall(1.0F).precipitation(Biome.Precipitation.RAIN)
                .specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build()).generationSettings(ancientJungleFeature().build()).build());
    }

    private static void generateMagnetDesert(ImmutableMap.Builder<ResourceKey<Biome>, Biome> biomes) {
        MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011)
                .skyColor(7972607).foliageColorOverride(10387789).grassColorOverride(9470285).build();
        mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.HUSK, 20, 1, 4));
        mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SPIDER, 9, 1, 2));
        mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.CREEPER, 9, 1, 2));
        mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SKELETON, 20, 1, 4));
        mobSpawnInfo.addSpawn(MobCategory.MISC, new MobSpawnSettings.SpawnerData(NPEntities.IRON_SNAIL.get(), 30, 2, 3));
        biomes.put(NPBiomes.MAGNET_DESERT, new Biome.BiomeBuilder().temperature(2.0F).downfall(0.0F).precipitation(Biome.Precipitation.NONE)
                .specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build()).generationSettings(magnetDesertFeature().build()).build());
    }

    private static void generateBoneReef(ImmutableMap.Builder<ResourceKey<Biome>, Biome> biomes) {
        MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011)
                .skyColor(7972607).foliageColorOverride(10387789).grassColorOverride(9470285).build();
        mobSpawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PUFFERFISH, 10, 3, 5));
        mobSpawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH, 10, 3, 5));
        mobSpawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.TURTLE, 5, 1, 4));
        biomes.put(NPBiomes.BONE_REEF, new Biome.BiomeBuilder().temperature(1.2F).downfall(1.0F).precipitation(Biome.Precipitation.RAIN)
                .specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build()).generationSettings(boneReefFeature().build()).build());
    }

    private static void generateVolcano(ImmutableMap.Builder<ResourceKey<Biome>, Biome> biomes) {
        MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(12638463).waterColor(4159204).waterFogColor(329011)
                .skyColor(7972607).foliageColorOverride(10387789).grassColorOverride(9470285).build();
        biomes.put(NPBiomes.VOLCANO, new Biome.BiomeBuilder().temperature(0.5F).downfall(0.2F).precipitation(Biome.Precipitation.RAIN)
                .specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build()).generationSettings(volcanoFeature().build()).build());
    }

}