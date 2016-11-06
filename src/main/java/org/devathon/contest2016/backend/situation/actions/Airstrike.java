package org.devathon.contest2016.backend.situation.actions;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.devathon.contest2016.backend.situation.SituationAction;
import org.devathon.contest2016.backend.situation.SituationPriority;

import java.util.List;

/**
 * This class was created on 11/6/16 by @codenameflip
 * All code contained within this class is sole property of the author.
 **/

public class Airstrike implements SituationAction {
    @Override
    public String getName() {
        return "Airstrike";
    }

    @Override
    public String getDesciption() {
        return "Hacks into U.S. Military drones and deploys a nuclear air strike.";
    }

    @Override
    public SituationPriority[] getPriority() {
        return new SituationPriority[]{ SituationPriority.HIGH };
    }

    @Override
    public void run(Player player, List<Entity> entities) {
        for (Entity entity : entities) {
            for (int i = 0; i < 20; i++) {
                TNTPrimed tnt = entity.getWorld().spawn(entity.getLocation().clone().add(0, 20, 0), TNTPrimed.class);
                tnt.setFuseTicks(20);
            }
        }
    }
}
