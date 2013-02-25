package com.wolvencraft.prison.exceptions;

public class EconomyNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3125091301334638031L;
	
	String message;
	
	public EconomyNotFoundException(String message) {
		super(message);
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
