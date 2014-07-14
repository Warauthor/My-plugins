package org.jack.plugins.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Player;

public class SpawnCreeper implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (sender instanceof Player && cmd.getName().equalsIgnoreCase("sc")) {

			Player player = (Player) sender;

			player.getWorld().spawn(player.getLocation().add(0, 0, 10.0), Creeper.class);
			
			Bukkit.broadcastMessage(ChatColor.DARK_GREEN + "A creeper has been spawned");
			
			return true;

		}

		return false;
	}

}
