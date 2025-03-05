package xyz.dwaslashe.tools.utils;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import xyz.dwaslashe.tools.Main;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Api {

    public static String fixColor(String message) {
        return message == null ? "" : ChatColor.translateAlternateColorCodes('&', message)
                .replace(">>", "»")
                .replace("<<", "«");
    }

    public static List<String> fixColor(List<String> message) {
        return message.stream().map(Api::fixColor).collect(Collectors.toList());
    }

    public static void sendPacket(Player player, Packet packet){
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(packet);
    }

    public static void sendPlayerToServer(Player player, String server) {
        try {
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(b);
            out.writeUTF("Connect");
            out.writeUTF(server);
            player.sendPluginMessage(Main.getPlugin(), "BungeeCord", b.toByteArray());
            b.close();
            out.close();
        }
        catch (Exception e) {
            Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&cNie możesz się dołączyć do serwera &e" + server);
        }
    }

    public static PacketPlayOutWorldParticles sendPacketParticle(EnumParticle particleType, Location location, float xOffSet, float yOffSet, float zOffSet, float speed, int count){
        float x = (float) location.getX();
        float y = (float) location.getY();
        float z = (float) location.getZ();

        PacketPlayOutWorldParticles particles = new PacketPlayOutWorldParticles(particleType, true, x, y, z, xOffSet, yOffSet, zOffSet, speed, count, null);
        return particles;
    }

    public static void sendMessage(CommandSender sender, String message) {
        sender.sendMessage(fixColor(message));
    }

    public static void sendLog(String message) {
        Bukkit.getConsoleSender().sendMessage(fixColor(message));
    }

    public static void sendBroadcast(String message) {
        Bukkit.getOnlinePlayers().forEach(player -> sendMessage(player, fixColor(message)));
    }

    public static boolean sendActionbar(Player p, String msg) {
        IChatBaseComponent cmp = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + fixColor(msg) + "\"}");
        PacketPlayOutChat bar = new PacketPlayOutChat(cmp, ((byte)2));
        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(bar);
        return true;
    }

    public static int getPing(Player player){
        return ((CraftPlayer)player).getHandle().ping;
    }

    public static boolean isFloat(String arg) {
        try {
            Float.parseFloat(arg);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isInt(String arg) {
        try {
            Integer.parseInt(arg);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static List<String> startsWith(List<String> subcommands, String start) {
        if (start != null && !start.equals("") && subcommands != null && !subcommands.isEmpty()) {
            ArrayList<String> startingStrings = new ArrayList<>();
            for (String subcommand : subcommands) {
                if (subcommand.regionMatches(true, 0, start, 0, start.length())) {
                    startingStrings.add(subcommand);
                }
            }

            return startingStrings;
        } else {
            return subcommands;
        }
    }

    public static boolean inventoryFull(Player player) {
        if (player.getInventory().contains(Material.AIR)) {
        } else {
            Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&cTwój ekwipunek jest pełny! Zwolnij mniejsce!");
        }
        return false;
    }

}
