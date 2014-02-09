package com.wolvencraft.prison.hooks;

import org.bukkit.entity.Player;

import net.milkbowl.vault.economy.Economy;

import com.wolvencraft.prison.PrisonSuite;
import com.wolvencraft.prison.exceptions.EconomyNotFoundException;

public class EconomyHook {
	
	/**
	 * Checks if Vault exists and is active
	 * @deprecated
	 * @return true if Vault is usable, false otherwise
	 */
	public static boolean usingVault() {
		return (PrisonSuite.getEconomy() != null && PrisonSuite.getEconomy().isEnabled());
	}
	
	/**
	 * Checks if Vault Economy hook exists and is active
	 * @return true if VaultEco is usable, false otherwise
	 */
	public static boolean usingVaultEconomy() {
		return (PrisonSuite.getEconomy() != null && PrisonSuite.getEconomy().isEnabled());
	}
	
	public static Economy getRawEconomy() throws EconomyNotFoundException {
		if(usingVaultEconomy()) return PrisonSuite.getEconomy();
		throw new EconomyNotFoundException("Could not find a valid economy instance");
	}
	
	/**
	 * Returns the balance of the specified player
	 * @param player Player
	 * @return double balance of the player
	 * @throws EconomyNotFoundException Thrown when no valid economy instance is found. Common causes: missing Vault / missing economy plugin.
	 */
	public static double getBalance(Player player) throws EconomyNotFoundException {
		if(usingVaultEconomy()) return PrisonSuite.getEconomy().getBalance(player.getName());
		throw new EconomyNotFoundException("Could not find a valid economy instance");
	}
	
	/**
	 * Safely withdraws money from a player
	 * @param player Player
	 * @param amount Amount to be withdrawn
	 * @return True if the transaction is complete, false if the player has insufficient funds
	 * @throws EconomyNotFoundException Thrown when no valid economy instance is found. Common causes: missing Vault / missing economy plugin.
	 */
	public static boolean withdraw(Player player, double amount) throws EconomyNotFoundException {
		if(!usingVaultEconomy()) throw new EconomyNotFoundException("Could not find a valid economy instance");
		Economy eco = PrisonSuite.getEconomy();
		if(!eco.has(player.getName(), amount)) return false;
		eco.withdrawPlayer(player.getName(), amount);
		return true;
	}

	/**
	 * Safely deposits money to a player
	 * @param player Player
	 * @param amount Amount to be deposited
	 * @return True if the transaction is complete, false if the player has insufficient funds
	 * @throws EconomyNotFoundException Thrown when no valid economy instance is found. Common causes: missing Vault / missing economy plugin.
	 */
	public static boolean deposit(Player player, double amount) throws EconomyNotFoundException {
		if(!usingVaultEconomy()) throw new EconomyNotFoundException("Could not find a valid economy instance");
		Economy eco = PrisonSuite.getEconomy();
		if(!eco.has(player.getName(), amount)) return false;
		eco.depositPlayer(player.getName(), amount);
		return true;
	}
}
