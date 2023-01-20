package com.nerantaps.registry;

import com.nerantaps.NerantaPs;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class NPBiomes {

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, NerantaPs.MOD_ID);
    public static final ResourceKey<Biome> FLUORESCENT_FOREST = makeKey("fluorescent_forest");
    public static final ResourceKey<Biome> ANCIENT_JUNGLE = makeKey("ancient_jungle");
    public static final ResourceKey<Biome> MAGNET_DESERT = makeKey("magnet_desert");
    public static final ResourceKey<Biome> BONE_REEF = makeKey("bone_reef");
    public static final ResourceKey<Biome> VOLCANO = makeKey("volcano");

    private static ResourceKey<Biome> makeKey(String name) {
        BIOMES.register(name, () -> new Biome.BiomeBuilder()
                .precipitation(Biome.Precipitation.NONE)
                .downfall(0).temperature(0)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .fogColor(0).waterColor(0)
                        .waterFogColor(0).skyColor(0).build())
                .generationSettings(new BiomeGenerationSettings.Builder().build())
                .mobSpawnSettings(new MobSpawnSettings.Builder().build())
                .temperatureAdjustment(Biome.TemperatureModifier.NONE).build());
        return ResourceKey.create(Registry.BIOME_REGISTRY, NerantaPs.prefix(name));
    }

}