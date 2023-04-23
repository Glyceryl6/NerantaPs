package com.nerantaps.data.provider;

import com.nerantaps.NerantaPs;
import com.nerantaps.data.tags.NPItemTags;
import com.nerantaps.registry.NPBlocks;
import com.nerantaps.registry.NPItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

@ParametersAreNonnullByDefault
public class NPRecipeProvider extends RecipeProvider {

    public NPRecipeProvider(DataGenerator generator) {
        super(generator);
    }
    
    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        this.buildGlowRecipe(fenceGateBuilder(NPBlocks.GLOW_FENCE_GATE.get(), Ingredient.of(NPBlocks.GLOW_PLANKS.get())), finishedRecipeConsumer);
        this.buildGlowRecipe(trapdoorBuilder(NPBlocks.GLOW_TRAPDOOR.get(), Ingredient.of(NPBlocks.GLOW_PLANKS.get())), finishedRecipeConsumer);
        this.buildGlowRecipe(buttonBuilder(NPBlocks.GLOW_BUTTON.get(), Ingredient.of(NPBlocks.GLOW_PLANKS.get())), finishedRecipeConsumer);
        this.buildGlowRecipe(stairBuilder(NPBlocks.GLOW_STAIRS.get(), Ingredient.of(NPBlocks.GLOW_PLANKS.get())), finishedRecipeConsumer);
        this.buildGlowRecipe(fenceBuilder(NPBlocks.GLOW_FENCE.get(), Ingredient.of(NPBlocks.GLOW_PLANKS.get())), finishedRecipeConsumer);
        this.buildGlowRecipe(doorBuilder(NPBlocks.GLOW_DOOR.get(), Ingredient.of(NPBlocks.GLOW_PLANKS.get())), finishedRecipeConsumer);
        this.buildCycasRecipe(fenceGateBuilder(NPBlocks.CYCAS_FENCE_GATE.get(), Ingredient.of(NPBlocks.CYCAS_PLANKS.get())), finishedRecipeConsumer);
        this.buildCycasRecipe(trapdoorBuilder(NPBlocks.CYCAS_TRAPDOOR.get(), Ingredient.of(NPBlocks.CYCAS_PLANKS.get())), finishedRecipeConsumer);
        this.buildCycasRecipe(buttonBuilder(NPBlocks.CYCAS_BUTTON.get(), Ingredient.of(NPBlocks.CYCAS_PLANKS.get())), finishedRecipeConsumer);
        this.buildCycasRecipe(stairBuilder(NPBlocks.CYCAS_STAIRS.get(), Ingredient.of(NPBlocks.CYCAS_PLANKS.get())), finishedRecipeConsumer);
        this.buildCycasRecipe(fenceBuilder(NPBlocks.CYCAS_FENCE.get(), Ingredient.of(NPBlocks.CYCAS_PLANKS.get())), finishedRecipeConsumer);
        this.buildCycasRecipe(doorBuilder(NPBlocks.CYCAS_DOOR.get(), Ingredient.of(NPBlocks.CYCAS_PLANKS.get())), finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(NPBlocks.IRON_SANDSTONE.get()).define('#', NPBlocks.IRON_SAND.get()).pattern("##").pattern("##")
                .unlockedBy("has_iron_sand", has(NPBlocks.IRON_SAND.get())).save(finishedRecipeConsumer);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(NPItems.DICYNODON_MEAT.get()), NPItems.COOKED_DICYNODON_MEAT.get(), 0.2F, 200)
                .unlockedBy("has_dicynodon_meat", has(NPItems.DICYNODON_MEAT.get())).save(finishedRecipeConsumer);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(NPBlocks.ABYSMAL_SEA_ROCK.get()), Blocks.STONE.asItem(), 0.2F, 200)
                .unlockedBy("has_abysmal_sea_rock", has(NPBlocks.ABYSMAL_SEA_ROCK.get())).save(finishedRecipeConsumer);
        //Chromite Armors and Tools
        ShapedRecipeBuilder.shaped(NPItems.CHROMITE_HELMET.get()).define('X', NPItems.CHROMITE_INGOT.get())
                .pattern("XXX").pattern("X X")
                .unlockedBy("has_chromite_ingot", has(NPItems.CHROMITE_INGOT.get())).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(NPItems.CHROMITE_CHESTPLATE.get()).define('X', NPItems.CHROMITE_INGOT.get())
                .pattern("X X").pattern("XXX").pattern("XXX")
                .unlockedBy("has_chromite_ingot", has(NPItems.CHROMITE_INGOT.get())).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(NPItems.CHROMITE_LEGGINGS.get()).define('X', NPItems.CHROMITE_INGOT.get())
                .pattern("XXX").pattern("X X").pattern("X X")
                .unlockedBy("has_chromite_ingot", has(NPItems.CHROMITE_INGOT.get())).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(NPItems.CHROMITE_BOOTS.get()).define('X', NPItems.CHROMITE_INGOT.get())
                .pattern("X X").pattern("X X")
                .unlockedBy("has_chromite_ingot", has(NPItems.CHROMITE_INGOT.get())).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(NPItems.CHROMITE_SWORD.get()).define('#', Items.STICK).define('X', NPItems.CHROMITE_INGOT.get())
                .pattern("X").pattern("X").pattern("#")
                .unlockedBy("has_chromite_ingot", has(NPItems.CHROMITE_INGOT.get())).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(NPItems.CHROMITE_PICKAXE.get()).define('#', Items.STICK).define('X', NPItems.CHROMITE_INGOT.get())
                .pattern("XXX").pattern(" # ").pattern(" # ")
                .unlockedBy("has_chromite_ingot", has(NPItems.CHROMITE_INGOT.get())).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(NPItems.CHROMITE_SHOVEL.get()).define('#', Items.STICK).define('X', NPItems.CHROMITE_INGOT.get())
                .pattern("X").pattern("#").pattern("#")
                .unlockedBy("has_chromite_ingot", has(NPItems.CHROMITE_INGOT.get())).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(NPItems.CHROMITE_AXE.get()).define('#', Items.STICK).define('X', NPItems.CHROMITE_INGOT.get())
                .pattern("XX").pattern("X#").pattern(" #")
                .unlockedBy("has_chromite_ingot", has(NPItems.CHROMITE_INGOT.get())).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(NPItems.CHROMITE_HOE.get()).define('#', Items.STICK).define('X', NPItems.CHROMITE_INGOT.get())
                .pattern("XX").pattern(" #").pattern(" #")
                .unlockedBy("has_chromite_ingot", has(NPItems.CHROMITE_INGOT.get())).save(finishedRecipeConsumer);
        //Eternal Tools
        ShapedRecipeBuilder.shaped(NPItems.ETERNAL_STEEL_SWORD.get()).define('#', Items.STICK).define('X', NPItems.ETERNAL_STEEL.get())
                .pattern("X").pattern("X").pattern("#")
                .unlockedBy("has_eternal_ingot", has(NPItems.ETERNAL_STEEL.get())).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(NPItems.ETERNAL_STEEL_PICKAXE.get()).define('#', Items.STICK).define('X', NPItems.ETERNAL_STEEL.get())
                .pattern("XXX").pattern(" # ").pattern(" # ")
                .unlockedBy("has_eternal_ingot", has(NPItems.ETERNAL_STEEL.get())).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(NPItems.ETERNAL_STEEL_SHOVEL.get()).define('#', Items.STICK).define('X', NPItems.ETERNAL_STEEL.get())
                .pattern("X").pattern("#").pattern("#")
                .unlockedBy("has_eternal_ingot", has(NPItems.ETERNAL_STEEL.get())).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(NPItems.ETERNAL_STEEL_AXE.get()).define('#', Items.STICK).define('X', NPItems.ETERNAL_STEEL.get())
                .pattern("XX").pattern("X#").pattern(" #")
                .unlockedBy("has_eternal_ingot", has(NPItems.ETERNAL_STEEL.get())).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(NPItems.ETERNAL_STEEL_HOE.get()).define('#', Items.STICK).define('X', NPItems.ETERNAL_STEEL.get())
                .pattern("XX").pattern(" #").pattern(" #")
                .unlockedBy("has_eternal_ingot", has(NPItems.ETERNAL_STEEL.get())).save(finishedRecipeConsumer);
        //Cycas Armors
        ShapedRecipeBuilder.shaped(NPItems.CYCAS_HELMET.get()).define('X', NPItems.CYCAS_BARK.get()).pattern("XXX").pattern("X X")
                .unlockedBy("has_cycas_bark", has(NPItems.CYCAS_BARK.get())).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(NPItems.CYCAS_CHESTPLATE.get()).define('X', NPItems.CYCAS_BARK.get())
                .pattern("X X").pattern("XXX").pattern("XXX")
                .unlockedBy("has_cycas_bark", has(NPItems.CYCAS_BARK.get())).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(NPItems.CYCAS_LEGGINGS.get()).define('X', NPItems.CYCAS_BARK.get())
                .pattern("XXX").pattern("X X").pattern("X X")
                .unlockedBy("has_cycas_bark", has(NPItems.CYCAS_BARK.get())).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(NPItems.CYCAS_BOOTS.get()).define('X', NPItems.CYCAS_BARK.get()).pattern("X X").pattern("X X")
                .unlockedBy("has_cycas_bark", has(NPItems.CYCAS_BARK.get())).save(finishedRecipeConsumer);
        //Dimension Keys
        ShapedRecipeBuilder.shaped(NPItems.KEY_OF_SURFACE.get()).define('#', Blocks.STONE).define('X', Items.WOODEN_SWORD)
                .pattern("###").pattern("#X#").pattern("###")
                .unlockedBy("has_stone", has(Blocks.STONE)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(NPItems.KEY_OF_DEEP.get()).define('#', Blocks.DEEPSLATE).define('X', Items.WOODEN_SWORD)
                .pattern("###").pattern("#X#").pattern("###")
                .unlockedBy("has_deepslate", has(Blocks.DEEPSLATE)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(NPItems.KEY_OF_NETHER.get()).define('#', Blocks.NETHERRACK).define('X', Items.STONE_SWORD)
                .pattern("###").pattern("#X#").pattern("###")
                .unlockedBy("has_netherrack", has(Blocks.NETHERRACK)).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(NPItems.KEY_OF_DEEP_NETHER.get()).define('#', NPBlocks.DEEP_NETHERRACK.get()).define('X', Items.STONE_SWORD)
                .pattern("###").pattern("#X#").pattern("###")
                .unlockedBy("has_deep_netherrack", has(NPBlocks.DEEP_NETHERRACK.get())).save(finishedRecipeConsumer);
        //Some new vanilla recipes
        ShapelessRecipeBuilder.shapeless(Items.MAGMA_CREAM).requires(Items.BLAZE_POWDER).requires(NPItems.GLOW_SLIME_BALL.get())
                .unlockedBy("has_blaze_powder", has(Items.BLAZE_POWDER))
                .save(finishedRecipeConsumer, NerantaPs.prefix("np_magma_cream"));
        ShapedRecipeBuilder.shaped(Items.LEAD, 2).define('~', Items.STRING).define('O', NPItems.GLOW_SLIME_BALL.get())
                .pattern("~~ ").pattern("~O ").pattern("  ~").unlockedBy("has_glow_slime_ball",
                        has(NPItems.GLOW_SLIME_BALL.get())).save(finishedRecipeConsumer, NerantaPs.prefix("np_lead"));
        ShapedRecipeBuilder.shaped(Blocks.STICKY_PISTON).define('P', Blocks.PISTON).define('S', NPItems.GLOW_SLIME_BALL.get())
                .pattern("S").pattern("P").unlockedBy("has_glow_slime_ball",
                        has(NPItems.GLOW_SLIME_BALL.get())).save(finishedRecipeConsumer, NerantaPs.prefix("np_sticky_piston"));
        ShapedRecipeBuilder.shaped(Blocks.TORCH).define('#', Items.STICK).define('X', NPItems.GLOW_SLIME_BALL.get())
                .pattern("X").pattern("#").unlockedBy("has_glow_slime_ball",
                        has(NPItems.GLOW_SLIME_BALL.get())).save(finishedRecipeConsumer, NerantaPs.prefix("np_torch"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(NPItems.RUST.get()), Items.IRON_NUGGET, 0.15F, 200)
                .unlockedBy("has_rust", has(NPItems.RUST.get()))
                .save(finishedRecipeConsumer, NerantaPs.prefix("np_iron_nugget"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(NPBlocks.IRON_PLATE_BLOCK.get()), Items.IRON_INGOT, 0.15F, 200)
                .unlockedBy("has_iron_plate_block", has(NPBlocks.IRON_PLATE_BLOCK.get()))
                .save(finishedRecipeConsumer, NerantaPs.prefix("np_iron_ingot_1"));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(NPBlocks.RUSTINESS_IRON_PLATE_BLOCK.get()), Items.IRON_INGOT, 0.15F, 200)
                .unlockedBy("has_rustiness_iron_plate_block", has(NPBlocks.RUSTINESS_IRON_PLATE_BLOCK.get()))
                .save(finishedRecipeConsumer, NerantaPs.prefix("np_iron_ingot_2"));
        ShapelessRecipeBuilder.shapeless(Items.CHARCOAL).requires(NPItems.BOTTLE_OF_SULFURIC_ACID.get()).requires(ItemTags.LOGS)
                .unlockedBy("has_bottle_of_sulfuric_acid", has(NPItems.BOTTLE_OF_SULFURIC_ACID.get()))
                .save(finishedRecipeConsumer, NerantaPs.prefix("np_charcoal"));
        ShapelessRecipeBuilder.shapeless(Items.CHARCOAL, 3).requires(NPItems.SULFURIC_ACID_BUCKET.get()).requires(ItemTags.LOGS)
                .unlockedBy("has_sulfuric_acid_bucket", has(NPItems.SULFURIC_ACID_BUCKET.get()))
                .save(finishedRecipeConsumer, NerantaPs.prefix("np_3_charcoal"));
        ShapelessRecipeBuilder.shapeless(NPItems.BOTTLE_OF_SULFURIC_ACID.get(), 3)
                .requires(NPItems.SULFURIC_ACID_BUCKET.get()).requires(Items.GLASS_BOTTLE, 3)
                .unlockedBy("has_sulfuric_acid_bucket", has(NPItems.SULFURIC_ACID_BUCKET.get())).save(finishedRecipeConsumer);
        ShapelessRecipeBuilder.shapeless(NPItems.DETOXIFY_SOUP.get()).requires(NPItems.GIANT_MOSS_LEAVES.get()).requires(Items.BOWL)
                .unlockedBy("has_giant_moss_leaves", has(NPItems.GIANT_MOSS_LEAVES.get()))
                .unlockedBy("has_bowl", has(Items.BOWL)).save(finishedRecipeConsumer);

        stairBuilder(NPBlocks.IRON_PLATE_STAIRS.get(), Ingredient.of(NPBlocks.IRON_PLATE_BLOCK.get()))
                .unlockedBy("has_iron_plate_block", has(NPBlocks.IRON_PLATE_BLOCK.get())).save(finishedRecipeConsumer);
        stairBuilder(NPBlocks.RUSTINESS_IRON_PLATE_STAIRS.get(), Ingredient.of(NPBlocks.RUSTINESS_IRON_PLATE_BLOCK.get()))
                .unlockedBy("has_rustiness_iron_plate_block", has(NPBlocks.RUSTINESS_IRON_PLATE_BLOCK.get())).save(finishedRecipeConsumer);
        stairBuilder(NPBlocks.CUT_IRON_PLATE_STAIRS.get(), Ingredient.of(NPBlocks.CUT_IRON_PLATE_BLOCK.get()))
                .unlockedBy("has_cut_iron_plate_block", has(NPBlocks.CUT_IRON_PLATE_BLOCK.get())).save(finishedRecipeConsumer);
        stairBuilder(NPBlocks.CUT_RUSTINESS_IRON_PLATE_STAIRS.get(), Ingredient.of(NPBlocks.CUT_RUSTINESS_IRON_PLATE_BLOCK.get()))
                .unlockedBy("has_cut_rustiness_iron_plate_block", has(NPBlocks.CUT_RUSTINESS_IRON_PLATE_BLOCK.get())).save(finishedRecipeConsumer);
        nineBlockStorageRecipes(finishedRecipeConsumer, NPItems.RAW_CHROMITE_ORE.get(), NPBlocks.RAW_CHROMITE_BLOCK.get());
        nineBlockStorageRecipes(finishedRecipeConsumer, NPItems.CHROMITE_INGOT.get(), NPBlocks.CHROMITE_BLOCK.get());
        nineBlockStorageRecipes(finishedRecipeConsumer, NPItems.SULFUR_POWDER.get(), NPBlocks.SULFUR_BLOCK.get());
        nineBlockStorageRecipes(finishedRecipeConsumer, NPItems.RUST.get(), NPBlocks.RUST_BLOCK.get());
        stonecutterResultFromBase(finishedRecipeConsumer, NPBlocks.IRON_PLATE_BLOCK.get(), Blocks.IRON_BLOCK, 9);
        stonecutterResultFromBase(finishedRecipeConsumer, NPBlocks.IRON_PLATE_STAIRS.get(), NPBlocks.IRON_PLATE_BLOCK.get(), 4);
        stonecutterResultFromBase(finishedRecipeConsumer, NPBlocks.IRON_PLATE_SLAB.get(), NPBlocks.IRON_PLATE_BLOCK.get(), 8);
        stonecutterResultFromBase(finishedRecipeConsumer, NPBlocks.RUSTINESS_IRON_PLATE_STAIRS.get(), NPBlocks.RUSTINESS_IRON_PLATE_BLOCK.get(), 4);
        stonecutterResultFromBase(finishedRecipeConsumer, NPBlocks.RUSTINESS_IRON_PLATE_SLAB.get(), NPBlocks.RUSTINESS_IRON_PLATE_BLOCK.get(), 8);
        stonecutterResultFromBase(finishedRecipeConsumer, NPBlocks.CUT_IRON_PLATE_BLOCK.get(), NPBlocks.IRON_PLATE_BLOCK.get(), 4);
        stonecutterResultFromBase(finishedRecipeConsumer, NPBlocks.CUT_IRON_PLATE_STAIRS.get(), NPBlocks.CUT_IRON_PLATE_BLOCK.get());
        stonecutterResultFromBase(finishedRecipeConsumer, NPBlocks.CUT_IRON_PLATE_SLAB.get(), NPBlocks.CUT_IRON_PLATE_BLOCK.get(), 2);
        stonecutterResultFromBase(finishedRecipeConsumer, NPBlocks.CUT_RUSTINESS_IRON_PLATE_STAIRS.get(), NPBlocks.CUT_RUSTINESS_IRON_PLATE_BLOCK.get(), 4);
        stonecutterResultFromBase(finishedRecipeConsumer, NPBlocks.CUT_RUSTINESS_IRON_PLATE_SLAB.get(), NPBlocks.CUT_RUSTINESS_IRON_PLATE_BLOCK.get(), 8);
        pressurePlate(finishedRecipeConsumer, NPBlocks.CYCAS_PRESSURE_PLATE.get(), NPBlocks.CYCAS_PLANKS.get());
        pressurePlate(finishedRecipeConsumer, NPBlocks.GLOW_PRESSURE_PLATE.get(), NPBlocks.GLOW_PLANKS.get());
        planksFromLogs(finishedRecipeConsumer, NPBlocks.MAPLE_PLANKS.get(), NPItemTags.MAPLE_LOGS);
        planksFromLogs(finishedRecipeConsumer, NPBlocks.CYCAS_PLANKS.get(), NPItemTags.CYCAS_LOGS);
        planksFromLogs(finishedRecipeConsumer, NPBlocks.GLOW_PLANKS.get(), NPItemTags.GLOW_LOGS);
//        woodFromLogs(finishedRecipeConsumer, NPBlocks.MAPLE_WOOD.get(), NPBlocks.MAPLE_LOG.get());
        woodFromLogs(finishedRecipeConsumer, NPBlocks.CYCAS_WOOD.get(), NPBlocks.CYCAS_LOG.get());
        woodFromLogs(finishedRecipeConsumer, NPBlocks.GLOW_WOOD.get(), NPBlocks.GLOW_LOG.get());
        slab(finishedRecipeConsumer, NPBlocks.IRON_PLATE_SLAB.get(), NPBlocks.IRON_PLATE_BLOCK.get());
        slab(finishedRecipeConsumer, NPBlocks.RUSTINESS_IRON_PLATE_SLAB.get(), NPBlocks.RUSTINESS_IRON_PLATE_BLOCK.get());
        slab(finishedRecipeConsumer, NPBlocks.CUT_IRON_PLATE_SLAB.get(), NPBlocks.CUT_IRON_PLATE_BLOCK.get());
        slab(finishedRecipeConsumer, NPBlocks.CUT_RUSTINESS_IRON_PLATE_SLAB.get(), NPBlocks.CUT_RUSTINESS_IRON_PLATE_BLOCK.get());
        slab(finishedRecipeConsumer, NPBlocks.CYCAS_SLAB.get(), NPBlocks.CYCAS_PLANKS.get());
        slab(finishedRecipeConsumer, NPBlocks.GLOW_SLAB.get(), NPBlocks.GLOW_PLANKS.get());
    }

    private void buildGlowRecipe(RecipeBuilder recipeBuilder, Consumer<FinishedRecipe> finishedRecipeConsumer) {
        recipeBuilder.unlockedBy(getHasName(NPBlocks.GLOW_PLANKS.get()), has(NPBlocks.GLOW_PLANKS.get())).save(finishedRecipeConsumer);
    }

    private void buildCycasRecipe(RecipeBuilder recipeBuilder, Consumer<FinishedRecipe> finishedRecipeConsumer) {
        recipeBuilder.unlockedBy(getHasName(NPBlocks.CYCAS_PLANKS.get()), has(NPBlocks.CYCAS_PLANKS.get())).save(finishedRecipeConsumer);
    }

}