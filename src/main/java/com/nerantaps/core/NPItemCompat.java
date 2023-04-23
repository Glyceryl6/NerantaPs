package com.nerantaps.core;

import com.nerantaps.registry.NPItems;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NPItemCompat {

    @SubscribeEvent
    public static void registerCompostables(FMLCommonSetupEvent event) {
        ComposterBlock.add(0.5F, NPItems.ASH.get());
        ComposterBlock.add(1.0F, NPItems.WITHERED_LEAF.get());
    }

}