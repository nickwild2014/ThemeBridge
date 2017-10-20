package com.bs.themebridge.entity.servlet.util;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.bs.themebridge.util.FileProperties;

/**
 * 
 * @author Prasath Ravichandran
 *
 */
public class AboutMeImpl {

	public static Logger logger = Logger.getLogger(AboutMeImpl.class);

	public static void main(String[] args) {
		// logger.debug("---");
		aboutMeProperties();
	}

	public static HashMap<String, String> aboutMeProperties() {

		HashMap<String, String> aHashMap = new HashMap<String, String>();

		String deployedDate = FileProperties.getFileProperties("ThemebridgeDeployedDate");
		aHashMap.put("ThemebridgeDeployedDate", deployedDate);

		String themeBridgeAppVersion = FileProperties.getFileProperties("ThemebridgeAppVersion");
		aHashMap.put("ThemebridgeAppVersion", themeBridgeAppVersion);

		String themebridgeDbVersion = FileProperties.getFileProperties("ThemebridgeDbVersion");
		aHashMap.put("ThemebridgeDbVersion", themebridgeDbVersion);

		String buildVersion = FileProperties.getFileProperties("BuildVersion");
		aHashMap.put("BuildVersion", buildVersion);

		String buildSequence = FileProperties.getFileProperties("BuildSequence");
		aHashMap.put("BuildSequence", buildSequence);

		String buildBy = FileProperties.getFileProperties("BuildBy");
		aHashMap.put("BuildBy", buildBy);

		String themeBridgeServicesEnabled = FileProperties.getFileProperties("BuildBy");
		aHashMap.put("ThemeBridgeServicesEnabled", themeBridgeServicesEnabled);

		logger.info("\nThemeBridgeDeployedDate : " + deployedDate + "\nThemeBridgeAppVersion : " + themeBridgeAppVersion
				+ "\nthemebridgeDbVersion : " + themebridgeDbVersion);

		logger.info(
				"\nBuildVersion : " + buildVersion + "\nBuildSequence : " + buildSequence + "\nBuildBy : " + buildBy);

		return aHashMap;
	}
}
