package com.nerantaps.registry;

import com.nerantaps.NerantaPs;
import com.nerantaps.level.effect.NPMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NPEffects {

    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, NerantaPs.MOD_ID);
    public static final RegistryObject<MobEffect> DRUNKENNESS = EFFECTS.register("drunkenness", () -> new NPMobEffect(MobEffectCategory.NEUTRAL, 0xdbcadb, false));
    public static final RegistryObject<MobEffect> SANGUINARY = EFFECTS.register("sanguinary", () -> new NPMobEffect(MobEffectCategory.HARMFUL, 0xa60219, false));
    public static final RegistryObject<MobEffect> CORRODE = EFFECTS.register("corrode", () -> new NPMobEffect(MobEffectCategory.HARMFUL, 0x03ae96, true));

}