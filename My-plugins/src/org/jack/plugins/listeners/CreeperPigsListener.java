package org.jack.plugins.listeners;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Pig;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class CreeperPigsListener implements Listener {

	@EventHandler
	public void creeperSpawn(CreatureSpawnEvent e) {

		if (e.getEntity() instanceof Creeper) {

			Entity c = e.getEntity();
			
			Entity pig = c.getWorld().spawn(c.getLocation(), Pig.class);
			
			pig.setPassenger(c);

		}

	}
}
