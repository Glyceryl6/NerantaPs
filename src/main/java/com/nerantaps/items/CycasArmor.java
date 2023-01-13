package com.nerantaps.items;

import com.nerantaps.registry.NPTabs;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class CycasArmor extends ArmorItem {

    public CycasArmor(EquipmentSlot slot) {
        super(NPArmorMaterial.CYCAS, slot, new Item.Properties().tab(NPTabs.TAB_NERANTA_TAB_1).fireResistant());
    }

    @Override
    public void appendHoverText(ItemStack itemstack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        list.add(Component.translatable("tips.cycas_armor_1"));
        list.add(Component.translatable("tips.cycas_armor_2"));
    }

}