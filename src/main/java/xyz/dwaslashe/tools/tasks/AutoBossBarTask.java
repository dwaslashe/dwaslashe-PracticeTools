package xyz.dwaslashe.tools.tasks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import xyz.dwaslashe.tools.Main;
import xyz.dwaslashe.tools.utils.BossBarApi;

public class AutoBossBarTask extends BukkitRunnable {
    private int id = 0;
    public AutoBossBarTask(Main plugin){
        runTaskTimer(plugin, 0, 20*60*Main.pluginConfig.getAuto().getBossBarAuto().getTime());
    }

    @Override
    public void run() {
        for (Player all : Bukkit.getOnlinePlayers()) {
            BossBarApi.sendBossBar(all);
        }
    }
}