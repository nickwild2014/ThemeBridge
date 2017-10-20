package com.bs.themebridge.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;

import com.prowidesoftware.swift.io.ConversionService;
import com.prowidesoftware.swift.io.IConversionService;
import com.prowidesoftware.swift.model.SwiftMessage;

public class SwiftFriendlyFormateAdaptee {
	private final static Logger logger = Logger.getLogger(SwiftFriendlyFormateAdaptee.class.getName());

	public static void main(String[] args) throws Exception {

		String SfmsOutMsg = ThemeBridgeUtil.readFile("D:\\_Prasath\\00_TASK\\sfms printer friendly\\sfmsSIT.txt");
		// .readFile("D:\\_Prasath\\00_TASK\\sfms printer
		// friendly\\SFMSPrinterFriendly.txt");

		// swiftMsg = ThemeBridgeUtil
		// .readFile("D:\\_Prasath\\00_TASK\\sfms printer
		// friendly\\SFMSPrinterFriendlyConverted.txt");

		String test = getFriendlySWIFT(SfmsOutMsg, "410");
		// logger.debug(test);
	}

	/**
	 * 
	 * @param swiftMessage
	 * @param msgType
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String getFriendlySWIFT(String swiftMessage, String msgType)
			throws FileNotFoundException, IOException {

		String friendlySWIFT = swiftMessage;
		IConversionService ics = new ConversionService();
		SwiftMessage sm = ics.getMessageFromFIN(swiftMessage);
		Map<String, String> block4Map = sm.getBlock4().getTagMap();
		Set<String> keySet = block4Map.keySet();
		Properties prop = getProperties(msgType);
		// logger.debug("Prop : " + prop);
		for (String tag : keySet) {
			String value = prop.getProperty(tag);
			if (value == null)
				value = "";
			friendlySWIFT = friendlySWIFT.replace(":" + tag + ":".trim(), ":" + tag + ":".trim() + " " + value + "\n");
		}
		logger.debug("Printer Friendly Message :-\n" + friendlySWIFT);
		return friendlySWIFT;
	}

	/**
	 * 
	 * @param messageType
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static Properties getProperties(String messageType) throws FileNotFoundException, IOException {

		// logger.debug("Inside getProperties method");
		Properties prop = new Properties();
		InputStream inputStream = null;
		inputStream = SwiftFriendlyFormateAdaptee.class.getClassLoader()
				.getResourceAsStream(messageType + ".properties");
		prop.load(inputStream);
		return prop;
	}
}
