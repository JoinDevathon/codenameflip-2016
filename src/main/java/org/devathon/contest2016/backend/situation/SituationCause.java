package org.devathon.contest2016.backend.situation;

import org.bukkit.entity.EntityType;

import static org.bukkit.entity.EntityType.*;
import static org.bukkit.entity.EntityType.ENDERMITE;

/**
 * This class was created on 11/5/16 by @codenameflip
 * All code contained within this class is sole property of the author.
 **/

public enum SituationCause {

    CREEPER_EXPLODE(CREEPER),
    SKELETON_SHOOT(SKELETON),
    ZOMBIE_BITE(EntityType.ZOMBIE),
    SPIDER_BITE(SPIDER),
    SILVERFISH_BITE(SILVERFISH),
    BLAZE_SHOOT(BLAZE),
    GUARDIAN_SHOOT(GUARDIAN),
    ENDERMITE_BITE(ENDERMITE),
    GHAST_FIRE(GHAST),
    MAMGA_CUBE_COLLIDE(MAGMA_CUBE),
    SHULKER_BLAST_APPROACH(SHULKER_BULLET),
    SLIME_COLLIDE(SLIME),
    WITCH_APPROACH(WITCH),
    WITHER_SKULL_APPROACH(WITHER_SKULL),


    HOSTILE_APPROACH(new EntityType[] { CREEPER, ZOMBIE, SPIDER, SKELETON,  })
    ;

    private EntityType[] allWhoCaused;
    private EntityType whoCaused;

    SituationCause(EntityType[] allWhoCaused) {
        this.allWhoCaused = allWhoCaused;
    }

    public EntityType[] getAllWhoCaused() {
        return allWhoCaused;
    }

    SituationCause(EntityType whoCaused) {
        this.whoCaused = whoCaused;
    }

    public EntityType getWhoCaused() {
        return whoCaused;
    }

}
