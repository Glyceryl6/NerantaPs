package com.nerantaps.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class MagneticStormVent extends Block {

    public MagneticStormVent() {
        super(Properties.of(Material.STONE).sound(SoundType.STONE).strength(2.5f, 30f)
                .lightLevel(s -> 7).requiresCorrectToolForDrops().noOcclusion());
    }

}