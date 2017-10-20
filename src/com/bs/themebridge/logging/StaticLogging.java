package com.bs.themebridge.logging;

import java.sql.Timestamp;

import org.apache.log4j.Logger;

import com.bs.themebridge.entity.adapter.StaticdatalogAdapter;
import com.bs.themebridge.entity.model.Staticdatalog;
import com.bs.themebridge.logging.StaticLogging;
import com.bs.themebridge.util.DateTimeUtil;
import com.bs.themebridge.util.ThemeBridgeUtil;
import com.bs.themebridge.util.ValidationsUtil;
import static com.bs.themebridge.util.ThemeConstant.SOURCE_SYSTEM;
import static com.bs.themebridge.util.ThemeConstant.TARGET_SYSTEM;

/**
 * 
 * @author Prasath Ravichandran
 *
 */
public class StaticLogging {

	private final static Logger logger = Logger.getLogger(StaticLogging.class);

	/**
	 * @since 2016-OCT-13
	 * @version v1.2
	 * @author Prasath Ravichandran
	 * 
	 * @param service
	 *            {@code allowed object is } {@link String }
	 * @param entityType
	 *            {@code allowed object is } {@link String }
	 * @param zone
	 *            {@code allowed object is } {@link String }
	 * @param branch
	 *            {@code allowed object is } {@link String }
	 * @param sourceSystem
	 *            {@code allowed object is } {@link String }
	 * @param targetSystem
	 *            {@code allowed object is } {@link String }
	 * @param status
	 *            {@code allowed object is } {@link String }
	 * @param receivedTime
	 *            {@code allowed object is } {@link Timestamp }
	 * @param inputMessage
	 *            {@code allowed object is } {@link String }
	 * @param tiRequest
	 *            {@code allowed object is } {@link String }
	 * @param tiResponse
	 *            {@code allowed object is } {@link String }
	 * @param narrative1
	 *            {@code allowed object is } {@link String }
	 * @param narrative2
	 *            {@code allowed object is } {@link String }
	 * @param narrative3
	 *            {@code allowed object is } {@link String }
	 * @param isReSubmitted
	 *            {@code allowed object is } {@link Boolean }
	 * @param reSubmittedCount
	 *            {@code allowed object is } {@link String }
	 * @param description
	 *            {@code allowed object is } {@link String }
	 * @return {@code allowed object is } {@link Boolean }
	 */
	public static boolean pushLogData(String service, String entityType, String zone, String branch,
			String sourceSystem, String targetSystem, String status, Timestamp receivedTime, String inputMessage,
			String tiRequest, String tiResponse, String narrative1, String narrative2, String narrative3,
			boolean isReSubmitted, String reSubmittedCount, String description) {

		boolean result = false;
		Staticdatalog staticDataLog = new Staticdatalog();

		try {

			if (ValidationsUtil.isValidString(service)) {
				staticDataLog.setService(service);
			} else {
				staticDataLog.setService("");
			}

			if (ValidationsUtil.isValidString(entityType)) {
				staticDataLog.setEntitytype(entityType);
			} else {
				staticDataLog.setEntitytype("");
			}

			if (ValidationsUtil.isValidString(zone)) {
				staticDataLog.setZone(zone);
			} else {
				staticDataLog.setZone(SOURCE_SYSTEM);
			}

			if (ValidationsUtil.isValidString(branch)) {
				staticDataLog.setBranch(branch);
			} else {
				staticDataLog.setBranch("");
			}

			if (ValidationsUtil.isValidString(sourceSystem)) {
				staticDataLog.setSourcesystem(sourceSystem);
			} else {
				staticDataLog.setSourcesystem(SOURCE_SYSTEM);
			}

			if (ValidationsUtil.isValidString(targetSystem)) {
				staticDataLog.setTargetsystem(targetSystem);
			} else {
				staticDataLog.setTargetsystem(TARGET_SYSTEM);
			}

			if (ValidationsUtil.isValidString(status)) {
				staticDataLog.setStatus(status);
			} else {
				staticDataLog.setStatus("");
			}

			if (ValidationsUtil.isValidString(status)) {
				staticDataLog.setReceivedtime(receivedTime);
			} else {
				staticDataLog.setReceivedtime(null);
			}

			if (ValidationsUtil.isValidString(inputMessage)) {
				staticDataLog.setInputmsg(inputMessage);
			} else {
				staticDataLog.setInputmsg("");
			}

			if (ValidationsUtil.isValidString(tiRequest)) {
				staticDataLog.setTirequest(tiRequest);
			} else {
				staticDataLog.setTirequest("");
			}

			if (ValidationsUtil.isValidString(tiResponse)) {
				staticDataLog.setTiresponse(tiResponse);
			} else {
				staticDataLog.setTiresponse("");
			}

			if (ValidationsUtil.isValidString(narrative1)) {
				staticDataLog.setNarrative1(narrative1);
			} else {
				staticDataLog.setNarrative1("");
			}

			if (ValidationsUtil.isValidString(narrative2)) {
				staticDataLog.setNarrative2(narrative2);
			} else {
				staticDataLog.setNarrative2("");
			}

			if (ValidationsUtil.isValidString(narrative3)) {
				staticDataLog.setNarrative3(narrative3);
			} else {
				staticDataLog.setNarrative3("");
			}

			if (isReSubmitted) {
				staticDataLog.setIsresubmitted('Y');
				staticDataLog.setResubmittedcount(new Short(reSubmittedCount));
				staticDataLog.setResubmittedtime(DateTimeUtil.getTimestamp());
			} else {
				staticDataLog.setIsresubmitted('N');
				staticDataLog.setResubmittedtime(null);
				staticDataLog.setResubmittedcount(new Short(reSubmittedCount));
			}

			if (ValidationsUtil.isValidString(description)) {
				staticDataLog.setDescription(description);
			} else {
				staticDataLog.setDescription("");
			}

			staticDataLog.setProcesstime(DateTimeUtil.getTimestamp());

			StaticdatalogAdapter sAdapter = new StaticdatalogAdapter();
			result = sAdapter.addProperty(staticDataLog);
			logger.debug("StaticdataLog added successfully!");

		} catch (Exception ex) {
			logger.error("Staticdata logging error " + ex.getMessage());
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

		boolean res1 = pushLogData("SERVICE", "ENTITYTYPE", "ZONE", "BRANCH", "SOURCE", "BOB", "SUCCEEDED", timestamp,
				"INPUT_MESSAGE", "TI_REQUEST", "TI_RESPONSE", "NARRATIVE_1", "NARRATIVE_2", "NARRATIVE_3", false, "0",
				"ERROR DESC");

		boolean res2 = pushLogData("SERVICE", "ENTITYTYPE", "ZONE", "BRANCH", "SOURCE", "BOB", "SUCCEEDED", timestamp,
				"INPUT_MESSAGE", "TI_REQUEST", "TI_RESPONSE", "NARRATIVE_1", "NARRATIVE_2", "NARRATIVE_3", true, "1",
				"ERROR DESC");

		/// logger.debug("Loging result : " + res2);
	}

}
