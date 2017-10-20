package com.bs.themebridge.xpath;

public class GatewayTfelcpyrXpath {

	/** Get TI Request **/
	/** service **/
	public static final String SERVICE = "/ServiceRequest/RequestHeader/Service";
	public static final String OPERATION = "/ServiceRequest/RequestHeader/Operation";
	public static final String CORRELATIONID = "/ServiceRequest/RequestHeader/CorrelationId";
	public static final String SOURCESYSTEM = "/ServiceRequest/RequestHeader/SourceSystem";
	public static final String TARGETSYSTEM = "/ServiceRequest/RequestHeader/TargetSystem";
	public static final String ZONE = "/ServiceRequest/RequestHeader/SourceSystem";

	public static final String MASTERREFERENCE = "/ServiceRequest/lcbdelcpyr/MasterReference";
	public static final String EVENTREFERENCE = "/ServiceRequest/lcbdelcpyr/EventReference";
	public static final String BEHALFOFBRANCH = "/ServiceRequest/lcbdelcpyr/BehalfofBranch";
	public static final String AMOUNT = "/ServiceRequest/lcbdelcpyr/Amount";
	public static final String CURRENCY = "/ServiceRequest/lcbdelcpyr/Currency";
	public static final String CUSTOMER = "/ServiceRequest/lcbdelcpyr/Customer";
	public static final String OURREFERENCE = "/ServiceRequest/lcbdelcpyr/OurReference";
	public static final String THEIRREFERENCE = "/ServiceRequest/lcbdelcpyr/TheirReference";
	public static final String PRESENTERSREFERENCE = "/ServiceRequest/lcbdelcpyr/PresentersReference";
	
	public static final String CLAIMID = "/ServiceRequest/lcbdelcpyr/ClaimID";
	public static final String PRODUCTCODE = "/ServiceRequest/lcbdelcpyr/ProductCode";
	public static final String PRODUCTNAME = "/ServiceRequest/lcbdelcpyr/ProductName";
	public static final String COUNTRY = "/ServiceRequest/lcbdelcpyr/CountryCode";

	public static final String APPLICANT = "/ServiceRequest/lcbdelcpyr/Applicant";
	public static final String BENEFICIARY = "/ServiceRequest/lcbdelcpyr/Beneficiary";
	
	public static final String EJB_STATUS = "ServiceResponse/ResponseHeader/Status";

}
