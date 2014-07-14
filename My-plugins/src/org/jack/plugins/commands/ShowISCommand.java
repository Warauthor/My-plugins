package org.jack.plugins.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShowISCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (sender instanceof Player
				&& cmd.getName().equalsIgnoreCase("iteminfo")) {

			Player player = (Player) sender;

			player.sendMessage("Item: " + player.getItemInHand());
		}
		return false;
	}

}
