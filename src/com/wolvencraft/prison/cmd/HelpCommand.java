package com.wolvencraft.prison.cmd;

import com.wolvencraft.prison.CommandManager;
import com.wolvencraft.prison.PrisonSuite;
import com.wolvencraft.prison.util.Message;

public class HelpCommand implements BaseCommand {

	@Override
	public boolean run(String[] args) {
		Message.formatHeader(20, PrisonSuite.getLanguage().GENERAL_TITLE);
		for(CommandManager cmd : CommandManager.values()) { cmd.getHelpLine(); }
		return true;
	}
	
	public void getHelp() {}
	public void getHelpLine() {};
}
