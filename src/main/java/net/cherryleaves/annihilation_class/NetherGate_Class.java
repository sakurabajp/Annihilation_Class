package net.cherryleaves.annihilation_class;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class NetherGate_Class implements Listener {

    Inventory ClassGUI = Bukkit.createInventory(null,9, ChatColor.AQUA + "クラスを選択");

    @EventHandler
    public void ClassChange(PlayerPortalEvent event){
        Player p = event.getPlayer();
        if(p.isSneaking()){
            event.setCancelled(true);
            SetClassItem();
            p.openInventory(ClassGUI);
        }
    }

    public void SetClassItem(){
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
}

