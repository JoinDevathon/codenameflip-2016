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
    public String name() {
        return "Contact assets";
    }

    @Override
    public SituationPriority[] priority() {
        return new SituationPriority[]{ SituationPriority.IRRELEVANT, SituationPriority.MONITOR, SituationPriority.POTENTIAL, SituationPriority.HIGH };
    }

    @Override
    public void run(Player player, List<Entity> entities) {

    }
}