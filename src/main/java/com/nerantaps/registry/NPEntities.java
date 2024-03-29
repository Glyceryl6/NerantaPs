package com.nerantaps.registry;

import com.nerantaps.NerantaPs;
import com.nerantaps.client.renderer.*;
import com.nerantaps.entity.animal.*;
import com.nerantaps.entity.monster.PaloloWorm;
import com.nerantaps.entity.monster.RustSlug;
import com.nerantaps.entity.monster.WingSnake;
import com.nerantaps.entity.projectile.ThrownSplashBottleOfAlcohol;
import com.nerantaps.entity.projectile.ThrownSplashBottleOfSulfuricAcid;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NPEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, NerantaPs.MOD_ID);
    public static final RegistryObject<EntityType<PaloloWorm>> PALOLO_WORM = registerCreature("palolo_worm", PaloloWorm::new, MobCategory.MONSTER, 2.0F, 2.0F);
    public static final RegistryObject<EntityType<IronSnail>> IRON_SNAIL = registerCreature("iron_snail", IronSnail::new, MobCategory.CREATURE, 0.625F, 1.5F);
    public static final RegistryObject<EntityType<WingSnake>> WING_SNAKE = registerCreature("wing_snake", WingSnake::new, MobCategory.MONSTER, 1.0F, 2.0F);
    public static final RegistryObject<EntityType<Dicynodon>> DICYNODON = registerCreature("dicynodon", Dicynodon::new, MobCategory.CREATURE, 1.5F, 0.9F);
    public static final RegistryObject<EntityType<RustSlug>> RUST_SLUG = registerCreature("rust_slug", RustSlug::new, MobCategory.MONSTER, 0.625F, 1.25F);
    public static final RegistryObject<EntityType<TubeWorm>> TUBE_WORM = registerCreature("tube_worm", TubeWorm::new, MobCategory.CREATURE, 0.5F, 1.8F);
    public static final RegistryObject<EntityType<Nautilus>> NAUTILUS = registerCreature("nautilus", Nautilus::new, MobCategory.CREATURE, 1.0F, 0.75F);
    public static final RegistryObject<EntityType<HellBee>> HELL_BEE = registerCreature("hell_bee", HellBee::new, MobCategory.CREATURE, 0.7F, 0.6F);
    public static final RegistryObject<EntityType<ThrownSplashBottleOfSulfuricAcid>> THROWN_SPLASH_BOTTLE_OF_SULFURIC_ACID =
            register("thrown_splash_bottle_of_sulfuric_acid", ThrownSplashBottleOfSulfuricAcid::new, MobCategory.MISC, 0.25F, 0.25F);
    public static final RegistryObject<EntityType<ThrownSplashBottleOfAlcohol>> THROWN_SPLASH_BOTTLE_OF_ALCOHOL =
            register("thrown_splash_bottle_of_alcohol", ThrownSplashBottleOfAlcohol::new, MobCategory.MISC, 0.25F, 0.25F);

    private static <T extends Entity> RegistryObject<EntityType<T>> registerCreature(String name, EntityType.EntityFactory<T> factory, MobCategory category, float width, float height) {
        return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, category).sized(width, height).build(name));
    }

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, EntityType.EntityFactory<T> factory, MobCategory category, float width, float height) {
        return ENTITY_TYPES.register(name, () -> EntityType.Builder.of(factory, category).sized(width, height).updateInterval(10).build(name));
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void registerRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(THROWN_SPLASH_BOTTLE_OF_SULFURIC_ACID.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(THROWN_SPLASH_BOTTLE_OF_ALCOHOL.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(PALOLO_WORM.get(), PaloloWormRenderer::new);
        event.registerEntityRenderer(IRON_SNAIL.get(), IronSnailRenderer::new);
        event.registerEntityRenderer(WING_SNAKE.get(), WingSnakeRenderer::new);
        event.registerEntityRenderer(RUST_SLUG.get(), RustSlugRenderer::new);
        event.registerEntityRenderer(DICYNODON.get(), DicynodonRenderer::new);
        event.registerEntityRenderer(TUBE_WORM.get(), TubeWormRenderer::new);
        event.registerEntityRenderer(NAUTILUS.get(), NautilusRenderer::new);
        event.registerEntityRenderer(HELL_BEE.get(), HellBeeRenderer::new);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(PALOLO_WORM.get(), PaloloWorm.createAttributes().build());
        event.put(IRON_SNAIL.get(), IronSnail.createAttributes().build());
        event.put(DICYNODON.get(), Dicynodon.createAttributes().build());
        event.put(TUBE_WORM.get(), TubeWorm.createAttributes().build());
        event.put(NAUTILUS.get(), Nautilus.createAttributes().build());
        event.put(HELL_BEE.get(), HellBee.createAttributes().build());
    }

}