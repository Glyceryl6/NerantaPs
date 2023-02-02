package com.nerantaps.level.levelgen.rules;

import com.google.common.collect.ImmutableList;
import com.nerantaps.registry.NPBiomes;
import com.nerantaps.registry.NPBlocks;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

import static net.minecraft.data.worldgen.SurfaceRuleData.*;

public class NPSurfaceRule {

    private static final SurfaceRules.ConditionSource MIDDLE_UNDER_FLOOR = SurfaceRules.stoneDepthCheck(0, true, 4, CaveSurface.FLOOR);

    public static SurfaceRules.RuleSource createNormalRuleSource(ResourceKey<Biome> resourceKey, Block surfaceBlock, Block secondBlock, Block underwaterBlock) {
        return SurfaceRules.ifTrue(SurfaceRules.isBiome(resourceKey), SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(SurfaceRules.ifTrue(
                        SurfaceRules.waterBlockCheck(-1, 0), makeStateRule(surfaceBlock)),
                        makeStateRule(underwaterBlock))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, makeStateRule(secondBlock)))));
    }

    public static SurfaceRules.RuleSource createSurfaceRule() {
        ImmutableList.Builder<SurfaceRules.RuleSource> builder = ImmutableList.builder();
        SurfaceRules.RuleSource volcanoRule = createNormalRuleSource(NPBiomes.VOLCANO, Blocks.SMOOTH_BASALT, Blocks.BASALT, Blocks.GRAVEL);
        SurfaceRules.RuleSource ancientJungleRule = SurfaceRules.ifTrue(SurfaceRules.isBiome(NPBiomes.ANCIENT_JUNGLE),
                SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), SurfaceRules.sequence(
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(SurfaceRules.ifTrue(
                                SurfaceRules.waterBlockCheck(-1, 0),
                                makeStateRule(Blocks.GRASS_BLOCK)), makeStateRule(Blocks.DIRT))),
                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, makeStateRule(Blocks.DIRT)),
                        SurfaceRules.ifTrue(MIDDLE_UNDER_FLOOR, makeStateRule(Blocks.MUD)))));
        SurfaceRules.RuleSource magnetDesertRule = SurfaceRules.ifTrue(SurfaceRules.isBiome(NPBiomes.MAGNET_DESERT),
                SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(), SurfaceRules.sequence(
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.sequence(SurfaceRules.ifTrue(
                                SurfaceRules.waterBlockCheck(-1, 0),
                                makeStateRule(NPBlocks.IRON_SAND.get())), makeStateRule(Blocks.GRAVEL))),
                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, makeStateRule(NPBlocks.IRON_SAND.get())),
                        SurfaceRules.ifTrue(MIDDLE_UNDER_FLOOR, makeStateRule(NPBlocks.IRON_SANDSTONE.get())),
                        SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR, makeStateRule(Blocks.BLACK_TERRACOTTA)))));
        builder.add(volcanoRule, ancientJungleRule, magnetDesertRule, overworld());
        return SurfaceRules.sequence(builder.build().toArray(SurfaceRules.RuleSource[]::new));
    }

}