package com.bs.themebridge.xpath;

public class LimitReservationsXpath {

	public static final String ErrorTypeXpath = "/FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorType";

	public static final String HostStatausXpath = "FIXML/Header/ResponseHeader/HostTransaction/Status";
	public static final String FacilityStatausXpath = "FIXML/Body/executeFinacleScriptResponse/executeFinacleScript_CustomData/STATUS";

	// System Error description
	// public static final String FISystemExceptionErrorCodeXpath =
	// "FIXML/Body/Error/FISystemException/ErrorDetail/ErrorCode";
	// public static final String FISystemExceptionErrorMsgDescXpath =
	// "FIXML/Body/Error/FISystemException/ErrorDetail/ErrorDesc";

	// System Error description
	public static final String FISystemExCodeXpath = "FIXML/Body/Error/FISystemException/ErrorDetail/ErrorCode";
	public static final String FISystemExErrorMsgDescXpath = "FIXML/Body/Error/FISystemException/ErrorDetail/ErrorDesc";
	// Business Error description
	public static final String FIBusinessExCodeXpath = "FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorCode";
	public static final String FIBusinessExMsgDescXpath = "FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorDesc";
	// Failure
	public static final String FIScriptResponseExCodeXpath = "FIXML/Body/executeFinacleScriptResponse/executeFinacleScript_CustomData/Error_Code";
	public static final String FIScriptResponseExMsgDescXpath = "FIXML/Body/executeFinacleScriptResponse/executeFinacleScript_CustomData/Error_Msg";

	public static final String correlationIdXPath = "ServiceRequest/RequestHeader/CorrelationId";
	public static final String Product = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/Product";
	public static final String ProductSubType = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/ProductSubType";
	public static final String MasterReference = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/MasterReference";
	public static final String EventReference = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/EventReference";
	public static final String AccountNumberXpath = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/AccountNumber";
	public static final String BackOfficeAccount = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/BackOfficeAccount";
	public static final String ExternalAccount = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/ExternalAccount";
	public static final String IBAN = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/IBAN";
	public static final String AccountType = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/AccountType";
	public static final String Customer = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/Customer";
	public static final String Branch = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/Branch";
	public static final String CustomerType = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/CustomerType";
	public static final String RelatedParty = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/RelatedParty";
	public static final String CorrelationId = "/ServiceRequest/RequestHeader/CorrelationId";
	public static final String CurrencyXpath = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/PostingAmount/Currency";
	public static final String AmountXpath = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/PostingAmount/Amount";
	public static final String DebitCreditFlag = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/DebitCreditFlag";
	public static final String ValueDate = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/ValueDate";
	public static final String TenorStartDate = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/TenorStartDate";
	public static final String TenorEndDate = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/TenorEndDate";
	public static final String Narrative = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/Narrative";
	public static final String UserCodes = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/UserCodes";
	public static final String BankCode1 = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/BankCode1";
	public static final String BankCode2 = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/BankCode2";
	public static final String BankCode3 = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/BankCode3";
	public static final String BankCode4 = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/BankCode4";
	public static final String BankCode5 = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/BankCode5";
	public static final String PostingKey = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/PostingKey";
	public static final String FacilityIdentifier = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/FacilityIdentifier";
	public static final String FacilitySequence = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/FacilitySequence";
	public static final String RelatedPartyIdentifier = "/ServiceRequest/ReservationsRequest/ReservationRequestDetails/RelatedPartyIdentifier";
	public static final String ExtraDataFieldsName = "/ServiceRequest/ReservationsRequest/ExtraDataFieldss/ExtraDataFields/Name";
	public static final String ExtraDataFieldsValue = "/ServiceRequest/ReservationsRequest/ExtraDataFieldss/ExtraDataFields/Value";
	public static final String ForceDebitLimit = "/ServiceRequest/ReservationsRequest/ExtraDataFieldss/ExtraDataFields[Name[contains(.,'FORPOST')]]/Value";

	/** Get Bank Response **/
	public static final String LienMarkId = "FIXML/Body/AcctLienAddResponse/AcctLienAddRs/LienIdRec/LienId";
	public static final String Status = "FIXML/Header/ResponseHeader/HostTransaction/Status";
	public static final String AccountId = "FIXML/Body/AcctLienAddResponse/AcctLienAddRs/AcctId/AcctId";

}
