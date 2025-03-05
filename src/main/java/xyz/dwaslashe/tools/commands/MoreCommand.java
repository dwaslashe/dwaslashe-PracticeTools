package xyz.dwaslashe.tools.commands;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.dwaslashe.tools.Main;
import xyz.dwaslashe.tools.commands.managers.Command;
import xyz.dwaslashe.tools.utils.Api;
import xyz.dwaslashe.tools.utils.ItemApi;
import java.util.Arrays;
import java.util.List;

public class MoreCommand extends Command {
    public MoreCommand() {
        super("more", "/more <ilosc>", "");
        setPermission("core.command.more");
        setOnlyPlayer(true);
    }

    @Override
    public List<String> tabCompleteExecute(CommandSender sender, String[] args) {
        if (args.length == 1) return Api.startsWith(Arrays.asList("1", "2", "3"), args[0]);
        return null;
    }

    @Override
    public void commandExecute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if (args.length == 1) {
            if (p.getItemInHand() == null && p.getItemInHand().getType() == Material.AIR) {
                Api.sendMessage(p, Main.pluginConfig.getMessages().getPrefix() + "&cPrzedmiot nie może być powietrzem");
                return;
            } else {
                if (Api.isInt(args[0])) {
                    p.setItemInHand(new ItemApi(p.getItemInHand()).setAmount(Integer.parseInt(args[0])).getItemStack());
                    Api.sendMessage(p, Main.pluginConfig.getMessages().getPrefix() + "&aIlość została ustawiona");
                } else {
                    Api.sendMessage(p, Main.pluginConfig.getMessages().getPrefix() + "&cIlość musi być podana w liczbie");
                }
            }
        } else if (args.length == 0) {
            if (p.getItemInHand() == null && p.getItemInHand().getType() == Material.AIR) {
                Api.sendMessage(p, Main.pluginConfig.getMessages().getPrefix() + "&cPrzedmiot nie może być powietrzem");
            } else {
                p.setItemInHand(new ItemApi(p.getItemInHand()).setAmount(64).getItemStack());
                Api.sendMessage(p, Main.pluginConfig.getMessages().getPrefix() + "&aIlość została ustawiona");
            }
        } else wrongUsage();
    }
}
