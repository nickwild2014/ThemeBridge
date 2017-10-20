package com.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.bs.theme.bob.adapter.adaptee.SWIFTSwiftInAdaptee;


public class TestTime {

	private final static Logger logger = Logger.getLogger(SWIFTSwiftInAdaptee.class);

	public static void main(String[] args) {

		String RTGSTime = "14:30:47";
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		logger.debug("Current Time " + dateFormat.format(date));
		String str1 = dateFormat.format(date);
		Date t1 = null;
		try {
			t1 = new SimpleDateFormat("HH:mm:ss").parse(str1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar c1 = Calendar.getInstance();
		c1.setTime(t1);

		Date d = null;
		try {
			d = new SimpleDateFormat("HH:mm:ss").parse(RTGSTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar c3 = Calendar.getInstance();
		c3.setTime(d);
		c3.add(Calendar.DATE, 0);

		Date x = c3.getTime();
		if (x.before(c1.getTime())) {
			logger.debug("Yes its before RTGS TIME");
		} else {
			logger.debug("Yes its after  RTGS TIME");
		}

	}

}
