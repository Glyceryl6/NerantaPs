package com.nerantaps.mixin;

import com.nerantaps.registry.NPBlocks;
import com.nerantaps.registry.NPItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Map;

@Mixin(AbstractFurnaceBlockEntity.class)
public abstract class MixinAbstractFurnaceBlockEntity {

    @Inject(method = "getFuel", at = @At("RETURN"), locals = LocalCapture.CAPTURE_FAILHARD)
    private static void getFuel(CallbackInfoReturnable<Map<Item, Integer>> cir, Map<Item, Integer> map) {
        map.put(NPBlocks.GLOW_FENCE_GATE.get().asItem(), 300);
        map.put(NPBlocks.MAPLE_FENCE_GATE.get().asItem(), 300);
        map.put(NPBlocks.COMBUSTIBLE_ICE.get().asItem(), 6400);
        map.put(NPItems.NASCENT_LAVA_BUCKET.get(), 18000);
    }

}