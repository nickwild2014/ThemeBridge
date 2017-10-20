package com.bs.themebridge.adapter.impl;

import static com.bs.themebridge.util.ThemeConstant.OPERATION_VERIFY;
import static com.bs.themebridge.util.ThemeConstant.SERVICE_BACKOFFICE;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.bs.themebridge.serverinterface.AdapteeImplementation;
import com.bs.themebridge.serverinterface.AdapteeInterface;
import com.bs.themebridge.serverinterface.AdapteeUtil;
import com.bs.themebridge.serverinterface.ServiceAdapterImpl;
import com.bs.themebridge.util.ResponseHeaderUtil;
import com.bs.themebridge.util.ValidationsUtil;
import com.misys.tiplus2.services.control.ServiceResponse.ResponseHeader;

public class BackOfficeVerifyAdapterImpl extends ServiceAdapterImpl {

	private final static Logger logger = Logger
			.getLogger(BackOfficeVerifyAdapterImpl.class);

	/**
	 * Method getBackOfficeVerify
	 * 
	 * <p>To send posting information to core system for verification</p>
	 * 
	 * @param inputXml
	 *            {@code is request from TI, allowed object is }
	 *            {@link String }
	 */
	@Override
	public String getBackOfficeVerify(String inputXml) {
		
		return null;
	}

	public static String getErrorResponse(String errorMessage) {
		String result = "";
		ResponseHeader responseHeader = null;
		if (ValidationsUtil.isValidString(errorMessage)) {
			responseHeader = ResponseHeaderUtil.failedResponse(
					SERVICE_BACKOFFICE, OPERATION_VERIFY, "", "",
					errorMessage + " (IM)");

		} else {
			responseHeader = ResponseHeaderUtil.failedResponse(
					SERVICE_BACKOFFICE, OPERATION_VERIFY, "", "",
					"Unexpected Error" + " (IM)");
		}
		result = ResponseHeaderUtil
				.getTIFailedResponseByResponseHeader(responseHeader);
		return result;
	}

	@Override
	public String process(String inputXml) throws ClassNotFoundException {
		logger.debug("Request enters Backoffice Batch Adapter");
		AdapteeInterface serviceAdaptee;
		String result = "";
		try {
			serviceAdaptee=getAdapteeInstance(inputXml);
			
			result = serviceAdaptee.process(inputXml);
			
			if (result==null) {
				result = getErrorResponse("Endsystem request is empty");	
			}
		} catch (ParserConfigurationException e) {
			logger.error(e.getMessage(), e);
		} catch (SAXException e) {
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} catch (JAXBException e) {
			logger.error(e.getMessage(), e);
		} catch (ServiceException e) {
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}
	
public AdapteeInterface getAdapteeInstance(String inputXml){
		
		
		AdapteeInterface implementationClass  = AdapteeUtil.getAdapteeInstance(inputXml,
				                        AdapteeImplementation.getBackofficeverifyadaptee());

		return implementationClass; 
	}

}
