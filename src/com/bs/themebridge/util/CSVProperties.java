package com.bs.themebridge.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;


public class CSVProperties {
	
	private final static Logger logger = Logger.getLogger(CSVProperties.class);

	static Properties prop = new Properties();
	static InputStream input = null;


	
	public static Set<Object> getPropertiesKey(String propertiesFilePath) throws IOException {
		
		//logger.debug("file Path:"+propertiesFilePath);
		
		
		try {
			
			InputStream input = CSVProperties.class.getClassLoader().getResourceAsStream(propertiesFilePath);

			prop.load(input);
		} catch (Exception e) {

			e.printStackTrace();
		}

		Set<Object> keys = prop.keySet();
		return keys;

	}

	public static String getPropertiesvalue(String key) {

		return prop.getProperty(key);
	}
	
	public static void main(String args[]) throws IOException
	{
		Set<Object> propkey=getPropertiesKey("D:/properties/fxrate.properties");
		
		for (Object keys : propkey) {
			
			String key = (String) keys;
			logger.debug(key);
			String MapKey = CSVProperties.getPropertiesvalue(key);
			
			logger.debug(MapKey);
			
			

		}
	}
}
