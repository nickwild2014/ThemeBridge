package com.bs.themebridge.logging;

import static com.bs.themebridge.util.ThemeConstant.SOURCE_SYSTEM;
import static com.bs.themebridge.util.ThemeConstant.TARGET_SYSTEM;
import java.sql.Timestamp;

import org.apache.log4j.Logger;

import com.bs.themebridge.entity.adapter.NotificationslogAdapter;
import com.bs.themebridge.entity.adapter.ServicelogAdapter;
import com.bs.themebridge.entity.model.Notificationslog;
import com.bs.themebridge.entity.model.Servicelog;
import com.bs.themebridge.logging.NotificationsLogging;
import com.bs.themebridge.util.DateTimeUtil;

import com.bs.themebridge.util.ValidationsUtil;

/**
 * 
 * @author Prasath Ravichandran
 *
 */
public class NotificationsLogging {

	private final static Logger logger = Logger.getLogger(NotificationsLogging.class);

	/**
	 * @since 2016-OCT-13
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
	 * @param servicekey1
	 *            {@code allows } {@link String}
	 * @param transactionkey1
	 *            {@code allows } {@link String}
	 * @param statickey1
	 *            {@code allows } {@link String}
	 * @param narrative1
	 *            {@code allows } {@link String}
	 * @param narrative2
	 *            {@code allows } {@link String}
	 * @param narrative3
	 *            {@code allows } {@link String}
	 * @param narrative4
	 *            {@code allows } {@link String}
	 * @param isReSubmitted
	 *            {@code allows } {@link Boolean}
	 * @param reSubmittedCount
	 *            {@code allows } {@link String}
	 * @param description
	 *            {@code allows } {@link String}
	 * @return {@code allows } {@link Boolean}
	 */
	public static boolean pushLogData(final String service, final String operation, final String zone,
			final String branch, final String sourceSystem, final String targetSystem, final String masterReference,
			final String eventReference, final String status, final String tiRequest, final String tiResponse,
			final String bankRequest, final String bankResponse, final Timestamp tiReqTime, final Timestamp bankReqTime,
			final Timestamp bankResTime, final Timestamp tiResTime, final String servicekey1,
			final String transactionkey1, final String statickey1, final String narrative1, final String narrative2,
			final String narrative3, final String narrative4, final boolean isReSubmitted,
			final String reSubmittedCount, final String description) {

		// logger.info("NotificationslogStart(T) >-->> " +
		// DateTimeUtil.getSqlLocalDateTime());
		Thread thread = new Thread() {
			public void run() {
				pushLogData2(service, operation, zone, branch, sourceSystem, targetSystem, masterReference,
						eventReference, status, tiRequest, tiResponse, bankRequest, bankResponse, tiReqTime,
						bankReqTime, bankResTime, tiResTime, servicekey1, transactionkey1, statickey1, narrative1,
						narrative2, narrative3, narrative4, isReSubmitted, reSubmittedCount, description);
			}
		};
		thread.start();
		// logger.info("NotificationslogEnd(T) >-->> " +
		// DateTimeUtil.getSqlLocalDateTime());
		return true;
	}

