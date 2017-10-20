package com.bs.themebridge.util;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

/**
 * This class contains exclusively public methods and static that operate on or
 * return data type.
 * <p>
 * Utility for the conversion of data types
 * 
 * @author Periyasamy
 * 
 */
public class BridgeAction {

	private final static Logger logger = Logger.getLogger(BridgeAction.class);

	/**
	 * Method StringtoDate
	 * 
	 * Convert from String to Date
	 * 
	 * @param name
	 *            : Incoming Date in a String
	 * @return Date
	 */
	public static Date StringtoDate(String name) {

		java.sql.Date convertedDate = null;
		try {
			SimpleDateFormat aSdfWithoutTimestamp = new SimpleDateFormat("dd/MM/yyyy");
			convertedDate = new java.sql.Date(aSdfWithoutTimestamp.parse(name).getTime());
			logger.debug("Converted Date ->" + convertedDate);
		} catch (Exception e) {
			logger.error("Exception : " + e);
			e.printStackTrace();
		}
		return convertedDate;
	}

	/**
	 * Method StringtoDecimal
	 * 
	 * Convert String to Double
	 * 
	 * @param name
	 *            : Incoming Double value in a String
	 * @return Double
	 */
	public static Double StringtoDecimal(String name) {
		Double aDouble;
		try {
			// dl = Double.parseDouble(name);
			aDouble = new Double(name);
		} catch (Exception e) {
			logger.error("Exception : " + e);
			return 0.0;
		}
		return aDouble;
	}

	/**
	 * Method StringtoInt
	 * 
	 * Convert String to Integer
	 * 
	 * @param name
	 *            :Incoming int in a String
	 * @return Integer
	 */

	public static int StringtoInt(String name) {
		int aint = 0;
		try {
			aint = Integer.parseInt(name);

		} catch (Exception e) {
			logger.error("Exception : " + e);
			e.printStackTrace();
		}
		return aint;
	}

	/**
	 * Method convertEnigma
	 * 
	 * Convert String to Enigma
	 * 
	 * @param EnigmaValue
	 *            :Input enigma value as a String
	 * @return Enigma value
	 */
	public static String convertEnigma(String EnigmaValue) {

		if (EnigmaValue.equals("0")) {
			return "false";
		} else {
			return "true";
		}

	}

	/**
	 * Method StringtoLong
	 * 
	 * Convert String to Long
	 * 
	 * @param name
	 *            : Input Long value as a String
	 * @return Long value
	 */
	public static Long StringtoLong(String name) {
		Long aint = 0L;
		try {
			aint = Long.parseLong(name);

		} catch (Exception e) {
			logger.error("Exception : " + e);
			e.printStackTrace();
		}
		return aint;
	}

	/**
	 * Method StringtoBigDecimal
	 * 
	 * Convert String to BigDecimal
	 * 
	 * @param name
	 *            :Input BigDecimal value as a String
	 * @return BigDecimal value
	 */
	public static BigDecimal StringtoBigDecimal(String name) {

		BigDecimal bigDecimal = null;
		try {
			bigDecimal = new BigDecimal(name);

		} catch (Exception e) {
			logger.error("Exception : " + e);
			e.printStackTrace();
		}
		return bigDecimal;
	}

	/**
	 * Method LongtoString
	 * 
	 * Convert Long to String
	 * 
	 * @param value
	 *            : Input value as a Long
	 * @return String
	 */
	public static String LongtoString(Long value) {
		String result = String.valueOf(value);

		return result;
	}

	/**
	 * Method getCurrentDate
	 * 
	 * Getting current Date
	 * 
	 * @return String
	 */
	public static String getCurrentDate() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date date = new java.util.Date();

		return dateFormat.format(date);
	}

	/**
	 * Method getCurrentDateTime
	 * 
	 * Getting Current Date and Time
	 * 
	 * @return DateTime
	 */
	public static java.util.Date getCurrentDateTime() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		java.util.Date date = new java.util.Date();
		return date;

	}

	/**
	 * Method removeDateSlash
	 * 
	 * replace / with ""
	 * 
	 * @return String
	 */

	public static String removeDateSlash(String value) {
		if (value == null)
			return value;
		value = value.replace("/", "x");
		value = value.replace("x", "");
		value = BridgeAction.removeDateDash(value);
		return value;
	}

	/**
	 * Method removeDateDash
	 * 
	 * replace - with ""
	 * 
	 * @return String
	 */

	public static String removeDateDash(String value) {

		if (value == null)
			return value;
		value = value.replace("-", "x");
		value = value.replace("x", "");

		return value;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String integerToString(Integer number) {

		String stringValue = null;
		if (ValidationsUtil.isValidObject(number)) {
			stringValue = String.valueOf(number);
		}
		return stringValue;
	}

	public static Integer StringtoIntConversion(String name) {

		if (name == null) {
			return null;
		}

		Integer aint = 0;

		try {
			aint = new Integer(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return aint;

	}

	/**
	 * Convert String to Long
	 * 
	 * @param name
	 *            : Input Long value as a String
	 * @return Long value
	 */
	public static Long StringtoLongConversion(String name) {
		Long aint = 0L;
		try {
			aint = Long.parseLong(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return aint;
	}

	/**
	 * <p>
	 * Converts an object to JSON
	 * </p>
	 * <p>
	 * If {@code obj} is null or not a valid Object, returns a empty
	 * {@link String}
	 * </p>
	 * 
	 * @param obj
	 *            {@code allows any }{@link Object}
	 * @return {@link String}
	 */
	public static String convertObjectToJSON(Object obj) {
		String jsonText = "";
		if (ValidationsUtil.isValidObject(obj)) {
			Gson gson = new Gson();
			jsonText = gson.toJson(obj);
		} else {
			// logger.error("Function convertObjectToJSON argument contains Null
			// value");
		}

		return jsonText;
	}

	/**
	 * <p>
	 * Converts an object to JSON
	 * </p>
	 * <p>
	 * If {@code obj} is null or not a valid Object, returns a empty
	 * {@link String}
	 * </p>
	 * 
	 * @param gson
	 *            {@code allows any }{@link Object}
	 * @param obj
	 *            {@code allows any }{@link Object}
	 * 
	 * @return {@link String}
	 */
	public static String convertObjectToJSON(Gson gson, Object obj) {
		String jsonText = "";
		if (ValidationsUtil.isValidObject(obj)) {
			if (!ValidationsUtil.isValidObject(gson)) {
				gson = new Gson();
			}
			jsonText = gson.toJson(obj);
		} else {
			// logger.error("Function convertObjectToJSON argument contains Null
			// value");
		}

		return jsonText;
	}

	/**
	 * <p>
	 * Converts JSON to an object
	 * </p>
	 * 
	 * <p>
	 * If {@code jsonText} is null or empty {@link String}, returns a empty
	 * {@link Object}
	 * </p>
	 * 
	 * @param jsonText
	 *            {@code allows }{@link String}
	 * @param obj
	 *            {@code allows any }{@link Object}
	 * @return {@link Object}
	 */
	public static Object convertJsonToObject(String jsonText, Object obj) {
		if (ValidationsUtil.isValidString(jsonText) && ValidationsUtil.isValidObject(obj)) {
			Gson gson = new Gson();
			// logger.debug("Function convertJsonToObject arguments : " + obj);
			obj = gson.fromJson(jsonText, Object.class);
		} else {
			// logger.error("Function convertJsonToObject arguments contains
			// Null value");
		}

		return obj;
	}

}
