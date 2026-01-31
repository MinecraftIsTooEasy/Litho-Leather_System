package com.m.litholeather.item;

import com.m.litholeather.block.ModBlocks;
import net.minecraft.Block;
import net.minecraft.CreativeTabs;
import net.minecraft.Material;
import net.xiaoyu233.fml.api.item.PickaxeItem;

/**
 * 燧石镐 - 早期工具，可挖掘地衣岩
 * 挖掘等级：1（石头等级）
 * 耐久度：80
 */
public class ItemFlintPickaxe extends PickaxeItem {
    
    public ItemFlintPickaxe(int id) {
        super(id, Material.flint); // 使用 flint 材质
        this.setMaxDamage(80); // 设置耐久度为 80
        this.setCreativeTab(CreativeTabs.tabTools);
        this.setTextureName("litholeather:flint_pickaxe");
    }
    
    /**
     * 获取最低制作难度
     */
    @Override
    public float getLowestCraftingDifficultyToProduce() {
        return 40.0F; // 与配方难度一致
    }
    
    /**
     * 检查工具是否可以挖掘指定方块
     */
    public boolean canHarvestBlock(Block block) {
        // 可以挖掘石头、圆石、煤矿
        if (block == Block.stone || block == Block.cobblestone || 
            block == Block.oreCoal) {
            return true;
        }
        
        // 可以挖掘地衣岩
        if (ModBlocks.lichenstone != null && block == ModBlocks.lichenstone) {
            return true;
        }
        
        // 不能挖掘铁矿、红石矿、青金石矿、钻石矿
        if (block == Block.oreIron || block == Block.oreRedstone || 
            block == Block.oreLapis || block == Block.oreDiamond) {
            return false;
        }
        
        // 默认返回 false
        return false;
    }
}
