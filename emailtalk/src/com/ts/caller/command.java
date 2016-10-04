package com.ts.caller;

public interface command {
	
	public String openMyBrowser(String BrowserName);
	
	public void myLogin(String UserName, String Password);
	
	public void openMyBrowserAndLogin(String BrowserName, String UserName, String Password );

}
