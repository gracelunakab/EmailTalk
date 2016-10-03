package com.ts.util;


import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import com.sun.jersey.server.impl.uri.rules.ResourceClassRule;
import com.sun.research.ws.wadl.Resource;
import com.ts.resourcescaller.PropertyCaller;
import com.ts.resourcescaller.RessourceCaller;


public class ConfigFilePrinter {

  public static void main(String[] args) {
	ConfigFilePrinter app = new ConfigFilePrinter();
	app.printThemAll();
	
	
  }

  private void printThemAll() {

	Properties prop = new Properties();
	InputStream input = null;

	try {

		String filename = "Config.properties";
		input = getClass().getClassLoader().getResourceAsStream(filename);
		if (input == null) {
			System.out.println("Sorry, unable to find " + filename);
			return;
		}

		prop.load(input);

		Enumeration<?> e = prop.propertyNames();
		while (e.hasMoreElements()) {
			String key = (String) e.nextElement();
			String value = prop.getProperty(key);
			System.out.println("Key : " + key + ", Value : " + value);
		}

	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

  }

}