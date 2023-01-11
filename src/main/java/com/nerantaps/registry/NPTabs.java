package com.nerantaps.registry;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

@MethodsReturnNonnullByDefault
public class NPTabs {

    public static CreativeModeTab TAB_NERANTA_TAB_0 = new CreativeModeTab("neranta_tab_0") {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(NPBlocks.CYCAS_LEAVES.get());
        }

    };

    public static CreativeModeTab TAB_NERANTA_TAB_1 = new CreativeModeTab("neranta_tab_1") {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(NPItems.PURPLE_SWORD.get());
        }

    };

}