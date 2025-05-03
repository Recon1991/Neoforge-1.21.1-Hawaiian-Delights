package net.reconhalcyon.hawaiinei.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.reconhalcyon.hawaiinei.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    // NOTE: gather is deprecated, will need to refactor in newer versions
    @SuppressWarnings("deprecation")
    @Override
    protected void gather() {
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModItems.HOT_SAND.getId(), new FurnaceFuel(800), false)
                .add(ModItems.HOT_STONE.getId(), new FurnaceFuel(1200), false);

        this.builder(NeoForgeDataMaps.COMPOSTABLES)
                .add(ModItems.TI_LEAF.getId(), new Compostable(0.6F, true), false)
                .add(ModItems.TI_PLANT_STALK.getId(), new Compostable(0.8F, true), false);

    }

}
