package com.wolvencraft.prison.hooks;

/**
 * An interface to be implemented in every task that has to be run on a timer.<br />
 * Pass the tasks to the PrisonSuite in order to run them.
 * @author bitDesctop
 *
 */
public class TimedTask {
	public TimedTask(long ticks) {}
	
	public void run() {}
	
	public String getName() { return null; }
}
