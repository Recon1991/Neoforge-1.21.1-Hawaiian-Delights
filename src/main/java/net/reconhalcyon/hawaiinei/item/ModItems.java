package net.reconhalcyon.hawaiinei.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.reconhalcyon.hawaiinei.HawaiiNei;
import net.reconhalcyon.hawaiinei.item.custom.ChiselItem;
import net.reconhalcyon.hawaiinei.item.custom.FishingSpearItem;
import net.reconhalcyon.hawaiinei.item.custom.FuelItem;
import net.reconhalcyon.hawaiinei.util.TooltipUtils;

import java.util.List;
import javax.annotation.Nonnull;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(HawaiiNei.MOD_ID);

    // Custom Base Items
    public static final DeferredItem<Item> MORPHITE_INGOT = ITEMS.register("morphite_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_MORPHITE = ITEMS.register("raw_morphite",
            () -> new Item(new Item.Properties()));

    // Custom Tools
    public static final DeferredItem<Item> MORPHITE_CHISEL = ITEMS.register("morphite_chisel",
            () -> new ChiselItem(new Item.Properties().durability(1024).stacksTo(1)));
    public static final DeferredItem<Item> FISHING_SPEAR = ITEMS.register("fishing_spear",
            () -> new FishingSpearItem(new Item.Properties().durability(64).stacksTo(1)) {
                @Override
                public void appendHoverText(@Nonnull ItemStack stack, @Nonnull Item.TooltipContext context, @Nonnull List<Component> tooltipComponents, @Nonnull TooltipFlag tooltipFlag) {
                    TooltipUtils.addShiftTooltip(tooltipComponents, "tooltip.hawaiinei.fishing_spear");
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    // Custom Tools - Fishing Rods
    public static final DeferredItem<Item> ULUA_ROD = ITEMS.register("ulua_rod",
            () -> new FishingRodItem(new Item.Properties().durability(1024)){
                @Override
                public void appendHoverText(@Nonnull ItemStack stack, @Nonnull Item.TooltipContext context, @Nonnull List<Component> tooltipComponents, @Nonnull TooltipFlag tooltipFlag) {
                    TooltipUtils.addShiftTooltip(tooltipComponents,"tooltip.hawaiinei.ulua_rod");
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> BOAT_ROD = ITEMS.register("boat_rod",
            () -> new FishingRodItem(new Item.Properties().durability(1024)){
                @Override
                public void appendHoverText(@Nonnull ItemStack stack, @Nonnull Item.TooltipContext context, @Nonnull List<Component> tooltipComponents, @Nonnull TooltipFlag tooltipFlag) {
                    TooltipUtils.addShiftTooltip(tooltipComponents,"tooltip.hawaiinei.boat_rod");
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> NOT_SO_PRETTY_STIC = ITEMS.register("not_so_pretty_stic",
            () -> new FishingRodItem(new Item.Properties().durability(1024)){
                @Override
                public void appendHoverText(@Nonnull ItemStack stack, @Nonnull Item.TooltipContext context, @Nonnull List<Component> tooltipComponents, @Nonnull TooltipFlag tooltipFlag) {
                    TooltipUtils.addShiftTooltip(tooltipComponents,"tooltip.hawaiinei.not_so_pretty_stic");
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    // Custom Food
    public static final DeferredItem<Item> POKE_BOWL = ITEMS.register("poke_bowl",
            () -> new Item(new Item.Properties().food(ModFoodProperties.POKE_BOWL)){
                @Override
                public void appendHoverText(@Nonnull ItemStack stack, @Nonnull TooltipContext context, @Nonnull List<Component> tooltipComponents, @Nonnull TooltipFlag tooltipFlag) {
                    TooltipUtils.addShiftTooltip(tooltipComponents,"tooltip.hawaiinei.poke_bowl");
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    // Hawaiian Fish
    public static final DeferredItem<Item> YELLOWFIN_TUNA = ITEMS.register("yellowfin_tuna",
            () -> new Item(new Item.Properties()));

    // Custom Fuel
    public static final DeferredItem<Item> HOT_STONE = ITEMS.register("hot_stone",
            () -> new FuelItem(new Item.Properties(), 800));
    public static final DeferredItem<Item> HOT_SAND = ITEMS.register("hot_sand",
            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

