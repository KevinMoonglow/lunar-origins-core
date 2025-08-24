package io.github.KevinMoonglow.lunar_origins.power;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.LivingEntity;

public class CrawlingPower extends Power {

    public CrawlingPower(PowerType<?> type, LivingEntity entity) {
        super(type, entity);
        this.setTicking();
    }

    @Override
    public void tick() {
        if (!entity.isSwimming())
            entity.setPose(EntityPose.SWIMMING);
    }
}
