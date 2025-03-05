package xyz.dwaslashe.tools.commands;

import org.bukkit.command.CommandSender;
import xyz.dwaslashe.tools.Main;
import xyz.dwaslashe.tools.commands.managers.Command;
import xyz.dwaslashe.tools.utils.Api;

import java.util.List;

public class YTCommand extends Command {
    public YTCommand() {
        super("yt", "/yt", "");
        setOnlyPlayer(true);
    }

    @Override
    public List<String> tabCompleteExecute(CommandSender sender, String[] args) {
        return null;
    }

    @Override
    public void commandExecute(CommandSender sender, String[] args) {
        for (String s : Main.pluginCommands.getCommands().getYt().getYt()) {
            Api.sendMessage(sender, s);
        }
    }
}
