package com.nerantaps.data.tags;

import com.nerantaps.NerantaPs;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class NPBiomeTags {

    private static TagKey<Biome> create(String name) {
        return TagKey.create(Registry.BIOME_REGISTRY, NerantaPs.prefix(name));
    }

}