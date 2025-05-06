package net.reconhalcyon.hawaiinei.item.groups;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.reconhalcyon.hawaiinei.util.TooltipItem;

import java.util.LinkedHashMap;
import java.util.Map;

import static net.reconhalcyon.hawaiinei.util.ItemRegistryHelper.*;

public class MaterialItems {
    public static final Map<String, DeferredItem<Item>> ALL = new LinkedHashMap<>();

    public static final DeferredItem<Item> MORPHITE_INGOT = registerTooltip(
            "morphite_ingot", TooltipItem::new,
            new Item.Properties(), ALL);
    public static final DeferredItem<Item> RAW_MORPHITE = registerTooltip(
            "raw_morphite", TooltipItem::new,
            new Item.Properties(), ALL);

}
