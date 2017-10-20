package com.bs.themebridge.serverinterface;

import org.apache.log4j.Logger;

/**
 * 
 * @author Bluescope
 *
 */
public class AdapteeUtil {

	private final static Logger logger = Logger.getLogger(AdapteeUtil.class);

	/**
	 * 
	 * @param inputXml
	 *            {@code allows }{@link String}
	 * @param adapteeImplementationClass
	 *            {@code allows }{@link String}
	 * @return
	 */
	public static AdapteeInterface getAdapteeInstance(String inputXml, String adapteeImplementationClass) {

		// logger.debug("*** AdapteeUtil.getAdapteeInstance initiated! ***");
		// logger.debug("AdapteeUtil getAdapteeInstance : "
		// + adapteeImplementationClass);
		Class aClass;
		AdapteeInterface implementationClass = null;
		try {
			aClass = Class.forName(adapteeImplementationClass);
			// logger.debug("Adapte Interface object class creation object:"
			// + aClass);
			implementationClass = (AdapteeInterface) aClass.newInstance();
			// logger.debug("Adapte Interface object creation:"
			// + implementationClass);
			implementationClass.initialize(inputXml);
		} catch (ClassNotFoundException e) {
			logger.error("ClassNotFoundException:" + e.getMessage());
		} catch (InstantiationException e) {
			logger.error("InstantiationException:" + e.getMessage());
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			logger.error("IllegalAccessException:" + e.getMessage());
		} catch (Exception e) {
			logger.error("Exception:" + e.getMessage());
		}

		// logger.info("*** AdapteeUtil.getAdapteeInstance finished! ***");
		return implementationClass;
	}

	/**
	 * 
	 * @param adapteeImplementationClass
	 *            {@code allows }{@link String}
	 * @return
	 */
	public static AdapteeInterface getStaticAdapteeInstance(String adapteeImplementationClass) {

		// logger.debug("*** AdapteeUtil.getStaticAdapteeInstance initiated!
		// ***");
		// logger.debug("AdapteeUtil getStaticAdapteeInstance : " +
		// adapteeImplementationClass);
		Class bClass;
		AdapteeInterface implementationClass = null;
		try {
			bClass = Class.forName(adapteeImplementationClass);
			implementationClass = (AdapteeInterface) bClass.newInstance();
			// logger.debug("Static Adapte Interface object creation:"
			// + implementationClass);
		} catch (ClassNotFoundException e) {
			logger.error("ClassNotFoundException:" + e.getMessage());
		} catch (InstantiationException e) {
			logger.error("InstantiationException:" + e.getMessage());
		} catch (IllegalAccessException e) {
			logger.error("IllegalAccessException:" + e.getMessage());
		} catch (Exception e) {
			logger.error("Exception:" + e.getMessage());
		}

		// logger.debug("*** AdapteeUtil.getStaticAdapteeInstance initiated!
		// ***");
		return implementationClass;
	}
}
