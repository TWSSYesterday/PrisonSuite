package com.wolvencraft.prison.hooks;

import org.bukkit.entity.Player;

import net.milkbowl.vault.economy.Economy;

import com.wolvencraft.prison.PrisonSuite;

public class EconomyHook {
	/**
	 * Checks if Vault exists and is active
	 * @return true if Vault is usable, false otherwise
	 */
	public static boolean usingVault() {
		return (PrisonSuite.getEconomy() != null && PrisonSuite.getEconomy().isEnabled());
	}
	
	/**
	 * Returns the balance of the specified player
	 * @param player Player
	 * @return double balance of the player
	 */
	public static double getBalance(Player player) {
		return PrisonSuite.getEconomy().getBalance(player.getName());
	}
	
	/**
	 * Safely withdraws money from a player
	 * @param player Player
	 * @param amount Amount to be withdrawn
	 * @return True if the transaction is complete, false if the player has insufficient funds
	 */
	public static boolean withdraw(Player player, double amount) {
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
	 */
	public static boolean deposit(Player player, double amount) {
		Economy eco = PrisonSuite.getEconomy();
		if(!eco.has(player.getName(), amount)) return false;
		eco.depositPlayer(player.getName(), amount);
		return true;
	}
}
