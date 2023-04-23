package com.nerantaps.items;

import com.nerantaps.NerantaPs;
import com.nerantaps.registry.NPItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum NPArmorMaterial implements ArmorMaterial {

    DRAGON_MARROW("dragon_marrow", new int[]{156, 180, 192, 132}, new int[]{3, 6, 8, 2}, 15, SoundEvents.ARMOR_EQUIP_IRON,
            2.0F, 0.0F, () -> Ingredient.of()),
    CHROMITE("chromite", new int[]{156, 180, 192, 132}, new int[]{2, 5, 7, 2}, 14, SoundEvents.ARMOR_EQUIP_IRON,
            1.0F, 0.0F, () -> Ingredient.of(new ItemStack(NPItems.CHROMITE_INGOT.get()))),
    CYCAS("cycas", new int[]{156, 180, 192, 132}, new int[]{1, 4, 5, 2}, 9, SoundEvents.ARMOR_EQUIP_GENERIC,
            0.0F, 0.0F, () -> Ingredient.of(new ItemStack(NPItems.CYCAS_BARK.get())));

    private final String name;
    private final int[] durability;
    private final int[] defense;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    NPArmorMaterial(String name, int[] durability, int[] defense, int enchantmentValue, SoundEvent equipSound,
                    float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durability = durability;
        this.defense = defense;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlot slot) {
        return this.durability[slot.getIndex()];
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot) {
        return this.defense[slot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return NerantaPs.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

}