package com.bs.themebridge.adapter.impl;

import static com.bs.themebridge.util.ThemeConstant.OPERATION_BATCH;
import static com.bs.themebridge.util.ThemeConstant.SERVICE_BACKOFFICE;

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

public class BackOfficeBatchAdapterImpl extends ServiceAdapterImpl {

	private final static Logger logger = Logger.getLogger(BackOfficeBatchAdapterImpl.class);

	@Override
	public String process(String inputXml) throws ClassNotFoundException {

		logger.info(" ************ Backoffice.Batch impl process started ************ ");

		AdapteeInterface serviceAdaptee = null;
		String result = "";
		boolean isValid = false;

		try {
			logger.debug("Initiate Backoffice Batch-Posting  Adaptee");
			serviceAdaptee = getAdapteeInstance(inputXml);

			if (ValidationsUtil.isValidString(inputXml)) {
				result = serviceAdaptee.process(inputXml);
			} else {
				result = getErrorResponse("TI requestXML is empty", "00001");
			}

		} catch (ParserConfigurationException e) {
			logger.error(e.getMessage(), e);
			result = getErrorResponse("Unexpected Error (IM) - " + e.getMessage(), "00001");
			isValid = false;
		} catch (SAXException e) {
			logger.error(e.getMessage(), e);
			result = getErrorResponse("Unexpected Error (IM) - " + e.getMessage(), "00001");
			isValid = false;
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			result = getErrorResponse("Unexpected Error (IM) - " + e.getMessage(), "00001");
			isValid = false;
		} catch (JAXBException e) {
			logger.error(e.getMessage(), e);
			result = getErrorResponse("Unexpected Error (IM) - " + e.getMessage(), "00001");
			isValid = false;
		} catch (ServiceException e) {
			logger.error(e.getMessage(), e);
			result = getErrorResponse("Unexpected Error (IM) - " + e.getMessage(), "00001");
			isValid = false;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = getErrorResponse("Unexpected Error (IM) - " + e.getMessage(), "00001");
			isValid = false;
		} finally {
			logger.info(" ************ BackOffice.Batch impl process ended ************ ");
		}

		return result;
	}

	public AdapteeInterface getAdapteeInstance(String inputXml) {

		AdapteeInterface implementationClass = AdapteeUtil.getAdapteeInstance(inputXml,
				AdapteeImplementation.getBackofficebatchadaptee());
		// logger.info("Calling Backoffice Batch adaptee " +
		// implementationClass);
		return implementationClass;
	}

	/**
	 * Get error response to TI
	 * 
	 * @param errorMessage
	 * @return {@link String}
	 */
	public static String getErrorResponse(String errorMessage, String errorCode) {
		String result = "";
		ResponseHeader responseHeader = null;
		if (ValidationsUtil.isValidString(errorMessage)) {
			responseHeader = ResponseHeaderUtil.failedResponse(SERVICE_BACKOFFICE, OPERATION_BATCH, "", "", errorCode,
					errorMessage + " (IM)");

		} else {
			responseHeader = ResponseHeaderUtil.failedResponse(SERVICE_BACKOFFICE, OPERATION_BATCH, "", "", errorCode,
					"Unexpected Error" + " (IM)");
		}
		result = ResponseHeaderUtil.getTIFailedResponseByResponseHeader(responseHeader);
		return result;
	}

	/**
	 * Method getBackOfficeBatch
	 * 
	 * <p>
	 * To do posting in core system
	 * </p>
	 * 
	 * @param inputXml
	 *            {@code is request from TI, allowed object is } {@link String }
	 */

	public String getBankRequestFromTIRequestWithClaim(Document object, String claimReference) {
		String result = "";

		return result;
	}

	@Override
	public String getBankRequestFromTIRequest(Document object) {
		String result = "";

		return result;
	}

	@Override
	public String getTIResponseFromBankResponse(String bankResponse) {
		String result = "";

		return result;
	}

	public static Boolean checkForEODReference(String eventReference) {
		Boolean flag = false;
		if (eventReference == null || eventReference.equals("PCH") || eventReference.equals("EXP")
				|| eventReference.equals("TRC") || eventReference.equals("EOD")) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public static void main(String[] args) throws Exception {
		try {
			BackOfficeBatchAdapterImpl bobai = new BackOfficeBatchAdapterImpl();
			String response = ThemeBridgeUtil.readFile("C:\\Users\\O4248\\Desktop\\BankRequest.xml");
			String result = bobai.process(response);
			logger.debug("Result : \n " + result);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error(ex);
		}
	}

}
