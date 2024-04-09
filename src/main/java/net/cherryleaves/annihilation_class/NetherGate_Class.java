package net.cherryleaves.annihilation_class;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;
import java.util.Set;

public class NetherGate_Class implements Listener {

    Inventory ClassGUI = Bukkit.createInventory(null,9, ChatColor.AQUA + "クラスを選択");

    /*@EventHandler
    public void ClassChange(PlayerPortalEvent event) {
        Player p = event.getPlayer();
        event.setCancelled(true);
        Location l = p.getLocation();
        Location tl = l.clone().add(l.getDirection().multiply(3));
        p.teleport(tl);
        SetClassItem();
        p.openInventory(ClassGUI);
    }*/

    public void SetClassItem(){
        ClassGUI.clear();
        ItemStack MinerItem = new ItemStack(Material.STONE_PICKAXE);
        ItemMeta MinerItemMeta = MinerItem.getItemMeta();
        Objects.requireNonNull(MinerItemMeta).setDisplayName(ChatColor.LIGHT_PURPLE + "マイナー");
        MinerItem.setItemMeta(MinerItemMeta);
        ClassGUI.addItem(MinerItem);
        ItemStack AcrobatItem = new ItemStack(Material.FEATHER);
        ItemMeta AcrobatItemMeta = AcrobatItem.getItemMeta();
        Objects.requireNonNull(AcrobatItemMeta).setDisplayName(ChatColor.LIGHT_PURPLE + "アクロバット");
        ClassGUI.addItem(AcrobatItem);
    }

    @EventHandler
    public void InventoryClick(InventoryClickEvent event){
        Player p = (Player) event.getWhoClicked();
        if (event.getWhoClicked() instanceof Player) {
            // クリックされたGUIを取得する
            Inventory clickedInventory = event.getClickedInventory();
            if (clickedInventory == ClassGUI) {
                // クリックされたアイテムを取得する
                ItemStack clickedItem = event.getCurrentItem();
                if (clickedItem != null && clickedItem.getType() == Material.STONE_PICKAXE) {
                    p.addScoreboardTag("Miner");
                }
            }
        }
    }
}

