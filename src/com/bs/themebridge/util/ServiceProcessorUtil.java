package com.bs.themebridge.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.misys.tiplus2.services.control.ServiceRequest;
import com.misys.tiplus2.services.control.ServiceRequest.RequestHeader;

/**
 * Process the input xml from request
 * 
 * @author Bluescope
 * 
 */
public class ServiceProcessorUtil {

	private final static Logger logger = Logger.getLogger(ServiceProcessorUtil.class);

	private RequestHeader requestHeader;
	private String inputMessage;
	private Document document;
	private String reqServiceOperation;
	private String reqService;

	public RequestHeader getRequestHeader() {
		return requestHeader;
	}

	public void setRequestHeader(RequestHeader requestHeader) {
		this.requestHeader = requestHeader;
	}

	public String getInputMessage() {
		return inputMessage;
	}

	public void setInputMessage(String inputMessage) {
		this.inputMessage = inputMessage;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public String getReqServiceOperation() {
		return reqServiceOperation;
	}

	public void setReqServiceOperation(String reqServiceOperation) {
		this.reqServiceOperation = reqServiceOperation;
	}

	public String getReqService() {
		return reqService;
	}

	public void setReqService(String reqService) {
		this.reqService = reqService;
	}

	/**
	 * Constructor ServiceProcessorUtil
	 * 
	 * process the input xml
	 * 
	 * @param inputXml
	 *            : input from TI
	 */
	public ServiceProcessorUtil(String inputXml)
			throws ParserConfigurationException, SAXException, IOException, JAXBException {

		// logger.debug("Input XML in Adaptee ***** " + inputXml);
		// logger.debug("ServiceProcessorUtil Request XML : " + inputXml);
		inputMessage = inputXml;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		DocumentBuilder db = dbf.newDocumentBuilder();
		document = db.parse(new ByteArrayInputStream(inputMessage.getBytes()));
		InputStream inStream = new ByteArrayInputStream(inputXml.getBytes());
		JAXBContext context = JAXBContext.newInstance(ServiceRequest.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		ServiceRequest serviceRequest = (ServiceRequest) unmarshaller.unmarshal(inStream);
		requestHeader = serviceRequest.getRequestHeader();
		reqService = requestHeader.getService();
		reqServiceOperation = requestHeader.getService() + requestHeader.getOperation();
		// logger.debug("ServiceOperation -> " + reqServiceOperation);
		inStream.close();
	}

	public ServiceProcessorUtil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void initialize(String inputXml)
			throws ParserConfigurationException, SAXException, IOException, JAXBException {

		inputMessage = inputXml;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		DocumentBuilder db = dbf.newDocumentBuilder();
		document = db.parse(new ByteArrayInputStream(inputMessage.getBytes()));
		InputStream inStream = new ByteArrayInputStream(inputXml.getBytes());
		JAXBContext context = JAXBContext.newInstance(ServiceRequest.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		ServiceRequest serviceRequest = (ServiceRequest) unmarshaller.unmarshal(inStream);
		requestHeader = serviceRequest.getRequestHeader();
		reqService = requestHeader.getService();
		reqServiceOperation = requestHeader.getService() + requestHeader.getOperation();
		// logger.debug("ServiceOperation -> " + reqServiceOperation);
		inStream.close();
	}

}
