package com.nerantaps.registry;

import com.nerantaps.NerantaPs;
import com.nerantaps.items.*;
import com.nerantaps.utils.NPItemTiers;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.nerantaps.utils.NPItemUtils.*;

@MethodsReturnNonnullByDefault
public class NPItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NerantaPs.MOD_ID);
    public static final RegistryObject<Item> KEY_OF_SURFACE = normal("key_of_surface");
    public static final RegistryObject<Item> KEY_OF_DEEP = normal("key_of_deep");
    public static final RegistryObject<Item> KEY_OF_NETHER = normal("key_of_nether");
    public static final RegistryObject<Item> KEY_OF_DEEP_NETHER = normal("key_of_deep_nether");
    public static final RegistryObject<Item> SUCK_BLOOD_WART = normal("suck_blood_wart");
    public static final RegistryObject<Item> CORRODE_WART = normal("corrode_wart");
    public static final RegistryObject<Item> RUST = normal("rust");
    public static final RegistryObject<Item> CYCAS_BARK = normal("cycas_bark");
    public static final RegistryObject<Item> PURPLE_SWORD = normal("purple_sword");
    public static final RegistryObject<Item> SULFUR_POWDER = normal("sulfur_powder");
    public static final RegistryObject<Item> WITHERED_LEAF = normal("withered_leaf");
    public static final RegistryObject<Item> ETERNAL_STEEL = normal("eternal_steel");
    public static final RegistryObject<Item> CHROMITE_INGOT = normal("chromite_ingot");
    public static final RegistryObject<Item> RUNIC_FRAGMENT = normal("runic_fragment");
    public static final RegistryObject<Item> SUSPENDOW_SCALE = normal("suspendow_scale");
    public static final RegistryObject<Item> GLOW_SLIME_BALL = normal("glow_slime_ball");
    public static final RegistryObject<Item> RAW_CHROMITE_ORE = normal("raw_chromite_ore");
    public static final RegistryObject<Item> IRON_SNAIL_SHELL = normal("iron_snail_shell");
    public static final RegistryObject<Item> GIANT_MOSS_LEAVES = normal("giant_moss_leaves");
    public static final RegistryObject<Item> METEORITE_ICE_FRAGMENT = normal("meteorite_ice_fragment");
    public static final RegistryObject<Item> METEORITE_ICE_BOOMERANG = normal("meteorite_ice_boomerang");
    public static final RegistryObject<Item> BOTTLE_OF_ALCOHOL = ITEMS.register("bottle_of_alcohol", BottleOfAlcohol::new);
    public static final RegistryObject<Item> SPLASH_BOTTLE_OF_ALCOHOL = ITEMS.register("splash_bottle_of_alcohol", SplashBottleOfAlcohol::new);
    public static final RegistryObject<Item> BOTTLE_OF_SULFURIC_ACID = ITEMS.register("bottle_of_sulfuric_acid",
            () -> new Item((defaultBuilder()).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> SPLASH_BOTTLE_OF_SULFURIC_ACID = ITEMS.register("splash_bottle_of_sulfuric_acid", SplashBottleOfSulfuricAcid::new);
    public static final RegistryObject<Item> SANGUINARY_POTION = ITEMS.register("sanguinary_potion", () -> new SplashPotionItem(defaultBuilder()) {
        @Override
        public ItemStack getDefaultInstance() {
            return PotionUtils.setPotion(super.getDefaultInstance(), NPPotions.SANGUINARY.get());
        }
    });
    public static final RegistryObject<Item> CORRODE_POTION = ITEMS.register("corrode_potion", () -> new SplashPotionItem(defaultBuilder()) {
        @Override
        public ItemStack getDefaultInstance() {
            return PotionUtils.setPotion(super.getDefaultInstance(), NPPotions.CORRODE.get());
        }
    });
    public static final RegistryObject<Item> ASH = ITEMS.register("ash", () -> new Item(defaultBuilder().fireResistant()));
    public static final RegistryObject<Item> SULFURIC_ACID_BUCKET = ITEMS.register("sulfuric_acid_bucket", () -> new BucketItem(
            NPFluids.SULFURIC_ACID, defaultBuilder().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> ALCOHOL_BUCKET = ITEMS.register("alcohol_bucket", () -> new BucketItem(
            NPFluids.ALCOHOL, defaultBuilder().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> NASCENT_LAVA_BUCKET = ITEMS.register("nascent_lava_bucket", () -> new BucketItem(
            NPFluids.NASCENT_LAVA, defaultBuilder().craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryObject<Item> STRIPPER = ITEMS.register("stripper", Stripper::new);
    //Cycas Armors
    public static final RegistryObject<Item> CYCAS_HELMET = ITEMS.register("cycas_helmet", () -> new CycasArmor(EquipmentSlot.HEAD));
    public static final RegistryObject<Item> CYCAS_CHESTPLATE = ITEMS.register("cycas_chestplate", () -> new CycasArmor(EquipmentSlot.CHEST));
    public static final RegistryObject<Item> CYCAS_LEGGINGS = ITEMS.register("cycas_leggings", () -> new CycasArmor(EquipmentSlot.LEGS));
    public static final RegistryObject<Item> CYCAS_BOOTS = ITEMS.register("cycas_boots", () -> new CycasArmor(EquipmentSlot.FEET));
    //Dragon Marrow Armors
    public static final RegistryObject<Item> DRAGON_MARROW_HELMET = ITEMS.register("dragon_marrow_helmet",
            () -> new ArmorItem(NPArmorMaterial.DRAGON_MARROW, EquipmentSlot.HEAD, defaultBuilder()));
    public static final RegistryObject<Item> DRAGON_MARROW_CHESTPLATE = ITEMS.register("dragon_marrow_chestplate",
            () -> new ArmorItem(NPArmorMaterial.DRAGON_MARROW, EquipmentSlot.CHEST, defaultBuilder()));
    public static final RegistryObject<Item> DRAGON_MARROW_LEGGINGS = ITEMS.register("dragon_marrow_leggings",
            () -> new ArmorItem(NPArmorMaterial.DRAGON_MARROW, EquipmentSlot.LEGS, defaultBuilder()));
    public static final RegistryObject<Item> DRAGON_MARROW_BOOTS = ITEMS.register("dragon_marrow_boots",
            () -> new ArmorItem(NPArmorMaterial.DRAGON_MARROW, EquipmentSlot.FEET, defaultBuilder()));
    //Chromite Armors and Tools
    public static final RegistryObject<Item> CHROMITE_HELMET = ITEMS.register("chromite_helmet",
            () -> new ArmorItem(NPArmorMaterial.CHROMITE, EquipmentSlot.HEAD, defaultBuilder()));
    public static final RegistryObject<Item> CHROMITE_CHESTPLATE = ITEMS.register("chromite_chestplate",
            () -> new ArmorItem(NPArmorMaterial.CHROMITE, EquipmentSlot.CHEST, defaultBuilder()));
    public static final RegistryObject<Item> CHROMITE_LEGGINGS = ITEMS.register("chromite_leggings",
            () -> new ArmorItem(NPArmorMaterial.CHROMITE, EquipmentSlot.LEGS, defaultBuilder()));
    public static final RegistryObject<Item> CHROMITE_BOOTS = ITEMS.register("chromite_boots",
            () -> new ArmorItem(NPArmorMaterial.CHROMITE, EquipmentSlot.FEET, defaultBuilder()));
    public static final RegistryObject<Item> CHROMITE_SWORD = ITEMS.register("chromite_sword",
            () -> new SwordItem(NPItemTiers.CHROMITE, 3, -2.4F, defaultBuilder()));
    public static final RegistryObject<Item> CHROMITE_SHOVEL = ITEMS.register("chromite_shovel",
            () -> new ShovelItem(NPItemTiers.CHROMITE, 1.5F, -3.0F, defaultBuilder()));
    public static final RegistryObject<Item> CHROMITE_PICKAXE = ITEMS.register("chromite_pickaxe",
            () -> new PickaxeItem(NPItemTiers.CHROMITE, 1, -2.8F, defaultBuilder()));
    public static final RegistryObject<Item> CHROMITE_AXE = ITEMS.register("chromite_axe",
            () -> new AxeItem(NPItemTiers.CHROMITE, 7.0F, -3.2F, defaultBuilder()));
    public static final RegistryObject<Item> CHROMITE_HOE = ITEMS.register("chromite_hoe",
            () -> new HoeItem(NPItemTiers.CHROMITE, -2, -1.0F, defaultBuilder()));
    //Eternal Tools
    public static final RegistryObject<Item> ETERNAL_STEEL_SWORD = ITEMS.register("eternal_steel_sword",
            () -> new SwordItem(NPItemTiers.ETERNAL, 3, -2.4F, defaultBuilder()));
    public static final RegistryObject<Item> ETERNAL_STEEL_SHOVEL = ITEMS.register("eternal_steel_shovel",
            () -> new ShovelItem(NPItemTiers.ETERNAL, 1.5F, -3.0F, defaultBuilder()));
    public static final RegistryObject<Item> ETERNAL_STEEL_PICKAXE = ITEMS.register("eternal_steel_pickaxe",
            () -> new PickaxeItem(NPItemTiers.ETERNAL, 1, -2.8F, defaultBuilder()));
    public static final RegistryObject<Item> ETERNAL_STEEL_AXE = ITEMS.register("eternal_steel_axe",
            () -> new AxeItem(NPItemTiers.ETERNAL, 9.0F, -3.2F, defaultBuilder()));
    public static final RegistryObject<Item> ETERNAL_STEEL_HOE = ITEMS.register("eternal_steel_hoe",
            () -> new HoeItem(NPItemTiers.ETERNAL, -4, -0.0F, defaultBuilder()));
    //Foods
    public static final RegistryObject<Item> DICYNODON_MEAT = ITEMS.register("dicynodon_meat", () -> new Item(new Item.Properties()
            .tab(NPTabs.TAB_NERANTA_TAB_1).food((new FoodProperties.Builder()).nutrition(2).saturationMod(0.2f).meat().build())));
    public static final RegistryObject<Item> COOKED_DICYNODON_MEAT = ITEMS.register("cooked_dicynodon_meat", () -> new Item(new Item.Properties()
            .tab(NPTabs.TAB_NERANTA_TAB_1).food((new FoodProperties.Builder()).nutrition(7).saturationMod(0.8f).meat().build())));
    public static final RegistryObject<Item> SLAG_CRAB_MEAT = ITEMS.register("slag_crab_meat", () -> new Item(new Item.Properties().fireResistant()
            .tab(NPTabs.TAB_NERANTA_TAB_1).food((new FoodProperties.Builder()).nutrition(4).saturationMod(2.0F).build())));
    public static final RegistryObject<Item> DETOXIFY_SOUP = ITEMS.register("detoxify_soup", DetoxifySoup::new);
    public static final RegistryObject<Item> MAPLE_SYRUP = ITEMS.register("maple_syrup", MapleSyrup::new);
    //Spawn Eggs
    public static final RegistryObject<Item> PALOLO_WORM_SPAWN_EGG = spawnEgg("palolo_worm", NPEntities.PALOLO_WORM, -1452680, -8568564);
    public static final RegistryObject<Item> IRON_SNAIL_SPAWN_EGG = spawnEgg("iron_snail", NPEntities.IRON_SNAIL, -12562576, -12483893);
    public static final RegistryObject<Item> DICYNODON_SPAWN_EGG = spawnEgg("dicynodon", NPEntities.DICYNODON, -5473466, -861246);
    public static final RegistryObject<Item> TUBE_WORM_SPAWN_EGG = spawnEgg("tube_worm", NPEntities.TUBE_WORM, -396303, -2058882);
    public static final RegistryObject<Item> NAUTILUS_SPAWN_EGG = spawnEgg("nautilus", NPEntities.NAUTILUS, -1931413, -274495);

}