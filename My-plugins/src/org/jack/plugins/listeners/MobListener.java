package org.jack.plugins.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class MobListener implements Listener {

	@EventHandler
	public void mobIdentify(EntityDeathEvent e) {

		if (e.getEntity().getKiller() instanceof Player) {

			Player player = (Player) e.getEntity().getKiller();

			player.sendMessage("You killed " + e.getEntity().getType());

		}

	}

}
