package com.ts.accessmanagement;

import java.util.logging.Logger;

import com.ts.caller.command;
import com.ts.resourcescaller.RessourceCaller;

public class LogicsController implements command {
private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


	
	public void openMyBrowser(String BrowserName){
		RessourceCaller data = new RessourceCaller();
		if (BrowserName.contains(data.getgmail())){
		Drivers dr = new Drivers(BrowserName);
		dr.openHeadlessBrowser();
		}else{
			LOGGER.info("Email Not Suported");
		}
	}
	
}
