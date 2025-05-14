package net.reconhalcyon.hawaiinei.util;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.reconhalcyon.hawaiinei.item.custom.BaseFishItem;

import javax.annotation.Nullable;
import java.util.List;

public class TooltipFishItem extends BaseFishItem {
    private final String tooltipKey;

    public TooltipFishItem(Properties properties, String tooltipKey) {
        super(properties);
        this.tooltipKey = tooltipKey;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.translatable("tooltip.hawaiinei." + tooltipKey));
    }
}
