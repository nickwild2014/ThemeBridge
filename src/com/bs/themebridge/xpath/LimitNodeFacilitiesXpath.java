package com.bs.themebridge.xpath;

public class LimitNodeFacilitiesXpath {

	/************************** Request Header **************************/
	public static final String CorrelationIdXPath = "ServiceRequest/RequestHeader/CorrelationId";
	public static final String serviceXPath = "ServiceRequest/RequestHeader/Service";
	public static final String operationXPath = "ServiceRequest/RequestHeader/Operation";
	public static final String credentialsNameXPath = "ServiceRequest/RequestHeader/Credentials/Name";
	public static final String targetSystemXPath = "ServiceRequest/RequestHeader/TargetSystem";
	public static final String sourceSystemXPath = "ServiceRequest/RequestHeader/SourceSystem";
	// Node Facilities
	public static final String Product = "/ServiceRequest/NodeFacilitiesRequest/NodeFacilityRequestDetails/Product";
	public static final String ProductSubType = "/ServiceRequest/NodeFacilitiesRequest/NodeFacilityRequestDetails/ProductSubType";
	public static final String MasterReference = "/ServiceRequest/NodeFacilitiesRequest/NodeFacilityRequestDetails/MasterReference";
	public static final String EventReference = "/ServiceRequest/NodeFacilitiesRequest/NodeFacilityRequestDetails/EventReference";
	public static final String Customer = "/ServiceRequest/NodeFacilitiesRequest/NodeFacilityRequestDetails/Customer";
	public static final String Branch = "/ServiceRequest/NodeFacilitiesRequest/NodeFacilityRequestDetails/Branch";
	public static final String ValueDate = "/ServiceRequest/NodeFacilitiesRequest/NodeFacilityRequestDetails/ValueDate";
	public static final String LimitNodeFacilityID = "/ServiceRequest/NodeFacilitiesRequest/NodeFacilityRequestDetails/LimitNode";

	/************************** Response Header **************************/
	// STATUS
	public static final String HostStatausXpath = "FIXML/Header/ResponseHeader/HostTransaction/Status";
	public static final String ServiceStatausXpath = "FIXML/Header/ResponseHeader/HostTransaction/Status";
	// System Error description
	public static final String FISystemExCodeXpath = "FIXML/Body/Error/FISystemException/ErrorDetail/ErrorCode";
	public static final String FISystemExceptionErrorMsgDescXpath = "FIXML/Body/Error/FISystemException/ErrorDetail/ErrorDesc";
	// Business Error description
	public static final String FIBusinessExCodeXpath = "FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorCode";
	public static final String FIBusinessExMsgDescXpath = "FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorDesc";
	// Failure
	public static final String FIScriptResponseExCodeXpath = "FIXML/Body/executeFinacleScriptResponse/executeFinacleScript_CustomData/Error_Code";
	public static final String FIScriptResponseExMsgDescXpath = "FIXML/Body/executeFinacleScriptResponse/executeFinacleScript_CustomData/Error_Msg";
	public static final String ErrorSourceXpath = "/FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorSource";
	public static final String ErrorTypeXpath = "/FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorType";

	//
	public static final String LimitNodeXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/";
	public static final String SequenceNumberXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/";

	public static final String AvailSanctLimitamountXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/availSanctLimit/amountValue";
	public static final String AvailSanctCurrencyXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/availSanctLimit/currencyCode";

	public static final String BaseUserMaintLiabAmountXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/baseUserMaintLiab/amountValue";
	public static final String BaseUserMaintLiabCurrencyXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/baseUserMaintLiab/currencyCode";

	public static final String CommittedFlgXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/committedFlg";
	public static final String CurrencyXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/crncy";
	public static final String DrwngPowerIndCodeXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/drwngPowerInd/code";
	public static final String DrwngPowerPcntValueXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/drwngPowerPcnt/value";

	public static final String FreeTextXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/freeText";
	public static final String LimitDescXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/limitDesc";
	public static final String LimitEffDateXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/limitEffDate";
	public static final String LimitExpiryDateXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/limitExpiryDate";

	public static final String LimitPrefixXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/limitPrefix";
	public static final String LimitSuffixXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/limitSuffix";

	public static final String LimitReviewDateXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/limitReviewDate";
	public static final String LimitSanctDateXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/limitSanctDate";
	public static final String LimitSanctRefXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/limitSanctRef";

	public static final String LimitSigningDateXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/limitSigningDate";
	public static final String MinReqdCollPcntValueXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/minReqdCollPcnt/value";
	public static final String ParentLimitPrefixXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/parentLimitPrefix";
	public static final String ParentLimitSuffixXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/parentLimitSuffix";
	public static final String PatternOfFundXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/patternOfFund";
	public static final String ReasonCodeXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/reasonCode";
	public static final String SanctAuthCodeXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/sanctAuthCode";
	public static final String SanctLevelCodeXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/sanctLevelCode";
	public static final String SanctLimitAmountXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/sanctLimit/amountValue";
	public static final String SanctLimitCurrencyXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/sanctLimit/currencyCode";
	public static final String SanctLimitFlgCodeXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/sanctLimitFlg/code";
	public static final String SingleTranFlgXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/singleTranFlg";
	public static final String StatusCodeXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/statusCode";
	public static final String UserMaintLiabDtlsXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/userMaintLiabDtls";
	public static final String TreasuryUtilLimitAmountXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/treasuryUtilLimit/amountValue";
	public static final String TreasuryUtilLimitCurrencyXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/treasuryUtilLimit/currencyCode";
	public static final String EffAvailSanctLimitAmountXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/effAvailSanctLimit/amountValue";
	public static final String EffAvailSanctLimitCurrencyXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/effAvailSanctLimit/currencyCode";
	public static final String InquireLimitNode_CustomDataXpath = "/FIXML/Body/inquireLimitNodeResponse/inquireLimitNode_CustomData";

	public static final String SharedLimitDtlsXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/sharedLimitDtls";
	public static final String OsharedLimitLLXpath = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/sharedLimitDtls/osharedLimitLL";
	public static final String OsharedLimitLLcifId = "/FIXML/Body/inquireLimitNodeResponse/InquireLimitNodeOutVO/sharedLimitDtls/osharedLimitLL/cifId";
	
}
