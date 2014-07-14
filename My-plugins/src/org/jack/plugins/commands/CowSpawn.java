package org.jack.plugins.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Player;

public class CowSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (sender instanceof Player
				&& cmd.getName().equalsIgnoreCase("cowspawn")) {

			Player player = (Player) sender;

			player.getWorld().spawn(player.getLocation(), Cow.class);
			
			Bukkit.broadcastMessage(ChatColor.AQUA + "A cow has been spawned!");

		}
		return false;
	}

}
