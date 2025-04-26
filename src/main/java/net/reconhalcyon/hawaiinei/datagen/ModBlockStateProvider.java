package net.reconhalcyon.hawaiinei.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.reconhalcyon.hawaiinei.HawaiiNei;
import net.reconhalcyon.hawaiinei.block.ModBlocks;

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
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
