package com.m.litholeather.item;

import net.minecraft.CreativeTabs;
import net.minecraft.Material;
import net.xiaoyu233.fml.api.item.ModItem;

/**
 * 鞣质岩粉 - 由地衣岩碎片煅烧获得的粉末
 */
public class ItemTannicAsh extends ModItem {
    
    public ItemTannicAsh(int id) {
        super(id, Material.sand, "tannic_ash");
        this.setMaxStackSize(64);
        this.setCraftingDifficultyAsComponent(60.0F);
        this.setCreativeTab(CreativeTabs.tabMaterials);
        this.setTextureName("litholeather:tannic_ash");
    }
}
