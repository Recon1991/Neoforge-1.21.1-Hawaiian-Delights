package net.reconhalcyon.hawaiinei.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.reconhalcyon.hawaiinei.HawaiiNei;
import net.reconhalcyon.hawaiinei.item.custom.ChiselItem;
import net.reconhalcyon.hawaiinei.item.custom.FuelItem;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(HawaiiNei.MOD_ID);

    public static final DeferredItem<Item> MORPHITE_INGOT = ITEMS.register("morphite_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_MORPHITE = ITEMS.register("raw_morphite",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> MORPHITE_CHISEL = ITEMS.register("morphite_chisel",
            () -> new ChiselItem(new Item.Properties().durability(1024)));

    public static final DeferredItem<Item> POKE_BOWL = ITEMS.register("poke_bowl",
            () -> new Item(new Item.Properties().food(ModFoodProperties.POKE_BOWL)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.hawaiinei.poke_bowl.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> HOT_STONE = ITEMS.register("hot_stone",
            () -> new FuelItem(new Item.Properties(), 800));
    public static final DeferredItem<Item> HOT_SAND = ITEMS.register("hot_sand",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
