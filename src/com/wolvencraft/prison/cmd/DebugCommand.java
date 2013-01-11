package com.wolvencraft.prison.cmd;

import com.wolvencraft.prison.CommandManager;
import com.wolvencraft.prison.PrisonSuite;
import com.wolvencraft.prison.hooks.TimedTask;
import com.wolvencraft.prison.util.Message;

public class DebugCommand implements BaseCommand {

	@Override
	public boolean run(String[] args) {
		if(!CommandManager.getSender().isOp()) return false;
		
		if(args[0].equalsIgnoreCase("displayTasks")) {
			for(TimedTask task : PrisonSuite.getLocalTasks()) {
				Message.send(task.getName());
			}
			return true;
		} else if(args[0].equalsIgnoreCase("cancelTask")) {
			for(TimedTask task : PrisonSuite.getLocalTasks()) {
				if(task.getName().equalsIgnoreCase(args[1])) {
					Message.send("Task " + task.getName() + " is being canceled");
					task.cancel();
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public void getHelp() { }

	@Override
	public void getHelpLine() { }

}
