package com.nerantaps.client.renderer;

import com.nerantaps.NerantaPs;
import com.nerantaps.client.NPModelLayers;
import com.nerantaps.client.model.WingSnakeModel;
import com.nerantaps.entity.monster.WingSnake;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class WingSnakeRenderer extends MobRenderer<WingSnake, WingSnakeModel<WingSnake>> {

    public WingSnakeRenderer(EntityRendererProvider.Context context) {
        super(context, new WingSnakeModel<>(context.bakeLayer(NPModelLayers.WING_SNAKE)), 1.0F);
    }

    @Override
    public ResourceLocation getTextureLocation(WingSnake pEntity) {
        return NerantaPs.prefix("textures/entity/wing_snake.png");
    }

}
