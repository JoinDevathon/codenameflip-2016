package org.devathon.contest2016.backend.situation;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.devathon.contest2016.DevathonPlugin;
import org.devathon.contest2016.utils.TitleHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * This class was created on 11/5/16 by @codenameflip
 * All code contained within this class is sole property of the author.
 **/

public class SituationControlCenter implements Listener {

    public Map<Player, Situation> inSituation = new HashMap<>();

    public Map<Player, Situation> getInSituation() {
        return inSituation;
    }

    public static void dispatchSituationAlert(Player player, Situation situation) {
        DevathonPlugin.C.alert(player,
                new String[] {
                        "I have detected imminent danger, I urge you to act upon this situation immediately",
                        " ",
                        "The cause of the threat is due to a/an " + situation.getCause().getIdentifier(),
                        "How I shall neutralize the situation? Click on an option below to confirm your choice."
                }
        );

        DevathonPlugin.C.m(player, " ");

        int counter = 0;
        for (SituationAction situationAction : situation.getPriority().getListActions()) {
            counter++;
            DevathonPlugin.C.m(player, " &7&l[" + counter + "] &f" + situationAction.getName() + ": &e&o" + situationAction.getDesciption());
        }

        DevathonPlugin.C.m(player, "Type in chat the number of the option you would like me to perform.");
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        if (getInSituation().containsKey(player)) {
            String message = event.getMessage();

            try {
                int parsed = Integer.parseInt(message);
                int possibleOptions = getInSituation().get(player).getPriority().getActions().length; // might have to subtract this by one to get the index, but i dont think index will be needed.

                if (parsed > 0 && parsed <= possibleOptions) {
                    // if the option is valid
                    int desiredIndex = parsed - 1;

                    getInSituation().get(player).getPriority().getListActions().get(desiredIndex).run(player, getInSituation().get(player).getEntities());
                    TitleHelper.sendAnimationTitle(player, 2, 2, "Performing...", 11, false);
                } else {
                    // otherwise
                    DevathonPlugin.C.m(player, "Invalid option specified. The value you entered was not an existing action.");
                }
            } catch (NumberFormatException ex) {
                DevathonPlugin.C.m(player, "Invalid option specified. The value entered was not a number.");
            }
        }
    }

}
