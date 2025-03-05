package xyz.dwaslashe.tools.commands;

import org.bukkit.command.CommandSender;
import xyz.dwaslashe.tools.Main;
import xyz.dwaslashe.tools.commands.managers.Command;
import xyz.dwaslashe.tools.utils.Api;
import java.util.List;

public class RulesCommand extends Command {
    public RulesCommand() {
        super("rules", "/regulamin", "", "regulamin");
    }

    @Override
    public List<String> tabCompleteExecute(CommandSender sender, String[] args) {
        return null;
    }

    @Override
    public void commandExecute(CommandSender sender, String[] args) {
        for (String s : Main.pluginCommands.getCommands().getRules().getRules()) {
            Api.sendMessage(sender, s);
        }
    }

}