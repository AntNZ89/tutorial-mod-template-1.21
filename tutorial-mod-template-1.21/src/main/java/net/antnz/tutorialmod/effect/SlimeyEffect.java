package net.antnz.tutorialmod.effect;

import net.antnz.tutorialmod.util.ModTags;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.item.Items;
import net.minecraft.util.math.Vec3d;

public class SlimeyEffect extends StatusEffect{
    public SlimeyEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {

        if (entity.horizontalCollision){
            Vec3d initial = entity.getVelocity();
            Vec3d climbing = new Vec3d(initial.x, 0.2, initial.z);
            entity.setVelocity(climbing);
            return true;
        }
        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
