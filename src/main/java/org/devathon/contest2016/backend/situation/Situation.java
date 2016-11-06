package org.devathon.contest2016.backend.situation;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * This class was created on 11/5/16 by @codenameflip
 * All code contained within this class is sole property of the author.
 **/

public class Situation {

    private SituationCause cause;
    private Player player;
    private Entity entity;

    public Situation(SituationCause cause, Player player, Entity entity) {
        this.cause = cause;
        this.player = player;
        this.entity = entity;
    }

    private List<Entity> entities;

    public Situation(SituationCause cause, Player player, List<Entity> entities) {
        this.cause = cause;
        this.player = player;
        this.entities = entities;
    }

    SituationStatus status;
    SituationPriority priority;

    public SituationCause getCause() {
        return cause;
    }

    public Player getPlayer() {
        return player;
    }

    public Entity getEntity() {
        return entity;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public SituationStatus getStatus() {
        return status;
    }

    public void setStatus(SituationStatus status) {
        this.status = status;
    }

    public SituationPriority getPriority() {
        return priority;
    }

    public void setPriority(SituationPriority priority) {
        this.priority = priority;
    }
}
