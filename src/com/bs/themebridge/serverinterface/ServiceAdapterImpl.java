package com.bs.themebridge.serverinterface;

import org.w3c.dom.Document;

import com.bs.themebridge.logging.ServiceLogging;
import com.bs.themebridge.server.adapter.IServiceExtractor;
import com.misys.tiplus2.services.control.ServiceRequest.RequestHeader;

public abstract class ServiceAdapterImpl implements IServiceExtractor {

	@Override
	public String getAvailBal(String inputXml) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLimitFacilities(String inputXml) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLimitReservations(String inputXml) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWatchList(String inputXml) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSwiftOut(String inputXml) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBackOfficeVerify(String inputXml) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBackOfficeBatch(String inputXml) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLimitReservationReversal(String inputXml) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHostSearch(String inputXml) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAccountDetails(String inputXml) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCustomerDetails(String inputXml) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBusinessSupportTIFxSpotRate(String inputXml) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBusinessSupportTIBaseRate(String inputXml) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBusinessSupportFxContracts(String inputXml) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBackOfficeFxContractDrawdown(String inputXml) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBackOfficeFxDeal(String inputXml) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAccountOpen(String inputXml) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFaxClient(String inputXml) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBankRequestFromTIRequest(Document object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTIResponseFromBankResponse(String result) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void processEventStepNotification(String inputXml) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processAsyncStepNotification(String inputXml) {
		// TODO Auto-generated method stub

	}

	@Override
	public String processGatewayNotification(String inputXml) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String process(String inputXml) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	public void doServiceLogging(RequestHeader requestHeader, String tiRequest, String tiResponse, String bankRequest,
			String bankResponse, String status) {

		// ServiceLogging.pushLogData(requestHeader.getService(),
		// requestHeader.getOperation(),
		// requestHeader.getSourceSystem(), "", requestHeader.getSourceSystem(),
		// requestHeader.getTargetSystem(),
		// tiRequest, tiResponse, bankRequest, bankResponse, status, "", "",
		// false, "", "", null, null, null,
		// null);

		ServiceLogging.pushLogData(requestHeader.getService(), requestHeader.getOperation(),
				requestHeader.getSourceSystem(), "", requestHeader.getSourceSystem(), requestHeader.getTargetSystem(),
				"", "", status, tiRequest, tiResponse, bankRequest, bankResponse, null, null, null, null, "", "", "",
				"", false, "0", "");
	}

	public void doServiceLogging(RequestHeader requestHeader, String tiRequest, String tiResponse, String bankRequest,
			String bankResponse, String masterReference, String eventReference, String status) {

		// ServiceLogging.pushLogData(requestHeader.getService(),
		// requestHeader.getOperation(),
		// requestHeader.getSourceSystem(), "", requestHeader.getSourceSystem(),
		// requestHeader.getTargetSystem(),
		// tiRequest, tiResponse, bankRequest, bankResponse, status,
		// masterReference, eventReference, false, "",
		// "", null, null, null, null);

		ServiceLogging.pushLogData(requestHeader.getService(), requestHeader.getOperation(),
				requestHeader.getSourceSystem(), "", requestHeader.getSourceSystem(), requestHeader.getTargetSystem(),
				"", "", status, tiRequest, tiResponse, bankRequest, bankResponse, null, null, null, null, "", "", "",
				"", false, "0", "");

	}

}
