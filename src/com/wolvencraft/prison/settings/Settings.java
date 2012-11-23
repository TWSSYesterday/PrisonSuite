package com.wolvencraft.prison.settings;

import com.wolvencraft.prison.PrisonSuite;

public class Settings {
	public final long TICKRATE;
	public final boolean METRICS;
	public final boolean DEBUG;
	public final int WAND;
	public final String LANGUAGE;
	
	public final boolean UPDATE;
	
	public Settings(PrisonSuite plugin) {
		TICKRATE = plugin.getConfig().getLong("general.tickRate");
		METRICS = plugin.getConfig().getBoolean("general.metrics");
		DEBUG = plugin.getConfig().getBoolean("general.debug");
		WAND = plugin.getConfig().getInt("general.wand");
		LANGUAGE = plugin.getConfig().getString("general.language");
		
		UPDATE = plugin.getConfig().getBoolean("updater.notifications");
	}
}
