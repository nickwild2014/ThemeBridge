package com.test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.apache.log4j.Logger;


public class TestNTest {

	private final static Logger logger = Logger.getLogger(TestNTest.class.getName());

	public static void main(String[] args) {

		// String convertedAmount = "22222222222222222444888.86559997";
		// CurrencyRoundOffValue(convertedAmount);

		logger.debug(getCcyFromEventField("ASCVacf123.45."));
	}

	/**
	 * 
	 * @param amt
	 * @return
	 */
	public static String getCcyFromEventField(String amt) {
		String result = amt;
		if (result == null) {
			return result;
		}
		result = result.replaceAll("[^a-zA-Z0-9]", "");
		return result;
	}

	public static void CurrencyRoundOffValue(String amountStr) {

		String roundOffValue = "";
		try {
			// String convertedAmount = "22222222222222222444888.86559997";
			BigDecimal bigDecimalValue = new BigDecimal(amountStr);

			// Define Formatter
			DecimalFormat diff = new DecimalFormat("#.##"); // "0.00"
			diff.setMaximumFractionDigits(2);

			// Round Off big decimal value
			roundOffValue = diff.format(bigDecimalValue);

		} catch (Exception e) {
			logger.debug("Exceptions..! " + e.getMessage());

		}

		logger.debug("roundOffValue : " + roundOffValue);
	}

}