package com.bs.themebridge.xpath;

public class BackOfficeBatchXpath {

	public static String correlationIdXPath = "ServiceRequest/RequestHeader/CorrelationId";
	// public static String transactionIdXpath =
	// "ServiceRequest/BatchRequest/Posting/TransactionId";
	public static String serviceXPath = "ServiceRequest/RequestHeader/Service";
	public static String operationXPath = "ServiceRequest/RequestHeader/Operation";
	public static String credentialsNameXPath = "ServiceRequest/RequestHeader/Credentials/Name";
	public static String targetSystemXPath = "ServiceRequest/RequestHeader/TargetSystem";
	public static String sourceSystemXPath = "ServiceRequest/RequestHeader/SourceSystem";
	// public static String ServiceRequestVersion = "10.2";
	// public static String ChannelId = "COR";
	// public static String BankId = "01";
	public static String executeFinacleScript = "executeFinacleScript";
	public static String accountSearchRequestId = "cifAcctInq";
	public static String limitExposureRequestId = "UMLModification";

	public static String MQJNDIName = "MQ_JNDI";
	public static String DefaultQueueJNDIName = "DEFAULT_QUEUE_JNDI";
	public static String WLCOutQueue = "WLC_OUT_QUEUE";
	public static String SwiftOutQueue = "SWIFT_OUT_QUEUE";
	public static String SwiftInQueue = "SWIFT_IN_QUEUE";

	// public static final String MasterReferenceXPath =
	// "/ServiceRequest/FacilitiesRequest/FacilityRequestDetails/MasterReference";
	// public static final String EventReferenceXPath =
	// "/ServiceRequest/FacilitiesRequest/FacilityRequestDetails/EventReference";
	public static String PostingXPath = "/ServiceRequest/BatchRequest/ServiceRequest/Posting";
	public static String MasterReferenceXPath = "/ServiceRequest/BatchRequest/ServiceRequest/Posting/MasterReference";
	public static String EventReferenceXPath = "/ServiceRequest/BatchRequest/ServiceRequest/Posting/EventReference";

	/**
	 * Get Bank Response values
	 */
	public static final String StatusXPath = "/FIXML/Header/ResponseHeader/HostTransaction/Status";
	public static final String ErrorCodeXPath = "/FIXML/Body/Error/FISystemException/ErrorDetail/ErrorCode";
	public static final String ErrorDescXPath = "/FIXML/Body/Error/FISystemException/ErrorDetail/ErrorDesc";
	public static final String ErrorTypeXPath = "/FIXML/Body/Error/FISystemException/ErrorDetail/ErrorType";
	public static final String TranIdXPath = "/FIXML/Body/executeFinacleScriptResponse/executeFinacleScript_CustomData/tranReference/tran_id";

}
