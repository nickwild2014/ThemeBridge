package com.bs.themebridge.server.adapter;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

/**
 * interface IServiceProcessor is works as bridge between ServiceHandler and
 * ServiceRouter.
 * 
 * @author Bluescope
 * 
 */
public interface IServiceProcessor {

	/**
	 * Method process
	 * 
	 * To process the input xml from TI
	 * 
	 * @param inputXml
	 *            : input service xml from TI
	 * @return
	 * @throws ClassNotFoundException
	 * 
	 */
	public String process(String inputXml) throws ClassNotFoundException,
			ParserConfigurationException, SAXException, IOException,
			JAXBException;

}
