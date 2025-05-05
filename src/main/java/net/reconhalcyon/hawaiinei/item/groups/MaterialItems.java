package net.reconhalcyon.hawaiinei.item.groups;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.reconhalcyon.hawaiinei.item.ModItems;
import net.reconhalcyon.hawaiinei.util.TooltipItem;

public class MaterialItems {
    public static final DeferredItem<Item> MORPHITE_INGOT = ModItems.ITEMS.register("morphite_ingot",
            () -> new TooltipItem(new Item.Properties(), "tooltip.hawaiinei.morphite_ingot"));
    public static final DeferredItem<Item> RAW_MORPHITE = ModItems.ITEMS.register("raw_morphite",
            () -> new TooltipItem(new Item.Properties(), "raw_morphite"));
}
