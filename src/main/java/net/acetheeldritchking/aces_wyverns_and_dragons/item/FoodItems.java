package net.acetheeldritchking.aces_wyverns_and_dragons.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FoodItems {

    public static final FoodProperties WYRMROOT =
            new FoodProperties.Builder().nutrition(1).saturationMod(0.05f)
                    .build();

    public static final FoodProperties COOKED_WYRMROOT =
            new FoodProperties.Builder().nutrition(4).saturationMod(0.3f)
                    .effect(() -> new MobEffectInstance(MobEffects.REGENERATION,
                            100), 1.0f)
                    .build();

}
