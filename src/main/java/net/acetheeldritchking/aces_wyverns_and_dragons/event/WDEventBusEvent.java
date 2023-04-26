package net.acetheeldritchking.aces_wyverns_and_dragons.event;

import net.acetheeldritchking.aces_wyverns_and_dragons.AcesWyvernsAndDragons;
import net.acetheeldritchking.aces_wyverns_and_dragons.entity.WDEntityTypes;
import net.acetheeldritchking.aces_wyverns_and_dragons.entity.custom.GreenWyvernEntity;
import net.acetheeldritchking.aces_wyverns_and_dragons.event.loot.WyrmrootFromGrassAddition;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = AcesWyvernsAndDragons.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WDEventBusEvent {

    // Loot Modifiers
    @SubscribeEvent
    public static void registerModifierSerializers
            (@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event)
    {
        event.getRegistry().registerAll(
                new WyrmrootFromGrassAddition.Serializer().setRegistryName
                        (new ResourceLocation(AcesWyvernsAndDragons.MOD_ID, "wyrmroot_from_grass"))
        );
    }

    // Entity
    // Adds attributes defined in the entity class
    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event)
    {
        event.put(WDEntityTypes.GREEN_WYVERN.get(), GreenWyvernEntity.setAttributes());
    }

}
