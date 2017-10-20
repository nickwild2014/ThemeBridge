package com.bs.themebridge.server.gateway.ti;

import java.sql.Timestamp;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.log4j.Logger;

import com.bs.themebridge.logging.StaticLogging;
import com.bs.themebridge.util.ResponseHeaderUtil;
import com.bs.themebridge.util.TIPlusEJBClient;
import com.misys.tiplus2.services.control.StatusEnum;

/**
 * 
 * @author Bluescope
 *
 */
@WebService(serviceName = "TIPlusGateway")
public class TIPlusGateway {

	private final static Logger logger = Logger.getLogger(TIPlusGateway.class);

	/**
	 * Common gateway for TIPlus to push staticdata XML String as input.
	 * 
	 * @param inputXML
	 * @return
	 */
	@WebMethod(operationName = "processData")
	public String process(@WebParam(name = "input") final String inputXML) {

		logger.info("*** Entering into TIPlusGateway ***");
		logger.debug("TIPlusGateway input Data \n" + inputXML);
		String type = "";
		String errorMsg = "";
		String tiResponseXml = "";
		StatusEnum statusEnum = null;
		Timestamp reqReceivedTime = null;
		try {
			type = "XML";
			// RequestHeaderUtil.
			reqReceivedTime = null;
			tiResponseXml = TIPlusEJBClient.process(inputXML);
			statusEnum = ResponseHeaderUtil.processEJBClientResponse(tiResponseXml);

		} catch (Exception e) {
			errorMsg = e.getMessage();
			logger.error("BridgeGateway process error.\n" + e.getMessage());
			e.printStackTrace();

		} finally {
			logger.debug("TIPlusGateway Logging...");

			// StaticLogging.pushLogData("TI", "", "ZONE1", "", "EXTSYS",
			// "TIPlus", inputXML, inputXML, tiResponseXml,
			// statusEnum.toString(), false, "0", "", "", "", type);

			// New Logging
			StaticLogging.pushLogData("TI", "", "ZONE1", "ALL", "EXTSYS", "TIPlus", statusEnum.toString(),
					reqReceivedTime, inputXML, inputXML, tiResponseXml, "", "", "", false, "0", type);
		}
		logger.debug("*** TIGateway process finished ***");
		return tiResponseXml;
	}

}
