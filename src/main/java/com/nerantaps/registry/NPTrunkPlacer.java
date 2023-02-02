package com.nerantaps.registry;

import com.mojang.serialization.Codec;
import com.nerantaps.NerantaPs;
import com.nerantaps.level.levelgen.feature.tree.trunk.FlatTopGiantTrunkPlacer;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class NPTrunkPlacer {

    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER = DeferredRegister.create(Registry.TRUNK_PLACER_TYPE_REGISTRY, NerantaPs.MOD_ID);
    public static final RegistryObject<TrunkPlacerType<FlatTopGiantTrunkPlacer>> FLAT_TOP_GIANT_TRUNK_PLACER = register("flat_top_giant", FlatTopGiantTrunkPlacer.CODEC);

    private static <P extends TrunkPlacer> RegistryObject<TrunkPlacerType<P>> register(String name, Codec<P> codec) {
        return TRUNK_PLACER.register(name + "_trunk_placer", () -> new TrunkPlacerType<>(codec));
    }

}