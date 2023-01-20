package com.nerantaps.data.provider;

import com.nerantaps.NerantaPs;
import com.nerantaps.registry.NPBiomes;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class NPBiomeTagsProvider extends BiomeTagsProvider {

    public NPBiomeTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, NerantaPs.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(BiomeTags.HAS_MINESHAFT).add(NPBiomes.MAGNET_DESERT);
        this.tag(BiomeTags.HAS_JUNGLE_TEMPLE).add(NPBiomes.ANCIENT_JUNGLE);
        this.tag(BiomeTags.HAS_PILLAGER_OUTPOST).add(NPBiomes.FLUORESCENT_FOREST);
        this.tag(BiomeTags.HAS_RUINED_PORTAL_STANDARD).add(NPBiomes.FLUORESCENT_FOREST, NPBiomes.MAGNET_DESERT);
    }

}