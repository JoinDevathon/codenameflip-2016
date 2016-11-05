package org.devathon.contest2016.backend.situation;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * This class was created on 11/5/16 by @codenameflip
 * All code contained within this class is sole property of the author.
 **/

public interface SituationAction {

    public String name();

    public SituationPriority[] priority();

    public void run(Player player, List<Entity> entities);
}
