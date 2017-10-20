package com.bs.themebridge.xpath;

public class LimitReservationsReversalXpath {

	/**
	 * Get TI Request
	 */
	public static final String FacilityIdentifier = "/ServiceRequest/ReservationsReversalRequest/FacilityIdentifier";
	public static final String FacilitySequence = "/ServiceRequest/ReservationsReversalRequest/FacilitySequence";
	public static final String ReservationIdentifier = "/ServiceRequest/ReservationsReversalRequest/ReservationIdentifier";
	public static final String ReservationSequence = "/ServiceRequest/ReservationsReversalRequest/ReservationSequence";
	public static final String Product = "/ServiceRequest/ReservationsReversalRequest/Product";
	public static final String ProductSubType = "/ServiceRequest/ReservationsReversalRequest/ProductSubType";
	public static final String MasterReference = "/ServiceRequest/ReservationsReversalRequest/MasterReference";
	public static final String EventReference = "/ServiceRequest/ReservationsReversalRequest/EventReference";
	public static final String Customer = "/ServiceRequest/ReservationsReversalRequest/Customer	";
	public static final String Branch = "/ServiceRequest/ReservationsReversalRequest/Branch";
	public static final String PostingKey = "/ServiceRequest/ReservationsReversalRequest/PostingKey";

	/**
	 * Get Bank Response
	 */
	public static final String AccountId = "FIXML/Body/AcctLienAddResponse/AcctLienAddRs/AcctId/AcctId";
	public static final String LienMarkId = "FIXML/Body/AcctLienAddResponse/AcctLienAddRs/LienIdRec/LienId";

	// System Error description
	public static final String FISystemExCodeXpath = "FIXML/Body/Error/FISystemException/ErrorDetail/ErrorCode";
	public static final String FISystemExErrorMsgDescXpath = "FIXML/Body/Error/FISystemException/ErrorDetail/ErrorDesc";
	// Business Error description
	public static final String FIBusinessExCodeXpath = "FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorCode";
	public static final String FIBusinessExMsgDescXpath = "FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorDesc";
	// Failure
	public static final String FIScriptResponseExCodeXpath = "FIXML/Body/executeFinacleScriptResponse/executeFinacleScript_CustomData/Error_Code";
	public static final String FIScriptResponseExMsgDescXpath = "FIXML/Body/executeFinacleScriptResponse/executeFinacleScript_CustomData/Error_Msg";

}
