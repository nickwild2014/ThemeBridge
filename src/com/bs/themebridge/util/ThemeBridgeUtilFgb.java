package com.bs.themebridge.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import org.xml.sax.InputSource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.misys.tiplus2.services.control.ServiceRequest;
import com.misys.tiplus2.services.control.ServiceResponse;

public class ThemeBridgeUtilFgb {

	private final static Logger logger = Logger.getLogger(ThemeBridgeUtilFgb.class.getName());
	public static Properties property = null;
	public static Properties fileProperty = null;
	public static Properties clientProperty = new Properties();

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
	 * Checks the given string is valid
	 * 
	 * @param string
	 *            {@code allows }{@link String}
	 * @return {@link Boolean}
	 */
	public static boolean isValidString(String string) {
		if (string == null || "".equalsIgnoreCase(string))
			return false;

		return true;
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
	 * Changing / Converting long amount to double amount with two precision
	 * 
	 * @param amountValue
	 *            {@code allows }{@link Long}
	 * @param decimalPrecision
	 *            {@code allows } {@link String}
	 * 
	 * @return {@link Double}
	 */
	public static Double changeLongToDoubleWithTwoPrecision(Long amountValue, String decimalPrecision) {
		Double result = 0.00;
		if (isValidObject(amountValue)) {
			String amtString = amountValue.toString();
			if (decimalPrecision.equalsIgnoreCase("0")) {
				result = Double.parseDouble(amtString);
			} else if (decimalPrecision.equalsIgnoreCase("1")) {
				String charValue = ThemeBridgeUtil.getSubStringData(amtString, 0, amtString.length() - 1);
				String mantValue = ThemeBridgeUtil.getSubStringData(amtString, amtString.length() - 1,
						amtString.length());
				result = Double.parseDouble(charValue + "." + mantValue);
			} else if (decimalPrecision.equalsIgnoreCase("2")) {
				String charValue = ThemeBridgeUtil.getSubStringData(amtString, 0, amtString.length() - 2);
				String mantValue = ThemeBridgeUtil.getSubStringData(amtString, amtString.length() - 2,
						amtString.length());
				result = Double.parseDouble(charValue + "." + mantValue);
			} else if (decimalPrecision.equalsIgnoreCase("3")) {
				String charValue = ThemeBridgeUtil.getSubStringData(amtString, 0, amtString.length() - 3);
				String mantValue = ThemeBridgeUtil.getSubStringData(amtString, amtString.length() - 3,
						amtString.length());
				result = Double.parseDouble(charValue + "." + mantValue);
			} else {
				result = Double.parseDouble(amtString);
			}
		}
		return result;
	}

	/**
	 * Checks the object valid and returns the same else returns null value
	 * 
	 * @param objectToCheck
	 *            {@code allows }{@link Object}
	 * @return {@link Object}
	 */
	public static Object getValidObject(Object objectToCheck) {
		return isValidObject(objectToCheck) ? objectToCheck : null;
	}

	/**
	 * Checks the string has value and returns the same else returns "" value
	 * 
	 * @param stringToCheck
	 *            {@code allows }{@link String}
	 * @return {@link String}
	 */
	public static String getValidStringValue(String stringToCheck) {
		return isValidString(stringToCheck) ? stringToCheck.trim() : "";
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
		return isValidString(stringToCheck) ? stringToCheck.trim() : getValidStringValue(stringToAssign);
	}

	/**
	 * Get local date and time
	 * 
	 * @return {@link Date}
	 */
	public static Date getLocalTime() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return cal.getTime();
	}

