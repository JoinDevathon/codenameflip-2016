package org.devathon.contest2016.backend.holograms;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.devathon.contest2016.DevathonPlugin;
import org.devathon.contest2016.backend.Backend;
import org.devathon.contest2016.utils.TitleHelper;
import org.devathon.contest2016.utils.VectorUtils;

/**
 * This class was created on 11/5/16 by @codenameflip
 * All code contained within this class is sole property of the author.
 **/

public class HologramLookEvent implements Listener {

    @EventHandler
    public void onHologramLookEvent(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if ((event.getTo().getPitch() != event.getFrom().getPitch()) || (event.getTo().getYaw() != event.getFrom().getYaw())) {
            if (VectorUtils.getLookingAt(player) != null) {
                ArmorStand entity = VectorUtils.getLookingAt(player);

                if (Backend.getInstance().isHologram(entity)) {
                    AnchoredHologram hologram = Backend.getInstance().getHologram(entity);
                    System.out.println(hologram);

                    if (hologram != null) {
                        if (!hologram.isHover()) hologram.setHover(true);

                        TitleHelper.sendAnimationTitle(player, 2, 2, "Asset located...", 10, false);

                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                if (VectorUtils.getLookingAt(player) == null || VectorUtils.getLookingAt(player) != entity) {
                                    hologram.setHover(false);
                                }
                            }
                        }.runTaskTimer(DevathonPlugin.getInstance(), 0, 15);
                    }
                }
            }
        }
    }

}
