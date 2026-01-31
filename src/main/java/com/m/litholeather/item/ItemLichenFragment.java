package com.m.litholeather.item;

import net.minecraft.CreativeTabs;
import net.minecraft.Material;
import net.xiaoyu233.fml.api.item.ModItem;

/**
 * 地衣岩碎片 - 挖掘地衣岩获得的碎片
 */
public class ItemLichenFragment extends ModItem {
    
    public ItemLichenFragment(int id) {
        super(id, Material.iron, "lichen_fragment");
        this.setMaxStackSize(64);
        this.setCraftingDifficultyAsComponent(20.0F);
        this.setCreativeTab(CreativeTabs.tabMaterials);
        this.setTextureName("litholeather:lichen_fragment");
    }
}
