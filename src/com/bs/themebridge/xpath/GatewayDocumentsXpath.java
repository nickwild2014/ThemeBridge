package com.bs.themebridge.xpath;

public class GatewayDocumentsXpath {

	static String lrcaseOperationName = "";

	/** Get TI Request **/
	public static final String Service = "/ServiceRequest/RequestHeader/Service";
	public static final String Operation = "/ServiceRequest/RequestHeader/Operation";
	public static final String TargetSystem = "/ServiceRequest/RequestHeader/TargetSystem";
	public static final String SourceSystem = "/ServiceRequest/RequestHeader/SourceSystem";
	public static final String CorrelationId = "/ServiceRequest/RequestHeader/CorrelationId";

	public static String MasterReference = "/ServiceRequest/" + lrcaseOperationName + "/MasterReference";
	public static String EventReference = "/ServiceRequest/" + lrcaseOperationName + "/EventReference";

	// LCBD
	public static String ProductType = "/ServiceRequest/" + lrcaseOperationName + "/ProductType";
	public static String ProductSubType = "/ServiceRequest/" + lrcaseOperationName + "/ProductSubType";
	public static String Customer = "/ServiceRequest/" + lrcaseOperationName + "/Customer";
	public static String Branch = "/ServiceRequest/" + lrcaseOperationName + "/Branch";
	public static String ValueDate = "/ServiceRequest/" + lrcaseOperationName + "/ValueDate";
	public static String ExposureAmount = "/ServiceRequest/" + lrcaseOperationName + "/ExposureAmount";
	public static String ExposureCurrency = "/ServiceRequest/" + lrcaseOperationName + "/ExposureCurrency";

}
