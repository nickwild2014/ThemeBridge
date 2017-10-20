package com.bs.themebridge.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.misys.tiplus2.services.control.ServiceResponse;
import com.misys.tiplus2.services.control.ServiceResponse.ResponseHeader;
import com.misys.tiplus2.services.control.ServiceResponse.ResponseHeader.Details;
import com.misys.tiplus2.services.control.StatusEnum;

/**
 * To extract RsponseHeader information from XML
 * 
 * @author BlueScope
 * 
 */
public class ResponseHeaderUtil {

	private final static Logger logger = Logger.getLogger(ResponseHeaderUtil.class);

	/**
	 * Returns sample response
	 * 
	 * <p>
	 * <b>Note:</b>
	 * {@code "status" value is '1' for Success, '0' for Failed, '-1' for Unavailable}
	 * </p>
	 * 
	 * @param status
	 *            {@code allows } {@link String}
	 * @param service
	 *            {@code allows } {@link String}
	 * @param operation
	 *            {@code allows } {@link String}
	 * @param correlationId
	 *            {@code allows } {@link String}
	 * @return {@link String}
	 */
	public static String sampleResponse(String status, String service, String operation, String correlationId) {

		ResponseHeader responseHeader = new ResponseHeader();
		responseHeader.setService(service);
		responseHeader.setOperation(operation);
		if (ValidationsUtil.isValidString(correlationId)) {
			responseHeader.setCorrelationId(correlationId);
		} else {
			responseHeader.setCorrelationId(ThemeBridgeUtil.randomCorrelationId());
		}
		if (status.equalsIgnoreCase("1"))
			responseHeader.setStatus(StatusEnum.SUCCEEDED);
		if (status.equalsIgnoreCase("0"))
			responseHeader.setStatus(StatusEnum.FAILED);
		if (status.equalsIgnoreCase("-1"))
			responseHeader.setStatus(StatusEnum.UNAVAILABLE);
		String response = "";
		try {
			response = getTIResponseByResponseHeader(responseHeader);
		} catch (Exception exp) {
			logger.error("Exception throws", exp);
		}
		return response;
	}

