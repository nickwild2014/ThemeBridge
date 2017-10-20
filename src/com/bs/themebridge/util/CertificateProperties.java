package com.bs.themebridge.util;

import java.security.KeyStore;
import java.security.cert.X509Certificate;

import org.apache.log4j.Logger;

/**
 * CertificateProperties to store the certification values generated
 * 						and utilize the values

 * @author Bluescope
 * 
 * */

public class CertificateProperties {
	
	private final static Logger logger = Logger.getLogger(ServiceProcessorUtil.class);

	public static X509Certificate[] chain = null;
	public static KeyStore ks = null;

	public static String host = null;
	public static int port = 0;
	public static char[] passphrase = null;

	/**
	 * Method loadProperties
	 * 
	 * To load certificate properties
	 * @param certificateValue
	 *          : certificateValue from SSLCertificate.jsp to store the certificates that needed 
	 * @param ksValue
	 *          : ksValue is KeyStore value from SSLCertificate.jsp 
	 * @param hostValue
	 *          : hostValue refers to the host where certificate wanted
	 * @param portValue
	 *			: portValue refers to the host where certificate wanted
	 * @param passphraseValue
	 *			: passphraseValue password for the host referring  
	 */

	public static void loadProperties(X509Certificate[] certificateValue,
			KeyStore ksValue, String hostValue, int portValue,
			char[] passphraseValue) {

		logger.debug("Loading Certificate properties");
		
		chain = certificateValue;
		ks = ksValue;
		host = hostValue;
		port = portValue;
		passphrase = passphraseValue;
	}

}
