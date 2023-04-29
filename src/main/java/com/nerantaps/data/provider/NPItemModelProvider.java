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
        this.basicItem(NPItems.ASH.get());
        this.basicItem(NPItems.RUST.get());
        this.basicItem(NPItems.STRIPPER.get());
        this.basicItem(NPItems.MAPLE_SYRUP.get());
        this.basicItem(NPItems.WITHERED_LEAF.get());
        this.basicItem(NPItems.RUNIC_FRAGMENT.get());
        this.basicItem(NPItems.KEY_OF_SURFACE.get());
        this.basicItem(NPItems.KEY_OF_DEEP.get());
        this.basicItem(NPItems.KEY_OF_NETHER.get());
        this.basicItem(NPItems.KEY_OF_DEEP_NETHER.get());
        this.basicItem(NPItems.CYCAS_BARK.get());
        this.basicItem(NPItems.CYCAS_HELMET.get());
        this.basicItem(NPItems.CYCAS_CHESTPLATE.get());
        this.basicItem(NPItems.CYCAS_LEGGINGS.get());
        this.basicItem(NPItems.CYCAS_BOOTS.get());
        this.basicItem(NPItems.CHROMITE_INGOT.get());
        this.basicItem(NPItems.CHROMITE_HELMET.get());
        this.basicItem(NPItems.CHROMITE_CHESTPLATE.get());
        this.basicItem(NPItems.CHROMITE_LEGGINGS.get());
        this.basicItem(NPItems.CHROMITE_BOOTS.get());
        this.basicItem(NPItems.ETERNAL_STEEL.get());
        this.basicItem(NPItems.DRAGON_MARROW_HELMET.get());
        this.basicItem(NPItems.DRAGON_MARROW_CHESTPLATE.get());
        this.basicItem(NPItems.DRAGON_MARROW_LEGGINGS.get());
        this.basicItem(NPItems.DRAGON_MARROW_BOOTS.get());
        this.basicItem(NPItems.RAW_CHROMITE_ORE.get());
        this.basicItem(NPItems.SUCK_BLOOD_WART.get());
        this.basicItem(NPItems.CORRODE_WART.get());
        this.basicItem(NPItems.SULFUR_POWDER.get());
        this.basicItem(NPItems.DETOXIFY_SOUP.get());
        this.basicItem(NPItems.DICYNODON_MEAT.get());
        this.basicItem(NPItems.SLAG_CRAB_MEAT.get());
        this.basicItem(NPItems.SUSPENDOW_SCALE.get());
        this.basicItem(NPItems.GLOW_SLIME_BALL.get());
        this.basicItem(NPItems.IRON_SNAIL_SHELL.get());
        this.basicItem(NPItems.GIANT_MOSS_LEAVES.get());
        this.basicItem(NPItems.NASCENT_LAVA_BUCKET.get());
        this.basicItem(NPItems.COOKED_DICYNODON_MEAT.get());
        this.basicItem(NPItems.METEORITE_ICE_FRAGMENT.get());
        this.basicItem(NPItems.METEORITE_ICE_BOOMERANG.get());
        this.basicItem(NPItems.ALCOHOL_BUCKET.get());
        this.basicItem(NPItems.SULFURIC_ACID_BUCKET.get());
        this.basicItem(NPItems.BOTTLE_OF_ALCOHOL.get());
        this.basicItem(NPItems.BOTTLE_OF_SULFURIC_ACID.get());
        this.basicItem(NPItems.SPLASH_BOTTLE_OF_ALCOHOL.get());
        this.basicItem(NPItems.SPLASH_BOTTLE_OF_SULFURIC_ACID.get());
        this.basicItem(NPBlocks.GLOW_DOOR.get().asItem());
        this.basicItem(NPBlocks.CYCAS_DOOR.get().asItem());
        this.spawnEggItem(NPItems.PALOLO_WORM_SPAWN_EGG.get());
        this.spawnEggItem(NPItems.IRON_SNAIL_SPAWN_EGG.get());
        this.spawnEggItem(NPItems.WING_SNAKE_SPAWN_EGG.get());
        this.spawnEggItem(NPItems.DICYNODON_SPAWN_EGG.get());
        this.spawnEggItem(NPItems.RUST_SLUG_SPAWN_EGG.get());
        this.spawnEggItem(NPItems.TUBE_WORM_SPAWN_EGG.get());
        this.spawnEggItem(NPItems.NAUTILUS_SPAWN_EGG.get());
        this.spawnEggItem(NPItems.HELL_BEE_SPAWN_EGG.get());
        this.blockItem(NPBlocks.UNDERWATER_FUNGUS.getId());
        this.blockItem(NPBlocks.CYCAS_SAPLING.getId());
        this.blockItem(NPBlocks.MAPLE_SAPLING.getId());
        this.blockItem(NPBlocks.GLOSSOPTERIS.getId());
        this.blockItem(NPBlocks.DESERT_BUSH.getId());
        this.blockItem(NPBlocks.ELDEN_FERN.getId());
        this.blockItem(NPBlocks.GLOW_MOSS.getId());
        this.blockItem(NPBlocks.GLOW_GRASS.getId());
        this.blockItem(NPBlocks.GLOW_SAPLING.getId());
        this.handheldItem(NPItems.CHROMITE_SWORD.get());
        this.handheldItem(NPItems.CHROMITE_SHOVEL.get());
        this.handheldItem(NPItems.CHROMITE_PICKAXE.get());
        this.handheldItem(NPItems.CHROMITE_AXE.get());
        this.handheldItem(NPItems.CHROMITE_HOE.get());
        this.handheldItem(NPItems.ETERNAL_STEEL_SWORD.get());
        this.handheldItem(NPItems.ETERNAL_STEEL_SHOVEL.get());
        this.handheldItem(NPItems.ETERNAL_STEEL_PICKAXE.get());
        this.handheldItem(NPItems.ETERNAL_STEEL_AXE.get());
        this.handheldItem(NPItems.ETERNAL_STEEL_HOE.get());
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