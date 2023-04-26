package net.acetheeldritchking.aces_wyverns_and_dragons.world.feature;

import net.acetheeldritchking.aces_wyverns_and_dragons.block.WDBlocks;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

import java.util.List;

public class WDConfiguredFeature {
    // Ore Gen
    // Aurdite Ore
    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_AURDITE_ORE =
            List.of(
                    OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, WDBlocks.AURDITE_ORE.get().defaultBlockState()),
                    OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, WDBlocks.DEEPSLATE_AURDITE_ORE.get().defaultBlockState())
            );

    public static final ConfiguredFeature<?, ?> AURDITE_ORE = FeatureUtils.register
            ("aurdite_ore", Feature.ORE.configured(new OreConfiguration(OVERWORLD_AURDITE_ORE, 8)));    // Average vein size

    // Drakestone
    public static final List<OreConfiguration.TargetBlockState> OVERWORLD_DRAKESTONE_ORE =
            List.of(
                    OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, WDBlocks.DRAKESTONE.get().defaultBlockState())
            );

    public static final ConfiguredFeature<?, ?> DRAKESTONE_ORE = FeatureUtils.register
            ("drakestone", Feature.ORE.configured(new OreConfiguration(OVERWORLD_DRAKESTONE_ORE, 45)));    // Average vein size

}
