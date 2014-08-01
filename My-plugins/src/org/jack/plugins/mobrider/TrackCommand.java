package org.jack.plugins.mobrider;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TrackCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (sender instanceof Player && cmd.getName().equalsIgnoreCase("track")) {

			Player player = (Player) sender;

			Player target = null;

			String name = "";

			if (args[0].length() > 0) {

				name = args[0];
			}

			Mount mount = (Mount) player.getVehicle();

			target = Bukkit.getPlayer(name);
			mount.trackPlayer(target);
		}

		return false;
	}

}
