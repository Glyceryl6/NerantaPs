package com.nerantaps.registry;

import com.nerantaps.NerantaPs;
import com.nerantaps.blocks.fluids.NascentLavaFluid;
import com.nerantaps.blocks.fluids.NascentLavaFluidType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fluids.FluidInteractionRegistry;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NPFluids {

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, NerantaPs.MOD_ID);
    public static final RegistryObject<FlowingFluid> NASCENT_LAVA = FLUIDS.register("nascent_lava", NascentLavaFluid.Source::new);
    public static final RegistryObject<FlowingFluid> FLOWING_NASCENT_LAVA = FLUIDS.register("flowing_nascent_lava", NascentLavaFluid.Flowing::new);

    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, NerantaPs.MOD_ID);
    public static final RegistryObject<FluidType> NASCENT_LAVA_TYPE = FLUID_TYPES.register("nascent_lava", NascentLavaFluidType::new);

    @SubscribeEvent
    public static void registerInteraction(FMLCommonSetupEvent event) {
        BlockState flowingNascentLavaState = NASCENT_LAVA.get().getFlowing().defaultFluidState().createLegacyBlock();
        FluidInteractionRegistry.addInteraction(NASCENT_LAVA_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(ForgeMod.WATER_TYPE.get(),
                fluidState -> fluidState.isSource() ? Blocks.OBSIDIAN.defaultBlockState() : Blocks.BASALT.defaultBlockState()));
        FluidInteractionRegistry.addInteraction(NASCENT_LAVA_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(ForgeMod.LAVA_TYPE.get(),
                fluidState -> fluidState.isSource() ? NPBlocks.NASCENT_LAVA.get().defaultBlockState() : flowingNascentLavaState));
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerRenderLayer(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(NASCENT_LAVA.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(FLOWING_NASCENT_LAVA.get(), RenderType.translucent());
    }

}