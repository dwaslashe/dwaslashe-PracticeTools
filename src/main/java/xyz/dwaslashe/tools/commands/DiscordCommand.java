package xyz.dwaslashe.tools.commands;

import org.bukkit.command.CommandSender;
import xyz.dwaslashe.tools.Main;
import xyz.dwaslashe.tools.commands.managers.Command;
import xyz.dwaslashe.tools.utils.Api;

import java.util.List;

public class DiscordCommand extends Command {
    public DiscordCommand() {
        super("discord", "/discord", "", "dc");
    }

    @Override
    public List<String> tabCompleteExecute(CommandSender sender, String[] args) {
        return null;
    }

    @Override
    public void commandExecute(CommandSender sender, String[] args) {
        Api.sendMessage(sender, Main.pluginConfig.getMessages().getPrefix() + "&aLink do naszego discorda &b" + Main.pluginConfig.getMessages().getDiscord());
    }
}
