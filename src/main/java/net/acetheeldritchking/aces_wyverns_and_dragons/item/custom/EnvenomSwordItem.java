package net.acetheeldritchking.aces_wyverns_and_dragons.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class EnvenomSwordItem extends SwordItem {

    public EnvenomSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        // Gives target enemy poison effect
        pTarget.addEffect(new MobEffectInstance(MobEffects.POISON, 100), pAttacker);
        // Gives user strength on hit
        pAttacker.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100), pTarget);
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
