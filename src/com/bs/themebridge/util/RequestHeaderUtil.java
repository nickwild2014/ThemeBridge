package com.bs.themebridge.util;

import org.apache.log4j.Logger;

import com.misys.tiplus2.services.control.ServiceRequest.RequestHeader;
import com.misys.tiplus2.services.control.ServiceRequest.RequestHeader.Credentials;

/**
 * To extract header information from xml
 * 
 * @author Prasath Ravichandran
 * 
 * 
 */
public class RequestHeaderUtil {

	private final static Logger logger = Logger
			.getLogger(RequestHeaderUtil.class);

	/**
	 * Method getRequestHeader
	 * 
	 * create request header
	 * 
	 * @param name
	 *            : credential name
	 * @param correlationId
	 *            : correlationId
	 * @return request header
	 */
	public static RequestHeader getRequestHeader(String name,
			String correlationId) {

		RequestHeader requestheader = new RequestHeader();
		Credentials credentials = new Credentials();
		if (name != null && !"".equalsIgnoreCase(name)) {
			credentials.setName(name);
		} else {
			credentials.setName("");
		}
		requestheader.setCredentials(credentials);
		if (correlationId != null && !"".equalsIgnoreCase(correlationId)) {
			requestheader.setCorrelationId(correlationId);
		} else {
			requestheader.setCorrelationId("");
		}
		return requestheader;
	}

	/**
	 * Method getRequestHeader
	 * 
	 * create request header
	 * 
	 * @param name
	 *            : credential name
	 * @param correlationId
	 *            : correlationId
	 * @return request header
	 */
	public static RequestHeader getRequestHeader(String service,
			String operation, String name, String correlationId) {
		
		RequestHeader requestheader = new RequestHeader();
		requestheader.setService(service);
		requestheader.setOperation(operation);
		Credentials credentials = new Credentials();
		if (name != null && !"".equalsIgnoreCase(name)) {
			credentials.setName(name);
		} else {
			credentials.setName("");
		}
		requestheader.setCredentials(credentials);
		if (correlationId != null && !"".equalsIgnoreCase(correlationId)) {
			requestheader.setCorrelationId(correlationId);
		} else {
			requestheader.setCorrelationId("");
		}
		return requestheader;
	}

}
