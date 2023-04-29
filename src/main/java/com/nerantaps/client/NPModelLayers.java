package com.nerantaps.client;

import com.nerantaps.NerantaPs;
import com.nerantaps.client.model.*;
import net.minecraft.client.model.BeeModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NerantaPs.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NPModelLayers {

    public static final ModelLayerLocation PALOLO_WORM = register("palolo_worm");
    public static final ModelLayerLocation IRON_SNAIL = register("iron_snail");
    public static final ModelLayerLocation WING_SNAKE = register("wing_snake");
    public static final ModelLayerLocation RUST_SLUG = register("rust_slug");
    public static final ModelLayerLocation DICYNODON = register("dicynodon");
    public static final ModelLayerLocation TUBE_WORM = register("tube_worm");
    public static final ModelLayerLocation NAUTILUS = register("nautilus");
    public static final ModelLayerLocation HELL_BEE = register("hell_bee");

    private static ModelLayerLocation register(String path) {
        return new ModelLayerLocation(NerantaPs.prefix(path), "main");
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(PALOLO_WORM, PaloloWormModel::createBodyLayer);
        event.registerLayerDefinition(IRON_SNAIL, IronSnailModel::createBodyLayer);
        event.registerLayerDefinition(WING_SNAKE, WingSnakeModel::createBodyLayer);
        event.registerLayerDefinition(RUST_SLUG, RustSlugModel::createBodyLayer);
        event.registerLayerDefinition(DICYNODON, DicynodonModel::createBodyLayer);
        event.registerLayerDefinition(TUBE_WORM, TubeWormModel::createBodyLayer);
        event.registerLayerDefinition(NAUTILUS, NautilusModel::createBodyLayer);
        event.registerLayerDefinition(HELL_BEE, BeeModel::createBodyLayer);
    }

}