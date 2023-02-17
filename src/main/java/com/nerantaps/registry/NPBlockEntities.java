package com.nerantaps.registry;

import com.nerantaps.NerantaPs;
import com.nerantaps.blocks.entity.MagneticStormVentEntity;
import com.nerantaps.blocks.entity.PaloloWormHoleEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NPBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, NerantaPs.MOD_ID);

    public static final RegistryObject<BlockEntityType<MagneticStormVentEntity>> MAGNETIC_STORM_VENT_ENTITY = BLOCK_ENTITY.register("magnetic_storm_vent_entity",
            () -> BlockEntityType.Builder.of(MagneticStormVentEntity::new, NPBlocks.MAGNETIC_STORM_VENT.get()).build(null));
    public static final RegistryObject<BlockEntityType<PaloloWormHoleEntity>> PALOLO_WORM_HOLE_ENTITY = BLOCK_ENTITY.register("palolo_worm_hole_entity",
            () -> BlockEntityType.Builder.of(PaloloWormHoleEntity::new, NPBlocks.PALOLO_WORM_HOLE.get()).build(null));

}