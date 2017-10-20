package com.bs.themebridge.xpath;

public class IFNSFMSGatewayXpath {

	/** Get TI Request **/
	public static String SERVICE = "/ServiceRequest/RequestHeader/Service";
	public static String OPERATION = "/ServiceRequest/RequestHeader/Operation";
	public static String CORRELATIONID = "/ServiceRequest/RequestHeader/CorrelationId";

	public static String MASTER_REFERENCE = "/ServiceRequest/ebgissue/MasterReference";
	public static String EVENT_REFERENCE = "/ServiceRequest/ebgissue/EventReference";
	public static String BEHALF_OF_BRANCH = "/ServiceRequest/ebgissue/BehalfOfBranch";
	public static String STATE_CODE = "/ServiceRequest/ebgissue/StateCode";
	public static String DATEOF_PAYMENT = "/ServiceRequest/ebgissue/DateOfPayment";
	public static String SENDER_IFSC = "/ServiceRequest/ebgissue/IssuingBranchIFSC";
	public static String AMOUNT_CCY = "/ServiceRequest/ebgissue/AmountAndCcy";
	public static String AMOUNT = "/ServiceRequest/ebgissue/Amount";
	public static String CURRENCY = "/ServiceRequest/ebgissue/Currency";
	public static String SENDING_PARTYNAME = "/ServiceRequest/ebgissue/SendingPartyName";
	public static String RECEIVING_PARTYNAME = "/ServiceRequest/ebgissue/ReceivingPartyName";
	public static String STAMPDUTY_PAIDBY = "/ServiceRequest/ebgissue/StampDutyPaidBy";
	public static String AMOUNT_PAID = "/ServiceRequest/ebgissue/AmountPaid";
	public static String ARTICLE_NUMBER = "/ServiceRequest/ebgissue/ArticleNumber";

}
