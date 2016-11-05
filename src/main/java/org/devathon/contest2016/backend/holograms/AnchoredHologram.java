package org.devathon.contest2016.backend.holograms;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.metadata.FixedMetadataValue;
import org.devathon.contest2016.DevathonPlugin;
import org.devathon.contest2016.backend.Backend;

import java.util.Random;

/**
 * This class was created on 11/5/16 by @codenameflip
 * All code contained within this class is sole property of the author.
 **/

public class AnchoredHologram {

    private String text;
    private Entity entity;
    private double xOffset;
    private double yOffset;
    private double zOffset;

    private ArmorStand armorStand;

    public AnchoredHologram(String text, Entity entity, double xOffset, double yOffset, double zOffset) {
        this.text = text;
        this.entity = entity;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.zOffset = zOffset;

        hover = false;

        armorStand = entity.getWorld().spawn(entity.getLocation(), ArmorStand.class);
        armorStand.setAI(false);
        armorStand.setVisible(false);
        armorStand.setGravity(false);
        armorStand.setCustomNameVisible(true);
        armorStand.setCustomName(ChatColor.translateAlternateColorCodes('&', text));
        armorStand.setMetadata("aHologram", new FixedMetadataValue(DevathonPlugin.getInstance(), new Random().nextInt(100000)));

        entity.setPassenger(armorStand);

        armorStand.teleport(new Location(entity.getWorld(), entity.getLocation().getX() + getxOffset(), entity.getLocation().getY() + getyOffset(), entity.getLocation().getZ() + getzOffset()));
    }

    private boolean hover;
    private HologramAction action;
    private ArmorStand indicator;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public double getxOffset() {
        return xOffset;
    }

    public void setxOffset(double xOffset) {
        this.xOffset = xOffset;
    }

    public double getyOffset() {
        return yOffset;
    }

    public void setyOffset(double yOffset) {
        this.yOffset = yOffset;
    }

    public double getzOffset() {
        return zOffset;
    }

    public void setzOffset(double zOffset) {
        this.zOffset = zOffset;
    }

    public ArmorStand getArmorStand() {
        return armorStand;
    }

    public boolean isHover() {
        return hover;
    }

    public void setHover(boolean hover) {
        this.hover = hover;

        if (hover) {
            ArmorStand stand = getArmorStand().getWorld().spawn(getArmorStand().getLocation().clone().subtract(0, -.3, 0), ArmorStand.class);
            stand.setAI(false);
            stand.setVisible(false);
            stand.setGravity(false);
            stand.setCustomNameVisible(true);
            stand.setCustomName("§c▲");

            setIndicator(stand);
        } else {
            getIndicator().remove();
        }
    }

    public ArmorStand getIndicator() {
        return indicator;
    }

    public void setIndicator(ArmorStand indicator) {
        this.indicator = indicator;
    }

    public HologramAction getAction() {
        return action;
    }

    public void setAction(HologramAction action) {
        this.action = action;
    }

    public void save() {
        Backend.getInstance().getHolograms().add(this);
    }

    public void kill() {
        this.armorStand.remove();
    }
}
