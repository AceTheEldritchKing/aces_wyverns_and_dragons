package net.acetheeldritchking.aces_wyverns_and_dragons.world;

import net.acetheeldritchking.aces_wyverns_and_dragons.AcesWyvernsAndDragons;
import net.acetheeldritchking.aces_wyverns_and_dragons.world.gen.WDOreGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AcesWyvernsAndDragons.MOD_ID)
public class WDWorldEvents {

    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event)
    {
        // Ores & Stones
        WDOreGeneration.generateOres(event);
    }

}
