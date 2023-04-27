package net.acetheeldritchking.aces_wyverns_and_dragons;

import net.acetheeldritchking.aces_wyverns_and_dragons.block.WDBlocks;
import net.acetheeldritchking.aces_wyverns_and_dragons.entity.WDEntityTypes;
import net.acetheeldritchking.aces_wyverns_and_dragons.entity.client.GreenWyvernRenderer;
import net.acetheeldritchking.aces_wyverns_and_dragons.item.WDItems;
import net.acetheeldritchking.aces_wyverns_and_dragons.sounds.WDSounds;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        WDItems.register(eventBus);

        // Mod Blocks
        WDBlocks.register(eventBus);

        // Sounds
        WDSounds.register(eventBus);

        // Entities
        WDEntityTypes.register(eventBus);

        eventBus.addListener(this::setup);
        // Client Rendering
        eventBus.addListener(this::clientSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    // Rendering
    private void clientSetup(final FMLClientSetupEvent event)
    {
        // Crop Blocks
        ItemBlockRenderTypes.setRenderLayer(WDBlocks.WYRMROOT_CROP_BLOCK.get(),
                RenderType.cutout());

        // Entities
        // Green Wyvern
        EntityRenderers.register(WDEntityTypes.GREEN_WYVERN.get(), GreenWyvernRenderer::new);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
