package com.ts.core;

import com.ts.resourcescaller.RessourceCaller;

public class CoreJava {
	
	
	public static String getsimplexml(String myvalue){
		RessourceCaller data = new RessourceCaller();
		String value = "<Correlation_ID>"+myvalue+" "+data.getgmail()+"</Correlation_ID>";
		return value;
	}

}
