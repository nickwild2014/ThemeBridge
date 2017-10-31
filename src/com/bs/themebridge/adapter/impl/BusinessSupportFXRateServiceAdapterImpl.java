package com.bs.themebridge.adapter.impl;

import static com.bs.themebridge.util.ThemeConstant.OPERATION_FXOPTIONSSEARCH;
import static com.bs.themebridge.util.ThemeConstant.SERVICE_BUSINESSSUPPORT;

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

public class BusinessSupportFXRateServiceAdapterImpl extends ServiceAdapterImpl {

	private final static Logger logger = Logger.getLogger(BusinessSupportFXRateServiceAdapterImpl.class);

	
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
			responseHeader = ResponseHeaderUtil.failedResponse(SERVICE_BUSINESSSUPPORT, OPERATION_FXOPTIONSSEARCH, "",
					"", errorMessage);
		} else {
			responseHeader = ResponseHeaderUtil.failedResponse(SERVICE_BUSINESSSUPPORT, OPERATION_FXOPTIONSSEARCH, "",
					"", "Unexpected Error");
			result = ResponseHeaderUtil.getTIFailedResponseByResponseHeader(responseHeader);
		}
		result = ResponseHeaderUtil.getTIFailedResponseByResponseHeader(responseHeader);
		return result;
	}

	@Override
	public String process(String inputXml) throws ClassNotFoundException {

		logger.info(" ************ BusinessSupport.FXRateService impl process started ************ ");
		AdapteeInterface serviceAdaptee = null;
		String result = "";
		String bankRequest = "";
		String bankResponse = "";
		boolean isValid = false;
		try {
			logger.debug("BusinessSupport FXRateService impl method.....");
			serviceAdaptee = getAdapteeInstance(inputXml);

			bankRequest = inputXml;
			// logger.debug("Request Message : \n" + inputXml);
			bankResponse = serviceAdaptee.process(inputXml);

			// logger.debug("Response Message : \n" + bankResponse);
			if (ValidationsUtil.isValidString(bankResponse)) {

				// converting bank response to TI response.
				result = bankResponse;
				isValid = true;

			} else {
				result = bankResponse;
				isValid = false;
			}

		} catch (ParserConfigurationException e) {
			logger.error(e.getMessage(), e);
			result = getErrorResponse("Unexpected host error [IM]");
			isValid = false;

		} catch (SAXException e) {
			logger.error(e.getMessage(), e);
			result = getErrorResponse("Unexpected host error [IM]");
			isValid = false;
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			result = getErrorResponse("Unexpected host error [IM]");
			isValid = false;
		} catch (JAXBException e) {
			logger.error(e.getMessage(), e);
			result = getErrorResponse("Unexpected host error [IM]");
			isValid = false;
		} catch (ServiceException e) {
			logger.error(e.getMessage(), e);
			result = getErrorResponse("Unexpected host error [IM]");
			isValid = false;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = getErrorResponse("Unexpected host error [IM]");
			isValid = false;
		}

		logger.info(" ************ BusinessSupport.FXOptionsSearch impl process ended ************ ");
		return result;
	}

	public AdapteeInterface getAdapteeInstance(String inputXml) {

		AdapteeInterface implementationClass = AdapteeUtil.getAdapteeInstance(inputXml,
				AdapteeImplementation.getBusinesssupportfxrateserviceadaptee());

		return implementationClass;
	}
}
