package com.nerantaps.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class OceanTrenchCreate extends Block {

    public OceanTrenchCreate() {
        super(Properties.copy(Blocks.BEDROCK).noCollission().noOcclusion());
    }

}