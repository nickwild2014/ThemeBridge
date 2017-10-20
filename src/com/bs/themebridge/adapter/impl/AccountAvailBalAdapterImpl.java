package com.bs.themebridge.adapter.impl;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.bs.theme.bob.template.util.RequestResponseTemplate;
import com.bs.themebridge.serverinterface.AdapteeImplementation;
import com.bs.themebridge.serverinterface.AdapteeInterface;
import com.bs.themebridge.serverinterface.AdapteeUtil;
import com.bs.themebridge.serverinterface.ServiceAdapterImpl;
import com.bs.themebridge.token.util.MapTokenResolver;
import com.bs.themebridge.token.util.TokenReplacingReader;
import com.bs.themebridge.util.ThemeBridgeUtil;
import com.bs.themebridge.util.ValidationsUtil;

/**
 * @author Bluescope
 * @see class AvailBalAdaptee used to implement the Available balance checking
 *      in the Core System.
 */
public class AccountAvailBalAdapterImpl extends ServiceAdapterImpl {

	private final static Logger logger = Logger.getLogger(AccountAvailBalAdapterImpl.class);

	@Override
	public String process(String inputXml) throws ClassNotFoundException {

		logger.info(" ************ Account.AvailBal impl process started ************ ");

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
		logger.info(" ************ Account.AvailBal impl process ended ************ ");
		return result;
	}

	/**
	 * @param inputXml
	 *            {@code allows }{@link String}
	 * @return implementationClass
	 */
	public AdapteeInterface getAdapteeInstance(String inputXml) {
		AdapteeInterface implementationClass = AdapteeUtil.getAdapteeInstance(
				inputXml, AdapteeImplementation.getAccountavailbaladaptee());
		// logger.info("Calling Account AvailBal adaptee " +
		// implementationClass);
		return implementationClass;
	}

	/**
	 * Method getErrorResponse
	 * 
	 * @param errorMessage
	 *            {@code allows }{@link String}
	 * @return
	 */
	public static String getErrorResponse(String errorMsg) {

		logger.debug("***** Account.AvailBal error response initiated *****");

		String response = "";
		Map<String, String> tokens = new HashMap<String, String>();

		try {
			tokens.put("blocked", "N");
			tokens.put("balance", "000000000000000");
			tokens.put("negative", "N");
			tokens.put("error", "Y");
			tokens.put("ErrorMessage", errorMsg + " (IM)");
			MapTokenResolver resolver = new MapTokenResolver(tokens);
			String responseTemplate;
			responseTemplate = ThemeBridgeUtil
					.readPropertiesFile(RequestResponseTemplate.ACCOUNT_AVAILBAL_TI_RESPONSE_TEMPLATE);
			Reader fileValue = new StringReader(responseTemplate);
			Reader reader = new TokenReplacingReader(fileValue, resolver);
			response = reader.toString();
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	@Override
	public String getAvailBal(String inputXml) {
		return null;
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
}
