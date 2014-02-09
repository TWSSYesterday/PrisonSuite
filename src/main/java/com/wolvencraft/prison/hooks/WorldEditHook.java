package com.wolvencraft.prison.hooks;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.bukkit.selections.Selection;
import com.wolvencraft.prison.PrisonSuite;

public class WorldEditHook {
	/**
	 * @deprecated
	 * Checks if WorldEdit exists and is running.<br />
	 * Moved to PrisonSuite main class for compatibility.
	 * @return true if WorldEdit is usable, false otherwise
	 */
	public static boolean usingWorldEdit() {
		if(PrisonSuite.getWorldEditPlugin() == null) com.wolvencraft.prison.util.Message.debug("No WE found, told you already!");
		return (PrisonSuite.getWorldEditPlugin() != null && PrisonSuite.getWorldEditPlugin().isEnabled());
	}
	
	/**
	 * Returns the item ID of the wand item used by the WorldEdit
	 * @return Item ID of the wand item
	 */
	public static int getWandItem() {
		return PrisonSuite.getWorldEditPlugin().getLocalConfiguration().wandItem;
	}
	
	/**
	 * Returns both selection points as an array for the specified player
	 * @param player Player who performed the selection
	 * @return An array of selection points or null if there is no selection
	 */
	public static Location[] getPoints(Player player) {
		if(!usingWorldEdit()) return null;
		WorldEditPlugin we = PrisonSuite.getWorldEditPlugin();
		Selection sel = we.getSelection(player);
		Location[] loc = {null, null};
		if(sel == null) return null;
		loc[0] = sel.getMinimumPoint();
		loc[1] = sel.getMaximumPoint();
		return loc;
	}
	
	/**
	 * Returns the maximum point of the selection
	 * @param player Player who performed the selection
	 * @return A selection point or null if there isn't one
	 */
	public static Location getMaximumPoint(Player player) {
		if(!usingWorldEdit()) return null;
		WorldEditPlugin we = PrisonSuite.getWorldEditPlugin();
		Selection sel = we.getSelection(player);
		if(sel == null) return null;
		return sel.getMaximumPoint();
	}

	/**
	 * Returns the minimum point of the selection
	 * @param player Player who performed the selection
	 * @return A selection point or null if there isn't one
	 */
	public static Location getMinimumPoint(Player player) {
		if(!usingWorldEdit()) return null;
		WorldEditPlugin we = PrisonSuite.getWorldEditPlugin();
		Selection sel = we.getSelection(player);
		if(sel == null) return null;
		return sel.getMinimumPoint();
	}
}
