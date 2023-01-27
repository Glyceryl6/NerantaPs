package com.nerantaps.registry;

import com.mojang.serialization.Codec;
import com.nerantaps.NerantaPs;
import com.nerantaps.level.levelgen.feature.tree.foliage.CycasFoliagePlacer;
import com.nerantaps.level.levelgen.feature.tree.foliage.EldenTreeFoliagePlacer;
import com.nerantaps.level.levelgen.feature.tree.foliage.MegaCycasFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NPFoliagePlacer {

    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER = DeferredRegister.create(ForgeRegistries.FOLIAGE_PLACER_TYPES, NerantaPs.MOD_ID);
    public static final RegistryObject<FoliagePlacerType<EldenTreeFoliagePlacer>> ELDEN_TREE_FOLIAGE_PLACER = register("elden_tree", EldenTreeFoliagePlacer.CODEC);
    public static final RegistryObject<FoliagePlacerType<CycasFoliagePlacer>> CYCAS_FOLIAGE_PLACER = register("cycas", CycasFoliagePlacer.CODEC);
    public static final RegistryObject<FoliagePlacerType<MegaCycasFoliagePlacer>> MEGA_CYCAS_FOLIAGE_PLACER = register("mega_cycas", MegaCycasFoliagePlacer.CODEC);

    private static <P extends FoliagePlacer> RegistryObject<FoliagePlacerType<P>> register(String name, Codec<P> codec) {
        return FOLIAGE_PLACER.register(name + "_foliage_placer", () -> new FoliagePlacerType<>(codec));
    }

}