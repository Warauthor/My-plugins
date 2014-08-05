package org.hcraid.factions;

import java.util.ArrayList;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.trc202.CombatTag.CombatTag;
import com.trc202.CombatTagApi.CombatTagApi;

public class Main extends JavaPlugin {

	public static Main m;
	public static CombatTagApi combatApi;
	public static WorldGuardPlugin worldguardplugin;
	public static ArrayList<String> regions;
	public static boolean enabled;

	public void onEnable() {

		log("enabled");
		loadConfig();

		getServer().getPluginManager().registerEvents(new PvpLockListener(),
				this);

		m = this;

		setupCombatTag();
		getWorldGuard();

	}

	public void onDisable() {

		log("disabled");
	}

	public void log(String message) {
		System.out.println("[Factions] " + message);

	}

	private void setupCombatTag() {
		if (getServer().getPluginManager().getPlugin("CombatTag") != null) {
			combatApi = new CombatTagApi((CombatTag) getServer()
					.getPluginManager().getPlugin("CombatTag"));
		} else {
			getServer().getPluginManager().disablePlugin(this);
			log("Disabling, couldn't find CombatTag.");
		}

	}

	private WorldGuardPlugin getWorldGuard() {
		Plugin plugin = getServer().getPluginManager().getPlugin("WorldGuard");

		// WorldGuard may not be loaded
		if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
			return null; // Maybe you want throw an exception instead
		}

		return (WorldGuardPlugin) plugin;
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	private void loadConfig() {

		ArrayList<String> regions = new ArrayList<String>();

		regions.add("innerspawn");
		regions.add("safespawn");

		getConfig().addDefault("Forcefield Region.Enabled", true);
		getConfig().addDefault("Forcefield Region.Regions", regions);

		getConfig().options().copyDefaults(true);

		saveConfig();

		this.regions = (ArrayList<String>) getConfig().getList(
				"Forcefield Region.Regions");
		enabled = getConfig().getBoolean("Forcefield Region.Enabled");
	}

	@SuppressWarnings("unused")
	private void logToFile(String directory, String fileName, String line) {

	}

}
