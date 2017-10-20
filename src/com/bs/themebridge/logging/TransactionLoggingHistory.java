/**
 * 
 */
package com.bs.themebridge.logging;

import static com.bs.themebridge.util.ThemeConstant.SOURCE_SYSTEM;
import static com.bs.themebridge.util.ThemeConstant.TARGET_SYSTEM;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

import org.apache.log4j.Logger;

import com.bs.themebridge.entity.adapter.TransactionlogAdapter;
import com.bs.themebridge.entity.adapter.TransactionloghistoryAdapter;
import com.bs.themebridge.entity.model.Transactionlog;
import com.bs.themebridge.entity.model.Transactionloghistory;
import com.bs.themebridge.util.DateTimeUtil;
import com.bs.themebridge.util.ValidationsUtil;

/**
 * @author Prasath Ravichandran
 *
 */
public class TransactionLoggingHistory {

	private final static Logger logger = Logger.getLogger(TransactionLoggingHistory.class);

	public static void updateTransactionLogData(String id, String service, String operation, String tiRequest,
			String tiResponse, String bankrequest, String bankresponse, String status, String masterreference,
			String eventreference, String source, String sourceSystem, String targetSystem) {

		// logger.debug("Update service in Transaction data log");
		try {

			Transactionlog transactionlog = new Transactionlog();

			transactionlog.setId(new BigDecimal(id));

			if (ValidationsUtil.isValidString(service))
				transactionlog.setService(service);
			else
				transactionlog.setService("");

			if (ValidationsUtil.isValidString(operation))
				transactionlog.setOperation(operation);
			else
				transactionlog.setOperation("");

			if (ValidationsUtil.isValidString(tiRequest))
				transactionlog.setTirequest(tiRequest);
			else
				transactionlog.setTirequest("");

			if (ValidationsUtil.isValidString(tiResponse))
				transactionlog.setTiresponse(tiResponse);
			else
				transactionlog.setTiresponse("");

			if (ValidationsUtil.isValidString(bankrequest))
				transactionlog.setBankrequest(bankrequest);
			else
				transactionlog.setBankrequest("");

			if (ValidationsUtil.isValidString(bankresponse))
				transactionlog.setBankresponse(bankresponse);
			else
				transactionlog.setBankresponse("");

			if (ValidationsUtil.isValidString(status))
				transactionlog.setStatus(status);
			else
				transactionlog.setStatus("");

			if (ValidationsUtil.isValidString(masterreference))
				transactionlog.setMasterreference(masterreference);
			else
				transactionlog.setMasterreference("");

			if (ValidationsUtil.isValidString(eventreference))
				transactionlog.setEventreference(eventreference);
			else
				transactionlog.setEventreference("");

			if (ValidationsUtil.isValidString(source))
				transactionlog.setSourcesystem(source);
			else
				transactionlog.setSourcesystem(SOURCE_SYSTEM);

			if (ValidationsUtil.isValidString(targetSystem))
				transactionlog.setTargetsystem(targetSystem);
			else
				transactionlog.setTargetsystem(TARGET_SYSTEM);

			if (ValidationsUtil.isValidString(sourceSystem))
				transactionlog.setZone(sourceSystem);
			else
				transactionlog.setZone(SOURCE_SYSTEM);
			transactionlog.setProcesstime(DateTimeUtil.getLocalTime());

			TransactionlogAdapter tAdapter = new TransactionlogAdapter();
			tAdapter.updateProperty(transactionlog);

			logger.debug("Transaction Data updated successfully");

		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
	}

	/**
	 * @since 2016-OCT-13
	 * @version v1.2
	 * @author Prasath Ravichandran
	 * 
	 * @param transactionlogid
	 *            {@code allows } {@link String}
	 * @param service
	 *            {@code allows } {@link String}
	 * @param operation
	 *            {@code allows } {@link String}
	 * @param zone
	 *            {@code allows } {@link String}
	 * @param branch
	 *            {@code allows } {@link String}
	 * @param sourceSystem
	 *            {@code allows } {@link String}
	 * @param targetSystem
	 *            {@code allows } {@link String}
	 * @param masterReference
	 *            {@code allows } {@link String}
	 * @param eventReference
	 *            {@code allows } {@link String}
	 * @param status
	 *            {@code allows } {@link String}
	 * @param tiRequest
	 *            {@code allows } {@link String}
	 * @param bankRequest
	 *            {@code allows } {@link String}
	 * @param bankResponse
	 *            {@code allows } {@link String}
	 * @param tiResponse
	 *            {@code allows } {@link String}
	 * @param tiReqTime
	 *            {@code allows } {@link Timestamp}
	 * @param bankReqTime
	 *            {@code allows } {@link Timestamp}
	 * @param bankResTime
	 *            {@code allows } {@link Timestamp}
	 * @param tiResTime
	 *            {@code allows } {@link Timestamp}
	 * @param servicekey1
	 *            {@code allows } {@link String}
	 * @param statickey1
	 *            {@code allows } {@link String}
	 * @param narrative1
	 *            {@code allows } {@link String}
	 * @param narrative2
	 *            {@code allows } {@link String}
	 * @param isReSubmitted
	 *            {@code allows } {@link String}
	 * @param reSubmittedCount
	 *            {@code allows } {@link String}
	 * @param errorMsg
	 *            {@code allows } {@link String}
	 * @return {@code allows }{@link Boolean}
	 */
	public static boolean pushLogData(String transactionlogid, String service, String operation, String zone,
			String branch, String sourceSystem, String targetSystem, String masterReference, String eventReference,
			String status, String tiRequest, String tiResponse, String bankRequest, String bankResponse,
			Timestamp tiReqTime, Timestamp bankReqTime, Timestamp bankResTime, Timestamp tiResTime, String servicekey1,
			String statickey1, String narrative1, String narrative2, boolean isReSubmitted, String reSubmittedCount,
			String description) {

		boolean result = false;
		Transactionloghistory transactionlog = new Transactionloghistory();

		try {

			if (ValidationsUtil.isValidString(transactionlogid)) {
				transactionlog.setTransactionlogid(new BigInteger(transactionlogid));
			}

			if (ValidationsUtil.isValidString(service)) {
				transactionlog.setService(service);
			} else {
				transactionlog.setService("");
			}

			if (ValidationsUtil.isValidString(operation)) {
				transactionlog.setOperation(operation);
			} else {
				transactionlog.setOperation("");
			}

			if (ValidationsUtil.isValidString(zone)) {
				transactionlog.setZone(zone);
			} else {
				transactionlog.setZone(SOURCE_SYSTEM);
			}

			if (ValidationsUtil.isValidString(branch)) {
				transactionlog.setBranch(branch);
			} else {
				transactionlog.setBranch("");
			}

			if (ValidationsUtil.isValidString(sourceSystem)) {
				transactionlog.setSourcesystem(sourceSystem);
			} else {
				transactionlog.setSourcesystem(SOURCE_SYSTEM);
			}

			if (ValidationsUtil.isValidString(targetSystem)) {
				transactionlog.setTargetsystem(targetSystem);
			} else {
				transactionlog.setTargetsystem(TARGET_SYSTEM);
			}

			if (ValidationsUtil.isValidString(masterReference)) {
				transactionlog.setMasterreference(masterReference);
			} else {
				transactionlog.setMasterreference("");
			}

			if (ValidationsUtil.isValidString(eventReference)) {
				transactionlog.setEventreference(eventReference);
			} else {
				transactionlog.setEventreference("");
			}

			if (ValidationsUtil.isValidString(status)) {
				transactionlog.setStatus(status);
			} else {
				transactionlog.setStatus("");
			}

			if (ValidationsUtil.isValidString(tiRequest)) {
				transactionlog.setTirequest(tiRequest);
			} else {
				transactionlog.setTirequest("");
			}

			if (ValidationsUtil.isValidString(tiResponse)) {
				transactionlog.setTiresponse(tiResponse);
			} else {
				transactionlog.setTiresponse("");
			}

			if (ValidationsUtil.isValidString(bankRequest)) {
				transactionlog.setBankrequest(bankRequest);
			} else {
				transactionlog.setBankrequest("");
			}

			if (ValidationsUtil.isValidString(bankResponse)) {
				transactionlog.setBankresponse(bankResponse);
			} else {
				transactionlog.setBankresponse("");
			}

			if (ValidationsUtil.isValidString(servicekey1)) {
				transactionlog.setServicekey1(servicekey1);
			} else {
				transactionlog.setServicekey1("");
			}

			if (ValidationsUtil.isValidString(statickey1)) {
				transactionlog.setStatickey1(statickey1);
			} else {
				transactionlog.setStatickey1(statickey1);
			}

			if (ValidationsUtil.isValidString(narrative1)) {
				transactionlog.setNarrative1(narrative1);
			} else {
				transactionlog.setNarrative1("");
			}

			if (ValidationsUtil.isValidString(narrative2)) {
				transactionlog.setNarrative2(narrative2);
			} else {
				transactionlog.setNarrative2("");
			}

			if (isReSubmitted) {
				transactionlog.setIsresubmitted('Y');
				transactionlog.setResubmittedcount(new Short(reSubmittedCount));
				transactionlog.setResubmittedtime(DateTimeUtil.getTimestamp());
			} else {
				transactionlog.setIsresubmitted('N');
				transactionlog.setResubmittedtime(null);
				transactionlog.setResubmittedcount(new Short(reSubmittedCount));
			}

			if (ValidationsUtil.isValidString(description)) {
				transactionlog.setDescription(description);
			} else {
				transactionlog.setDescription("");
			}

			transactionlog.setTireqtime(tiReqTime);
			transactionlog.setTirestime(tiResTime);
			transactionlog.setBankreqtime(bankReqTime);
			transactionlog.setBankrestime(bankResTime);
			transactionlog.setProcesstime(DateTimeUtil.getTimestamp());

			TransactionloghistoryAdapter tAdapter = new TransactionloghistoryAdapter();
			result = tAdapter.addProperty(transactionlog);
			logger.debug("Transactiondata history logged successfully!");

		} catch (Exception ex) {
			logger.error("Transactiondata logging error " + ex.getMessage());
			ex.printStackTrace();
			return result;
		}
		return result;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Timestamp timestamp = DateTimeUtil.getTimestamp();

		boolean res = pushLogData("101", "SERVICE", "OPERATION", "ZONE", "BRANCH", "SOURCE", "BOB", "MASTER_REF",
				"EVENT_REF", "SUCCEEDED", "TI_REQUEST", "TI_RESPONSE", "BANK_REQUEST", "BANK_RESPONSE", timestamp,
				timestamp, timestamp, timestamp, "SERVICE_KEY1", "STATIC_KEY1", "NARRATIVE_1", "NARRATIVE_2", false,
				"0", "ERROR DESC");

		boolean res2 = pushLogData("101", "SERVICE", "OPERATION", "ZONE", "BRANCH", "SOURCE", "BOB", "MASTER_REF",
				"EVENT_REF", "SUCCEEDED", "TI_REQUEST", "TI_RESPONSE", "BANK_REQUEST", "BANK_RESPONSE", timestamp,
				timestamp, timestamp, timestamp, "SERVICE_KEY1", "STATIC_KEY1", "NARRATIVE_1", "NARRATIVE_2", true, "1",
				"ERROR DESC");

		// logger.debug("Loging result : " + res);
	}

}
