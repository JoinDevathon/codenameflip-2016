package org.devathon.contest2016;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.devathon.contest2016.backend.Backend;
import org.devathon.contest2016.backend.commands.DebugCmd;

public class DevathonPlugin extends JavaPlugin implements Listener {

    private static DevathonPlugin instance;
    public static DevathonPlugin getInstance() { return instance; }

    @Override
    public void onEnable() {
        instance = this;
        new Backend();
        // put your enable code here

        register("debug", new DebugCmd());
    }

    @Override
    public void onDisable() {
        // put your disable code here
        instance = null;
    }

    private void register(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, this);
    }

    private void register(String name, CommandExecutor executor) {
        getCommand(name).setExecutor(executor);
    }

//    @EventHandler
//    public void onJoin(PlayerJoinEvent event) { // this is just a test method to test my animation title
//        Player player = event.getPlayer();
//
//        TitleHelper.sendAnimationTitle(player, 2, 2, "Find the machine.", 8, false);
//    }

    public static class C {
        public static String color(String message) {
            return ChatColor.translateAlternateColorCodes('&', message);
        }

        public static final String TAG = color("&f[SAMARITAN] &c");

        public static void m(Player player, String message) {
            player.sendMessage(TAG + color(message));
        }

        public static void alert(Player player, String[] messages) {
            player.sendMessage(color("&c&m---------------------------------------"));
            player.sendMessage(color("   &f&lSamaritan Alert"));

            for (String message : messages) {
                player.sendMessage(color("   &7" + message));
            }

            player.sendMessage(color("&c&m---------------------------------------"));
        }
    }
}

