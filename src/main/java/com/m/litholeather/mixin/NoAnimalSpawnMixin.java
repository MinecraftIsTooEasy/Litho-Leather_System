package com.m.litholeather.mixin;

import com.m.litholeather.LITHOLEATHERMod;
import net.minecraft.Entity;
import net.minecraft.EntityAnimal;
import net.minecraft.EntityLivestock;
import net.minecraft.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Mixin 注入：阻止所有动物在世界中生成
 */
@Mixin(World.class)
public class NoAnimalSpawnMixin {

    @Inject(method = "spawnEntityInWorld", at = @At("HEAD"), cancellable = true)
    private void onSpawnEntity(Entity entity, CallbackInfoReturnable<Boolean> cir) {
        // 阻止所有动物生成 (EntityAnimal 或 EntityLivestock)
        if (entity instanceof EntityAnimal || entity instanceof EntityLivestock) {
            LITHOLEATHERMod.LOGGER.info("已阻止动物生成: {} 位置 ({}, {}, {})",
                entity.getClass().getSimpleName(),
                (int) entity.posX, 
                (int) entity.posY, 
                (int) entity.posZ);
            cir.setReturnValue(false);
        }
    }
}
