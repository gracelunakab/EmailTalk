package com.ts.core;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlImageInput;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlOption;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public class CoreHtmlUnit {

	private HtmlPage currentPage;
	private WebClient webClient;
 
	public HtmlPage getCurrentPage() {
		return currentPage;
	}

	public void setInputValue(String inputId, String textValue) {
		 webClient.waitForBackgroundJavaScript(100);
		HtmlTextInput input = (HtmlTextInput) currentPage.getElementById(inputId);
		while(input != null) {
			  webClient.waitForBackgroundJavaScript(100);
			  input = (HtmlTextInput) currentPage.getElementById(inputId);
			  input.setValueAttribute(textValue);
			}
	
		
	}

	public CoreHtmlUnit(String pageAddress) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		this();
		this.goToAddress(pageAddress);
	}
	
	 public CoreHtmlUnit() {
		// TODO Auto-generated constructor stub
	}

	public void goToAddress(String pageAddress)
	            throws FailingHttpStatusCodeException, MalformedURLException,
	            IOException {
	        WebClient webClient = new WebClient();
	        currentPage = webClient.getPage(pageAddress);
	    }
	
	/**
     * 
     * @param buttonId
     *            Button id
     * @throws IOException
     */
    public void clickImageButton(String xpathExpr) throws IOException {
        HtmlImageInput button = (HtmlImageInput) currentPage
                .getFirstByXPath(xpathExpr);
        currentPage = (HtmlPage) button.click();
    }
    
    /**
     * 
     * @param radioButtonId
     * @param radioButtonOption
     * @throws IOException
     * @throws InterruptedException
     */
    public void selectRadioButton(String radioButtonId, String radioButtonOption)
            throws IOException, InterruptedException {
        final HtmlInput radio = (HtmlInput) currentPage
                .getElementById(radioButtonId);
        radio.click();
        Thread.sleep(10000);
    }
    /**
     * 
     * @param dropListId
     * @param dropListOption
     */
    public void selectDropList(String dropListId, String dropListOption) {
        HtmlSelect select = (HtmlSelect) currentPage.getElementById(dropListId);
        HtmlOption option = select.getOptionByValue(dropListOption);
        select.setSelectedAttribute(option, true);
    }
    
    public static void main(String[] args) throws IOException {
    	CoreHtmlUnit bot = new CoreHtmlUnit("http://www.amazon.com");
        bot.selectDropList("searchDropdownBox", "search-alias=stripbooks");
        bot.setInputValue("twotabsearchtextbox", "java");
        bot.clickImageButton("//div[@id='navGoButton']/input");
        bot.getCurrentPage().getTitleText();
    }

	public void clickButton(String myid) throws IOException {
		 HtmlImageInput button = (HtmlImageInput) currentPage
	                .getElementById(myid);
	        currentPage = (HtmlPage) button.click();
		
	}
    




}
