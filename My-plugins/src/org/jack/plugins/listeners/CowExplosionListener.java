package org.jack.plugins.listeners;


import org.bukkit.entity.Cow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class CowExplosionListener implements Listener {

	@EventHandler
	public void cowExplode(CreatureSpawnEvent e) {

		if (e.getEntity() instanceof Cow) {

			
			e.getEntity().getWorld()
					.createExplosion(e.getEntity().getLocation().add(0, 0, 30.0), (float) 20.0);
			
		}

	}

}
