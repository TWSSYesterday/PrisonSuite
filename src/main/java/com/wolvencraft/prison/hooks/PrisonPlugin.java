package com.wolvencraft.prison.hooks;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class PrisonPlugin extends JavaPlugin {
	private double version;
	
	public double getVersion() { return version; }
}