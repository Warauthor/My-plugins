package org.jack.plugins.commands;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BlockBelowCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (sender instanceof Player
				&& cmd.getName().equalsIgnoreCase("blockbelow")) {

			Player player = (Player) sender;

			Block currentblock = player.getLocation().getBlock();

			Location belowblock = currentblock.getLocation().subtract(0, 1.00,
					0);

			player.sendMessage("The block below you is: "
					+ belowblock.getBlock().getType());

		}
		return false;
	}

}
