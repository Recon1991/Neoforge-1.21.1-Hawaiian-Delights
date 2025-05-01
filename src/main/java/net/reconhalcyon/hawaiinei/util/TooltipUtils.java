package net.reconhalcyon.hawaiinei.util;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import java.util.List;

public class TooltipUtils {
    public static void addShiftTooltip(List<Component> tooltip, String baseKey) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable(baseKey + ".shift_down").withStyle(ChatFormatting.GRAY));
        } else {
            tooltip.add(Component.translatable("tooltip.shift_prompt").withStyle(ChatFormatting.DARK_AQUA));
        }
    }
}
