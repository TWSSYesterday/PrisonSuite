package com.wolvencraft.prison.exceptions;

public class PermissionsNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5143625980831657040L;
	
	String message;
	
	public PermissionsNotFoundException(String message) {
		super(message);
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
