package net.reconhalcyon.hawaiinei.datagen;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.reconhalcyon.hawaiinei.block.ModBlocks;
import net.reconhalcyon.hawaiinei.block.custom.TiPlantBlock;
import net.reconhalcyon.hawaiinei.item.ModItems;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.MORPHITE_BLOCK.get());
        dropSelf(ModBlocks.MORPHITE_MAGIC_BLOCK.get());

        add(ModBlocks.MORPHITE_ORE.get(),
                block -> createOreDrop(ModBlocks.MORPHITE_ORE.get(), ModItems.RAW_MORPHITE.get()));
        add(ModBlocks.DEEPSLATE_MORPHITE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.DEEPSLATE_MORPHITE_ORE.get(), ModItems.RAW_MORPHITE.get(), 2, 5));

        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.TI_PLANT.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TiPlantBlock.AGE, 5));
        this.add(ModBlocks.TI_PLANT.get(), this.createCropDrops(ModBlocks.TI_PLANT.get(),
                ModItems.TI_LEAF.get(), ModItems.TI_PLANT_STALK.asItem(), lootItemConditionBuilder));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
