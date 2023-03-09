package net.acetheeldritchking.aces_wyverns_and_dragons.item;

import net.acetheeldritchking.aces_wyverns_and_dragons.AcesWyvernsAndDragons;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AcesWyvernsAndDragons.MOD_ID);

    // Aurdite Ingot
    public static final RegistryObject<Item> AURDITE_INGOT = ITEMS.register("aurdite_ingot",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    // Aurdite Nugget
    public static final RegistryObject<Item> AURDITE_NUGGET = ITEMS.register("aurdite_nugget",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    // Raw Aurdite
    public static final RegistryObject<Item> RAW_AURDITE = ITEMS.register("raw_aurdite",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
