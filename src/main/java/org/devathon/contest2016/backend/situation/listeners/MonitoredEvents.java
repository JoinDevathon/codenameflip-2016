package org.devathon.contest2016.backend.situation.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreeperPowerEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;

/**
 * This class was created on 11/5/16 by @codenameflip
 * All code contained within this class is sole property of the author.
 **/

public class MonitoredEvents implements Listener {


//    CREEPER_EXPLODE(CREEPER),
//    SKELETON_SHOOT(SKELETON),
//    ZOMBIE_BITE(ZOMBIE),
//    SPIDER_BITE(SPIDER),
//    SILVERFISH_BITE(SILVERFISH),
//    BLAZE_SHOOT(BLAZE),
//    GUARDIAN_SHOOT(GUARDIAN),
//    ENDERMITE_BITE(ENDERMITE),
//    GHAST_FIRE(GHAST),
//    FIREBALL_APPROACH(FIREBALL),
//    MAMGA_CUBE_COLLIDE(MAGMA_CUBE),
//    SHULKER_BLAST_APPROACH(SHULKER_BULLET),
//    SLIME_COLLIDE(SLIME),
//    WITCH_APPROACH(WITCH),
//    WITHER_SKULL_APPROACH(WITHER_SKULL),


    @EventHandler
    public void onCreeperExplode(CreeperPowerEvent event) {

    }

    @EventHandler
    public void onShoot(ProjectileLaunchEvent event) {

    }


    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {

    }

}
