package com.bs.themebridge.server.gateway.in;

import java.io.IOException;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.ws.WebServiceContext;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.bs.themebridge.server.adapter.IServiceProcessor;
import com.bs.themebridge.server.service.ServiceHandler;
import com.bs.themebridge.util.ThemeBridgeUtil;

/**
 * Its an common gateway for all the services between TI and Core System.
 * 
 * @author Bluescope
 */
@WebService(serviceName = "BridgeGateway")
// @HandlerChain(file = "handler-chain.xml")
public class BridgeGateway implements Gateway {

	private final static Logger logger = Logger.getLogger(BridgeGateway.class);

	@Resource
	private WebServiceContext serviceContext;

	/**
	 * Common gateway for TIPlus to interface with core banking services. This
	 * method will accept input as XML String and returns the processed response
	 * as XML String to Theme Transport Client.
	 * 
	 * @param input
	 *            {@code allows }{@link String}
	 *            {@code i.e, Input XML from TI through ThemeTransportClient}
	 * @return {@link String},
	 *         {@code returns the processed result from core to TI Plus via Theme
	 *         Transport Client}
	 * @throws Exception
	 */
	@WebMethod(operationName = "process")
	public String process(@WebParam(name = "input") final String input) {

		// logger.debug("*** Entering into BridgeGateway ***");
		 logger.debug("*** BridgeGateway ***" + input);
		String result = "";
		try {
			final IServiceProcessor aServiceHandler = new ServiceHandler();
			result = aServiceHandler.process(input);
		} catch (Exception e) {
			logger.error("BridgeGateway process error!!!\n" + e.getMessage(), e);
		}
		// logger.debug("*** BridgeGateway process end ***");
		return result;
	}

}
