package xyz.dwaslashe.tools.commands;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import xyz.dwaslashe.tools.commands.managers.Command;
import xyz.dwaslashe.tools.utils.Api;

import java.util.List;

public class PurchaseCommand extends Command {
    public PurchaseCommand() {
        super("purchase", "/purchase <nick>", "");
        setPermission("core.command.purchase");
    }

    @Override
    public List<String> tabCompleteExecute(CommandSender sender, String[] args) {
        return null;
    }

    @Override
    public void commandExecute(CommandSender s, String[] args) {
        OfflinePlayer p2 = Bukkit.getOfflinePlayer(args[0]);
        if (args.length == 0) {
            wrongUsage();
        } else if (args.length == 1) {
            Api.sendBroadcast("&6&lDZIĘKUJEMY &8>> &fGracz &e" + p2.getName() + " &fkupił u nas coś w sklepie! &bDziękujemy za wsparcie serwera!");
        } else if (args.length >= 2) {
            Api.sendBroadcast("&6&lDZIĘKUJEMY &8>> &fGracz &e" + p2.getName() + " &fkupił u nas &b" + StringUtils.join(args, " ", 1, args.length) + "&f! &bDziękujemy za wsparcie serwera!");
        }
    }
}
