package com.ts.accessmanagement;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.ts.core.CoreHtmlUnit;
import com.ts.resourcescaller.LoginElementCaller;

public class Login extends LoginElementCaller  {
	
	private static String UserName;
	private static String Password;
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return UserName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		UserName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		Password = password;
	}
	
	public Login(){
		
	}
	
	public void myLogin(){
	CoreHtmlUnit bot;
	LoginElementCaller ldata = new LoginElementCaller();
	try {
		bot = new CoreHtmlUnit();
	
		    bot.setInputValue(ldata.getGmailUserNameID(), UserName);
		    bot.clickButton(ldata.getGmailUserNameNextButtonID());
		    bot.setInputValue(ldata.getGmailUserPasswordID(), Password);
		    bot.clickButton(ldata.getGmailUserSignID());
		    bot.getCurrentPage().getTitleText();
		    
	} catch (FailingHttpStatusCodeException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  
  }

	
}
//bot.clickImageButton("//div[@id='navGoButton']/input");
//  bot.selectDropList("searchDropdownBox", "search-alias=stripbooks");