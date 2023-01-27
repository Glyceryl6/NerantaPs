package com.nerantaps.blocks.entity;

import com.mojang.logging.LogUtils;
import com.nerantaps.registry.NPBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CompassItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.slf4j.Logger;

public class MagneticStormVentEntity extends BlockEntity {

    private static final Logger LOGGER = LogUtils.getLogger();

    public MagneticStormVentEntity(BlockPos worldPosition, BlockState blockState) {
        super(NPBlockEntities.MAGNETIC_STORM_VENT_ENTITY.get(), worldPosition, blockState);
    }

    @SuppressWarnings("unused")
    public static void serverTick(Level level, BlockPos pos, BlockState state, MagneticStormVentEntity entity) {
        if (!level.isClientSide()) {
            AABB aabb = (new AABB(pos)).inflate(50.0D);
            for (Player player : level.getEntitiesOfClass(Player.class, aabb)) {
                for (ItemStack itemStack : player.getInventory().items) {
                    if (itemStack.is(Items.COMPASS)) {
                        CompoundTag compoundTag = itemStack.getOrCreateTag();
                        if (CompassItem.isLodestoneCompass(itemStack)) {
                            compoundTag.putBoolean("MagneticDisturbance", true);
                        } else {
                            compoundTag.put("LodestonePos", NbtUtils.writeBlockPos(pos));
                            Level.RESOURCE_KEY_CODEC.encodeStart(NbtOps.INSTANCE, level.dimension()).resultOrPartial(LOGGER::error)
                                    .ifPresent(tag -> compoundTag.put("LodestoneDimension", tag));
                            compoundTag.putBoolean("LodestoneTracked", true);
                        }
                    }
                }
            }
            for (BlockPos blockPos : BlockPos.withinManhattan(pos, 2, 2, 2)) {
                BlockState blockState = level.getBlockState(blockPos);
                if (blockState.getBlock() instanceof BedBlock) {
                    level.setBlock(pos, state.setValue(BedBlock.OCCUPIED, true), 3);
                }
            }
        }
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

}