	/**
	 * Get local date and time in yyMMdd
	 * 
	 * @return {@link String}
	 */
	public static String getLocalTimeInSwiftFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		return sdf.format(new Date());
	}

	/**
	 * Get date string in expected format
	 * 
	 * @return {@link String}
	 */
	public static String getStringDateInFormat(String date, String dateFormat, String expectedFormat) {
		SimpleDateFormat sdf = null;
		String result = "";
		if (isValidString(date)) {
			try {
				sdf = new SimpleDateFormat(dateFormat);
				Date aDate = sdf.parse(date);
				sdf = new SimpleDateFormat(expectedFormat);
				result = sdf.format(aDate);
			} catch (Exception e) {
				logger.error("Exception! Check the logs for details", e);
			}
		}
		return result;
	}

	/**
	 * Get date string in expected format
	 * 
	 * @return {@link String}
	 */
	public static String getStringDateForExtractionFileFormat(String date, String dateFormat, String expectedFormat) {
		SimpleDateFormat sdf = null;
		String result = "";
		if (isValidString(date)) {
			try {
				String aResult = "";
				sdf = new SimpleDateFormat(dateFormat);
				Date aDate = sdf.parse(date);
				sdf = new SimpleDateFormat(expectedFormat);
				aResult = sdf.format(aDate);
				Date bDate = new Date();
				String bResult = getDateInFormat(bDate, "HHmm");
				result = aResult.concat(bResult);
			} catch (Exception e) {
				logger.error("Exception! Check the logs for details", e);
			}
		}
		return result;
	}

	/**
	 * Get date string in expected format
	 * 
	 * @return {@link String}
	 */
	public static String getDateInFormat(Date date, String dateFormat) {
		SimpleDateFormat sdf = null;
		String result = "";
		if (isValidObject(date)) {
			try {
				sdf = new SimpleDateFormat(dateFormat);
				result = sdf.format(date);
			} catch (Exception e) {
				logger.error("Exception! Check the logs for details", e);
			}
		}
		return result;
	}

	/**
	 * Get local time
	 * 
	 * @return {@link String}
	 */
	public static String getLocalSystemTime() {
		String systemTime = getDateInFormat(new Date(), "hh:mm:ss");
		return systemTime;
	}

	/**
	 * Get local time with 24 hour format
	 * 
	 * @return {@link String}
	 */
	public static String getLocalSystemTimeFormat() {
		String systemTime = getDateInFormat(new Date(), "HH:mm:ss");
		return systemTime;
	}

	/**
	 * Get local date and time in SQL Timestamp
	 * 
	 * @return {@link Timestamp}
	 */
	public static Timestamp getLocalDateTime() {
		Date date = new Date();
		long t = date.getTime();
		Timestamp sqlTimestamp = new Timestamp(t);
		return sqlTimestamp;
	}

	/**
	 * Get local date and time in format 'yyyyMMddhhmmss'
	 * 
	 * @return {@link String}
	 */
	public static String getFormatLocalDateTime() {
		return getDateInFormat(getLocalDate(), "yyyyMMddHHmmssS");
	}

	/**
	 * Get local date and time in format 'yyyy-MM-dd HH:mm:ss.SSS' <br/>
	 * Used in storing the service request and response time in log
	 * 
	 * @return {@link String}
	 */
	public static String getRequestAuditTimeFormat() {
		return getDateInFormat(getLocalDate(), "yyyy-MM-dd HH:mm:ss.SSS");
	}

	/**
	 * Get local date and time in format 'dd-MM-yyyy HH:mm:ss.SSS' <br/>
	 * Used in storing the service request and response time in log
	 * 
	 * @return {@link String}
	 */
	public static String getEventRequestTimeFormat() {
		return getDateInFormat(getLocalDate(), "dd-MM-yyyy HH:mm:ss.SSS");
	}

	/**
	 * Get local date and time in format 'dd-MM-yyyy HH:mm:ss' <br/>
	 * Used in storing the service request and response time in log
	 * 
	 * @return {@link String}
	 */
	public static String getEventRequestTime() {
		return getDateInFormat(getLocalDate(), "dd-MM-yyyy HH:mm:ss");
	}

	/**
	 * Get local date
	 * 
	 * @return {@link Date}
	 */
	public static Date getLocalDate() {
		return new Date();
	}

	/**
	 * Get local date in XML Gregorian
	 * 
	 * @return {@link XMLGregorianCalendar}
	 * @throws Exception
	 */
	public static XMLGregorianCalendar getLocalDateInXMLGregorian() throws Exception {
		XMLGregorianCalendar result = null;

		try {
			Date dateTime = getLocalDate();
			Calendar cal = Calendar.getInstance();
			cal.setTime(dateTime);
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH);
			int date = cal.get(Calendar.DATE);

			result = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(year, month + 1, date,
					DatatypeConstants.FIELD_UNDEFINED);

		} catch (Exception e) {
			logger.error("Exception! Check the logs for details", e);
			throw new Exception(e.getMessage());
		}

		return result;
	}

	/**
	 * Get local date and time in XML Gregorian
	 * 
	 * @return {@link XMLGregorianCalendar}
	 * @throws Exception
	 */
	public static XMLGregorianCalendar getLocalDateTimeInXMLGregorian() throws Exception {
		XMLGregorianCalendar result = null;

		try {
			Date dateTime = getLocalDate();
			Calendar cal = Calendar.getInstance();
			cal.setTime(dateTime);
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH);
			int date = cal.get(Calendar.DATE);
			int hour = cal.get(Calendar.HOUR);
			int minute = cal.get(Calendar.MINUTE);
			int second = cal.get(Calendar.SECOND);

			result = DatatypeFactory.newInstance().newXMLGregorianCalendar(year, month + 1, date, hour, minute, second,
					DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED);

		} catch (Exception e) {
			logger.error("Exception! Check the logs for details", e);
			throw new Exception(e.getMessage());
		}

		return result;
	}

	/**
	 * Get local date in XML Gregorian
	 * 
	 * @param {@link
	 * 			Date}
	 * @return {@link XMLGregorianCalendar}
	 * @throws Exception
	 */
	public static XMLGregorianCalendar getDateInXMLGregorian(Date dateToBeConvert) throws Exception {
		XMLGregorianCalendar result = null;

		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(dateToBeConvert);
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH);
			int date = cal.get(Calendar.DATE);

			result = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(year, month + 1, date,
					DatatypeConstants.FIELD_UNDEFINED);

		} catch (Exception e) {
			logger.error("Exception! Check the logs for details", e);
			throw new Exception(e.getMessage());
		}

		return result;
	}

	/**
	 * Get local date and time in XML Gregorian
	 * 
	 * @param {@link
	 * 			Date}
	 * @return {@link Date}
	 * @throws Exception
	 */
	public static XMLGregorianCalendar getDateTimeInXMLGregorian(Date dateToBeConvert) throws Exception {
		XMLGregorianCalendar result = null;

		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(dateToBeConvert);
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH);
			int date = cal.get(Calendar.DATE);
			int hour = cal.get(Calendar.HOUR);
			int minute = cal.get(Calendar.MINUTE);
			int second = cal.get(Calendar.SECOND);

			result = DatatypeFactory.newInstance().newXMLGregorianCalendar(year, month + 1, date, hour, minute, second,
					DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED);

		} catch (Exception e) {
			logger.error("Exception! Check the logs for details", e);
			throw new Exception(e.getMessage());
		}

		return result;
	}

	/**
	 * Get data in XMLGregorian Calendar
	 * 
	 * @param dateString
	 *            {@code allows } {@link String}
	 * @param dateInFormat
	 *            {@code allows } {@link String}
	 * @return {@link XMLGragorianCalendar}
	 * @throws Exception
	 */
	public static XMLGregorianCalendar getDateStringInXMLGregorian(String dateString, String dateInFormat)
			throws Exception {
		XMLGregorianCalendar result = null;

		try {
			Date dateToBeConvert = getDateByDateAndFormat(dateString, dateInFormat);
			result = getDateInXMLGregorian(dateToBeConvert);
		} catch (Exception e) {
			logger.error("Exception! Check the logs for details", e);
			throw new Exception(e.getMessage());
		}

		return result;
	}

	/**
	 * Get local date and time in SQL Date
	 * 
	 * @return {@link java.sql.Date}
	 */
	public static java.sql.Date getSQLLocalDate() {
		Date date = new Date();
		long t = date.getTime();
		java.sql.Date sqlDate = new java.sql.Date(t);
		return sqlDate;
	}

	/**
	 * Get SQL Date by date string
	 * 
	 * @param date
	 *            {@code allows } {@link String}
	 * @param dateFormat
	 *            {@code allows } {@link String}
	 * 
	 * @return {@link java.util.Date}
	 */
	public static Date getDateByDateAndFormat(String dateStr, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			logger.error("Exception! Check the logs for details", e);
		}
		return date;
	}

	/**
	 * Get SQL Date by date string
	 * 
	 * @param date
	 *            {@code allows } {@link String}
	 * @param dateFormat
	 *            {@code allows } {@link String}
	 * 
	 * @return {@link java.sql.Date}
	 */
	public static java.sql.Date getSqlDateByDateAndFormat(String dateStr, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date date = null;
		java.sql.Date sqlDate = null;
		try {
			date = sdf.parse(dateStr);
			long t = date.getTime();
			sqlDate = new java.sql.Date(t);
		} catch (ParseException e) {
			logger.error("Exception! Check the logs for details", e);
		}
		return sqlDate;
	}

	/**
	 * Get SQL Date by date string
	 * 
	 * @param date
	 *            {@code allows } {@link String}
	 * @param dateFormat
	 *            {@code allows } {@link String}
	 * 
	 * @return {@link java.sql.Time}
	 */
	public static java.sql.Time getSqlTimeByDateAndFormat(String dateStr, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date date = null;
		java.sql.Time sqlDate = null;
		try {
			date = sdf.parse(dateStr);
			long t = date.getTime();
			sqlDate = new java.sql.Time(t);
		} catch (ParseException e) {
			logger.error("Exception! Check the logs for details", e);
		}
		return sqlDate;
	}

	/**
	 * Get local date and time in SQL Timestamp type
	 * 
	 * @param date
	 *            {@code allows } {@link String}
	 * @param dateFormat
	 *            {@code allows } {@link String}
	 * @return {@link Timestamp}
	 */
	public static Timestamp getTimeStampByDateAndFormat(String dateStr, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date date = null;
		Timestamp sqlTimestamp = null;
		try {
			date = sdf.parse(dateStr);
			long t = date.getTime();
			sqlTimestamp = new Timestamp(t);
		} catch (ParseException e) {
			logger.error("Exception! Check the logs for details", e);
		}
		return sqlTimestamp;
	}

	/**
	 * Reads content from a file
	 * 
	 * @param filePath
	 *            {@code allows } {@link String}
	 * @return {@link String}
	 * @throws Exception
	 */
	public static String readFile(String filePath) throws Exception {
		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = null;
		StringBuilder stringBuilder = new StringBuilder();
		String ls = System.getProperty("line.separator");
		try {
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			try {
				fileReader.close();
			} catch (Exception ex) {

			}
			try {
				bufferedReader.close();
			} catch (Exception ex) {

			}
		}

		return stringBuilder.toString();
	}

	/**
	 * Reads content from a file with CR LF tag
	 * 
	 * @param filePath
	 *            {@code allows } {@link String}
	 * @return {@link String}
	 * @throws Exception
	 */
	public static String readSwiftFile(String filePath) throws Exception {
		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = null;
		StringBuilder stringBuilder = new StringBuilder();
		String ls = "\r\n"; // CR/LF separator
		// System.getProperty("line.separator");
		try {
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			try {
				fileReader.close();
			} catch (Exception ex) {

			}
			try {
				bufferedReader.close();
			} catch (Exception ex) {

			}
		}

		return stringBuilder.toString();
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
		if (isValidObject(obj)) {
			Gson gson = new Gson();
			jsonText = gson.toJson(obj);
		} else {
			logger.error("Function convertObjectToJSON argument contains Null value");
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
		if (isValidObject(obj)) {
			if (!isValidObject(gson)) {
				gson = new Gson();
			}
			jsonText = gson.toJson(obj);
		} else {
			logger.error("Function convertObjectToJSON argument contains Null value");
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
		if (isValidString(jsonText) && isValidObject(obj)) {
			Gson gson = new Gson();
			obj = gson.fromJson(jsonText, obj.getClass());
		} else {
			logger.error("Function convertJsonToObject arguments contains Null value");
		}
		return obj;
	}

	/**
	 * Random ID/String used for CorrelationID in TI
	 * 
	 * @return {@link String}
	 */
	public static String randomCorrelationId() {
		return UUID.randomUUID().toString();
	}

	/**
	 * Random ID/String used for limit service requestid in ESB which allows
	 * only 18 character
	 * 
	 * @return {@link String}
	 */
	public static String randomLimitRequestId() {
		String result = randomCorrelationId().replace('-', '0');
		result = getSubStringData(result, 0, 18);
		return result;
	}

	/**
	 * Random ID/String used for any sequence
	 * 
	 * @return {@link String}
	 */
	public static String randomSeqeunceId() {
		String result = getSubStringData(randomCorrelationId(), 0, 5);
		return result;
	}

	/**
	 * Random ID/String used for limit service requestid in ESB which allows
	 * only 18 character
	 * 
	 * @return {@link String}
	 */
	public static String getLimitRequestId(String correlationid) {
		String result = correlationid.replace('-', '0');
		result = getSubStringData(result, 0, 18);
		return result;
	}

	/**
	 * Returns resubmit count increment with 1
	 * <p>
	 * <b>'countVal'</b> {@code should be numeric of type} {@link String}
	 * </p>
	 * 
	 * @param countVal
	 *            {@code allows} {@link String}
	 * 
	 * @return {@link String}
	 */
	public static String getReSubmitCount(String countVal) {
		String result = "";
		if (isValidString(countVal)) {
			Integer count = new Integer(countVal);
			if (isValidObject(count)) {
				result = (count + 1) + "";
			}
		} else {
			result = "1";
		}
		return result;
	}

	/**
	 * To get a key value from dummyFile.properties
	 * 
	 * @param keyName
	 *            {@code allows } {@link String}
	 * @return keyValue {@link String}
	 */
	public static String getFileProperties(String keyName) {
		if (!isValidObject(fileProperty)) {
			fileProperty = new Properties();
			InputStream inputStream = ThemeBridgeUtil.class.getClassLoader()
					.getResourceAsStream("bridgeFile.properties");
			try {
				fileProperty.load(inputStream);
				inputStream.close();
			} catch (Exception e) {
				logger.error("Load property exception! Check the logs for details", e);
			} finally {
				try {
					if (isValidObject(inputStream))
						inputStream.close();
				} catch (Exception e) {
					logger.error("Close property exception! Check the logs for details", e);
				}
			}
		}
		return fileProperty.getProperty(keyName);
	}

	/**
	 * To get a key value from dummyFile.properties
	 * 
	 * @param keyName
	 *            {@code allows } {@link String}
	 * @return keyValue {@link String}
	 */
	public static String getTransportClientProperties(String keyName) {
		clientProperty.clear();
		{
			InputStream inputStream = ThemeBridgeUtil.class.getClassLoader()
					.getResourceAsStream("ThemeTransportClient.properties");
			try {
				clientProperty.load(inputStream);
			} catch (Exception e) {
				logger.error("Load property exception! Check the logs for details", e);
			} finally {
				try {
					if (isValidObject(inputStream))
						inputStream.close();
				} catch (Exception e) {
					logger.error("Close property exception! Check the logs for details", e);
				}
			}
		}
		return clientProperty.getProperty(keyName);
	}

	/**
	 * Update file properties, dummy method dont use this
	 */
	public static void updateFileProperties(String keyName, String keyValue) {
		// {
		// FileInputStream in = new FileInputStream("First.properties");
		// Properties props = new Properties();
		// props.load(in);
		// in.close();
		//
		// FileOutputStream out = new FileOutputStream("First.properties");
		// props.setProperty("country", "america");
		// props.store(out, null);
		// out.close();
		// }
	}

	/**
	 * To get a key value from productevent.properties
	 * 
	 * @param productEventConcatValue
	 *            {@code allows } {@link String}
	 * @return keyValue {@link String}
	 */
	public static String getProductEventOrigCodeFromProperties(String productEventConcatValue) {
		if (!isValidObject(property)) {
			property = new Properties();
			InputStream inputStream = ThemeBridgeUtil.class.getClassLoader()
					.getResourceAsStream("prodevent.properties");
			try {
				property.load(inputStream);
			} catch (IOException e) {
				logger.error("Exception! Check the logs for details", e);
			} catch (NullPointerException e) {
				logger.error("Exception! Check the logs for details", e);
			} catch (Exception e) {
				logger.error("Exception! Check the logs for details", e);
			} finally {
				try {
					inputStream.close();
				} catch (Exception e) {
					logger.error("Exception! Check the logs for details", e);
				}
			}
		}
		return property.getProperty(productEventConcatValue);
	}

	/**
	 * To convert Response XML to String, JAXBContext of ServiceResponse
	 * 
	 * @param serviceResponse
	 *            {@code allows } {@link ServiceResponse}
	 * 
	 * @return {@link String}
	 */
	public static String convertRequesXMLToString(ServiceRequest serviceRequest) {
		String result = "";
		JAXBContext context = null;
		try {
			context = JAXBInstanceInitialiser.getServiceRequestContext();
			result = JAXBTransformUtil.doMarshalling(context, serviceRequest);
		} catch (Exception exp) {
			logger.error("Exception! Check the logs for details", exp);
		}
		return result;
	}

	/**
	 * To convert Response XML to String, JAXBContext of ServiceResponse
	 * 
	 * @param serviceResponse
	 *            {@code allows } {@link ServiceResponse}
	 * 
	 * @return {@link String}
	 */
	public static String convertResponseXMLToString(ServiceResponse serviceResponse) {
		String result = "";
		JAXBContext context = null;
		try {
			context = JAXBInstanceInitialiser.getServiceResponseContext();
			result = JAXBTransformUtil.doMarshalling(context, serviceResponse);
		} catch (Exception exp) {
			logger.error("Exception! Check the logs for details", exp);
		}
		return result;
	}

	/**
	 * To do marshalling of JAXBObject and returns as string
	 * 
	 * @param context
	 *            {@code allows object of } {@link JAXBContext}
	 * @param toDoObject
	 *            {@code allows object of } {@link ServiceRequest}
	 * @return {@link String}
	 */
	public static String doMarshalling(JAXBContext context, Object toDoObject) {
		String result = "";
		if (ValidationsUtil.isValidObject(toDoObject)) {
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			try {
				Marshaller jaxbMarshaller = context.createMarshaller();
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				jaxbMarshaller.marshal(toDoObject, outStream);
				result = outStream.toString();
			} catch (Exception exp) {
				logger.error(exp);
			} finally {
				try {
					outStream.close();
				} catch (IOException e) {
					logger.error("Exception! Check the logs for details", e);
				}
			}
		} else {
			logger.debug("Marshalling object is not valid");
		}
		return result;
	}

	/**
	 * To write swift out message in text file and store in it local path
	 * 
	 * @param filePath
	 *            {@code allows } {@link String}
	 * @param messageToBeWrite
	 *            {@code allows } {@link String}
	 * 
	 * @return {@link boolean}
	 */
	public static boolean writeFile(String filePath, String messageToBeWrite) {
		boolean isSucceed = false;
		Writer output = null;
		File file = null;
		try {
			file = new File(filePath);
			output = new BufferedWriter(new FileWriter(file));
			if (isValidString(messageToBeWrite)) {
				output.write(messageToBeWrite);
			}
			isSucceed = true;
			logger.debug(" File has been written in " + filePath + " ");
		} catch (Exception ex) {
			logger.error("Exception! Check the logs for detail", ex);
			isSucceed = false;
		} finally {
			try {
				if (output != null)
					output.close();
			} catch (IOException e) {
				logger.error("Exception! Check the logs for details", e);
			}
		}
		return isSucceed;
	}

	/**
	 * To write swift out message in text file and store in it local path
	 * 
	 * @param filePath
	 *            {@code allows } {@link String}
	 * @param fileName
	 *            {@code allows } {@link String}
	 * @param messageToBeWrite
	 *            {@code allows } {@link String}
	 * 
	 * @return {@link boolean}
	 */
	public static boolean writeFile(String filePath, String fileName, String messageToBeWrite) {
		boolean isSucceed = false;
		Writer output = null;
		File file = null;
		try {

			file = new File(filePath + fileName + "_" + randomSeqeunceId());

			// file = new File(filePath + fileName);
			// if (file.exists()) {
			// file = new File(filePath + fileName + "_" + randomSeqeunceId());
			// }

			output = new BufferedWriter(new FileWriter(file));
			if (isValidString(messageToBeWrite)) {
				/**
				 * Added to append the CR LF character in swift messages -
				 * Updated on 20150809
				 */
				messageToBeWrite = messageToBeWrite.replace("\n", "\r\n");
				output.write(messageToBeWrite);
			}
			isSucceed = true;
		} catch (Exception ex) {
			logger.error("Exception! Check the logs for detail", ex);
			isSucceed = false;
		} finally {
			try {
				output.close();
			} catch (IOException e) {
				logger.error("Exception! Check the logs for details", e);
			}
		}
		return isSucceed;
	}

	/**
	 * To write swift out message in text file and store in it local path
	 * 
	 * @param filePath
	 *            {@code allows } {@link String}
	 * @param fileName
	 *            {@code allows } {@link String}
	 * @param messageToBeWrite
	 *            {@code allows } {@link String}
	 * 
	 * @return {@link boolean}
	 */
	public static boolean writeFile(String filePath, String fileName, String eventNumber, String messageToBeWrite) {
		boolean isSucceed = false;
		Writer output = null;
		File file = null;
		try {
			file = new File(filePath + fileName);
			if (file.exists()) {
				file = new File(filePath + fileName + "_" + eventNumber);
			}

			output = new BufferedWriter(new FileWriter(file));
			if (isValidString(messageToBeWrite)) {
				// output.write(messageToBeWrite.trim());
				// logger.debug("Message before write "
				// + messageToBeWrite);
				/**
				 * Added to append the CR LF character in swift messages -
				 * Updated on 20150809
				 */
				messageToBeWrite = messageToBeWrite.replace("\n", "\r\n");

				// logger.debug("Message after write "
				// + messageToBeWrite);
				output.write(messageToBeWrite);
			}
			isSucceed = true;
		} catch (Exception ex) {
			logger.error("Exception! Check the logs for detail", ex);
			isSucceed = false;
		} finally {
			try {
				output.close();
			} catch (IOException e) {
				logger.error("Exception! Check the logs for details", e);
			}
		}
		return isSucceed;
	}

	/**
	 * To delete a file which stored in it local system
	 * 
	 * @param filePath
	 *            {@code allows } {@link String}
	 * 
	 * @return {@link boolean}
	 */
	public static boolean deleteFile(String filePath) {
		boolean isSucceed = false;
		File file = null;
		try {
			file = new File(filePath);
			if (file.exists()) {
				file.delete();
			}
			isSucceed = true;
		} catch (Exception ex) {
			logger.error("Exception! Check the logs for detail", ex);
			isSucceed = false;
		} finally {
			// TODO
		}
		return isSucceed;
	}

	/**
	 * To convert XMLGregorianCalendar to string value
	 * <p>
	 * <code>
	 * Note: this function returns date as long in string format   
	 * </code>
	 * </p>
	 * 
	 * @param xmlGCDate
	 *            {@link XMLGregorianCalendar}
	 * @return {@link String}
	 * @throws ParseException
	 * @throws DatatypeConfigurationException
	 */
	public static String xmlGregorianCalendarToString(XMLGregorianCalendar xmlGCDate) {
		String result = "";
		if (isValidObject(xmlGCDate)) {
			Calendar calendar = xmlGCDate.toGregorianCalendar();
			Date date = calendar.getTime();
			result = date.getTime() + "";
		}
		return result;
	}

	/**
	 * To convert XMLGregorianCalendar to string value
	 * <p>
	 * <code>
	 * Note: this function returns date as long in string format   
	 * </code>
	 * </p>
	 * 
	 * @param xmlGCDate
	 *            {@link XMLGregorianCalendar}
	 * @return {@link String}
	 * @throws ParseException
	 * @throws DatatypeConfigurationException
	 */
	public static String xmlGregorianCalendarToStringWithFormat(XMLGregorianCalendar xmlGCDate, String dateFormat) {
		String result = "";
		if (isValidObject(xmlGCDate)) {
			Calendar calendar = xmlGCDate.toGregorianCalendar();
			Date date = calendar.getTime();
			result = getDateInFormat(date, dateFormat);
		}
		return result;
	}

	/**
	 * To convert XMLGregorianCalendar to string value
	 * <p>
	 * <code>
	 * Note: this function returns date as long in string format   
	 * </code>
	 * </p>
	 * 
	 * @param xmlGCDate
	 *            {@link XMLGregorianCalendar}
	 * @return {@link String}
	 * @throws ParseException
	 * @throws DatatypeConfigurationException
	 */
	public static String xmlGregorianCalendarToString(XMLGregorianCalendar xmlGCDate, String dateFormat) {
		String result = "";
		if (isValidObject(xmlGCDate)) {
			Calendar calendar = xmlGCDate.toGregorianCalendar();
			Date date = calendar.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			result = sdf.format(date);
		}
		return result;
	}

	/**
	 * To convert Local XMLGregorianCalendar to string value
	 * <p>
	 * <code>
	 * Note: this function returns date as long in string format   
	 * </code>
	 * </p>
	 * 
	 * @param xmlGCDate
	 *            {@code allows } {@link XMLGregorianCalendar}
	 * @return {@link String}
	 * @throws Exception
	 * @throws ParseException
	 * @throws DatatypeConfigurationException
	 */
	public static String getXmlGregorianCalendarLocalTimeToString() throws Exception {
		String result = "";
		if (isValidObject(getLocalDateTimeInXMLGregorian())) {
			Calendar calendar = getLocalDateTimeInXMLGregorian().toGregorianCalendar();
			Date date = calendar.getTime();
			result = date.getTime() + "";
		}
		return result;
	}

	/**
	 * Get accountabode value with pipe separator by account
	 * 
	 * @param accountNumber
	 * @return {@link String}
	 */

	/**
	 * Parsing pipe separator content into array
	 * 
	 * @param pipeConcatenatedString
	 *            {@code allows } {@link String}
	 * @return {@link String}
	 */
	public static String[] parsePipeSeparatorIntoArray(String pipeConcatenatedString) {
		String[] resultArray = null;
		if (isValidString(pipeConcatenatedString)) {
			resultArray = pipeConcatenatedString.split("\\|");
		}
		return resultArray;
	}

	/**
	 * Separate the string with seperator
	 * 
	 * @param inputString
	 *            {@code allows } {@link String}
	 * @param separatorCode
	 *            {@code allows } {@link String}
	 * 
	 * @return {@link String}
	 */
	public static String[] parseStringSeparatorIntoArray(String inputString, String separatorCode) {
		String[] resultArray = null;
		if (isValidString(inputString)) {
			resultArray = inputString.split(separatorCode);
		}
		return resultArray;
	}

	/**
	 * Check the status of T24 posting
	 * 
	 * @param statusCode
	 *            {@code allows } {@link String}
	 * @return {@link boolean}
	 */
	public static boolean checkT24PostingStatus(String statusCode) {
		boolean isSucceed = false;
		if (isValidString(statusCode)) {
			if (statusCode.indexOf("0") != -1 || statusCode.indexOf("2") != -1)
				isSucceed = false;
			else
				isSucceed = true;
		}
		return isSucceed;
	}

	/**
	 * To convert string of DateTime to XMLGregorianCalendar value
	 * <p>
	 * <code>
	 * Note: this function returns 'yyyy-mm-dd' format   
	 * </code>
	 * </p>
	 * 
	 * @param dateTime
	 * @return {@link XMLGregorianCalendar}
	 * @throws ParseException
	 * @throws DatatypeConfigurationException
	 */
	public static XMLGregorianCalendar dateToXMLGregorianCalendarDate(Date dateTime)
			throws ParseException, DatatypeConfigurationException {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(dateTime);
		XMLGregorianCalendar xmlGC = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(cal.get(Calendar.YEAR),
				cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH), DatatypeConstants.FIELD_UNDEFINED);
		return xmlGC;
	}

	/**
	 * Get the values from and to index
	 * 
	 * @param value
	 *            {@code allows } {@link String}
	 * @param fromIndex
	 *            {@code allows } {@link Integer}
	 * @param toIndex
	 *            {@code allows } {@link Integer}
	 * @return {@link String}
	 */
	public static String getSubStringData(String value, int fromIndex, int toIndex) {
		String result = "";
		if (isValidString(value)) {
			if (value.length() > fromIndex && value.length() >= toIndex && fromIndex < toIndex) {
				result = value.substring(fromIndex, toIndex).trim();
			} else {
				result = value;
			}
		} else {
			result = "";
		}
		return result;
	}

	/**
	 * Get the values from and to index
	 * 
	 * @param text
	 *            {@code allows } {@link String}
	 * @param token
	 *            {@code allows } {@link Integer}
	 * @param value
	 *            {@code allows } {@link Integer}
	 * @return {@link String}
	 */
	public static String replaceTokenByValue(String text, String token, String value) {

		if (isValidString(text) && isValidString(token)) {
			text = text.replace(token, value);
		}

		return text;
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
		if (isValidString(numberString)) {
			numberString = numberString.replace(",", "");
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
		if (isValidString(numberString)) {
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
		if (isValidString(numberString)) {
			if (numberString.contains(",") && numberString.indexOf(",") != 0) {
				numberString = numberString.replace(",", "");
			} else {
				// do nothing
			}
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
		if (isValidString(numberString)) {
			numberString = removeAmountStringDotSpecification(numberString);
			numberString = removeAmountStringCommaSpecification(numberString);
		}
		return numberString;
	}

	/**
	 * Pad with "0" and make the out put string to contain 15chars. handles
	 * decimals of currency based on the input.
	 */
	public static String getAmountWithPadding(String amount) {
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
	 * Return a error response where RestResource client returns
	 * 'Conflict'/'Exception' code
	 * 
	 * @return {@link String}
	 * @throws IOException
	 */
	public static String receiveErrorResponse(String requestId, String errorCode, String errorResponse) {
		String result = "";
		try {
			LinkedHashMap resMap = new LinkedHashMap();
			resMap.put("requestId", requestId);
			resMap.put("requestTime", "1416266822000");
			resMap.put("status", "FAILURE");
			resMap.put("data", null);
			LinkedHashMap errorMap = new LinkedHashMap();
			errorMap.put("code", errorCode);
			errorMap.put("description", errorResponse);
			resMap.put("error", errorMap);

			result = new Gson().toJson(resMap);
		} catch (Exception e) {
			logger.error("Exception! Check the logs for details", e);
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
		if (isValidObject(decimalPrecision)) {
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
		Double result = Math.round(value * 100.0) / 100.0;
		return result;
	}

	/**
	 * Check double amount with custom precision <br>
	 * Note: This function do Math.round(*) calculation </br>
	 * 
	 * @return {@link String}
	 */
	public static Double getAmountWithCustomPrecision(Double value, int decimalPrecision) {
		Double denominator = 1d;
		if (isValidObject(decimalPrecision)) {
			String amount = "1";
			for (int i = 1; i <= decimalPrecision; i++) {
				amount += "0";
			}
			denominator = denominator * Double.parseDouble(amount);
		}
		Double result = Math.round(value * denominator) / denominator;
		return result;
	}

	/**
	 * Get the tag value from the XML string
	 * 
	 * @param xmlString
	 *            {@code allows } {@link String}
	 * @param tagName
	 *            {@code allows } {@link String}
	 * @return {@link String}
	 */
	public static String getXMLTagValue(String xmlString, String tagName) {
		String result = "";
		if (isValidString(xmlString) && isValidString(tagName)) {
			try {
				result = xmlString.split("<" + tagName + ">")[1].split("</" + tagName + ">")[0];
			} catch (ArrayIndexOutOfBoundsException e) {
				logger.error("Undefined " + tagName + " tag in XML Request");
			} catch (Exception e) {
				logger.error("Exception in fetching XMLTagValue! Check logs for the details", e);
			} finally {
				// do nothing
			}
		}
		return getValidStringValue(result);
	}

	public static String formatXml(String stringToBeFormatted) {
		try {
			Transformer serializer = SAXTransformerFactory.newInstance().newTransformer();
			serializer.setOutputProperty(OutputKeys.INDENT, "yes");
			// serializer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,
			// "yes");
			serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			serializer.setOutputProperty("{http://xml.customer.org/xslt}indent-amount", "2");
			Source xmlSource = new SAXSource(new InputSource(new ByteArrayInputStream(stringToBeFormatted.getBytes())));
			StreamResult res = new StreamResult(new ByteArrayOutputStream());
			serializer.transform(xmlSource, res);
			return new String(((ByteArrayOutputStream) res.getOutputStream()).toByteArray());
		} catch (Exception e) {
			// TODO log error
			return stringToBeFormatted;
		}
	}

	/**
	 * Get the string in Capital camel case
	 * 
	 * @param string
	 *            {@code allows any }{@link Object}
	 * @return {@link String}
	 */
	public static String getStringCapitalize(String string) {
		if (isValidString(string)) {
			string = StringUtils.capitalize(string);
		}

		return string;
	}

	/**
	 * Get the string in Uncapital camel case
	 * 
	 * @param string
	 *            {@code allows any }{@link Object}
	 * @return {@link String}
	 */
	public static String getStringUncapitalize(String string) {
		if (isValidString(string)) {
			string = StringUtils.uncapitalize(string);
		}

		return string;
	}

	/**
	 * Checks and returns if the given email addresses contains any ';' then
	 * replace this character to ','
	 * 
	 * @param addresses
	 *            {@code allows any }{@link Object}
	 * @return {@link String}
	 */
	public static String getValidEmailAddress(String addresses) {
		String result = "";
		if (isValidString(addresses))
			result = addresses.replace(';', ',');
		return result;
	}

	/**
	 * Get the line seperator
	 * 
	 * @return {@link String}
	 */
	public static String getLineSepartorText() {
		String result = System.getProperty("line.separator") + "------------------------------"
				+ System.getProperty("line.separator");
		return result;
	}

	/**
	 * Get star (*) as separator
	 * 
	 * @return {@link String}
	 */
	public static String getStarSepartorText() {
		String result = "*************************************************************************************************";
		return result;
	}

	/**
	 * Get line feeder ('\n')
	 * 
	 * @return {@link String}
	 */
	public static String getLineFeederText() {
		String result = System.getProperty("line.separator");
		return result;
	}

	/**
	 * Get line tab ('\t')
	 * 
	 * @return {@link String}
	 */
	public static String getTabLineText() {
		return "\t";
	}

	/**
	 * Added by PRASATH
	 * 
	 * @param inputBranch
	 *            {@link String }
	 * @return
	 */

	/**
	 * Get day of system's current date
	 * 
	 * @return {@link String}
	 */
	public static String getSystemCurrentDay() {
		String currentDay = new SimpleDateFormat("EEEE").format(getLocalDate());
		return currentDay;
	}

	/**
	 * Get date of system's current date
	 * 
	 * @return {@link String}
	 */
	public static String getSystemCurrentDate() {
		String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(getLocalDate());
		return currentDate;
	}

	/**
	 * Get time string in expected format <br>
	 * {@code time formats should be 'hh:mm' } <br>
	 * {@code functions returns 'dd-mm-yyyy hh:mm' }
	 * 
	 * @param time
	 *            {@code allows } {@link String}
	 * 
	 * @return {@link String}
	 */
	public static String getTimeWithCurrentDateInStringFormat(String time) {
		String result = "";
		if (isValidString(time)) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				result = sdf.format(getLocalDate());
				result = result + " " + time;
			} catch (Exception e) {
				logger.error("Exception! Check the logs for details", e);
			}
		}
		return result;
	}

	/**
	 * Compare with local time
	 * 
	 * @param givenTime
	 *            {@code allows } {@link String}
	 * 
	 * @Info Time should be in format 'HH:mm'
	 * @Method Checks giventime after to currenttime of the system
	 * 
	 * @return {@link String}
	 */
	public static boolean compareWithLocalTime(String givenTime) {
		boolean isValid = false;
		try {
			String givenDateTime = getTimeWithCurrentDateInStringFormat(givenTime);
			SimpleDateFormat ra = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			Date userDate = ra.parse(givenDateTime);
			Date currentDate = getLocalDate();

			// logger.debug("Comparing user time with " + userDate);
			// logger.debug("Comparing current time with "
			// + currentDate);

			if (currentDate.after(userDate)) {
				isValid = true;
			} else {
				isValid = false;
			}
		} catch (Exception e) {
			// TODO
		}
		return isValid;
	}

	/**
	 * Compare with local time
	 * 
	 * @param givenTime
	 *            {@code allows } {@link String}
	 * @param startTime
	 *            {@code allows } {@link String}
	 * @param endTime
	 *            {@code allows } {@link String}
	 * 
	 * @Info Time should be in format 'HH:mm'
	 * @Method Checks giventime after to starttime and endtime
	 * 
	 * @return {@link boolean}
	 */
	public static boolean compareGivenTimeBetweenProvidedTime(String givenTime, String startTime, String endTime) {
		boolean isValid = false;
		try {
			String givenDateTime = getTimeWithCurrentDateInStringFormat(givenTime);
			String aStartTime = getTimeWithCurrentDateInStringFormat(startTime);
			String aEndTime = getTimeWithCurrentDateInStringFormat(endTime);

			SimpleDateFormat ra = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			Date givenDate = ra.parse(givenDateTime);
			Date startDate = ra.parse(aStartTime);
			Date endDate = ra.parse(aEndTime);

			// logger.debug("Comparing given time at " + givenDate);
			// logger.debug("Comparing start time at " + startDate);
			// logger.debug("Comparing end time at " + endDate);

			if (givenDate.after(startDate) && givenDate.after(endDate)) {
				isValid = true;
			} else {
				isValid = false;
			}
		} catch (Exception e) {
			// TODO
		}
		return isValid;
	}

	/**
	 * Compare with local date
	 * 
	 * @param givenDate
	 *            {@code allows } {@link String}
	 * 
	 * @Info Given date should be in format 'dd-MM-yyyy'
	 * @Method Checks givendate before to currentdate of the system
	 * 
	 * @return {@link String}
	 */
	public static boolean compareWithLocalDate(String givenDate) {
		boolean isValid = false;
		try {
			SimpleDateFormat ra = new SimpleDateFormat("dd-MM-yyyy");
			Date userDate = ra.parse(givenDate);
			Date currentDate = getLocalDate();
			if (userDate.before(currentDate)) {
				isValid = true;
			} else {
				isValid = false;
			}
		} catch (Exception e) {
			// TODO
		}
		return isValid;
	}

	/**
	 * 
	 * @param givenDate
	 *            {@code allows } {@link String}
	 * @return {@link boolean}
	 */
	public static boolean checksProvidedDateIsMonthEnd(String givenDate) {
		boolean isValid = false;
		if (ValidationsUtil.isValidString(givenDate)) {
			String[] splDate = givenDate.split("-");
			Date date = DateTimeUtil.getDateByStringDateInFormat(givenDate, "dd-MM-yyyy");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);

			int lastDate = calendar.getActualMaximum(Calendar.DATE);

			logger.debug("GivenDate " + splDate[0] + " LastDate " + lastDate);

			if (splDate[0].equalsIgnoreCase(lastDate + ""))
				isValid = true;
		}
		return isValid;
	}

	/**
	 * 
	 * @param givenDate
	 *            {@code allows } {@link String}
	 * @return {@link boolean}
	 */
	public static String getDayForGivenDate(String givenDate) {
		String result = "";
		if (ValidationsUtil.isValidString(givenDate)) {
			Date date = DateTimeUtil.getDateByStringDateInFormat(givenDate, "dd-MM-yyyy");
			result = new SimpleDateFormat("EEEE").format(date);
		}
		return result;
	}

	/**
	 * Get valid zone name
	 * 
	 * @param zoneName
	 *            {@code allows } {@link String}
	 * @return {@link String}
	 */
	public static String getInternalZoneName(String zoneName) {
		if (zoneName.equalsIgnoreCase("UAEZONE"))
			return "UAE";
		if (zoneName.equalsIgnoreCase("QATARZONE"))
			return "Qatar";
		if (zoneName.equalsIgnoreCase("SNGZONE"))
			return "Singapore";
		else
			return "";
	}

	/**
	 * Main method
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		logger.debug(compareGivenTimeBetweenProvidedTime("16:59", "08:01", "17:00"));
	}

	public static String dummyMethod() throws Exception {
		String fileContent = readFile("C:\\Users\\O4248\\Desktop\\SampleUpdateDoc_Request.txt");
		String result = "agsdjagsjdgj";
		LinkedHashMap requestMap = (LinkedHashMap) convertJsonToObject(fileContent, new LinkedHashMap());
		LinkedHashMap updt = (LinkedHashMap) requestMap.get("data");
		result = (String) updt.get("content");
		return result;
	}

}
