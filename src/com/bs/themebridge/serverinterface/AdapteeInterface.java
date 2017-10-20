package com.bs.themebridge.serverinterface;

import org.w3c.dom.Document;

import com.misys.tiplus2.services.control.ServiceRequest.RequestHeader;

public interface AdapteeInterface {

	public String process(String inputXML) throws Exception;

	public void initialize(String inputXML) throws Exception;

	public RequestHeader getRequestHeader();

	public void setRequestHeader(RequestHeader requestHeader);

	public String getInputMessage();

	public void setInputMessage(String inputMessage);

	public Document getDocument();

	public void setDocument(Document document);

	public String getReqServiceOperation();

	public void setReqServiceOperation(String reqServiceOperation);
}
