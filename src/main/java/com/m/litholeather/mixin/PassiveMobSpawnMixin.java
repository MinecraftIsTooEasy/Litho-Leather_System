//package com.m.litholeather.mixin;
//
//import net.minecraft.*;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//
//import java.util.List;
//import java.util.Iterator;
//
///**
// * 被动生物生成禁用 Mixin
// * 阻止所有被动生物（牛、猪、羊、鸡、马、驴、兔子）的生成
// */
//@Mixin(BiomeGenBase.class)
//public class PassiveMobSpawnMixin {
//
//    /**
//     * 注入到 getSpawnableList 方法，移除被动生物
//     */
//    @Inject(method = "getSpawnableList", at = @At("RETURN"))
//    private void removePassiveMobs(EnumCreatureType type, CallbackInfoReturnable<List> cir) {
//        // 移除所有被动生物
//        List<SpawnListEntry> list = cir.getReturnValue();
//        if (list != null) {
//            Iterator<SpawnListEntry> iterator = list.iterator();
//            while (iterator.hasNext()) {
//                SpawnListEntry entry = iterator.next();
//                if (isPassiveMob(entry.entityClass)) {
//                    iterator.remove();
//                }
//            }
//        }
//    }
//
//    /**
//     * 检查是否为被动生物
//     */
//    private boolean isPassiveMob(Class entityClass) {
//        if (entityClass == null) {
//            return false;
//        }
//
//        String className = entityClass.getName();
//
//        // 检查是否为被动生物
//        return className.equals("net.minecraft.EntityCow") ||
//               className.equals("net.minecraft.EntityPig") ||
//               className.equals("net.minecraft.EntitySheep") ||
//               className.equals("net.minecraft.EntityChicken") ||
//               className.equals("net.minecraft.EntityHorse") ||
//               className.equals("net.minecraft.EntityRabbit");
//    }
//}
