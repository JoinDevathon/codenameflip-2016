package org.devathon.contest2016.backend;

import org.bukkit.ChatColor;

/**
 * This class was created on 11/5/16 by @codenameflip
 * All code contained within this class is sole property of the author.
 **/

public enum EntityStatus {

    ENEMY(0, ChatColor.DARK_RED),
    NEUTRAL(1, ChatColor.GRAY),
    ASSET(2, ChatColor.YELLOW),
    ADMIN(3, ChatColor.GOLD)
    ;

    private int priority;
    private ChatColor color;

    EntityStatus(int priority, ChatColor color) {
        this.priority = priority;
        this.color = color;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isFriendly() {
        return this == ADMIN || this == ASSET;
    }

}
