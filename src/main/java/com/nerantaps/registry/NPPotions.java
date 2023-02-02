package com.nerantaps.registry;

import com.nerantaps.NerantaPs;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NPPotions {

    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, NerantaPs.MOD_ID);
    public static final RegistryObject<Potion> IMPREGNABLE = register("impregnable", MobEffects.DAMAGE_RESISTANCE, 900, 0);
    public static final RegistryObject<Potion> LONG_IMPREGNABLE = register("long_impregnable", MobEffects.DAMAGE_RESISTANCE, 1800, 0);
    public static final RegistryObject<Potion> STRONG_IMPREGNABLE = register("strong_impregnable", MobEffects.DAMAGE_RESISTANCE, 450, 1);

    private static RegistryObject<Potion> register(String name, MobEffect effect, int duration, int amplifier) {
        return POTIONS.register(name, () -> new Potion(new MobEffectInstance(effect, duration, amplifier)));
    }

    @SubscribeEvent
    public static void registerBrewingRecipes(FMLCommonSetupEvent event) {
        PotionBrewing.addMix(Potions.AWKWARD, NPItems.IRON_SNAIL_SHELL.get(), IMPREGNABLE.get());
        PotionBrewing.addMix(IMPREGNABLE.get(), Items.REDSTONE, LONG_IMPREGNABLE.get());
        PotionBrewing.addMix(IMPREGNABLE.get(), Items.GLOWSTONE_DUST, STRONG_IMPREGNABLE.get());
    }

}