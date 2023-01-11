package com.nerantaps.data.tags;

import com.nerantaps.NerantaPs;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class NPItemTags {

    public static final TagKey<Item> GLOW_LOGS = create("glow_logs");
    public static final TagKey<Item> CYCAS_LOGS = create("cycas_logs");
    public static final TagKey<Item> SULFUR_FIRE_BASE_BLOCKS = create("sulfur_fire_base_blocks");

    private static TagKey<Item> create(String name) {
        return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(NerantaPs.MOD_ID, name));
    }

}
