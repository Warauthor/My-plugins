package org.jack.plugins.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ExplosionCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if(sender instanceof Player && cmd.getName().equalsIgnoreCase("explosion")){
			
		Player player = (Player) sender;
		
		player.getWorld().createExplosion(player.getLocation().add(0, 0, 15.0), 10);
			
		}
		return false;
	}

}
