package com.m.litholeather.item;

import net.minecraft.Item;
import net.xiaoyu233.fml.reload.utils.IdUtil;

/**
 * 岩鞣革系统 - 物品注册表
 */
public class ModItems {
    // 亚麻纤维
    public static Item flaxFiber;
    
    // 亚麻布
    public static Item linenCloth;
    
    // 地衣岩碎片
    public static Item lichenFragment;
    
    // 鞣质岩粉
    public static Item tannicAsh;
    
    // 燧石镐
    public static Item flintPickaxe;
    
    /**
     * 注册所有物品
     */
    public static void registerItems() {
        System.out.println("[LithoLeather] 开始物品注册...");
        
        try {
            // 亚麻纤维
            flaxFiber = new ItemFlaxFiber(IdUtil.getNextItemID())
                .setUnlocalizedName("flax_fiber");
            System.out.println("[LithoLeather] 亚麻纤维注册成功: " + flaxFiber);
        } catch (Exception e) {
            System.err.println("[LithoLeather] 亚麻纤维注册失败: " + e.getMessage());
            e.printStackTrace();
        }
        
        try {
            // 亚麻布
            linenCloth = new ItemLinenCloth(IdUtil.getNextItemID())
                .setUnlocalizedName("linen_cloth");
            System.out.println("[LithoLeather] 亚麻布注册成功: " + linenCloth);
        } catch (Exception e) {
            System.err.println("[LithoLeather] 亚麻布注册失败: " + e.getMessage());
            e.printStackTrace();
        }
        
        try {
            // 地衣岩碎片
            lichenFragment = new ItemLichenFragment(IdUtil.getNextItemID())
                .setUnlocalizedName("lichen_fragment");
            System.out.println("[LithoLeather] 地衣岩碎片注册成功: " + lichenFragment);
        } catch (Exception e) {
            System.err.println("[LithoLeather] 地衣岩碎片注册失败: " + e.getMessage());
            e.printStackTrace();
        }
        
        try {
            // 鞣质岩粉
            tannicAsh = new ItemTannicAsh(IdUtil.getNextItemID())
                .setUnlocalizedName("tannic_ash");
            System.out.println("[LithoLeather] 鞣质岩粉注册成功: " + tannicAsh);
        } catch (Exception e) {
            System.err.println("[LithoLeather] 鞣质岩粉注册失败: " + e.getMessage());
            e.printStackTrace();
        }
        
        try {
            // 燧石镐
            flintPickaxe = new ItemFlintPickaxe(IdUtil.getNextItemID())
                .setUnlocalizedName("flint_pickaxe");
            System.out.println("[LithoLeather] 燧石镐注册成功: " + flintPickaxe);
        } catch (Exception e) {
            System.err.println("[LithoLeather] 燧石镐注册失败: " + e.getMessage());
            e.printStackTrace();
        }
        
        System.out.println("[LithoLeather] 物品注册完成");
    }
}
