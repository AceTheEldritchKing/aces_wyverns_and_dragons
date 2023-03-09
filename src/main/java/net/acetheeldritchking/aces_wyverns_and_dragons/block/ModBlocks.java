package net.acetheeldritchking.aces_wyverns_and_dragons.block;

import net.acetheeldritchking.aces_wyverns_and_dragons.AcesWyvernsAndDragons;
import net.acetheeldritchking.aces_wyverns_and_dragons.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, AcesWyvernsAndDragons.MOD_ID);

    // Aurdite Metal Block
    public static final RegistryObject<Block> AURDITE_BLOCK = registerBlock("aurdite_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_MISC);

    // Aurdite Ore
    public static final RegistryObject<Block> AURDITE_ORE = registerBlock("aurdite_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_MISC);



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
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
