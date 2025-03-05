package xyz.dwaslashe.tools.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.dwaslashe.tools.Main;
import xyz.dwaslashe.tools.commands.managers.Command;
import xyz.dwaslashe.tools.utils.Api;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static xyz.dwaslashe.tools.commands.IgnoreCommand.blockMsg;

public class UnIgnoreCommand extends Command {

    public UnIgnoreCommand() {
        super("unignore", "/unignore <all, nick>", "", "przestanignorowac");
        setOnlyPlayer(true);
    }

    @Override
    public List<String> tabCompleteExecute(CommandSender sender, String[] args) {
        if (args.length == 1) return Collections.singletonList("[players]");
        else if (args.length == 1) return Api.startsWith(Arrays.asList("all"), args[0]);
        return null;
    }

    @Override
    public void commandExecute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("all")) {
                Api.sendMessage(p, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie przestano ignorować wszystkich graczy!");
                blockMsg.remove(p);
                return;
            }
            Player p2 = Bukkit.getPlayer(args[0]);
            if (p2 == null) {
                offlinePlayer();
                return;
            }

            Api.sendMessage(p, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie przestano ignorować gracza &e" + p2.getName());
            IgnoreCommand.ignoreMsg.remove(p, p2);
        } else wrongUsage();
    }

}
