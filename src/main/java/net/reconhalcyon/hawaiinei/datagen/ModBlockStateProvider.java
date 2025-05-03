package net.reconhalcyon.hawaiinei.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.reconhalcyon.hawaiinei.HawaiiNei;
import net.reconhalcyon.hawaiinei.block.ModBlocks;
import net.reconhalcyon.hawaiinei.block.custom.TiPlantBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper){
        super(output, HawaiiNei.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.MORPHITE_BLOCK);

        blockWithItem(ModBlocks.MORPHITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_MORPHITE_ORE);

        blockWithItem(ModBlocks.MORPHITE_MAGIC_BLOCK);

        makeCrop(((TiPlantBlock) ModBlocks.TI_PLANT.get()), "ti_plant_stage", "ti_plant_stage");

        simpleBlock(ModBlocks.HIBISCUS_RED.get(),
                models().cross(blockTexture(ModBlocks.HIBISCUS_RED.get()).getPath(), blockTexture(ModBlocks.HIBISCUS_RED.get())).renderType("cutout"));
        simpleBlock(ModBlocks.POTTED_HIBISCUS_RED.get(), models().singleTexture("potted_hibiscus_red", ResourceLocation.parse("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.HIBISCUS_RED.get())).renderType("cutout"));
    }

    private void leavesBlock(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(),
                models().singleTexture(deferredBlock.getId().getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(deferredBlock.get())).renderType("cutout"));
    }

    public void makeCrop(CropBlock block, String modelName, String textureName){
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((TiPlantBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(HawaiiNei.MOD_ID, "block/" + textureName +
                        state.getValue(((TiPlantBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("hawaiinei:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("hawaiinei:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
