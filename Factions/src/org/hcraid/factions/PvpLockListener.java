package org.hcraid.factions;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class PvpLockListener implements Listener{
	
	
	@EventHandler
	public void locationLock(PlayerMoveEvent e){
		
		Player player = (Player) e.getPlayer();

		if(Main.combatApi != null && Main.combatApi.isInCombat(player)){
			
			Location loc = player.getLocation();
	
			boolean inRegion = false;		
			
			exit:
			
			for(ProtectedRegion pr : Main.worldguardplugin.getRegionManager(loc.getWorld()).getRegions().values()){
				
				for(String id : Main.regions){
					
					if(pr.getId().equalsIgnoreCase(id) && 
							pr.contains(loc.getBlockX(), 
									loc.getBlockY(), loc.getBlockZ())){
						inRegion = true;
						break exit;
					}
					
				}
				
			}
			
			if(inRegion){
				
				Vector v = player.getVelocity();
				
				double x = v.getX();
				double y = v.getY();
				double z = v.getZ();
				
				Vector force = new Vector(x*-1, y*-1, z*-1);
				
				for(int i = 0; i < 3; i++){
					force.add(force);
				}
				
				player.setVelocity(force);
							
				player.sendMessage(ChatColor.RED + "You can't enter this zone whilst in combat!");
			}

			
			
			
		}
		
		
	}

}
