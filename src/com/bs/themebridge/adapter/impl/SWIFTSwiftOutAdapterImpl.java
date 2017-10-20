package com.bs.themebridge.adapter.impl;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.bs.themebridge.serverinterface.AdapteeImplementation;
import com.bs.themebridge.serverinterface.AdapteeInterface;
import com.bs.themebridge.serverinterface.AdapteeUtil;
import com.bs.themebridge.serverinterface.ServiceAdapterImpl;
import com.bs.themebridge.util.ResponseHeaderUtil;
import com.bs.themebridge.util.ThemeBridgeUtil;
import com.bs.themebridge.util.ValidationsUtil;
import com.misys.tiplus2.services.control.ServiceResponse.ResponseHeader;

public class SWIFTSwiftOutAdapterImpl extends ServiceAdapterImpl {

	private final static Logger logger = Logger.getLogger(SWIFTSwiftOutAdapterImpl.class);

	@Override
	public String process(String inputXml) throws ClassNotFoundException {

		logger.info(" ************ SWIFT.SwiftOut adapter impl process started ************ ");
		String result = "";
		AdapteeInterface serviceAdaptee;
		try {
			// logger.debug("Initiate SWIFT SwiftOut Adaptee");
			serviceAdaptee = getAdapteeInstance(inputXml);

			if (ValidationsUtil.isValidString(inputXml)) {
				result = serviceAdaptee.process(inputXml);
			} else {
				result = getErrorResponse("TI requestXML is empty");
			}
		} catch (ParserConfigurationException e) {
			logger.error(e.getMessage(), e);
			result = getErrorResponse("Unexpected error " + e.getMessage());
		} catch (SAXException e) {
			logger.error(e.getMessage(), e);
			result = getErrorResponse("Unexpected error " + e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			result = getErrorResponse("Unexpected error " + e.getMessage());
		} catch (JAXBException e) {
			logger.error(e.getMessage(), e);
			result = getErrorResponse("Unexpected error " + e.getMessage());
		} catch (ServiceException e) {
			logger.error(e.getMessage(), e);
			result = getErrorResponse("Unexpected error " + e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = getErrorResponse("Unexpected error " + e.getMessage());
		} finally {
			// TODO nothing
		}
		logger.info(" ************ SWIFT.SwiftOut adapter impl process ended ************ ");
		return result;
	}

	/**
	 * Method getErrorResponse
	 * 
	 * @param errorMessage
	 *            {@code allows }{@link String}
	 * @return
	 */
	public static String getErrorResponse(String errorMessage) {

		logger.debug("***** SWIFT SwiftOut error response initiated *****");
		String result = "";
		if (ValidationsUtil.isValidString(errorMessage)) {
			ResponseHeader responseHeader = ResponseHeaderUtil.failedResponse("service", "OPERATION", "", "",
					errorMessage + " (IM)");
			result = ResponseHeaderUtil.getTIFailedResponseByResponseHeader(responseHeader);
		} else {
			ResponseHeader responseHeader = ResponseHeaderUtil.failedResponse("service", "OPERATION", "", "",
					"Unexpected Error" + " (IM)");
			result = ResponseHeaderUtil.getTIFailedResponseByResponseHeader(responseHeader);
		}
		return result;
	}

	/**
	 * Method getSwiftOut
	 * 
	 * <p>
	 * To send swift out to core system
	 * </p>
	 * 
	 * @param inputXml
	 *            {@code is request from TI, allowed object is } {@link String }
	 */
	@Override
	public String getSwiftOut(String inputXml) {
		return null;
	}

	/**
	 * Get the swift messages from TI
	 */
	@Override
	public String getBankRequestFromTIRequest(Document object) {
		String result = "";

		return result;
	}

	@Override
	public String getTIResponseFromBankResponse(String result) {
		return null;
	}

	public AdapteeInterface getAdapteeInstance(String inputXml) {

		AdapteeInterface implementationClass = AdapteeUtil.getAdapteeInstance(inputXml,
				AdapteeImplementation.getSwiftoutadaptee());
		return implementationClass;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SWIFTSwiftOutAdapterImpl bob = new SWIFTSwiftOutAdapterImpl();
		try {
			bob.getSwiftOut(ThemeBridgeUtil.readFile("C:\\Users\\Supreme\\Desktop\\SwiftOut_202.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
