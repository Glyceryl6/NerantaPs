package com.nerantaps.level.biome.builder;

import com.mojang.datafixers.util.Pair;
import com.nerantaps.registry.NPBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;

import java.util.function.Consumer;

@SuppressWarnings("unchecked")
public class NPSurfaceBiomeBuilder {

    private final Climate.Parameter[] temperatures = new Climate.Parameter[]{
            Climate.Parameter.span(-0.3833F, 0.5166F),
            Climate.Parameter.span(0.2F, 1.1333F),
            Climate.Parameter.span(0.5833F, 1.4166F),
            Climate.Parameter.span(0.0833F, 0.85F),
            Climate.Parameter.span(-0.45F, 0.45F),
            Climate.Parameter.span(-0.45F, -0.15F),
            Climate.Parameter.span(-0.15F, 0.2F),
            Climate.Parameter.span(-0.45F, 1.0F)};
    private final Climate.Parameter[] humidities = new Climate.Parameter[]{
            Climate.Parameter.span(-0.95F, 0.95F),
            Climate.Parameter.span(0.5333F, 1.4666F),
            Climate.Parameter.span(-1.4166F, -0.5833F),
            Climate.Parameter.span(0.6166F, 1.3833F),
            Climate.Parameter.span(-1.05F, -0.15F),
            Climate.Parameter.span(-1.0F, 1.0F),
            Climate.Parameter.span(-1.0F, 1.0F),
            Climate.Parameter.span(-1.0F, 1.0F)};
    private final Climate.Parameter[] continentalness = new Climate.Parameter[]{
            Climate.Parameter.span(0.03F, 0.3F),
            Climate.Parameter.span(0.11F, 0.375F),
            Climate.Parameter.span(0.09833F, 0.9316F),
            Climate.Parameter.span(-0.3833F, 0.3833F),
            Climate.Parameter.span(0.075F, 0.975F),
            Climate.Parameter.span(-0.455F, -0.19F),
            Climate.Parameter.span(-1.05F, -0.455F),
            Climate.Parameter.span(-0.19F, -0.11F)};
    private final Climate.Parameter[] erosions = new Climate.Parameter[]{
            Climate.Parameter.span(0.51F, 1.41F),
            Climate.Parameter.span(0.4833F, 1.4166F),
            Climate.Parameter.span(0.5333F, 1.3666F),
            Climate.Parameter.span(0.5666F, 1.3333F),
            Climate.Parameter.span(0.5F, 1.4F),
            Climate.Parameter.span(-1.0F, 1.0F),
            Climate.Parameter.span(-1.0F, 1.0F),
            Climate.Parameter.span(-1.0F, -0.375F)};
    private final Climate.Parameter[] weirdness = new Climate.Parameter[]{
            Climate.Parameter.span(-0.9328F, -0.0328F),
            Climate.Parameter.span(-0.9495F, -0.0162F),
            Climate.Parameter.span(-0.8995F, -0.0662F),
            Climate.Parameter.span(-0.8662F, -0.0995F),
            Climate.Parameter.span(-0.9328F, -0.0328F),
            Climate.Parameter.span(-1.0F, 1.0F),
            Climate.Parameter.span(-1.0F, 1.0F),
            Climate.Parameter.span(-0.05F, 0.05F)};
    private final ResourceKey<Biome>[] nerantaBiomes = new ResourceKey[]{
            NPBiomes.FLUORESCENT_FOREST, NPBiomes.ANCIENT_JUNGLE,
            NPBiomes.MAGNET_DESERT, NPBiomes.BONE_REEF, NPBiomes.VOLCANO};

    public void addBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer) {
        for (int i = 0; i < this.nerantaBiomes.length; i++) {
            consumer.accept(Pair.of(Climate.parameters(this.temperatures[i], this.humidities[i], this.continentalness[i], this.erosions[i],
                    Climate.Parameter.point(0.0F), this.weirdness[i], 0.0F), this.nerantaBiomes[i]));
        }
    }

}