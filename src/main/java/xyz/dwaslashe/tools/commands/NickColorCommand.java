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

public class NickColorCommand extends Command implements Listener {
    public NickColorCommand() {
        super("nickcolor", "/nickcolor", "", "kolornick", "colornick", "nickkolor", "kolor", "color");
        setPermission("core.command.nickcolor");
        setOnlyPlayer(true);
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
            InventoryHelper inventoryHelper = new InventoryHelper(player, "Kolor nicku", 6);

            ItemStack head = inventoryHelper.prepareItemStack(Material.SKULL_ITEM, itemStack -> {
                itemStack.setDurability((short) 3);
                inventoryHelper.editSkullMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setOwner(player.getName());
                    itemMeta.setDisplayName(Api.fixColor("&eInformacje"));
                    itemMeta.setLore(Api.fixColor(Arrays.asList("", " &7Wybierz kolor, który byś chciał", " &7żeby widniał nad twoim nickiem")));
                });
            });

            ItemStack back = inventoryHelper.prepareItemStack(Material.BARRIER, itemStack -> {
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&cWróć"));
                });
            });

            ItemStack orange = inventoryHelper.prepareItemStack(Material.INK_SACK, itemStack -> {
                itemStack.setDurability((short) 14);
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&6" + player.getName()));
                    itemMeta.setLore(Api.fixColor(Arrays.asList("", " &f&nKliknij aby zmienić kolor nicku!")));
                });
            });

            ItemStack yellow = inventoryHelper.prepareItemStack(Material.INK_SACK, itemStack -> {
                itemStack.setDurability((short) 11);
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&e" + player.getName()));
                    itemMeta.setLore(Api.fixColor(Arrays.asList("", " &f&nKliknij aby zmienić kolor nicku!")));
                });
            });

            ItemStack green = inventoryHelper.prepareItemStack(Material.INK_SACK, itemStack -> {
                itemStack.setDurability((short) 10);
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&a" + player.getName()));
                    itemMeta.setLore(Api.fixColor(Arrays.asList("", " &f&nKliknij aby zmienić kolor nicku!")));
                });
            });

            ItemStack dark_green = inventoryHelper.prepareItemStack(Material.INK_SACK, itemStack -> {
                itemStack.setDurability((short) 2);
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&2" + player.getName()));
                    itemMeta.setLore(Api.fixColor(Arrays.asList("", " &f&nKliknij aby zmienić kolor nicku!")));
                });
            });

            ItemStack white = inventoryHelper.prepareItemStack(Material.INK_SACK, itemStack -> {
                itemStack.setDurability((short) 15);
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&f" + player.getName()));
                    itemMeta.setLore(Api.fixColor(Arrays.asList("", " &f&nKliknij aby zmienić kolor nicku!")));
                });
            });

            ItemStack gray = inventoryHelper.prepareItemStack(Material.INK_SACK, itemStack -> {
                itemStack.setDurability((short) 8);
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&7" + player.getName()));
                    itemMeta.setLore(Api.fixColor(Arrays.asList("", " &f&nKliknij aby zmienić kolor nicku!")));
                });
            });

            ItemStack light_blue = inventoryHelper.prepareItemStack(Material.INK_SACK, itemStack -> {
                itemStack.setDurability((short) 12);
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&7" + player.getName()));
                    itemMeta.setLore(Api.fixColor(Arrays.asList("", " &f&nKliknij aby zmienić kolor nicku!")));
                });
            });

            ItemStack blue = inventoryHelper.prepareItemStack(Material.INK_SACK, itemStack -> {
                itemStack.setDurability((short) 4);
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&9" + player.getName()));
                    itemMeta.setLore(Api.fixColor(Arrays.asList("", " &f&nKliknij aby zmienić kolor nicku!")));
                });
            });

            ItemStack pink = inventoryHelper.prepareItemStack(Material.INK_SACK, itemStack -> {
                itemStack.setDurability((short) 9);
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&d" + player.getName()));
                    itemMeta.setLore(Api.fixColor(Arrays.asList("", " &f&nKliknij aby zmienić kolor nicku!")));
                });
            });

            ItemStack purple = inventoryHelper.prepareItemStack(Material.INK_SACK, itemStack -> {
                itemStack.setDurability((short) 5);
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&5" + player.getName()));
                    itemMeta.setLore(Api.fixColor(Arrays.asList("", " &f&nKliknij aby zmienić kolor nicku!")));
                });
            });

            inventoryHelper.click(e -> {
                e.setCancelled(true);
                if (e.getSlot() == 19) {
                    player.getOpenInventory().close();
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "adminnick " + player.getName() + " &6" + player.getName());
                    Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie zmieniłeś nick na &e" + player.getDisplayName());
                } else if (e.getSlot() == 20) {
                    player.getOpenInventory().close();
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "adminnick " + player.getName() + " &e" + player.getName());
                    Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie zmieniłeś nick na &e" + player.getDisplayName());
                } else if (e.getSlot() == 21) {
                    player.getOpenInventory().close();
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "adminnick " + player.getName() + " &a" + player.getName());
                    Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie zmieniłeś nick na &e" + player.getDisplayName());
                } else if (e.getSlot() == 22) {
                    player.getOpenInventory().close();
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "adminnick " + player.getName() + " &2" + player.getName());
                    Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie zmieniłeś nick na &e" + player.getDisplayName());
                } else if (e.getSlot() == 23) {
                    player.getOpenInventory().close();
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "adminnick " + player.getName() + " &f" + player.getName());
                    Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie zmieniłeś nick na &e" + player.getDisplayName());
                } else if (e.getSlot() == 24) {
                    player.getOpenInventory().close();
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "adminnick " + player.getName() + " &7" + player.getName());
                    Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie zmieniłeś nick na &e" + player.getDisplayName());
                } else if (e.getSlot() == 25) {
                    player.getOpenInventory().close();
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "adminnick " + player.getName() + " &b" + player.getName());
                    Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie zmieniłeś nick na &e" + player.getDisplayName());
                } else if (e.getSlot() == 30) {
                    player.getOpenInventory().close();
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "adminnick " + player.getName() + " &9" + player.getName());
                    Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie zmieniłeś nick na &e" + player.getDisplayName());
                } else if (e.getSlot() == 31) {
                    player.getOpenInventory().close();
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "adminnick " + player.getName() + " &d" + player.getName());
                    Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie zmieniłeś nick na &e" + player.getDisplayName());
                } else if (e.getSlot() == 32) {
                    player.getOpenInventory().close();
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "adminnick " + player.getName() + " &5" + player.getName());
                    Api.sendMessage(player, Main.pluginConfig.getMessages().getPrefix() + "&aPomyślnie zmieniłeś nick na &e" + player.getDisplayName());
                } else if (e.getSlot() == 49) {
                    player.closeInventory();
                }
            });

            inventoryHelper.setItem(4, head);

            inventoryHelper.setItem(19, orange);
            inventoryHelper.setItem(20, yellow);
            inventoryHelper.setItem(21, green);
            inventoryHelper.setItem(22, dark_green);
            inventoryHelper.setItem(23, white);
            inventoryHelper.setItem(24, gray);
            inventoryHelper.setItem(25, light_blue);

            inventoryHelper.setItem(30, blue);
            inventoryHelper.setItem(31, pink);
            inventoryHelper.setItem(32, purple);

            inventoryHelper.setItem(49, back);

            inventoryHelper.open(player);
        }
    }
}
