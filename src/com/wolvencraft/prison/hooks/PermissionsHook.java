
package com.wolvencraft.prison.hooks;
 
import net.milkbowl.vault.permission.Permission;
import org.bukkit.entity.Player;

import com.wolvencraft.prison.PrisonSuite;
import com.wolvencraft.prison.exceptions.PermissionsNotFoundException;
 
public class PermissionsHook {
	
	/**
	 * Checks if Vault Permissions hook exists and is active
	 * @return true if VaultPerms is usable, false otherwise
	 */
	public static boolean usingVaultPermissions() {
		return (PrisonSuite.getPermissions() != null && PrisonSuite.getPermissions().isEnabled());
	}
	
	/**
	 * Returns the rank that the specified player has
	 * @param player Player to check
	 * @return <b>String</b> name of the rank
	 * @throws PermissionsNotFoundException  Thrown when no valid permissions instance is found. Common causes: missing Vault / missing permissions plugin.
	 */
	public static String getRank(Player player) throws PermissionsNotFoundException {
		if(!usingVaultPermissions()) throw new PermissionsNotFoundException("Could not find a valid permissions instance");
		return PrisonSuite.getPermissions().getPlayerGroups(player.getWorld(), player.getPlayerListName())[0];
	}
	 
	/**
	 * Sets the rank of the specified player to the desired rank
	 * @param player Player to set the rank to
	 * @param rank Rank to set
	 * @return <b>true</b> if the rank has been set, <b>false</b> otherwise
	 * @throws PermissionsNotFoundException  Thrown when no valid permissions instance is found. Common causes: missing Vault / missing permissions plugin.
	 */
	public static boolean setRank(Player player, String rank) throws PermissionsNotFoundException {
		if(!usingVaultPermissions()) throw new PermissionsNotFoundException("Could not find a valid permissions instance");
		if(!rankExists(rank)) return false;
		Permission permissions = PrisonSuite.getPermissions();
		if(permissions.playerInGroup(player, rank)) return false;
		String currentGroup = getRank(player);
		if(permissions.playerAddGroup(player, rank) && permissions.playerRemoveGroup(player, currentGroup)) return true;
		return false;
	}
	 
	/**
	 * Checks if the rank even exists in the permissions plugin
	 * @param rank Rank to check
	 * @return <b>true</b> if the rank exists, <b>false</b> otherwise
	 * @throws PermissionsNotFoundException  Thrown when no valid permissions instance is found. Common causes: missing Vault / missing permissions plugin.
	 */
	public static boolean rankExists(String rank) throws PermissionsNotFoundException {
		if(!usingVaultPermissions()) throw new PermissionsNotFoundException("Could not find a valid permissions instance");
		for(String group : PrisonSuite.getPermissions().getGroups()) {
			if(group.equalsIgnoreCase(rank)) return true;
		}
		return false;
	}
}