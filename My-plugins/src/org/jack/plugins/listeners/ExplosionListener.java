package org.jack.plugins.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.jack.plugins.Main;

public class ExplosionListener implements Listener {

	@EventHandler
	public void multiplyExplosion(final EntityExplodeEvent e) {

		new BukkitRunnable() {

			@Override
			public void run() {
				for (Block b : e.blockList()) {

					b.setType(Material.LAVA);

				}

			}
		}.runTaskLater(Main.m, 20);

	}

}
