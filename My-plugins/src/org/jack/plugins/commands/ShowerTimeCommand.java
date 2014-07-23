package org.jack.plugins.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.jack.plugins.Main;

public class ShowerTimeCommand implements CommandExecutor {
	
	private BukkitTask br;

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (sender instanceof Player
				&& cmd.getName().equalsIgnoreCase("showertime")) {

			final Player player = (Player) sender;
			final long seconds = Long.parseLong(args[0]) * 1000;
			final long time = System.currentTimeMillis();
			int itemID = Integer.parseInt(args[1]);
			final ItemStack items = new ItemStack(itemID);

	
			this.br = new BukkitRunnable(){
				
				public void run() {
					
					if(System.currentTimeMillis() < time + seconds){
					
					player.getWorld().dropItem(
							player.getLocation().add(0, 10.0, 0), items);
				}
					else{
						
						br.cancel();
					}

			}
			}.runTaskTimer(Main.m, 10, 20);
	}
		return false;
}
}