package com.m.litholeather.mixin;

import com.m.litholeather.achievement.ModAchievements;
import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * 合成成就 Mixin
 * 监听玩家从合成槽取出物品，触发相应成就
 */
@Mixin(SlotCrafting.class)
public class CraftingAchievementMixin {
    
    // 记录已经获得过药水效果的玩家
    private static final Set<UUID> playersWithEffect = new HashSet<>();
    
    @Shadow
    private EntityPlayer thePlayer;
    
    /**
     * 注入到 onPickupFromSlot 方法
     * 当玩家从合成槽取出皮革时触发"无兽之匠"成就
     * 只在首次合成时给予药水效果
     */
    @Inject(
        method = "onPickupFromSlot(Lnet/minecraft/EntityPlayer;Lnet/minecraft/ItemStack;)V",
        at = @At("HEAD")
    )
    private void onCraftingLeather(EntityPlayer player, ItemStack itemStack, CallbackInfo ci) {
        if (itemStack == null || player == null) {
            return;
        }
        
        // 检查是否合成了皮革
        if (itemStack.itemID == Item.leather.itemID) {
            // 触发成就
            if (ModAchievements.beastlessCrafter != null) {
                player.triggerAchievement(ModAchievements.beastlessCrafter);
            }
            
            // 检查玩家是否已经获得过药水效果
            UUID playerUUID = player.getUniqueID();
            boolean isFirstTime = !playersWithEffect.contains(playerUUID);
            
            // 只在首次合成时给予药水效果
            if (isFirstTime) {
                // 记录该玩家已获得药水效果
                playersWithEffect.add(playerUUID);
                
                // 给予"无兽之王"效果 - 抗性提升 I，无限时间
                // Potion.resistance 的 ID 是 11
                // 使用 Integer.MAX_VALUE 作为持续时间（接近无限）
                // 等级 0 = 抗性提升 I
                player.addPotionEffect(new PotionEffect(Potion.resistance.id, Integer.MAX_VALUE, 0));
                
                // 发送消息
                if (!player.worldObj.isRemote) {
                    player.sendChatToPlayer(ChatMessageComponent.createFromText(
                        "§6[无兽之王] §f骚年，收下我的力量吧！这就是无兽力量！"));
                }
            }
        }
    }
}
