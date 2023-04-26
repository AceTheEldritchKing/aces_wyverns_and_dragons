package net.acetheeldritchking.aces_wyverns_and_dragons.entity.client;

import net.acetheeldritchking.aces_wyverns_and_dragons.AcesWyvernsAndDragons;
import net.acetheeldritchking.aces_wyverns_and_dragons.entity.custom.GreenWyvernEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GreenWyvernModel extends AnimatedGeoModel<GreenWyvernEntity> {
    @Override
    public ResourceLocation getModelLocation(GreenWyvernEntity object) {
        return new ResourceLocation(AcesWyvernsAndDragons.MOD_ID, "geo/green_wyvern.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(GreenWyvernEntity object) {
        return new ResourceLocation(AcesWyvernsAndDragons.MOD_ID, "textures/entity/green_wyvern/green_wyvern.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(GreenWyvernEntity animatable) {
        return new ResourceLocation(AcesWyvernsAndDragons.MOD_ID, "animations/green_wyvern.animation.json");
    }
}
