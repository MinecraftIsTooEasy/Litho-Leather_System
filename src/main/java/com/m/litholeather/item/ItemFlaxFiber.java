package com.m.litholeather.item;

import net.minecraft.CreativeTabs;
import net.minecraft.Material;
import net.xiaoyu233.fml.api.item.ModItem;

/**
 * 亚麻纤维 - 从草丛中获取的植物纤维
 */
public class ItemFlaxFiber extends ModItem {
    
    public ItemFlaxFiber(int id) {
        super(id, Material.plants, "flax_fiber");
        this.setMaxStackSize(64);
        this.setCraftingDifficultyAsComponent(10.0F);
        this.setCreativeTab(CreativeTabs.tabMaterials);
        this.setTextureName("litholeather:flax_fiber");
    }
}
