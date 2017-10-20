package com.bs.themebridge.util;

import org.apache.log4j.Logger;

import com.bs.themebridge.server.adapter.IServiceProcessor;
import com.bs.themebridge.server.service.ServiceHandler;

public class ThemeBridgeSimulator {

	private static Logger logger = Logger.getLogger(ThemeBridgeSimulator.class);

	/**
	 * To process message via EJB
	 * 
	 * @param message
	 *            {@code allows } {@link String}
	 * @return {@link String}
	 */
	public static String processBridgeGatewaySimulator(String message) {

		String result = "Unable to Process";
		logger.debug("Process through ThemeBridge simulator");
		if (ValidationsUtil.isValidString(message)) {
			try {
				final IServiceProcessor aServiceHandler = new ServiceHandler();
				result = aServiceHandler.process(message);

			} catch (Exception e) {
				e.printStackTrace();
				result = "Request occurs exception";
				logger.error("Exception! Check the logs for details", e);
			}
		} else {
			logger.debug("Invalid request message");
		}
		logger.debug("Process through ThemeBridge simulator ended ");
		return result;
	}
	public static void main(String args[]) throws Exception
	{
		String balReq = ThemeBridgeUtil.readFile("C:\\Users\\subhash\\Desktop\\AvailableBalRequest2.xml");
		System.out.println(balReq);
		String str = processBridgeGatewaySimulator(balReq);
		System.out.println(str);
	}

}
