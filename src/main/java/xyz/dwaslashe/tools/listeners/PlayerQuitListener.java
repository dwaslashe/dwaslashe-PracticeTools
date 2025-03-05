package xyz.dwaslashe.tools.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import xyz.dwaslashe.tools.Main;
import xyz.dwaslashe.tools.utils.Api;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerQuitListener implements Listener {
    public static Map<UUID, Double> LocYaw = new HashMap<UUID, Double>();

    public static void checkPlayer(Player p) {
        UUID uuid = p.getUniqueId();

        if (LocYaw.get(uuid) != null) {
            if ((double) p.getLocation().getYaw() == LocYaw.get(uuid)) {
                p.sendTitle(Api.fixColor("&c&lANTY-AFK"), Api.fixColor("&8>> &fe, spisz? &8<<"));
                Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
                    @Override
                    public void run() {
                        if ((double) p.getLocation().getYaw() == LocYaw.get(uuid)) {
                            Api.sendPlayerToServer(p, "lobbyafk");
                        }
                    }
                }, 20 * 60);
            } else {
                LocYaw.put(uuid, (double) p.getLocation().getYaw());
            }
        } else {
            LocYaw.put(uuid, (double) p.getLocation().getYaw());
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage(null);
        Player p = e.getPlayer();

        LocYaw.remove(p.getUniqueId());
    }
}
