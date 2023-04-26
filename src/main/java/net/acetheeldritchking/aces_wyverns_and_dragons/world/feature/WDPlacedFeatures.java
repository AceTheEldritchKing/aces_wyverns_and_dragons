package net.acetheeldritchking.aces_wyverns_and_dragons.world.feature;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class WDPlacedFeatures {
    // Ore Gen
    // Aurdite Ore
    public static final PlacedFeature AURDITE_ORE_PLACED = PlacementUtils.register
            ("aurdite_ore_placed", WDConfiguredFeature.AURDITE_ORE.placed
                    (WDOrePlacement.commonOrePlacement(5,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-100),
                                    VerticalAnchor.aboveBottom(100)))));

    // Drakestone
    public static final PlacedFeature DRAKESTONE_ORE_PLACED = PlacementUtils.register
            ("drakestone_ore_placed", WDConfiguredFeature.DRAKESTONE_ORE.placed
                    (WDOrePlacement.commonOrePlacement(10,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-100),
                                    VerticalAnchor.aboveBottom(100)))));
}