	/**
	 * Get status from TI Response header
	 * 
	 * @param result
	 * 
	 * @return {@link StatusEnum}
	 */
	public static StatusEnum processEJBClientResponse(String result) {

		StatusEnum statusEnum = null;
		InputStream inStream = null;
		try {
			inStream = new ByteArrayInputStream(result.getBytes());
			JAXBContext context = JAXBInstanceInitialiser.getServiceResponseContext();
			Unmarshaller unmarshaller = context.createUnmarshaller();
			ServiceResponse response = (ServiceResponse) unmarshaller.unmarshal(inStream);
			ResponseHeader responseHeader = response.getResponseHeader();
			statusEnum = responseHeader.getStatus();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			statusEnum = StatusEnum.UNAVAILABLE;
		} finally {
			try {
				inStream.close();
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}
		return statusEnum;
	}

	public static String processEJBClientFailedResponse(String result) {

		String output = "";
		List<String> aErrorMsg = null;
		List<String> aInfoMsg = null;
		List<String> aWarning = null;
		InputStream inStream = null;
		try {
			inStream = new ByteArrayInputStream(result.getBytes());
			JAXBContext context = JAXBInstanceInitialiser.getServiceResponseContext();
			Unmarshaller unmarshaller;
			unmarshaller = context.createUnmarshaller();
			ServiceResponse response = (ServiceResponse) unmarshaller.unmarshal(inStream);
			ResponseHeader responseHeader = response.getResponseHeader();
			responseHeader.getDetails();
			ResponseHeader.Details aDetails = response.getResponseHeader().getDetails();
			aErrorMsg = aDetails.getError();
			aInfoMsg = aDetails.getInfo();
			aWarning = aDetails.getWarning();

			if (!aInfoMsg.isEmpty()) {
				logger.debug("\n\n Information : " + aInfoMsg.toString() + "\n");
				output = aInfoMsg.toString();
			}
			if (!aWarning.isEmpty()) {
				logger.debug("\n\n Warning : " + aWarning.toString() + "\n");
				output = aWarning.toString();
			}
			if (!aErrorMsg.isEmpty()) {
				logger.debug("\n\n ErrorMessage : " + aErrorMsg.toString() + "\n");
				output = aErrorMsg.toString();
			}
			logger.debug("ResponseHeader error mesage : \n" + responseHeader);
		} catch (JAXBException e) {
			logger.error(e.getMessage(), e);
		} finally {
			try {
				inStream.close();
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}
		return output;
	}

	/**
	 * Returns ResponseHeader with arguments value
	 * 
	 * @param service
	 *            {@code allows } {@link String}
	 * @param operation
	 *            {@code allows } {@link String}
	 * @param sourceSystem
	 *            {@code allows } {@link String}
	 * @param targetSystem
	 *            {@code allows } {@link String}
	 * @return {@link ResponseHeader}
	 */
	public static ResponseHeader getResponseHeader(String service, String operation, String sourceSystem,
			String targetSystem) {
		ResponseHeader responseHeader = new ResponseHeader();
		if (ValidationsUtil.isValidString(service)) {
			responseHeader.setService(service);
		} else {
			responseHeader.setService("");
		}
		if (ValidationsUtil.isValidString(operation)) {
			responseHeader.setOperation(operation);
		} else {
			responseHeader.setOperation("");
		}

		if (ValidationsUtil.isValidString(sourceSystem)) {
			responseHeader.setSourceSystem(sourceSystem);
		} else {
			// responseHeader.setSourceSystem("");
		}
		if (ValidationsUtil.isValidString(targetSystem)) {
			responseHeader.setTargetSystem(targetSystem);
		} else {
			// responseHeader.setTargetSystem("");
		}
		return responseHeader;
	}

	/**
	 * Return TI response in String
	 * 
	 * @param responseHeader
	 *            {@code allows } {@link ResponseHeader}
	 * @return {@link String}
	 */
	public static String getTIFailedResponseByResponseHeader(ResponseHeader responseHeader) {
		String response = "";
		try {
			responseHeader.setStatus(StatusEnum.FAILED);
			response = getTIResponseByResponseHeader(responseHeader);
		} catch (Exception exp) {
			logger.error("Exception throws", exp);
		}
		return response;
	}

	/**
	 * Return failed response of ResponseHeader
	 * 
	 * @param service
	 *            {@code allows } {@link String}
	 * @param operation
	 *            {@code allows } {@link String}
	 * @param sourceSystem
	 *            {@code allows } {@link String}
	 * @param targetSystem
	 *            {@code allows } {@link String}
	 * @param errorMessage
	 *            {@code allows } {@link String}
	 * @return {@link ResponseHeader}
	 */
	public static ResponseHeader failedResponse(String service, String operation, String sourceSystem,
			String targetSystem, String errorMessage) {

		ResponseHeader responseHeader = getResponseHeader(service, operation, sourceSystem, targetSystem);
		responseHeader.setStatus(StatusEnum.FAILED);
		Details detail = new Details();
		if (ValidationsUtil.isValidString(errorMessage)) {
			errorMessage = errorMessage.replace(':', ' ');
			detail.getError().add(errorMessage);
		} else {
			detail.getError().add("Unexpected error");
		}
		responseHeader.setDetails(detail);
		return responseHeader;
	}

	/**
	 * Return failed response of ResponseHeader
	 * 
	 * @param service
	 *            {@code allows } {@link String}
	 * @param operation
	 *            {@code allows } {@link String}
	 * @param sourceSystem
	 *            {@code allows } {@link String}
	 * @param targetSystem
	 *            {@code allows } {@link String}
	 * @param infoMessage
	 *            {@code allows } {@link String}
	 * @return {@link ResponseHeader}
	 */
	public static ResponseHeader successResponse(String service, String operation, String sourceSystem,
			String targetSystem, String infoMessage) {

		ResponseHeader responseHeader = getResponseHeader(service, operation, sourceSystem, targetSystem);
		responseHeader.setStatus(StatusEnum.SUCCEEDED);
		Details detail = new Details();
		if (ValidationsUtil.isValidString(infoMessage)) {
			detail.getInfo().add(infoMessage);
		} else {
			detail.getInfo().add("Holiday completed successfully");
		}
		responseHeader.setDetails(detail);
		return responseHeader;
	}

	/**
	 * Return Error Response with Success of ResponseHeader
	 * 
	 * @param service
	 *            {@code allows } {@link String}
	 * @param operation
	 *            {@code allows } {@link String}
	 * @param sourceSystem
	 *            {@code allows } {@link String}
	 * @param targetSystem
	 *            {@code allows } {@link String}
	 * @param errorMessage
	 *            {@code allows } {@link String}
	 * @return {@link ResponseHeader}
	 */
	public static ResponseHeader errorSuccessResponse(String service, String operation, String sourceSystem,
			String targetSystem, String errorMessage) {
		ResponseHeader responseHeader = getResponseHeader(service, operation, sourceSystem, targetSystem);
		responseHeader.setStatus(StatusEnum.SUCCEEDED);
		Details detail = new Details();
		if (ValidationsUtil.isValidString(errorMessage)) {
			errorMessage = errorMessage.replace(':', ' ');
			detail.getError().add(errorMessage);
		} else {
			detail.getError().add("BO system fails for these service");
		}
		responseHeader.setDetails(detail);
		return responseHeader;
	}

	/**
	 * Return warning response of ResponseHeader
	 * 
	 * @param service
	 *            {@code allows } {@link String}
	 * @param operation
	 *            {@code allows } {@link String}
	 * @param sourceSystem
	 *            {@code allows } {@link String}
	 * @param targetSystem
	 *            {@code allows } {@link String}
	 * @param errorMessage
	 *            {@code allows } {@link String}
	 * @return {@link ResponseHeader}
	 */
	public static ResponseHeader warningResponse(String service, String operation, String sourceSystem,
			String targetSystem, String errorMessage) {

		ResponseHeader responseHeader = getResponseHeader(service, operation, sourceSystem, targetSystem);
		responseHeader.setStatus(StatusEnum.SUCCEEDED);
		Details detail = new Details();
		if (ValidationsUtil.isValidString(errorMessage)) {
			errorMessage = errorMessage.replace(':', ' ');
			detail.getWarning().add(errorMessage);
		} else {
			detail.getError().add("BO system fails for these service");
		}

		responseHeader.setDetails(detail);
		return responseHeader;
	}

	/**
	 * Return failed response of ResponseHeader
	 * 
	 * @param service
	 *            {@code allows } {@link String}
	 * @param operation
	 *            {@code allows } {@link String}
	 * @param sourceSystem
	 *            {@code allows } {@link String}
	 * @param targetSystem
	 *            {@code allows } {@link String}
	 * @param corelationId
	 *            {@code allows } {@link String}
	 * @param errorMessage
	 *            {@code allows } {@link String}
	 * @return {@link ResponseHeader}
	 */
	public static ResponseHeader failedResponse(String service, String operation, String sourceSystem,
			String targetSystem, String corelationId, String errorMessage) {

		ResponseHeader responseHeader = getResponseHeader(service, operation, sourceSystem, targetSystem, corelationId);
		responseHeader.setStatus(StatusEnum.FAILED);
		Details detail = new Details();
		if (ValidationsUtil.isValidString(errorMessage)) {
			detail.getError().add(errorMessage);
		} else {
			detail.getError().add("Unexpected error");
		}
		responseHeader.setDetails(detail);
		return responseHeader;
	}

	/**
	 * Return TI response in String
	 * 
	 * @param responseHeader
	 *            {@code allows } {@link ResponseHeader}
	 * @return {@link String}
	 */
	public static String getTIResponseByResponseHeader(ResponseHeader responseHeader) {

		ServiceResponse serviceResponse = new ServiceResponse();
		serviceResponse.setResponseHeader(responseHeader);
		String response = "";
		try {
			response = ThemeBridgeUtil.convertResponseXMLToString(serviceResponse);
		} catch (Exception exp) {
			logger.error("Exception throws", exp);
		}
		return response;
	}

	/**
	 * Returns ResponseHeader with arguments value
	 * 
	 * @param service
	 *            {@code allows } {@link String}
	 * @param operation
	 *            {@code allows } {@link String}
	 * @param sourceSystem
	 *            {@code allows } {@link String}
	 * @param targetSystem
	 *            {@code allows } {@link String}
	 * @param corelationId
	 *            {@code allows } {@link String}
	 * @return {@link ResponseHeader}
	 */
	public static ResponseHeader getResponseHeader(String service, String operation, String sourceSystem,
			String targetSystem, String corelationId) {

		ResponseHeader responseHeader = getResponseHeader(service, operation, sourceSystem, targetSystem);
		if (ValidationsUtil.isValidString(corelationId)) {
			responseHeader.setCorrelationId(corelationId);
		} else {
			responseHeader.setCorrelationId("");
		}
		return responseHeader;
	}

	/**
	 * Returns ResponseHeader with arguments value
	 * 
	 * @param service
	 *            {@code allows } {@link String}
	 * @param operation
	 *            {@code allows } {@link String}
	 * @param sourceSystem
	 *            {@code allows } {@link String}
	 * @param targetSystem
	 *            {@code allows } {@link String}
	 * @return {@link ResponseHeader}
	 */
	public static ResponseHeader getResponseHeader(String service, String operation) {
		ResponseHeader responseHeader = new ResponseHeader();
		if (ValidationsUtil.isValidString(service)) {
			responseHeader.setService(service);
		} else {
			responseHeader.setService("");
		}
		if (ValidationsUtil.isValidString(operation)) {
			responseHeader.setOperation(operation);
		} else {
			responseHeader.setOperation("");
		}

		return responseHeader;
	}
}
