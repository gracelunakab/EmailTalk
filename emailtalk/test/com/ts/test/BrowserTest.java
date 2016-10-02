package com.ts.test;

import org.junit.Test;
import com.ts.accessmanagement.LogicsController;


public class BrowserTest extends LogicsController  {
	
	private LogicsController lc = new LogicsController();
	@Test
	public void openheadlessbrowse(){
		lc.openMyBrowser("https://www.gmail.com");
	}

}
