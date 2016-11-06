package org.devathon.contest2016.backend;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class was created on 11/5/16 by @codenameflip
 * All code contained within this class is sole property of the author.
 **/

public class Backend {

    private static Backend instance;
    public Backend() { instance = this; }
    public static Backend getInstance() { return instance; }

    public List<Player> inMachineMode = new ArrayList<>();

    public boolean isInMachineMdoe(Player player) {
        return inMachineMode.contains(player);
    }

    public Map<Entity, EntityStatus> markedEntities = new HashMap<>();

    public Map<Entity, EntityStatus> getMarkedEntities() {
        return markedEntities;
    }

    public boolean isMarked(Entity entity) {
        return getMarkedEntities().containsKey(entity);
    }

    public EntityStatus getMark(Entity entity) {
        if (isMarked(entity)) {
            return getMarkedEntities().get(entity);
        } else {
            throw new NullPointerException("Cannot run #getStatus() in Backend.java due to the entity not being registered in the #getMarkedEntities()");
        }
    }

    public void evaluateStatus(Player player, Entity entity) {
        /*
        We are looking for:
        - Entity type
        - Distance from player
        - Possible damage that can be enflicted

        All to evaluate situation status
         */

        // TODO
    }

}
