package com.test;

import org.apache.log4j.Logger;

import com.bs.theme.bob.adapter.adaptee.SWIFTSwiftInAdaptee;


public class JavaDataTypesAnalysis {

	private final static Logger logger = Logger.getLogger(SWIFTSwiftInAdaptee.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		integervalues();
		floatValues();
		doubleValues();
		longValues();
	}

	public static void integervalues() {
		logger.debug(Integer.MIN_VALUE);// -2147483648
		logger.debug(Integer.MAX_VALUE);// 2147483647
	}

	public static void floatValues() {
		logger.debug(Float.MIN_VALUE);// 1.4E-45
		logger.debug(Float.MAX_VALUE);// 3.4028235E38
	}

	public static void doubleValues() {
		logger.debug(Double.MIN_VALUE);// 4.9E-324
		logger.debug(Double.MAX_VALUE);// 1.7976931348623157E308
	}

	public static void longValues() {
		logger.debug(Long.MIN_VALUE);// -9223372036854775808
		logger.debug(Long.MAX_VALUE);// 9223372036854775808
	}
}
