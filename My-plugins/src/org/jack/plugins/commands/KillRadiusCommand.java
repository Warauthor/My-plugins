package org.jack.plugins.commands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class KillRadiusCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (sender instanceof Player
				&& cmd.getName().equalsIgnoreCase("killradius") && args != null) {

			Player player = (Player) sender;
			
			double radius = Double.parseDouble(args[0]);

			for (Entity e : player.getNearbyEntities(radius, radius, radius)) {

				if (e instanceof LivingEntity) {

					LivingEntity mob = (LivingEntity) e;

					mob.setHealth(0);
					
					player.sendMessage("You killed: " + mob.getType());
				}
			}

		}
		return false;
	}
}
