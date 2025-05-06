package net.reconhalcyon.hawaiinei.item.groups;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.reconhalcyon.hawaiinei.item.ModItems;
import net.reconhalcyon.hawaiinei.util.TooltipChiselItem;
import net.reconhalcyon.hawaiinei.util.TooltipFishingRodItem;
import net.reconhalcyon.hawaiinei.util.TooltipFishingSpearItem;

import java.util.LinkedHashMap;
import java.util.Map;

public class ToolItems {
    public static final Map<String, DeferredItem<Item>> ALL = new LinkedHashMap<>();

    // Register List for 'Tool Items'
    public static final DeferredItem<Item> MORPHITE_CHISEL = registerChiselTooltip("morphite_chisel", new Item.Properties().durability(1024).stacksTo(1));
    public static final DeferredItem<Item> FISHING_SPEAR = registerFishingSpearTooltip("fishing_spear", new Item.Properties().durability(1024).stacksTo(1));
    public static final DeferredItem<Item> ULUA_ROD = registerFishingRodTooltip("ulua_rod", new Item.Properties().durability(1024).stacksTo(1));
    public static final DeferredItem<Item> BOAT_ROD = registerFishingRodTooltip("boat_rod", new Item.Properties().durability(1024).stacksTo(1));
    public static final DeferredItem<Item> NOT_SO_PRETTY_STIC = registerFishingRodTooltip("not_so_pretty_stic", new Item.Properties().durability(1024).stacksTo(1));

    // Register Tool Items to Tooltip classes
    private static DeferredItem<Item> registerChiselTooltip(String name, Item.Properties props) {
        DeferredItem<Item> item = ModItems.ITEMS.register(name,
                () -> new TooltipChiselItem(props, name));
        ALL.put(name, item);
        return item;
    }
    private static DeferredItem<Item> registerFishingSpearTooltip(String name, Item.Properties props) {
        DeferredItem<Item> item = ModItems.ITEMS.register(name,
                () -> new TooltipFishingSpearItem(props, name));
        ALL.put(name, item);
        return item;
    }
    private static DeferredItem<Item> registerFishingRodTooltip(String name, Item.Properties props) {
        DeferredItem<Item> item = ModItems.ITEMS.register(name,
                () -> new TooltipFishingRodItem(props, name));
        ALL.put(name, item);
        return item;
    }
}
