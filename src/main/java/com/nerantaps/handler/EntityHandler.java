package com.nerantaps.handler;

import com.nerantaps.NerantaPs;
import com.nerantaps.entity.ai.JohnnyAttackGoal;
import com.nerantaps.items.CycasArmor;
import com.nerantaps.items.NPArmorMaterial;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
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
    
    @SubscribeEvent
    public static void onPlayerTicking(TickEvent.PlayerTickEvent event) {
        int armorCount = 0;
        Player player = event.player;
        for (EquipmentSlot slots : EquipmentSlot.values()) {
            Item slotItems = player.getItemBySlot(slots).getItem();
            boolean flag1 = slots.getType() == EquipmentSlot.Type.ARMOR;
            boolean flag2 = slotItems instanceof ArmorItem armorItem &&
                    armorItem.getMaterial() == NPArmorMaterial.DRAGON_MARROW;
            if (flag1 && (armorCount += flag2 ? 1 : 0) == 4) {
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20));
            }
        }
    }

    @SubscribeEvent
    public static void onEntityJoinWorld(EntityJoinLevelEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Mob mob) {
            mob.goalSelector.addGoal(4, new JohnnyAttackGoal(mob));
        }
    }

}