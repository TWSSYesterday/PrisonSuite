package com.wolvencraft.prison.exceptions;

public class VaultNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2138363908306615259L;
	
	String message;
	
	public VaultNotFoundException(String message) {
		super(message);
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
}
