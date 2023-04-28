package net.acetheeldritchking.aces_wyverns_and_dragons.entity.custom;

import net.acetheeldritchking.aces_wyverns_and_dragons.item.WDItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.scores.Team;
import net.minecraftforge.event.ForgeEventFactory;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.UUID;
import java.util.function.Predicate;

public class GreenWyvernEntity extends AbstractDraconicEntity implements IAnimatable, NeutralMob {
    // Animation
    private AnimationFactory factory = new AnimationFactory(this);
    // Sitting
    private static final EntityDataAccessor<Boolean> SITTING =
            SynchedEntityData.defineId(GreenWyvernEntity.class, EntityDataSerializers.BOOLEAN);
    // Neutral Mob Variables
    // Aggro
    private static final EntityDataAccessor<Integer> DATA_REMAINING_ANGER_TIMER =
            SynchedEntityData.defineId(GreenWyvernEntity.class, EntityDataSerializers.INT);
    // Aggro Timer
    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 60);
    // Anger Target
    private UUID persistentAngerTarget;

    // Some goals
    // Prey creatures
    public static final Predicate<LivingEntity> PREY_SELECTOR = (livingEntity) ->
    {
        EntityType<?> entityType = livingEntity.getType();
        return entityType == EntityType.RABBIT || entityType == EntityType.CHICKEN;
    };

    public GreenWyvernEntity(EntityType<? extends AbstractDraconicEntity> entityType, Level level) {
        super(entityType, level);
        this.setTame(false);
    }

    // Sync Data
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        // Sitting
        this.entityData.define(SITTING, false);
        // Aggro
        this.entityData.define(DATA_REMAINING_ANGER_TIMER, 0);
    }

    // Attributes
    public static AttributeSupplier setAttributes()
    {
        return AbstractDraconicEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 30.0D)
                .add(Attributes.ATTACK_DAMAGE, 5.0f)
                .add(Attributes.ATTACK_SPEED, 2.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.3f)
                .add(Attributes.FLYING_SPEED, 0.4D)
                .build();
    }

    // Entity Goals
    // Essentially just AI
    // Register
    protected void registerGoals()
    {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        // Tamable
        // Sit needs to be of higher priority
        this.goalSelector.addGoal(1, new SitWhenOrderedToGoal(this));
        // Follow owner
        this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, Player.class, 10.0f));
        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomFlyingGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1, true));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.0D, Ingredient.of(WDItems.WYRMROOT.get()), false));
        // If owner gets hurt
        this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
        // If owner hurts another entity
        this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        // Attack Player if hit
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>
                (this, Player.class, 10, false, false, this::isAngryAt));
        // Allows Wyvern to hunt down specified mobs
        this.targetSelector.addGoal(5, new NonTameRandomTargetGoal<>
                (this, Animal.class, false, PREY_SELECTOR));

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

    // Predicate Method
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        // Walking Anim
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.green_wyvern.walk_cycle", true));
            return PlayState.CONTINUE;
        }

        // Siting Anim
        if (this.isSitting())
        {
            event.getController().setAnimation(new AnimationBuilder().addAnimation
                    ("animation.green_wyvern.sitting", true));
            return PlayState.CONTINUE;
        }

        // Idle Anim
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.green_wyvern.idle", true));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    // Determines if entity is sitting or not
    public boolean isSitting()
    {
        return this.entityData.get(SITTING);
    }
    // Set sitting once tamed
    // Calls setOrderedToSit method in TamableAnimal super class
    public void setSitting(boolean sitting)
    {
        this.entityData.set(SITTING, sitting);
        this.setOrderedToSit(sitting);
    }

    // Tamable
    // Need accessor, other the predicate for the animation will not work
    // Mismatch between server and client w/ Geckolib, so need to define sitting
    @Override
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        // Gets item in player's hand
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        Item item = itemstack.getItem();
        // Defines what item to use for taming
        Item itemToTame = WDItems.WYRMROOT.get();

        // Taming Mechs
        // If is not tamed or angry
        if (this.level.isClientSide)
        {
            boolean flag = this.isOwnedBy(pPlayer) ||
                    this.isTame() ||
                    item == itemToTame && !this.isTame() && !this.isAngry();
            // Removes item in inventory when right-clicked
            // Ternary Operator
            // Makes a pass if the item for taming is used again if entity is tamed
            // Pass is essentially like a break
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else {
            if (this.isTame())
            {
                if (pHand == InteractionHand.MAIN_HAND)
                {
                    setSitting(!isSitting());
                }

                if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth())
                {
                    if (!pPlayer.getAbilities().instabuild)
                    {
                        itemstack.shrink(1);
                    }

                    this.heal((float) item.getFoodProperties().getNutrition());
                    return InteractionResult.SUCCESS;
                }
            } else if (item == itemToTame && !this.isAngry())
            {
                // If not in Creative, do this
                if (!pPlayer.getAbilities().instabuild && !this.isAngry())
                {
                    itemstack.shrink(1);
                }

                // Event fired once tamed
                if (!ForgeEventFactory.onAnimalTame(this, pPlayer))
                {
                    // Making sure on server side...
                    if (!this.level.isClientSide)
                    {
                        super.tame(pPlayer);
                        this.navigation.recomputePath();
                        // Clears aggro
                        this.setTarget(null);
                        // Sends a packet to a player of that event
                        this.level.broadcastEntityEvent(this, (byte)7);
                        setSitting(true);
                    }
                    return InteractionResult.SUCCESS;
                }
            }
        }
        // Once tamed, and on server
        // Makes sure to only use main hand for commands
        /*if (isTame() && !this.level.isClientSide && pHand == InteractionHand.MAIN_HAND)
        {
            setSitting(!isSitting());
            return InteractionResult.SUCCESS;
        }*/

        // Makes a pass if the item for taming is used again
        /*if (itemstack.getItem() == itemToTame)
        {
            return InteractionResult.PASS;  // Sorta like a break
        }*/

        return super.mobInteract(pPlayer, pHand);
    }

    // Neutral Mob Stuff
    @Override
    public int getRemainingPersistentAngerTime() {
        return this.entityData.get(DATA_REMAINING_ANGER_TIMER);
    }

    @Override
    public void setRemainingPersistentAngerTime(int pTime) {
        this.entityData.set(DATA_REMAINING_ANGER_TIMER, pTime);
    }

    @Nullable
    @Override
    public UUID getPersistentAngerTarget() {
        return this.persistentAngerTarget;
    }

    @Override
    public void setPersistentAngerTarget(@Nullable UUID pTarget) {
        this.persistentAngerTarget = pTarget;
    }

    @Override
    public void startPersistentAngerTimer() {
        this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
    }

    // Team to animal belongs to
    @Override
    public Team getTeam() {
        return super.getTeam();
    }

    // Can be leashed
    // Bug w/ Geckolib that makes leads invis when used on entities
    // Still works but invis
    // And I don't care
    public boolean canBeLeashed(Player pPlayer)
    {
        // Leashed as long as it isn't angry
        // Takes from tamable animal class (canBeLeashed method)
        return !this.isAngry() && super.canBeLeashed(pPlayer);
    }
}
