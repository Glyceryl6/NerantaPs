package com.nerantaps.mixin;

import com.nerantaps.registry.NPItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(FireBlock.class)
public class MixinFireBlock {

    //Todo: Need to test and fix some potential bugs.
    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerLevel;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z",
            ordinal = 1, shift = At.Shift.BEFORE), locals = LocalCapture.CAPTURE_FAILHARD)
    public void tick(BlockState state, ServerLevel level, BlockPos blockPos, RandomSource random, CallbackInfo ci, BlockState blockState, boolean flag,
                     int i, int j, boolean flag1, int k, BlockPos.MutableBlockPos mutableBlockPos, int l, int i1, int j1, int k1, int l1, int i2, int j2) {
        if (level.getBlockState(mutableBlockPos).getBlock() instanceof LeavesBlock) {
            ItemStack ashStack = NPItems.ASH.get().getDefaultInstance();
            Vec3 centerPos = Vec3.atCenterOf(mutableBlockPos);
            if (!level.isClientSide && level.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS)) {
                ItemEntity ashItemEntity = new ItemEntity(level, centerPos.x, centerPos.y, centerPos.z, ashStack);
                ashItemEntity.setDefaultPickUpDelay();
                level.addFreshEntity(ashItemEntity);
            }
        }
    }

}