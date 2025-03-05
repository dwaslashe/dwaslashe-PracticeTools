package xyz.dwaslashe.tools.listeners;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import xyz.dwaslashe.tools.Main;
import xyz.dwaslashe.tools.commands.ChatCommand;
import xyz.dwaslashe.tools.objects.PlayerParticles;
import xyz.dwaslashe.tools.utils.Api;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.bukkit.event.block.Action.RIGHT_CLICK_AIR;
import static org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK;

@Getter @Setter
public class OthersListener implements Listener {
    HashMap<Player, String> previousMessages = new HashMap<>();

    @EventHandler
    public void onPlayerChatSameMessage(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();
        if (previousMessages.containsKey(player)) {
            if (message.equalsIgnoreCase(previousMessages.get(player))) {
                Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&cNie możesz wysłać znowu takiej samej wiadomości!");
                event.setCancelled(true);
            }
            previousMessages.put(player, message);
        }
    }

    @EventHandler
    public void onPlayerSit(PlayerInteractEvent event) {
        Player player = event.getPlayer();
    }

    //@EventHandler
    //public void onUnknownCommand(PlayerCommandPreprocessEvent e) {
    //    Player p = e.getPlayer();
    //    if (Bukkit.getHelpMap().getHelpTopic(e.getMessage().split(" ")[0]) == null) {
    //        e.setCancelled(true);
    //        p.sendTitle(Api.fixColor(Main.pluginConfig.getMessages().getIp()), Api.fixColor("&8>> &cKomenda &e" + e.getMessage().split(" ")[0] + " &cnie istnieje &8<<"));
    //    }
    //}

    @EventHandler
    public void onSendCommand(PlayerCommandPreprocessEvent event) {
        Player p = event.getPlayer();
        String[] msg = event.getMessage().split(" ");
        List<String> allowedCommands = Main.pluginConfig.getChat().getAllowedcommands();
        for (String allowed : Main.pluginConfig.getChat().getAllowedcommands()) {
            if (msg[0].toLowerCase().equals("/" + allowed)) {
                if (!p.hasPermission("core.command.bypass")) {
                    event.setCancelled(true);
                }
            }
        }

        //String[] cmdAndArgs = event.getMessage().split(" ");
        //String cmd = cmdAndArgs[0].substring(1);
        //Command command = Main.getPlugin().getServer().getPluginCommand(cmd);
        //
        //if (!this.isAllowedCommand((Command)command)) {
        //    event.setCancelled(true);
        //    Api.sendMessage(p, "nie");
        //}
    }


    //private boolean isAllowedCommand(Command command) {
    //    List<String> allowedCommands = Main.pluginConfig.getChat().getAllowedcommands();
    //    if (allowedCommands.contains(command.getName())) {
    //        return true;
    //    } else {
    //        Iterator i$ = command.getAliases().iterator();
//
    //        String s;
    //        do {
    //            if (!i$.hasNext()) {
    //                return false;
    //            }
//
    //            s = (String)i$.next();
    //        } while(!allowedCommands.contains(s));
//
    //        return true;
    //    }
    //}

    //@EventHandler
    //public void onCommandTabSend(PlayerCommandSendEvent event) {
    //    Player p = event.getPlayer();
    //    if (!p.hasPermission("core.command.tabcomplete.bypass")) {
    //        for (String string : Main.pluginConfig.getChat().getBlocktabcommands()) {
    //            event.getCommands().add(string);
    //        }
    //    }
    //}

    @EventHandler
    public void onChat(PlayerChatEvent e) {
        Player p = e.getPlayer();
        if (ChatCommand.disablechat.get(ChatCommand.TYPE.WRITABLE) == true) {
            if (!p.hasPermission("core.chat.bypass")) {
                e.setCancelled(true);
                Api.sendMessage(p, Main.pluginConfig.getMessages().getPrefix() + "&cCzat jest wyłączony!");
            }
        }
    }

    //@EventHandler
    //public void onDeath(PlayerDeathEvent e) {
    //    if (e.getEntity().getKiller() instanceof Player) {
    //        Player killer = e.getEntity().getKiller();
    //        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + killer.getName() + " 1");
    //        Api.sendMessage(killer, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie za zabójstwo dostałeś &61$");
    //        if (killer.hasPermission("core.kill.vip")) {
    //            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + killer.getName() + " 2");
    //            Api.sendMessage(killer, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie za zabójstwo dostałeś &62$");
    //        } else if (killer.hasPermission("core.kill.svip")) {
    //            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + killer.getName() + " 3");
    //            Api.sendMessage(killer, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie za zabójstwo dostałeś &63$");
    //        } else if (killer.hasPermission("core.kill.pro")) {
    //            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + killer.getName() + " 4");
    //            Api.sendMessage(killer, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie za zabójstwo dostałeś &64$");
    //        }
    //    }
    //}

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getPlugin(), () -> {
            if (Main.pluginConfig.getCommands().isParticles()) {
                Bukkit.getOnlinePlayers().forEach(p -> {
                    if (p.getWorld().getName().equals(e.getPlayer().getWorld().getName()) && p.getLocation().getDirection().distance(e.getPlayer().getLocation().getDirection()) < 25) {
                        if (p.canSee(e.getPlayer())) {
                            PlayerParticles particles = PlayerParticles.get(e.getPlayer());
                            if (particles.getParticleType() != null) {
                                ((CraftPlayer) p).getHandle().playerConnection.sendPacket(Api.sendPacketParticle(particles.getParticleType(), e.getPlayer().getLocation(), 0.01f, 0, 0.01f, 0.05f, particles.getAmount()));
                            }
                        }
                    }
                });
            }
        }, 5);
    }

    @EventHandler
    public void onSignColor(SignChangeEvent e) {
        Player p = e.getPlayer();
        String[] lines = e.getLines();
        for (int n = 0; n <= 3; n++)
            if (p.hasPermission("core.sign.color") == true) {
                e.setLine(n, Api.fixColor(lines[n]));
            }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String message = e.getMessage();
        message = message.toLowerCase();
        List<String> wordsInMessage = Arrays.asList(message.split(" "));
        for (String word : Main.pluginConfig.getChat().getBlockwords().getWords()) {
            if (wordsInMessage.contains(word.toLowerCase())) {
                if (p.hasPermission("core.chat.block.bypass")) {
                    break;
                }
                Bukkit.getScheduler().runTask(Main.getPlugin(), () -> {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Main.pluginConfig.getChat().getBlockwords().getCommand().replace("{PLAYER}", p.getName()));
                });
                break;
            }
        }
    }

}
