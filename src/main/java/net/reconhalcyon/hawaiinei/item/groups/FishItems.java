package net.reconhalcyon.hawaiinei.item.groups;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.reconhalcyon.hawaiinei.item.ModItems;
import net.reconhalcyon.hawaiinei.util.TooltipItem;

import java.util.LinkedHashMap;
import java.util.Map;

public class FishItems {
    public static final Map<String, DeferredItem<Item>> ALL = new LinkedHashMap<>();

    public static final DeferredItem<Item> BONEFISH = ITEMS.register("bonefish",
            () -> new TooltipItem(new Item.Properties()));
    public static final DeferredItem<Item> EYESTRIPE_SURGEONFISH = ITEMS.register("eyestripe_surgeonfish",
            () -> new TooltipItem(new Item.Properties()));
    public static final DeferredItem<Item> SQUIRRELFISH = ITEMS.register("squirrelfish",
            () -> new TooltipItem(new Item.Properties()));
    public static final DeferredItem<Item> HOGFISH = ITEMS.register("hogfish",
            () -> new TooltipItem(new Item.Properties()));
    public static final DeferredItem<Item> STRIPPED_MULLET = ITEMS.register("stripped_mullet",
            () -> new TooltipItem(new Item.Properties()));
    public static final DeferredItem<Item> YELLOWFIN_TUNA = ITEMS.register("yellowfin_tuna",
            () -> new TooltipItem(new Item.Properties()));

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
