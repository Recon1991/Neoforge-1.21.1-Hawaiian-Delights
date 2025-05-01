package net.reconhalcyon.hawaiinei.datagen;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.reconhalcyon.hawaiinei.HawaiiNei;
import net.reconhalcyon.hawaiinei.block.ModBlocks;
import net.reconhalcyon.hawaiinei.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> MORPHITE_SMELTABLES = List.of(ModItems.RAW_MORPHITE,
                ModBlocks.MORPHITE_ORE, ModBlocks.DEEPSLATE_MORPHITE_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MORPHITE_BLOCK.get())
                .pattern("MMM")
                .pattern("MMM")
                .pattern("MMM")
                .define('M', ModItems.MORPHITE_INGOT.get())
                .unlockedBy("has_morphite_ingot", has(ModItems.MORPHITE_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ULUA_ROD.get())
                .define('#', Items.STICK)
                .define('X', Items.STRING)
                .define('T', Items.IRON_INGOT)
                .pattern("  #")
                .pattern(" TX")
                .pattern("# X")
                .unlockedBy("has_string", has(Items.STRING))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BOAT_ROD.get())
                .define('#', Items.STICK)
                .define('X', Items.STRING)
                .define('T', Items.IRON_INGOT)
                .pattern("  T")
                .pattern(" #X")
                .pattern("# X")
                .unlockedBy("has_string", has(Items.STRING))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NOT_SO_PRETTY_STIC.get())
                .define('#', Items.STICK)
                .define('X', Items.STRING)
                .define('T', Items.IRON_INGOT)
                .pattern("  #")
                .pattern(" #X")
                .pattern("T X")
                .unlockedBy("has_string", has(Items.STRING))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MORPHITE_INGOT.get(), 9)
                .requires(ModBlocks.MORPHITE_BLOCK)
                .unlockedBy("has_morphite_block", has(ModBlocks.MORPHITE_BLOCK))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MORPHITE_INGOT.get(), 18)
                .requires(ModBlocks.MORPHITE_MAGIC_BLOCK)
                .unlockedBy("has_morphite_magic_block", has(ModBlocks.MORPHITE_BLOCK))
                .save(recipeOutput, "hawaiinei:morphite_ingot_from_morphite_magic_block");

        oreSmelting(recipeOutput, MORPHITE_SMELTABLES, RecipeCategory.MISC, ModItems.MORPHITE_INGOT.get(), 0.25f, 200, "morphite");
        oreBlasting(recipeOutput, MORPHITE_SMELTABLES, RecipeCategory.MISC, ModItems.MORPHITE_INGOT.get(), 0.25f, 100, "morphite");
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer,
                                                                       AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory,
                                                                       ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemLike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemLike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory)
                    .group(pGroup).unlockedBy(getHasName(itemLike), has(itemLike))
                    .save(recipeOutput, HawaiiNei.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemLike));
        }
    }
}

