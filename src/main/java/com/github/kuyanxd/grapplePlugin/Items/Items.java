package com.github.kuyanxd.grapplePlugin.Items;

import com.github.kuyanxd.grapplePlugin.GrapplePlugin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Items {
    public static ItemStack getGrapple() {
        ItemStack item = new ItemStack(Material.FISHING_ROD);
        ItemMeta meta = item.getItemMeta();
        String grappleName = GrapplePlugin.getInstance().getConfig().getString("GrappleName");
        meta.setDisplayName(ChatColor.YELLOW + grappleName);
        List<String> lore = GrapplePlugin.getInstance().getConfig().getStringList("Lore");
        meta.setLore(new ArrayList<>(lore));
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        return item;
    }
}
