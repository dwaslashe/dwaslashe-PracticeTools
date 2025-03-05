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

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MsgCommand extends Command {
    static HashMap<Player, Player> lastMsg = new HashMap();
    public MsgCommand() {
        super("msg", "/msg <nick> <tresc>", "", "tell", "whisper");
        setOnlyPlayer(true);
    }

    @Override
    public List<String> tabCompleteExecute(CommandSender sender, String[] args) {
        if (args.length == 1) return Collections.singletonList("[players]");
        return null;
    }

    @Override
    public void commandExecute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if (args.length < 2) {
            wrongUsage();
        } else if (args.length > 1) {
            Player p2 = Bukkit.getPlayer(args[0]);
            if (p2 == null) {
                offlinePlayer();
                return;
            }

            String msg = StringUtils.join(args, " ", 1, args.length);

            if(msg.isEmpty()) {
                Api.sendMessage(p, Main.pluginConfig.getMessages().getPrefix() + "&cWiadomość nie może być pusta");
                return;
            }
            lastMsg.put(p, p2);
            lastMsg.put(p2, p);

            if (IgnoreCommand.blockMsg.contains(p2)) {
                Api.sendMessage(p, Main.pluginConfig.getMessages().getPrefix() + "&cNie możesz wysłać wiadomości ponieważ dana osoba wyłączyła wysyłanie prywatnych wiadomości!");
                return;
            }

            if (IgnoreCommand.ignoreMsg.containsValue(p) || IgnoreCommand.ignoreMsg.containsValue(p2)) {
                Api.sendMessage(p, Main.pluginConfig.getMessages().getPrefix() + "&cNie możesz wysłać wiadomości ponieważ dana osoba Cię wyciszyła!");
                return;
            }

            SocialSpyCommand.getList()
                    .stream()
                    .map(o -> o = Bukkit.getPlayer((String) o))
                    .filter(Objects::nonNull)
                    .forEach(po -> {
                        ((Player) po).sendMessage(Api.fixColor("&c&lSocialSPY &8[ &d" + p.getPlayer().getName() + " &8> &d" + p2.getPlayer().getName() + " &8] &8» &d" + msg));
                    });
            Api.sendMessage(p, "&8[ &dTY &8> &d" + p2.getPlayer().getName() + " &8] &8» &d" + msg);
            Api.sendMessage(p2, "&8[ &d" + p.getPlayer().getName() + " &8> &dTY &8] &8» &d" + msg);
        }
    }

    public static HashMap<Player, Player> getLastMsg() {
        return lastMsg;
    }

}