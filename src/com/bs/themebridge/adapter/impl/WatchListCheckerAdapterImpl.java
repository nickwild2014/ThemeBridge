package com.bs.themebridge.adapter.impl;

import static com.bs.themebridge.util.ThemeConstant.SERVICE_GATEWAY;

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

public class WatchListCheckerAdapterImpl extends ServiceAdapterImpl {

	private final static Logger logger = Logger.getLogger(WatchListCheckerAdapterImpl.class);

	@Override
	public String process(String inputXml) throws ClassNotFoundException {

		logger.info(" ************ NCIF / WatchList / TI-TFWLCRSP impl process started ************ ");

		String result = "";
		AdapteeInterface serviceAdaptee = null;

		try {
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
		}

		logger.info(" ************ NCIF / WatchList / TI-TFWLCRSP impl process ended ************ ");
		return result;
	}

	public AdapteeInterface getAdapteeInstance(String inputXml) {

		AdapteeInterface implementationClass = AdapteeUtil.getAdapteeInstance(inputXml,
				AdapteeImplementation.getWatchlistcheckeradaptee());

		return implementationClass;
	}

	public static String getErrorResponse(String errorMessage) {
		String result = "";
		if (ValidationsUtil.isValidString(errorMessage)) {
			ResponseHeader responseHeader = ResponseHeaderUtil.failedResponse(SERVICE_GATEWAY, "", "", "",
					errorMessage + " (IM)");
			result = ResponseHeaderUtil.getTIFailedResponseByResponseHeader(responseHeader);
		} else {
			ResponseHeader responseHeader = ResponseHeaderUtil.failedResponse(SERVICE_GATEWAY, "", "", "",
					"Unexpected Error" + " (IM)");
			result = ResponseHeaderUtil.getTIFailedResponseByResponseHeader(responseHeader);

		}
		return result;
	}

}
