package net.reconhalcyon.hawaiinei.util;

import net.reconhalcyon.hawaiinei.HawaiiNei;

public class TooltipKeys {
    public static String of(String itemId) {
        return "tooltip." + HawaiiNei.MOD_ID + "." + itemId;
    }

    public static final String SHIFT_PROMPT = "tooltip.shift_prompt";
}
