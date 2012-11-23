package com.wolvencraft.prison.hooks;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.bukkit.selections.Selection;
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
		Selection sel = we.getSelection(player);
		Location[] loc = {null, null};
		if(sel == null) return null;
		loc[0] = sel.getMinimumPoint();
		loc[1] = sel.getMaximumPoint();
		return loc;
	}
	
	public static Location getMaximumPoint(Player player) {
		WorldEditPlugin we = PrisonSuite.getWorldEditPlugin();
		Selection sel = we.getSelection(player);
		if(sel == null) return null;
		return sel.getMaximumPoint();
	}
	
	public static Location getMinimumPoint(Player player) {
		WorldEditPlugin we = PrisonSuite.getWorldEditPlugin();
		Selection sel = we.getSelection(player);
		if(sel == null) return null;
		return sel.getMinimumPoint();
	}
}
