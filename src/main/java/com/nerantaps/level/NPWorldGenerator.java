package com.nerantaps.level;

import com.google.common.collect.ImmutableList;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.datafixers.util.Pair;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.*;
import com.nerantaps.NerantaPs;
import com.nerantaps.level.biome.builder.NPSurfaceBiomeBuilder;
import com.nerantaps.level.biome.NPBiomeMaker;
import com.nerantaps.registry.NPDimensions;
import com.nerantaps.registry.NPNoises;
import net.minecraft.core.*;
import net.minecraft.data.*;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public record NPWorldGenerator(DataGenerator generator) implements DataProvider {

    private static final Logger LOGGER = LogUtils.getLogger();
    private static final ResourceLocation NERANTA_SURFACE = NerantaPs.prefix("neranta_surface");
    private static final ResourceLocation NERANTA_DEEP = NerantaPs.prefix("neranta_deep");
    private static final ResourceLocation NERANTA_NETHER = NerantaPs.prefix("neranta_nether");
    private static final ResourceLocation NERANTA_NETHER_DEEP = NerantaPs.prefix("neranta_nether_deep");
    private static final ResourceKey<LevelStem> NERANTA_SURFACE_LEVEL_STEM = ResourceKey.create(Registry.LEVEL_STEM_REGISTRY, NERANTA_SURFACE);
    private static final ResourceKey<LevelStem> NERANTA_DEEP_LEVEL_STEM = ResourceKey.create(Registry.LEVEL_STEM_REGISTRY, NERANTA_DEEP);
    private static final ResourceKey<LevelStem> NERANTA_NETHER_LEVEL_STEM = ResourceKey.create(Registry.LEVEL_STEM_REGISTRY, NERANTA_NETHER);
    private static final ResourceKey<LevelStem> NERANTA_NETHER_DEEP_LEVEL_STEM = ResourceKey.create(Registry.LEVEL_STEM_REGISTRY, NERANTA_NETHER_DEEP);
    private static final MultiNoiseBiomeSource.Preset NERANTA_SURFACE_PRESET = new MultiNoiseBiomeSource.Preset(NERANTA_SURFACE, biomes -> {
        ImmutableList.Builder<Pair<Climate.ParameterPoint, Holder<Biome>>> builder = ImmutableList.builder();
        (new NPSurfaceBiomeBuilder()).addBiomes(pair -> builder.add(pair.mapSecond(biomes::getOrCreateHolderOrThrow)));
        return new Climate.ParameterList<>(builder.build());
    });

    @Override
    public void run(@NotNull CachedOutput cachedOutput) {
        Path path = this.generator.getOutputFolder();
        RegistryAccess registryAccess = BuiltinRegistries.ACCESS;
        Registry<LevelStem> neranta = this.registerNPSettings(registryAccess);
        DynamicOps<JsonElement> dynamicOps = RegistryOps.create(JsonOps.INSTANCE, registryAccess);
        WritableRegistry<Biome> biomesRegistry = new MappedRegistry<>(Registry.BIOME_REGISTRY, Lifecycle.experimental(), null);
        this.getBiomes().forEach((rl, biome) -> biomesRegistry.register(ResourceKey.create(Registry.BIOME_REGISTRY, rl), biome, Lifecycle.experimental()));
        StreamSupport.stream(RegistryAccess.knownRegistries().spliterator(), false)
                .filter(r -> registryAccess.ownedRegistry(r.key()).isPresent() && !r.key().equals(Registry.BIOME_REGISTRY))
                .forEach((data) -> dumpRegistryCap(cachedOutput, path, registryAccess, dynamicOps, data));
        dumpRegistry(path, cachedOutput, dynamicOps, Registry.BIOME_REGISTRY, biomesRegistry, Biome.DIRECT_CODEC);
        dumpRegistry(path, cachedOutput, dynamicOps, Registry.LEVEL_STEM_REGISTRY, neranta, LevelStem.CODEC);
    }

    private static <T> void dumpRegistryCap(CachedOutput cache, Path path, RegistryAccess access, DynamicOps<JsonElement> ops, RegistryAccess.RegistryData<T> data) {
        dumpRegistry(path, cache, ops, data.key(), access.ownedRegistryOrThrow(data.key()), data.codec());
    }

    private Registry<LevelStem> registerNPSettings(RegistryAccess access) {
        Registry<Biome> biomesRegistry = access.registryOrThrow(Registry.BIOME_REGISTRY);
        WritableRegistry<LevelStem> levelStemRegistry = new MappedRegistry<>(Registry.LEVEL_STEM_REGISTRY, Lifecycle.experimental(), null);
        if (NPDimensions.NERANTA_SURFACE_TYPE.getHolder().isPresent() && NPNoises.NERANTA_SURFACE_NOISE.getHolder().isPresent()) {
            levelStemRegistry.register(NERANTA_SURFACE_LEVEL_STEM, new LevelStem(NPDimensions.NERANTA_SURFACE_TYPE.getHolder().get(),
                    new NoiseBasedChunkGenerator(access.registryOrThrow(Registry.STRUCTURE_SET_REGISTRY), access.registryOrThrow(Registry.NOISE_REGISTRY),
                    NERANTA_SURFACE_PRESET.biomeSource(biomesRegistry, false), NPNoises.NERANTA_SURFACE_NOISE.getHolder().get())), Lifecycle.experimental());
        }
        return levelStemRegistry;
    }

    private static <E, T extends Registry<E>> void dumpRegistry(
            Path path, CachedOutput cache, DynamicOps<JsonElement> ops,
            ResourceKey<? extends T> key, T registry, Encoder<E> encoder) {
        for (Map.Entry<ResourceKey<E>, E> entry : registry.entrySet()) {
            if (entry.getKey().location().getNamespace().equals(NerantaPs.MOD_ID)) {
                Path otherPath = createPath(path, key.location(), entry.getKey().location());
                dumpValue(otherPath, cache, ops, encoder, entry.getValue());
            }
        }
    }

    private static <E> void dumpValue(Path path, CachedOutput cache, DynamicOps<JsonElement> ops, Encoder<E> encoder, E entry) {
        try {
            Optional<JsonElement> optional = encoder.encodeStart(ops, entry).resultOrPartial(
                    (s) -> LOGGER.error("Couldn't serialize element {}: {}", path, s));
            if (optional.isPresent()) {
                if (optional.get().isJsonObject()) {
                    JsonObject object = optional.get().getAsJsonObject();
                    if (object.has("generator") && object.get("generator").isJsonObject()) {
                        JsonObject generator = object.getAsJsonObject("generator");
                        generator.addProperty("seed", 0);
                    }
                }
                DataProvider.saveStable(cache, optional.get(), path);
            }
        } catch (IOException exception) {
            LOGGER.error("Couldn't save element {}", path, exception);
        }
    }

    private static Path createPath(Path path, ResourceLocation registry, ResourceLocation entry) {
        return path.resolve("data").resolve(entry.getNamespace()).resolve(registry.getPath()).resolve(entry.getPath() + ".json");
    }

    @Nonnull @Override
    public String getName() {
        return "Neranta World Generator";
    }

    private Map<ResourceLocation, Biome> getBiomes() {
        return NPBiomeMaker.BIOMES.entrySet().stream().collect(Collectors.toMap(entry -> entry.getKey().location(), Map.Entry::getValue));
    }

}