package com.bs.themebridge.xpath;

public class WatchListCheckerXpath {

	public static final String correlationIdXPath = "ServiceRequest/RequestHeader/CorrelationId";

	public static final String MasterReference = "ServiceRequest/ncif/MasterReference";
	public static final String EventReference = "ServiceRequest/ncif/EventReference";
	public static final String BehalfOfBranch = "/ServiceRequest/ncif/BehalfOfBranch";

	public static final String Applicant = "/ServiceRequest/ncif/Applicant";
	public static final String ApplicantID = "/ServiceRequest/ncif/ApplicantID";
	public static final String AppPOINumber = "/ServiceRequest/ncif/AppPOINumber";

	public static final String Beneficiary = "/ServiceRequest/ncif/Beneficiary";
	public static final String BenPOINumber = "/ServiceRequest/ncif/BenPOINumber";
	public static final String BeneficiaryID = "/ServiceRequest/ncif/BeneficiaryID";

}
