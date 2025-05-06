package net.reconhalcyon.hawaiinei.item.groups;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.reconhalcyon.hawaiinei.item.ModItems;
import net.reconhalcyon.hawaiinei.util.TooltipItem;

import java.util.LinkedHashMap;
import java.util.Map;

public class FishItems {
    public static final Map<String, DeferredItem<Item>> ALL = new LinkedHashMap<>();

    public static final DeferredItem<Item> BONEFISH = registerTooltip("bonefish");
    public static final DeferredItem<Item> EYESTRIPE_SURGEONFISH = registerTooltip("eyestripe_surgeonfish");
    public static final DeferredItem<Item> SQUIRRELFISH = registerTooltip("squirrelfish");
    public static final DeferredItem<Item> HOGFISH = registerTooltip("hogfish");
    public static final DeferredItem<Item> STRIPPED_MULLET = registerTooltip("stripped_mullet");
    public static final DeferredItem<Item> YELLOWFIN_TUNA = registerTooltip("yellowfin_tuna");

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
