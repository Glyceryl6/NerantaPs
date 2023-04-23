package com.nerantaps.data.provider;

import com.nerantaps.NerantaPs;
import com.nerantaps.data.tags.NPBlockTags;
import com.nerantaps.data.tags.NPItemTags;
import com.nerantaps.registry.NPItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeItemTagsProvider;
import org.jetbrains.annotations.Nullable;

public class NPItemTagsProvider extends ItemTagsProvider {

    public NPItemTagsProvider(DataGenerator generator, BlockTagsProvider blockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, blockTagsProvider, NerantaPs.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.copy(NPBlockTags.GLOW_LOGS, NPItemTags.GLOW_LOGS);
        this.copy(NPBlockTags.CYCAS_LOGS, NPItemTags.CYCAS_LOGS);
        this.copy(NPBlockTags.MAPLE_LOGS, NPItemTags.MAPLE_LOGS);
        this.copy(NPBlockTags.SULFUR_FIRE_BASE_BLOCKS, NPItemTags.SULFUR_FIRE_BASE_BLOCKS);
    }

}