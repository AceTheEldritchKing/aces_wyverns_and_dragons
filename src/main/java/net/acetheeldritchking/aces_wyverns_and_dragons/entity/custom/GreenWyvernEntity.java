package net.acetheeldritchking.aces_wyverns_and_dragons.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class GreenWyvernEntity extends AbstractDraconicEntity implements IAnimatable {
    // Animation
    private AnimationFactory factory = new AnimationFactory(this);

    // Some goals
    private Goal huntTargetGoal;

    public GreenWyvernEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    // Attributes
    public static AttributeSupplier setAttributes()
    {
        return AbstractDraconicEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 30.0D)
                .add(Attributes.ATTACK_DAMAGE, 5.0f)
                .add(Attributes.ATTACK_SPEED, 2.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.2f)
                .add(Attributes.FLYING_SPEED, 0.4D)
                .build();
    }

    // Entity Goals
    // Essentially just AI
    // Get
    private void setTargetGoals()
    {
        this.targetSelector.addGoal(3, this.huntTargetGoal);
    }
    // Register
    protected void registerGoals()
    {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        // this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));
        // this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 10.0f));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomFlyingGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.huntTargetGoal = new NearestAttackableTargetGoal<>(
                this, Animal.class, 10, false, false,
                (pTargetPredicate) -> { return pTargetPredicate instanceof Chicken || pTargetPredicate instanceof Rabbit;
                }
        );
    }

    // Sounds
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.RAVAGER_STEP, 0.15F, 1.0F);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENDER_DRAGON_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.RAVAGER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.RAVAGER_DEATH;
    }

    protected float getSoundVolume() {
        return 0.2F;
    }

    // DAMAGE!!!
    // Gives poison effect upon hitting target
    @Override
    public boolean doHurtTarget(Entity pEntity) {
        if (!super.doHurtTarget(pEntity))
        {
            return false;
        } else {
            if (pEntity instanceof LivingEntity)
            {
                ((LivingEntity)pEntity).addEffect(new MobEffectInstance
                        (MobEffects.POISON, 100), this);
            }

            return true;
        }
    }

    // Other Stuff
    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    @Override
    public boolean isFlying() {
        return !this.onGround;
    }

    public boolean causeFallDamage(float pFallDistance, float pMultiplier, DamageSource pSource) {
        return false;
    }

    protected void checkFallDamage(double pY, boolean pOnGround, BlockState pState, BlockPos pPos) {
    }

    // ANIMATIONS
    @Override
    public void registerControllers(AnimationData data) {

    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
