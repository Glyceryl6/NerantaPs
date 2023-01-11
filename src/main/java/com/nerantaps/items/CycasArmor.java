package com.nerantaps.items;

import com.nerantaps.registry.NPTabs;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class CycasArmor extends ArmorItem {

    public CycasArmor(EquipmentSlot slot) {
        super(NPArmorMaterial.CYCAS, slot, new Item.Properties().tab(NPTabs.TAB_NERANTA_TAB_1).fireResistant());
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        list.add(Component.translatable("tips.cycas_armor_1"));
        list.add(Component.translatable("tips.cycas_armor_2"));
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        for (EquipmentSlot slots : EquipmentSlot.values()) {
            if (player.getItemBySlot(slots).is(this)) {
                player.clearFire();
            }
        }
    }

}