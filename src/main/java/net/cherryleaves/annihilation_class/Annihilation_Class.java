package net.cherryleaves.annihilation_class;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Annihilation_Class extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "※ このプラグインを入れるとネザーに入れなくなります");
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        Bukkit.getServer().getPluginManager().registerEvents(new NetherGate_Class(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new System_Class(), this);
        super.onEnable();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        super.onDisable();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("class")) {
            new NetherGate_Class().SetClassItem();
            Player p =(Player) sender;
            p.openInventory(new NetherGate_Class().ClassGUI);
        }
        return false;
    }
}
