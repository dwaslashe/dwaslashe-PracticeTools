package xyz.dwaslashe.tools.helpers;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;

/**
 * @Author WuShei
 */
public class InventoryHelper implements Listener {
    public static void implement(JavaPlugin javaPlugin) {
        Bukkit.getPluginManager().registerEvents(new InventoryHelper(), (Plugin)javaPlugin);
    }

    private static final Map<String, InventoryHelper> inventoryHelperMap = new HashMap<>();

    private Inventory inventory;

    private Consumer<InventoryClickEvent> eventConsumer;

    private String title;

    private Player player;

    @EventHandler
    private void onClick(InventoryClickEvent event) {
        if (event.getCurrentItem() == null)
            return;
        InventoryHelper inventoryHelper = inventoryHelperMap.get(event.getWhoClicked().getName());
        if (inventoryHelper == null || inventoryHelper.eventConsumer == null)
            return;
        inventoryHelper.eventConsumer.accept(event);
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        inventoryHelperMap.remove(event.getPlayer().getName());
    }

    private InventoryHelper() {}

    public InventoryHelper(Inventory inventory) {
        this.inventory = inventory;
    }

    public InventoryHelper(Player player, String title, int sizeInRows) {
        this.title = title;
        this.inventory = Bukkit.createInventory((InventoryHolder)player, sizeInRows * 9, org.bukkit.ChatColor.translateAlternateColorCodes('&', title));
        this.player = player;
    }

    public InventoryHelper(String title, int sizeInRows) {
        this((Player)null, title, sizeInRows);
    }

    public InventoryHelper(Player player, String title, InventoryType inventoryType) {
        this.title = title;
        this.inventory = Bukkit.createInventory((InventoryHolder)player, inventoryType, ChatColor.translateAlternateColorCodes('&', title));
        this.player = player;
    }

    public String getTitle() {
        return this.title;
    }

    public Player getPlayer() {
        return this.player;
    }

    public InventoryHelper(String title, InventoryType inventoryType) {
        this((Player)null, title, inventoryType);
    }

    public ItemStack prepareItemStack(Material material, Consumer<ItemStack> consumer) {
        ItemStack itemStack = new ItemStack(material);
        consumer.accept(itemStack);
        return itemStack;
    }

    public void editSkullMetaForItemStack(ItemStack itemStack, Consumer<SkullMeta> consumer) {
        ItemMeta meta = itemStack.getItemMeta();
        consumer.accept((SkullMeta)meta);
        itemStack.setItemMeta(meta);
    }

    public void editMetaForItemStack(ItemStack itemStack, Consumer<ItemMeta> consumer) {
        ItemMeta meta = itemStack.getItemMeta();
        consumer.accept(meta);
        itemStack.setItemMeta(meta);
    }

    public void editSkullMetaWithProperty(ItemStack itemStack, String texture) {
        SkullMeta meta = (SkullMeta)itemStack.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        profile.getProperties().put("textures", new Property("textures", texture));
        ReflectionHelper.setFieldValue(meta, "profile", profile);
        itemStack.setItemMeta((ItemMeta)meta);
    }

    private void checkBounds(int i, int i2) {
        if (i > i2)
            throw new IndexOutOfBoundsException("Int ''from'' cannot be bigger than ''to''.");
    }

    public void setItem(int slot, ItemStack itemStack) {
        this.inventory.setItem(slot, itemStack);
    }

    public void setItem(int slot, Consumer<ItemMeta> metaConsumer, ItemStack itemStack) {
        Objects.requireNonNull(itemStack, "ItemStack cannot be null.");
        ItemMeta meta = itemStack.getItemMeta();
        metaConsumer.accept(meta);
        itemStack.setItemMeta(meta);
        this.inventory.setItem(slot, itemStack);
    }

    public void addItem(ItemStack... itemStacks) {
        this.inventory.addItem(itemStacks);
    }

    public void setItemRange(int from, int to, ItemStack itemStack) {
        checkBounds(0, from);
        checkBounds(from, to);
        checkBounds(to, this.inventory.getSize());
        for (int i = from; i < to; i++)
            this.inventory.setItem(i, itemStack);
    }

    public void setItemRange(int from, int to, Consumer<ItemMeta> metaConsumer, ItemStack itemStack) {
        Objects.requireNonNull(itemStack, "ItemStack cannot be null.");
        ItemMeta meta = itemStack.getItemMeta();
        metaConsumer.accept(meta);
        itemStack.setItemMeta(meta);
        setItemRange(from, to, itemStack);
    }

    public void setItemRangeWithIgnoringOtherItems(int from, int to, Consumer<ItemMeta> metaConsumer, ItemStack itemStack) {
        Objects.requireNonNull(itemStack, "ItemStack cannot be null.");
        ItemMeta meta = itemStack.getItemMeta();
        metaConsumer.accept(meta);
        itemStack.setItemMeta(meta);
        setItemRangeWithIgnoringOtherItems(from, to, itemStack);
    }

    public void setItemRangeWithIgnoringOtherItems(int from, int to, ItemStack itemStack) {
        checkBounds(0, from);
        checkBounds(from, to);
        checkBounds(to, this.inventory.getSize());
        for (int i = from; i < to; i++) {
            ItemStack inventoryStack = this.inventory.getItem(i);
            if (inventoryStack == null || inventoryStack.getType() == Material.AIR)
                this.inventory.setItem(i, itemStack);
        }
    }

    public InventoryHelper editor(Consumer<InventoryHelper> consumer) {
        consumer.accept(this);
        return this;
    }

    public void click(Consumer<InventoryClickEvent> consumer) {
        this.eventConsumer = consumer;
    }

    public void open(Player player){
        this.inventoryHelperMap.remove(player.getName());
        this.inventoryHelperMap.put(player.getName(), this);
        player.openInventory(getInventory());
    }

    public Inventory getInventory() {
        return inventory;
    }
}
