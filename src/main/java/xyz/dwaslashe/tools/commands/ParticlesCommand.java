package xyz.dwaslashe.tools.commands;

import com.google.common.collect.ImmutableList;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemFlag;
import xyz.dwaslashe.tools.Main;
import xyz.dwaslashe.tools.commands.managers.Command;
import xyz.dwaslashe.tools.objects.PlayerParticles;
import xyz.dwaslashe.tools.utils.Api;
import xyz.dwaslashe.tools.utils.Item;
import xyz.dwaslashe.tools.utils.ItemApi;

import java.util.Arrays;
import java.util.List;

public class ParticlesCommand extends Command implements Listener {
    public ParticlesCommand( ) {
        super("particles", "", "/particles", "particlesy");
        setPermission("core.command.particles");
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
            see(p);
        }
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String alias, String[] args) throws IllegalArgumentException {
        return ImmutableList.of();
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getCurrentItem() == null) return;
        if ("Particlesy".equalsIgnoreCase(e.getInventory().getTitle())) {
            e.setCancelled(true);
            PlayerParticles p = PlayerParticles.get((Player) e.getWhoClicked());
            Player player = (Player) e.getWhoClicked();
            if (e.getSlot() == 18) {
                p.setParticleType(null);
                see(player);
                Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&cUsunieto particlesy");
            } else if (e.getSlot() == 19) {
                p.setParticleType(EnumParticle.HEART);
                see(player);
                Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aUstawiono particlesy &e" + p.getParticleType());
            } else if (e.getSlot() == 20) {
                p.setParticleType(EnumParticle.FLAME);
                see(player);
                Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aUstawiono particlesy &e" + p.getParticleType());
            } else if (e.getSlot() == 21) {
                p.setParticleType(EnumParticle.VILLAGER_HAPPY);
                see(player);
                Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aUstawiono particlesy &e" + p.getParticleType());
            } else if (e.getSlot() == 22) {
                p.setParticleType(EnumParticle.VILLAGER_ANGRY);
                see(player);
                Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aUstawiono particlesy &e" + p.getParticleType());
            } else if (e.getSlot() == 23) {
                p.setParticleType(EnumParticle.DRIP_WATER);
                see(player);
                Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aUstawiono particlesy &e" + p.getParticleType());
            } else if (e.getSlot() == 24) {
                p.setParticleType(EnumParticle.SLIME);
                see(player);
                Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aUstawiono particlesy &e" + p.getParticleType());
            } else if (e.getSlot() == 25) {
                p.setParticleType(EnumParticle.SNOWBALL);
                see(player);
                Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aUstawiono particlesy &e" + p.getParticleType());
            } else if (e.getSlot() == 26) {
                p.setParticleType(EnumParticle.DRIP_LAVA);
                see(player);
                Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aUstawiono particlesy &e" + p.getParticleType());
            } else if(e.getSlot() == 29){
                p.setAmount(1);
                see(player);
                Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aIlosc czasteczek efektu zostala zmieniona na &e" + p.getAmount());
            } else if(e.getSlot() == 30){
                p.setAmount(2);
                see(player);
                Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aIlosc czasteczek efektu zostala zmieniona na &e" + p.getAmount());
            } else if(e.getSlot() == 31){
                p.setAmount(3);
                see(player);
                Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aIlosc czasteczek efektu zostala zmieniona na &e" + p.getAmount());
            } else if(e.getSlot() == 32){
                p.setAmount(4);
                see(player);
                Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aIlosc czasteczek efektu zostala zmieniona na &e" + p.getAmount());
            } else if(e.getSlot() == 33){
                p.setAmount(5);
                see(player);
                Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aIlosc czasteczek efektu zostala zmieniona na &e" + p.getAmount());
            }
        }
    }

    private InventoryView see(Player p) {
        Inventory inv = Bukkit.createInventory(p, 5 * 9, "Particlesy");

        PlayerParticles particles = PlayerParticles.get(p);
        inv.setItem(4, new ItemApi(Material.BOOK).setName("&aTwoje aktualne particlesy").setLore(Arrays.asList("" , " &7Particles &f" + (particles.getParticleType() == null ? "Brak" : particles.getParticleType().toString()), " &7Ilosc czasteczek &8(&f" + particles.getAmount() + "&8)")).getItemStack());

        ItemApi remove = new ItemApi(Material.SIGN).setName("&cUsun efekt");
        if (particles.getParticleType() == null) {
            remove.addItemFlag(ItemFlag.HIDE_ENCHANTS);
            remove.addEnchant(Enchantment.DURABILITY, 1);
        }
        inv.setItem(18, remove.getItemStack());

        Item item = new Item(Material.RED_ROSE).setName("&cSerce");
        if (particles.getParticleType() == EnumParticle.HEART) {
            item.addItemFlag(ItemFlag.HIDE_ENCHANTS);
            item.addEnchant(Enchantment.DURABILITY, 1);
        }
        inv.setItem(19, item.getItemStack());

        Item item1 = new Item(Material.BLAZE_ROD).setName("&6Plomien");
        if (particles.getParticleType() == EnumParticle.FLAME) {
            item1.addItemFlag(ItemFlag.HIDE_ENCHANTS);
            item1.addEnchant(Enchantment.DURABILITY, 1);
        }
        inv.setItem(20, item1.getItemStack());

        Item item2 = new Item(Material.getMaterial(383), (short)120).setName("&aSzczesliwy Villager");
        if (particles.getParticleType() == EnumParticle.VILLAGER_HAPPY) {
            item2.addItemFlag(ItemFlag.HIDE_ENCHANTS);
            item2.addEnchant(Enchantment.DURABILITY, 1);
        }
        inv.setItem(21, item2.getItemStack());

        Item item3 = new Item(Material.getMaterial(383), (short)120).setName("&cWsciekly Villager");
        if (particles.getParticleType() == EnumParticle.VILLAGER_ANGRY) {
            item3.addItemFlag(ItemFlag.HIDE_ENCHANTS);
            item3.addEnchant(Enchantment.DURABILITY, 1);
        }
        inv.setItem(22, item3.getItemStack());

        Item item4 = new Item(Material.WATER_BUCKET).setName("&bWoda");
        if (particles.getParticleType() == EnumParticle.DRIP_WATER) {
            item4.addItemFlag(ItemFlag.HIDE_ENCHANTS);
            item4.addEnchant(Enchantment.DURABILITY, 1);
        }
        inv.setItem(23, item4.getItemStack());

        Item item5 = new Item(Material.SLIME_BALL).setName("&aSlime");
        if (particles.getParticleType() == EnumParticle.SLIME) {
            item5.addItemFlag(ItemFlag.HIDE_ENCHANTS);
            item5.addEnchant(Enchantment.DURABILITY, 1);
        }
        inv.setItem(24, item5.getItemStack());

        Item item6 = new Item(Material.SNOW_BALL).setName("&fSnieg");
        if (particles.getParticleType() == EnumParticle.SNOWBALL) {
            item6.addItemFlag(ItemFlag.HIDE_ENCHANTS);
            item6.addEnchant(Enchantment.DURABILITY, 1);
        }
        inv.setItem(25, item6.getItemStack());

        Item item7 = new Item(Material.LAVA_BUCKET).setName("&cLava");
        if (particles.getParticleType() == EnumParticle.SNOWBALL) {
            item7.addItemFlag(ItemFlag.HIDE_ENCHANTS);
            item7.addEnchant(Enchantment.DURABILITY, 1);
        }
        inv.setItem(26, item7.getItemStack());

        Item strong_0 = new Item(Material.SKULL_ITEM, (short)3).setOwnerURL("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmQ1N2UzYmM4OGE2NTczMGUzMWExNGUzZjQxZTAzOGE1ZWNmMDg5MWE2YzI0MzY0M2I4ZTU0NzZhZTIifX19").setName("&aIlosc czasteczek &e5");
        inv.setItem(33, strong_0.getItemStack());
        Item strong_1 = new Item(Material.SKULL_ITEM, (short)3).setOwnerURL("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzFiYzJiY2ZiMmJkMzc1OWU2YjFlODZmYzdhNzk1ODVlMTEyN2RkMzU3ZmMyMDI4OTNmOWRlMjQxYmM5ZTUzMCJ9fX0=").setName("&aIlosc czasteczek &e1");
        inv.setItem(29, strong_1.getItemStack());
        Item strong_2 = new Item(Material.SKULL_ITEM, (short)3).setOwnerURL("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGNkOWVlZWU4ODM0Njg4ODFkODM4NDhhNDZiZjMwMTI0ODVjMjNmNzU3NTNiOGZiZTg0ODczNDE0MTk4NDcifX19").setName("&aIlosc czasteczek &e2");
        inv.setItem(30, strong_2.getItemStack());
        Item strong_3 = new Item(Material.SKULL_ITEM, (short)3).setOwnerURL("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWQ0ZWFlMTM5MzM4NjBhNmRmNWU4ZTk1NTY5M2I5NWE4YzNiMTVjMzZiOGI1ODc1MzJhYzA5OTZiYzM3ZTUifX19").setName("&aIlosc czasteczek &e3");
        inv.setItem(31, strong_3.getItemStack());
        Item strong_4 = new Item(Material.SKULL_ITEM, (short)3).setOwnerURL("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDJlNzhmYjIyNDI0MjMyZGMyN2I4MWZiY2I0N2ZkMjRjMWFjZjc2MDk4NzUzZjJkOWMyODU5ODI4N2RiNSJ9fX0=").setName("&aIlosc czasteczek &e4");
        inv.setItem(32, strong_4.getItemStack());

        return p.openInventory(inv);
    }
}
