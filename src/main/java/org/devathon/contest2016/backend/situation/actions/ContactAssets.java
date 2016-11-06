package org.devathon.contest2016.backend.situation.actions;

import org.bukkit.entity.Entity;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.devathon.contest2016.DevathonPlugin;
import org.devathon.contest2016.backend.situation.SituationAction;
import org.devathon.contest2016.backend.situation.SituationPriority;

import java.util.List;

/**
 * This class was created on 11/5/16 by @codenameflip
 * All code contained within this class is sole property of the author.
 **/

public class ContactAssets implements SituationAction {
    @Override
    public String getName() {
        return "Contact assets";
    }

    @Override
    public String getDesciption() {
        return "Dispatch a request to all nearby assets to terminate the threat.";
    }

    @Override
    public SituationPriority[] getPriority() {
        return new SituationPriority[0];
    }

    @Override
    public void run(Player player, List<Entity> entities) {

        for (Entity entity : entities) {
            if (entity instanceof LivingEntity) {
                IronGolem golem1 = player.getWorld().spawn(entity.getLocation().clone().add(1, 0, 0), IronGolem.class);
                IronGolem golem2 = player.getWorld().spawn(entity.getLocation().clone().add(0, 0, 1), IronGolem.class);
                IronGolem golem3 = player.getWorld().spawn(entity.getLocation().clone().add(-1, 0, 0), IronGolem.class);
                IronGolem golem4 = player.getWorld().spawn(entity.getLocation().clone().add(0, 0, -1), IronGolem.class);

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if (!entity.isDead()) {
                            golem1.setTarget((LivingEntity) entity);
                            golem2.setTarget((LivingEntity) entity);
                            golem3.setTarget((LivingEntity) entity);
                            golem4.setTarget((LivingEntity) entity);
                        } else {
                            golem1.remove();
                            golem2.remove();
                            golem3.remove();
                            golem4.remove();
                        }
                    }
                }.runTaskTimer(DevathonPlugin.getInstance(), 0, 10);
            }
        }
        player.sendMessage("Assets contacted...");
    }
}
