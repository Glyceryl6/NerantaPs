package com.nerantaps.core;

import com.nerantaps.registry.NPBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NPBlockCompat {

    @SubscribeEvent
    @SuppressWarnings("deprecation")
    public static void registerColors(FMLClientSetupEvent event) {
        Minecraft minecraft = Minecraft.getInstance();
        BlockColors blockColors = minecraft.getBlockColors();
        blockColors.register((state, level, pos, tintIndex) ->
                0xd0d0b8, NPBlocks.SULFURIC_ACID.get());
    }

    @SubscribeEvent
    public static void registerFlammable(FMLCommonSetupEvent event) {
        FireBlock fireblock = (FireBlock) Blocks.FIRE;
        fireblock.setFlammable(NPBlocks.STRIPPED_GLOW_LOG.get(), 5, 5);
        fireblock.setFlammable(NPBlocks.STRIPPED_GLOW_WOOD.get(), 5, 5);
        fireblock.setFlammable(NPBlocks.GLOW_LEAVES.get(), 30, 60);
        fireblock.setFlammable(NPBlocks.GLOW_LOG.get(), 5, 5);
        fireblock.setFlammable(NPBlocks.GLOW_WOOD.get(), 5, 5);
        fireblock.setFlammable(NPBlocks.GLOW_PLANKS.get(), 5, 20);
        fireblock.setFlammable(NPBlocks.GLOW_SLAB.get(), 5, 20);
        fireblock.setFlammable(NPBlocks.GLOW_FENCE.get(), 5, 20);
        fireblock.setFlammable(NPBlocks.GLOW_STAIRS.get(), 5, 20);
        fireblock.setFlammable(NPBlocks.GLOW_FENCE_GATE.get(), 5, 20);
        fireblock.setFlammable(NPBlocks.STRIPPED_MAPLE_LOG.get(), 5, 5);
        fireblock.setFlammable(NPBlocks.STRIPPED_MAPLE_WOOD.get(), 5, 5);
        fireblock.setFlammable(NPBlocks.MAPLE_LEAVES.get(), 30, 60);
        fireblock.setFlammable(NPBlocks.MAPLE_LOG.get(), 5, 5);
        fireblock.setFlammable(NPBlocks.MAPLE_WOOD.get(), 5, 5);
        fireblock.setFlammable(NPBlocks.MAPLE_PLANKS.get(), 5, 20);
        fireblock.setFlammable(NPBlocks.MAPLE_SLAB.get(), 5, 20);
        fireblock.setFlammable(NPBlocks.MAPLE_FENCE.get(), 5, 20);
        fireblock.setFlammable(NPBlocks.MAPLE_STAIRS.get(), 5, 20);
        fireblock.setFlammable(NPBlocks.MAPLE_FENCE_GATE.get(), 5, 20);
        fireblock.setFlammable(NPBlocks.ELDEN_FERN.get(), 60, 100);
        fireblock.setFlammable(NPBlocks.GLOSSOPTERIS.get(), 60, 100);
    }

}