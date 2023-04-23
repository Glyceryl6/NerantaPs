package com.nerantaps.blocks.fluids;

import com.nerantaps.registry.NPFluids;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class Alcohol extends LiquidBlock {
    
    public Alcohol() {
        super(NPFluids.ALCOHOL, BlockBehaviour.Properties.of(Material.WATER)
                .strength(100f).noCollission().noLootTable());
    }

}