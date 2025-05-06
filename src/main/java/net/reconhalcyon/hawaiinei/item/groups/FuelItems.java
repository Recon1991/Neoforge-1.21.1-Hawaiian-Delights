package net.reconhalcyon.hawaiinei.item.groups;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.LinkedHashMap;
import java.util.Map;

import static net.reconhalcyon.hawaiinei.util.ItemRegistryHelper.registerTooltipFuel;

public class FuelItems {
    public static final Map<String, DeferredItem<Item>> ALL = new LinkedHashMap<>();

    // Hot Items
    public static final DeferredItem<Item> HOT_STONE = registerTooltipFuel("hot_stone", new Item.Properties(), 800, ALL);
    public static final DeferredItem<Item> HOT_SAND = registerTooltipFuel("hot_sand", new Item.Properties(),800, ALL);

    // 'Ōhiʻa Lehua
    public static final DeferredItem<Item> OHIA_LOG = registerTooltipFuel("ohia_log", new Item.Properties(), 300, ALL);
    public static final DeferredItem<Item> OHIA_PLANKS = registerTooltipFuel("ohia_planks", new Item.Properties(), 150, ALL);
    public static final DeferredItem<Item> OHIA_SAPLING = registerTooltipFuel("ohia_sapling", new Item.Properties(), 100, ALL);

    // Hau
    public static final DeferredItem<Item> HAU_LOG = registerTooltipFuel("hau_log", new Item.Properties(), 300, ALL);
    public static final DeferredItem<Item> HAU_PLANKS = registerTooltipFuel("hau_planks", new Item.Properties(), 150, ALL);
    public static final DeferredItem<Item> HAU_SAPLING = registerTooltipFuel("hau_sapling", new Item.Properties(), 100, ALL);

    // Kukui
    public static final DeferredItem<Item> KUKUI_LOG = registerTooltipFuel("kukui_log", new Item.Properties(), 300, ALL);
    public static final DeferredItem<Item> KUKUI_PLANKS = registerTooltipFuel("kukui_planks", new Item.Properties(), 150, ALL);
    public static final DeferredItem<Item> KUKUI_SAPLING = registerTooltipFuel("kukui_sapling", new Item.Properties(), 100, ALL);
    public static final DeferredItem<Item> KUKUI_OIL = registerTooltipFuel("kukui_oil", new Item.Properties(), 1600, ALL);

    // Macadamia
    public static final DeferredItem<Item> MACADAMIA_LOG = registerTooltipFuel("macadamia_log", new Item.Properties(), 300, ALL);
    public static final DeferredItem<Item> MACADAMIA_PLANKS = registerTooltipFuel("macadamia_planks", new Item.Properties(), 150, ALL);
    public static final DeferredItem<Item> MACADAMIA_SAPLING = registerTooltipFuel("macadamia_sapling", new Item.Properties(), 100, ALL);

    // Mango
    public static final DeferredItem<Item> MANGO_LOG = registerTooltipFuel("mango_log", new Item.Properties(), 300, ALL);
    public static final DeferredItem<Item> MANGO_PLANKS = registerTooltipFuel("mango_planks", new Item.Properties(), 150, ALL);
    public static final DeferredItem<Item> MANGO_SAPLING = registerTooltipFuel("mango_sapling", new Item.Properties(), 100, ALL);

    // Milo
    public static final DeferredItem<Item> MILO_LOG = registerTooltipFuel("milo_log", new Item.Properties(), 300, ALL);
    public static final DeferredItem<Item> MILO_PLANKS = registerTooltipFuel("milo_planks", new Item.Properties(), 150, ALL);
    public static final DeferredItem<Item> MILO_SAPLING = registerTooltipFuel("milo_sapling", new Item.Properties(), 100, ALL);

    // Noni
    public static final DeferredItem<Item> NONI_LOG = registerTooltipFuel("noni_log", new Item.Properties(), 300, ALL);
    public static final DeferredItem<Item> NONI_PLANKS = registerTooltipFuel("noni_planks", new Item.Properties(), 150, ALL);
    public static final DeferredItem<Item> NONI_SAPLING = registerTooltipFuel("noni_sapling", new Item.Properties(), 100, ALL);

    // Papaya
    public static final DeferredItem<Item> PAPAYA_LOG = registerTooltipFuel("papaya_log", new Item.Properties(), 300, ALL);
    public static final DeferredItem<Item> PAPAYA_PLANKS = registerTooltipFuel("papaya_planks", new Item.Properties(), 150, ALL);
    public static final DeferredItem<Item> PAPAYA_SAPLING = registerTooltipFuel("papaya_sapling", new Item.Properties(), 100, ALL);

    // Sandalwood
    public static final DeferredItem<Item> SANDALWOOD_LOG = registerTooltipFuel("sandalwood_log", new Item.Properties(), 300, ALL);
    public static final DeferredItem<Item> SANDALWOOD_PLANKS = registerTooltipFuel("sandalwood_planks", new Item.Properties(), 150, ALL);
    public static final DeferredItem<Item> SANDALWOOD_SAPLING = registerTooltipFuel("sandalwood_sapling", new Item.Properties(), 100, ALL);

    // Dried Ti Leaf
    public static final DeferredItem<Item> DRIED_TI_LEAF = registerTooltipFuel("dried_ti_leaf", new Item.Properties(), 200, ALL);

}
