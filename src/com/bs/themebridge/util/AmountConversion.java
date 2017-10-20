package com.bs.themebridge.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class AmountConversion {

	public static Logger logger = Logger.getLogger(ThemeBridgeUtil.class);

	public static void main(String[] args) {

		String result = "";
		// result = getAmountWithPadding("100.23"));// 000000000010023

		// result = getTransactionAmount("10023", "INR");
		// logger.debug(result);

		// result = generateTIPlus15DigitAmount(new BigDecimal("100.23"),
		// "INR");

//		String swiftAmount = "INR5000,00";
//		swiftAmount = swiftAmount.replace(",", ".");
//		System.out.println(swiftAmount);
//		AlphaNumericSegregation.getNumericalsWithDecimalComma(alphaNumeric)();
		
//		System.out.println(getAmountFromEventField("INR5000,00"));
//		System.out.println(getAmountFromEventField(swiftAmount));

		System.out.println(getAmountFromEventField("5000.00"));
		
		// logger.debug(result);

	}

	/**
	 * 01
	 * <p>
	 * Input : 100.23 <br>
	 * Output : 000000000010023
	 * </p>
	 * 
	 * @param amount
	 *            {@code allows }{@link String}
	 * @return {@code amount }
	 */
	public static String getAmountWithPadding(String amount) {
		String result = "";
		if (ValidationsUtil.isValidString(amount)) {
			amount = amount.replace(".", "");
			amount = amount.replace("-", "");
			if (amount.length() > 15) {
				result = amount.substring(0, 15);
			} else {
				String format = "%015d";
				result = String.format(format, new BigInteger(amount));
			}
		}
		return result;
	}

	/**
	 * 01
	 * <p>
	 * Input : 100.23 <br>
	 * Output : 0000000000100.23
	 * </p>
	 * 
	 * @param amount
	 * @return
	 */
	public static String getPaddingLength(String amount) {
		String result = "";
		String format = "";
		if (amount.indexOf('.') < 0) {
			format = "%015d";
			result = String.format(format, new BigInteger(amount));
		} else {
			String decimals = amount.substring(amount.indexOf('.') + 1).length() + "";

			format = "%015." + decimals + "f";
			Float floatNumber = Float.parseFloat(amount);
			result = String.format(format, floatNumber);
		}
		return result;
	}

	/**
	 * <p>
	 * Input : 10023 <br>
	 * Output : 100.23
	 * </p>
	 * 
	 * @param amount
	 *            {@code allows }{@link String}
	 * @param currency
	 *            {@code allows }{@link String}
	 * @return {@link String}
	 */
	public static String getTransactionAmount(String amount, String currency) {

		String result = "";
		BigDecimal transAmount = new BigDecimal(amount);

		if (currency.equals("OMR") || currency.equals("BHD") || currency.equals("KWD") || currency.equals("JOD")) {
			result = transAmount.divide(new BigDecimal(1000), 3, RoundingMode.CEILING).toString();

		} else if (currency.equals("JPY")) {
			result = amount;

		} else {
			result = transAmount.divide(new BigDecimal(100), 2, RoundingMode.CEILING).toString();
		}

		return result.trim();
	}

	/**
	 * <p>
	 * Input : 10023 <br>
	 * Output : 100.23
	 * </p>
	 * 
	 * @param amount
	 *            {@code allows }{@link String}
	 * @param ccy
	 *            {@code allows }{@link String}
	 * @return {@link String}
	 */
	public static String convertAmountFromTIPlus(String amount, String ccy) {

		BigDecimal bg = new BigDecimal("0");
		if (ValidationsUtil.isValidString(amount) && ValidationsUtil.isValidString(ccy)
				&& (ccy.equals("OMR") || ccy.equals("BHD") || ccy.equals("KWD"))) {
			bg = new BigDecimal(amount);
			bg = bg.divide(new BigDecimal(1000));

		} else if (ValidationsUtil.isValidString(amount) && ValidationsUtil.isValidString(ccy) && ccy.equals("JPY")) {
			bg = new BigDecimal(amount);

		} else if (ValidationsUtil.isValidString(amount) && ValidationsUtil.isValidString(ccy)) {
			bg = new BigDecimal(amount);
			bg = bg.divide(new BigDecimal(100));
		}
		// logger.info("convertAmountFromTIPlus :\t" + bg.toString());
		return bg.toString();
	}

	/**
	 * 
	 * @param bg
	 * @param ccy
	 * @return
	 */
	public static String generateTIPlus15DigitAmount(BigDecimal bg, String ccy) {

		String amount = "";
		if (ValidationsUtil.isValidObject(bg) && ValidationsUtil.isValidString(ccy)
				&& (ccy.equals("OMR") || ccy.equals("BHD") || ccy.equals("KWD"))) {
			bg = bg.multiply(new BigDecimal(1000));

		} else if (ValidationsUtil.isValidString(ccy) && ccy.equals("JPY")) {

		} else {
			bg = bg.multiply(new BigDecimal(100));
		}

		amount = bg.toBigInteger().toString();

		// String avail = getAvaiBalanceBalance(bg);
		// logger.debug(avail);

		// String result = getAmountWithPadding(avail);
		// logger.debug(result);

		return amount;
	}

	/*********************************/

	// branchCode = branchCode.replaceFirst("^0+(?!$)", "");

	/**
	 * PRASATH R
	 * 
	 * @since 2016-Aug-09
	 * @param amt
	 * @return
	 */
	public static BigDecimal getAmountValuesRTGS(String checkAmountValue) {

		BigDecimal result = null;
		try {
			if (ValidationsUtil.isValidString(checkAmountValue)) {
				checkAmountValue = checkAmountValue.replace(",", "");
				checkAmountValue = checkAmountValue.replaceAll("\\s+", "");
				checkAmountValue = checkAmountValue.replaceAll("[^0-9 , .]", "");
				result = new BigDecimal(checkAmountValue);
			}

		} catch (Exception e) {
			logger.debug("Exception e");
		}
		return result;
	}

	/**
	 * Wrong Method output
	 * 
	 * @param amt
	 * @return
	 */
	public static int getAmountValuesOld(String amt) {

		int amount = 0;
		String result = amt;

		if (result == null) {
			return amount;
		}
		result = result.replaceAll("[^0-9]", "");
		amount = Integer.parseInt(result);
		return amount;
	}

	/**
	 * 
	 * @param amountWithCcy
	 * @return
	 */
	public static int getAmount(String amountWithCcy) {

		int amount = 0;
		// Match int or float
		Pattern pattern = Pattern.compile("\\d+(?:\\.\\d+)?");
		// String str = null;
		Matcher matcher = pattern.matcher(amountWithCcy);
		if (matcher.find()) {
			logger.debug(matcher.group());
		}

		return amount;
	}

	/**
	 * 
	 * @param amt
	 * @return
	 */
	public static String getAmountFromEventField(String amtCcy) {

		String result = amtCcy;
		if (result == null) {
			return result;
		}
		result = result.replaceAll("[^0-9]", "");
		return result;
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
		result = result.replaceAll("[^a-zA-Z]", "");
		return result;
	}
	/*********************************/

	/**
	 * INPUT 1,000.00 USD OUTPUT 1000
	 * 
	 * @param amount
	 *            {@code allows } {@link String}
	 * @return
	 */
	public static String getAmountValues(String amount) {

		String result = "";
		amount = amount.replace(",", "");
		amount = amount.replaceAll("\\s+", "");
		amount = amount.replaceAll("[^0-9 , .]", "");
		// BigDecimal result = new BigDecimal(amount);
		result = amount;

		return result;
	}

	/**
	 * Convert amount format string to number format string
	 * <i> {@code i.e., 123,456.00 as 123456.00 } </i>
	 * 
	 * @param numberString
	 *            {@code allows } {@link String}
	 * @return {@link String}
	 */
	public static String convertAmountStringToNumberStringFormat(String numberString) {
		if (ValidationsUtil.isValidString(numberString)) {
			numberString = numberString.replace(",", "");
		}
		return numberString;
	}

	/**
	 * Convert amount format string to number format string
	 * <i> {@code i.e., 123,456.00 as 12345600 } </i>
	 * 
	 * @param numberString
	 *            {@code allows } {@link String}
	 * @return {@link String}
	 */
	public static String removeAmountStringDotAndCommaSpecification(String numberString) {
		if (ValidationsUtil.isValidString(numberString)) {
			numberString = removeAmountStringDotSpecification(numberString);
			numberString = removeAmountStringCommaSpecification(numberString);
		}
		return numberString;
	}

	/**
	 * Convert amount format string to number format string
	 * <i> {@code i.e., 123,456.00 as 12,345600 } </i>
	 * 
	 * @param numberString
	 *            {@code allows } {@link String}
	 * @return {@link String}
	 */
	public static String removeAmountStringDotSpecification(String numberString) {
		if (ValidationsUtil.isValidString(numberString)) {
			Double amount = Double.parseDouble(numberString);
			amount = (amount * 100);
			numberString = new DecimalFormat("0.00").format(amount);
			if (numberString.contains(".") && numberString.indexOf(".") != 0) {
				numberString = numberString.substring(0, numberString.indexOf("."));
			} else {
				// do nothing
			}
		}
		return numberString;
	}

	/**
	 * Convert amount format string to number format string
	 * <i> {@code i.e., 123,456.00 as 123456.00 } </i>
	 * 
	 * @param numberString
	 *            {@code allows } {@link String}
	 * @return {@link String}
	 */
	public static String removeAmountStringCommaSpecification(String numberString) {
		if (ValidationsUtil.isValidString(numberString)) {
			if (numberString.contains(",") && numberString.indexOf(",") != 0) {
				numberString = numberString.replace(",", "");
			} else {
				// do nothing
			}
		}
		return numberString;
	}

	/**
	 * Pad with "0" and make the out put string to contain 15chars. handles
	 * decimals of currency based on the input.
	 */
	public static String getAmountWithPadding(String amount, String paddingLength) {
		String result = "";
		String format = "";
		if (amount.indexOf('.') < 0) {
			format = "%0" + paddingLength + "d";
			result = String.format(format, new BigInteger(amount));
		} else {
			String decimals = amount.substring(amount.indexOf('.') + 1).length() + "";
			format = "%0" + paddingLength + "." + decimals + "f";
			Float floatNumber = Float.parseFloat(amount);
			result = String.format(format, floatNumber);
		}
		return result;
	}

	/**
	 * Check double amount with two precision <br>
	 * Note: This function do DecimalFormat calculation </br>
	 * 
	 * @return {@link String}
	 */
	public static Double getAmountAsDoubleWithTwoPrecision(Double value) {
		Double aDouble = Double.parseDouble(new DecimalFormat("0.00").format(value));
		return aDouble;
	}

	/**
	 * Check double amount with custom precision <br>
	 * Note: This function do DecimalFormat calculation </br>
	 * 
	 * @return {@link String}
	 */
	public static Double getAmountAsDoubleWithCustomPrecision(Double value, int decimalPrecision) {
		String decimal = "0.";
		if (ValidationsUtil.isValidObject(decimalPrecision)) {
			for (int i = 0; i < decimalPrecision; i++) {
				decimal += "0";
			}
		}
		Double aDouble = Double.parseDouble(new DecimalFormat(decimal).format(value));
		return aDouble;
	}

	/**
	 * Check double amount with two precision <br>
	 * Note: This function do Math.round(*) calculation </br>
	 * 
	 * @return {@link String}
	 */
	public static Double getAmountWithTwoPrecision(Double value) {
		Double aDouble = Math.round(value * 100.0) / 100.0;
		return aDouble;
	}

	/**
	 * Check double amount with custom precision <br>
	 * Note: This function do Math.round(*) calculation </br>
	 * 
	 * @return {@link String}
	 */
	public static Double getAmountWithCustomPrecision(Double value, int decimalPrecision) {
		Double denominator = 1d;
		if (ValidationsUtil.isValidObject(decimalPrecision)) {
			String amount = "1";
			for (int i = 1; i <= decimalPrecision; i++) {
				amount += "0";
			}
			logger.info("Amount : " + amount);
			denominator = denominator * Double.parseDouble(amount);
		}
		logger.info("Denominator : " + denominator);
		Double aDouble = Math.round(value * denominator) / denominator;
		return aDouble;
	}
}
