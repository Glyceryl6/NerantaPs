package com.nerantaps.registry;

import com.nerantaps.NerantaPs;
import com.nerantaps.level.levelgen.rules.NPSurfaceRule;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.NoiseRouterData;
import net.minecraft.world.level.levelgen.NoiseSettings;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class NPNoises {

    public static final DeferredRegister<NoiseGeneratorSettings> NOISE_GENERATORS = DeferredRegister.create(Registry.NOISE_GENERATOR_SETTINGS_REGISTRY, NerantaPs.MOD_ID);
    public static final RegistryObject<NoiseGeneratorSettings> NERANTA_SURFACE_NOISE = NOISE_GENERATORS.register("neranta_surface_noise", NPNoises::nerantaSurfaceNoise);
    public static final RegistryObject<NoiseGeneratorSettings> NERANTA_DEEP_NOISE = NOISE_GENERATORS.register("neranta_deep_noise", NPNoises::nerantaSurfaceNoise);
    public static final RegistryObject<NoiseGeneratorSettings> NERANTA_NETHER_NOISE = NOISE_GENERATORS.register("neranta_nether_noise", NPNoises::nerantaSurfaceNoise);
    public static final RegistryObject<NoiseGeneratorSettings> NERANTA_NETHER_DEEP_NOISE = NOISE_GENERATORS.register("neranta_nether_deep_noise", NPNoises::nerantaSurfaceNoise);

    private static NoiseGeneratorSettings nerantaSurfaceNoise() {
        final NoiseSettings NOISE_SETTINGS = NoiseSettings.create(-64, 256, 2, 1);
        return new NoiseGeneratorSettings(NOISE_SETTINGS, Blocks.STONE.defaultBlockState(), Blocks.WATER.defaultBlockState(),
                NoiseRouterData.overworld(BuiltinRegistries.DENSITY_FUNCTION, false, false), NPSurfaceRule.createSurfaceRule(),
                List.of(), 63, false, true, true, false);
    }

}