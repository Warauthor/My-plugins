package org.jack.plugins.commands;


import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Player;

public class SpawnCreeper implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (sender instanceof Player && cmd.getName().equalsIgnoreCase("sc")) {

			Player player = (Player) sender;
			
			Block b = player.getTargetBlock(null, 5);
			Location loc = b.getLocation();
			
			player.getWorld().spawn(loc, Creeper.class);
			
			return true;

		}

		return false;
	}

}
