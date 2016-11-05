package org.devathon.contest2016;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class was created on 11/5/16 by @codenameflip
 * All code contained within this class is sole property of the author.
 **/

public class TitleHelper {

    public static void sendPacket(Player player, Object packet) {
        try {
            Object handle = player.getClass().getMethod("getHandle").invoke(player);
            Object playerConnection = handle.getClass().getField("playerConnection").get(handle);
            playerConnection.getClass().getMethod("sendPacket", getNMSClass("Packet")).invoke(playerConnection, packet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Class<?> getNMSClass(String name) {
        String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];

        try {
            return Class.forName("net.minecraft.server." + version + "." + name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void sendAnimationTitle(Player player, Integer fadeIn, Integer fadeOut, String message, Integer delay, boolean subTitle) {

        // the animation will have a "type writer feel" to it
        // ex: 1: "h", 2: "he", 3: "hel" and so on
        // then when completed, wait x seconds, then quickly remove all of it

        final String[] splitted = message.split("(?!^)"); // this will turn strings like "hello" into []{ "h", "e", "l", "l", "o" }

        new BukkitRunnable() {
            int counter = 0;
            int max = splitted.length - 1; // subtract one to get the index
            String current = ""; // make sure this isnt re-assigning the value every loop

            @Override
            public void run() {
                current = current + splitted[counter];

                if (subTitle) {
                    sendSubtitle(player, fadeIn, delay, fadeOut, current);
                } else {
                    sendTitle(player, fadeIn, delay, fadeOut, current, null);
                }

                counter++;

                if (counter > max) {
                    this.cancel();

                    String finalCurrent = current;
                    new BukkitRunnable() {
                        int backwardsCounter = splitted.length - 1; // this will assign the index of the last character.

                        String[] backwardsSplit = finalCurrent.split("(?!^)");
                        List<String> entries = new ArrayList<>();

                        String newFormatted = "";

                        @Override
                        public void run() {
                            if (backwardsCounter == splitted.length - 1) { // if the counter is at the end/start
                                Collections.addAll(entries, backwardsSplit);
                            }

                            entries.remove(backwardsCounter);

                            newFormatted = "";

                            for (String all : entries) {
                                newFormatted = newFormatted + all;
                            }

                            if (subTitle) {
                                sendSubtitle(player, fadeIn, delay, fadeOut, newFormatted);
                            } else {
                                sendTitle(player, fadeIn, delay, fadeOut, newFormatted, null);
                            }

                            if (entries.size() == 0) {
                                this.cancel();
                            }

                            backwardsCounter--;
                        }
                    }.runTaskTimer(DevathonPlugin.getInstance(), 10, 3);
                }
            }
        }.runTaskTimer(DevathonPlugin.getInstance(), 0, delay);
    }

    public static void sendSubtitle(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String message) {
        sendTitle(player, fadeIn, stay, fadeOut, null, message);
    }

    public static void sendTitle(Player player, Integer fadeIn, Integer stay, Integer fadeOut, String title, String subtitle) {
        try {
            Object e;
            Object chatTitle;
            Object chatSubtitle;
            Constructor subtitleConstructor;
            Object titlePacket;
            Object subtitlePacket;

            if (title != null) {
                title = ChatColor.translateAlternateColorCodes('&', title);
                title = title.replaceAll("%player%", player.getDisplayName());

                // Times packets

                e = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TIMES").get(null);
                chatTitle = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[]{String.class}).invoke(null, "{\"text\":\"" + title + "\"}");
                subtitleConstructor = getNMSClass("PacketPlayOutTitle").getConstructor(getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], getNMSClass("IChatBaseComponent"), Integer.TYPE, Integer.TYPE, Integer.TYPE);
                titlePacket = subtitleConstructor.newInstance(e, chatTitle, fadeIn, stay, fadeOut);
                sendPacket(player, titlePacket);

                e = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TITLE").get(null);
                chatTitle = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[]{String.class}).invoke(null, "{\"text\":\"" + title + "\"}");
                subtitleConstructor = getNMSClass("PacketPlayOutTitle").getConstructor(getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], getNMSClass("IChatBaseComponent"));
                titlePacket = subtitleConstructor.newInstance(e, chatTitle);
                sendPacket(player, titlePacket);
            }

            if (subtitle != null) {
                subtitle = ChatColor.translateAlternateColorCodes('&', subtitle);
                subtitle = subtitle.replaceAll("%player%", player.getDisplayName());

                // Times packets

                e = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TIMES").get(null);
                chatSubtitle = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[]{String.class}).invoke(null, "{\"text\":\"" + title + "\"}");
                subtitleConstructor = getNMSClass("PacketPlayOutTitle").getConstructor(getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], getNMSClass("IChatBaseComponent"), Integer.TYPE, Integer.TYPE, Integer.TYPE);
                subtitlePacket = subtitleConstructor.newInstance(e, chatSubtitle, fadeIn, stay, fadeOut);
                sendPacket(player, subtitlePacket);

                e = getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("SUBTITLE").get(null);
                chatSubtitle = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", new Class[]{String.class}).invoke(null, "{\"text\":\"" + subtitle + "\"}");
                subtitleConstructor = getNMSClass("PacketPlayOutTitle").getConstructor(getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], getNMSClass("IChatBaseComponent"), Integer.TYPE, Integer.TYPE, Integer.TYPE);
                subtitlePacket = subtitleConstructor.newInstance(e, chatSubtitle, fadeIn, stay, fadeOut);
                sendPacket(player, subtitlePacket);
            }
        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException | NullPointerException e) {
            e.printStackTrace();
        }
    }

}
