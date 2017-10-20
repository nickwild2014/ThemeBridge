package com.bs.themebridge.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;

public class FileProperties {

	private final static Logger logger = Logger.getLogger(FileProperties.class);

	public static Properties property = null;
	public static Properties fileProperty = null;

	public static void main(String[] args) throws Exception {
		logger.info("FileProperties.class");
		getFileProperties("BuildVersion");
	}

	/**
	 * To get a key value from bridgefile.properties
	 * 
	 * @param keyName
	 *            {@code allows } {@link String}
	 * @return keyValue {@link String}
	 */
	public static String getFileProperties(String keyName) {

		// logger.debug("Property KeyName : " + keyName);
		if (!ValidationsUtil.isValidObject(fileProperty)) {
			fileProperty = new Properties();
			InputStream inputStream = FileProperties.class.getClassLoader()
					.getResourceAsStream("bridgefile.properties");
			try {
				fileProperty.load(inputStream);

			} catch (Exception e) {
				logger.error("Load property exception! Check the logs for details", e);

			} finally {
				try {
					if (ValidationsUtil.isValidObject(inputStream))
						inputStream.close();
				} catch (Exception e) {
					logger.error("Property exception! Check the logs for details" + e.getMessage());
				}
			}
		}
		// logger.debug("Property Value : " +
		// fileProperty.getProperty(keyName));
		return fileProperty.getProperty(keyName);
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public HashMap<String, String> loadProperties() throws IOException {

		HashMap<String, String> hashMap = new HashMap<String, String>();
		Properties prop = new Properties();
		InputStream inputStream = getClass().getResourceAsStream("/TINotification.properties");
		prop.load(inputStream);

		hashMap.put("dbdriver", prop.getProperty("dbdriver"));
		hashMap.put("dburl", prop.getProperty("dburl"));
		hashMap.put("dbusername", prop.getProperty("dbusername"));
		hashMap.put("dbpassword", prop.getProperty("dbpassword"));

		hashMap.put("tidbdriver", prop.getProperty("tidbdriver"));
		hashMap.put("tidburl", prop.getProperty("tidburl"));
		hashMap.put("tidbusername", prop.getProperty("tidbusername"));
		hashMap.put("tidbpassword", prop.getProperty("tidbpassword"));
		logger.debug("tidbpassword : " + prop.getProperty("tidbpassword"));

		return hashMap;
	}

}
