package org.jack.plugins.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LocationCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (sender instanceof Player
				&& cmd.getName().equalsIgnoreCase("currentlocation")) {

			Player player = (Player) sender;

			int x = player.getLocation().getBlockX();
			int y = player.getLocation().getBlockY();
			int z = player.getLocation().getBlockZ();

			player.sendMessage("You are: " + "X: " + x + " Y: " + y + " Z: "
					+ z + " World: " + player.getWorld());

		}
		return false;
	}

}
