package com.bs.themebridge.xpath;

public class IFN760COVGatewayXpath {

	/** Get TI Request **/
	public static String SERVICE = "/ServiceRequest/RequestHeader/Service";
	public static String OPERATION = "/ServiceRequest/RequestHeader/Operation";
	public static String CORRELATIONID = "/ServiceRequest/RequestHeader/CorrelationId";

	public static String MASTERREFERENCE = "/ServiceRequest/bgifn760cv/MasterReference";
	public static String EVENTREFERENCE = "/ServiceRequest/bgifn760cv/EventReference";
	public static String BEHALFOFBRANCH = "/ServiceRequest/bgifn760cv/BehalfOfBranch";
	public static String TRANSACTIONREFNUMBER = "/ServiceRequest/bgifn760cv/TransactionRefNumber";
	public static String GUARANTEEFORMNUMBER = "/ServiceRequest/bgifn760cv/GuaranteeFormNumber";

	public static String TYPEOFBANKGUARANTEE = "/ServiceRequest/bgifn760cv/TypeOfBankGuarantee";
	public static String GUARANTEECURRENCYAMOUNT = "/ServiceRequest/bgifn760cv/GuaranteeCurrencyAmount";
	public static String CURRENCY = "/ServiceRequest/bgifn760cv/GuaranteeCurrency";

	public static String GUARANTEEFROMDATE = "/ServiceRequest/bgifn760cv/GuaranteeFromDate";
	public static String GUARANTEETODATE = "/ServiceRequest/bgifn760cv/GuaranteeToDate";
	public static String GUARANTEEEFFECTIVEDATE = "/ServiceRequest/bgifn760cv/GuaranteeEffectiveDate";
	public static String ENDDATEFORLODGMENTOFCLAIM = "/ServiceRequest/bgifn760cv/EndDateForLodgmentOfClaim";

	public static String PLACEOFLODGMENTOFCLAIM = "/ServiceRequest/bgifn760cv/PlaceOfLodgmentOfClaim";
	public static String ISSUINGBRANCHIFSC = "/ServiceRequest/bgifn760cv/IssuingBranchIFSC";
	public static String ISSUINGBRANCHNAMEADDRESS = "/ServiceRequest/bgifn760cv/IssuingBranchNameAddress";
	public static String NAMEOFAPPLICANT = "/ServiceRequest/bgifn760cv/NameOfApplicant";
	public static String NAMEOFBENEFICIARY = "/ServiceRequest/bgifn760cv/NameOfBeneficiary";
	public static String BENEFICIARYIFSC = "/ServiceRequest/bgifn760cv/BeneficiaryIFSC";
	public static String BENEFICIARYBRANCHNAMEADDRESS = "/ServiceRequest/bgifn760cv/BeneficiaryBranchNameAddress";

	public static String SENDERINFORMATION = "/ServiceRequest/bgifn760cv/SenderInformation";
	public static String RECEIVERINFORMATION = "/ServiceRequest/bgifn760cv/ReceiverInformation";
	public static String SENDERTORECEIVERINFORMATION = "/ServiceRequest/bgifn760cv/SenderToReceiverInformation";

	public static String PURPOSEOFGUARANTEE = "/ServiceRequest/bgifn760cv/PurposeOfGuarantee";
	public static String REFERENCEOFUNDERLINEDCONTRACT = "/ServiceRequest/bgifn760cv/ReferenceOfUnderlinedContract";

	public static String ELECTRONICALLYPAID = "/ServiceRequest/bgifn760cv/ElectronicallyPaid";
	public static String ESTAMPCERTIFICATENUMBER = "/ServiceRequest/bgifn760cv/EStampCertificateNumber";
	public static String ESTAMPDATE = "/ServiceRequest/bgifn760cv/EStampDate";
	public static String ESTAMPTIME = "/ServiceRequest/bgifn760cv/EStampTime";

	public static String AMOUNTPAID = "/ServiceRequest/bgifn760cv/AmountPaid";
	public static String STATECODE = "/ServiceRequest/bgifn760cv/StateCode";
	public static String ARTICLENUMBER = "/ServiceRequest/bgifn760cv/ArticleNumber";

	public static String DATEOFPAYMENT = "/ServiceRequest/bgifn760cv/DateOfPayment";
	public static String PLACEOFPAYMENT = "/ServiceRequest/bgifn760cv/PlaceOfPayment";
	public static String EBGHELDINDEMATFORM = "/ServiceRequest/bgifn760cv/EBGHeldInDematForm";
	public static String DEMATACCOUNTNUMBER = "/ServiceRequest/bgifn760cv/DematAccountNumber";
	public static String CUSTODIANSERVICEPROVIDER = "/ServiceRequest/bgifn760cv/CustodianServiceProvider";

}
