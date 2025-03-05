package xyz.dwaslashe.tools.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.dwaslashe.tools.Main;
import xyz.dwaslashe.tools.commands.managers.Command;
import xyz.dwaslashe.tools.managers.CooldownManager;
import xyz.dwaslashe.tools.utils.Api;

import java.util.List;

public class DayCommand extends Command {
    public DayCommand() {
        super("day", "/day", "", "dzien");
        setPermission("core.command.day");
    }

    @Override
    public List<String> tabCompleteExecute(CommandSender sender, String[] args) {
        return null;
    }

    @Override
    public void commandExecute(CommandSender s, String[] args) {
        if (!(s instanceof Player)) {
            Bukkit.getWorld("world").setTime(0);
            Api.sendMessage(s, "&aPomyślnie zmieniłeś pogode");
        } else {
            final Player p = (Player) s;
            if (CooldownManager.checkDelay(p) == true) {
                return;
            }
            CooldownManager.addColdown(p, "10m");
            Api.sendMessage(p, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie zmieniłeś pogode");
            Bukkit.getWorld("world").setTime(0);
        }
    }

}
