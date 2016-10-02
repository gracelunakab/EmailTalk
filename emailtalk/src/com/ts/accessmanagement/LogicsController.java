package com.ts.accessmanagement;

import java.util.logging.Logger;

import com.ts.caller.command;

public class LogicsController implements command {
private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


	
	public void openMyBrowser(String uRL){
		Drivers dr = new Drivers(uRL);
		dr.openHeadlessBrowser();
	}
	
}
