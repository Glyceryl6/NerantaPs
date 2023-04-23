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
    public static final RegistryObject<Potion> IRONFORT = register("ironfort", MobEffects.DAMAGE_RESISTANCE, 900, 0);
    public static final RegistryObject<Potion> LONG_IRONFORT = register("long_ironfort", MobEffects.DAMAGE_RESISTANCE, 1800, 0);
    public static final RegistryObject<Potion> STRONG_IRONFORT = register("strong_ironfort", MobEffects.DAMAGE_RESISTANCE, 440, 3);
    public static final RegistryObject<Potion> LEVITATION = register("levitation", MobEffects.LEVITATION, 3600, 0);
    public static final RegistryObject<Potion> LONG_LEVITATION = register("long_levitation", MobEffects.LEVITATION, 9600, 0);
    public static final RegistryObject<Potion> SANGUINARY = register("sanguinary", NPEffects.SANGUINARY, 600, 0);
    public static final RegistryObject<Potion> CORRODE = register("corrode", NPEffects.CORRODE, 1, 0);

    //Register new potion that use vanilla effect.
    private static RegistryObject<Potion> register(String name, MobEffect effect, int duration, int amplifier) {
        return POTIONS.register(name, () -> new Potion(new MobEffectInstance(effect, duration, amplifier)));
    }

    //Register new potion that use mod's effect.
    private static RegistryObject<Potion> register(String name, RegistryObject<MobEffect> effect, int duration, int amplifier) {
        return POTIONS.register(name, () -> new Potion(new MobEffectInstance(effect.get(), duration, amplifier)));
    }

    @SubscribeEvent
    public static void registerBrewingRecipes(FMLCommonSetupEvent event) {
        PotionBrewing.addContainerRecipe(NPItems.BOTTLE_OF_SULFURIC_ACID.get(), Items.GUNPOWDER, NPItems.SPLASH_BOTTLE_OF_SULFURIC_ACID.get());
        PotionBrewing.addContainerRecipe(NPItems.BOTTLE_OF_ALCOHOL.get(), Items.GUNPOWDER, NPItems.SPLASH_BOTTLE_OF_ALCOHOL.get());
        PotionBrewing.addContainerRecipe(Items.SPLASH_POTION, NPItems.SUCK_BLOOD_WART.get(), NPItems.SANGUINARY_POTION.get());
        PotionBrewing.addContainerRecipe(Items.SPLASH_POTION, NPItems.CORRODE_WART.get(), NPItems.CORRODE_POTION.get());
        PotionBrewing.addMix(Potions.AWKWARD, NPItems.IRON_SNAIL_SHELL.get(), IRONFORT.get());
        PotionBrewing.addMix(IRONFORT.get(), Items.REDSTONE, LONG_IRONFORT.get());
        PotionBrewing.addMix(IRONFORT.get(), Items.GLOWSTONE_DUST, STRONG_IRONFORT.get());
        PotionBrewing.addMix(Potions.AWKWARD, NPItems.SUSPENDOW_SCALE.get(), LEVITATION.get());
        PotionBrewing.addMix(LEVITATION.get(), Items.REDSTONE, LONG_LEVITATION.get());
    }

}