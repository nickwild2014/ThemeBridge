package com.bs.themebridge.xpath;

public class LimitExposureXpath {

	public static final String FinacleStatausXpath = "FIXML/Header/ResponseHeader/HostTransaction/Status";
	public static final String Error_DescXpath = "/FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorDesc";
	public static final String ErrorCodeXpath = "/FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorCode";
	public static final String ErrorSourceXpath = "/FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorSource";
	public static final String ErrorTypeXpath = "/FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorType";

	public static final String correlationIdXPath = "ServiceRequest/RequestHeader/CorrelationId";
	public static final String serviceXPath = "ServiceRequest/RequestHeader/Service";
	public static final String operationXPath = "ServiceRequest/RequestHeader/Operation";
	public static final String credentialsNameXPath = "ServiceRequest/RequestHeader/Credentials/Name";
	public static final String targetSystemXPath = "ServiceRequest/RequestHeader/TargetSystem";
	public static final String sourceSystemXPath = "ServiceRequest/RequestHeader/SourceSystem";
	public static final String MasterReferenceXPath = "ServiceRequest/BatchRequest/ServiceRequest/Exposure/MasterReference";
	public static final String EventReferenceXPath = "ServiceRequest/BatchRequest/ServiceRequest/Exposure/EventReference";

	// public static final String ServiceRequestVersion = "10.2";
	// public static final String ChannelId = "COR";
	// public static final String BankId = "01";
	// public static final String executeFinacleScript = "executeFinacleScript";
	public static final String accountSearchRequestId = "cifAcctInq";
	public static final String limitExposureRequestId = "UMLModification";

	public static final String MQJNDIName = "MQ_JNDI";
	public static final String DefaultQueueJNDIName = "DEFAULT_QUEUE_JNDI";
	public static final String WLCOutQueue = "WLC_OUT_QUEUE";
	public static final String SwiftOutQueue = "SWIFT_OUT_QUEUE";
	public static final String SwiftInQueue = "SWIFT_IN_QUEUE";

	public static final String TransactionId = "ServiceRequest/BatchRequest/ServiceRequest/Exposure/TransactionId";
	public static final String Product = "/ServiceRequest/FacilitiesRequest/FacilityRequestDetails/Product";
	public static final String ProductSubType = "/ServiceRequest/FacilitiesRequest/FacilityRequestDetails/ProductSubType";
	public static final String MasterReference = "/ServiceRequest/FacilitiesRequest/FacilityRequestDetails/MasterReference";
	public static final String EventReference = "/ServiceRequest/FacilitiesRequest/FacilityRequestDetails/EventReference";
	public static final String AccountNumber = "/ServiceRequest/FacilitiesRequest/FacilityRequestDetails/AccountNumber";
	public static final String BackOfficeAccount = "/ServiceRequest/FacilitiesRequest/FacilityRequestDetails/BackOfficeAccount";
	public static final String ExternalAccount = "/ServiceRequest/FacilitiesRequest/FacilityRequestDetails/ExternalAccount";
	public static final String IBAN = "/ServiceRequest/FacilitiesRequest/FacilityRequestDetails/IBAN";
	public static final String AccountType = "/ServiceRequest/FacilitiesRequest/FacilityRequestDetails/AccountType";
	public static final String Customer = "/ServiceRequest/FacilitiesRequest/FacilityRequestDetails/Customer";
	public static final String Branch = "/ServiceRequest/FacilitiesRequest/FacilityRequestDetails/Branch";
	public static final String CustomerType = "/ServiceRequest/FacilitiesRequest/FacilityRequestDetails/CustomerType";
	public static final String RelatedParty = "/ServiceRequest/FacilitiesRequest/FacilityRequestDetails/RelatedParty";

	public static final String Currency = "/ServiceRequest/FacilitiesRequest/FacilityRequestDetails/PostingAmount/Currency";
	public static final String Amount = "/ServiceRequest/FacilitiesRequest/FacilityRequestDetails/PostingAmount/Amount";

	public static final String DebitCreditFlag = "/ServiceRequest/FacilitiesRequest/FacilityRequestDetails/DebitCreditFlag";
	public static final String ValueDate = "/ServiceRequest/FacilitiesRequest/FacilityRequestDetails/ValueDate";
	public static final String TenorStartDate = "/ServiceRequest/FacilitiesRequest/FacilityRequestDetails/TenorStartDate";
	public static final String TenorEndDate = "/ServiceRequest/FacilitiesRequest/FacilityRequestDetails/TenorEndDate";
	public static final String Narrative = "/ServiceRequest/FacilitiesRequest/FacilityRequestDetails/Narrative";
	public static final String UserCodes = "/ServiceRequest/FacilitiesRequest/FacilityRequestDetails/UserCodes";
	public static final String BankCode1 = "/ServiceRequest/FacilitiesRequest/FacilityRequestDetails/BankCode1";
	public static final String BankCode2 = "/ServiceRequest/FacilitiesRequest/FacilityRequestDetails/BankCode2";
	public static final String BankCode3 = "/ServiceRequest/FacilitiesRequest/FacilityRequestDetails/BankCode3";
	public static final String BankCode4 = "/ServiceRequest/FacilitiesRequest/FacilityRequestDetails/BankCode4";
	public static final String BankCode5 = "/ServiceRequest/FacilitiesRequest/FacilityRequestDetails/BankCode5";
	public static final String PostingKey = "/ServiceRequest/FacilitiesRequest/FacilityRequestDetails/PostingKey";

	public static final String ExtraDataFieldsName = "/ServiceRequest/FacilitiesRequest/ExtraDataFieldss/ExtraDataFields/Name";
	public static final String ExtraDataFieldsValue = "/ServiceRequest/FacilitiesRequest/ExtraDataFieldss/ExtraDataFields/Value";

	public static final String FiltersName = "/ServiceRequest/FacilitiesRequest/Filterss/Filters/Name";
	public static final String FiltersValue = "/ServiceRequest/FacilitiesRequest/Filterss/Filters/Value";

	public static final String ExpectedColumn1 = "/ServiceRequest/FacilitiesRequest/ExpectedColumns/ExpectedColumn1";
	public static final String ExpectedColumn2 = "/ServiceRequest/FacilitiesRequest/ExpectedColumns/ExpectedColumn2";
	public static final String ExpectedColumn3 = "/ServiceRequest/FacilitiesRequest/ExpectedColumns/ExpectedColumn3";
	public static final String ExpectedColumn4 = "/ServiceRequest/FacilitiesRequest/ExpectedColumns/ExpectedColumn4";
	public static final String ExpectedColumn5 = "/ServiceRequest/FacilitiesRequest/ExpectedColumns/ExpectedColumn5";
	public static final String ExpectedColumn6 = "/ServiceRequest/FacilitiesRequest/ExpectedColumns/ExpectedColumn6";
	public static final String ExpectedColumn7 = "/ServiceRequest/FacilitiesRequest/ExpectedColumns/ExpectedColumn7";
	public static final String ExpectedColumn8 = "/ServiceRequest/FacilitiesRequest/ExpectedColumns/ExpectedColumn8";
	public static final String ExpectedColumn9 = "/ServiceRequest/FacilitiesRequest/ExpectedColumns/ExpectedColumn9";
	public static final String ExpectedColumn10 = "/ServiceRequest/FacilitiesRequest/ExpectedColumns/ExpectedColumn10";

}
