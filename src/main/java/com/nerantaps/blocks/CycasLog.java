package com.nerantaps.blocks;

import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class CycasLog extends AxeStrippedBlock {

    public CycasLog(Supplier<Block> strippedBlock) {
        super(strippedBlock, Properties.of(Material.WOOD, (state) -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ?
                MaterialColor.WOOD : MaterialColor.PODZOL).strength(2.5f, 2f).sound(SoundType.WOOD));
    }

    @Override
    public void appendHoverText(ItemStack itemstack, @Nullable BlockGetter world, List<Component> list, TooltipFlag flag) {
        list.add(Component.translatable("tips.cycas_log"));
    }

}