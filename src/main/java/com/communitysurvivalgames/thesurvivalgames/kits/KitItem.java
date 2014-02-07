package com.communitysurvivalgames.thesurvivalgames.kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitItem {
	private ItemStack item;
	private ItemMeta itemMeta;

	public KitItem() {
	}

	public KitItem(Material type) {
		item = new ItemStack(type);
		itemMeta = item.getItemMeta();
	}

	public ItemStack getItem() {
		return item;
	}

	public void addEnchantment(Enchantment e, int level) {
		itemMeta.addEnchant(e, level, true);
		item.setItemMeta(itemMeta);
	}

	public void addEnchantment(Enchantment e) {
		itemMeta.addEnchant(e, 1, true);
		item.setItemMeta(itemMeta);
	}

	public void addEnchantment(String e, int level) {
		itemMeta.addEnchant(Enchantment.getByName(e), level, true);
		item.setItemMeta(itemMeta);
	}

	public void addEnchantment(String e) {
		itemMeta.addEnchant(Enchantment.getByName(e), 1, true);
		item.setItemMeta(itemMeta);
	}

	public void setLore(String s) {
		List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.translateAlternateColorCodes('&', s));
		itemMeta.setLore(lore);
		item.setItemMeta(itemMeta);
	}

	public void setLore(List<String> s) {
		List<String> lore = new ArrayList<String>();
		for (String string : s)
			lore.add(ChatColor.translateAlternateColorCodes('&', string));
		itemMeta.setLore(lore);
		item.setItemMeta(itemMeta);
	}

	public void setDisplayName(String s) {
		itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', s));
		item.setItemMeta(itemMeta);
	}

	public void setItem(ItemStack item) {
		this.item = item;
	}
}
