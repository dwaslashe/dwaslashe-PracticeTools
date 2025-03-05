package xyz.dwaslashe.tools.managers;

import com.google.common.collect.Maps;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.dwaslashe.tools.Main;
import xyz.dwaslashe.tools.utils.Api;
import xyz.dwaslashe.tools.utils.TimerApi;

import java.util.Map;

public class CooldownManager {
    protected static final Map<CommandSender, Long> delay = Maps.newHashMap();

    public static void addColdown(CommandSender s, String time) {
        if (delay.containsKey(s) && delay.get(s) > System.currentTimeMillis()) {
            Api.sendMessage(s, Main.pluginConfig.getMessages().getPrefix() + "&cKomende możesz użyć za &e" + TimerApi.secondsToString(delay.get(s)));
            return;
        }
        delay.remove(s);

        delay.put(s, TimerApi.parseDateDiff(time, true));
        if (s instanceof Player); {
            Player p = (Player) s;
            if (p.hasPermission("core.cooldown.bypass")) {
                delay.remove(p);
            } else delay.put(s, TimerApi.parseDateDiff(time, true));
        }
    }

    public static boolean checkDelay(CommandSender s) {
        if (delay.containsKey(s) && delay.get(s) > System.currentTimeMillis()) {
            Api.sendMessage(s, Main.pluginConfig.getMessages().getPrefix() + "&cKomende możesz użyć za &e" + TimerApi.secondsToString(delay.get(s)));
            return true;
        } else return false;
    }

}
