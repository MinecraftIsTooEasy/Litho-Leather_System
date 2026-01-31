package com.m.litholeather.mixin;

import com.m.litholeather.worldgen.WorldGenLichenstone;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

/**
 * 区块生成 Mixin - 注入地衣岩生成逻辑
 */
@Mixin(ChunkProviderGenerate.class)
public class ChunkProviderMixin {
    
    @Shadow
    private World worldObj;
    
    @Shadow
    private Random rand;
    
    /**
     * 在区块填充完成后生成地衣岩
     */
    @Inject(
        method = "populate(Lnet/minecraft/IChunkProvider;II)V",
        at = @At("RETURN")
    )
    private void onPopulate(IChunkProvider chunkProvider, int chunkX, int chunkZ, CallbackInfo ci) {
        // 生成地衣岩
        WorldGenLichenstone.generateLichenstone(worldObj, rand, chunkX * 16, chunkZ * 16);
    }
}
