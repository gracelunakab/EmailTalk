package com.ts.accessmanagement;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


public class Drivers {
	
	   private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);



	private String BrowserName;
	private String URL;
	

	/**
	 * @param browserName
	 * @param uRL
	 */
	public Drivers(String browserName, String uRL) {
		BrowserName = browserName;
		URL = uRL;
	}

	public String getBrowser() {
		return BrowserName;
	}

	public String getURL() {
		return URL;
	}
	
	public Drivers(String uRL){
		this.URL = uRL;
	}

	public void openHeadlessBrowser() {

		HtmlUnitDriver unitDriver = new HtmlUnitDriver();
		// open webpage
		LOGGER.info("Opening HeadLess Browser for: "+URL );
	//	unitDriver.get(URL);
		 try (final WebClient webClient = new WebClient()) {
		        try {
					final HtmlPage page = webClient.getPage(URL);
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
//		        final HtmlDivision div = page.getHtmlElementById("some_div_id");
//		        final HtmlAnchor anchor = page.getAnchorByName("anchor_name");
		    }
		LOGGER.info("Successfully Openned URL: "+URL);
	}

}
