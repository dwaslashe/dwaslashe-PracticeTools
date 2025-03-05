package xyz.dwaslashe.tools.commands;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import xyz.dwaslashe.tools.commands.managers.Command;
import xyz.dwaslashe.tools.helpers.InventoryHelper;
import xyz.dwaslashe.tools.utils.Api;
import xyz.dwaslashe.tools.utils.ChatApi;

import java.util.Arrays;
import java.util.List;

public class RankCommand extends Command implements Listener {
    public RankCommand() {
        super("rangi", "/rangi", "", "vip", "svip", "sigma");
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
            openGui(0, p);
        }
    }

    private void openGui(int guiID, Player player) {
        //0
        if (guiID == 0) {
            InventoryHelper inventoryHelper = new InventoryHelper(player, "Lista Rang", 5);

            ItemStack clock = inventoryHelper.prepareItemStack(Material.COMPASS, itemStack -> {
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&aOTWARCIE TRYBU"));
                    itemMeta.setLore(Api.fixColor(Arrays.asList(" ", " &6⚠ &eData startu&8: &707.03.2025")));
                });
            });

            ItemStack player_info = inventoryHelper.prepareItemStack(Material.SKULL_ITEM, itemStack -> {
                itemStack.setDurability((short) 3);
                inventoryHelper.editSkullMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setOwner(player.getName());
                    itemMeta.setDisplayName(Api.fixColor(ChatApi.getPrefix(player) + "&7" + player.getName()));
                    itemMeta.setLore(Api.fixColor(Arrays.asList("")));
                });
            });

            //VIP

            ItemStack vip_chestplate = inventoryHelper.prepareItemStack(Material.IRON_CHESTPLATE, itemStack -> {
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&eVIP &7" + player.getName()));
                    itemMeta.setLore(Api.fixColor(Arrays.asList(
                            " ",
                            " &7Cena usługi&8: &b10 zł",
                            " &7Czas trwania &d30 dni!",
                            "",
                            " &eKomendy rangi VIP:",
                            "",
                            " &8>> &f/particlesy &8- &7Particlesy gdy chodzisz",
                            "",
                            " &a&nKliknij prawym żeby podejrzeć link!"
                    )));
                });
            });

            ItemStack vip_leggings = inventoryHelper.prepareItemStack(Material.IRON_LEGGINGS, itemStack -> {
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&eVIP &7" + player.getName()));
                    itemMeta.setLore(Api.fixColor(Arrays.asList(
                            "",
                            " &ePrzywileje rangi VIP:",
                            "",
                            " &8>> &7Unikatowy prefix &eVIP",
                            " &8>> &7Wejście na &apelen &7serwer",
                            " &8>> &7Wszystkie &e&lefekty &7zabójstwa",
                            " &8>> &7Wiadomość jak wchodisz na serwer",
                            "",
                            " &a&nKliknij prawym żeby podejrzeć link!"
                    )));
                });
            });

            ItemStack vip_boots = inventoryHelper.prepareItemStack(Material.IRON_BOOTS, itemStack -> {
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&aKliknij po link!"));
                });
            });

            //SVIP

            ItemStack svip_chestplate = inventoryHelper.prepareItemStack(Material.GOLD_CHESTPLATE, itemStack -> {
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&bSVIP &7" + player.getName()));
                    itemMeta.setLore(Api.fixColor(Arrays.asList(
                            "",
                            " &7Cena usługi&8: &b20 zł",
                            " &7Czas trwania &d30 dni!",
                            "",
                            " &eKomendy rangi SVIP:",
                            "",
                            " &8>> &f/particlesy &8- &7Particlesy gdy chodzisz",
                            "",
                            " &a&nKliknij prawym żeby podejrzeć link!"
                    )));
                });
            });

            ItemStack svip_leggings = inventoryHelper.prepareItemStack(Material.GOLD_LEGGINGS, itemStack -> {
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&bSVIP &7" + player.getName()));
                    itemMeta.setLore(Api.fixColor(Arrays.asList(
                            "",
                            " &ePrzywileje rangi SVIP:",
                            "",
                            " &8>> &7Unikatowy prefix &bSVIP",
                            " &8>> &7Wejście na &apelen &7serwer",
                            " &8>> &7Wszystkie &e&lefekty &7zabójstwa",
                            " &8>> &7Wiadomość jak wchodisz na serwer",
                            " &8>> &7Tworzenie eventu &e,,turniej\"",
                            " &8>> &7Możliwość latania po spawnie",
                            " &8>> &7Możliwość tworzenia customowego bota",
                            "",
                            " &a&nKliknij prawym żeby podejrzeć link!"
                    )));
                });
            });

            ItemStack svip_boots = inventoryHelper.prepareItemStack(Material.GOLD_BOOTS, itemStack -> {
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&aKliknij po link!"));
                });
            });

            //SIGMA

            ItemStack sigma_chestplate = inventoryHelper.prepareItemStack(Material.DIAMOND_CHESTPLATE, itemStack -> {
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&d&lSIGMA &f" + player.getName()));
                    itemMeta.setLore(Api.fixColor(Arrays.asList(
                            "",
                            " &7Cena usługi&8: &b35 zł",
                            " &7Czas trwania &d30 dni!",
                            "",
                            " &eKomendy rangi SIGMA:",
                            "",
                            " &8>> &f/particlesy &8- &7Particlesy gdy chodzisz",
                            " &8>> &f/party announce &8- &7Możliwość ogłoszenia publicznego party",
                            "",
                            " &a&nKliknij prawym żeby podejrzeć link!"
                    )));
                });
            });

            ItemStack sigma_leggings = inventoryHelper.prepareItemStack(Material.DIAMOND_LEGGINGS, itemStack -> {
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&d&lSIGMA &f" + player.getName()));
                    itemMeta.setLore(Api.fixColor(Arrays.asList(
                            "",
                            " &ePrzywileje rangi SIGMA:",
                            "",
                            " &8>> &7Unikatowy prefix &d&lSIGMA",
                            " &8>> &7Wejście na &apelen &7serwer",
                            " &8>> &7Wszystkie &e&lefekty &7zabójstwa",
                            " &8>> &7Wiadomość jak wchodisz na serwer",
                            " &8>> &7Tworzenie eventu &e,,turniej\"",
                            " &8>> &7Możliwość latania po spawnie",
                            " &8>> &7Możliwość tworzenia customowego bota",
                            " &8>> &7Możliwość zwiększenia limitu party",
                            " &8>> &7Możliwość ogłoszenia publicznego party",
                            " &8>> &7Wszystkie ślady pocisków",
                            " &8>> &7Dostęp do wszystkich tytułów",
                            "",
                            "",
                            " &a&nKliknij prawym żeby podejrzeć link!"
                    )));
                });
            });

            ItemStack sigma_boots = inventoryHelper.prepareItemStack(Material.DIAMOND_BOOTS, itemStack -> {
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&aKliknij po link!"));
                });
            });

            inventoryHelper.click(e -> {
                e.setCancelled(true);
                if (e.getSlot() == 31) {
                    player.getOpenInventory().close();
                    player.chat("/website");
                } else if (e.getSlot() == 32) {
                    player.closeInventory();
                    player.chat("/website");
                } else if (e.getSlot() == 33) {
                    player.closeInventory();
                    player.chat("/website");
                }
            });

            inventoryHelper.setItem(11, player_info);

            inventoryHelper.setItem(13, vip_chestplate);
            inventoryHelper.setItem(14, svip_chestplate);
            inventoryHelper.setItem(15, sigma_chestplate);

            inventoryHelper.setItem(20, clock);

            inventoryHelper.setItem(22, vip_leggings);
            inventoryHelper.setItem(23, svip_leggings);
            inventoryHelper.setItem(24, sigma_leggings);

            inventoryHelper.setItem(31, vip_boots);
            inventoryHelper.setItem(32, svip_boots);
            inventoryHelper.setItem(33, sigma_boots);

            inventoryHelper.open(player);
        }
    }
}
