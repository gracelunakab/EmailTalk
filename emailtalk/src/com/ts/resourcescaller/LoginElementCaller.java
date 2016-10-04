package com.ts.resourcescaller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;


@SuppressWarnings("static-access")
public class LoginElementCaller {
	
	   private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

		private static RessourceCaller PropertiesCache;
		private final static Properties configProp = new Properties();
		private static String Propertyfilename ="Login_Elements.properties";
		
		
		public LoginElementCaller setPropertyfilename(String Propertyfilename ){
			this.Propertyfilename=Propertyfilename;
			return this;
			
		}

		public LoginElementCaller() {
			// Private constructor to restrict new instances
			InputStream in = this.getClass().getClassLoader().getResourceAsStream(Propertyfilename);
			LOGGER.info("Reading properties from file: "+Propertyfilename);
			try {
				configProp.load(in);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// Bill Pugh Solution for singleton pattern
		public static class ResourceLoader {
			private static final RessourceCaller INSTANCE = new RessourceCaller();
		}

		public static RessourceCaller getInstance() {
			return ResourceLoader.INSTANCE;
		}

		public static String getProperty(String key) {
			return configProp.getProperty(key);
		}

		public Set<String> getAllPropertyNames() {
			return configProp.stringPropertyNames();
		}

		public boolean containsKey(String key) {
			return configProp.containsKey(key);
		}
		
		public void setProperty(String key, String value){
			  configProp.setProperty(key, value);
		}
		
		public static void main(String[] args)
		{
		  //Get individual properties
		  System.out.println(PropertiesCache.getInstance().getProperty("emailid"));
		  //All property names
		  System.out.println(PropertiesCache.getInstance().getAllPropertyNames());
		}
		

		public String getGmailUserNameID(){
			return PropertiesCache.getInstance().getProperty("gmailUserNameID");
		}
		public String getGmailUserPasswordID(){
			return PropertiesCache.getInstance().getProperty("gmailUserPasswordID");
		}
		public String getGmailUserNameNextButtonID(){
			return PropertiesCache.getInstance().getProperty("gmailUserNameNextButtonID");
		}
		public String getGmailUserSignID(){
			return PropertiesCache.getInstance().getProperty("gmailUserSignID");
		}
		public String getGmailFindMyAccountLing(){
			return PropertiesCache.getInstance().getProperty("gmailFindMyAccountLing");
		}
		

}
