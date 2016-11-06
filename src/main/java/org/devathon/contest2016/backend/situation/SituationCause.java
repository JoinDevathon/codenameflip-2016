package org.devathon.contest2016.backend.situation;

import org.bukkit.entity.EntityType;

import static org.bukkit.entity.EntityType.*;

/**
 * This class was created on 11/5/16 by @codenameflip
 * All code contained within this class is sole property of the author.
 **/

public enum SituationCause {

    CREEPER_EXPLODE(CREEPER, "Creeper Explosion"),
    SKELETON_SHOOT(SKELETON, "Skeleton Shot"),
    ZOMBIE_BITE(ZOMBIE, "Zombie Bite"),
    SPIDER_BITE(SPIDER, "Spider Bite"),
    SILVERFISH_BITE(SILVERFISH, "Silverfish Bite"),
    BLAZE_SHOOT(BLAZE, "Blaze Attack"),
    GUARDIAN_SHOOT(GUARDIAN, "Guardian Shot"),
    ENDERMITE_BITE(ENDERMITE, "Endermite Bite"),
    GHAST_FIRE(GHAST, "Ghast Fireball"),
    FIREBALL_APPROACH(FIREBALL, "Fireball Approach"),
    MAMGA_CUBE_COLLIDE(MAGMA_CUBE, "MagmaCube Collision"),
    SHULKER_BLAST_APPROACH(SHULKER_BULLET, "Shulker Blast"),
    SLIME_COLLIDE(SLIME, "Slime Collision"),
    WITCH_APPROACH(WITCH, "Witch Approach"),
    WITHER_SKULL_APPROACH(WITHER_SKULL, "Wither Skull Approach"),


    HOSTILE_APPROACH(new EntityType[] { CREEPER, SKELETON, ZOMBIE, SPIDER, SILVERFISH, BLAZE, GUARDIAN, ENDERMITE, GHAST, MAGMA_CUBE, SHULKER_BULLET, SLIME, WITHER_SKULL }, "Hostile Mob Approach")
    ;

    private EntityType[] allWhoCaused;
    private EntityType whoCaused;
    private String identifier;

    SituationCause(EntityType[] allWhoCaused, String identifier) {
        this.allWhoCaused = allWhoCaused;
        this.identifier = identifier;
    }

    public EntityType[] getAllWhoCaused() {
        return allWhoCaused;
    }

    SituationCause(EntityType whoCaused, String identifier) {
        this.whoCaused = whoCaused;
        this.identifier = identifier;
    }

    public EntityType getWhoCaused() {
        return whoCaused;
    }

    public String getIdentifier() {
        return identifier;
    }
}
