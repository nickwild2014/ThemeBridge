package com.bs.themebridge.adapter.impl;

import static com.bs.themebridge.util.ThemeConstant.OPERATION_ACCOUNTSEARCH;
import static com.bs.themebridge.util.ThemeConstant.SERVICE_ACCOUNT;

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

public class AccountAccountSearchAdapterImpl extends ServiceAdapterImpl {

	private final static Logger logger = Logger.getLogger(AccountAccountSearchAdapterImpl.class);

	@Override
	public String process(String inputXml) throws ClassNotFoundException {
		logger.debug("Request enters AccountAccountSearch Adapter");
		AdapteeInterface serviceAdaptee;
		String result = "";
		try {
			serviceAdaptee = getAdapteeInstance(inputXml);
			result = serviceAdaptee.process(inputXml);
			if (result == null) {
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

	public static String getErrorResponse(String errorMessage) {
		String result = "";
		ResponseHeader responseHeader = null;
		if (ValidationsUtil.isValidString(errorMessage)) {
			responseHeader = ResponseHeaderUtil.failedResponse(SERVICE_ACCOUNT, OPERATION_ACCOUNTSEARCH, "", "",
					errorMessage + " (IM)");

		} else {
			responseHeader = ResponseHeaderUtil.failedResponse(SERVICE_ACCOUNT, OPERATION_ACCOUNTSEARCH, "", "",
					"Unexpected Error" + " (IM)");
		}
		result = ResponseHeaderUtil.getTIFailedResponseByResponseHeader(responseHeader);
		return result;
	}

	public AdapteeInterface getAdapteeInstance(String inputXml) {

		AdapteeInterface implementationClass = AdapteeUtil.getAdapteeInstance(inputXml,
				AdapteeImplementation.getAccountaccountsearchadaptee());

		return implementationClass;
	}

}
