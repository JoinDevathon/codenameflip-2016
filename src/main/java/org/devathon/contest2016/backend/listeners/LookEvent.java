package org.devathon.contest2016.backend.listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.devathon.contest2016.backend.Backend;
import org.devathon.contest2016.backend.EntityStatus;
import org.devathon.contest2016.backend.holograms.AnchoredHologram;
import org.devathon.contest2016.utils.VectorUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class was created on 11/5/16 by @codenameflip
 * All code contained within this class is sole property of the author.
 **/

public class LookEvent implements Listener {

    @EventHandler
    public void onLookEvent(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        List<Entity> nearby = new ArrayList<>();
        nearby.addAll(player.getNearbyEntities(30, 30, 30));

        for (Entity allNearby : nearby) {
            if (VectorUtils.isEntityInSight(player, allNearby)) {
                if (allNearby instanceof LivingEntity && allNearby.getType() != EntityType.ARMOR_STAND) {
                    if (!Backend.getInstance().isMarked(allNearby)) {
                        // TODO

                        Backend.getInstance().markedEntities.put(allNearby, EntityStatus.ASSET);

                        switch (Backend.getInstance().getMark(allNearby)) {
                            case ASSET:
                                AnchoredHologram h1 = new AnchoredHologram("&e&lAsset #" + new Random().nextInt(4000), allNearby, 0, 2, 0);
                                h1.save();

                                break;
                        }
                    }
                }
            }
        }
    }

}
