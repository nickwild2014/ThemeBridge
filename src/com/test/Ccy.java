package com.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bs.themebridge.util.ThemeBridgeUtil;

public class Ccy {

	private final static Logger logger = Logger.getLogger(Ccy.class.getName());

	// public static void main(String[] args) {
	// // TODO Auto-generated method stub
	//
	// String allowedProduct = "ILC;BG;ELC";
	// String postingProd = "ILC;BG;ELC";
	//
	// logger.debug(ThemeBridgeUtil.getLocalDateTime());
	// String[] productArray = allowedProduct.split(";");
	//
	// for (int ccyIterator = 0; ccyIterator <= productArray.length;
	// ccyIterator++) {
	// logger.debug("LOOP");
	// if (productArray[ccyIterator].equals(postingProd)) {
	// // do something
	// logger.debug("TEST");
	// break;
	// }
	// }
	//
	// logger.debug(ThemeBridgeUtil.getLocalDateTime());
	// }

	/**
	 * PRASATH R
	 * 
	 * @since 2016-Aug-09
	 * @param amt
	 * @return
	 */
	public static BigDecimal getAmountValues(String amount) {

		amount = amount.replace(",", "");
		amount = amount.replaceAll("\\s+", "");
		amount = amount.replaceAll("[^0-9 , .]", "");
		BigDecimal result = new BigDecimal(amount);

		return result;
	}

	/**
	 * 
	 * @param amt
	 * @return
	 */
	public static String getCcyFromEventField(String amt) {
		String result = amt;
		if (result == null) {
			return result;
		}
		result = result.replaceAll("[^a-zA-Z]", "");
		return result;
	}

	public static String getTagValue(String xml, String tagName) {

		String value = xml.split("<" + tagName + ">")[1].split("</" + tagName + ">")[0];
		logger.debug("value of " + value);
		return value;
	}

	public static void main(String[] args) {

		// char ch;
		// for (ch = 'a'; ch <= 'z'; ch++)
		// System.out.println(ch);

		// String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"
		// standalone=\"yes\"?> <ns4:ServiceResponse
		// xmlns:ns2=\"urn:common.service.ti.apps.tiplus2.misys.com\"
		// xmlns:ns3=\"urn:messages.service.ti.apps.tiplus2.misys.com\"
		// xmlns:ns4=\"urn:control.services.tiplus2.misys.com\">
		// <ns4:ResponseHeader> <ns4:Service>Limit</ns4:Service>
		// <ns4:Operation>Facilities</ns4:Operation>
		// <ns4:Status>FAILED</ns4:Status> <ns4:Details> <ns4:Error>No Limit
		// Line Available for this Customer [IM]</ns4:Error> </ns4:Details>
		// </ns4:ResponseHeader> </ns4:ServiceResponse>";
		// getTagValue(xml, "ns4:Status");

		// logger.debug(getCcyFromEventField("1,000.00 INR"));
		// logger.debug(getAmountValues("1,000.00 INR"));

		// try {
		// String facilityId = "Prasath /Ravichandran";
		// logger.debug(facilityId);
		//
		// String[] parts = facilityId.split("/");
		// logger.debug("facilityId : " + facilityId);
		//
		// String limitPrefix = parts[0].trim();
		// String limitSuffix = parts[1].trim();
		//
		// logger.debug("limitPrefix : >>" + limitPrefix + "<<");
		// logger.debug("limitSuffix : >>" + limitSuffix + "<<");
		//
		// logger.debug("limitPrefix : >>" + limitPrefix.trim() + "<<");
		// logger.debug("limitSuffix : >>" + limitSuffix.trim() + "<<");
		//
		// } catch (Exception e) {
		// logger.debug("Ex " + e.getMessage());
		// }

		// String ReferenceOfUnderlinedContract = "aaaaaaaaaaa aaaaaaaaaaa
		// aaaaaaab bbbbbbbbbbbbb bbbbbb bbbbbbbcc ccccccccccccccccccc
		// dddddddddddddddd eeeefff";

		// String ReferenceOfUnderlinedContract = "12";
		//
		// if (ReferenceOfUnderlinedContract.length() > 5) {
		// ReferenceOfUnderlinedContract =
		// ReferenceOfUnderlinedContract.substring(0, 5);
		// }
		//
		// String freeText = null;
		// String[] splitStringArray =
		// BreakString.splitStringByCharCount(ReferenceOfUnderlinedContract, 2);
		// logger.debug(splitStringArray.length);
		// for (int arrayIterator = 0; arrayIterator < splitStringArray.length;
		// arrayIterator++) {
		// if (arrayIterator == 0) {
		// freeText = splitStringArray[arrayIterator];
		// logger.debug("IF");
		// } else {
		// freeText = freeText + "\n" + splitStringArray[arrayIterator];
		// logger.debug("ELSE");
		// }
		// // freeText = splitStringArray[0] + "\n" +
		// // splitStringArray[1] + "\n" + splitStringArray[2];
		// }
		//
		// logger.debug(":7039:" + freeText + "<<<");
		//
		// // logger.debug(ReferenceOfUnderlinedContract);

		// String ReferenceOfUnderlinedContract = "aaaaaaaaaaa aaaaaaaaaaa
		// aaaaaaab bbbbbbbbbbbbb bbbbbb bbbbbbbcc ccccccccccccccccccc
		// dddddddddddddddd eeeefff";

		// String ReferenceOfUnderlinedContract =
		// "jkdjqdueqdqwohfiqhfhqiuhdfeqiwhdud
		// huqiwdheqwuihuhdfeqhudhequihdhqiuh
		// diuqdiquehddihqhiudeheqiuhdddsadhh"

		// splitFreeText7039(ReferenceOfUnderlinedContract);
	}

	public static String splitFreeText7039(String ReferenceOfUnderlinedContract) {

		StringBuilder freeText = new StringBuilder();

		try {
			if (ReferenceOfUnderlinedContract.length() > 105) {
				ReferenceOfUnderlinedContract = ReferenceOfUnderlinedContract.substring(0, 105);
			}

			String[] splitStringArray = BreakString.splitStringByCharCount(ReferenceOfUnderlinedContract, 35);
			logger.debug("No. of Lines in Freetext : " + splitStringArray.length);

			for (int arrayIterator = 0; arrayIterator < splitStringArray.length; arrayIterator++) {
				if (arrayIterator == 0)
					freeText.append(splitStringArray[arrayIterator]);
				else
					freeText.append("\n" + splitStringArray[arrayIterator]);
			}
			logger.debug(":7039:" + freeText + "<<<END>>>");

		} catch (Exception e) {
			logger.error("FreeText 7039 parsing exception..!" + e.getMessage());
		}
		return freeText.toString();
	}

}
