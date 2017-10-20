package com.bs.themebridge.xpath;

public class CustomisationFDLienMarkXpath {

	// public static String BankId = "01";
	// public static String ChannelId = "COR";
	// public static String ServiceRequestVersion = "10.2";

	public static String correlationIdXPath = "ServiceRequest/RequestHeader/CorrelationId";
	public static String serviceXPath = "ServiceRequest/RequestHeader/Service";
	public static String operationXPath = "ServiceRequest/RequestHeader/Operation";
	public static String credentialsNameXPath = "ServiceRequest/RequestHeader/Credentials/Name";
	public static String targetSystemXPath = "ServiceRequest/RequestHeader/TargetSystem";
	public static String sourceSystemXPath = "ServiceRequest/RequestHeader/SourceSystem";

	/**
	 * Get TI Request values
	 */
	public static String masterRefXpath = "ServiceRequest/fdlienadd/FDRow/MasterReference";
	public static String eventRefXpath = "ServiceRequest/fdlienadd/FDRow/EventRefernce";
	public static String AccountNumberXPath = "ServiceRequest/fdlienadd/FDRow/AccountNumber";
	public static String AmountXPath = "ServiceRequest/fdlienadd/FDRow/Amount";
	public static String CurrencyXPath = "ServiceRequest/fdlienadd/FDRow/Currency";
	public static String ReasonCodeXPath = "ServiceRequest/fdlienadd/FDRow/ReasonCode";
	public static String RemarksXPath = "ServiceRequest/fdlienadd/FDRow/Remarks";
	public static String LienStartDateXPath = "ServiceRequest/fdlienadd/FDRow/LienStartDate";
	public static String LienEndDateXPath = "ServiceRequest/fdlienadd/FDRow/LienEndDate";

	/**
	 * Get Bank Response values
	 */
	public static final String StatusXPath = "/FIXML/Header/ResponseHeader/HostTransaction/Status";	
	public static final String ErrorCodeXPath = "/FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorCode";
	public static final String ErrorDesc = "/FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorDesc";	
	public static final String ErrorDescXPath = "/FIXML/Body/executeFinacleScriptResponse/executeFinacleScript_CustomData/Error_Msg";	
	public static final String ErrorSourceXPath = "/FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorSource";
	public static final String ErrorTypeXPath = "/FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorType";
	public static final String AccountIdXPath = "FIXML/Body/AcctLienAddResponse/AcctLienAddRs/AcctId/AcctId";
	public static final String LienIdXPath = "FIXML/Body/AcctLienAddResponse/AcctLienAddRs/LienIdRec/LienId";

}
