package com.bs.themebridge.util;

import org.apache.log4j.Logger;

/**
 * @author <i><b><font style = color:blue> Prasath Ravichandran </i></b></font>
 * @version 1.01
 * @since 2016-NOV-26
 *
 */
public class AlphaNumericSegregation {

	private final static Logger logger = Logger.getLogger(AlphaNumericSegregation.class);

	public static void main(String[] args) {

		// logger.debug(getNumericals("1,100.23 INR"));
		// logger.debug(getNumericalsWithDecimal("$ 1,100.23 USD"));
		// logger.debug(getNumericalsWithDecimalComma("$ 1,100.23 USD"));
		//
		// logger.debug(getAlphabets("$ 1,100.23 USD"));
		// logger.debug(getAlphabetsLowerCase("$ 1,256.23 USD inSr"));
		// logger.debug(getAlphabetsUpperCase("$ 1,256.23 USiD inr"));

		System.out.println(getSwiftToRegularAmount("INR5000,00"));
		// System.out.println(getNumericalsWithDecimalComma("INR 256.00"));

		test();
	}

	public static String test() {

		String branchCode = "123 # IJDH";
		branchCode = branchCode.replaceFirst("^0+(?!$)", "");
		logger.debug(branchCode);

		return "";
	}

	/**
	 * 
	 * @param amt
	 * @return
	 */
	public static String getAlphabetsNumbers(String amt) {
		String result = amt;
		if (result == null) {
			return result;
		}
		result = result.replaceAll("[^a-zA-Z0-9]", "");
		return result;
	}

	/**
	 * 2017-Mar-10
	 * 
	 * @param amountccy
	 *            {@code allows '1,256.23 INR' }{@link String}
	 * @return {@code returns '125623' }{@link String}
	 */
	public static String getNumericals(String alphaNumeric) {

		String result = "";
		try {
			if (alphaNumeric != null && !alphaNumeric.isEmpty()) {
				result = alphaNumeric.replaceAll("[^0-9]", "");
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return result;
	}

	/**
	 * 2017-Mar-10
	 * 
	 * @param amountccy
	 *            {@code allows '1,256.23 INR' }{@link String}
	 * @return {@code returns '1256.23' }{@link String}
	 */
	public static String getNumericalsWithDecimal(String alphaNumeric) {

		String result = "";
		try {
			if (alphaNumeric != null && !alphaNumeric.isEmpty()) {
				result = alphaNumeric.replaceAll("[^0-9.]", "");
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return result;
	}

	/**
	 * 2017-Mar-10
	 * 
	 * @param amountccy
	 *            {@code allows '1,256.23 INR' }{@link String}
	 * @return {@code returns '1,256.23' }{@link String}
	 */
	public static String getNumericalsWithDecimalComma(String alphaNumeric) {

		String result = "";
		try {
			if (alphaNumeric != null && !alphaNumeric.isEmpty()) {
				// alphaNumeric = alphaNumeric.replaceAll("\\s+", "");
				result = alphaNumeric.replaceAll("[^0-9,.]", "");
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return result;
	}

	/**
	 * 2017-Mar-10
	 * 
	 * @param amountccy
	 *            {@code allows '1,256.23 INR' }{@link String}
	 * @return {@code returns '1,256.23' }{@link String}
	 */
	public static String getSwiftToRegularAmount(String alphaNumeric) {

		String result = "";
		try {
			alphaNumeric = alphaNumeric.replace(",", ".");
			if (alphaNumeric != null && !alphaNumeric.isEmpty()) {
				// alphaNumeric = alphaNumeric.replaceAll("\\s+", "");
				result = alphaNumeric.replaceAll("[^0-9,.]", "");

				// getAmountFromEventField();
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * With Comma and Decimal
	 * 
	 * @param amtCcy
	 * @return
	 */
	public static String getAmountFromEventField(String amtCcy) {

		String result = amtCcy;
		if (result == null) {
			return result;
		}
		result = result.replaceAll("[^0-9.,]", "");
		return result;
	}

	/**
	 * 
	 * @param amt
	 * @return
	 */
	public static String getCcyFromEventField(String amtCcy) {
		// System.out.println("amtCcy >>" + amtCcy);
		String result = amtCcy;
		if (result == null) {
			return result;
		}
		result = result.replaceAll("[^a-zA-Z]", "");
		return result;
	}

	/*****************************************************************/

	/**
	 * 2017-Mar-10
	 * 
	 * @param amountccy
	 *            {@code allows '$ 1,256.23 USD' }{@link String}
	 * @return {@code returns 'USD' }{@link String}
	 */
	public static String getAlphabets(String alphaNumeric) {

		String result = "";
		try {
			if (alphaNumeric != null && !alphaNumeric.isEmpty()) {
				result = alphaNumeric.replaceAll("[^a-zA-Z]", "");
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return result;
	}

	/**
	 * 2017-Mar-10
	 * 
	 * @param amountccy
	 *            {@code allows '$ 1,256.23 USD inSr' }{@link String}
	 * @return {@code returns 'inr' }{@link String}
	 */
	public static String getAlphabetsLowerCase(String alphaNumeric) {

		String result = "";
		try {
			if (alphaNumeric != null && !alphaNumeric.isEmpty()) {
				result = alphaNumeric.replaceAll("[^a-z]", "");
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return result;
	}

	/**
	 * 2017-Mar-10
	 * 
	 * @param amountccy
	 *            {@code allows '$ 1,256.23 USiD inr' }{@link String}
	 * @return {@code returns 'USD' }{@link String}
	 */
	public static String getAlphabetsUpperCase(String alphaNumeric) {

		String result = "";
		try {
			if (alphaNumeric != null && !alphaNumeric.isEmpty()) {
				result = alphaNumeric.replaceAll("[^A-Z]", "");
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return result;
	}
}
