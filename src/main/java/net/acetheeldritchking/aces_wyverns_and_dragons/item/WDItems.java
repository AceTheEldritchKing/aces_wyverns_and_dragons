package net.acetheeldritchking.aces_wyverns_and_dragons.item;

import net.acetheeldritchking.aces_wyverns_and_dragons.AcesWyvernsAndDragons;
import net.acetheeldritchking.aces_wyverns_and_dragons.block.WDBlocks;
import net.acetheeldritchking.aces_wyverns_and_dragons.entity.WDEntityTypes;
import net.acetheeldritchking.aces_wyverns_and_dragons.item.custom.EnvenomAxeItem;
import net.acetheeldritchking.aces_wyverns_and_dragons.item.custom.EnvenomSwordItem;
import net.acetheeldritchking.aces_wyverns_and_dragons.sounds.WDSounds;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
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
    // Cooked Wyrmroot
    public static final RegistryObject<Item> COOKED_WYRMROOT = ITEMS.register("cooked_wyrmroot",
            () -> new Item(new Item.Properties().tab(WDCreativeModTab.ACES_WYVERNS_AND_DRAGONS_TAB)
                    .food(FoodItems.COOKED_WYRMROOT)));

    // Spawn Eggs
    // Green Wyvern
    public static final RegistryObject<ForgeSpawnEggItem> GREEN_WYVERN_SPAWN_EGG =
            ITEMS.register("green_wyvern_spawn_egg", () ->
                    new ForgeSpawnEggItem(WDEntityTypes.GREEN_WYVERN, 0x25b53c, 0x96b546,
                            new Item.Properties().tab(WDCreativeModTab.ACES_WYVERNS_AND_DRAGONS_TAB)));

    // Music Discs
    // Where Are We Now?
    public static final RegistryObject<Item> WHERE_ARE_WE_NOW_RECORD = ITEMS.register("music_disc_where_are_we_now",
            () -> new RecordItem(3, WDSounds.WHERE_ARE_WE_NOW,
                    new Item.Properties().tab(WDCreativeModTab.ACES_WYVERNS_AND_DRAGONS_TAB).stacksTo(1)));

    // Scales
    // Green Wyvern Scale
    public static final RegistryObject<Item> GREEN_WYVERN_SCALE = ITEMS.register("green_wyvern_scale",
            () -> new Item(new Item.Properties().tab(WDCreativeModTab.ACES_WYVERNS_AND_DRAGONS_TAB).fireResistant()
                    .stacksTo(16)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
