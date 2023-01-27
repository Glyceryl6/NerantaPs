package com.nerantaps.registry;

import com.nerantaps.NerantaPs;
import com.nerantaps.blocks.entity.MagneticStormVentEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NPBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, NerantaPs.MOD_ID);

    public static final RegistryObject<BlockEntityType<MagneticStormVentEntity>> MAGNETIC_STORM_VENT_ENTITY = BLOCK_ENTITY.register("magnetic_storm_vent_entity",
            () -> BlockEntityType.Builder.of(MagneticStormVentEntity::new, NPBlocks.MAGNETIC_STORM_VENT.get()).build(null));

}