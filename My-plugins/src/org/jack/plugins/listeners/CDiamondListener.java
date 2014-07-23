package org.jack.plugins.listeners;


import org.bukkit.Material;
import org.bukkit.entity.Creeper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.ItemStack;

public class CDiamondListener implements Listener {

	@EventHandler
	public void diamondSpawn(EntityExplodeEvent e) {

		if (e.getEntity() instanceof Creeper){
			
			Creeper c = (Creeper) e.getEntity();
			ItemStack item = new ItemStack(Material.DIAMOND, 1);
			c.getWorld().dropItem(c.getLocation(), item);

		}

	}

}
