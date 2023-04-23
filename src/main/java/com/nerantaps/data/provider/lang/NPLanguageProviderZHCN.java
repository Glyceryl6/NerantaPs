package com.nerantaps.data.provider.lang;

import com.nerantaps.NerantaPs;
import com.nerantaps.registry.NPItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class NPLanguageProviderZHCN extends LanguageProvider {

    public NPLanguageProviderZHCN(DataGenerator gen) {
        super(gen, NerantaPs.MOD_ID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        this.add(NPItems.KEY_OF_SURFACE.get(), "地表钥匙");
        this.add(NPItems.KEY_OF_DEEP.get(), "深层钥匙");
        this.add(NPItems.KEY_OF_NETHER.get(), "下界钥匙");
        this.add(NPItems.KEY_OF_DEEP_NETHER.get(), "下界深层钥匙");
        this.add(NPItems.SUCK_BLOOD_WART.get(), "吸血孢子");
        this.add(NPItems.CORRODE_WART.get(), "腐蚀孢子");
        this.add(NPItems.RAW_CHROMITE_ORE.get(), "粗铬铁矿");
        this.add(NPItems.CHROMITE_INGOT.get(), "铬铁锭");
        this.add(NPItems.CHROMITE_HELMET.get(), "铬铁头盔");
        this.add(NPItems.CHROMITE_CHESTPLATE.get(), "铬铁胸甲");
        this.add(NPItems.CHROMITE_LEGGINGS.get(), "铬铁护腿");
        this.add(NPItems.CHROMITE_BOOTS.get(), "铬铁靴子");
        this.add(NPItems.CHROMITE_SWORD.get(), "铬铁剑");
        this.add(NPItems.CHROMITE_PICKAXE.get(), "铬铁镐");
        this.add(NPItems.CHROMITE_SHOVEL.get(), "铬铁锹");
        this.add(NPItems.CHROMITE_AXE.get(), "铬铁斧");
        this.add(NPItems.CHROMITE_HOE.get(), "铬铁锄");
        this.add(NPItems.RUST.get(), "铁锈");
    }

}