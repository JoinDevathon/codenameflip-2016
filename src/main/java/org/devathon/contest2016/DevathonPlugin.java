package org.devathon.contest2016;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.devathon.contest2016.backend.Backend;
import org.devathon.contest2016.backend.commands.DebugCmd;
import org.devathon.contest2016.backend.situation.SituationControlCenter;
import org.devathon.contest2016.backend.situation.listeners.MonitoredEvents;

public class DevathonPlugin extends JavaPlugin implements Listener {

    private static DevathonPlugin instance;
    public static DevathonPlugin getInstance() { return instance; }

    @Override
    public void onEnable() {
        instance = this;
        new Backend();
        // put your enable code here

        register(this);
        register(new SituationControlCenter());
        register(new MonitoredEvents());

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

    @EventHandler
    public void onJoin(PlayerJoinEvent event) { // this is just a test method to test my animation title
        Player player = event.getPlayer();

        Backend.getInstance().inMachineMode.add(player);

        // this code is hacky /shurg

//        new BukkitRunnable() {
//            boolean p1 = false;
//            boolean p2 = false;
//            boolean p3 = false;
//            boolean p4 = false;
//            boolean p5 = false;
//
//            @Override
//            public void run() {
//                if (!p1) {
//                    TitleHelper.sendAnimationTitle(player, 2, 2, "Welcome.", 10, false);
//                    p1 = true;
//                }
//
//                if (!p2) {
//                    TitleHelper.sendAnimationTitle(player, 2, 2, "Im glad you could make it", 7, false);
//                    p2 = true;
//                }
//
//                if (!p3) {
//                    TitleHelper.sendAnimationTitle(player, 2, 2, "I've been waiting...", 8, false);
//                    p3 = true;
//                }
//
//                if (!p4) {
//                    TitleHelper.sendAnimationTitle(player, 2, 2, "So let's start.", 8, false);
//                    p4 = true;
//                }
//
//                if (!p5) {
//                    TitleHelper.sendAnimationTitle(player, 2, 2, "I am Samaritan.", 11, false);
//                    p5 = true;
//                }
//            }
//        }.runTaskTimer(this, 0, 15);


    }

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

