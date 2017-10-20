package com.bs.themebridge.server.gateway.in;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.xml.sax.SAXException;

/**
 * Its an Common gateway for all the services between TI and Core System.
 * 
 * @author Bluescope
 */
@WebService
// @HandlerChain(file = "handler-chain.xml")
@SOAPBinding(style = Style.RPC)
public interface Gateway {

	/**
	 * Common gateway for TIPlus to interface with core banking service. This
	 * method will accept input as XML String and returns the processed response
	 * as XML String to Theme Transport Client.
	 * 
	 * @param input
	 *            {@code allows }{@link String}
	 *            {@code i.e, Input XML from TI through ThemeTransportClient}
	 * 
	 * @return {@link String},
	 *         {@code returns the processed result from core to TI Plus via Theme
	 *         Transport Client}
	 * @throws JAXBException
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	@WebMethod(operationName = "process")
	public String process(@WebParam(name = "input") final String input);

}
