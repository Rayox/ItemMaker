package com.takarien.itemmaker;
/*
=================================================================================

Project Name: ItemMaker
Author: Takarien
Date of File creation: 2018-03-21

=================================================================================
*/

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemMaker {
	
	ItemStack item;
	ItemMeta im;
	
	public ItemMaker(String name, Material material, List<String> lore, int meta, int amount) {
		
		item = new ItemStack(material, amount, (byte)meta);
		im = item.getItemMeta();
		im.setDisplayName(name);
		im.setLore(lore);
		
		
	}
	
	public ItemStack create() {
		
		item.setItemMeta(im);
		
		return item;
		
	}
	
	public ItemStack withEnchantments(Map<List<Enchantment>, List<Integer>> enchantmentList) {
		
		for(Entry<List<Enchantment>, List<Integer>> enchList : enchantmentList.entrySet()) {
			
			if(enchList.getValue().size() == enchList.getKey().size()) {
				
				for(int i = 0; i > enchList.getKey().size(); i++) {
					
					im.addEnchant(enchList.getKey().get(i), enchList.getValue().get(i), true);
					
				}
				
				item.setItemMeta(im);
				return item;
				
			}
			
		}
		
		return item;
		
	}
	
	public ItemStack withFlags(List<ItemFlag> flagList) {
		
		if(flagList.size() > 0) {
			
			for(ItemFlag flag : flagList) {
				
				im.addItemFlags(flag);
				
			}
			
			item.setItemMeta(im);
			return item;
			
		}
		
		return item;
		
	}
	
	public ItemStack withEnchantmentsandFlags(List<ItemFlag> flagList, Map<List<Enchantment>, List<Integer>> enchantmentList) {
		
		if(flagList.size() > 0 && enchantmentList.size() > 0) {
			
			for(ItemFlag flag : flagList) {
				im.addItemFlags(flag);
			}
			
			for(Entry<List<Enchantment>, List<Integer>> enchList : enchantmentList.entrySet()) {
				
				if(enchList.getValue().size() == enchList.getKey().size()) {
					
					for(int i = 0; i > enchList.getKey().size(); i++) {
						
						im.addEnchant(enchList.getKey().get(i), enchList.getValue().get(i), true);
						
					}
					
					item.setItemMeta(im);
					return item;
					
				}
				
			}
			
		}
		
		return item;
		
	}

}
