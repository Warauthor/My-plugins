package org.jack.plugins.commands;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ExplosionCommand implements CommandExecutor{

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if(sender instanceof Player && cmd.getName().equalsIgnoreCase("explosion")){
			
		Player player = (Player) sender;
		
		Block b = player.getTargetBlock(null, 5);
		Location loc = b.getLocation();
		
		
		player.getWorld().createExplosion(loc, 10);
			
		}
		return false;
	}

}
