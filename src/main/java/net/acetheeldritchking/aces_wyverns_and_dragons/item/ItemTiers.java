package net.acetheeldritchking.aces_wyverns_and_dragons.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ItemTiers {
    // Tier for Aurdite
    public static final ForgeTier AURDITE = new ForgeTier
            (4, 2632, 9.5F, 5.0F, 20,
                    BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(ModItems.AURDITE_INGOT.get()));
}
