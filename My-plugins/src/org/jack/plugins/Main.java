package org.jack.plugins;

import org.bukkit.plugin.java.JavaPlugin;
import org.jack.plugins.commands.BlockBelowCommand;
import org.jack.plugins.commands.CowSpawn;
import org.jack.plugins.commands.CurrentTimeCommand;
import org.jack.plugins.commands.DropItemCommand;
import org.jack.plugins.commands.ExplosionCommand;
import org.jack.plugins.commands.KillCommand;
import org.jack.plugins.commands.KillRadiusCommand;
import org.jack.plugins.commands.LocationCommand;
import org.jack.plugins.commands.ShowISCommand;
import org.jack.plugins.commands.SpawnCreeper;
import org.jack.plugins.commands.TeleportCommand;
import org.jack.plugins.listeners.CDiamondListener;
import org.jack.plugins.listeners.CowExplosionListener;
import org.jack.plugins.listeners.ExplosionListener;
import org.jack.plugins.listeners.MobListener;

public class Main extends JavaPlugin {

	public static Main m;
	
	public void onEnable(){
		log("Plugin enabled");
		getServer().getPluginCommand("kill").setExecutor(new KillCommand());
		getServer().getPluginCommand("sc").setExecutor(new SpawnCreeper());
		getServer().getPluginManager().registerEvents(new MobListener(), this);
		getServer().getPluginManager().registerEvents(new CDiamondListener(), this);
		getServer().getPluginCommand("teleport").setExecutor(new TeleportCommand());
		getServer().getPluginCommand("currentlocation").setExecutor(new LocationCommand());
		getServer().getPluginCommand("currenttime").setExecutor(new CurrentTimeCommand());
		getServer().getPluginCommand("cowspawn").setExecutor(new CowSpawn());
		getServer().getPluginManager().registerEvents(new CowExplosionListener(), this);
		getServer().getPluginCommand("iteminfo").setExecutor(new ShowISCommand());
		getServer().getPluginCommand("shower").setExecutor(new DropItemCommand());
		getServer().getPluginCommand("killradius").setExecutor(new KillRadiusCommand());
		getServer().getPluginCommand("blockbelow").setExecutor(new BlockBelowCommand());
		getServer().getPluginManager().registerEvents(new ExplosionListener(), this);
		getServer().getPluginCommand("explosion").setExecutor(new ExplosionCommand());
		m = this;
	}
	
	public void onDisable(){
		log("Plugin disabled");
		
	}
	
	public void log(String message){
		
		System.out.println("[Server log] " + message);
	}

}
