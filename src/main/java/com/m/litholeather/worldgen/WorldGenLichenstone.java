package com.m.litholeather.worldgen;

import com.m.litholeather.block.ModBlocks;
import net.minecraft.*;

import java.util.Random;

/**
 * 地衣岩世界生成器
 * 在 Y < 64 的位置，以 8% 的概率替换石头方块为地衣岩
 */
public class WorldGenLichenstone {
    
    /**
     * 在指定区块中生成地衣岩
     * 由 Mixin 调用
     */
    public static void generateLichenstone(World world, Random random, int chunkX, int chunkZ) {
        if (ModBlocks.lichenstone == null) {
            return;
        }
        
        // 仅在主世界生成
        if (world.provider.dimensionId != 0) {
            return;
        }
        
        // 遍历区块中的所有方块
        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 64; y++) {  // Y < 64
                for (int z = 0; z < 16; z++) {
                    int worldX = chunkX + x;
                    int worldY = y;
                    int worldZ = chunkZ + z;
                    
                    // 检查是否为石头方块
                    int blockId = world.getBlockId(worldX, worldY, worldZ);
                    if (blockId == Block.stone.blockID) {
                        // 2% 概率替换为地衣岩
                        if (random.nextFloat() < 0.005F) {
                            world.setBlock(worldX, worldY, worldZ, 
                                         ModBlocks.lichenstone.blockID, 0, 2);
                        }
                    }
                }
            }
        }
    }
}
