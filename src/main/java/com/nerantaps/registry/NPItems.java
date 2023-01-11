package com.nerantaps.registry;

import com.nerantaps.NerantaPs;
import com.nerantaps.items.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.nerantaps.utils.NPItemUtils.normal;
import static com.nerantaps.utils.NPItemUtils.spawnEgg;

public class NPItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NerantaPs.MOD_ID);
    public static final RegistryObject<Item> PURPLE_SWORD = normal("purple_sword");
    public static final RegistryObject<Item> CYCAS_BARK = normal("cycas_bark");
    public static final RegistryObject<Item> SULFUR_POWDER = normal("sulfur_powder");
    public static final RegistryObject<Item> IRON_SNAIL_SHELL = normal("iron_snail_shell");
    public static final RegistryObject<Item> STRIPPER = ITEMS.register("stripper", Stripper::new);
    public static final RegistryObject<Item> CYCAS_HELMET = ITEMS.register("cycas_helmet", () -> new CycasArmor(EquipmentSlot.HEAD));
    public static final RegistryObject<Item> CYCAS_CHESTPLATE = ITEMS.register("cycas_chestplate", () -> new CycasArmor(EquipmentSlot.CHEST));
    public static final RegistryObject<Item> CYCAS_LEGGINGS = ITEMS.register("cycas_leggings", () -> new CycasArmor(EquipmentSlot.LEGS));
    public static final RegistryObject<Item> CYCAS_BOOTS = ITEMS.register("cycas_boots", () -> new CycasArmor(EquipmentSlot.FEET));
    public static final RegistryObject<Item> NASCENT_LAVA_BUCKET = ITEMS.register("nascent_lava_bucket", NascentLavaBucket::new);
    public static final RegistryObject<Item> DICYNODON_MEAT = ITEMS.register("dicynodon_meat", () -> new Item(new Item.Properties()
            .tab(NPTabs.TAB_NERANTA_TAB_1).food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.2f).meat().build())));
    public static final RegistryObject<Item> COOKED_DICYNODON_MEAT = ITEMS.register("cooked_dicynodon_meat", () -> new Item(new Item.Properties()
            .tab(NPTabs.TAB_NERANTA_TAB_1).food((new FoodProperties.Builder()).nutrition(7).saturationMod(0.8f).meat().build())));
    public static final RegistryObject<Item> PALOLO_WORM_SPAWN_EGG = spawnEgg("palolo_worm", NPEntities.PALOLO_WORM, -1452680, -8568564);
    public static final RegistryObject<Item> IRON_SNAIL_SPAWN_EGG = spawnEgg("iron_snail", NPEntities.IRON_SNAIL, -12562576, -12483893);
    public static final RegistryObject<Item> DICYNODON_SPAWN_EGG = spawnEgg("dicynodon", NPEntities.DICYNODON, -5473466, -861246);
    public static final RegistryObject<Item> TUBE_WORM_SPAWN_EGG = spawnEgg("tube_worm", NPEntities.TUBE_WORM, -396303, -2058882);
    public static final RegistryObject<Item> NAUTILUS_SPAWN_EGG = spawnEgg("nautilus", NPEntities.NAUTILUS, -1931413, -274495);

}