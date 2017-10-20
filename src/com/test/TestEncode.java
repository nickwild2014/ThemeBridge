package com.test;

import org.apache.log4j.Logger;

import com.bs.theme.bob.adapter.adaptee.SWIFTSwiftInAdaptee;
import com.bs.themebridge.util.ThemeBridgeUtil;

public class TestEncode {

	private final static Logger logger = Logger.getLogger(SWIFTSwiftInAdaptee.class);

	// public static void main(String args[]) {
	//
	// try {
	//
	// String url = "<![CDATA[ <IMG SRC=\" 
	// javascript:document.vulnerable=true;\"> ]]>";
	//
	// String encodedUrl = URLEncoder.encode(url, "UTF-8");
	//
	// logger.debug("Encoded URL " + encodedUrl);
	//
	// String decodedUrl = URLDecoder.decode(url, "UTF-8");
	//
	// logger.debug("Dncoded URL " + decodedUrl);
	//
	// } catch (UnsupportedEncodingException e) {
	//
	// logger.debug(e);
	//
	// }
	// }

	public static void main(String args[]) {

		String test = null;
		try {
			test = ThemeBridgeUtil.readFile("D:\\_Prasath\\Filezilla\\MADAsamy\\103\\103\\00350510.out");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getSwiftMsgType(test);
	}

	public static String getSwiftMsgType(String msg) {
		String swiftCode = "";
		int indexCode = msg.indexOf("{2:");
		if (indexCode >= 0 && indexCode < msg.length()) {
			swiftCode = msg.substring(indexCode + 4, indexCode + 7);
			logger.debug("Msg Type -> " + swiftCode);
		}
		return swiftCode;
	}
}
