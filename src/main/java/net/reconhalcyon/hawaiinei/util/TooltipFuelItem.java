package net.reconhalcyon.hawaiinei.util;

import net.minecraft.world.item.ItemStack;
import net.reconhalcyon.hawaiinei.item.custom.FuelItem;
import net.reconhalcyon.hawaiinei.util.TooltipUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

import javax.annotation.Nonnull;

public class TooltipFuelItem extends FuelItem {
    private final String tooltipKey;

    public TooltipFuelItem(Properties properties, int burnTime, String tooltipKey) {
        super(properties, burnTime);
        this.tooltipKey = tooltipKey;
    }

    @Override
    public void appendHoverText(@Nonnull ItemStack stack, @Nonnull TooltipContext context, @Nonnull List<Component> tooltip, @Nonnull TooltipFlag flag) {
        TooltipUtils.addShiftTooltip(tooltip, tooltipKey);
        super.appendHoverText(stack, context, tooltip, flag);
    }
}
