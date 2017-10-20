package com.bs.themebridge.xpath;

public class ResponseHeaderXpath {

	/** Get Request Header **/

	public static final String ZONE = "ZONE";

	public static final String SERVICE = "/ServiceRequest/ResponseHeader/Service";
	public static final String OPERATION = "/ServiceRequest/ResponseHeader/Operation";

	public static final String STATUS = "/ServiceRequest/ResponseHeader/Status";
	public static final String CORRELATIONID = "/ServiceRequest/ResponseHeader/CorrelationId";

	public static final String DETAILSINFO = "/ServiceRequest/ResponseHeader/Details/Info";
	public static final String DETAILSERROR = "/ServiceRequest/ResponseHeader/Details/Error";
	public static final String DETAILSWARNING = "/ServiceRequest/ResponseHeader/Details/Warning";

}
