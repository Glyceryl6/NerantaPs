package com.nerantaps.handler;

import com.nerantaps.NerantaPs;
import com.nerantaps.items.CycasArmor;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NerantaPs.MOD_ID)
public class EntityHandler {

    @SubscribeEvent
    public static void onLivingAttack(LivingAttackEvent event) {
        int armorCount = 0;
        if (event.getSource().isFire() && event.getEntity() instanceof Player player) {
            for (EquipmentSlot slots : EquipmentSlot.values()) {
                boolean flag1 = slots.getType() == EquipmentSlot.Type.ARMOR;
                boolean flag2 = player.getItemBySlot(slots).getItem() instanceof CycasArmor;
                if (flag1 && (armorCount += flag2 ? 1 : 0) == 4) {
                    player.clearFire();
                    event.setCanceled(true);
                }
            }
        }
    }

}