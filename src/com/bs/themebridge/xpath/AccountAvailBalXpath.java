package com.bs.themebridge.xpath;

public class AccountAvailBalXpath {

	/** Get TI Request **/
	public static final String BackOfficeAccount = "/ServiceRequest/AvailBalRequest/BackOfficeAccount	";
	public static final String ExternalAccount = "/ServiceRequest/AvailBalRequest/ExternalAccount";
	public static final String PostingValueDate = "/ServiceRequest/AvailBalRequest/PostingValueDate";
	public static final String PostingAmount = "/ServiceRequest/AvailBalRequest/PostingAmount";
	public static final String PostingCurrency = "/ServiceRequest/AvailBalRequest/PostingCurrency";
	public static final String DebitCredit = "/ServiceRequest/AvailBalRequest/DebitCredit";
	public static final String Customer = "/ServiceRequest/AvailBalRequest/Customer";

	/** Get Bank Response **/
	public static final String AccountID = "/FIXML/Body/BalInqRequest/BalInqRq/AcctId/AcctId";
	public static final String BalanceResp = "/FIXML/Body/BalInqResponse/BalInqRs/AcctBal[BalType[contains(.,'CLRBAL')]]/BalAmt/amountValue";
	// CLRBAL
	//public static final String EfectiveBalanceResp = "/FIXML/Body/BalInqResponse/BalInqRs/AcctBal[BalType[contains(.,'EFFAVL')]]/BalAmt/amountValue";
	public static final String EfectiveBalanceResp = "/FIXML/Body/executeFinacleScriptResponse/executeFinacleScript_CustomData/balanceInquiry/effAvailBalance";
	//public static final String BalanceCurrency = "/FIXML/Body/BalInqResponse/BalInqRs/AcctBal[BalType[contains(.,'CLRBAL')]]/BalAmt/currencyCode";

	// Bank Response Error COde and Description
	// System Error description
	public static final String FISystemExCode = "FIXML/Body/Error/FISystemException/ErrorDetail/ErrorCode";
	public static final String FISystemExErrorMsgDesc = "FIXML/Body/Error/FISystemException/ErrorDetail/ErrorDesc";
	// Business Error description
	public static final String FIBusinessErrCode = "FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorCode";
	public static final String FIBusinessErrMsgDesc = "FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorDesc";
	// ExecuteFinacleScript Error dsescription
	public static final String FIScriptResponseExCode = "FIXML/Body/executeFinacleScriptResponse/executeFinacleScript_CustomData/ErrorDetail/ErrorCode";
	public static final String FIScriptResponseExDesc = "FIXML/Body/executeFinacleScriptResponse/executeFinacleScript_CustomData/ErrorDetail/ErrorDesc";

	public static final String ErrorSource = "/FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorSource";
	public static final String ErrorType = "/FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorType";
	public static final String FinacleStatausXpath = "FIXML/Header/ResponseHeader/HostTransaction/Status";

	// public static final String FISystemExCodeXpath =
	// "FIXML/Body/Error/FISystemException/ErrorDetail/ErrorCode";
	// public static final String FISystemExceptionErrorMsgDescXpath =
	// "FIXML/Body/Error/FISystemException/ErrorDetail/ErrorDesc";
	// public static final String FIBusinessExCodeXpath =
	// "FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorCode";
	// public static final String FIBusinessExMsgDescXpath =
	// "FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorDesc";
	// public static final String FIScriptResponseExCodeXpath =
	// "FIXML/Body/executeFinacleScriptResponse/executeFinacleScript_CustomData/Error_Code";
	// public static final String FIScriptResponseExMsgDescXpath =
	// "FIXML/Body/executeFinacleScriptResponse/executeFinacleScript_CustomData/Error_Msg";
}
