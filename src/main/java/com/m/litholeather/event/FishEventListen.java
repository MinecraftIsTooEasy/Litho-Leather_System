package com.m.litholeather.event;

import com.m.litholeather.LITHOLEATHERMod;
import com.m.litholeather.achievement.ModAchievements;
import com.m.litholeather.block.ModBlocks;
import com.m.litholeather.item.ModItems;
import com.google.common.eventbus.Subscribe;
import net.minecraft.*;
import net.xiaoyu233.fml.reload.event.*;

/**
 * 岩鞣革系统 - 事件监听器
 */
public class FishEventListen {

    /**
     * 处理物品注册事件
     */
    @Subscribe
    public void onItemRegister(ItemRegistryEvent event) {
        // 注册物品
        ModItems.registerItems();
        
        // 注册方块
        ModBlocks.registerBlocks();
        
        // 使用 registerItemBlock 注册方块的 ItemBlock
        if (ModBlocks.lichenstone != null) {
            event.registerItemBlock(LITHOLEATHERMod.LithoLeatherNameSpace, "litholeather:lichenstone", "lichenstone",ModBlocks.lichenstone);
            System.out.println("[LithoLeather] 地衣岩 ItemBlock 注册成功");
        }
    }

    /**
     * 处理方块注册事件
     */
    @Subscribe
    public void onBlockRegister(BlockRegistryEvent event) {
        System.out.println("[LithoLeather] 方块注册事件触发");
    }

    /**
     * 处理成就注册事件
     */
    @Subscribe
    public void onAchievementRegister(AchievementRegistryEvent event) {
        ModAchievements.registerAchievements();
    }

    /**
     * 处理配方注册事件
     */
    @Subscribe
    public void onRecipeRegister(RecipeRegistryEvent event) {
        System.out.println("[LithoLeather] 开始配方注册...");

        // 亚麻布配方（无序）: 3 亚麻纤维 → 1 亚麻布
        if (ModItems.linenCloth != null && ModItems.flaxFiber != null) {
            try {
                event.registerShapelessRecipe(
                        new ItemStack(ModItems.linenCloth, 1),
                        true,
                        new ItemStack(ModItems.flaxFiber),
                        new ItemStack(ModItems.flaxFiber),
                        new ItemStack(ModItems.flaxFiber)
                ).difficulty(30.0F);
                System.out.println("[LithoLeather] 亚麻布配方注册成功");
            } catch (Exception e) {
                System.err.println("[LithoLeather] 亚麻布配方注册失败: " + e.getMessage());
            }
        }

        // 燧石镐配方（有序）- 只能在燧石工作台合成
        if (ModItems.flintPickaxe != null) {
            try {
                System.out.println("[LithoLeather] 开始注册燧石镐配方...");
                System.out.println("[LithoLeather] 燧石镐 ID: " + ModItems.flintPickaxe.itemID);
                
                event.registerShapedRecipe(
                        new ItemStack(ModItems.flintPickaxe, 1),
                        false,  // false = 只能在燧石工作台合成
                        "FFF",
                        " S ",
                        " S ",
                        'F', new ItemStack(Item.flint),
                        'S', new ItemStack(Item.stick)
                ).difficulty(40.0F);
                
                System.out.println("[LithoLeather] 燧石镐配方注册成功（燧石工作台）");
            } catch (Exception e) {
                System.err.println("[LithoLeather] 燧石镐配方注册失败: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            System.err.println("[LithoLeather] 燧石镐为 null，无法注册配方");
        }

        // 皮革配方（有序）: 亚麻布 + 鞣质岩粉 → 皮革
        // 配方形状:
        // T T
        // L L
        // T = 鞣质岩粉, L = 亚麻布
        if (ModItems.tannicAsh != null && ModItems.linenCloth != null) {
            try {
                event.registerShapedRecipe(
                        new ItemStack(Item.leather, 1),
                        true,
                        "TT",
                        "LL",
                        'T', new ItemStack(ModItems.tannicAsh),
                        'L', new ItemStack(ModItems.linenCloth)
                ).difficulty(50.0F);
                System.out.println("[LithoLeather] 皮革配方注册成功");
            } catch (Exception e) {
                System.err.println("[LithoLeather] 皮革配方注册失败: " + e.getMessage());
            }
        }

        // 注册熔炼配方
        registerSmeltingRecipes();

        System.out.println("[LithoLeather] 配方注册完成");
    }

    /**
     * 注册熔炼配方
     * 地衣岩碎片 -> 鞣质岩粉
     */
    private void registerSmeltingRecipes() {
        try {
            if (ModItems.lichenFragment != null && ModItems.tannicAsh != null) {
                // 地衣岩碎片烧制成鞣质岩粉
                // addSmelting(输入物品ID, 输出ItemStack)
                FurnaceRecipes.smelting().addSmelting(
                        ModItems.lichenFragment.itemID,
                        new ItemStack(ModItems.tannicAsh, 1)
                );
                System.out.println("[LithoLeather] 熔炼配方注册成功: 地衣岩碎片 -> 鞣质岩粉");
            } else {
                System.err.println("[LithoLeather] 熔炼配方注册失败: 物品未注册");
            }
        } catch (Exception e) {
            System.err.println("[LithoLeather] 熔炼配方注册失败: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
