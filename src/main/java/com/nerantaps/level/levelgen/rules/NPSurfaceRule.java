package com.nerantaps.level.levelgen.rules;

import com.google.common.collect.ImmutableList;
import com.nerantaps.registry.NPBiomes;
import com.nerantaps.registry.NPBlocks;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

import static net.minecraft.data.worldgen.SurfaceRuleData.*;

public class NPSurfaceRule {

    private static final SurfaceRules.ConditionSource MIDDLE_UNDER_FLOOR = SurfaceRules.stoneDepthCheck(0, true, 4, CaveSurface.FLOOR);

    private static SurfaceRules.RuleSource createNormalRuleSource(ResourceKey<Biome> resourceKey, Block surfaceBlock, Block secondBlock) {
        return SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(resourceKey),
                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, makeStateRule(surfaceBlock)),
                SurfaceRules.ifTrue(SurfaceRules.waterStartCheck(-4, -1),
                        SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, makeStateRule(secondBlock)))))));
    }

    private static SurfaceRules.RuleSource createSpecialRuleSource(ResourceKey<Biome> resourceKey, Block b1, Block b2, Block b3, Block b4, int o1, int o2, int o3) {
        return SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(resourceKey),
                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, makeStateRule(b1)),
                        SurfaceRules.ifTrue(SurfaceRules.waterStartCheck(o1, 0),
                                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, makeStateRule(b2)))),
                        SurfaceRules.ifTrue(SurfaceRules.waterStartCheck(o2, 0),
                                SurfaceRules.sequence(SurfaceRules.ifTrue(MIDDLE_UNDER_FLOOR, makeStateRule(b3)))),
                        SurfaceRules.ifTrue(SurfaceRules.waterStartCheck(o3, 0),
                                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, makeStateRule(b4)))))));
    }

    public static SurfaceRules.RuleSource createSurfaceRule() {
        ImmutableList.Builder<SurfaceRules.RuleSource> builder = ImmutableList.builder();
        SurfaceRules.RuleSource ancientJungleRule = createSpecialRuleSource(NPBiomes.ANCIENT_JUNGLE,
                Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.MUD, Blocks.MUD, -3, -2, -1);
        SurfaceRules.RuleSource boneReefRule = createNormalRuleSource(NPBiomes.BONE_REEF, Blocks.AIR, Blocks.WATER);
        SurfaceRules.RuleSource volcanoRule = createNormalRuleSource(NPBiomes.VOLCANO, Blocks.SMOOTH_BASALT, Blocks.BASALT);
        SurfaceRules.RuleSource magnetDesertRule = createSpecialRuleSource(NPBiomes.MAGNET_DESERT,
                NPBlocks.IRON_SAND.get(), NPBlocks.IRON_SAND.get(), NPBlocks.IRON_SANDSTONE.get(), Blocks.BLACK_TERRACOTTA, -4, -1, 0);
        SurfaceRules.RuleSource fluorescentForestRule = createNormalRuleSource(NPBiomes.FLUORESCENT_FOREST, Blocks.GRASS_BLOCK, Blocks.DIRT);
        builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor",
                        VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK))
                .add(ancientJungleRule, boneReefRule, volcanoRule, magnetDesertRule, fluorescentForestRule);
        builder.add(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("deepslate",
                VerticalAnchor.absolute(0), VerticalAnchor.absolute(8)), DEEPSLATE));
        return SurfaceRules.sequence(builder.build().toArray(SurfaceRules.RuleSource[]::new));
    }

}