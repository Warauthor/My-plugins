package org.jack.plugins.mobrider;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class MountListener implements Listener{
	
	@EventHandler
	public void mountMob(PlayerInteractEntityEvent e){
		
		Player p = (Player) e.getPlayer();
		
		Entity m = (Entity) e.getRightClicked();
		
		m.setPassenger(p);
		
		new Mount(p, p.getLocation(), m.getType());
		
	}
}
