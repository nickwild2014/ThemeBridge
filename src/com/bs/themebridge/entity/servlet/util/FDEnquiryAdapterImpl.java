package com.bs.themebridge.entity.servlet.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpException;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import com.bob.client.finacle.FinacleHttpClient;
import com.bob.client.finacle.FinacleServiceException;
import com.bs.theme.bob.adapter.adaptee.AccountAvailBalAdaptee;
import com.bs.theme.bob.template.util.KotakConstant;
import com.bs.theme.bob.template.util.RequestResponseTemplate;
import com.bs.themebridge.entity.model.FDEnquiryModel;
import com.bs.themebridge.logging.ServiceLogging;
import com.bs.themebridge.token.util.MapTokenResolver;
import com.bs.themebridge.token.util.TokenReplacingReader;
import com.bs.themebridge.util.DateTimeUtil;
import com.bs.themebridge.util.ThemeBridgeUtil;
import com.misys.tiplus2.services.control.StatusEnum;

/**
 * @author PRASATH RAVICHANDRAN
 */
public class FDEnquiryAdapterImpl {

	private final static Logger logger = Logger.getLogger(FDEnquiryAdapterImpl.class.getName());
	private String branch = "";
	private String crnNumber = "";
	private String tiRequest = "";
	private String tiResponse = "";
	private String bankRequest = "";
	private String bankResponse = "";
	private String eventReference = "";
	private String masterReference = "";
	private Timestamp tiReqTime = null;
	private Timestamp tiResTime = null;
	private Timestamp bankReqTime = null;
	private Timestamp bankResTime = null;

	public static void main(String[] args) throws Exception {

		FDEnquiryAdapterImpl obj = new FDEnquiryAdapterImpl();
		// obj.getCRNAccData("MAS0123", "EVE123", "650073");
		// String resp =
		// ThemeBridgeUtil.readFile("D:\\_Prasath\\00_TASK\\CustAccEnq\\HdrChangedResponse.xml");
		// logger.debug(getBankResponseErrorMessage(resp));

		// String resp =
		// ThemeBridgeUtil.readFile("D:\\_Prasath\\00_TASK\\CustAccEnq\\2017-08-23\\26362604.Account.Bank.Response.xml");
		// List<FDEnquiryModel> message = obj.getResponseDetails(resp);

		String resp = ThemeBridgeUtil
				.readFile("D:\\_Prasath\\00_TASK\\CustAccEnq\\2017-08-23\\26362604.Account.Bank.Response.xml");
		// String resp = ThemeBridgeUtil
		// .readFile("D:\\_Prasath\\00_TASK\\CustAccEnq\\2017-08-23\\6500073.Account.Bank.Response.xml");

		logger.debug("TEST1 ");
		List<FDEnquiryModel> message = obj.getResponseDetails(resp);

		// logger.debug("List " + message.size());

	}

	public List<FDEnquiryModel> getCRNAccData(String masterRef, String eventRef, String customerCIF) {

		String status = StatusEnum.SUCCEEDED.toString();
		int accListSize = 0;
		String errorMsg = "";
		List<FDEnquiryModel> fdEnquiryObj = new ArrayList<FDEnquiryModel>();

		try {
			masterReference = masterRef;
			eventReference = eventRef;

			tiReqTime = DateTimeUtil.getSqlLocalDateTime();
			tiRequest = customerCIF;

			bankRequest = getBankRequest(customerCIF);
			bankReqTime = DateTimeUtil.getSqlLocalDateTime();
			logger.debug("\n\nCustAccEnq Bank Request:\n" + bankRequest);

			bankResponse = getBankResponseFromBankRequest(bankRequest);
			bankResTime = DateTimeUtil.getSqlLocalDateTime();
			logger.debug("\n\nCustAccEnq Bank Response:\n" + bankResponse);

			fdEnquiryObj = getResponseDetails(bankResponse);
			accListSize = fdEnquiryObj.size();
			tiResponse = String.valueOf(accListSize);
			tiResTime = DateTimeUtil.getSqlLocalDateTime();

		} catch (Exception e) {
			errorMsg = e.getMessage();
			status = StatusEnum.FAILED.toString();

		} finally {
			ServiceLogging.pushLogData("Customization", "CustAccEnquiry", "ZONE1", branch, "ZONE1", "KOTAK",
					masterReference, eventReference, status, tiRequest, tiResponse, bankRequest, bankResponse,
					tiReqTime, bankReqTime, bankResTime, tiResTime, "", "", "", "", false, "0", errorMsg);
		}
		return fdEnquiryObj;
	}

	public String getBankRequest(String custId) {

		String result = "";
		String maxRec = "10"; // ?
		// String custId = ""; // ?
		String custType = "Corporate"; // ? Retail
		InputStream anInputStream = null;
		try {
			anInputStream = AccountAvailBalAdaptee.class.getClassLoader()
					.getResourceAsStream(RequestResponseTemplate.CUSTOMER_ACCOUNT_ENQUIRY_BANK_REQUEST_TEMPLATE);
			String requestTemplate = ThemeBridgeUtil.readFile(anInputStream);
			String dateTime = DateTimeUtil.getDateAsEndSystemFormat();
			String requestId = ThemeBridgeUtil.randomCorrelationId();

			Map<String, String> tokens = new HashMap<String, String>();

			tokens.put("dateTime", dateTime);
			tokens.put("requestId", requestId);
			tokens.put("ChannelId", KotakConstant.CHANNELID);
			tokens.put("BankId", KotakConstant.BANKID);
			tokens.put("ServiceReqVersion", KotakConstant.SERVICEREQUESTVERSION);

			tokens.put("MaxRec", maxRec);
			tokens.put("CustId", custId);
			tokens.put("CustType", custType);

			MapTokenResolver resolver = new MapTokenResolver(tokens);
			Reader fileValue = new StringReader(requestTemplate);
			Reader reader = new TokenReplacingReader(fileValue, resolver);
			result = reader.toString();
			reader.close();

		} catch (Exception e) {
			logger.error("Customer account enq generate BankReq Exceptions! " + e.getMessage());
			e.printStackTrace();
		
		} finally {
			try {
				anInputStream.close();
			} catch (IOException e) {
				System.out.println("InputStram close exception");
			}
		}

		return result;
	}

