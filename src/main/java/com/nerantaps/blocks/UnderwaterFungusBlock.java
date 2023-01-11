package com.nerantaps.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class UnderwaterFungusBlock extends Block {

    public UnderwaterFungusBlock() {
        super(Properties.of(Material.DIRT).sound(SoundType.GRAVEL).strength(0.5F, 0.2F));
    }

}