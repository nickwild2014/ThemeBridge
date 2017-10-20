package com.bs.themebridge.server.adapter;

import org.w3c.dom.Document;

import com.bs.themebridge.serverinterface.AdapteeInterface;

/**
 * interface IServiceExtractor is used to declare all the service methods which
 * is implemented for the TI Services Operations.
 * 
 * @author Bluescope
 * 
 */
public interface IServiceExtractor {

	public String process(String inputXml) throws ClassNotFoundException;

	public String getAvailBal(String inputXml) throws ClassNotFoundException;

	public String getLimitFacilities(String inputXml)
			throws ClassNotFoundException;

	public String getLimitReservations(String inputXml)
			throws ClassNotFoundException;

	public String getWatchList(String inputXml);

	public String getSwiftOut(String inputXml);

	public String getBackOfficeVerify(String inputXml);

	public String getBackOfficeBatch(String inputXml);

	public String getLimitReservationReversal(String inputXml);

	public String getHostSearch(String inputXml);

	public String getAccountDetails(String inputXml);

	public String getCustomerDetails(String inputXml);

	public String getBusinessSupportTIFxSpotRate(String inputXml);

	public String getBusinessSupportTIBaseRate(String inputXml);

	public String getBusinessSupportFxContracts(String inputXml);

	public String getBackOfficeFxContractDrawdown(String inputXml);

	public String getBackOfficeFxDeal(String inputXml);

	public String getAccountOpen(String inputXml);

	public String getFaxClient(String inputXml);

	public String getBankRequestFromTIRequest(Document object);

	public String getTIResponseFromBankResponse(String result);

	public void processEventStepNotification(String inputXml);

	public void processAsyncStepNotification(String inputXml);

	public String processGatewayNotification(String inputXml);

	public AdapteeInterface getAdapteeInstance(String inputXml);
}
