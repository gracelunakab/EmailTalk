package com.ts.test;

import org.junit.Ignore;
import org.junit.Test;
import com.ts.accessmanagement.LogicsController;


public class BrowserTest extends LogicsController  {
	
	private LogicsController lc = new LogicsController();
	@Test
	@Ignore
	public void openheadlessbrowse(){
		lc.openMyBrowser("... //http..ok ok mbyut dfa gmail sdfads");
	}
	
	@Test
	public void opendgmailandlogin(){
		lc.openMyBrowserAndLogin("like gmail", "gracetkab", "Lunay1990@");
	}

}
