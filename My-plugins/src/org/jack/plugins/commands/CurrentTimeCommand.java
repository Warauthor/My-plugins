package org.jack.plugins.commands;

import java.util.Date;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CurrentTimeCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (sender instanceof Player
				&& cmd.getName().equalsIgnoreCase("currenttime")) {
			
			Player player = (Player) sender;

			Date date = new Date();

			String d = date.toString();
			
			player.sendMessage(ChatColor.GOLD + "The current date/time is: " + d);

			return true;
		}
		return false;
	}

}
