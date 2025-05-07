package net.reconhalcyon.hawaiinei.item;

import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.reconhalcyon.hawaiinei.HawaiiNei;
import net.reconhalcyon.hawaiinei.block.ModBlocks;
import net.reconhalcyon.hawaiinei.item.groups.FuelItems;
import net.reconhalcyon.hawaiinei.item.groups.FishItems;
import net.reconhalcyon.hawaiinei.item.groups.MaterialItems;
import net.reconhalcyon.hawaiinei.item.groups.ToolItems;
import net.reconhalcyon.hawaiinei.util.*;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(HawaiiNei.MOD_ID);

    // Material Items
    public static final DeferredItem<Item> RAW_MORPHITE = MaterialItems.RAW_MORPHITE;
    public static final DeferredItem<Item> MORPHITE_INGOT = MaterialItems.MORPHITE_INGOT;

    // Tool Items
    public static final DeferredItem<Item> MORPHITE_CHISEL = ToolItems.MORPHITE_CHISEL;
    public static final DeferredItem<Item> FISHING_SPEAR = ToolItems.FISHING_SPEAR;
    public static final DeferredItem<Item> ULUA_ROD = ToolItems.ULUA_ROD;
    public static final DeferredItem<Item> BOAT_ROD = ToolItems.BOAT_ROD;
    public static final DeferredItem<Item> NOT_SO_PRETTY_STIC = ToolItems.NOT_SO_PRETTY_STIC;

    // Crop & Plant Items
    public static final DeferredItem<Item> TI_LEAF = ITEMS.register("ti_leaf",
            () -> new TooltipItem(new Item.Properties(), "ti_leaf"));
    // 🌱 Special Block-Linked Items
    public static final DeferredItem<Item> TI_PLANT_STALK = ITEMS.register("ti_plant_stalk",
            () -> new ItemNameBlockItem(ModBlocks.TI_PLANT.get(), new Item.Properties()));

    // Food Items
    public static final DeferredItem<Item> POKE_BOWL = ITEMS.register("poke_bowl",
            () -> new TooltipItem(new Item.Properties().food(ModFoodProperties.POKE_BOWL), "poke_bowl"));

    // Hawaiian Fish
    public static final DeferredItem<Item> BLUEFIN_TREVALLY = FishItems.BLUEFIN_TREVALLY;
    public static final DeferredItem<Item> BONEFISH = FishItems.BONEFISH;
    public static final DeferredItem<Item> EYESTRIPE_SURGEONFISH = FishItems.EYESTRIPE_SURGEONFISH;
    public static final DeferredItem<Item> GREAT_BARRACUDA = FishItems.GREAT_BARRACUDA;
    public static final DeferredItem<Item> HOGFISH = FishItems.HOGFISH;
    public static final DeferredItem<Item> MACKEREL_SCAD = FishItems.MACKEREL_SCAD;
    public static final DeferredItem<Item> MARLIN = FishItems.MARLIN;
    public static final DeferredItem<Item> MILKFISH = FishItems.MILKFISH;
    public static final DeferredItem<Item> MOORISH_IDOL = FishItems.MOORISH_IDOL;
    public static final DeferredItem<Item> PINK_SNAPPER = FishItems.PINK_SNAPPER;
    public static final DeferredItem<Item> RACCOON_BUTTERFLYFISH = FishItems.RACCOON_BUTTERFLYFISH;
    public static final DeferredItem<Item> SKIPJACK_TUNA = FishItems.SKIPJACK_TUNA;
    public static final DeferredItem<Item> SQUIRRELFISH = FishItems.SQUIRRELFISH;
    public static final DeferredItem<Item> STRIPPED_MULLET = FishItems.STRIPPED_MULLET;
    public static final DeferredItem<Item> TRIGGERFISH = FishItems.TRIGGERFISH;
    public static final DeferredItem<Item> UNICORNFISH = FishItems.UNICORNFISH;
    public static final DeferredItem<Item> WRASSE = FishItems.WRASSE;
    public static final DeferredItem<Item> YELLOWFIN_TUNA = FishItems.YELLOWFIN_TUNA;

    // Custom Fuel Items
    public static final DeferredItem<Item> HOT_STONE = FuelItems.HOT_STONE;
    public static final DeferredItem<Item> HOT_SAND = FuelItems.HOT_SAND;
    public static final DeferredItem<Item> OHIA_LOG = FuelItems.OHIA_LOG;
    public static final DeferredItem<Item> OHIA_PLANKS = FuelItems.OHIA_PLANKS;
    public static final DeferredItem<Item> OHIA_SAPLING = FuelItems.OHIA_SAPLING;
    public static final DeferredItem<Item> HAU_LOG = FuelItems.HAU_LOG;
    public static final DeferredItem<Item> HAU_PLANKS = FuelItems.HAU_PLANKS;
    public static final DeferredItem<Item> HAU_SAPLING = FuelItems.HAU_SAPLING;
    public static final DeferredItem<Item> KUKUI_LOG = FuelItems.KUKUI_LOG;
    public static final DeferredItem<Item> KUKUI_PLANKS = FuelItems.KUKUI_PLANKS;
    public static final DeferredItem<Item> KUKUI_SAPLING = FuelItems.KUKUI_SAPLING;
    public static final DeferredItem<Item> KUKUI_OIL = FuelItems.KUKUI_OIL;
    public static final DeferredItem<Item> MACADAMIA_LOG = FuelItems.MACADAMIA_LOG;
    public static final DeferredItem<Item> MACADAMIA_PLANKS = FuelItems.MACADAMIA_PLANKS;
    public static final DeferredItem<Item> MACADAMIA_SAPLING = FuelItems.MACADAMIA_SAPLING;
    public static final DeferredItem<Item> MANGO_LOG = FuelItems.MANGO_LOG;
    public static final DeferredItem<Item> MANGO_PLANKS = FuelItems.MANGO_PLANKS;
    public static final DeferredItem<Item> MANGO_SAPLING = FuelItems.MANGO_SAPLING;
    public static final DeferredItem<Item> MILO_LOG = FuelItems.MILO_LOG;
    public static final DeferredItem<Item> MILO_PLANKS = FuelItems.MILO_PLANKS;
    public static final DeferredItem<Item> MILO_SAPLING = FuelItems.MILO_SAPLING;
    public static final DeferredItem<Item> NONI_LOG = FuelItems.NONI_LOG;
    public static final DeferredItem<Item> NONI_PLANKS = FuelItems.NONI_PLANKS;
    public static final DeferredItem<Item> NONI_SAPLING = FuelItems.NONI_SAPLING;
    public static final DeferredItem<Item> PAPAYA_LOG = FuelItems.PAPAYA_LOG;
    public static final DeferredItem<Item> PAPAYA_PLANKS = FuelItems.PAPAYA_PLANKS;
    public static final DeferredItem<Item> PAPAYA_SAPLING = FuelItems.PAPAYA_SAPLING;
    public static final DeferredItem<Item> SANDALWOOD_LOG = FuelItems.SANDALWOOD_LOG;
    public static final DeferredItem<Item> SANDALWOOD_PLANKS = FuelItems.SANDALWOOD_PLANKS;
    public static final DeferredItem<Item> SANDALWOOD_SAPLING = FuelItems.SANDALWOOD_SAPLING;
    public static final DeferredItem<Item> DRIED_TI_LEAF = FuelItems.DRIED_TI_LEAF;

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}