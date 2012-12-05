package com.wolvencraft.prison.hooks;

/**
 * An interface to be implemented in every task that has to be run on a timer.<br />
 * Pass the tasks to the PrisonSuite in order to run them.
 * @author bitDesctop
 *
 */
public interface TimedTask {
	
	/**
	 * Bulk of the task. All timed actions go here.
	 */
	public void run();
	
	/**
	 * Returns the name of the task for debug
	 * @return Name of the task
	 */
	public String getName();
	
	/**
	 * Checks if the task has expired
	 * @return true if the task has expired, false otherwise.
	 */
	public boolean getExpired();
	
	/**
	 * Cancels the current task.<br />
	 * The task waits until the end of its period and then expires
	 */
	public void cancel();
}
