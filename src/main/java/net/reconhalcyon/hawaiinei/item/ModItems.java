package net.reconhalcyon.hawaiinei.item;

import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.reconhalcyon.hawaiinei.HawaiiNei;
import net.reconhalcyon.hawaiinei.block.ModBlocks;
import net.reconhalcyon.hawaiinei.item.custom.FuelItem;
import net.reconhalcyon.hawaiinei.item.groups.FishItems;
import net.reconhalcyon.hawaiinei.item.groups.MaterialItems;
import net.reconhalcyon.hawaiinei.util.*;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(HawaiiNei.MOD_ID);

    // Materials
    public static final DeferredItem<Item> RAW_MORPHITE = MaterialItems.RAW_MORPHITE;
    public static final DeferredItem<Item> MORPHITE_INGOT = MaterialItems.MORPHITE_INGOT;

    // Custom Tools

    public static final DeferredItem<Item> FISHING_SPEAR = ITEMS.register("fishing_spear",
            () -> new TooltipFishingSpearItem(new Item.Properties().durability(64).stacksTo(1), TooltipKeys.of("fishing_spear")));
    public static final DeferredItem<Item> ULUA_ROD = ITEMS.register("ulua_rod",
            () -> new TooltipFishingRodItem(new Item.Properties().durability(1024), "tooltip.hawaiinei.ulua_rod"));
    public static final DeferredItem<Item> BOAT_ROD = ITEMS.register("boat_rod",
            () -> new TooltipFishingRodItem(new Item.Properties().durability(1024), "tooltip.hawaiinei.boat_rod"));
    public static final DeferredItem<Item> NOT_SO_PRETTY_STIC = ITEMS.register("not_so_pretty_stic",
            () -> new TooltipFishingRodItem(new Item.Properties().durability(1024), "tooltip.hawaiinei.not_so_pretty_stic"));

    // Custom Crops & Plants
    public static final DeferredItem<Item> TI_LEAF = ITEMS.register("ti_leaf",
            () -> new TooltipItem(new Item.Properties(), "ti_leaf"));
    public static final DeferredItem<Item> TI_PLANT_STALK = ITEMS.register("ti_plant_stalk",
            () -> new ItemNameBlockItem(ModBlocks.TI_PLANT.get(), new Item.Properties()));

    // Custom Food
    public static final DeferredItem<Item> POKE_BOWL = ITEMS.register("poke_bowl",
            () -> new TooltipItem(new Item.Properties().food(ModFoodProperties.POKE_BOWL), "poke_bowl"));

    // Hawaiian Fish
    public static final DeferredItem<Item> BONEFISH = FishItems.BONEFISH;
    public static final DeferredItem<Item> EYESTRIPE_SURGEONFISH = FishItems.EYESTRIPE_SURGEONFISH;
    public static final DeferredItem<Item> SQUIRRELFISH = FishItems.SQUIRRELFISH;
    public static final DeferredItem<Item> HOGFISH = FishItems.HOGFISH;
    public static final DeferredItem<Item> STRIPPED_MULLET = FishItems.STRIPPED_MULLET;
    public static final DeferredItem<Item> YELLOWFIN_TUNA = FishItems.YELLOWFIN_TUNA;

    // Custom Fuel
    public static final DeferredItem<Item> HOT_STONE = ITEMS.register("hot_stone",
            () -> new FuelItem(new Item.Properties(), 800));
    public static final DeferredItem<Item> HOT_SAND = ITEMS.register("hot_sand",
            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}