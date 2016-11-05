package org.devathon.contest2016.backend.holograms;

import org.bukkit.entity.Player;
import org.devathon.contest2016.backend.situation.Situation;

/**
 * This class was created on 11/5/16 by @codenameflip
 * All code contained within this class is sole property of the author.
 **/

public interface HologramAction {

    public String getName();

    public void run(Player clicked, Situation situation);

}
