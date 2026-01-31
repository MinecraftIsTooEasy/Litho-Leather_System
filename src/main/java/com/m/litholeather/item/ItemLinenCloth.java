package com.m.litholeather.item;

import net.minecraft.CreativeTabs;
import net.minecraft.Material;
import net.xiaoyu233.fml.api.item.ModItem;

/**
 * 亚麻布 - 由亚麻纤维合成的布料
 */
public class ItemLinenCloth extends ModItem {
    
    public ItemLinenCloth(int id) {
        super(id, Material.cloth, "linen_cloth");
        this.setMaxStackSize(64);
        this.setCraftingDifficultyAsComponent(30.0F);
        this.setCreativeTab(CreativeTabs.tabMaterials);
        this.setTextureName("litholeather:linen_cloth");
    }
}
