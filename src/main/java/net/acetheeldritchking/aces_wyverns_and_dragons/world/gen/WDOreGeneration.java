package net.acetheeldritchking.aces_wyverns_and_dragons.world.gen;

import net.acetheeldritchking.aces_wyverns_and_dragons.world.feature.WDPlacedFeatures;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;
import java.util.function.Supplier;

public class WDOreGeneration {

    public static void generateOres(final BiomeLoadingEvent event)
    {
        List<Supplier<PlacedFeature>> base =
                event.getGeneration().getFeatures
                        (GenerationStep.Decoration.UNDERGROUND_ORES);

        base.add(() -> WDPlacedFeatures.AURDITE_ORE_PLACED);
        base.add(() -> WDPlacedFeatures.DRAKESTONE_ORE_PLACED);
    }

}
