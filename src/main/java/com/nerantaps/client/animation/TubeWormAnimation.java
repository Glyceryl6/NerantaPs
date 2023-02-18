package com.nerantaps.client.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TubeWormAnimation {

    public static final AnimationDefinition IDLE = AnimationDefinition.Builder.withLength(9.25f)
            .addAnimation("group3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.4583f, KeyframeAnimations.degreeVec(5f, 0f, 5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(5.25f, KeyframeAnimations.degreeVec(2.5f, 0f, 2.5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(7.375f, KeyframeAnimations.degreeVec(-2.5f, 0f, -5f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(9.0417f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("group", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.375f, KeyframeAnimations.posVec(0f, -10f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(5.5417f, KeyframeAnimations.posVec(0f, -10f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(9.0417f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition SWIM = AnimationDefinition.Builder.withLength(10f)
            .addAnimation("group3", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3f, KeyframeAnimations.degreeVec(5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(5.6667f, KeyframeAnimations.degreeVec(3.86f, 0f, 6.29f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(8.2917f, KeyframeAnimations.degreeVec(-2.5f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(10f, KeyframeAnimations.degreeVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("group", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(1.75f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(3.375f, KeyframeAnimations.posVec(0f, -2f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(5f, KeyframeAnimations.posVec(0f, -2f, 0f), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(7.0833f, KeyframeAnimations.posVec(0f, 0f, 0f), AnimationChannel.Interpolations.LINEAR))).build();

}