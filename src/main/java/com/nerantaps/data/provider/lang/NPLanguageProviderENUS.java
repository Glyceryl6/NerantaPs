package com.nerantaps.data.provider.lang;

import com.nerantaps.NerantaPs;
import com.nerantaps.registry.NPItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class NPLanguageProviderENUS extends LanguageProvider {

    public NPLanguageProviderENUS(DataGenerator gen) {
        super(gen, NerantaPs.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.add(NPItems.KEY_OF_SURFACE.get(), "Key Of Surface");
        this.add(NPItems.KEY_OF_DEEP.get(), "Key Of Deep");
        this.add(NPItems.KEY_OF_NETHER.get(), "Key Of Nether");
        this.add(NPItems.KEY_OF_DEEP_NETHER.get(), "Key Of Deep Nether");
        this.add(NPItems.SUCK_BLOOD_WART.get(), "Suck Blood Wart");
        this.add(NPItems.CORRODE_WART.get(), "Corrode Wart");
        this.add(NPItems.RAW_CHROMITE_ORE.get(), "Raw Chromite Ore");
        this.add(NPItems.CHROMITE_INGOT.get(), "Chromite Ingot");
        this.add(NPItems.CHROMITE_HELMET.get(), "Chromite Helmet");
        this.add(NPItems.CHROMITE_CHESTPLATE.get(), "Chromite Chestplate");
        this.add(NPItems.CHROMITE_LEGGINGS.get(), "Chromite Leggings");
        this.add(NPItems.CHROMITE_BOOTS.get(), "Chromite Boots");
        this.add(NPItems.CHROMITE_SWORD.get(), "Chromite Sword");
        this.add(NPItems.CHROMITE_PICKAXE.get(), "Chromite Pickaxe");
        this.add(NPItems.CHROMITE_SHOVEL.get(), "Chromite Shovel");
        this.add(NPItems.CHROMITE_AXE.get(), "Chromite Axe");
        this.add(NPItems.CHROMITE_HOE.get(), "Chromite Hoe");
        this.add(NPItems.RUST.get(), "Rust");
    }

}