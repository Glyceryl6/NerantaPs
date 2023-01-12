package com.nerantaps.data.provider;

import com.nerantaps.NerantaPs;
import com.nerantaps.registry.NPBlocks;
import com.nerantaps.registry.NPItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class NPItemModelProvider extends ItemModelProvider {

    public NPItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, NerantaPs.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        this.basicItem(NPItems.STRIPPER.get());
        this.basicItem(NPItems.CYCAS_BARK.get());
        this.basicItem(NPItems.CYCAS_HELMET.get());
        this.basicItem(NPItems.CYCAS_CHESTPLATE.get());
        this.basicItem(NPItems.CYCAS_LEGGINGS.get());
        this.basicItem(NPItems.CYCAS_BOOTS.get());
        this.basicItem(NPItems.SULFUR_POWDER.get());
        this.basicItem(NPItems.DICYNODON_MEAT.get());
        this.basicItem(NPItems.IRON_SNAIL_SHELL.get());
        this.basicItem(NPItems.NASCENT_LAVA_BUCKET.get());
        this.basicItem(NPItems.COOKED_DICYNODON_MEAT.get());
        this.basicItem(NPBlocks.GLOW_DOOR.get().asItem());
        this.basicItem(NPBlocks.CYCAS_DOOR.get().asItem());
        this.spawnEggItem(NPItems.PALOLO_WORM_SPAWN_EGG.get());
        this.spawnEggItem(NPItems.IRON_SNAIL_SPAWN_EGG.get());
        this.spawnEggItem(NPItems.DICYNODON_SPAWN_EGG.get());
        this.spawnEggItem(NPItems.TUBE_WORM_SPAWN_EGG.get());
        this.spawnEggItem(NPItems.NAUTILUS_SPAWN_EGG.get());
        this.blockItem(NPBlocks.UNDERWATER_FUNGUS.getId());
        this.blockItem(NPBlocks.CYCAS_SAPLING.getId());
        this.blockItem(NPBlocks.GLOSSOPTERIS.getId());
        this.blockItem(NPBlocks.DESERT_BUSH.getId());
        this.blockItem(NPBlocks.ELDEN_FERN.getId());
        this.blockItem(NPBlocks.GLOW_MOSS.getId());
        this.blockItem(NPBlocks.GLOW_GRASS.getId());
        this.blockItem(NPBlocks.GLOW_SAPLING.getId());
        this.handheldItem(NPItems.PURPLE_SWORD.get());
    }

    private void spawnEggItem(Item item) {
        this.getBuilder(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath())
                .parent(new ModelFile.UncheckedModelFile("item/template_spawn_egg"));
    }

    @SuppressWarnings("unused")
    private void customItem(Item item, String parent, String type) {
        ResourceLocation resource = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item));
        this.withExistingParent(resource.getPath(), new ResourceLocation("item/" + parent))
                .texture("layer0", NerantaPs.prefix(type + "/" + resource.getPath()));
    }

    private void blockItem(ResourceLocation resource) {
        this.withExistingParent(resource.getPath(), new ResourceLocation("item/generated"))
                .texture("layer0", NerantaPs.prefix("block/" + resource.getPath()));
    }

    private void handheldItem(Item item) {
        ResourceLocation resource = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item));
        this.withExistingParent(resource.getPath(), new ResourceLocation("item/handheld"))
                .texture("layer0", NerantaPs.prefix("item/" + resource.getPath()));
    }

}