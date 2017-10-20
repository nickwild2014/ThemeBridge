package com.bs.themebridge.server.service;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import com.bs.themebridge.server.adapter.IServiceProcessor;
import com.bs.themebridge.server.gateway.in.BridgeGateway;

/**
 * Service ServiceHandler Class process the input XMl from TI and pass the input
 * to the Service Router for routing.And as the return result of process()
 * method is send back to TI as service Response through Gateway. ServiceHandler
 * implements IServiceProcess interface.
 * 
 * @author BlueScope
 */
public class ServiceHandler implements IServiceProcessor {

	private final static Logger logger = Logger.getLogger(BridgeGateway.class);
	IServiceProcessor bridgeAdapter;

	/**
	 * 
	 * process the request from TI
	 * 
	 * @param inputXMl
	 *            : Handling the service xml from TI by passing into Service
	 *            Router for routing from Service Handler.
	 * @return : Returning the response for the corresponding request xml.
	 * @throws JAXBException
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	@Override
	public String process(String inputXml)
			throws ClassNotFoundException, ParserConfigurationException, SAXException, IOException, JAXBException {
		// logger.debug("*** ServiceHandler process started ***");
		String result = "";
		try {
			bridgeAdapter = new ServiceRouter(inputXml);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		result = bridgeAdapter.process(inputXml);
		// logger.debug("*** ServiceHandler process ended ***");
		return result;
	}
}
