package net.reconhalcyon.hawaiinei.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;
import net.reconhalcyon.hawaiinei.HawaiiNei;
import net.reconhalcyon.hawaiinei.item.ModItems;
import net.reconhalcyon.hawaiinei.item.groups.FishItems;
import net.reconhalcyon.hawaiinei.util.ModTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, HawaiiNei.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(Items.BOWL);

        tag(ModTags.Items.HAWAIINEI_FISH)
                .add(FishItems.ALL.values().stream()
                        .map(DeferredItem::get)
                        .toArray(Item[]::new));

        tag(ItemTags.COW_FOOD)
                .add(ModItems.TI_LEAF.get())
                .add(ModItems.TI_PLANT_STALK.get());

        tag(ItemTags.PIG_FOOD)
                .add(ModItems.TI_LEAF.get())
                .add(ModItems.TI_PLANT_STALK.get());
    }
}
