package xyz.dwaslashe.tools.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.MaterialData;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Item {
    private ItemStack itemStack;

    public Item(Material material){
        this.itemStack = new ItemStack(material);
    }
    public Item(Material material, int amount){
        this.itemStack = new ItemStack(material, amount);
    }
    public Item(Material material, int amount, short durability){
        this.itemStack = new ItemStack(material, amount, durability);
    }
    public Item(Material material, short data){
        this.itemStack = new ItemStack(material, 1, data);
    }
    public Item(ItemStack itemStack) {
        this.itemStack = itemStack.clone();
    }
    public Item(ItemStack itemStack, int amount){
        ItemStack is = itemStack.clone();
        is.setAmount(amount);
        this.itemStack = is;
    }
    public Item(ItemStack itemStack, short data){
        this.itemStack = itemStack.clone();
        this.itemStack.setDurability(data);
    }

    public Item(ItemStack itemStack, int amount, short durability){
        ItemStack is = itemStack.clone();
        is.setAmount(amount);
        is.setAmount(amount);
        is.setDurability(durability);
        this.itemStack = new ItemStack(is);
    }
    public Item setName(String name){
        ItemMeta meta = this.itemStack.getItemMeta();
        meta.setDisplayName(Api.fixColor(name));
        this.itemStack.setItemMeta(meta);
        return this;
    }
    public Item setColor(Color color){
        LeatherArmorMeta meta = (LeatherArmorMeta)itemStack.getItemMeta();
        meta.setColor(color);
        itemStack.setItemMeta(meta);
        return this;
    }
    public Item setLore(List<String> lore){
        ItemMeta meta = this.itemStack.getItemMeta();
        meta.setLore(Api.fixColor(lore));
        this.itemStack.setItemMeta(meta);
        return this;
    }
    public Item addItemFlag(ItemFlag flag){
        ItemMeta meta = this.itemStack.getItemMeta();
        meta.addItemFlags(flag);
        this.itemStack.setItemMeta(meta);
        return this;
    }
    public Item setLeatherArmorColor(Color color){
        LeatherArmorMeta meta = (LeatherArmorMeta) this.itemStack.getItemMeta();
        meta.setColor(color);
        this.itemStack.setItemMeta(meta);
        return this;
    }
    public Item setUnbreakable(boolean enable){
        ItemMeta meta = this.itemStack.getItemMeta();
        meta.spigot().setUnbreakable(enable);
        this.itemStack.setItemMeta(meta);
        return this;
    }
    public Item addLore(String lore){
        List<String> line = new ArrayList();
        ItemMeta meta = this.itemStack.getItemMeta();
        if(meta.hasLore()){
            line = new ArrayList(meta.getLore());
        }
        line.add(Api.fixColor(lore));
        meta.setLore(line);
        this.itemStack.setItemMeta(meta);
        return this;
    }
    public List<String> getLore(){
        ItemMeta meta = this.itemStack.getItemMeta();
        return meta.getLore();
    }
    public Item clearLore(){
        ItemMeta meta = this.itemStack.getItemMeta();
        meta.setLore(new ArrayList());
        this.itemStack.setItemMeta(meta);
        return this;
    }
    public Item setOwner(String owner){
        SkullMeta meta = (SkullMeta)itemStack.getItemMeta();
        meta.setOwner(owner);
        itemStack.setItemMeta(meta);
        return this;
    }
    public Item setOwnerURL(String url){
        SkullMeta meta = (SkullMeta) this.itemStack.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);

        profile.getProperties().put("textures", new Property("textures", url));

        try
        {
            Field profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);

        }
        catch (IllegalArgumentException|NoSuchFieldException|SecurityException | IllegalAccessException error)
        {
            error.printStackTrace();
        }
        this.itemStack.setItemMeta(meta);
        return this;
    }
    public String getOwner(){
        SkullMeta meta = (SkullMeta) this.itemStack.getItemMeta();
        return meta.getOwner();
    }
    public Item addEnchant(Enchantment enchantment, int level){
        ItemMeta meta = this.itemStack.getItemMeta();
        meta.addEnchant(enchantment, level, true);
        this.itemStack.setItemMeta(meta);
        return this;
    }
    public Item removeEnchant(Enchantment enchantment){
        this.itemStack.removeEnchantment(enchantment);
        return this;
    }
    public Item setAmount(int amount){
        this.itemStack.setAmount(amount);
        return this;
    }
    public Item setDurability(int durability){
        this.itemStack.setDurability((short)durability);
        return this;
    }
    public ItemStack getItemStack() {
        return itemStack;
    }
    public MaterialData getMaterialData(){
        return itemStack.getData();
    }
}
