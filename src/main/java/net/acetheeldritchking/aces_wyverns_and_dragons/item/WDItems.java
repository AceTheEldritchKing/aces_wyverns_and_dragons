package net.acetheeldritchking.aces_wyverns_and_dragons.item;

import net.acetheeldritchking.aces_wyverns_and_dragons.AcesWyvernsAndDragons;
import net.acetheeldritchking.aces_wyverns_and_dragons.block.WDBlocks;
import net.acetheeldritchking.aces_wyverns_and_dragons.item.custom.EnvenomAxeItem;
import net.acetheeldritchking.aces_wyverns_and_dragons.item.custom.EnvenomSwordItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WDItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AcesWyvernsAndDragons.MOD_ID);

    //Basic Items
    // Aurdite Ingot
    public static final RegistryObject<Item> AURDITE_INGOT = ITEMS.register("aurdite_ingot",
            () -> new Item(new Item.Properties().tab(WDCreativeModTab.ACES_WYVERNS_AND_DRAGONS_TAB).fireResistant()));
    // Aurdite Nugget
    public static final RegistryObject<Item> AURDITE_NUGGET = ITEMS.register("aurdite_nugget",
            () -> new Item(new Item.Properties().tab(WDCreativeModTab.ACES_WYVERNS_AND_DRAGONS_TAB).fireResistant()));
    // Raw Aurdite
    public static final RegistryObject<Item> RAW_AURDITE = ITEMS.register("raw_aurdite",
            () -> new Item(new Item.Properties().tab(WDCreativeModTab.ACES_WYVERNS_AND_DRAGONS_TAB).fireResistant()));

    // Green Aurdite Tool Set
    // Sword and Axe both inflict poison on hit
    // Sword
    public static final RegistryObject<Item> AURDITE_SWORD = ITEMS.register("aurdite_sword",
            () -> new EnvenomSwordItem(ItemTiers.AURDITE, 3, -2.4f,
                    new Item.Properties().tab(WDCreativeModTab.ACES_WYVERNS_AND_DRAGONS_TAB).fireResistant()));
    // Pickaxe
    public static final RegistryObject<Item> AURDITE_PICKAXE = ITEMS.register("aurdite_pickaxe",
            () -> new PickaxeItem(ItemTiers.AURDITE, 0, -2.8F,
                    new Item.Properties().tab(WDCreativeModTab.ACES_WYVERNS_AND_DRAGONS_TAB).fireResistant()));
    // Shovel
    public static final RegistryObject<Item> AURDITE_SHOVEL = ITEMS.register("aurdite_shovel",
            () -> new ShovelItem(ItemTiers.AURDITE, 0, -3F,
                    new Item.Properties().tab(WDCreativeModTab.ACES_WYVERNS_AND_DRAGONS_TAB).fireResistant()));
    // Axe
    public static final RegistryObject<Item> AURDITE_AXE = ITEMS.register("aurdite_axe",
            () -> new EnvenomAxeItem(ItemTiers.AURDITE, 5, -3F,
                    new Item.Properties().tab(WDCreativeModTab.ACES_WYVERNS_AND_DRAGONS_TAB).fireResistant()));
    // Hoe
    public static final RegistryObject<Item> AURDITE_HOE = ITEMS.register("aurdite_hoe",
            () -> new HoeItem(ItemTiers.AURDITE, 0, -3F,
                    new Item.Properties().tab(WDCreativeModTab.ACES_WYVERNS_AND_DRAGONS_TAB).fireResistant()));

    // Green Aurdite Armor Set
    // Helmet
    public static final RegistryObject<Item> AURDITE_HELMET = ITEMS.register("aurdite_helmet",
            () -> new ArmorItem(CustomArmorMaterials.AURDITE, EquipmentSlot.HEAD,
                    new Item.Properties().tab(WDCreativeModTab.ACES_WYVERNS_AND_DRAGONS_TAB).fireResistant()));
    // Chestplate
    public static final RegistryObject<Item> AURDITE_CHESTPLATE = ITEMS.register("aurdite_chestplate",
            () -> new ArmorItem(CustomArmorMaterials.AURDITE, EquipmentSlot.CHEST,
                    new Item.Properties().tab(WDCreativeModTab.ACES_WYVERNS_AND_DRAGONS_TAB).fireResistant()));
    // Leggings
    public static final RegistryObject<Item> AURDITE_LEGGINGS = ITEMS.register("aurdite_leggings",
            () -> new ArmorItem(CustomArmorMaterials.AURDITE, EquipmentSlot.LEGS,
                    new Item.Properties().tab(WDCreativeModTab.ACES_WYVERNS_AND_DRAGONS_TAB).fireResistant()));
    // Boots
    public static final RegistryObject<Item> AURDITE_BOOTS = ITEMS.register("aurdite_boots",
            () -> new ArmorItem(CustomArmorMaterials.AURDITE, EquipmentSlot.FEET,
                    new Item.Properties().tab(WDCreativeModTab.ACES_WYVERNS_AND_DRAGONS_TAB).fireResistant()));

    // Food Stuff
    // Wyrmroot
    public static final RegistryObject<Item> WYRMROOT = ITEMS.register("wyrmroot",
            () -> new ItemNameBlockItem(WDBlocks.WYRMROOT_CROP_BLOCK.get(), new Item.Properties()
                    .tab(WDCreativeModTab.ACES_WYVERNS_AND_DRAGONS_TAB).food(FoodItems.WYRMROOT)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
