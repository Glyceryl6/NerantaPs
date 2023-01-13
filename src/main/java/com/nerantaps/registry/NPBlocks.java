package com.nerantaps.registry;

import com.nerantaps.NerantaPs;
import com.nerantaps.blocks.*;
import com.nerantaps.blocks.grower.CycasGrower;
import com.nerantaps.blocks.grower.GlowTreeGrower;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.nerantaps.utils.NPBlockUtils.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
@SuppressWarnings("removal")
public class NPBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NerantaPs.MOD_ID);
    public static final RegistryObject<Block> NASCENT_LAVA = BLOCKS.register("nascent_lava", NascentLava::new);
    public static final RegistryObject<Block> SULFUR_FIRE = BLOCKS.register("sulfur_fire", SulfurFire::new);
    public static final RegistryObject<Block> IRON_SAND = register("iron_sand", IronSand::new);
    public static final RegistryObject<Block> IRON_SANDSTONE = normal("iron_sandstone", defaultProperties().strength(1.0F, 40.0F));
    public static final RegistryObject<Block> MAGNETIC_STORM_VENT = register("magnetic_storm_vent", MagneticStormVent::new);
    public static final RegistryObject<Block> RED_HOT_IRON_SAND = register("red_hot_iron_sand", RedHotIronSand::new);
    public static final RegistryObject<Block> DESERT_BUSH = register("desert_bush", () -> new FallingBlock(copy(Blocks.DEAD_BUSH)));
    public static final RegistryObject<Block> STRIPPED_GLOW_LOG = register("stripped_glow_log", () -> Blocks.log(MaterialColor.WOOD, MaterialColor.PODZOL));
    public static final RegistryObject<Block> STRIPPED_GLOW_WOOD = wood("stripped_glow_wood", MaterialColor.WOOD, 15);
    public static final RegistryObject<Block> GLOW_LEAVES = register("glow_leaves", () -> new LeavesBlock(copy(Blocks.OAK_LEAVES).lightLevel(s -> 11)));
    public static final RegistryObject<Block> GLOW_LOG = register("glow_log", () -> glowLog(STRIPPED_GLOW_LOG, MaterialColor.PODZOL));
    public static final RegistryObject<Block> GLOW_WOOD = register("glow_wood", () -> glowLog(STRIPPED_GLOW_WOOD, MaterialColor.WOOD));
    public static final RegistryObject<Block> GLOW_PLANKS = normal("glow_planks", copy(Blocks.OAK_PLANKS).lightLevel(s -> 1));
    public static final RegistryObject<Block> GLOW_SLAB = slab("glow_slab", copy(Blocks.OAK_SLAB).lightLevel(s -> 1));
    public static final RegistryObject<Block> GLOW_DOOR = door("glow_door", copy(Blocks.OAK_DOOR).lightLevel(s -> 1));
    public static final RegistryObject<Block> GLOW_FENCE = fence("glow_fence", copy(Blocks.OAK_FENCE).lightLevel(s -> 1));
    public static final RegistryObject<Block> GLOW_TRAPDOOR = trapdoor("glow_trapdoor", copy(Blocks.OAK_TRAPDOOR).lightLevel(s -> 1));
    public static final RegistryObject<Block> GLOW_STAIRS = stair("glow_stairs", GLOW_PLANKS, copy(Blocks.OAK_STAIRS).lightLevel(s -> 1));
    public static final RegistryObject<Block> GLOW_BUTTON = button("glow_button", true, copy(Blocks.OAK_BUTTON).lightLevel(s -> 1));
    public static final RegistryObject<Block> GLOW_FENCE_GATE = fenceGate("glow_fence_gate", copy(Blocks.OAK_FENCE_GATE).lightLevel(s -> 1));
    public static final RegistryObject<Block> GLOW_PRESSURE_PLATE = pressurePlate("glow_pressure_plate", copy(Blocks.OAK_PRESSURE_PLATE).lightLevel(s -> 1));
    public static final RegistryObject<Block> GLOW_SAPLING = register("glow_sapling", () -> new SaplingBlock(new GlowTreeGrower(), copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> GLOW_GRASS = register("glow_grass", () -> new TallGrassBlock(copy(Blocks.GRASS).lightLevel(s -> 7)));
    public static final RegistryObject<Block> GLOW_MOSS = register("glow_moss", () -> new TallGrassBlock(copy(Blocks.BROWN_MUSHROOM).lightLevel(s -> 3)));
    public static final RegistryObject<Block> ABYSMAL_SEA_ROCK = normal("abysmal_sea_rock", defaultProperties().strength(2.5F, 6.0F));
    public static final RegistryObject<Block> BLACK_SMOKER = register("black_smoker", BlackSmoker::new);
    public static final RegistryObject<Block> COMBUSTIBLE_ICE = normal("combustible_ice", copy(Blocks.ICE));
    public static final RegistryObject<Block> KIMBERLITE = ore("kimberlite", defaultProperties().strength(2.0F, 5.0F));
    public static final RegistryObject<Block> ENRICHED_IRON_ORE = ore("enriched_iron_ore", defaultProperties().strength(2.5F, 6.0F));
    public static final RegistryObject<Block> SULFUR_ORE = ore("sulfur_ore", defaultProperties().strength(2.0F, 6.0F));
    public static final RegistryObject<Block> SULFUR_BLOCK = normal("sulfur_block", defaultProperties().strength(1.5F, 5.0F));
    public static final RegistryObject<Block> STRIPPED_CYCAS_LOG = register("stripped_cycas_log", () -> Blocks.log(MaterialColor.WOOD, MaterialColor.PODZOL));
    public static final RegistryObject<Block> STRIPPED_CYCAS_WOOD = wood("stripped_cycas_wood", MaterialColor.WOOD, 0);
    public static final RegistryObject<Block> CYCAS_LEAVES = register("cycas_leaves", () -> Blocks.leaves(SoundType.GRASS));
    public static final RegistryObject<Block> CYCAS_LOG = register("cycas_log", () -> new CycasLog(STRIPPED_CYCAS_LOG));
    public static final RegistryObject<Block> CYCAS_WOOD = register("cycas_wood", () -> new CycasLog(STRIPPED_CYCAS_WOOD));
    public static final RegistryObject<Block> CYCAS_PLANKS = normal("cycas_planks", cycasProperties());
    public static final RegistryObject<Block> CYCAS_SLAB = slab("cycas_slab", cycasProperties());
    public static final RegistryObject<Block> CYCAS_DOOR = door("cycas_door", cycasProperties());
    public static final RegistryObject<Block> CYCAS_FENCE = fence("cycas_fence", cycasProperties());
    public static final RegistryObject<Block> CYCAS_TRAPDOOR = trapdoor("cycas_trapdoor", cycasProperties());
    public static final RegistryObject<Block> CYCAS_FENCE_GATE = fenceGate("cycas_fence_gate", cycasProperties());
    public static final RegistryObject<Block> CYCAS_STAIRS = stair("cycas_stairs", CYCAS_PLANKS, cycasProperties());
    public static final RegistryObject<Block> CYCAS_BUTTON = button("cycas_button", true, cycasProperties());
    public static final RegistryObject<Block> CYCAS_PRESSURE_PLATE = pressurePlate("cycas_pressure_plate", cycasProperties());
    public static final RegistryObject<Block> CYCAS_SAPLING = register("cycas_sapling", () -> new SaplingBlock(new CycasGrower(), copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> ELDEN_FERN = register("elden_fern", () -> new TallGrassBlock(copy(Blocks.GRASS)));
    public static final RegistryObject<Block> GLOSSOPTERIS = register("glossopteris", () -> new TallGrassBlock(copy(Blocks.GRASS)));
    public static final RegistryObject<Block> UNDERWATER_FUNGUS_BLOCK = register("underwater_fungus_block", UnderwaterFungusBlock::new);
    public static final RegistryObject<Block> UNDERWATER_FUNGUS = register("underwater_fungus", UnderwaterFungus::new);
    public static final RegistryObject<Block> ROTTEN_FLESH_BLOCK = register("rotten_flesh_block", RottenFleshBlock::new);
    public static final RegistryObject<Block> PALOLO_WORM_HOLE = register("palolo_worm_hole", PaloloWormHole::new);

    private static RotatedPillarBlock glowLog(Supplier<Block> strippedBlock, MaterialColor barkColor) {
        return new AxeStrippedBlock(strippedBlock, BlockBehaviour.Properties.of(Material.WOOD, (state) ->
               state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : barkColor)
                .strength(2.0F).sound(SoundType.WOOD).lightLevel(s -> 15));
    }

    private static BlockBehaviour.Properties defaultProperties() {
       return BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops();
    }

    private static BlockBehaviour.Properties cycasProperties() {
        return BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(4.0F, 5.0F);
    }

    private static BlockBehaviour.Properties copy(BlockBehaviour blockBehaviour) {
        return BlockBehaviour.Properties.copy(blockBehaviour);
    }

    @SubscribeEvent
    public static void registerRenderLayer(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ELDEN_FERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(DESERT_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(SULFUR_FIRE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(GLOSSOPTERIS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(UNDERWATER_FUNGUS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(GLOW_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(GLOW_MOSS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(GLOW_GRASS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(GLOW_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(GLOW_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(GLOW_LEAVES.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(CYCAS_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CYCAS_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CYCAS_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CYCAS_LEAVES.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(COMBUSTIBLE_ICE.get(), RenderType.translucent());
    }

}