package org.jack.plugins.commands;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (sender instanceof Player && cmd.getName().equalsIgnoreCase("Teleport")) {

			Player player = (Player) sender;
			
			double x = new Random().nextDouble();
			double y = new Random().nextDouble();
			double z = new Random().nextDouble();
			
			Location l = new Location(player.getWorld(), x, y, z);
			
			player.teleport(l);
			player.sendMessage(ChatColor.DARK_RED + "You have been teleported");
			
			return true;
		}
		return false;
	}

}
