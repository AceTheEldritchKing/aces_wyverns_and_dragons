package net.acetheeldritchking.aces_wyverns_and_dragons;

import net.acetheeldritchking.aces_wyverns_and_dragons.block.ModBlocks;
import net.acetheeldritchking.aces_wyverns_and_dragons.item.ModItems;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AcesWyvernsAndDragons.MOD_ID)
public class AcesWyvernsAndDragons
{
    public static final String MOD_ID = "aces_wyverns_and_dragons";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public AcesWyvernsAndDragons() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Mod Items
        ModItems.register(eventBus);

        // Mod Blocks
        ModBlocks.register(eventBus);

        eventBus.addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
