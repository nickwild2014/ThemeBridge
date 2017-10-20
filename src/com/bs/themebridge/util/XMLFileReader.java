package com.bs.themebridge.util;

import java.io.IOException;

import org.apache.log4j.Logger;


public class XMLFileReader {

	private final static Logger logger = Logger.getLogger(XMLFileReader.class);

	public static String tiFxRateSourceTemplate = null;
	public static String tiAccountSourceTemplate = null;
	public static String tiCurrencySpotRateSourceTemplate = null;
	public static String tiCustomerSourceTemplate = null;
	public static String tiAccountOfficerTemplate = null;
	public static String tiBaseRateTemplate = null;
	public static String tiSpotRateTemplate = null;

	public static void main(String args[]) throws Exception {

		for (int i = 1; i <= 5; i++) {
			try {
				String test = ThemeBridgeUtil.readPropertiesFile("");
				logger.debug(test);
				test = "abcd";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static String getTIFxRateSource() throws Exception {

		if (tiFxRateSourceTemplate == null) {
			tiFxRateSourceTemplate = ThemeBridgeUtil.readPropertiesFile("TIRequest_Card_Rate_Template.xml");
			return tiFxRateSourceTemplate;
		} else {
			return tiFxRateSourceTemplate;
		}
	}

	public static String getTICurrencySpotRateSource() throws Exception {

		if (tiCurrencySpotRateSourceTemplate == null) {
			tiCurrencySpotRateSourceTemplate = ThemeBridgeUtil.readPropertiesFile("TIRequest_Spot_Rate_Template.xml");
			return tiCurrencySpotRateSourceTemplate;
		} else {
			return tiCurrencySpotRateSourceTemplate;
		}
	}

	public static String getTIBaseRateSource() throws Exception {

		if (tiBaseRateTemplate == null) {
			tiBaseRateTemplate = ThemeBridgeUtil.readPropertiesFile("TIRequest_Base_Rate_Template.xml");
			return tiBaseRateTemplate;
		} else {
			return tiBaseRateTemplate;
		}
	}

	// public static String getTISpotRateSource() throws Exception {
	//
	// if (tiSpotRateTemplate == null) {
	// tiSpotRateTemplate =
	// ThemeBridgeUtil.readPropertiesFile("TIRequest_Spot_Rate_Template.xml");
	// return tiSpotRateTemplate;
	// } else {
	// return tiSpotRateTemplate;
	// }
	// }

	public static String getTIAccountSource() throws Exception {

		if (tiAccountSourceTemplate == null || tiAccountSourceTemplate.isEmpty()) {
			tiAccountSourceTemplate = ThemeBridgeUtil.readPropertiesFile("TIRequest_Account_Data_Template.xml");
			return tiAccountSourceTemplate;
		} else {
			return tiAccountSourceTemplate;
		}
	}

	public static String getTICustomerSource() throws Exception {

		if (tiCustomerSourceTemplate == null) {
			tiCustomerSourceTemplate = ThemeBridgeUtil.readPropertiesFile("TIRequest_Customer_Data_Template.xml");
			return tiCustomerSourceTemplate;
		} else {
			return tiCustomerSourceTemplate;
		}
	}

	public static String getTIAccountOfficerSource() throws Exception {

		if (tiAccountOfficerTemplate == null) {
			tiAccountOfficerTemplate = ThemeBridgeUtil.readPropertiesFile("TI.AccountOfficer.xml");
			return tiAccountOfficerTemplate;
		} else {
			return tiAccountOfficerTemplate;
		}
	}

	public static String getTiresponse() throws Exception {

		if (tiCustomerSourceTemplate == null) {
			tiCustomerSourceTemplate = ThemeBridgeUtil.readPropertiesFile("Tiresponse.xml");
			return tiCustomerSourceTemplate;
		} else {
			return tiCustomerSourceTemplate;
		}
	}

	public static void initializeInputXML() throws IOException {

		try {
			getTIAccountSource();
			getTICurrencySpotRateSource();
			getTICustomerSource();
			getTIAccountOfficerSource();
			getTIBaseRateSource();

		} catch (Exception e) {
			logger.debug(e.getMessage());
			e.printStackTrace();
		}
	}
}
