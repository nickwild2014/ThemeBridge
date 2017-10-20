package com.test;

import org.apache.log4j.Logger;

import com.bs.theme.bob.adapter.adaptee.SWIFTSwiftInAdaptee;
import com.bs.themebridge.util.ThemeBridgeUtil;

public class StringLineSepaator {

	private final static Logger logger = Logger.getLogger(SWIFTSwiftInAdaptee.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringLineSeparator();
	}

	public static String StringLineSeparator() {

		String result = "";
		try {
			String swiftMessage = ThemeBridgeUtil
					.readFile("C:\\Users\\KXT51472\\Downloads\\MT10323022017_1750047.swift");

			StringBuilder currencyleg = new StringBuilder();
			String[] lines = swiftMessage.split(System.getProperty("line.separator"));

			String MsgType = "103";
			if (MsgType.equals("103")) {
				for (String string : lines) {
					if (string.contains("32A:")) {
						currencyleg.append(string);
					}
					if (string.contains("33B:")) {
						currencyleg.append(string);
					}
				}
			}

			if (MsgType.equals("202")) {

				for (String string : lines) {
					if (string.contains("32B:")) {
						currencyleg.append(string);
					}
					if (string.contains("32A:")) {
						currencyleg.append(string);
					}
				}
			}

			String ccy = currencyleg.toString();
			logger.debug(ccy);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
