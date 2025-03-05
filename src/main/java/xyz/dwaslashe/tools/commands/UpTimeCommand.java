package xyz.dwaslashe.tools.commands;

import org.bukkit.command.CommandSender;
import xyz.dwaslashe.tools.Main;
import xyz.dwaslashe.tools.commands.managers.Command;
import xyz.dwaslashe.tools.utils.Api;
import xyz.dwaslashe.tools.utils.TimerApi;

import java.lang.management.ManagementFactory;
import java.util.List;

public class UpTimeCommand extends Command {
    public UpTimeCommand() {
        super("uptime", "/uptime", "");
    }

    @Override
    public List<String> tabCompleteExecute(CommandSender sender, String[] args) {
        return null;
    }

    @Override
    public void commandExecute(CommandSender sender, String[] args) {
        if (args.length >= 0) {
            Api.sendMessage(sender, Main.pluginConfig.getMessages().getPrefix() + "&aUpTime &e" + TimerApi.getDurationBreakdownShort(ManagementFactory.getRuntimeMXBean().getUptime()));
        }
    }
}
