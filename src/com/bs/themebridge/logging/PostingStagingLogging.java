package com.bs.themebridge.logging;

import static com.bs.theme.bob.template.util.KotakConstant.ZONE;
import static com.bs.themebridge.util.ThemeConstant.SOURCE_SYSTEM;
import static com.bs.themebridge.util.ThemeConstant.TARGET_SYSTEM;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.apache.log4j.Logger;

import com.bs.themebridge.entity.adapter.PostingStagingAdapter;
import com.bs.themebridge.entity.model.Postingstaging;
import com.bs.themebridge.util.DateTimeUtil;
import com.bs.themebridge.util.ValidationsUtil;

/**
 * 
 * @author Prasath Ravichandran
 * 
 */
public class PostingStagingLogging {

	private final static Logger logger = Logger.getLogger(PostingStagingLogging.class);

	/**
	 * @since 2016-OCT-13
	 * @version v1.2
	 * @author Prasath Ravichandran
	 * 
	 * @param service
	 *            {@code allows } {@link String}
	 * @param operation
	 *            {@code allows } {@link String}
	 * @param masterReference
	 *            {@code allows } {@link String}
	 * @param eventReference
	 *            {@code allows } {@link String}
	 * @param tiRequest
	 *            {@code allows } {@link String}
	 * @param tiResponse
	 *            {@code allows } {@link String}
	 * @param status
	 *            {@code allows } {@link String}
	 * @return {@code allows } {@link Boolean}
	 */
	public static boolean pushLogData(String service, String operation, String masterReference, String eventReference,
			String tiRequest, String tiResponse, String status) {

		boolean result = false;
		try {
			Postingstaging postingStaging = new Postingstaging();

			if (ValidationsUtil.isValidString(service)) {
				postingStaging.setService(service);
			} else {
				postingStaging.setService("");
			}

			if (ValidationsUtil.isValidString(operation)) {
				postingStaging.setOperation(operation);
			} else {
				postingStaging.setOperation("");
			}

			postingStaging.setZone(ZONE);
			postingStaging.setBranch("");
			postingStaging.setSourcesystem(SOURCE_SYSTEM);
			postingStaging.setTargetsystem(TARGET_SYSTEM);

			if (ValidationsUtil.isValidString(masterReference)) {
				postingStaging.setMasterreference(masterReference);
			} else {
				postingStaging.setMasterreference("");
			}

			if (ValidationsUtil.isValidString(eventReference)) {
				postingStaging.setEventreference(eventReference);
			} else {
				postingStaging.setEventreference("");
			}

			if (ValidationsUtil.isValidString(tiRequest)) {
				postingStaging.setTirequest(tiRequest);
			} else {
				postingStaging.setTirequest("");
			}

			if (ValidationsUtil.isValidString(tiResponse)) {
				postingStaging.setTiresponse(tiResponse);
			} else {
				postingStaging.setTiresponse("");
			}

			if (ValidationsUtil.isValidString(status)) {
				postingStaging.setStatus(status);
			} else {
				postingStaging.setStatus("");
			}

			postingStaging.setProcesstime(DateTimeUtil.getTimestamp());
			postingStaging.setTireqtime(DateTimeUtil.getTimestamp());

			PostingStagingAdapter sAdapter = new PostingStagingAdapter();
			result = sAdapter.addProperty(postingStaging);
			logger.debug("Posting Staging added successfully!");

		} catch (Exception ex) {
			logger.error("Posting Staging logging error " + ex.getMessage());
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

		boolean res = pushLogData("SERVICE", "OPERATION", "MASTER_REF", "EVENT_REF", "TI_REQUEST", "TI_RESPONSE",
				"SUCCEEDED");

		logger.debug("Loging result : " + res);
	}

	/**
	 * @since 2016-OCT-13
	 * @version v1.2
	 * @author Prasath Ravichandran
	 * 
	 * @param id
	 *            {@code allows } {@link String}
	 * @param service
	 *            {@code allows } {@link String}
	 * @param operation
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
	 * @param tireqtime
	 *            {@code allows } {@link Timestamp}
	 * @return {@code allows } {@link Boolean}
	 */
	public static boolean updateLogData(BigDecimal id, String service, String operation, String masterReference,
			String eventReference, String status, String tiRequest, String tiResponse, Timestamp tireqtime) {

		// logger.debug("Posting Staging Updating initiated");
		boolean result = false;

		try {
			Postingstaging postingStaging = new Postingstaging();

			postingStaging.setId(id);

			if (ValidationsUtil.isValidString(service)) {
				postingStaging.setService(service);
			} else {
				postingStaging.setService("");
			}

			if (ValidationsUtil.isValidString(operation)) {
				postingStaging.setOperation(operation);
			} else {
				postingStaging.setOperation("");
			}

			postingStaging.setZone(ZONE);
			// postingStaging.setBranch("");
			postingStaging.setSourcesystem(SOURCE_SYSTEM);
			postingStaging.setTargetsystem(TARGET_SYSTEM);

			if (ValidationsUtil.isValidString(tiRequest)) {
				postingStaging.setTirequest(tiRequest);
			} else {
				postingStaging.setTirequest("");
			}

			if (ValidationsUtil.isValidString(tiResponse)) {
				postingStaging.setTiresponse(tiResponse);
			} else {
				postingStaging.setTiresponse("");
			}

			if (ValidationsUtil.isValidString(status)) {
				postingStaging.setStatus(status);
			} else {
				postingStaging.setStatus("");
			}

			if (ValidationsUtil.isValidString(masterReference)) {
				postingStaging.setMasterreference(masterReference);
			} else {
				postingStaging.setMasterreference("");
			}

			if (ValidationsUtil.isValidString(eventReference)) {
				postingStaging.setEventreference(eventReference);
			} else {
				postingStaging.setEventreference("");
			}

			postingStaging.setProcesstime(DateTimeUtil.getLocalTime());
			postingStaging.setTireqtime(tireqtime);
			postingStaging.setTirestime(DateTimeUtil.getLocalTime());

			PostingStagingAdapter sAdapter = new PostingStagingAdapter();
			result = sAdapter.updateProperty(postingStaging);
			logger.debug("Posting Staging Updated successfully");

		} catch (Exception ex) {
			logger.error("Posting Staging Updated error " + ex.getMessage());
			ex.printStackTrace();
			return result;
		}
		return result;
	}
}
