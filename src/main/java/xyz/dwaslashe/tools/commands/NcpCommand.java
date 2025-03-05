package xyz.dwaslashe.tools.commands;

import org.bukkit.command.CommandSender;
import xyz.dwaslashe.tools.commands.managers.Command;
import xyz.dwaslashe.tools.utils.Api;

import java.util.List;

public class NcpCommand extends Command {
    public NcpCommand() {
        super("ncp", "/ncp", "");
    }

    @Override
    public List<String> tabCompleteExecute(CommandSender sender, String[] args) {
        return null;
    }

    @Override
    public void commandExecute(CommandSender sender, String[] args) {
        if (args.length >= 0) {
            Api.sendMessage(sender, "&cBrak permisji");
        }
    }

}