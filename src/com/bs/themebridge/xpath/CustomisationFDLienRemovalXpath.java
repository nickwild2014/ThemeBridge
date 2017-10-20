package com.bs.themebridge.xpath;

public class CustomisationFDLienRemovalXpath {

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
	public static String masterRefXpath = "ServiceRequest/fdlienmodify/FDRow/MasterReference";
	public static String eventRefXpath = "ServiceRequest/fdlienmodify/FDRow/EventRefernce";
	public static String AccountNumberXPath = "ServiceRequest/fdlienmodify/FDRow/AccountNumber";
	public static String AmountXPath = "ServiceRequest/fdlienmodify/FDRow/Amount";
	public static String CurrencyXPath = "ServiceRequest/fdlienmodify/FDRow/Currency";
	public static String ReasonCodeXPath = "ServiceRequest/fdlienmodify/FDRow/ReasonCode";
	public static String RemarksXPath = "ServiceRequest/fdlienmodify/FDRow/Remarks";
	public static String LienStartDateXPath = "ServiceRequest/fdlienmodify/FDRow/LienStartDate";
	public static String LienEndDateXPath = "ServiceRequest/fdlienmodify/FDRow/LienEndDate";

	/**
	 * Get Bank Response values
	 */
	// Status
	public static final String HostStatusXPath = "/FIXML/Header/ResponseHeader/HostTransaction/Status";
	public static final String LienStatusXPath = "/FIXML/Body/executeFinacleScriptResponse/executeFinacleScript_CustomData/STATUS";
	// Failure
	public static final String ErrorCodeBusinessExXPath = "/FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorCode";
	public static final String ErrorDescBusinessExXPath = "/FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorDesc";
	public static final String ErrorTypeBusinessExXPath = "/FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorType";
	public static final String ErrorSourceBusinessExXPath = "/FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorSource";
	public static final String ErrorCodeScriptRespXPath = "/FIXML/Body/executeFinacleScriptResponse/executeFinacleScript_CustomData/Error_Code";
	public static final String ErrorMsgScriptRespXPath = "/FIXML/Body/executeFinacleScriptResponse/executeFinacleScript_CustomData/Error_Msg";
	// Success
	public static final String SuccessMsgScriptRespXPath = "/FIXML/Body/executeFinacleScriptResponse/executeFinacleScript_CustomData/MESSAGE";
}