	/**
	 * 
	 * @param bankRequest
	 *            {@code allows }{@link String}
	 * @return
	 * @throws FinacleServiceException
	 * @throws IOException
	 * @throws HttpException
	 */
	private String getBankResponseFromBankRequest(String bankRequest)
			throws HttpException, IOException, FinacleServiceException {

		// logger.error("CustAccEnq FI! ");
		try {
			/******* Finacle http client call *******/
			bankResponse = FinacleHttpClient.postXML(bankRequest);

		} catch (Exception e) {
			logger.error("CustAccEnq FI exceptions! " + e.getMessage());
			bankResponse = "";
			// logger.debug("Bank response : " + bankResponse);
		}
		return bankResponse;
	}

	public List<FDEnquiryModel> getResponseDetails(String bankResponseXML) {

		// logger.debug("Milestone 01 ");
		JSONObject xmlJSONObj = null;
		List<FDEnquiryModel> fdEnquiryListObj = null;
		try {
			xmlJSONObj = XML.toJSONObject(bankResponseXML);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}

		// logger.debug("Milestone 02 ");
		try {
			String status = xmlJSONObj.getJSONObject("FIXML").getJSONObject("Header").getJSONObject("ResponseHeader")
					.getJSONObject("HostTransaction").getString("Status");
			// logger.debug("Milestone 03 ");
			if (status.contains("SUCCESS")) {
				// logger.debug("Milestone 04 ");
				JSONObject jArr = xmlJSONObj.getJSONObject("FIXML").getJSONObject("Body")
						.getJSONObject("CustAcctInqResponse").getJSONObject("CustAcctInqRs");
				// logger.debug("Milestone 05 ");
				// JSONArray jsonArray = (JSONArray)
				// jArr.get("GenUnifiedAcctsDtls");// GenUnifiedAcctsDtls
				// logger.debug("json array length " + jsonArray.length());
				JSONArray jsonArray = new JSONArray();
				try {
					// logger.debug("Milestone 06 ");
					jsonArray = (JSONArray) jArr.get("GenUnifiedAcctsDtls");
				} catch (Exception ex) {
					// logger.debug("Milestone 07 ");
					ex.printStackTrace();
					jArr = xmlJSONObj.getJSONObject("FIXML").getJSONObject("Body").getJSONObject("CustAcctInqResponse")
							.getJSONObject("CustAcctInqRs").getJSONObject("GenUnifiedAcctsDtls");
					jsonArray = jsonArray.put(jArr);
				}
				// logger.debug("Milestone 08 ");
				fdEnquiryListObj = new ArrayList<FDEnquiryModel>();
				FDEnquiryModel fdEnquiryObj = null;
				for (int i = 0; i < jsonArray.length(); i++) {
					fdEnquiryObj = new FDEnquiryModel();

					String acctStatus = null;
					acctStatus = jsonArray.getJSONObject(i).getJSONObject("SaleChannelDtls").getString("AcctStatus");
					// logger.debug("AcctStatus : " + acctStatus);

					if (!acctStatus.isEmpty() && acctStatus != null) {
						// logger.debug("loop in");
						fdEnquiryObj
								.setAcctId(jsonArray.getJSONObject(i).getJSONObject("SaleDtls").getString("AcctId"));
						fdEnquiryObj.setAcctCurrCode(
								jsonArray.getJSONObject(i).getJSONObject("SaleChannelDtls").getString("AcctCurrCode"));
						fdEnquiryObj.setBranch(
								jsonArray.getJSONObject(i).getJSONObject("SaleDtls").getString("AcctBranchCode"));
						fdEnquiryObj.setProductCategory(
								jsonArray.getJSONObject(i).getJSONObject("SaleDtls").getString("ProductCategory"));
						fdEnquiryObj.setProductCode(
								jsonArray.getJSONObject(i).getJSONObject("SaleDtls").getString("ProductCode"));
						fdEnquiryListObj.add(fdEnquiryObj);
					}
				}
			} else if (status.contains("FAILURE")) {
				// logger.debug("Milestone 09 ");
				JSONObject failureObj = xmlJSONObj.getJSONObject("FIXML").getJSONObject("Body").getJSONObject("Error")
						.getJSONObject("FIBusinessException").getJSONObject("ErrorDetail");
				String errorCode = failureObj.getString("ErrorCode");
				String errorDesc = failureObj.getString("ErrorDesc");
				String errorType = failureObj.getString("ErrorType");
				logger.debug("errorCode " + errorCode);
				logger.debug("errorDesc " + errorDesc);
				logger.debug("errorType " + errorType);
				// logger.debug("Milestone 10 ");
			}

			// logger.debug("json resp : " + fdEnquiryListObj.toString());

		} catch (JSONException e) {
			logger.error("FDLienEnquiry : " + e.getMessage());
			e.printStackTrace();
		}
		return fdEnquiryListObj;
	}

}
