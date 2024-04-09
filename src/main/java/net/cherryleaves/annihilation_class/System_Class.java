package net.cherryleaves.annihilation_class;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scoreboard.Scoreboard;

import java.util.Objects;

public class System_Class implements Listener {

    @EventHandler
    public void PlayerDeathEvent(PlayerDeathEvent event){
        Player p = event.getEntity().getPlayer();
        String PlayerHasTag = String.valueOf(Objects.requireNonNull(p).getScoreboardTags());
        p.getInventory().clear();
        switch (PlayerHasTag) {
            case "Miner":
                StartArmorMiner();
            case "Enchanter":
                StartArmorEnchanter();
        }
    }

    public void StartArmorMiner(){
    }

    public void StartArmorEnchanter(){
    }

    public void Miner(){
    }
}
