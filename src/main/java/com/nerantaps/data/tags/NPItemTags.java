package com.nerantaps.data.tags;

import com.nerantaps.NerantaPs;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class NPItemTags {

    public static final TagKey<Item> GLOW_LOGS = create("glow_logs");
    public static final TagKey<Item> CYCAS_LOGS = create("cycas_logs");
    public static final TagKey<Item> MAPLE_LOGS = create("maple_logs");
    public static final TagKey<Item> SULFUR_FIRE_BASE_BLOCKS = create("sulfur_fire_base_blocks");

    private static TagKey<Item> create(String name) {
        return ItemTags.create(NerantaPs.prefix(name));
    }

}