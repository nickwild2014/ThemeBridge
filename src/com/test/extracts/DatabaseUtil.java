/**
 * 
 */
package com.test.extracts;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 
 * @author O6831, prasath ravichandran
 * 
 */
public class DatabaseUtil {

	public static Properties fileProperty = null;
	private final static Logger logger = Logger.getLogger(DatabaseUtil.class.getName());

	public static void main(String[] args) {
		// logger.debug(getConnection());
		// logger.debug("testconn");
		// logger.debug();
		// String jndi = getFileProperties("ThemeBridgeJNDIName");
		// logger.debug("property :"+jndi);
		// getThemebridgeConnection();
		// getConnection();

		// loadProprtiesFile();

	}

	/**
	 * 
	 * @param object
	 * @return
	 */
	public static boolean isValidObject(Object object) {
		if (object == null)
			return false;
		return true;
	}

	/**
	 * 
	 * @param keyName
	 * @return
	 */
	public static String getFileProperties(String keyName) {
		if (!isValidObject(fileProperty)) {
			fileProperty = new Properties();
			// InputStream inputStream = DatabaseUtil.class.getClassLoader()
			// .getResourceAsStream("bridgeFile.properties");
			InputStream inputStream = null;
			String propertyFilePath = DirectoryUtil.currentDirectory();
			String filePathWithExtn = propertyFilePath + "/bridgeFile.properties";
			logger.info("File>>>" + filePathWithExtn);

			try {
				inputStream = new FileInputStream(filePathWithExtn);
				fileProperty.load(inputStream);
				// inputStream.close();
			} catch (Exception e) {
				logger.error("Load property exception! Check the logs for details");
			} finally {
				try {
					if (isValidObject(inputStream))
						inputStream.close();
				} catch (Exception e) {
					logger.error("Close property exception! Check the logs for details");
				}
			}
		}
		return fileProperty.getProperty(keyName);
	}

}
