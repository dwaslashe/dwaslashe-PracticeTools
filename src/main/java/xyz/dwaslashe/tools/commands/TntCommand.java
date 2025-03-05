package xyz.dwaslashe.tools.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import xyz.dwaslashe.tools.Main;
import xyz.dwaslashe.tools.commands.managers.Command;
import xyz.dwaslashe.tools.utils.Api;

import java.util.HashSet;
import java.util.List;

public class TntCommand extends Command {
    public TntCommand() {
        super("tnt", "/tnt", "");
        setPermission("core.command.tnt");
        setOnlyPlayer(true);
    }

    @Override
    public List<String> tabCompleteExecute(CommandSender sender, String[] args) {
        return null;
    }

    @Override
    public void commandExecute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if (args.length >= 0) {
            Api.sendMessage(p, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie zapalaiłeś &etnt");
            Entity tnt = p.getWorld().spawn(p.getTargetBlock((HashSet<Byte>) null, 50).getLocation().add(0.0D, 1.0D, 0.0D), TNTPrimed.class);
        }
    }
}