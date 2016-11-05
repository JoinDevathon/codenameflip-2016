package org.devathon.contest2016;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DevathonPlugin extends JavaPlugin implements Listener {

    private static DevathonPlugin instance;
    public static DevathonPlugin getInstance() { return instance; }

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getPluginManager().registerEvents(this, this);
        // put your enable code here
    }

    @Override
    public void onDisable() {
        // put your disable code here
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) { // this is just a test method to test my animation title
        Player player = event.getPlayer();

        TitleHelper.sendAnimationTitle(player, 5, 5, "Testing", 6, false);
    }
}

