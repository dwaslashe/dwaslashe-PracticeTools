package xyz.dwaslashe.tools.commands;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.dwaslashe.tools.Main;
import xyz.dwaslashe.tools.commands.managers.Command;
import xyz.dwaslashe.tools.utils.Api;

import java.util.List;
import java.util.Objects;

public class ReplyCommand extends Command {
    public ReplyCommand() {
        super("reply", "/reply <tresc>", "", "r");
        setOnlyPlayer(true);
    }

    @Override
    public List<String> tabCompleteExecute(CommandSender sender, String[] args) {
        return null;
    }

    @Override
    public void commandExecute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if (args.length < 1) {
            wrongUsage();
        } else {
            if (args.length > 0) {
                Player p2 = MsgCommand.getLastMsg().get(p);
                if (p2 == null) {
                    Api.sendMessage(p, Main.pluginConfig.getMessages().getPrefix() + "&cNie masz komu odpisać");
                    return;
                }

                String msg = StringUtils.join(args, " ", 0, args.length);

                MsgCommand.getLastMsg().put(p, p2);
                MsgCommand.getLastMsg().put(p2, p);
                SocialSpyCommand.getList()
                       .stream()
                        .map(o -> o = Bukkit.getPlayer((String) o))
                        .filter(Objects::nonNull)
                        .forEach(po -> {
                            ((Player) po).sendMessage(Api.fixColor("&c&lSocialSPY &8[ &6" + p.getName() + " &8> &6" + p2.getName() + " &8] &8» &6" + msg));
                        });
                Api.sendMessage(p, "&8[ &dTY &8> &d" + p2.getName() + " &8] &8» &d" + msg);
                Api.sendMessage(p2, "&8[ &d" + p.getName() + " &8> &dTY &8] &8» &d" + msg);
            }
        }
    }
}
