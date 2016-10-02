package com.ts.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class SystemUtility {

	/**
	 * Defining log level SEVERE (highest) WARNING INFO CONFIG FINE FINER FINEST
	 **/


	public String getCurrentDateTimeWithDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		// get current date time with Date()
		Date date = new Date();
		return (dateFormat.format(date));
	}

	public String getCurrentDateTimeWithCalendar() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		// get current date time with Calendar()
		Calendar cal = Calendar.getInstance();
		return (dateFormat.format(cal.getTime()));
	}

}
