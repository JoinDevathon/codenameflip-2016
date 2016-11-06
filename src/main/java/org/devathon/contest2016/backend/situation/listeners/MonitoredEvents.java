package org.devathon.contest2016.backend.situation.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreeperPowerEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.devathon.contest2016.backend.Backend;
import org.devathon.contest2016.backend.situation.*;

/**
 * This class was created on 11/5/16 by @codenameflip
 * All code contained within this class is sole property of the author.
 **/

public class MonitoredEvents implements Listener {


//    WITHER_SKULL_APPROACH(WITHER_SKULL),
//    BLAZE_SHOOT(BLAZE),
//    GUARDIAN_SHOOT(GUARDIAN),
//    GHAST_FIRE(GHAST),
//    FIREBALL_APPROACH(FIREBALL),

//    ZOMBIE_BITE(ZOMBIE),
//    SPIDER_BITE(SPIDER),
//    SILVERFISH_BITE(SILVERFISH),
//    ENDERMITE_BITE(ENDERMITE),
//    MAMGA_CUBE_COLLIDE(MAGMA_CUBE),
//    SHULKER_BLAST_APPROACH(SHULKER_BULLET),
//    SLIME_COLLIDE(SLIME),
//    WITCH_APPROACH(WITCH),

    @EventHandler
    public void onCreeperExplode(CreeperPowerEvent event) {
        for (Entity nearby : event.getEntity().getNearbyEntities(10, 10, 10)) {
            if (nearby instanceof Player) {
                Player player = (Player) nearby;

                if (Backend.getInstance().isInMachineMdoe(player)) {
                    Situation situation = new Situation(SituationCause.CREEPER_PRIME, player, event.getEntity());
                    situation.setStatus(SituationStatus.PERFORMING_ACTION);
                    situation.setPriority(SituationPriority.HIGH);

                    SituationControlCenter.dispatchSituationAlert(player, situation);
                }
            }
        }
    }

    @EventHandler
    public void onShoot(ProjectileLaunchEvent event) {
        Projectile projectile = event.getEntity();
        Player player = null;

        for (Entity nearby : projectile.getNearbyEntities(7, 7, 7)) {
            if (nearby instanceof Player) {
                if (Backend.getInstance().isInMachineMdoe((Player) nearby)) player = (Player) nearby;
            }
        }

        if (projectile.getShooter() instanceof LivingEntity && player != null) {
            LivingEntity shooter = (LivingEntity) projectile.getShooter();

            switch (shooter.getType()) {
                case SKELETON:
                    Situation situation = new Situation(SituationCause.SKELETON_SHOOT, player, shooter);
                    situation.setStatus(SituationStatus.PERFORMING_ACTION);
                    situation.setPriority(SituationPriority.POTENTIAL);

                    SituationControlCenter.dispatchSituationAlert(player, situation);
                    break;
            }
        }
    }


    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {

    }

}
