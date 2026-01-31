package com.m.litholeather.block;

import com.m.litholeather.item.ModItems;
import net.minecraft.*;

/**
 * 地衣岩方块 - 一种特殊的石头变种
 * 挖掘等级：1（需要燧石镐）
 * 掉落：1-2 个地衣岩碎片
 */
public class BlockLichenstone extends Block {
    
    public BlockLichenstone(int id) {
        super(id, Material.stone, new BlockConstants());
        this.setHardness(2.0F);
        this.setResistance(10.0F);
        this.setStepSound(Block.soundStoneFootstep);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    /**
     * 重写掉落方法，使其掉落地衣岩碎片而不是方块本身
     */
    @Override
    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        if (ModItems.lichenFragment == null) {
            return 0;
        }
        
        // 随机掉落 1-2 个地衣岩碎片
        int quantity = 1 + info.world.rand.nextInt(2);
        return this.dropBlockAsEntityItem(info, ModItems.lichenFragment.itemID, 0, quantity, 1.0F);
    }
    
    /**
     * 获取挖掘等级
     */
    @Override
    public int getMinHarvestLevel(int metadata) {
        return 1; // 需要燧石镐或更好的工具
    }
}
