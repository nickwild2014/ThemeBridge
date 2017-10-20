package com.test;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.log4j.Logger;

public class XmlSpecialCharacterEncoding {

	private final static Logger logger = Logger.getLogger(XmlSpecialCharacterEncoding.class.getName());

	public static void main(String[] args) {

		escape();

		logger.debug(StringEscapeUtils.escapeXml("test&345> dfasd <"));
		// xmlEscapeText(String t)

		String f = "kjkjk '&' hgh";
	}

	/**
	 * 
	 */
	public static void escape() {

		String ex = "<?xml version='1.0' encoding='UTF-8'?> <Bank> <Account type> <Id>100@1</Id> <Name>Jack & Robinson</Name> <Amt>10000</Amt> </Account> <Account type> <Id>1002</Id> <Name>Sony Corporation</Name> <Amt>1000000</Amt> </Account> </Bank>";
		// String escapedXml = StringEscapeUtils.escapeXml("the data might
		// contain & or ! or % or ' or # etc");
		// logger.debug(escapedXml);
		// String escapedXml2 = StringEscapeUtils.escapeXml(ex);
		// logger.debug(escapedXml2);
		logger.debug(xmlEscapeText(ex));
	}

	/**
	 * 
	 * @param xmlString
	 * @return
	 */
	public static String escapeXmlSpecialCahr(String xmlString) {

		logger.debug(" ************ GATEWAY.NEFTRTGS adaptee process started ************ ");

		String result = "";
		try {
			String escapeXmlStr = StringEscapeUtils.escapeXml(xmlString);
			logger.debug("EscapedXmlString : " + escapeXmlStr);
			result = escapeXmlStr;

		} catch (Exception e) {
			logger.error("EscapeXmlStr exceptions! " + e.getMessage());

		}

		return result;
	}

	/**
	 * 
	 * @param xmlString
	 *            {@code allows }{@link String}
	 * @return
	 */
	public static String xmlEscapeText(String xmlString) {

		// String result =
		// xmlString.replaceAll("[~!@#$%^&*(){}\\[\\]:;\"<,>.?/]", " ");
		// logger.debug(result);
		// return result;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < xmlString.length(); i++) {
			char c = xmlString.charAt(i);
			switch (c) {
			// case '<':
			// sb.append("&lt;");
			// break;
			// case '>':
			// sb.append("&gt;");
			// break;
			// case '\"':
			// sb.append("&quot;");
			// break;
			case '&':
				// sb.append("&amp;");
				// sb.append("'&'");
				sb.append("and");
				break;
			// case '\'':
			// sb.append("&apos;");
			// break;
			default:
				if (c > 0x7e) {
					sb.append("&#" + ((int) c) + ";");
				} else
					sb.append(c);
			}
		}

		// logger.debug(sb);
		return sb.toString();

	}

	/**
	 * 
	 * @param xmlString
	 *            {@code allows }{@link String}
	 * @return
	 */
	public static String watchListXmlEscapeText(String xmlString) {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < xmlString.length(); i++) {
			char c = xmlString.charAt(i);
			switch (c) {
			// case '<':
			// sb.append("&lt;");
			// break;
			// case '>':
			// sb.append("&gt;");
			// break;
			// case '\"':
			// sb.append("&quot;");
			// break;
			case '&':
				sb.append("&amp;");
				// sb.append("'&'");
				break;
			// case '\'':
			// sb.append("&apos;");
			// break;
			default:
				if (c > 0x7e) {
					sb.append("&#" + ((int) c) + ";");
				} else
					sb.append(c);
			}
		}

		// logger.debug(sb);
		return sb.toString();
	}

}
