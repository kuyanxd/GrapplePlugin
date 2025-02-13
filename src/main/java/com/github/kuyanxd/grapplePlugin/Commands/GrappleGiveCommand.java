package com.github.kuyanxd.grapplePlugin.Commands;

import com.github.kuyanxd.grapplePlugin.GrapplePlugin;
import com.github.kuyanxd.grapplePlugin.Items.Items;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GrappleGiveCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("grappleplugin.use") || sender.isOp()) {
                ((Player) sender).getInventory().addItem(Items.getGrapple());
                ((Player) sender).playSound(((Player) sender).getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            } else {
                String noPermissionMessage = GrapplePlugin.getInstance().getConfig().getString("noPermissionMessage");
                String prefix = ChatColor.GOLD + "[" + ChatColor.WHITE + "Grapple" + ChatColor.GOLD + "] " + ChatColor.RESET;
                sender.sendMessage(prefix + ChatColor.DARK_RED + noPermissionMessage);
            }
        }
        return false;
    }
}
