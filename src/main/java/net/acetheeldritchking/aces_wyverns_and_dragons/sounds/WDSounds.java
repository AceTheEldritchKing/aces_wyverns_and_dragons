package net.acetheeldritchking.aces_wyverns_and_dragons.sounds;

import net.acetheeldritchking.aces_wyverns_and_dragons.AcesWyvernsAndDragons;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WDSounds {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, AcesWyvernsAndDragons.MOD_ID);

    // Music Discs
    // Where Are We Now?
    public static RegistryObject<SoundEvent> WHERE_ARE_WE_NOW =
            registerSoundEvents("where_are_we_now");


    // Helper method for sound resource location
    private static RegistryObject<SoundEvent> registerSoundEvents(String name)
    {
        ResourceLocation id = new ResourceLocation(AcesWyvernsAndDragons.MOD_ID, name);

        return SOUND_EVENTS.register(name, () -> new SoundEvent(id));
    }

    public static void register(IEventBus eventBus)
    {
        SOUND_EVENTS.register(eventBus);
    }

}
