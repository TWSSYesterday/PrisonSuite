package com.wolvencraft.prison.settings;

import com.wolvencraft.prison.PrisonSuite;

public class Language {
	
	public final String GENERAL_TITLE;
	public final String GENERAL_SUCCESS;
	public final String GENERAL_ERROR;
	
	public final String ERROR_COMMAND;
	public final String ERROR_ARGUMENTS;
	public final String ERROR_ACCESS;
	public final String ERROR_NOSUCHBLOCK;
	public final String ERROR_DIRECTION;
	public final String ERROR_SENDERISNOTPLAYER;

	public final String PROTECTION_PVP;
	public final String PROTECTION_BREAK;
	public final String PROTECTION_PLACE;
	
	public Language(PrisonSuite plugin) {
		GENERAL_TITLE = plugin.getLanguageData().getString("general.title");
		GENERAL_SUCCESS = plugin.getLanguageData().getString("general.title-success");
		GENERAL_ERROR = plugin.getLanguageData().getString("general.title-error");
		
		ERROR_COMMAND = plugin.getLanguageData().getString("error.command");
		ERROR_ARGUMENTS = plugin.getLanguageData().getString("error.arguments");
		ERROR_ACCESS = plugin.getLanguageData().getString("error.access");
		ERROR_NOSUCHBLOCK = plugin.getLanguageData().getString("error.invalid-block");
		ERROR_DIRECTION = plugin.getLanguageData().getString("error.invalid-direction");
		ERROR_SENDERISNOTPLAYER = plugin.getLanguageData().getString("error.sender-is-not-player");
		
		PROTECTION_PVP = plugin.getLanguageData().getString("protection.pvp");
		PROTECTION_BREAK = plugin.getLanguageData().getString("protection.break");
		PROTECTION_PLACE = plugin.getLanguageData().getString("protection.place");
	}
}