package com.nerantaps.client.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class IronSnailAnimation {

    public static final AnimationDefinition IN_SHELL = AnimationDefinition.Builder.withLength(10f)
            .addAnimation("shell", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f),
                            AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.posVec(0f, -2f, 0f),
                            AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(8f, KeyframeAnimations.posVec(0f, -2f, 0f),
                            AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(9f, KeyframeAnimations.posVec(0f, 0f, 0f),
                            AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("shell", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                            AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(15f, 0f, 0f),
                            AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.5f, KeyframeAnimations.degreeVec(15f, 0f, 0f),
                            AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(8f, KeyframeAnimations.degreeVec(15f, 0f, 0f),
                            AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(10f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                            AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                            AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.posVec(0f, 1f, 0f),
                            AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.posVec(0f, 3f, 1f),
                            AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(8f, KeyframeAnimations.posVec(0f, 3f, 1f),
                            AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(9f, KeyframeAnimations.posVec(0f, 1f, 0f),
                            AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(10f, KeyframeAnimations.posVec(0f, 0f, 0f),
                            AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                            AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(40f, 0f, 0f),
                            AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(90f, 0f, 0f),
                            AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2.5f, KeyframeAnimations.degreeVec(90f, 0f, 0f),
                            AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(8f, KeyframeAnimations.degreeVec(90f, 0f, 0f),
                            AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(9f, KeyframeAnimations.degreeVec(40f, 0f, 0f),
                            AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(10f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                            AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("ass", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                            AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.posVec(0f, 3f, 0f),
                            AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.posVec(0f, 5f, 0f),
                            AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(8f, KeyframeAnimations.posVec(0f, 5f, 0f),
                            AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(9f, KeyframeAnimations.posVec(0f, 3f, 0f),
                            AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(10f, KeyframeAnimations.posVec(0f, 0f, 0f),
                            AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("ass", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                            AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1f, KeyframeAnimations.degreeVec(-35f, 0f, 0f),
                            AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(2f, KeyframeAnimations.degreeVec(-67.5f, 0f, 0f),
                            AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(8f, KeyframeAnimations.degreeVec(-67.5f, 0f, 0f),
                            AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(9f, KeyframeAnimations.degreeVec(-35f, 0f, 0f),
                            AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(10f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                            AnimationChannel.Interpolations.LINEAR))).build();

}