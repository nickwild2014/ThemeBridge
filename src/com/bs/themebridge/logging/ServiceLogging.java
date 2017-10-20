package com.bs.themebridge.logging;

import static com.bs.themebridge.util.ThemeConstant.SOURCE_SYSTEM;
import static com.bs.themebridge.util.ThemeConstant.TARGET_SYSTEM;

import java.sql.Timestamp;

import org.apache.log4j.Logger;

import com.bs.themebridge.entity.adapter.ServicelogAdapter;
import com.bs.themebridge.entity.model.Servicelog;
import com.bs.themebridge.util.DateTimeUtil;
import com.bs.themebridge.util.ValidationsUtil;

/**
 * 
 * @author Prasath Ravichandran
 *
 */
public class ServiceLogging {

	private final static Logger logger = Logger.getLogger(ServiceLogging.class);

	/**
	 * @since 2016-OCT-12
	 * @version v1.2
	 * @author Prasath Ravichandran
	 * 
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
	 * @param tiResponse
	 *            {@code allows } {@link String}
	 * @param bankRequest
	 *            {@code allows } {@link String}
	 * @param bankResponse
	 *            {@code allows } {@link String}
	 * @param tiReqTime
	 *            {@code allows } {@link Timestamp}
	 * @param bankReqTime
	 *            {@code allows } {@link Timestamp}
	 * @param bankResTime
	 *            {@code allows } {@link Timestamp}
	 * @param tiResTime
	 *            {@code allows } {@link Timestamp}
	 * @param transactionkey1
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
	public static boolean pushLogData(final String service, final String operation, final String zone,
			final String branch, final String sourceSystem, final String targetSystem, final String masterReference,
			final String eventReference, final String status, final String tiRequest, final String tiResponse,
			final String bankRequest, final String bankResponse, final Timestamp tiReqTime, final Timestamp bankReqTime,
			final Timestamp bankResTime, final Timestamp tiResTime, final String transactionkey1,
			final String statickey1, final String narrative1, final String narrative2, final boolean isReSubmitted,
			final String reSubmittedCount, final String description) {

		// logger.info("ServicelogStart(T) >-->> " +
		// DateTimeUtil.getSqlLocalDateTime());
		Thread thread = new Thread() {
			public void run() {
				pushLogData2(service, operation, zone, branch, sourceSystem, targetSystem, masterReference,
						eventReference, status, tiRequest, tiResponse, bankRequest, bankResponse, tiReqTime,
						bankReqTime, bankResTime, tiResTime, transactionkey1, statickey1, narrative1, narrative2,
						isReSubmitted, reSubmittedCount, description);
			}
		};
		thread.start();
		// logger.info("ServicelogEnd(T) >-->> " +
		// DateTimeUtil.getSqlLocalDateTime());
		return true;
	}

	public static boolean pushLogData2(String service, String operation, String zone, String branch,
			String sourceSystem, String targetSystem, String masterReference, String eventReference, String status,
			String tiRequest, String tiResponse, String bankRequest, String bankResponse, Timestamp tiReqTime,
			Timestamp bankReqTime, Timestamp bankResTime, Timestamp tiResTime, String transactionkey1,
			String statickey1, String narrative1, String narrative2, boolean isReSubmitted, String reSubmittedCount,
			String description) {

		// logger.debug("Servicedata logged initiated!!!");
		logger.info("ServicelogStart >-->> " + DateTimeUtil.getSqlLocalDateTime());
		boolean result = false;
		Servicelog serviceLog = new Servicelog();

		try {

			if (ValidationsUtil.isValidString(service)) {
				serviceLog.setService(service);
			} else {
				serviceLog.setService("");
			}

			if (ValidationsUtil.isValidString(operation)) {
				serviceLog.setOperation(operation);
			} else {
				serviceLog.setOperation("");
			}
			// logger.debug("Milestone 012");
			if (ValidationsUtil.isValidString(zone)) {
				serviceLog.setZone(zone);
			} else {
				serviceLog.setZone(SOURCE_SYSTEM);
			}

			if (ValidationsUtil.isValidString(branch)) {
				serviceLog.setBranch(branch);
			} else {
				serviceLog.setBranch("");
			}
			// logger.debug("Milestone 013");
			if (ValidationsUtil.isValidString(sourceSystem)) {
				serviceLog.setSourcesystem(sourceSystem);
			} else {
				serviceLog.setSourcesystem(SOURCE_SYSTEM);
			}

			if (ValidationsUtil.isValidString(targetSystem)) {
				serviceLog.setTargetsystem(targetSystem);
			} else {
				serviceLog.setTargetsystem(TARGET_SYSTEM);
			}
			// logger.debug("Milestone 013");
			if (ValidationsUtil.isValidString(masterReference)) {
				serviceLog.setMasterreference(masterReference);
			} else {
				serviceLog.setMasterreference("");
			}

			if (ValidationsUtil.isValidString(eventReference)) {
				serviceLog.setEventreference(eventReference);
			} else {
				serviceLog.setEventreference("");
			}
			// logger.debug("Milestone 014");
			if (ValidationsUtil.isValidString(status)) {
				serviceLog.setStatus(status);
			} else {
				serviceLog.setStatus("");
			}

			if (ValidationsUtil.isValidString(tiRequest)) {
				serviceLog.setTirequest(tiRequest);
			} else {
				serviceLog.setTirequest("");
			}
			// logger.debug("Milestone 015");
			if (ValidationsUtil.isValidString(tiResponse)) {
				serviceLog.setTiresponse(tiResponse);
			} else {
				serviceLog.setTiresponse("");
			}

			if (ValidationsUtil.isValidString(bankRequest)) {
				serviceLog.setBankrequest(bankRequest);
			} else {
				serviceLog.setBankrequest("");
			}
			// logger.debug("Milestone 016");
			if (ValidationsUtil.isValidString(bankResponse)) {
				serviceLog.setBankresponse(bankResponse);
			} else {
				serviceLog.setBankresponse("");
			}

			if (ValidationsUtil.isValidString(transactionkey1)) {
				serviceLog.setTransactionkey1(transactionkey1);
			} else {
				serviceLog.setTransactionkey1("");
			}
			// logger.debug("Milestone 017");
			if (ValidationsUtil.isValidString(statickey1)) {
				serviceLog.setStatickey1(statickey1);
			} else {
				serviceLog.setStatickey1(statickey1);
			}

			if (ValidationsUtil.isValidString(narrative1)) {
				serviceLog.setNarrative1(narrative1);
			} else {
				serviceLog.setNarrative1("");
			}
			// logger.debug("Milestone 018");
			if (ValidationsUtil.isValidString(narrative2)) {
				serviceLog.setNarrative2(narrative2);
			} else {
				serviceLog.setNarrative2("");
			}
			// logger.debug("Milestone 019");
			if (isReSubmitted) {
				serviceLog.setIsresubmitted('Y');
				serviceLog.setResubmittedcount(new Short(reSubmittedCount));
				serviceLog.setResubmittedtime(DateTimeUtil.getTimestamp());
			} else {
				serviceLog.setIsresubmitted('N');
				serviceLog.setResubmittedtime(null);
				serviceLog.setResubmittedcount(new Short(reSubmittedCount));
			}
			// logger.debug("Milestone 020");
			if (ValidationsUtil.isValidString(description)) {
				serviceLog.setDescription(description);
			} else {
				serviceLog.setDescription("");
			}
			// logger.debug("Milestone 021");
			serviceLog.setTireqtime(tiReqTime);
			serviceLog.setTirestime(tiResTime);
			serviceLog.setBankreqtime(bankReqTime);
			serviceLog.setBankrestime(bankResTime);
			serviceLog.setProcesstime(DateTimeUtil.getTimestamp());
			// logger.debug("Milestone 022");
			ServicelogAdapter sAdapter = new ServicelogAdapter();
			result = sAdapter.addProperty(serviceLog);
			logger.debug("Servicedata logged successfully!");

		} catch (Exception ex) {
			logger.error("Servicedata logging error " + ex.getMessage());
			ex.printStackTrace();
			return result;
		}

		logger.info("ServicelogEnd >-->> " + DateTimeUtil.getSqlLocalDateTime());
		return true;
	}

	/**
	 * Update servicelog data
	 * 
	 * @param serviceLog
	 *            {@code allows } {@link Servicelog}
	 */
	public static void updateServicelog(Servicelog serviceLog) {
		try {
			ServicelogAdapter sAdapter = new ServicelogAdapter();
			if (ValidationsUtil.isValidString(serviceLog.getBankrequest())) {
				serviceLog.setBankrequest(serviceLog.getBankrequest());
			}

			if (ValidationsUtil.isValidString(serviceLog.getBankresponse())) {
				serviceLog.setBankresponse(serviceLog.getBankresponse());
			}

			serviceLog.setProcesstime(DateTimeUtil.getLocalTime());
			sAdapter.updateProperty(serviceLog);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Timestamp timestamp = DateTimeUtil.getTimestamp();

		// NEW LOGGING
		boolean res = ServiceLogging.pushLogData("SERVICE", "OPERATION", "ZONE", "BRANCH", "SOURCE", "BOB",
				"MASTER_REF", "EVENT_REF", "SUCCEEDED", "TI_REQUEST", "TI_RESPONSE", "BANK_REQUEST", "BANK_RESPONSE",
				timestamp, timestamp, timestamp, timestamp, "TRANSACTION_KEY1", "STATIC_KEY1", "NARRATIVE_1",
				"NARRATIVE_2", false, "0", "ERRORDESC");

		boolean res2 = pushLogData("SERVICE", "OPERATION", "ZONE", "BRANCH", "SOURCE", "BOB", "MASTER_REF",
				"EVENT_REF", "SUCCEEDED", "TI_REQUEST", "TI_RESPONSE", "BANK_REQUEST", "BANK_RESPONSE", timestamp,
				timestamp, timestamp, timestamp, "TRANSACTION_KEY1", "STATIC_KEY1", "NARRATIVE_1", "NARRATIVE_2", true,
				"1", "ERRORDESC");

		// logger.debug("Loging result : " + res);
	}

}
