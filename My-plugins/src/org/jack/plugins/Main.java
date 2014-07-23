package org.jack.plugins;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.jack.plugins.commands.BlockBelowCommand;
import org.jack.plugins.commands.CurrentTimeCommand;
import org.jack.plugins.commands.DropItemCommand;
import org.jack.plugins.commands.ExplosionCommand;
import org.jack.plugins.commands.KillCommand;
import org.jack.plugins.commands.KillRadiusCommand;
import org.jack.plugins.commands.LocationCommand;
import org.jack.plugins.commands.ShowISCommand;
import org.jack.plugins.commands.ShowerTimeCommand;
import org.jack.plugins.commands.SpawnCreeper;
import org.jack.plugins.commands.TeleportCommand;
import org.jack.plugins.listeners.CDiamondListener;
import org.jack.plugins.listeners.CowExplosionListener;
import org.jack.plugins.listeners.CreeperPigsListener;
import org.jack.plugins.listeners.MobListener;
import org.jack.plugins.mobrider.SpawnMobCommand;

public class Main extends JavaPlugin {

	public static Main m;
	public static Economy economy = null;

	public void onEnable() {
		log("Plugin enabled");
		getServer().getPluginCommand("kill").setExecutor(new KillCommand());
		getServer().getPluginCommand("sc").setExecutor(new SpawnCreeper());
		getServer().getPluginManager().registerEvents(new MobListener(), this);
		getServer().getPluginManager().registerEvents(new CDiamondListener(),
				this);
		getServer().getPluginCommand("teleport").setExecutor(
				new TeleportCommand());
		getServer().getPluginCommand("currentlocation").setExecutor(
				new LocationCommand());
		getServer().getPluginCommand("currenttime").setExecutor(
				new CurrentTimeCommand());
		// getServer().getPluginCommand("cowspawn").setExecutor(new CowSpawn());
		getServer().getPluginManager().registerEvents(
				new CowExplosionListener(), this);
		getServer().getPluginCommand("iteminfo").setExecutor(
				new ShowISCommand());
		getServer().getPluginCommand("shower").setExecutor(
				new DropItemCommand());
		getServer().getPluginCommand("killradius").setExecutor(
				new KillRadiusCommand());
		getServer().getPluginCommand("blockbelow").setExecutor(
				new BlockBelowCommand());
		// getServer().getPluginManager().registerEvents(new
		// ExplosionListener(),
		// this);
		getServer().getPluginCommand("explosion").setExecutor(
				new ExplosionCommand());
		getServer().getPluginManager().registerEvents(
				new CreeperPigsListener(), this);
		getServer().getPluginCommand("showertime").setExecutor(
				new ShowerTimeCommand());
		getServer().getPluginCommand("sm").setExecutor(new SpawnMobCommand());
		m = this;
		setupEconomy();
	}

	public void onDisable() {
		log("Plugin disabled");

	}

	private boolean setupEconomy() {
		RegisteredServiceProvider<Economy> economyProvider = getServer()
				.getServicesManager().getRegistration(
						net.milkbowl.vault.economy.Economy.class);
		if (economyProvider != null) {
			economy = economyProvider.getProvider();
		}

		return (economy != null);
	}

	public void log(String message) {

		System.out.println("[Server log] " + message);
	}

}
