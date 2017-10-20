package com.bs.themebridge.entity.servlet.util;

import org.apache.log4j.Logger;

import com.bs.themebridge.util.EncryptDecrypt;
import com.bs.themebridge.util.FileProperties;

public class VerificationAdapterImpl {

	private final static Logger logger = Logger.getLogger(VerificationAdapterImpl.class);

	public static void main(String[] args) {

	}

	public static boolean verifyConsoleRights(String password) {
		logger.info("Password verify initiated");
		boolean result = false;
		String encryptPassword = "";
		try {
			encryptPassword = EncryptDecrypt.encrypt(password);
			String adminPassword = FileProperties.getFileProperties("ThemeBridgeConsole");

			if (adminPassword.equals(encryptPassword)) {
				result = true;
				logger.debug("Password verification return " + result);
			} else {
				result = false;
				logger.debug("Password verification return " + result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static boolean verify(String password) {

		logger.info("Password verify initiated");
		boolean result = false;
		if (password.equals("ta")) {
			result = true;
		} else {
			result = false;

		}
		logger.info("Password verification return " + result);
		return result;
	}
}
