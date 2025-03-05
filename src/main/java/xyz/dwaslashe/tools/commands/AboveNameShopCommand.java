package xyz.dwaslashe.tools.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import xyz.dwaslashe.tools.Main;
import xyz.dwaslashe.tools.commands.managers.Command;
import xyz.dwaslashe.tools.helpers.InventoryHelper;
import xyz.dwaslashe.tools.utils.Api;

import java.util.Arrays;
import java.util.List;

public class AboveNameShopCommand extends Command implements Listener {


    public AboveNameShopCommand() {
        super("abovename", "/abovename", "", "tytuly");
    }

    @Override
    public List<String> tabCompleteExecute(CommandSender sender, String[] args) {
        return null;
    }



    @Override
    public void commandExecute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if (args.length >= 0){
            openGui(0, p);
        }
    }

    private void openGui(int guiID, Player player) {
        //0
        if (guiID == 0) {
            InventoryHelper inventoryHelper = new InventoryHelper(player, "Tytuly", 6);

            ItemStack back = inventoryHelper.prepareItemStack(Material.BARRIER, itemStack -> {
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&cWróć"));
                });
            });

            ItemStack tag_1 = inventoryHelper.prepareItemStack(Material.SKULL_ITEM, itemStack -> {
                itemStack.setDurability((short) 3);
                inventoryHelper.editSkullMetaWithProperty(itemStack, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDZiYTYzMzQ0ZjQ5ZGQxYzRmNTQ4OGU5MjZiZjNkOWUyYjI5OTE2YTZjNTBkNjEwYmI0MGE1MjczZGM4YzgyIn19fQ==");
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&cNie mam czituw, jestem na lunar"));
                    itemMeta.setLore(Api.fixColor(Arrays.asList("", player.hasPermission("core.abovenameshop.tag1") ? " &aMasz już zakupiony ten tytuł!" : " &cAby kupić ten tytuł potrzebujesz &620k$", "", player.hasPermission("core.abovenameshop.tag1") ? " &f&nKliknij aby ustawić tytuł!" : " ")));
                });
            });

            ItemStack tag_2 = inventoryHelper.prepareItemStack(Material.SKULL_ITEM, itemStack -> {
                itemStack.setDurability((short) 3);
                inventoryHelper.editSkullMetaWithProperty(itemStack, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDZiYTYzMzQ0ZjQ5ZGQxYzRmNTQ4OGU5MjZiZjNkOWUyYjI5OTE2YTZjNTBkNjEwYmI0MGE1MjczZGM4YzgyIn19fQ==");
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&dJestem nub シ"));
                    itemMeta.setLore(Api.fixColor(Arrays.asList("", player.hasPermission("core.abovenameshop.tag2") ? " &aMasz już zakupiony ten tytuł!" : " &cTytuł możesz kupić na stronie &dhttps://pvpplay.pl/", "", player.hasPermission("core.abovenameshop.tag2") ? " &f&nKliknij aby ustawić tytuł!" : " ")));
                });
            });

            ItemStack tag_3 = inventoryHelper.prepareItemStack(Material.SKULL_ITEM, itemStack -> {
                itemStack.setDurability((short) 3);
                inventoryHelper.editSkullMetaWithProperty(itemStack, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDZiYTYzMzQ0ZjQ5ZGQxYzRmNTQ4OGU5MjZiZjNkOWUyYjI5OTE2YTZjNTBkNjEwYmI0MGE1MjczZGM4YzgyIn19fQ==");
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&eMakroCzity"));
                    itemMeta.setLore(Api.fixColor(Arrays.asList("", player.hasPermission("core.abovenameshop.tag3") ? " &aMasz już zakupiony ten tytuł!" : " &cTytuł możesz kupić na stronie &dhttps://pvpplay.pl/", "", player.hasPermission("core.abovenameshop.tag3") ? " &f&nKliknij aby ustawić tytuł!" : " ")));
                });
            });

            ItemStack tag_4 = inventoryHelper.prepareItemStack(Material.SKULL_ITEM, itemStack -> {
                itemStack.setDurability((short) 3);
                inventoryHelper.editSkullMetaWithProperty(itemStack, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDZiYTYzMzQ0ZjQ5ZGQxYzRmNTQ4OGU5MjZiZjNkOWUyYjI5OTE2YTZjNTBkNjEwYmI0MGE1MjczZGM4YzgyIn19fQ==");
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&aJestem malutki ☛☚"));
                    itemMeta.setLore(Api.fixColor(Arrays.asList("", player.hasPermission("core.abovenameshop.tag4") ? " &aMasz już zakupiony ten tytuł!" : " &cTytuł możesz kupić na stronie &dhttps://pvpplay.pl/", "", player.hasPermission("core.abovenameshop.tag4") ? " &f&nKliknij aby ustawić tytuł!" : " ")));
                });
            });

            ItemStack tag_5 = inventoryHelper.prepareItemStack(Material.SKULL_ITEM, itemStack -> {
                itemStack.setDurability((short) 3);
                inventoryHelper.editSkullMetaWithProperty(itemStack, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDZiYTYzMzQ0ZjQ5ZGQxYzRmNTQ4OGU5MjZiZjNkOWUyYjI5OTE2YTZjNTBkNjEwYmI0MGE1MjczZGM4YzgyIn19fQ==");
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&dHej randka?"));
                    itemMeta.setLore(Api.fixColor(Arrays.asList("", player.hasPermission("core.abovenameshop.tag5") ? " &aMasz już zakupiony ten tytuł!" : " &cTytuł możesz kupić na stronie &dhttps://pvpplay.pl/", "", player.hasPermission("core.abovenameshop.tag5") ? " &f&nKliknij aby ustawić tytuł!" : " ")));
                });
            });

            ItemStack tag_6 = inventoryHelper.prepareItemStack(Material.SKULL_ITEM, itemStack -> {
                itemStack.setDurability((short) 3);
                inventoryHelper.editSkullMetaWithProperty(itemStack, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDZiYTYzMzQ0ZjQ5ZGQxYzRmNTQ4OGU5MjZiZjNkOWUyYjI5OTE2YTZjNTBkNjEwYmI0MGE1MjczZGM4YzgyIn19fQ==");
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&6¯\\_(ツ)_/¯"));
                    itemMeta.setLore(Api.fixColor(Arrays.asList("", player.hasPermission("core.abovenameshop.tag6") ? " &aMasz już zakupiony ten tytuł!" : " &cTytuł możesz kupić na stronie &dhttps://pvpplay.pl/", "", player.hasPermission("core.abovenameshop.tag6") ? " &f&nKliknij aby ustawić tytuł!" : " ")));
                });
            });

            ItemStack tag_7 = inventoryHelper.prepareItemStack(Material.SKULL_ITEM, itemStack -> {
                itemStack.setDurability((short) 3);
                inventoryHelper.editSkullMetaWithProperty(itemStack, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDZiYTYzMzQ0ZjQ5ZGQxYzRmNTQ4OGU5MjZiZjNkOWUyYjI5OTE2YTZjNTBkNjEwYmI0MGE1MjczZGM4YzgyIn19fQ==");
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&bIcey zimno tak jak..."));
                    itemMeta.setLore(Api.fixColor(Arrays.asList("", player.hasPermission("core.abovenameshop.tag7") ? " &aMasz już zakupiony ten tytuł!" : " &cTytuł możesz kupić na stronie &dhttps://pvpplay.pl/", "", player.hasPermission("core.abovenameshop.tag7") ? " &f&nKliknij aby ustawić tytuł!" : " ")));
                });
            });

            ItemStack tag_8 = inventoryHelper.prepareItemStack(Material.SKULL_ITEM, itemStack -> {
                itemStack.setDurability((short) 3);
                inventoryHelper.editSkullMetaWithProperty(itemStack, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDZiYTYzMzQ0ZjQ5ZGQxYzRmNTQ4OGU5MjZiZjNkOWUyYjI5OTE2YTZjNTBkNjEwYmI0MGE1MjczZGM4YzgyIn19fQ==");
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&4Duel stivku?"));
                    itemMeta.setLore(Api.fixColor(Arrays.asList("", player.hasPermission("core.abovenameshop.tag8") ? " &aMasz już zakupiony ten tytuł!" : " &cTytuł możesz kupić na stronie &dhttps://pvpplay.pl/", "", player.hasPermission("core.abovenameshop.tag7") ? " &f&nKliknij aby ustawić tytuł!" : " ")));
                });
            });

            ItemStack tag_9 = inventoryHelper.prepareItemStack(Material.SKULL_ITEM, itemStack -> {
                itemStack.setDurability((short) 3);
                inventoryHelper.editSkullMetaWithProperty(itemStack, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDZiYTYzMzQ0ZjQ5ZGQxYzRmNTQ4OGU5MjZiZjNkOWUyYjI5OTE2YTZjNTBkNjEwYmI0MGE1MjczZGM4YzgyIn19fQ==");
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&dJestem simpem"));
                    itemMeta.setLore(Api.fixColor(Arrays.asList("", player.hasPermission("core.abovenameshop.tag9") ? " &aMasz już zakupiony ten tytuł!" : " &cTytuł możesz kupić na stronie &dhttps://pvpplay.pl/", "", player.hasPermission("core.abovenameshop.tag7") ? " &f&nKliknij aby ustawić tytuł!" : " ")));
                });
            });

            ItemStack tag_10 = inventoryHelper.prepareItemStack(Material.SKULL_ITEM, itemStack -> {
                itemStack.setDurability((short) 3);
                inventoryHelper.editSkullMetaWithProperty(itemStack, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDZiYTYzMzQ0ZjQ5ZGQxYzRmNTQ4OGU5MjZiZjNkOWUyYjI5OTE2YTZjNTBkNjEwYmI0MGE1MjczZGM4YzgyIn19fQ==");
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&6Gigachad"));
                    itemMeta.setLore(Api.fixColor(Arrays.asList("", player.hasPermission("core.abovenameshop.tag10") ? " &aMasz już zakupiony ten tytuł!" : " &cTytuł możesz kupić na stronie &dhttps://pvpplay.pl/", "", player.hasPermission("core.abovenameshop.tag7") ? " &f&nKliknij aby ustawić tytuł!" : " ")));
                });
            });

            ItemStack tag_11 = inventoryHelper.prepareItemStack(Material.SKULL_ITEM, itemStack -> {
                itemStack.setDurability((short) 3);
                inventoryHelper.editSkullMetaWithProperty(itemStack, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDZiYTYzMzQ0ZjQ5ZGQxYzRmNTQ4OGU5MjZiZjNkOWUyYjI5OTE2YTZjNTBkNjEwYmI0MGE1MjczZGM4YzgyIn19fQ==");
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&5Co tam eziaki?"));
                    itemMeta.setLore(Api.fixColor(Arrays.asList("", player.hasPermission("core.abovenameshop.tag11") ? " &aMasz już zakupiony ten tytuł!" : " &cTytuł możesz kupić na stronie &dhttps://pvpplay.pl/", "", player.hasPermission("core.abovenameshop.tag7") ? " &f&nKliknij aby ustawić tytuł!" : " ")));
                });
            });

            ItemStack tag_12 = inventoryHelper.prepareItemStack(Material.SKULL_ITEM, itemStack -> {
                itemStack.setDurability((short) 3);
                inventoryHelper.editSkullMetaWithProperty(itemStack, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDZiYTYzMzQ0ZjQ5ZGQxYzRmNTQ4OGU5MjZiZjNkOWUyYjI5OTE2YTZjNTBkNjEwYmI0MGE1MjczZGM4YzgyIn19fQ==");
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&cStivek ->"));
                    itemMeta.setLore(Api.fixColor(Arrays.asList("", player.hasPermission("core.abovenameshop.tag12") ? " &aMasz już zakupiony ten tytuł!" : " &cTytuł możesz kupić na stronie &dhttps://pvpplay.pl/", "", player.hasPermission("core.abovenameshop.tag7") ? " &f&nKliknij aby ustawić tytuł!" : " ")));
                });
            });

            ItemStack tag_coming = inventoryHelper.prepareItemStack(Material.SKULL_ITEM, itemStack -> {
                itemStack.setDurability((short) 3);
                inventoryHelper.editSkullMetaWithProperty(itemStack, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDZiYTYzMzQ0ZjQ5ZGQxYzRmNTQ4OGU5MjZiZjNkOWUyYjI5OTE2YTZjNTBkNjEwYmI0MGE1MjczZGM4YzgyIn19fQ==");
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&cZa niedługo.."));
                });
            });

            ItemStack tag_info = inventoryHelper.prepareItemStack(Material.SKULL_ITEM, itemStack -> {
                itemStack.setDurability((short) 3);
                inventoryHelper.editSkullMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setOwner(player.getName());
                    itemMeta.setDisplayName(Api.fixColor("&eInformacja"));
                    itemMeta.setLore(Api.fixColor(Arrays.asList("", " &7Tytuł to jest napis, który pojawia się", " &7nad twoim nickiem. ", " ", " &f&nKliknij aby usunąć istniejący tytuł!")));
                });
            });

            inventoryHelper.click(e -> {
                e.setCancelled(true);
                if (e.getSlot() == 19) {
                    player.closeInventory();
                    if (player.hasPermission("core.abovenameshop.tag1")) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "admintitletag set " + player.getName() + " &cNie mam czituw, jestem na lunar");
                        Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie ustawiono tytuł!");
                    } else {
                        Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&cNie masz zakupionego tytułu!");
                    }
                } else if (e.getSlot() == 20) {
                    player.closeInventory();
                    if (player.hasPermission("core.abovenameshop.tag2")) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "admintitletag set " + player.getName() + " &dJestem nub シ");
                        Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie ustawiono tytuł!");
                    } else {
                        Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&cNie masz zakupionego tytułu!");
                    }
                } else if (e.getSlot() == 21) {
                    player.closeInventory();
                    if (player.hasPermission("core.abovenameshop.tag3")) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "admintitletag set " + player.getName() + " &eMakroCzity");
                        Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie ustawiono tytuł!");
                    } else {
                        Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&cNie masz zakupionego tytułu!");
                    }
                } else if (e.getSlot() == 22) {
                    player.closeInventory();
                    if (player.hasPermission("core.abovenameshop.tag4")) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "admintitletag set " + player.getName() + " &aJestem malutki ☛☚");
                        Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie ustawiono tytuł!");
                    } else {
                        Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&cNie masz zakupionego tytułu!");
                    }
                } else if (e.getSlot() == 23) {
                    player.closeInventory();
                    if (player.hasPermission("core.abovenameshop.tag5")) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "admintitletag set " + player.getName() + " &dHej randka?");
                        Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie ustawiono tytuł!");
                    } else {
                        Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&cNie masz zakupionego tytułu!");
                    }
                } else if (e.getSlot() == 24) {
                    player.closeInventory();
                    if (player.hasPermission("core.abovenameshop.tag6")) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "admintitletag set " + player.getName() + " &6¯\\_(ツ)_/¯");
                        Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie ustawiono tytuł!");
                    } else {
                        Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&cNie masz zakupionego tytułu!");
                    }
                } else if (e.getSlot() == 25) {
                    player.closeInventory();
                    if (player.hasPermission("core.abovenameshop.tag7")) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "admintitletag set " + player.getName() + " &bIcey zimno tak jak...");
                        Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie ustawiono tytuł!");
                    } else {
                        Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&cNie masz zakupionego tytułu!");
                    }
                } else if (e.getSlot() == 28) {
                    player.closeInventory();
                    if (player.hasPermission("core.abovenameshop.tag8")) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "admintitletag set " + player.getName() + " &4Duel stivku?");
                        Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie ustawiono tytuł!");
                    } else {
                        Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&cNie masz zakupionego tytułu!");
                    }
                } else if (e.getSlot() == 29) {
                    player.closeInventory();
                    if (player.hasPermission("core.abovenameshop.tag9")) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "admintitletag set " + player.getName() + " &dJestem simpem");
                        Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie ustawiono tytuł!");
                    } else {
                        Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&cNie masz zakupionego tytułu!");
                    }
                } else if (e.getSlot() == 30) {
                    player.closeInventory();
                    if (player.hasPermission("core.abovenameshop.tag10")) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "admintitletag set " + player.getName() + " &6Gigachad");
                        Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie ustawiono tytuł!");
                    } else {
                        Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&cNie masz zakupionego tytułu!");
                    }
                } else if (e.getSlot() == 31) {
                    player.closeInventory();
                    if (player.hasPermission("core.abovenameshop.tag11")) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "admintitletag set " + player.getName() + " &5Co tam eziaki?");
                        Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie ustawiono tytuł!");
                    } else {
                        Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&cNie masz zakupionego tytułu!");
                    }
                } else if (e.getSlot() == 32) {
                    player.closeInventory();
                    if (player.hasPermission("core.abovenameshop.tag12")) {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "admintitletag set " + player.getName() + " &cStivek ->");
                        Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie ustawiono tytuł!");
                    } else {
                        Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&cNie masz zakupionego tytułu!");
                    }
                } else if (e.getSlot() == 4) {
                    Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie wyczyściłeś swój tytuł!");
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "admintitletag remove " + player.getName());
                    player.closeInventory();
                } else if (e.getSlot() == 49) {
                    player.closeInventory();
                }

            });

            inventoryHelper.setItem(19, tag_1);
            inventoryHelper.setItem(20, tag_2);
            inventoryHelper.setItem(21, tag_3);
            inventoryHelper.setItem(22, tag_4);
            inventoryHelper.setItem(23, tag_5);
            inventoryHelper.setItem(24, tag_6);
            inventoryHelper.setItem(25, tag_7);

            inventoryHelper.setItem(28, tag_8);
            inventoryHelper.setItem(29, tag_9);
            inventoryHelper.setItem(30, tag_10);
            inventoryHelper.setItem(31, tag_11);
            inventoryHelper.setItem(32, tag_12);
            inventoryHelper.setItem(33, tag_coming);
            inventoryHelper.setItem(34, tag_coming);

            inventoryHelper.setItem(4, tag_info);
            inventoryHelper.setItem(49, back);



            inventoryHelper.open(player);
        }
    }
}
