package com.github.kuyanxd.grapplePlugin;

import com.github.kuyanxd.grapplePlugin.Commands.GrappleGiveCommand;
import com.github.kuyanxd.grapplePlugin.Items.Items;
import com.github.kuyanxd.grapplePlugin.Listeners.PlayerFishListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;

public final class GrapplePlugin extends JavaPlugin {

    public static GrapplePlugin instance;

    public static GrapplePlugin getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        getLogger().info("-- Grapple Plugin --");
        getLogger().info("https://discord.gg/mFKhsQ6tTS");

        registerListeners();

        registerCommand("grapple",new GrappleGiveCommand());

        registerRecipe();
    }

    private void registerListeners() {
        PluginManager pluginManager = getServer().getPluginManager();
        List<Listener> listeners = Arrays.asList(
                new PlayerFishListener()
        );

        for (Listener listener : listeners) {
            pluginManager.registerEvents(listener, this);
        }
    }

    private void registerCommand(String name, CommandExecutor executor) {
        PluginCommand command = getCommand(name);
        if (command != null) {
            command.setExecutor(executor);
        } else {
            getLogger().warning("Command '" + name + "' not found in plugin.yml!");
        }
    }

    private void registerRecipe(){
        NamespacedKey grappleKey = new NamespacedKey(this, "grapple");
        ShapedRecipe grapplerecipe = new ShapedRecipe(grappleKey, Items.getGrapple());
        grapplerecipe.shape(
                " FD",
                "FTS",
                "TRS"
        );
        grapplerecipe.setIngredient('S', Material.STRING);
        grapplerecipe.setIngredient('F', Material.FEATHER);
        grapplerecipe.setIngredient('D', Material.DIAMOND);
        grapplerecipe.setIngredient('T', Material.STICK);
        grapplerecipe.setIngredient('R', Material.FISHING_ROD);
        Bukkit.addRecipe(grapplerecipe);
    }

    @Override
    public void onDisable() {
        NamespacedKey namespacedKey = new NamespacedKey(this, "grapple");
        Bukkit.removeRecipe(namespacedKey);
    }
}
