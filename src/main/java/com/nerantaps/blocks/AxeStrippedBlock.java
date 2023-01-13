package com.nerantaps.blocks;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class AxeStrippedBlock extends RotatedPillarBlock {

    private final Supplier<Block> block;

    public AxeStrippedBlock(Supplier<Block> strippedBlock, Properties properties) {
        super(properties);
        this.block = strippedBlock;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (toolAction == ToolActions.AXE_STRIP) {
            return transferAllBlockStates(state, this.block.get().defaultBlockState());
        }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static BlockState transferAllBlockStates(BlockState initial, BlockState after) {
        BlockState block = after;
        for (Property property : initial.getBlock().getStateDefinition().getProperties()) {
            if (after.hasProperty(property)) {
                block = block.setValue(property, initial.getValue(property));
            }
        }
        return block;
    }

}