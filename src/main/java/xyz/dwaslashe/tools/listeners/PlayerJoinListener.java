package xyz.dwaslashe.tools.listeners;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import xyz.dwaslashe.tools.Main;
import xyz.dwaslashe.tools.utils.Api;
import xyz.dwaslashe.tools.utils.ChatApi;

public class PlayerJoinListener implements Listener {

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(null);
        Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getPlugin(), () -> {
            final Player p = e.getPlayer();

            if (p.hasPermission("core.join.vip")) {
                Api.sendBroadcast(PlaceholderAPI.setPlaceholders(p, Main.pluginConfig.getJoin().getVipbroadcast()).replace("{PLAYER}", p.getDisplayName()).replace("{PREFIX}", PlaceholderAPI.setPlaceholders(p, ChatApi.getPrefix(p))));
            }
            p.sendMessage("");

        }, 5);
    }

    @EventHandler
    public void OnPlayerLoginEvent(PlayerLoginEvent event) {
        if (event.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
            Player player = event.getPlayer();
            if (player.hasPermission("core.join.full.bypass")) {
                event.allow();
            }
        }
    }
}