package com.nerantaps.items;

import com.nerantaps.registry.NPTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SplashPotionItem;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.registries.RegistryObject;

public class SpecialSplashPotion extends SplashPotionItem {

    private final Potion potion;

    public SpecialSplashPotion(Potion potion) {
        super(new Properties().tab(NPTabs.TAB_NERANTA_TAB_1));
        this.potion = potion;
    }

    public SpecialSplashPotion(RegistryObject<Potion> potion) {
        super(new Properties().tab(NPTabs.TAB_NERANTA_TAB_1));
        this.potion = potion.get();
    }

    @Override
    public ItemStack getDefaultInstance() {
        return PotionUtils.setPotion(super.getDefaultInstance(), this.potion);
    }

}