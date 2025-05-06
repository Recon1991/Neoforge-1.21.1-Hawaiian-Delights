package net.reconhalcyon.hawaiinei.item.groups;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.reconhalcyon.hawaiinei.item.ModItems;
import net.reconhalcyon.hawaiinei.util.TooltipItem;

import java.util.LinkedHashMap;
import java.util.Map;

public class MaterialItems {
    public static final Map<String, DeferredItem<Item>> ALL = new LinkedHashMap<>();

    public static final DeferredItem<Item> MORPHITE_INGOT = registerTooltip("morphite_ingot");
    public static final DeferredItem<Item> RAW_MORPHITE = registerTooltip("raw_morphite");

    private static DeferredItem<Item> registerTooltip(String name) {
        DeferredItem<Item> item = ModItems.ITEMS.register(name,
                () -> new TooltipItem(new Item.Properties(), name));
        ALL.put(name, item);
        return item;
    }

    private static DeferredItem<Item> registerBasic(String name) {
        DeferredItem<Item> item = ModItems.ITEMS.register(name,
                () -> new Item(new Item.Properties()));
        ALL.put(name, item);
        return item;
    }
}
