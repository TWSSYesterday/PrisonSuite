package com.wolvencraft.prison.hooks;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import com.sk89q.worldedit.IncompleteRegionException;
import com.sk89q.worldedit.LocalWorld;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldedit.Vector;
import com.wolvencraft.prison.PrisonSuite;

public class WorldEditHook {
	public static boolean usingWorldEdit() {
		if(PrisonSuite.getWorldEditPlugin() == null) return false;
		return true;
	}
	
	public static int getWandItem() {
		return PrisonSuite.getWorldEditPlugin().getLocalConfiguration().wandItem;
	}
	
	public static Location[] getPoints(Player player) {
		WorldEditPlugin we = PrisonSuite.getWorldEditPlugin();
		Region sel = null;
		try { sel = we.getSession(player).getSelection((LocalWorld) player.getWorld()); }
		catch (IncompleteRegionException ire) { return null; }
		Location[] loc = {null, null};
		if(sel == null) return null;
		loc[0] = toLocation((World) sel.getWorld(), sel.getMinimumPoint());
		loc[1] = toLocation((World) sel.getWorld(), sel.getMaximumPoint());
		return loc;
	}
	
	public static Location getMaximumPoint(Player player) {
		WorldEditPlugin we = PrisonSuite.getWorldEditPlugin();
		Region sel = null;
		try { sel = we.getSession(player).getSelection((LocalWorld) player.getWorld()); }
		catch (IncompleteRegionException ire) { return null; }
		if(sel == null) return null;
		return toLocation((World) sel.getWorld(), sel.getMaximumPoint());
	}
	
	public static Location getMinimumPoint(Player player) {
		WorldEditPlugin we = PrisonSuite.getWorldEditPlugin();
		Region sel = null;
		try { sel = we.getSession(player).getSelection((LocalWorld) player.getWorld()); }
		catch (IncompleteRegionException ire) { return null; }
		if(sel == null) return null;
		return toLocation((World) sel.getWorld(), sel.getMinimumPoint());
	}
	
	private static Location toLocation(World world, Vector vector) {
		return new Location(world, vector.getX(), vector.getY(), vector.getZ());
	}
}
