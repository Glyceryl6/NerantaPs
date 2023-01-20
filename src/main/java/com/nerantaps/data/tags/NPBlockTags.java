package com.nerantaps.data.tags;

import com.nerantaps.NerantaPs;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class NPBlockTags {

    public static final TagKey<Block> GLOW_LOGS = create("glow_logs");
    public static final TagKey<Block> CYCAS_LOGS = create("cycas_logs");
    public static final TagKey<Block> SULFUR_FIRE_BASE_BLOCKS = create("sulfur_fire_base_blocks");

    private static TagKey<Block> create(String name) {
        return BlockTags.create(NerantaPs.prefix(name));
    }

}