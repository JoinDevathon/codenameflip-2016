package org.devathon.contest2016;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.devathon.contest2016.backend.Backend;
import org.devathon.contest2016.backend.holograms.HologramLookEvent;
import org.devathon.contest2016.backend.listeners.LookEvent;

public class DevathonPlugin extends JavaPlugin implements Listener {

    private static DevathonPlugin instance;
    public static DevathonPlugin getInstance() { return instance; }

    @Override
    public void onEnable() {
        instance = this;
        new Backend();
        // put your enable code here

        register(new LookEvent());
        register(new HologramLookEvent());
    }

    @Override
    public void onDisable() {
        // put your disable code here
        instance = null;

        Backend.getInstance().cleanupHolograms();
    }

    private void register(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, this);
    }

//    @EventHandler
//    public void onJoin(PlayerJoinEvent event) { // this is just a test method to test my animation title
//        Player player = event.getPlayer();
//
//        TitleHelper.sendAnimationTitle(player, 2, 2, "Find the machine.", 8, false);
//    }
}

