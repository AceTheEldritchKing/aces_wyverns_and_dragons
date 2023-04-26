package net.acetheeldritchking.aces_wyverns_and_dragons.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.level.Level;

public abstract class AbstractDraconicEntity extends TamableAnimal implements FlyingAnimal {
    // For when I make multiple dragon entities
    protected AbstractDraconicEntity(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }
}
