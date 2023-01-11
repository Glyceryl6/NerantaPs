package com.nerantaps.data.provider;

import com.nerantaps.NerantaPs;
import com.nerantaps.data.tags.NPBlockTags;
import com.nerantaps.data.tags.NPItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class NPItemTagsProvider extends ItemTagsProvider {

    public NPItemTagsProvider(DataGenerator pGenerator, BlockTagsProvider pBlockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, pBlockTagsProvider, NerantaPs.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.copy(NPBlockTags.GLOW_LOGS, NPItemTags.GLOW_LOGS);
        this.copy(NPBlockTags.CYCAS_LOGS, NPItemTags.CYCAS_LOGS);
        this.copy(NPBlockTags.SULFUR_FIRE_BASE_BLOCKS, NPItemTags.SULFUR_FIRE_BASE_BLOCKS);
    }

}