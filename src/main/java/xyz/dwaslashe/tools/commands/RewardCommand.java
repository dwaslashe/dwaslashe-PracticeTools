package xyz.dwaslashe.tools.commands;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import xyz.dwaslashe.tools.commands.managers.Command;
import xyz.dwaslashe.tools.helpers.InventoryHelper;
import xyz.dwaslashe.tools.utils.Api;

import java.util.Arrays;
import java.util.List;

public class RewardCommand extends Command implements Listener {
    public RewardCommand() {
        super("rewards", "/rewards", "", "nagroda");
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
            InventoryHelper inventoryHelper = new InventoryHelper(player, "Lista Rang", 3);

            ItemStack glass_black = inventoryHelper.prepareItemStack(Material.STAINED_GLASS_PANE, itemStack -> {
                itemStack.setDurability((short) 15);
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(" ");
                });
            });

            ItemStack mclist = inventoryHelper.prepareItemStack(Material.SKULL_ITEM, itemStack -> {
                itemStack.setDurability((short) 3);
                inventoryHelper.editSkullMetaWithProperty(itemStack, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTZiYjlmYjk3YmE4N2NiNzI3Y2QwZmY0NzdmNzY5MzcwYmVhMTljY2JmYWZiNTgxNjI5Y2Q1NjM5ZjJmZWMyYiJ9fX0=");
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&aNagroda za polubienie McList"));
                    itemMeta.setLore(Api.fixColor(Arrays.asList(
                            " ",
                            " &7Aby dostać nagrodę musisz polubić serwer",
                            " &7na stronie &ehttps://mclist.pl/serwer/pvpplay.pl",
                            " &7pomaga nam to w &a&nrozwoju serwera!",
                            "",
                            " &aZa polubienie dostajesz &610$!",
                            "",
                            " &f&nKliknij aby polubić"
                    )));
                });
            });

            ItemStack discord = inventoryHelper.prepareItemStack(Material.SKULL_ITEM, itemStack -> {
                itemStack.setDurability((short) 3);
                inventoryHelper.editSkullMetaWithProperty(itemStack, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzg3M2MxMmJmZmI1MjUxYTBiODhkNWFlNzVjNzI0N2NiMzlhNzVmZjFhODFjYmU0YzhhMzliMzExZGRlZGEifX19");
                inventoryHelper.editMetaForItemStack(itemStack, itemMeta -> {
                    itemMeta.setDisplayName(Api.fixColor("&9Nagroda za wejście na Discord"));
                    itemMeta.setLore(Api.fixColor(Arrays.asList(
                            " ",
                            " &c&nZa niedługo!"
                    )));
                });
            });

            inventoryHelper.click(e -> {
                e.setCancelled(true);
                if (e.getSlot() == 12) {
                    player.getOpenInventory().close();
                    player.chat("/mclist");
                } else if (e.getSlot() == 14) {
                    player.closeInventory();
                    player.chat("/discord");
                }
            });

                inventoryHelper.setItemRange(0, 27, glass_black);
                inventoryHelper.setItem(12, mclist);
                inventoryHelper.setItem(14, discord);

            inventoryHelper.open(player);
        }
    }
}