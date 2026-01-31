package com.m.litholeather.block;

import net.minecraft.Block;
import net.xiaoyu233.fml.reload.utils.IdUtil;

/**
 * 岩鞣革系统 - 方块注册表
 */
public class ModBlocks {
    // 地衣岩
    public static Block lichenstone;
    
    /**
     * 注册所有方块
     */
    public static void registerBlocks() {
        try {
            // 地衣岩
            lichenstone = new BlockLichenstone(IdUtil.getNextBlockID())
                .setUnlocalizedName("lichenstone");
            System.out.println("[LithoLeather] 地衣岩方块创建成功");
        } catch (Exception e) {
            System.err.println("[LithoLeather] 地衣岩注册失败: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
