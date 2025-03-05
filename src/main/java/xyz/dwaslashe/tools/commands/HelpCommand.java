package xyz.dwaslashe.tools.commands;

import org.bukkit.command.CommandSender;
import xyz.dwaslashe.tools.Main;
import xyz.dwaslashe.tools.commands.managers.Command;
import xyz.dwaslashe.tools.utils.Api;

import java.util.List;

public class HelpCommand extends Command {
    public HelpCommand() {
        super("help", "/help", "", "pomoc");
    }

    @Override
    public List<String> tabCompleteExecute(CommandSender sender, String[] args) {
        return null;
    }

    @Override
    public void commandExecute(CommandSender sender, String[] args) {
        for (String s : Main.pluginCommands.getCommands().getHelp().getHelp()) {
            Api.sendMessage(sender, s);
        }
    }
}
