package org.devathon.contest2016.backend.situation.actions;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.devathon.contest2016.backend.situation.SituationAction;
import org.devathon.contest2016.backend.situation.SituationPriority;

import java.util.List;

/**
 * This class was created on 11/5/16 by @codenameflip
 * All code contained within this class is sole property of the author.
 **/

public class ContactAssets implements SituationAction {
    @Override
    public String getName() {
        return "Contact assets";
    }

    @Override
    public String getDesciption() {
        return "Dispatch a request to all nearby assets to terminate the threat.";
    }

    @Override
    public SituationPriority[] getPriority() {
        return new SituationPriority[0];
    }

    @Override
    public void run(Player player, List<Entity> entities) {
        player.sendMessage("Assets contacted...");
    }
}
