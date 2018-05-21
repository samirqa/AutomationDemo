package com.qualtab.automationdemo.scripts.utility;

import java.io.IOException;
import java.util.Properties;

public class ApplicationProperties extends Properties {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ApplicationProperties() throws IOException{
		load(getClass().getResourceAsStream("/application.properties"));
	}
	
	private static ApplicationProperties _appProps;
	
	public static ApplicationProperties getInstance()
	{
		synchronized (_appProps) {
			if(_appProps!=null)
				return _appProps;
			else
				try {
					return new ApplicationProperties();
				} catch (IOException e) {
					e.printStackTrace();
				}
			return null;
		}
	}
}