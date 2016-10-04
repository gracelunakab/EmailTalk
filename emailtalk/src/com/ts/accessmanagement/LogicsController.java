package com.ts.accessmanagement;

import java.util.logging.Logger;

import com.ts.caller.command;
import com.ts.core.CoreJava;
import com.ts.resourcescaller.RessourceCaller;

public class LogicsController extends CoreJava implements command {
private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

      
	@Override
	public String openMyBrowser(String BrowserName){
		String correlation =  Thread.currentThread().getStackTrace()[1].getMethodName();
		
		RessourceCaller data = new RessourceCaller();
		if (BrowserName.contains(data.getgmail())){
		Drivers dr = new Drivers(data.getgmailUrl());
		dr.openHeadlessBrowser();
		LOGGER.info(getsimplexml(correlation));
		return getsimplexml(correlation);
		}else{
			LOGGER.info("Email Account Not Suported");
			return null;
		}
		
	}
	@Override
	public void myLogin(String UserName, String Password) {
		// TODO Auto-generated method stub
		Login lo = new Login();
		lo.setUserName(UserName);
		lo.setPassword(Password);
		lo.myLogin();
	}
	
	@Override
	public void openMyBrowserAndLogin(String BrowserName, String UserName, String Password ){
		openMyBrowser(BrowserName);
		myLogin(UserName, Password);		
	}
	
	
}
