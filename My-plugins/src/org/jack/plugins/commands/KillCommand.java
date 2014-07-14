package org.jack.plugins.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class KillCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender instanceof Player && cmd.getName().equalsIgnoreCase("kill")) {
			
			
			if(sender.hasPermission("HcRaid.Kill.Your.Self")){
				
				// do shit...
				
			}
			
			Player player = (Player) sender;
			player.setHealth(0);
			Bukkit.broadcastMessage(ChatColor.DARK_RED + player.getName() + " killed themselves");
			return true;
		}
		Bukkit.broadcastMessage(ChatColor.BLUE + "Kill command was not activated");
		return false;
	}
}
