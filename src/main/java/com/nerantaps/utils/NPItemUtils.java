package com.nerantaps.utils;

import com.nerantaps.registry.NPItems;
import com.nerantaps.registry.NPTabs;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class NPItemUtils {

    public static RegistryObject<Item> normal(String name) {
        return NPItems.ITEMS.register(name, () -> new Item(defaultBuilder()));
    }

    public static RegistryObject<Item> alias(String name, RegistryObject<Block> block) {
        return NPItems.ITEMS.register(name, () -> new ItemNameBlockItem(block.get(), defaultBuilder()));
    }

    public static RegistryObject<Item> spawnEgg(String name, Supplier<? extends EntityType<? extends Mob>> type, int backgroundColor, int highlightColor) {
        return NPItems.ITEMS.register(name + "_spawn_egg", () -> new ForgeSpawnEggItem(type, backgroundColor, highlightColor, defaultBuilder()));
    }

    private static Item.Properties defaultBuilder() {
        return new Item.Properties().tab(NPTabs.TAB_NERANTA_TAB_1);
    }

}