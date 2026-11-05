package com.enderdevelopment.endersky.mixin;

import net.minecraft.client.render.WorldRenderer;
import net.minecraft.world.dimension.DimensionEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Priority;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * Forces the value used to scale the sun (and the sunrise/sunset sky tint) to the
 * vanilla value, so that even if another mod replaces or overrides the dimension's
 * sky effects the horizon and celestial height still look exactly like vanilla.
 */
@Mixin(WorldRenderer.class)
@Priority(1200)
public class WorldRendererMixin {

    /** Vanilla overworld sun height. */
    private static final float VANILLA_SUN_HEIGHT = 100.0F;

    @Redirect(
            method = "renderSky",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/dimension/DimensionEffects;getSunHeight()F"
            )
    )
    private float endersky_lockSunHeight(DimensionEffects effects) {
        return VANILLA_SUN_HEIGHT;
    }
}
