package com.nerantaps.data.provider;

import com.nerantaps.data.tags.NPItemTags;
import com.nerantaps.registry.NPBlocks;
import com.nerantaps.registry.NPItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
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
        ShapedRecipeBuilder.shaped(NPBlocks.IRON_SANDSTONE.get()).define('#', NPBlocks.IRON_SAND.get()).pattern("##")
                .pattern("##").unlockedBy("has_iron_sand", has(NPBlocks.IRON_SAND.get())).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(NPItems.CYCAS_HELMET.get()).define('X', NPItems.CYCAS_BARK.get()).pattern("XXX")
                .pattern("X X").unlockedBy("has_cycas_bark", has(NPItems.CYCAS_BARK.get())).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(NPItems.CYCAS_CHESTPLATE.get()).define('X', NPItems.CYCAS_BARK.get()).pattern("X X").pattern("XXX")
                .pattern("XXX").unlockedBy("has_cycas_bark", has(NPItems.CYCAS_BARK.get())).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(NPItems.CYCAS_LEGGINGS.get()).define('X', NPItems.CYCAS_BARK.get()).pattern("XXX").pattern("X X")
                .pattern("X X").unlockedBy("has_cycas_bark", has(NPItems.CYCAS_BARK.get())).save(finishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(NPItems.CYCAS_BOOTS.get()).define('X', NPItems.CYCAS_BARK.get()).pattern("X X")
                .pattern("X X").unlockedBy("has_cycas_bark", has(NPItems.CYCAS_BARK.get())).save(finishedRecipeConsumer);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(NPItems.DICYNODON_MEAT.get()), NPItems.COOKED_DICYNODON_MEAT.get(), 0.2F, 200)
                .unlockedBy("has_dicynodon_meat", has(NPItems.DICYNODON_MEAT.get())).save(finishedRecipeConsumer);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(NPBlocks.ABYSMAL_SEA_ROCK.get()), Blocks.STONE.asItem(), 0.2F, 200)
                .unlockedBy("has_abysmal_sea_rock", has(NPBlocks.ABYSMAL_SEA_ROCK.get())).save(finishedRecipeConsumer);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(NPBlocks.RED_HOT_IRON_SAND.get()), Items.IRON_NUGGET, 0.2F, 200)
                .unlockedBy("has_red_hot_iron_sand", has(NPBlocks.RED_HOT_IRON_SAND.get())).save(finishedRecipeConsumer);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(NPBlocks.IRON_SAND.get()), Items.IRON_NUGGET, 0.2F, 200)
                .unlockedBy("has_iron_sand", has(NPBlocks.IRON_SAND.get())).save(finishedRecipeConsumer);
        nineBlockStorageRecipes(finishedRecipeConsumer, NPItems.SULFUR_POWDER.get(), NPBlocks.SULFUR_BLOCK.get());
        pressurePlate(finishedRecipeConsumer, NPBlocks.CYCAS_PRESSURE_PLATE.get(), NPBlocks.CYCAS_PLANKS.get());
        pressurePlate(finishedRecipeConsumer, NPBlocks.GLOW_PRESSURE_PLATE.get(), NPBlocks.GLOW_PLANKS.get());
        planksFromLogs(finishedRecipeConsumer, NPBlocks.CYCAS_PLANKS.get(), NPItemTags.CYCAS_LOGS);
        planksFromLogs(finishedRecipeConsumer, NPBlocks.GLOW_PLANKS.get(), NPItemTags.GLOW_LOGS);
        woodFromLogs(finishedRecipeConsumer, NPBlocks.CYCAS_WOOD.get(), NPBlocks.CYCAS_LOG.get());
        woodFromLogs(finishedRecipeConsumer, NPBlocks.GLOW_WOOD.get(), NPBlocks.GLOW_LOG.get());
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