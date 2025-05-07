package net.reconhalcyon.hawaiinei.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.reconhalcyon.hawaiinei.HawaiiNei;
import net.reconhalcyon.hawaiinei.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HawaiiNei.MOD_ID);

    public static final Supplier<CreativeModeTab> PREVIEW_ITEMS_TAB = CREATIVE_MODE_TAB.register("hawaiinei_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.MORPHITE_INGOT.get()))
                    .title(Component.translatable("creativetab.hawaiinei.hawaiinei_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.MORPHITE_INGOT);
                        output.accept(ModItems.RAW_MORPHITE);
                        output.accept(ModItems.MORPHITE_CHISEL);
                        output.accept(ModItems.POKE_BOWL);
                        output.accept(ModItems.HOT_SAND);
                        output.accept(ModItems.HOT_STONE);
                        output.accept(ModItems.ULUA_ROD);
                        output.accept(ModItems.BOAT_ROD);
                        output.accept(ModItems.NOT_SO_PRETTY_STIC);
                        output.accept(ModItems.FISHING_SPEAR);
                        output.accept(ModItems.TI_PLANT_STALK);
                        output.accept(ModBlocks.HIBISCUS_RED);

                    }).build());

    public static final Supplier<CreativeModeTab> PREVIEW_BLOCK_TAB = CREATIVE_MODE_TAB.register("hawaiinei_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.MORPHITE_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(HawaiiNei.MOD_ID, "hawaiinei_items_tab"))
                    .title(Component.translatable("creativetab.hawaiinei.hawaiinei_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.MORPHITE_BLOCK);
                        output.accept(ModBlocks.MORPHITE_ORE);
                        output.accept(ModBlocks.DEEPSLATE_MORPHITE_ORE);
                        output.accept(ModBlocks.MORPHITE_MAGIC_BLOCK);

                    }).build());

    public static final Supplier<CreativeModeTab> PREVIEW_FISH_TAB = CREATIVE_MODE_TAB.register("hawaiinei_fish_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.YELLOWFIN_TUNA.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(HawaiiNei.MOD_ID, "hawaiinei_blocks_tab"))
                    .title(Component.translatable("creativetab.hawaiinei.hawaiinei_fish"))
                    .displayItems((itemDisplayParameters, output) -> {
                        net.reconhalcyon.hawaiinei.item.groups.FishItems.ALL.values().forEach(item -> output.accept(item.get()));
                    }).build());

    public static final Supplier<CreativeModeTab> PREVIEW_FUEL_TAB = CREATIVE_MODE_TAB.register("hawaiinei_fuel_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.HOT_STONE.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(HawaiiNei.MOD_ID, "hawaiinei_fish_tab"))
                    .title(Component.translatable("creativetab.hawaiinei.hawaiinei_fuels"))
                    .displayItems((itemDisplayParameters, output) -> {
                        net.reconhalcyon.hawaiinei.item.groups.FuelItems.ALL.values().forEach(item -> output.accept(item.get()));
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }


}
