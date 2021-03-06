package net.acticraft.actiextension.Guis;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.awt.*;
import java.util.ArrayList;

import static org.bukkit.Material.*;

public class HelpGui implements CommandExecutor , Listener {

    // GUI Create
    public static Inventory HelpGUIMeunu = Bukkit.createInventory(null, 9, ChatColor.of(new Color(61, 210, 255))+"Help Gui");

    public static void SetHelpGui(){

        // SetItems
        ItemStack info = new ItemStack(BOOK);
        ItemStack feed = new ItemStack(Material.CAKE);
        ItemStack sword = new ItemStack(Material.IRON_SWORD);

        ItemMeta info_meta = info.getItemMeta();
        info_meta.setDisplayName(ChatColor.of(new Color(255, 61, 61))+"WhiteList");
        ArrayList<String> suicide_lore = new ArrayList<>();
        suicide_lore.add(ChatColor.of(new Color(153, 4, 56))+"Turn it on!");
        info_meta.setLore(suicide_lore);
        info.setItemMeta(info_meta);

        ItemStack[] menu_items = {info, feed, sword};
        HelpGUIMeunu.setContents(menu_items);
    }

    // Open Gui Command
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            ((Player) sender).getPlayer().openInventory(HelpGUIMeunu);
        }

        return false;

    }

    @EventHandler
    public void HelpMenuAction(InventoryClickEvent event) {
        if(event.getView().getTitle().equalsIgnoreCase(ChatColor.of(new Color(61, 210, 255))+"Help Gui") && event.getCurrentItem() != null) {
            event.getWhoClicked().closeInventory();
            if (event.getCurrentItem().getType() == Material.BOOK) {
                if (event.getClick().equals(ClickType.RIGHT)) {
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    Bukkit.setWhitelist(true);
                }
            }
                System.out.println(event.getView().getTitle().toString());
                if (event.getView().getTitle().equalsIgnoreCase(ChatColor.of(new Color(61, 210, 255)) + "Help Gui")) {

                    // item


            event.setCancelled(true);

                }

            }

    }
}