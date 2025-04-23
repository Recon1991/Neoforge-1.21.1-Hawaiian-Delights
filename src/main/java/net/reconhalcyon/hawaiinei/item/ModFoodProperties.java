package net.reconhalcyon.hawaiinei.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class ModFoodProperties {
    public static final FoodProperties POKE_BOWL = new FoodProperties.Builder().nutrition(4).saturationModifier(2f)
            .usingConvertsTo(Items.BOWL).effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 200), 0.35f).build();
}
