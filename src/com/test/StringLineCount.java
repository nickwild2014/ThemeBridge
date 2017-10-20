package com.test;

import java.io.IOException;

import javax.xml.xpath.XPathExpressionException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.bs.themebridge.util.ThemeBridgeUtil;
import com.bs.themebridge.xpath.XPathParsing;

public class StringLineCount {

	private final static Logger logger = Logger.getLogger(StringLineCount.class.getName());

	public static void main(String[] args) throws Exception {

		// String requestXML =
		// ThemeBridgeUtil.readFile("D:\\_Prasath\\00_TASK\\task string
		// concat\\rtgs.xml");
		// String value = XPathParsing.getValue(requestXML,
		// "/ServiceRequest/rtgselcpod/RemitterAddress");

		String requestXML = ThemeBridgeUtil
				.readFile("D:\\_Prasath\\00_TASK\\task 767COV\\TIRequest.IFN760COV-20170301.xml");
		String value = XPathParsing.getValue(requestXML, "/ServiceRequest/bgifn767cv/AmendmentDetails");

		logger.debug(splitStringRowsCharacters(value, 150, 65));
	}

	/**
	 * 
	 * @param value
	 *            {@code allows }{@link String}
	 * @param maxCharCount
	 *            {@code allows }{@link String}
	 * @param maxRowsCount
	 *            {@code allows }{@link String}
	 * @return {@code allows }{@link String}
	 */
	public static String splitStringRowsCharacters(String value, int maxRowsCount, int maxCharCount) {

		String result = "";
		try {
			String concatStr = concatenateStringValue(value);
			// logger.debug("ConcatenateString : >>>" + concatStr + "<<<");

			String splitedValues = splitInParts(concatStr, maxCharCount);
			// logger.debug("SplitedValues : >>>" + splitedValues + "<<<");

			String maxRows = maxRowsCount(splitedValues, maxRowsCount);
			// logger.debug("MaxRowsValues : >>>" + maxRows + "<<<");

			result = maxRows;
			// logger.debug("SPLIT Completed");

		} catch (Exception e) {
			result = value;
			logger.error("Exception e " + e.getMessage());
		}

		return result;
	}

	/**
	 * 
	 * @param value
	 *            {@code allows }{@link String}
	 * @param maxCharCount
	 *            {@code allows }{@link String}
	 * @return {@code allows }{@link String}
	 * @throws XPathExpressionException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static String concatenateStringValue(String value)
			throws XPathExpressionException, SAXException, IOException {

		// logger.debug("[[[ concatenateStringValue ]]]");
		String result = "";
		String[] lines = value.split("\n", -1);
		int count = lines.length;
		// logger.debug("Line count : " + count);

		String addStr = "";
		for (int i = 0; i < lines.length; i++) {
			if (i == 0)
				addStr = addStr + lines[i];
			else
				addStr = addStr + " " + lines[i];
		}
		// logger.debug(addStr);
		result = addStr;

		return result;
	}

	/**
	 * 
	 * @param value
	 *            {@code allows }{@link String}
	 * @param partLength
	 *            {@code allows }{@link String}
	 * @return {@code allows }{@link String}
	 */
	public static String splitInParts(String value, int partLength) {

		// logger.debug("{{{ splitInParts }}}");
		String result = "";
		StringBuilder resultArray = new StringBuilder();
		int len = value.length();
		// Number of parts
		int nparts = (len + partLength - 1) / partLength;
		// String parts[] = new String[nparts];

		// Break into parts
		int offset = 0;
		int i = 0;
		while (i < nparts) {
			// parts[i] = s.substring(offset, Math.min(offset + partLength,
			// len));
			resultArray.append(value.substring(offset, Math.min(offset + partLength, len)));
			offset += partLength;
			i++;
			resultArray.append("\n");
		}

		// logger.debug(result);
		result = resultArray.toString().trim();

		return result;
	}

	/**
	 * @since 2017-FEB-27
	 * 
	 * @version v.1.0.1
	 * @author <b><i><font color=blue>Prasath Ravichandran</font></i></b>,
	 *         <font color=green>Software Analyst, </font>
	 *         <font color=violet>Bluescope</font>
	 * 
	 * @param value
	 *            {@code allows }{@link String}
	 * @param maxRowsCount
	 *            {@code allows }{@link String}
	 * @return {@code allows }{@link String}
	 * @throws XPathExpressionException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static String maxRowsCount(String value, int maxRowsCount)
			throws XPathExpressionException, SAXException, IOException {

		// logger.debug("((( concatenateStringValue )))");
		String result = "";
		// logger.debug(value);
		StringBuffer resultValue = new StringBuffer();

		String[] lines = value.split("\n", -1);
		int linecount = lines.length;
		// logger.debug("Line count : " + linecount);

		for (int i = 0; i < linecount; i++) {
			if (i < maxRowsCount) {
				resultValue.append(lines[i] + "\n");
				// logger.debug(i);
			}
		}
		result = resultValue.toString().trim();
		// logger.debug("result " + result);

		return result;
	}

	/*
	 * public static String splitChar(String value, int maxCharCount) {
	 * 
	 * String result = ""; // String s = "teststr"; StringBuilder tmp = new
	 * StringBuilder();
	 * 
	 * for (int i = 0; i < value.length(); i++) { tmp.append(value.charAt(i));
	 * if (i % maxCharCount == 1) tmp.append("\n"); }
	 * 
	 * result = tmp.toString(); logger.debug(result);
	 * 
	 * return result; }
	 */

	/**
	 * Standard values
	 * 
	 * @param value
	 * @param maxRowsCount
	 * @param maxCharOfRowCount
	 * @return
	 * @throws XPathExpressionException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static String readLineProperties(String value, int maxRowsCount)
			throws XPathExpressionException, SAXException, IOException {

		String result = "";
		logger.debug(value);
		StringBuffer resultValue = new StringBuffer();

		String[] lines = value.split("\n", -1);
		int count = lines.length;
		logger.debug("Lie count : " + count);

		for (int i = 0; i < lines.length; i++) {
			logger.debug("Line number : " + i + "\t" + lines[i].length() + "\t" + lines[i]);
		}

		return result;
	}
}
