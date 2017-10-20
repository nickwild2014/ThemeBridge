package com.bs.themebridge.util;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * @since 2016-SEP-22
 * @version 1.0.1
 * @author <code>Prasath Ravichandran</code>
 */
public class ValidationsUtil {

	private final static Logger logger = Logger.getLogger(ValidationsUtil.class.getName());

	/**
	 * Checks the given string is valid
	 * 
	 * @param string
	 *            {@code allows }{@link String}
	 * @return {@link Boolean}
	 */
	public static boolean isValidString(String checkValue) {
		boolean result = false;
		if (checkValue != null && !checkValue.trim().isEmpty())
			result = true;
		return result;
	}

	/**
	 * Checks the given object is valid
	 * 
	 * @param object
	 *            {@code allows any }{@link Object}
	 * @return {@link Boolean}
	 */
	public static boolean isValidObject(Object object) {
		if (object == null)
			return false;
		return true;
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public static String checkIsNull(String value) {
		try {
			value = value.trim();
			if (value.equals(null) || value == null || value.length() < 1) {
				return "";
			} else {
				return value;
			}
		} catch (NullPointerException e) {
			return "";
		}

	}

	/**
	 * Checks the given number is valid
	 * 
	 * @param str
	 *            {@code allows any }{@link String}
	 * @return {@link Boolean}
	 */
	public static boolean isValidNumber(String str) {
		String s = str;
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isDigit(s.charAt(i)))
				return false;
		}
		return true;
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {

		try {
			for (char c : str.toCharArray()) {
				if (!Character.isDigit(c))
					return false;
			}
		} catch (Exception e) {
			logger.error("isNumeric ? exception..!! " + e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param str
	 *            {@code allows any }{@link String}
	 * @return {@link Boolean}
	 */
	public static boolean isValidNumber2(String str) {

		boolean b = str.matches("^[+-]?(?=.)\\d*(\\.\\d+)?$");
		return b;
	}

	/**
	 * Checks the given list is valid
	 * 
	 * @param list
	 *            {@code allows }{@link List}
	 * @return {@link Boolean}
	 */
	public static boolean isValidList(List list) {
		if (isValidObject(list) && list.size() > 0)
			return true;
		return false;
	}

	/**
	 * Checks the given amount is valid and greater than 0.00
	 * 
	 * @param amountValue
	 *            {@code allows }{@link Double}
	 * @return {@link Boolean}
	 */
	public static boolean isValidAmount(Double amountValue) {
		if (isValidObject(amountValue) && amountValue > 0.00)
			return true;
		return false;
	}

	/**
	 * Checks the object valid and returns the same else returns null value
	 * 
	 * @param objectToCheck
	 *            {@code allows }{@link Object}
	 * @return {@link Object}
	 */
	public static Object getValidObject(Object objectToCheck) {
		return ValidationsUtil.isValidObject(objectToCheck) ? objectToCheck : null;
	}

	/**
	 * Checks the string has value and returns the same else returns "" value
	 * 
	 * @param stringToCheck
	 *            {@code allows }{@link String}
	 * @return {@link String}
	 */
	public static String getValidStringValue(String stringToCheck) {
		return ValidationsUtil.isValidString(stringToCheck) ? stringToCheck.trim() : "";
	}

	/**
	 * Checks the string has value and returns the same else returns
	 * 'stringToAssign' value
	 * 
	 * @param stringToCheck
	 *            {@code allows }{@link String}
	 * @param stringToAssign
	 *            {@code allows }{@link String}
	 * 
	 * @return {@link String}
	 */
	public static String getValidStringValue(String stringToCheck, String stringToAssign) {
		return ValidationsUtil.isValidString(stringToCheck) ? stringToCheck.trim()
				: getValidStringValue(stringToAssign);
	}

	/**
	 * Checks the given amount is valid and 0.00
	 * 
	 * @param amountValue
	 *            {@code allows }{@link Double}
	 * @return {@link Boolean}
	 */
	public static boolean isAmountValid(Double amountValue) {
		if (isValidObject(amountValue) && amountValue == 0.00)
			return true;
		return false;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		String str = "-122A";
		boolean b = isValidNumber(str);
		logger.debug(b);

		boolean b2 = isValidNumber2(str);
		logger.debug(b2);
	}

}
