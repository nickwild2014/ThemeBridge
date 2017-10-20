package com.bs.themebridge.incoming.util;

import org.apache.log4j.Logger;

import com.bs.themebridge.util.ValidationsUtil;
import com.misys.tiplus2.services.control.ReplyFormatEnum;
import com.misys.tiplus2.services.control.ServiceRequest.RequestHeader;
import com.misys.tiplus2.services.control.ServiceRequest.RequestHeader.Credentials;
import com.misys.tiplus2.services.control.TransactionControlEnum;
import com.misys.tiplus2.services.control.YNEnum;

/**
 * Processor for Incoming request to TI
 * 
 * @author ThemeBridge
 * 
 */
public class IncomingServiceProcessor {

	private final static Logger logger = Logger.getLogger(IncomingServiceProcessor.class);

	public RequestHeader requestHeader;

	public IncomingServiceProcessor(String name, String correlationId, String service, String operation)
			throws Exception {

		requestHeader = new RequestHeader();

		if (ValidationsUtil.isValidString(correlationId)) {
			requestHeader.setCorrelationId(correlationId);
		} else {
			requestHeader.setCorrelationId("");
		}

		if (ValidationsUtil.isValidString(service)) {
			requestHeader.setService(service);
		} else {
			requestHeader.setService("");
		}
		if (ValidationsUtil.isValidString(operation)) {
			requestHeader.setOperation(operation);
		} else {

		}

		Credentials credentials = new Credentials();
		if (ValidationsUtil.isValidString(name)) {
			credentials.setName(name);
		} else {
			credentials.setName("");
		}

		requestHeader.setCredentials(credentials);
		requestHeader.setReplyFormat(ReplyFormatEnum.FULL);
		requestHeader.setNoRepair(YNEnum.Y);
		requestHeader.setNoOverride(YNEnum.Y);
		requestHeader.setTransactionControl(TransactionControlEnum.NONE);
	}

}
