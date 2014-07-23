package org.jack.plugins.mobrider;

import net.minecraft.server.v1_7_R3.EntityCreature;
import net.minecraft.server.v1_7_R3.PathEntity;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_7_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftCreature;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.jack.plugins.Main;

public class Mount {

	private Player p;
	private LivingEntity mount;
	private Player tracktarget;
	private Location targetlocation;
	private BukkitTask ts;
	private Boolean trackmode;

	public Mount(Player p, Location l, EntityType et) {

		trackmode = false;
		setName();
		startTimer();

	}

	public void setName() {

		mount.setCustomName(ChatColor.GREEN + p.getName() + "'s" + " mount");
	}

	public void mount() {

		mount.setPassenger(p);
	}

	public void trackPlayer(Player tt) {

		this.tracktarget = tt;

		if (tt.isOnline() && tt.isDead() == false) {

			EntityCreature ec = ((CraftCreature) mount).getHandle();

			float speed = 1.4f;

			Block to = tt.getLocation().getBlock();

			PathEntity pf = ((CraftWorld) to.getWorld()).getHandle().a(ec,
					to.getX(), to.getY(), to.getZ(), speed, true, false, false,
					true);
			ec.setPathEntity(pf);

		}
	}

	public Location updateTrackLocation() {

		targetlocation = tracktarget.getLocation();

		return targetlocation;

	}

	private void startTimer() {
		ts = new BukkitRunnable() {

			@Override
			public void run() {

				if (tracktarget.isOnline()) {

					updateTrackLocation();

				}

			}

		}.runTaskTimer(Main.m, 10, 20);

	}

	private void cancelTimer() {
		if (mount.isDead()) {
			p.sendMessage("Your mount has died");
		}
		mount.remove();
		ts.cancel();

	}

	private void track() {
		
		if(trackmode = true){

	}
}
}
