package org.devathon.contest2016.utils;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.util.BlockIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * This class was created on 11/5/16 by @codenameflip
 * All code contained within this class is sole property of the author.
 **/

public class VectorUtils {

    public static boolean isEntityInSight(Player player, Entity entity) {
        return player.hasLineOfSight(entity);
    }

    public static ArmorStand getLookingAt(Player player) {
        List<Entity> nearby = player.getNearbyEntities(45, 45, 45);
        List<ArmorStand> nearbyFiltered = new ArrayList<>();

        for (Entity entity : nearby) {
            if (entity instanceof ArmorStand) {
                nearbyFiltered.add((ArmorStand) entity);
            }
        }

        BlockIterator iterator = new BlockIterator(player, 60);
        Block block;
        Location loc;
        int bx, by, bz;
        double ex, ey, ez;

        // Loop through the player's line of sight

        while (iterator.hasNext()) {
            block = iterator.next();

            bx = block.getX();
            by = block.getY();
            bz = block.getZ();

            // Check for entities near this block line of sight.

            for (ArmorStand nearLOS : nearbyFiltered) {
                loc = nearLOS.getLocation();
                ex = nearLOS.getLocation().getX();
                ey = nearLOS.getLocation().getY();
                ez = nearLOS.getLocation().getZ();

                if ((bx - .75 <= ex && ex <= bx + 1.75) && (bz - .75 <= ez && ez <= bz + 1.75) && (by - 1 <= ey && ey <= by + 2.5)) {
                    // Entity is within x distance of the iterator, found it.
                    return nearLOS;
                }
            }
        }
        return null;
    }
}