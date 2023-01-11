package com.nerantaps.items;

import com.nerantaps.registry.NPTabs;
import net.minecraft.world.item.Item;

public class Stripper extends Item {

    public Stripper() {
        super(new Item.Properties().tab(NPTabs.TAB_NERANTA_TAB_1).durability(64));
    }

}