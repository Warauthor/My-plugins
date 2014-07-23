package org.jack.plugins.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class MobMountCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (sender instanceof Player && cmd.getName().equalsIgnoreCase("mm")) {
			Player player = (Player) sender;

			String mobname = args[0].toString();
			

			LivingEntity e = (LivingEntity) player.getWorld().spawnEntity(player.getLocation(),
					EntityType.fromName(mobname));

			if (e != null) {

				e.setPassenger(player);

			}
			else{
				player.sendMessage("The entity you specified was null");
				
			}
		}

		return false;
	}
}
