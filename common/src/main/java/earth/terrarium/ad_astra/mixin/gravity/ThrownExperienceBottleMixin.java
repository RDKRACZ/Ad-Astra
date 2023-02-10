package earth.terrarium.ad_astra.mixin.gravity;

import earth.terrarium.ad_astra.common.config.AdAstraConfig;
import earth.terrarium.ad_astra.common.util.ModUtils;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.ThrownExperienceBottle;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ThrownExperienceBottle.class)
public abstract class ThrownExperienceBottleMixin {
    @Inject(method = "getGravity", at = @At("HEAD"), cancellable = true)
    public void adastra_getGravity(CallbackInfoReturnable<Float> cir) {
        if (AdAstraConfig.doEntityGravity) {
            cir.setReturnValue(0.07f * ModUtils.getEntityGravity((Entity) (Object) this));

        }
    }
}