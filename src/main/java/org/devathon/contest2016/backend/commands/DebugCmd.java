package org.devathon.contest2016.backend.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.devathon.contest2016.backend.situation.*;

/**
 * This class was created on 11/5/16 by @codenameflip
 * All code contained within this class is sole property of the author.
 **/

public class DebugCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("debug")) {
            runSituationDebug((Player) sender);
        }

        return false;
    }

    private void runSituationDebug(Player sender) {
        Situation test = new Situation(SituationCause.HOSTILE_APPROACH, sender, sender.getNearbyEntities(20, 20, 20));
        test.setPriority(SituationPriority.HIGH);
        test.setStatus(SituationStatus.MONITORING);

        SituationControlCenter.dispatchSituationAlert(sender, test);
    }
}
