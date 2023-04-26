package net.acetheeldritchking.aces_wyverns_and_dragons.block;

import net.acetheeldritchking.aces_wyverns_and_dragons.AcesWyvernsAndDragons;
import net.acetheeldritchking.aces_wyverns_and_dragons.block.custom.WyrmrootCropBlock;
import net.acetheeldritchking.aces_wyverns_and_dragons.item.WDCreativeModTab;
import net.acetheeldritchking.aces_wyverns_and_dragons.item.WDItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class WDBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, AcesWyvernsAndDragons.MOD_ID);

    // Aurdite Metal Block
    public static final RegistryObject<Block> AURDITE_BLOCK = registerBlock("aurdite_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), WDCreativeModTab.ACES_WYVERNS_AND_DRAGONS_TAB);

    // Aurdite Ore
    public static final RegistryObject<Block> AURDITE_ORE = registerBlock("aurdite_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops()), WDCreativeModTab.ACES_WYVERNS_AND_DRAGONS_TAB);

    // Deepslate Aurdite ore
    public static final RegistryObject<Block> DEEPSLATE_AURDITE_ORE = registerBlock("deepslate_aurdite_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops()), WDCreativeModTab.ACES_WYVERNS_AND_DRAGONS_TAB);

    // Raw Aurdite block
    public static final RegistryObject<Block> RAW_AURDITE_BLOCK = registerBlock("raw_aurdite_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f).requiresCorrectToolForDrops()), WDCreativeModTab.ACES_WYVERNS_AND_DRAGONS_TAB);

    // Drakestone Block
    public static final RegistryObject<Block> DRAKESTONE = registerBlock("drakestone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops()), WDCreativeModTab.ACES_WYVERNS_AND_DRAGONS_TAB);

    // Drakestone Aurdite Ore
    public static final RegistryObject<Block> DRAKESTONE_AURDITE_ORE = registerBlock("drakestone_aurdite_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops()), WDCreativeModTab.ACES_WYVERNS_AND_DRAGONS_TAB);

    // Drakestone Bricks
    public static final RegistryObject<Block> DRAKESTONE_BRICKS = registerBlock("drakestone_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops()), WDCreativeModTab.ACES_WYVERNS_AND_DRAGONS_TAB);

    // Chiseled Drakestone
    public static final RegistryObject<Block> CHISELED_DRAKESTONE = registerBlock("chiseled_drakestone",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops()), WDCreativeModTab.ACES_WYVERNS_AND_DRAGONS_TAB);

    // Drakestone Brick Stairs
    public static final RegistryObject<Block> DRAKESTONE_BRICK_STAIRS = registerBlock("drakestone_brick_stairs",
            () -> new StairBlock(() -> WDBlocks.DRAKESTONE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops()), WDCreativeModTab.ACES_WYVERNS_AND_DRAGONS_TAB);

    // Drakestone Brick Slabs
    public static final RegistryObject<Block> DRAKESTONE_BRICK_SLAB = registerBlock("drakestone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops()), WDCreativeModTab.ACES_WYVERNS_AND_DRAGONS_TAB);


    // Crop Blocks
    // Wyrmroot
    public static final RegistryObject<Block> WYRMROOT_CROP_BLOCK = BLOCKS.register("wyrmroot_crop",
            () -> new WyrmrootCropBlock(BlockBehaviour.Properties.copy(Blocks.POTATOES)
                    .noCollission().noOcclusion()));


    // Block Helper Methods/Funcs
    private static <T extends Block> RegistryObject<T> registerBlock
            (String name, Supplier<T> block, CreativeModeTab tab)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);

        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem
            (String name, RegistryObject<T> block, CreativeModeTab tab)
    {
        return WDItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
