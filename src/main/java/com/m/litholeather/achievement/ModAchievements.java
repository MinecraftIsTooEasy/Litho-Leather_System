package com.m.litholeather.achievement;

import net.minecraft.Achievement;
import net.minecraft.AchievementList;
import net.minecraft.Item;

/**
 * 岩鞣革系统 - 成就注册
 */
public class ModAchievements {
    
    // 无兽之匠 - 首次合成皮革
    public static Achievement beastlessCrafter;
    
    /**
     * 注册所有成就
     */
    public static void registerAchievements() {
        try {
            // 无兽之匠 - 首次合成皮革
            // Achievement(int id, String name, int displayColumn, int displayRow, Item icon, Achievement parent)
            // 放在 buildWorkBench (工作台) 成就旁边
            beastlessCrafter = new Achievement(
                5000,  // 成就 ID
                "beastlessCrafter",
                4, 2,  // 显示位置
                Item.leather,  // 图标
                AchievementList.buildWorkBench  // 父成就：工作台
            ).registerAchievement();
            
            System.out.println("[LithoLeather] 成就注册成功: 无兽之匠");
        } catch (Exception e) {
            System.err.println("[LithoLeather] 成就注册失败: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
