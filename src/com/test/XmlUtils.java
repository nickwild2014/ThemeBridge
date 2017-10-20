package com.test;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.log4j.Logger;

import com.bs.theme.bob.adapter.adaptee.SWIFTSwiftInAdaptee;


public class XmlUtils {

	private final static Logger logger = Logger.getLogger(SWIFTSwiftInAdaptee.class);

	public static void main(String[] args) {

		// org.apache.commons.lang.StringEscapeUtils
		// String escapedXml =
		// StringEscapeUtils.escapeXml("the data might contain & or ! or % or '
		// or # etc");
		XmlUtils();
	}

	public static void XmlUtils() {

		// handling xml special character & in Java String
		String xmlWithSpecial = "<raja>Java & HTML</raja>"; // xml String with &
															// as special
		// characters
		logger.debug("Original unescaped XML String: " + xmlWithSpecial);
		logger.debug("Escaped XML String in Java: " + StringEscapeUtils.escapeXml(xmlWithSpecial));

		// handling xml special character > in String on Java
		xmlWithSpecial = "Java > HTML"; // xml String with & as special
										// characters
		logger.debug("Original unescaped XML String: " + xmlWithSpecial);
		logger.debug("Escaped XML String : " + StringEscapeUtils.escapeXml(xmlWithSpecial));

		// handling xml and html special character < in String
		xmlWithSpecial = "Java < HTML"; // xml String with & as special
										// characters
		logger.debug("Original unescaped XML String: " + xmlWithSpecial);
		logger.debug("Escaped XML String: " + StringEscapeUtils.escapeXml(xmlWithSpecial));

		// handling html and xml special character " in Java
		xmlWithSpecial = "Java \" HTML"; // xml String with & as special
											// characters
		logger.debug("Original unescaped XML String: " + xmlWithSpecial);
		logger.debug("Escaped XML String: " + StringEscapeUtils.escapeXml(xmlWithSpecial));

		// handling xml special character ' in String from Java
		xmlWithSpecial = "Java ' HTML"; // xml String with & as special
										// characters
		logger.debug("Original unescaped XML String: " + xmlWithSpecial);
		logger.debug("Escaped XML String: " + StringEscapeUtils.escapeXml(xmlWithSpecial));

	}

	// Read more:
	// http://javarevisited.blogspot.com/2012/09/how-to-replace-escape-xml-special-characters-java-string.html#ixzz4RDILOIkd

}
