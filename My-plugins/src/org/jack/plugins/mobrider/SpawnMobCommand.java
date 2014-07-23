package org.jack.plugins.mobrider;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class SpawnMobCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (sender instanceof Player && cmd.getName().equalsIgnoreCase("sm")) {

			Player p = (Player) sender;

			String mobname = args[0].toString();

			new Mount(p, p.getLocation(), EntityType.fromName(mobname));

		}

		return false;
	}
}