	public static boolean pushLogData2(String service, String operation, String zone, String branch,
			String sourceSystem, String targetSystem, String masterReference, String eventReference, String status,
			String tiRequest, String tiResponse, String bankRequest, String bankResponse, Timestamp tiReqTime,
			Timestamp bankReqTime, Timestamp bankResTime, Timestamp tiResTime, String servicekey1,
			String transactionkey1, String statickey1, String narrative1, String narrative2, String narrative3,
			String narrative4, boolean isReSubmitted, String reSubmittedCount, String description) {

		boolean result = false;
		Notificationslog notificationsLog = new Notificationslog();
		try {

			if (ValidationsUtil.isValidString(service)) {
				notificationsLog.setService(service);
			} else {
				notificationsLog.setService("");
			}

			if (ValidationsUtil.isValidString(operation)) {
				notificationsLog.setOperation(operation);
			} else {
				notificationsLog.setOperation("");
			}

			if (ValidationsUtil.isValidString(zone)) {
				notificationsLog.setZone(zone);
			} else {
				notificationsLog.setZone(SOURCE_SYSTEM);
			}

			if (ValidationsUtil.isValidString(branch)) {
				notificationsLog.setBranch(branch);
			} else {
				notificationsLog.setBranch("");
			}

			if (ValidationsUtil.isValidString(sourceSystem)) {
				notificationsLog.setSourcesystem(sourceSystem);
			} else {
				notificationsLog.setSourcesystem(SOURCE_SYSTEM);
			}

			if (ValidationsUtil.isValidString(targetSystem)) {
				notificationsLog.setTargetsystem(targetSystem);
			} else {
				notificationsLog.setTargetsystem(TARGET_SYSTEM);
			}

			if (ValidationsUtil.isValidString(masterReference)) {
				notificationsLog.setMasterreference(masterReference);
			} else {
				notificationsLog.setMasterreference("");
			}

			if (ValidationsUtil.isValidString(eventReference)) {
				notificationsLog.setEventreference(eventReference);
			} else {
				notificationsLog.setEventreference("");
			}

			if (ValidationsUtil.isValidString(status)) {
				notificationsLog.setStatus(status);
			} else {
				notificationsLog.setStatus("");
			}

			if (ValidationsUtil.isValidString(tiRequest)) {
				notificationsLog.setTirequest(tiRequest);
			} else {
				notificationsLog.setTirequest("");
			}

			if (ValidationsUtil.isValidString(tiResponse)) {
				notificationsLog.setTiresponse(tiResponse);
			} else {
				notificationsLog.setTiresponse("");
			}

			if (ValidationsUtil.isValidString(bankRequest)) {
				notificationsLog.setBankrequest(bankRequest);
			} else {
				notificationsLog.setBankrequest("");
			}

			if (ValidationsUtil.isValidString(bankResponse)) {
				notificationsLog.setBankresponse(bankResponse);
			} else {
				notificationsLog.setBankresponse("");
			}

			// TODO Enable after change table
			if (ValidationsUtil.isValidString(servicekey1)) {
				notificationsLog.setServicekey1(servicekey1);
			} else {
				notificationsLog.setServicekey1("");
			}

			if (ValidationsUtil.isValidString(transactionkey1)) {
				notificationsLog.setTransactionkey1(transactionkey1);
			} else {
				notificationsLog.setTransactionkey1("");
			}

			if (ValidationsUtil.isValidString(statickey1)) {
				notificationsLog.setStatickey1(statickey1);
			} else {
				notificationsLog.setStatickey1(statickey1);
			}

			if (ValidationsUtil.isValidString(narrative1)) {
				notificationsLog.setNarrative1(narrative1);
			} else {
				notificationsLog.setNarrative1("");
			}

			if (ValidationsUtil.isValidString(narrative2)) {
				notificationsLog.setNarrative2(narrative2);
			} else {
				notificationsLog.setNarrative2("");
			}

			if (ValidationsUtil.isValidString(narrative3)) {
				notificationsLog.setNarrative3(narrative3);
			} else {
				notificationsLog.setNarrative3("");
			}

			if (ValidationsUtil.isValidString(narrative4)) {
				notificationsLog.setNarrative4(narrative4);
			} else {
				notificationsLog.setNarrative4("");
			}
			if (isReSubmitted) {
				notificationsLog.setIsresubmitted('Y');
				notificationsLog.setResubmittedcount(new Short(reSubmittedCount));
				notificationsLog.setResubmittedtime(DateTimeUtil.getTimestamp());
			} else {
				notificationsLog.setIsresubmitted('N');
				notificationsLog.setResubmittedtime(null);
				notificationsLog.setResubmittedcount(new Short(reSubmittedCount));
			}

			if (ValidationsUtil.isValidString(description)) {
				notificationsLog.setDescription(description);
			} else {
				notificationsLog.setDescription("");
			}

			notificationsLog.setTireqtime(tiReqTime);
			notificationsLog.setTirestime(tiResTime);
			notificationsLog.setBankreqtime(bankReqTime);
			notificationsLog.setBankrestime(bankResTime);
			notificationsLog.setProcesstime(DateTimeUtil.getTimestamp());

			NotificationslogAdapter nAdapter = new NotificationslogAdapter();
			result = nAdapter.addProperty(notificationsLog);
			// logger.debug("NotificationsData inserted successfully");

		} catch (Exception ex) {
			logger.error("NotificationsData logging error " + ex.getMessage());
			ex.printStackTrace();
			return result;
		}

		return result;
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

		boolean res = pushLogData("SERVICE", "OPERATION", "ZONE", "BRANCH", "SOURCE", "BOB", "MASTER_REF",
				"EVENT_REF", "SUCCEEDED", "TI_REQUEST", "TI_RESPONSE", "BANK_REQUEST", "BANK_RESPONSE", timestamp,
				timestamp, timestamp, timestamp, "SERVICE_KEY1", "TRANSACTION_KEY1", "STATIC_KEY1", "NARRATIVE_1",
				"NARRATIVE_2", "NARRATIVE_3", "NARRATIVE_4", false, "0", "ERROR DESC");

		boolean res2 = pushLogData("SERVICE", "OPERATION", "ZONE", "BRANCH", "SOURCE", "BOB", "MASTER_REF",
				"EVENT_REF", "SUCCEEDED", "TI_REQUEST", "TI_RESPONSE", "BANK_REQUEST", "BANK_RESPONSE", timestamp,
				timestamp, timestamp, timestamp, "SERVICE_KEY1", "TRANSACTION_KEY1", "STATIC_KEY1", "NARRATIVE_1",
				"NARRATIVE_2", "NARRATIVE_3", "NARRATIVE_4", true, "1", "ERROR DESC");

		logger.debug("Loging result : " + res);
	}

}
