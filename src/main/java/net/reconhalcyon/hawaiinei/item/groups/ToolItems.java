package net.reconhalcyon.hawaiinei.item.groups;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.reconhalcyon.hawaiinei.util.TooltipChiselItem;
import net.reconhalcyon.hawaiinei.util.TooltipFishingRodItem;
import net.reconhalcyon.hawaiinei.util.TooltipFishingSpearItem;

import static net.reconhalcyon.hawaiinei.util.ItemRegistryHelper.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class ToolItems {
    public static final Map<String, DeferredItem<Item>> ALL = new LinkedHashMap<>();

    // Register List for 'Tool Items'
    public static final DeferredItem<Item> MORPHITE_CHISEL = registerTooltip(
            "morphite_chisel", TooltipChiselItem::new,
            new Item.Properties().durability(256).stacksTo(1), ALL);
    public static final DeferredItem<Item> FISHING_SPEAR = registerTooltip(
            "fishing_spear", TooltipFishingSpearItem::new,
            new Item.Properties().durability(64).stacksTo(1), ALL);
    public static final DeferredItem<Item> ULUA_ROD = registerTooltip(
            "ulua_rod", TooltipFishingRodItem::new,
            new Item.Properties().durability(128).stacksTo(1), ALL);
    public static final DeferredItem<Item> BOAT_ROD = registerTooltip(
            "boat_rod", TooltipFishingRodItem::new,
            new Item.Properties().durability(64).stacksTo(1), ALL);
    public static final DeferredItem<Item> NOT_SO_PRETTY_STIC = registerTooltip(
            "not_so_pretty_stic", TooltipFishingRodItem::new,
            new Item.Properties().durability(64).stacksTo(1), ALL);
}
