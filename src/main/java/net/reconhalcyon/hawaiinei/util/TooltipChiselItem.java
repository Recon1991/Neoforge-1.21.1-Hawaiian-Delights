package net.reconhalcyon.hawaiinei.util;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.reconhalcyon.hawaiinei.item.custom.ChiselItem;

import javax.annotation.Nonnull;
import java.util.List;

public class TooltipChiselItem extends ChiselItem {
    private final String tooltipKey;

    public TooltipChiselItem(Properties properties, String tooltipKey) {
        super(properties);
        this.tooltipKey = tooltipKey;
    }

    @Override
    public void appendHoverText(@Nonnull ItemStack stack, @Nonnull TooltipContext context, @Nonnull List<Component> tooltipComponents, @Nonnull TooltipFlag tooltipFlag) {
        TooltipUtils.addShiftTooltip(tooltipComponents, tooltipKey);
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}