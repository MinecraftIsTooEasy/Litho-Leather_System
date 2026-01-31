package com.m.litholeather.mixin;

import com.m.litholeather.item.ModItems;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

/**
 * 草掉落亚麻 Mixin
 * 使草（tallGrass）有 15% 概率掉落亚麻纤维
 * <p>
 * 注入到 BlockTallGrass 的 dropBlockAsEntityItem 方法
 */
@Mixin(BlockTallGrass.class)
public class TallGrassDropMixin {

    /**
     * 注入到 dropBlockAsEntityItem 方法末尾
     * 添加 15% 概率掉落亚麻
     */
    @Inject(
            method = "dropBlockAsEntityItem",
            at = @At("RETURN")
    )
    private void addFlaxDrop(BlockBreakInfo info, CallbackInfoReturnable<Integer> cir) {
        World world = info.world;

        if (world == null || world.isRemote) {
            return;
        }

        if (ModItems.flaxFiber == null) {
            return;
        }

        // 15% 概率掉落亚麻
        Random random = world.rand;
        if (random.nextFloat() < 0.15F) {
            int x = info.x;
            int y = info.y;
            int z = info.z;

            // 创建亚麻物品实体
            ItemStack flaxStack = new ItemStack(ModItems.flaxFiber, 1);
            EntityItem entityItem = new EntityItem(world,
                    x + 0.5, y + 0.5, z + 0.5, flaxStack);

            // 添加随机运动
            entityItem.motionX = random.nextGaussian() * 0.05;
            entityItem.motionY = random.nextGaussian() * 0.05 + 0.2;
            entityItem.motionZ = random.nextGaussian() * 0.05;

            world.spawnEntityInWorld(entityItem);
        }
    }
}
