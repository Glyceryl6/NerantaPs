package com.nerantaps;

import com.nerantaps.registry.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.Locale;

@Mod(NerantaPs.MOD_ID)
public class NerantaPs {

    public static final String MOD_ID = "neranta_ps";
    public IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

    public NerantaPs() {
        NPItems.ITEMS.register(this.eventBus);
        NPBlocks.BLOCKS.register(this.eventBus);
        NPBiomes.BIOMES.register(this.eventBus);
        NPFluids.FLUIDS.register(this.eventBus);
        NPFluids.FLUID_TYPES.register(this.eventBus);
        NPEffects.EFFECTS.register(this.eventBus);
        NPPotions.POTIONS.register(this.eventBus);
        NPFeatures.FEATURES.register(this.eventBus);
        NPEntities.ENTITY_TYPES.register(this.eventBus);
        NPNoises.NOISE_GENERATORS.register(this.eventBus);
        NPTrunkPlacer.TRUNK_PLACER.register(this.eventBus);
        NPParticles.PARTICLE_TYPES.register(this.eventBus);
        NPDimensions.DIMENSION_TYPES.register(this.eventBus);
        NPBlockEntities.BLOCK_ENTITY.register(this.eventBus);
        NPFoliagePlacer.FOLIAGE_PLACER.register(this.eventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static ResourceLocation prefix(String name) {
        return new ResourceLocation(MOD_ID, name.toLowerCase(Locale.ROOT));
    }

}