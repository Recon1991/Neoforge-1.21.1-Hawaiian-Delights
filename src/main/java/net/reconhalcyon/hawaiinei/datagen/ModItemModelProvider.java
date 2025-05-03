package net.reconhalcyon.hawaiinei.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.reconhalcyon.hawaiinei.HawaiiNei;
import net.reconhalcyon.hawaiinei.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper){
        super(output, HawaiiNei.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Ores and Ingots
        basicItem(ModItems.RAW_MORPHITE.get());
        basicItem(ModItems.MORPHITE_INGOT.get());

        // Tools
        basicItem(ModItems.MORPHITE_CHISEL.get());
        basicItem(ModItems.ULUA_ROD.get());
        basicItem(ModItems.BOAT_ROD.get());
        basicItem(ModItems.NOT_SO_PRETTY_STIC.get());
        basicItem(ModItems.FISHING_SPEAR.get());

        // Food Items
        basicItem(ModItems.POKE_BOWL.get());

        // Hawaiian Fish
        basicItem(ModItems.YELLOWFIN_TUNA.get());

        // Fuel Items
        basicItem(ModItems.HOT_SAND.get());
        basicItem(ModItems.HOT_STONE.get());

        // Crops & Plants
        basicItem(ModItems.TI_LEAF.get());
        basicItem(ModItems.TI_PLANT_STALK.get());
    }
}
