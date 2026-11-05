package com.enderdevelopment.endersky.mixin;

import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Priority;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Locks the sky rotation angle (the value that drives where the sun and moon
 * discs are drawn across the sky) to the pure vanilla formula.
 *
 * <p>Mods often change a world's time, its {@link net.minecraft.world.dimension.DimensionEffects},
 * or override its sky angle so the sun and moon drift off the vanilla path. This mixin runs
 * with a high priority and recomputes the angle purely from the world's time of day, so the
 * resulting angle (and therefore the sun/moon position) is always identical to vanilla.
 */
@Mixin(World.class)
@Priority(1200)
public class WorldMixin {

    @Inject(method = "getSkyAngle", at = @At("HEAD"), cancellable = true)
    private void endersky_lockSkyAngle(float tickDelta, CallbackInfoReturnable<Float> cir) {
        World self = (World) (Object) this;

        // Exactly the vanilla World#getSkyAngle computation, using only the
        // time of day. Any other mod's change to the angle is ignored.
        double dayProgress = MathHelper.frac(self.getTimeOfDay(tickDelta) - 0.25);
        double ease = 0.5 - Math.cos(dayProgress * Math.PI) / 2.0;
        cir.setReturnValue((float) (dayProgress * 2.0 + ease) / 3.0F);
    }
}
