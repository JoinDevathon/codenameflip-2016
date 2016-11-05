package org.devathon.contest2016.backend.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.devathon.contest2016.backend.Backend;
import org.devathon.contest2016.utils.VectorUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * This class was created on 11/5/16 by @codenameflip
 * All code contained within this class is sole property of the author.
 **/

public class LookEvent implements Listener {

    @EventHandler
    public void onLookEvent(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        List<Entity> nearby = new ArrayList<>();
        nearby.addAll(player.getNearbyEntities(75, 75, 75));

        for (Entity allNearby : nearby) {
            if (VectorUtils.isEntityInSight(player, allNearby)) {
                if (!Backend.getInstance().isMarked(allNearby)) {
                    // TODO
                }
            }
        }
    }

}
