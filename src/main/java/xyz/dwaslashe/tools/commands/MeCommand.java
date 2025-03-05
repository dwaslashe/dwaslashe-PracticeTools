package xyz.dwaslashe.tools.commands;

import org.apache.commons.lang.StringUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.dwaslashe.tools.commands.managers.Command;
import xyz.dwaslashe.tools.managers.CooldownManager;
import xyz.dwaslashe.tools.utils.Api;

import java.util.List;

public class MeCommand extends Command {

    public MeCommand() {
        super("me", "/me <tresc>", "", "minecraft:me");
        setOnlyPlayer(true);
        setPermission("core.command.me");
    }

    @Override
    public List<String> tabCompleteExecute(CommandSender sender, String[] args) {
        return null;
    }

    @Override
    public void commandExecute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if (args.length >= 1) {
            if (CooldownManager.checkDelay(p) == true) {
                return;
            }
            CooldownManager.addColdown(p, "3s");
            String msg = "";
            Api.sendBroadcast("&7* " + p.getName() + " &f" + StringUtils.join(args, " ", 0, args.length));

        } else if (args.length == 0) {
            wrongUsage();
        }
    }
}
