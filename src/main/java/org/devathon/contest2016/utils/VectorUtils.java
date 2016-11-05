package org.devathon.contest2016.utils;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/**
 * This class was created on 11/5/16 by @codenameflip
 * All code contained within this class is sole property of the author.
 **/

public class VectorUtils {

    public static boolean isEntityInSight(Player player, Entity entity) {
        return player.hasLineOfSight(entity);
    }

}
