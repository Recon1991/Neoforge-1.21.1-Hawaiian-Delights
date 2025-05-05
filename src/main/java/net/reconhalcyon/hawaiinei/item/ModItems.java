package net.reconhalcyon.hawaiinei.item;

import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.reconhalcyon.hawaiinei.HawaiiNei;
import net.reconhalcyon.hawaiinei.block.ModBlocks;
import net.reconhalcyon.hawaiinei.item.custom.FuelItem;
import net.reconhalcyon.hawaiinei.util.*;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(HawaiiNei.MOD_ID);

    // Custom Tools
    public static final DeferredItem<Item> MORPHITE_CHISEL = ITEMS.register("morphite_chisel",
            () -> new TooltipChiselItem(new Item.Properties().durability(1024).stacksTo(1), "tooltip.hawaiinei."));

    // Custom Tools - Fishing Spears
    public static final DeferredItem<Item> FISHING_SPEAR = ITEMS.register("fishing_spear",
            () -> new TooltipFishingSpearItem(new Item.Properties().durability(64).stacksTo(1), TooltipKeys.of("fishing_spear")));

    // Custom Tools - Fishing Rods
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
    public static final DeferredItem<Item> BONEFISH = ITEMS.register("bonefish",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> EYESTRIPE_SURGEONFISH = ITEMS.register("eyestripe_surgeonfish",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SQUIRRELFISH = ITEMS.register("squirrelfish",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> HOGFISH = ITEMS.register("hogfish",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_MULLET = ITEMS.register("stripped_mullet",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> YELLOWFIN_TUNA = ITEMS.register("yellowfin_tuna",
            () -> new Item(new Item.Properties()));

    // Custom Fuel
    public static final DeferredItem<Item> HOT_STONE = ITEMS.register("hot_stone",
            () -> new FuelItem(new Item.Properties(), 800));
    public static final DeferredItem<Item> HOT_SAND = ITEMS.register("hot_sand",
            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}