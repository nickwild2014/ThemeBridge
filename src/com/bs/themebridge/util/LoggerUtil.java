package com.bs.themebridge.util;

import org.apache.log4j.Logger;

/**
 * Util class for logger
 * 
 * @author BlueScope
 * 
 */
public class LoggerUtil {

	public static Logger logger;

	/**
	 * Instantiate logger
	 * 
	 * @param clazz
	 */
	public LoggerUtil(Class clazz) {
		logger = Logger.getLogger(clazz);
	}

	/**
	 * Instantiate logger
	 * 
	 * @param myClass
	 * @return
	 */
	/*
	 * public static Logger setLogger(Class myClass) { logger =
	 * Logger.getLogger(myClass); return logger; }
	 */

	/**
	 * Logging debug message
	 * 
	 * @param debugMsg
	 */
	public static void setDebug(String debugMsg) {
		logger.debug(debugMsg);
	};

	/**
	 * Logging info message
	 * 
	 * @param infoMsg
	 */
	public static void setInfo(String infoMsg) {
		logger.debug(infoMsg);
	};

	/**
	 * Logging warning message
	 * 
	 * @param warnMsg
	 */
	public static void setWarn(String warnMsg) {
		logger.warn(warnMsg);
	};

	/**
	 * Logging error message
	 * 
	 * @param errorMsg
	 */
	public static void setError(String errorMsg) {
		logger.error(errorMsg);
	};

	/**
	 * Logging fatal message
	 * 
	 * @param fatalMsg
	 */
	public static void setFatal(String fatalMsg) {
		logger.fatal(fatalMsg);
	};

	/**
	 * Logging error with message and exception
	 * 
	 * @param errorMsg
	 * @param ex
	 */
	public static void setError(String errorMsg, Exception ex) {
		logger.error(errorMsg, ex);
	};

}
