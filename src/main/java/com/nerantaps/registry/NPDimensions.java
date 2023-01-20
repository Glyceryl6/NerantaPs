package com.nerantaps.registry;

import com.nerantaps.NerantaPs;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.OptionalLong;

public class NPDimensions {

    public static final DeferredRegister<DimensionType> DIMENSION_TYPES = DeferredRegister.create(Registry.DIMENSION_TYPE_REGISTRY, NerantaPs.MOD_ID);
    public static final RegistryObject<DimensionType> NERANTA_SURFACE_TYPE = DIMENSION_TYPES.register("neranta_surface_type", NPDimensions::nerantaSurfaceType);
    public static final RegistryObject<DimensionType> NERANTA_DEEP_TYPE = DIMENSION_TYPES.register("neranta_deep_type", NPDimensions::nerantaSurfaceType);
    public static final RegistryObject<DimensionType> NERANTA_NETHER_TYPE = DIMENSION_TYPES.register("neranta_nether_type", NPDimensions::nerantaSurfaceType);
    public static final RegistryObject<DimensionType> NERANTA_NETHER_DEEP_TYPE = DIMENSION_TYPES.register("neranta_nether_deep_type", NPDimensions::nerantaSurfaceType);

    public static final ResourceKey<Level> NERANTA_SURFACE = ResourceKey.create(Registry.DIMENSION_REGISTRY, NerantaPs.prefix("neranta_surface"));
    public static final ResourceKey<Level> NERANTA_DEEP = ResourceKey.create(Registry.DIMENSION_REGISTRY, NerantaPs.prefix("neranta_deep"));
    public static final ResourceKey<Level> NERANTA_NETHER = ResourceKey.create(Registry.DIMENSION_REGISTRY, NerantaPs.prefix("neranta_nether"));
    public static final ResourceKey<Level> NERANTA_NETHER_DEEP = ResourceKey.create(Registry.DIMENSION_REGISTRY, NerantaPs.prefix("neranta_nether_deep"));

    private static DimensionType nerantaSurfaceType() {
        return new DimensionType(OptionalLong.empty(), true, false, false, true,
                1.0D, true, false, -64, 320, 256,
                BlockTags.INFINIBURN_OVERWORLD, BuiltinDimensionTypes.OVERWORLD_EFFECTS, 0.0F,
                new DimensionType.MonsterSettings(false, true, UniformInt.of(0, 7), 0));
    }

}