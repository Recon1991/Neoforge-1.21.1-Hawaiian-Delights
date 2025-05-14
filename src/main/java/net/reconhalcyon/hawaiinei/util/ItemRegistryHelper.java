package net.reconhalcyon.hawaiinei.util;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.reconhalcyon.hawaiinei.item.ModItems;
import net.reconhalcyon.hawaiinei.util.TooltipFuelItem;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class ItemRegistryHelper {

    public static DeferredItem<Item> registerBasic(String name, Map<String, DeferredItem<Item>> allMap) {
        return register(name, () -> new Item(new Item.Properties()), allMap);
    }
    public static DeferredItem<Item> registerWithProperties(String name, Item.Properties props, Map<String, DeferredItem<Item>> allMap) {
        return register(name, () -> new Item(props), allMap);
    }
    public static DeferredItem<Item> registerTooltip(String name, Item.Properties props, Map<String, DeferredItem<Item>> allMap) {
        return register(name, () -> new TooltipItem(props, name), allMap);
    }
    public static DeferredItem<Item> registerTooltipFishingRod(String name, Item.Properties props, Map<String, DeferredItem<Item>> allMap) {
        return register(name, () -> new TooltipFishingRodItem(props, name), allMap);
    }
    public static DeferredItem<Item> registerTooltipChisel(String name, Item.Properties props, Map<String, DeferredItem<Item>> allMap) {
        return register(name, () -> new TooltipChiselItem(props, name), allMap);
    }
    public static DeferredItem<Item> registerTooltipFishingSpear(String name, Item.Properties props, Map<String, DeferredItem<Item>> allMap) {
        return register(name, () -> new TooltipFishingSpearItem(props, name), allMap);
    }

    private static DeferredItem<Item> register(String name, Supplier<Item> supplier, Map<String, DeferredItem<Item>> allMap) {
        DeferredItem<Item> item = ModItems.ITEMS.register(name, supplier);
        allMap.put(name, item);
        return item;
    }

    public static <T extends Item> DeferredItem<Item> registerTooltip(
            String name,
            BiFunction<Item.Properties, String, T> constructor,
            Item.Properties props,
            Map<String, DeferredItem<Item>> allMap
    ) {
        DeferredItem<Item> item = ModItems.ITEMS.register(name, () -> constructor.apply(props, name));
        allMap.put(name, item);
        return item;
    }

    public static DeferredItem<Item> registerTooltipFuel(
            String name,
            Item.Properties props,
            int burnTime,
            Map<String, DeferredItem<Item>> allMap
    ) {
        DeferredItem<Item> item = ModItems.ITEMS.register(name,
                () -> new TooltipFuelItem(props, burnTime, name));
        allMap.put(name, item);
        return item;
    }

    public static DeferredItem<Item> registerTooltipFish(
            String name,
            Item.Properties props,
            String biome,
            String rarity,
            boolean spearCatchable,
            Map<String, DeferredItem<Item>> allMap
    ) {
        DeferredItem<Item> item = ModItems.ITEMS.register(name, () ->
                new TooltipFishItem(props, name)
                        .fishBiome(biome)
                        .fishRarity(rarity)
                        .spearCatchable(spearCatchable)
        );

        allMap.put(name, item);
        return item;
    }

}
