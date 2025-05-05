package net.reconhalcyon.hawaiinei.util;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.util.List;

public class TooltipUtils {
    public static void addShiftTooltip(List<Component> tooltip, String itemId) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable(TooltipKeys.of(itemId)).withStyle(ChatFormatting.WHITE));
        } else {
            tooltip.add(Component.translatable(TooltipKeys.SHIFT_PROMPT).withStyle(ChatFormatting.DARK_GRAY));
        }
    }
}
