package com.nerantaps.handler;

import com.nerantaps.NerantaPs;
import com.nerantaps.blocks.SulfurFire;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NerantaPs.MOD_ID)
public class BlockHandler {

    @SubscribeEvent
    public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
        BlockPos blockPos = event.getPos();
        LevelAccessor level = event.getLevel();
        if (event.getPlacedBlock().is(Blocks.FIRE.defaultBlockState().getBlock())) {
            level.setBlock(blockPos, SulfurFire.getState(level, blockPos), 3);
        }
    }

}
