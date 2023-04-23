package com.nerantaps.mixin;

import net.minecraft.server.commands.LocateCommand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(LocateCommand.class)
public class MixinLocateCommand {

    @ModifyArg(method = "locateBiome", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerLevel;findClosestBiome3d(Ljava/util/function/Predicate;Lnet/minecraft/core/BlockPos;III)Lcom/mojang/datafixers/util/Pair;"), index = 2)
    private static int locateBiome(int radius) {
        return Short.MAX_VALUE;
    }

}