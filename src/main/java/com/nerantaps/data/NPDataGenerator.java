package com.nerantaps.data;

import com.nerantaps.NerantaPs;
import com.nerantaps.data.provider.*;
import com.nerantaps.level.NPWorldGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NerantaPs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NPDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper exFileHelper = event.getExistingFileHelper();
        generator.addProvider(event.includeServer(), new NPBlockStateProvider(generator, exFileHelper));
        generator.addProvider(event.includeServer(), new NPItemModelProvider(generator, exFileHelper));
        NPBlockTagsProvider blockTagsProvider = new NPBlockTagsProvider(generator, exFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new NPItemTagsProvider(generator, blockTagsProvider, exFileHelper));
        generator.addProvider(event.includeServer(), new NPBiomeTagsProvider(generator, exFileHelper));
        generator.addProvider(event.includeServer(), new NPLootTableProvider(generator));
        generator.addProvider(event.includeServer(), new NPRecipeProvider(generator));
        generator.addProvider(event.includeServer(), new NPWorldGenerator(generator));
    }

}