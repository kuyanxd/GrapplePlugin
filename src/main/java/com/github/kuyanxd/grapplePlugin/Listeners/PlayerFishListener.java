package com.github.kuyanxd.grapplePlugin.Listeners;

import com.github.kuyanxd.grapplePlugin.Items.Items;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class PlayerFishListener implements Listener {
    @EventHandler
    public void onPlayerFish(PlayerFishEvent event){
        if (event.getState().equals(PlayerFishEvent.State.REEL_IN) || event.getState().equals(PlayerFishEvent.State.IN_GROUND)) {
            Player player = event.getPlayer();
            if (Items.getGrapple().isSimilar(player.getInventory().getItemInMainHand()) || Items.getGrapple().isSimilar(player.getInventory().getItemInOffHand())) {
                FishHook fishHook = event.getHook();
                if (!fishHook.getLocation().add(0, 1, 0).getBlock().getType().equals(Material.AIR)) {
                    player.setVelocity(fishHook.getLocation().subtract(player.getLocation()).toVector().multiply(0.274));
                    player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ZOMBIE_INFECT, 0.5F, 1);
                }
                if (!fishHook.getLocation().add(0, -1, 0).getBlock().getType().equals(Material.AIR) || fishHook.isOnGround()) {
                    if (!fishHook.getLocation().add(0, -1, 0).getBlock().getType().equals(Material.WATER)) {
                        player.setVelocity(fishHook.getLocation().subtract(player.getLocation()).toVector().multiply(0.274));
                        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ZOMBIE_INFECT, 0.5F, 1);
                    }
                }
            }

        }
    }
}
