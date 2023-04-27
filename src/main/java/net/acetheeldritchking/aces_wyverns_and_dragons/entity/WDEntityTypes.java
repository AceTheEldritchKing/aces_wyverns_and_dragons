package net.acetheeldritchking.aces_wyverns_and_dragons.entity;

import net.acetheeldritchking.aces_wyverns_and_dragons.AcesWyvernsAndDragons;
import net.acetheeldritchking.aces_wyverns_and_dragons.entity.custom.GreenWyvernEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WDEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, AcesWyvernsAndDragons.MOD_ID);

    // Green Wyvern
    public static final RegistryObject<EntityType<GreenWyvernEntity>> GREEN_WYVERN =
            ENTITY_TYPES.register("green_wyvern", () -> EntityType.Builder.of
                    (GreenWyvernEntity::new, MobCategory.CREATURE).
                    // Bounding Box
                    sized(0.9f, 1f).build(new
                            ResourceLocation(AcesWyvernsAndDragons.MOD_ID,
                            "green_wyvern").toString()));

    public static void register(IEventBus eventBus)
    {
        ENTITY_TYPES.register(eventBus);
    }

}
