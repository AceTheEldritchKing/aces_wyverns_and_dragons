package net.acetheeldritchking.aces_wyverns_and_dragons.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModTab {
    public static final CreativeModeTab ACES_WYVERNS_AND_DRAGONS_TAB =
            new CreativeModeTab("aces_wyverns_and_dragons_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.AURDITE_INGOT.get());
        }
    };

}
