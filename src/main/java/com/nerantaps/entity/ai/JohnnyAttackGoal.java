package com.nerantaps.entity.ai;

import com.nerantaps.registry.NPEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;

public class JohnnyAttackGoal extends NearestAttackableTargetGoal<LivingEntity> {

    public JohnnyAttackGoal(Mob entity) {
        super(entity, LivingEntity.class, 0, true, true, LivingEntity::attackable);
    }

    @Override
    public boolean canUse() {
        return this.mob.hasEffect(NPEffects.SANGUINARY.get()) && super.canUse();
    }

    @Override
    public void start() {
        super.start();
        this.mob.setNoActionTime(0);
    }

}