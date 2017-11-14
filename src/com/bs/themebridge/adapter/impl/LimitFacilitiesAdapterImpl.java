package com.bs.themebridge.adapter.impl;

import static com.bs.themebridge.util.ThemeConstant.OPERATION_FACILITIES;
import static com.bs.themebridge.util.ThemeConstant.SERVICE_LIMIT;

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
import com.bs.themebridge.util.ValidationsUtil;
import com.misys.tiplus2.services.control.ServiceResponse.ResponseHeader;

/**
 * @author Bluescope
 * @see class LimitFacilityAdapterImpl used to implement the Limit checking in
 *      the Core System.
 */
public class LimitFacilitiesAdapterImpl extends ServiceAdapterImpl {

	private final static Logger logger = Logger
			.getLogger(LimitFacilitiesAdapterImpl.class);

	@Override
	public String process(String inputXml) throws ClassNotFoundException {

		logger.info(" ************ Limit.Facilities impl process started ************ ");
		AdapteeInterface serviceAdaptee = null;
		String result = "";
		try {
			logger.debug("Initiate Limit Facilities Adaptee");
			serviceAdaptee = getAdapteeInstance(inputXml);

			if (ValidationsUtil.isValidString(inputXml)) {
				result = serviceAdaptee.process(inputXml);
			} else {
				result = getErrorResponse("TI requestXML is empty");
			}
		} catch (ParserConfigurationException e) {
			logger.error(e.getMessage(), e);
			result = getErrorResponse("Unexpected error");
		} catch (SAXException e) {
			logger.error(e.getMessage(), e);
			result = getErrorResponse("Unexpected error");
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			result = getErrorResponse("Unexpected error");
		} catch (JAXBException e) {
			logger.error(e.getMessage(), e);
			result = getErrorResponse("Unexpected error");
		} catch (ServiceException e) {
			logger.error(e.getMessage(), e);
			result = getErrorResponse("Unexpected error");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = getErrorResponse("Unexpected error");
		} finally {
			// TODO nothing
		}
		logger.info(" ************ Limit.Facilities impl process ended ************ ");
		return result;
	}

	/**
	 * Get error response to TI
	 * 
	 * @param errorMessage
	 * @return {@link String}
	 */
	public static String getErrorResponse(String errorMessage) {
		String result = "";
		ResponseHeader responseHeader = null;
		if (ValidationsUtil.isValidString(errorMessage)) {
			responseHeader = ResponseHeaderUtil.failedResponse(SERVICE_LIMIT,
					OPERATION_FACILITIES, "", "", errorMessage + " (IM)");
		} else {
			responseHeader = ResponseHeaderUtil.failedResponse(SERVICE_LIMIT,
					OPERATION_FACILITIES, "", "", "Unexpected Error" + " (IM)");
			result = ResponseHeaderUtil
					.getTIFailedResponseByResponseHeader(responseHeader);
		}
		result = ResponseHeaderUtil
				.getTIFailedResponseByResponseHeader(responseHeader);
		return result;
	}

	/**
	 * @param errorMessage
	 *            {@code allows }{@link String}
	 * @return {@link String}
	 */
	public AdapteeInterface getAdapteeInstance(String inputXml) {

		AdapteeInterface implementationClass = AdapteeUtil.getAdapteeInstance(
				inputXml, AdapteeImplementation.getLimitfacilitiesadaptee());
		// logger.info("Calling Limit Facilities adaptee " +
				// implementationClass);
		return implementationClass;
	}

	/**
	 * Method getLimitFacilities
	 * 
	 * <p>
	 * To fetch limit facility from core
	 * </p>
	 * 
	 * @param inputXml
	 *            {@code is request from TI, allowed object is } {@link String }
	 */
	@Override
	public String getLimitFacilities(String inputXml) {

		return null;
	}

	/**
	 * Converts TI request to bank request
	 * 
	 * @param object
	 *            {@code is request from TI, allowed object is }
	 *            {@link Document }
	 */
	@Override
	public String getBankRequestFromTIRequest(Document object) {
		String result = "";

		return result;
	}

	/**
	 * Converts bank response to TI response
	 * 
	 * @param bankResponse
	 *            {@code is response from bank, allowed object is }
	 *            {@link String }
	 */
	@Override
	public String getTIResponseFromBankResponse(String bankResponse) {
		String result = "";

		return result;
	}

}
