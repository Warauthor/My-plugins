package org.jack.plugins.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class DropItemCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (sender instanceof Player
				&& cmd.getName().equalsIgnoreCase("shower") && args != null){

			Player player = (Player) sender;
			
			int itemID = Integer.parseInt(args[0]);
			int stackSize = Integer.parseInt(args[1]);
						
			ItemStack items = new ItemStack(itemID, stackSize);
			
			player.getWorld().dropItem(player.getLocation(), items);
			player.sendMessage("You spawned " + items.getType() + " Amount: " + items.getAmount());
		}

		return false;
	}

}
