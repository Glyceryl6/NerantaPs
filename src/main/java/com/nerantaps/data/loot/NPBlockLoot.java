package com.nerantaps.data.loot;

import com.google.common.collect.Sets;
import com.nerantaps.registry.NPBlocks;
import com.nerantaps.registry.NPItems;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Set;
import java.util.function.BiConsumer;

@ParametersAreNonnullByDefault
public class NPBlockLoot extends BlockLoot {

    @Override
    protected void addTables() {
        this.dropSelf(NPBlocks.IRON_SAND.get());
        this.dropSelf(NPBlocks.IRON_SANDSTONE.get());
        this.dropSelf(NPBlocks.DEEP_NETHERRACK.get());
        this.dropSelf(NPBlocks.ABYSMAL_SEA_ROCK.get());
        this.dropSelf(NPBlocks.RAW_CHROMITE_BLOCK.get());
        this.dropSelf(NPBlocks.CHROMITE_BLOCK.get());
        this.dropSelf(NPBlocks.SULFUR_BLOCK.get());
        this.dropSelf(NPBlocks.GLOW_LOG.get());
        this.dropSelf(NPBlocks.GLOW_WOOD.get());
        this.dropSelf(NPBlocks.GLOW_PLANKS.get());
        this.dropSelf(NPBlocks.GLOW_SAPLING.get());
        this.dropSelf(NPBlocks.GLOW_SLAB.get());
        this.dropSelf(NPBlocks.GLOW_DOOR.get());
        this.dropSelf(NPBlocks.GLOW_FENCE.get());
        this.dropSelf(NPBlocks.GLOW_STAIRS.get());
        this.dropSelf(NPBlocks.GLOW_BUTTON.get());
        this.dropSelf(NPBlocks.GLOW_TRAPDOOR.get());
        this.dropSelf(NPBlocks.GLOW_FENCE_GATE.get());
        this.dropSelf(NPBlocks.GLOW_PRESSURE_PLATE.get());
        this.dropSelf(NPBlocks.CYCAS_LOG.get());
        this.dropSelf(NPBlocks.CYCAS_WOOD.get());
        this.dropSelf(NPBlocks.CYCAS_PLANKS.get());
        this.dropSelf(NPBlocks.CYCAS_SAPLING.get());
        this.dropSelf(NPBlocks.CYCAS_SLAB.get());
        this.dropSelf(NPBlocks.CYCAS_DOOR.get());
        this.dropSelf(NPBlocks.CYCAS_FENCE.get());
        this.dropSelf(NPBlocks.CYCAS_STAIRS.get());
        this.dropSelf(NPBlocks.CYCAS_BUTTON.get());
        this.dropSelf(NPBlocks.CYCAS_TRAPDOOR.get());
        this.dropSelf(NPBlocks.CYCAS_FENCE_GATE.get());
        this.dropSelf(NPBlocks.CYCAS_PRESSURE_PLATE.get());
        this.dropSelf(NPBlocks.MAPLE_LOG.get());
        this.dropSelf(NPBlocks.MAPLE_WOOD.get());
        this.dropSelf(NPBlocks.MAPLE_PLANKS.get());
        this.dropSelf(NPBlocks.MAPLE_SAPLING.get());
        this.dropSelf(NPBlocks.MAPLE_SLAB.get());
        this.dropSelf(NPBlocks.MAPLE_DOOR.get());
        this.dropSelf(NPBlocks.MAPLE_FENCE.get());
        this.dropSelf(NPBlocks.MAPLE_STAIRS.get());
        this.dropSelf(NPBlocks.MAPLE_BUTTON.get());
        this.dropSelf(NPBlocks.MAPLE_TRAPDOOR.get());
        this.dropSelf(NPBlocks.MAPLE_FENCE_GATE.get());
        this.dropSelf(NPBlocks.MAPLE_PRESSURE_PLATE.get());
        this.dropSelf(NPBlocks.COBBLED_OCEANICEND_STONE.get());
        this.dropSelf(NPBlocks.RED_HOT_IRON_SAND.get());
        this.dropSelf(NPBlocks.STRIPPED_GLOW_LOG.get());
        this.dropSelf(NPBlocks.STRIPPED_GLOW_WOOD.get());
        this.dropSelf(NPBlocks.STRIPPED_CYCAS_LOG.get());
        this.dropSelf(NPBlocks.STRIPPED_CYCAS_WOOD.get());
        this.dropSelf(NPBlocks.ROTTEN_FLESH_BLOCK.get());
        this.dropSelf(NPBlocks.IRON_PLATE_BLOCK.get());
        this.dropSelf(NPBlocks.CUT_IRON_PLATE_BLOCK.get());
        this.dropSelf(NPBlocks.RUSTINESS_IRON_PLATE_BLOCK.get());
        this.dropSelf(NPBlocks.CUT_RUSTINESS_IRON_PLATE_BLOCK.get());
        this.dropSelf(NPBlocks.IRON_PLATE_SLAB.get());
        this.dropSelf(NPBlocks.CUT_IRON_PLATE_SLAB.get());
        this.dropSelf(NPBlocks.RUSTINESS_IRON_PLATE_SLAB.get());
        this.dropSelf(NPBlocks.CUT_RUSTINESS_IRON_PLATE_SLAB.get());
        this.dropSelf(NPBlocks.IRON_PLATE_STAIRS.get());
        this.dropSelf(NPBlocks.CUT_IRON_PLATE_STAIRS.get());
        this.dropSelf(NPBlocks.RUSTINESS_IRON_PLATE_STAIRS.get());
        this.dropSelf(NPBlocks.CUT_RUSTINESS_IRON_PLATE_STAIRS.get());
        this.dropWhenSilkTouch(NPBlocks.BLACK_SMOKER.get());
        this.dropWhenSilkTouch(NPBlocks.COMBUSTIBLE_ICE.get());
        this.dropWhenSilkTouch(NPBlocks.MAGNETIC_STORM_VENT.get());
        this.dropPottedContents(NPBlocks.POTTED_ELDEN_FERN.get());
        this.dropPottedContents(NPBlocks.POTTED_GLOSSOPTERIS.get());
        this.dropPottedContents(NPBlocks.POTTED_GLOW_SAPLING.get());
        this.dropPottedContents(NPBlocks.POTTED_CYCAS_SAPLING.get());
        this.dropPottedContents(NPBlocks.POTTED_MAPLE_SAPLING.get());
        this.dropPottedContents(NPBlocks.POTTED_UNDERWATER_FUNGUS.get());
        this.add(NPBlocks.DEEP_NETHER_CHROMITE_ORE.get(), block ->
                createOreDrop(block, NPItems.RAW_CHROMITE_ORE.get()));
        this.add(NPBlocks.UNDERWATER_FUNGUS_BLOCK.get(), block ->
                createSingleItemTableWithSilkTouch(block, Blocks.DIRT));
        this.add(NPBlocks.BLOODY_BLACKSTONE.get(), block ->
                createSingleItemTableWithSilkTouch(block, Blocks.BLACKSTONE));
        this.add(NPBlocks.OCEANICEND_STONE.get(), block ->
                createSingleItemTableWithSilkTouch(block, NPBlocks.COBBLED_OCEANICEND_STONE.get()));
        this.add(NPBlocks.GLOW_GRASS.get(), BlockLoot::createGrassDrops);
        this.add(NPBlocks.GLOW_LEAVES.get(), block -> createLeavesDrops(block,
                NPBlocks.GLOW_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(NPBlocks.CYCAS_LEAVES.get(), block -> createLeavesDrops(block,
                NPBlocks.CYCAS_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(NPBlocks.MAPLE_LEAVES.get(), block -> createLeavesDrops(block,
                NPBlocks.MAPLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(NPBlocks.ELDEN_FERN.get(), BlockLoot::createShearsOnlyDrop);
        this.add(NPBlocks.GLOSSOPTERIS.get(), BlockLoot::createShearsOnlyDrop);
        this.add(NPBlocks.UNDERWATER_FUNGUS.get(), BlockLoot::createShearsOnlyDrop);
        this.add(NPBlocks.GLOW_MOSS.get(), block -> createSilkTouchOrShearsDispatchTable(block,
                applyExplosionCondition(block, LootItem.lootTableItem(NPBlocks.GLOW_MOSS.get()))));
        this.add(NPBlocks.KIMBERLITE.get(), block -> createSilkTouchDispatchTable(block,
                applyExplosionCondition(block, LootItem.lootTableItem(Items.DIAMOND).when(BonusLevelTableCondition
                .bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.2F, 0.5F, 0.7F, 1.0F))
                .otherwise(LootItem.lootTableItem(Blocks.BASALT)))));
        this.add(NPBlocks.SULFUR_ORE.get(), block -> createSilkTouchDispatchTable(block,
                applyExplosionDecay(block, LootItem.lootTableItem(NPItems.SULFUR_POWDER.get())
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)))));
        this.add(NPBlocks.ENRICHED_IRON_ORE.get(), block -> createSilkTouchDispatchTable(block,
                applyExplosionDecay(block, LootItem.lootTableItem(Items.REDSTONE)
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));
        this.add(NPBlocks.DESERT_BUSH.get(), block -> createSilkTouchOrShearsDispatchTable(block,
                applyExplosionDecay(block, LootItem.lootTableItem(Items.STICK)
                .when(LootItemRandomChanceCondition.randomChance(0.25F))
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))));
    }

    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> biConsumer) {
        this.addTables();
        Set<ResourceLocation> set = Sets.newHashSet();
        for (Block block : this.getKnownBlocks()) {
            ResourceLocation resource = block.getLootTable();
            if (resource != BuiltInLootTables.EMPTY && set.add(resource)) {
                LootTable.Builder lootTable$builder = this.map.remove(resource);
                if (lootTable$builder != null) {
                    biConsumer.accept(resource, lootTable$builder);
                }
            }
        }

        if (!this.map.isEmpty()) {
            throw new IllegalStateException("Created block loot tables for non-blocks: " + this.map.keySet());
        }
    }

    @Nonnull @Override
    protected Iterable<Block> getKnownBlocks() {
        return NPBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

}