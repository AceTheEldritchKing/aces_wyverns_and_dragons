package net.acetheeldritchking.aces_wyverns_and_dragons.event.loot;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class WyrmrootFromGrassAddition extends LootModifier {
    private final Item addition;
    /**
     * Constructs a LootModifier.
     *
     * @param conditionsIn the ILootConditions that need to be matched before the loot is modified.
     * @param addition
     */
    protected WyrmrootFromGrassAddition(LootItemCondition[] conditionsIn, Item addition) {
        super(conditionsIn);
        this.addition = addition;
    }

    @NotNull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        generatedLoot.add(new ItemStack(addition, 3));
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<WyrmrootFromGrassAddition>
    {
        @Override
        public WyrmrootFromGrassAddition read(ResourceLocation location,
                                              JsonObject object,
                                              LootItemCondition[] conditionsIn)
        {
            Item addition = ForgeRegistries.ITEMS.getValue(
                    new ResourceLocation(GsonHelper.getAsString(object, "addition"))
            );

            return new WyrmrootFromGrassAddition(conditionsIn, addition);
        }

        @Override
        public JsonObject write(WyrmrootFromGrassAddition instance) {
            JsonObject json = makeConditions(instance.conditions);
            json.addProperty("addition", ForgeRegistries.ITEMS.getKey(instance.addition).toString());

            return json;
        }
    }
}
