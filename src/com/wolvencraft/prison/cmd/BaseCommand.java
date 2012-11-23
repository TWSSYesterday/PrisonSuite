package com.wolvencraft.prison.cmd;

public interface BaseCommand {
	public boolean run(String[] args);
	public void getHelp();
	public void getHelpLine();
}
