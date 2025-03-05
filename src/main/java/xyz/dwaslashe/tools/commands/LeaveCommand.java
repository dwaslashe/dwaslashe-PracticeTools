package xyz.dwaslashe.tools.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.dwaslashe.tools.commands.managers.Command;

import java.util.List;

public class LeaveCommand extends Command {
    public LeaveCommand() {
        super("opusc", "/opusc", "");
    }

    @Override
    public List<String> tabCompleteExecute(CommandSender sender, String[] args) {
        return null;
    }

    @Override
    public void commandExecute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if (args.length >= 0) {
            p.chat("/leave");
        }
    }
}

