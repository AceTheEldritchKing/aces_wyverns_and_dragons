package net.acetheeldritchking.aces_wyverns_and_dragons.world.gen;

import net.acetheeldritchking.aces_wyverns_and_dragons.entity.WDEntityTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

public class WDEntityGeneration {

    public static void onEntitySpawn(final BiomeLoadingEvent event)
    {
        addEntityToAllOverworldBiomes(event, WDEntityTypes.GREEN_WYVERN.get(), 100, 1, 2);
    }

    // Entity Gen to overworld biomes
    private static void addEntityToAllOverworldBiomes(BiomeLoadingEvent event,
                                                      EntityType<?> type,
                                                      int weight, int minCount, int maxCount)
    {
        if (!event.getCategory().equals(Biome.BiomeCategory.THEEND) && !event.getCategory().equals(Biome.BiomeCategory.NETHER))
        {
            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
        }
    }

    // Adds entities to selected biomes
    private static void addEntityToAllBiomes (BiomeLoadingEvent event,
                                              EntityType<?> type,
                                              int weight, int minCount, int maxCount)
    {
        List<MobSpawnSettings.SpawnerData> base =
                event.getSpawns().getSpawner(type.getCategory());
        base.add(new MobSpawnSettings.SpawnerData(type, weight, minCount, maxCount));
    }

}
