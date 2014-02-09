package com.wolvencraft.prison.hooks;

public interface CommandHook {
	
	public boolean isCommand(String arg);
	public void getHelp();
	public void getHelpLine();
	
	public boolean run(String[] args);
	public boolean run(String arg);
}