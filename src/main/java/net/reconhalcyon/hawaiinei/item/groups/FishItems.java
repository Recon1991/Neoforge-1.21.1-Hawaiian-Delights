package net.reconhalcyon.hawaiinei.item.groups;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.reconhalcyon.hawaiinei.item.ModItems;
import net.reconhalcyon.hawaiinei.util.TooltipItem;

import java.util.LinkedHashMap;
import java.util.Map;

import static net.reconhalcyon.hawaiinei.util.ItemRegistryHelper.registerTooltip;

public class FishItems {
    public static final Map<String, DeferredItem<Item>> ALL = new LinkedHashMap<>();

    public static final DeferredItem<Item> BLUEFIN_TREVALLY = registerTooltip("bluefin_trevally", TooltipItem::new, new Item.Properties(), ALL);
    public static final DeferredItem<Item> BONEFISH = registerTooltip("bonefish", TooltipItem::new, new Item.Properties(), ALL);
    public static final DeferredItem<Item> EYESTRIPE_SURGEONFISH = registerTooltip("eyestripe_surgeonfish", TooltipItem::new, new Item.Properties(), ALL);
    public static final DeferredItem<Item> GREAT_BARRACUDA = registerTooltip("great_barracuda", TooltipItem::new, new Item.Properties(), ALL);
    public static final DeferredItem<Item> HOGFISH = registerTooltip("hogfish", TooltipItem::new, new Item.Properties(), ALL);
    public static final DeferredItem<Item> MACKEREL_SCAD = registerTooltip("mackerel_scad", TooltipItem::new, new Item.Properties(), ALL);
    public static final DeferredItem<Item> MARLIN = registerTooltip("marlin", TooltipItem::new, new Item.Properties(), ALL);
    public static final DeferredItem<Item> MILKFISH = registerTooltip("milkfish", TooltipItem::new, new Item.Properties(), ALL);
    public static final DeferredItem<Item> MOORISH_IDOL = registerTooltip("moorish_idol", TooltipItem::new, new Item.Properties(), ALL);
    public static final DeferredItem<Item> PINK_SNAPPER = registerTooltip("pink_snapper", TooltipItem::new, new Item.Properties(), ALL);
    public static final DeferredItem<Item> RACCOON_BUTTERFLYFISH = registerTooltip("raccoon_butterflyfish", TooltipItem::new, new Item.Properties(), ALL);
    public static final DeferredItem<Item> SKIPJACK_TUNA = registerTooltip("skipjack_tuna", TooltipItem::new, new Item.Properties(), ALL);
    public static final DeferredItem<Item> SQUIRRELFISH = registerTooltip("squirrelfish", TooltipItem::new, new Item.Properties(), ALL);
    public static final DeferredItem<Item> STRIPPED_MULLET = registerTooltip("stripped_mullet", TooltipItem::new, new Item.Properties(), ALL);
    public static final DeferredItem<Item> TRIGGERFISH = registerTooltip("triggerfish", TooltipItem::new, new Item.Properties(), ALL);
    public static final DeferredItem<Item> UNICORNFISH = registerTooltip("unicornfish", TooltipItem::new, new Item.Properties(), ALL);
    public static final DeferredItem<Item> WRASSE = registerTooltip("wrasse", TooltipItem::new, new Item.Properties(), ALL);
    public static final DeferredItem<Item> YELLOWFIN_TUNA = registerTooltip("yellowfin_tuna", TooltipItem::new, new Item.Properties(), ALL);

}
