package org.jack.plugins.mobrider;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class MobMountCommand implements CommandExecutor{

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		
		if(sender instanceof Player && cmd.getName().equalsIgnoreCase("mm")){
			
			Player p = (Player) sender;
			
			if(p.isInsideVehicle() == false){
				
				for(Entity e : p.getTargetBlock(null, 5).getWorld().getEntities()){
					
					e.setPassenger(p);
					break;
				}
			}
			
			
		}

		return false;
	}

}
