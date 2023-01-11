package com.nerantaps.items;

import com.nerantaps.NerantaPs;
import com.nerantaps.registry.NPItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public enum NPArmorMaterial implements ArmorMaterial {

    CYCAS("cycas", new int[]{156, 180, 192, 132}, new int[]{1, 4, 5, 2}, 9, SoundEvents.ARMOR_EQUIP_GENERIC,
            0.0F, 0.0F, () -> Ingredient.of(new ItemStack(NPItems.CYCAS_BARK.get())));

    private final String name;
    private final int[] slotDurability;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    NPArmorMaterial(String name, int[] slotDurability, int[] slotProtections, int enchantmentValue, SoundEvent soundEvent,
                     float toughness, float knockbackResistance, Supplier<Ingredient> supplier) {
        this.repairIngredient = new LazyLoadedValue<>(supplier);
        this.knockbackResistance = knockbackResistance;
        this.enchantmentValue = enchantmentValue;
        this.slotProtections = slotProtections;
        this.slotDurability = slotDurability;
        this.toughness = toughness;
        this.sound = soundEvent;
        this.name = name;
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlot slot) {
        return this.slotDurability[slot.getIndex()];
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot) {
        return this.slotProtections[slot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.sound;
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
