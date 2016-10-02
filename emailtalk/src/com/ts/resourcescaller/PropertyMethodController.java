package com.ts.resourcescaller;

public class PropertyMethodController {
	
	
	public static void main (String[]args){
		createproperty();
	}
	
	public static void createproperty(){
		
		PropertyCaller prop = new PropertyCaller();
		prop.setproperty_key("Prince");
		prop.setproperty_value("5th child");
		prop.setproperty_key("Gracze");
		prop.setproperty_value("4th child");
		prop.setProperty_file_name("");
		prop.myPropertiesBuilder();
	}

}
