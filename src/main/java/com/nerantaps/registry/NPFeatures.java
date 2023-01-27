package com.nerantaps.registry;

import com.nerantaps.NerantaPs;
import com.nerantaps.level.levelgen.feature.JungleMushroom;
import com.nerantaps.level.levelgen.feature.MagneticStormVentPillar;
import com.nerantaps.level.levelgen.feature.PatchDesertBush;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NPFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, NerantaPs.MOD_ID);
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> JUNGLE_MUSHROOM = FEATURES.register("jungle_mushroom", JungleMushroom::new);
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> PATCH_DESERT_BUSH  = FEATURES.register("patch_desert_bush", PatchDesertBush::new);
    public static final RegistryObject<Feature<NoneFeatureConfiguration>> MAGNETIC_STORM_VENT_PILLAR = FEATURES.register("magnetic_storm_vent_pillar", MagneticStormVentPillar::new);

}