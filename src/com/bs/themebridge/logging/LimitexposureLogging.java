package com.bs.themebridge.logging;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import org.apache.log4j.Logger;

import com.bs.themebridge.entity.adapter.LimitexposureAdapter;
import com.bs.themebridge.entity.model.Limitexposure;
import com.bs.themebridge.util.DateTimeUtil;
import com.bs.themebridge.util.ValidationsUtil;

public class LimitexposureLogging {

	private final static Logger logger = Logger.getLogger(LimitexposureLogging.class);

	/**
	 * 
	 * @param master
	 * @param event
	 * @param accountid
	 * @param tranamount
	 * @param rate
	 * @param lienamount
	 * @param remarks
	 * @param lien
	 * @param lienid
	 * @return
	 */
	public static boolean pushLimitexposureLogging(String master, String event, String limitPrefix, String limitSuffix,
			String reservationid, String tranamount, String trxnccy, String rate, String exposureAmount,
			String exposureccy, String exposureflag, String valueDate, String liabilityType, String narrative1) {

		// logger.debug("Customer Limit Logging initiated");
		boolean result = false;
		try {
			Limitexposure LimitexposureBean = new Limitexposure();

			if (ValidationsUtil.isValidString(master)) {
				LimitexposureBean.setMasterreference(master);
			} else {
				LimitexposureBean.setMasterreference("");
			}

			if (ValidationsUtil.isValidString(event)) {
				LimitexposureBean.setEventreference(event);
			} else {
				LimitexposureBean.setEventreference("");
			}

			if (ValidationsUtil.isValidString(limitPrefix)) {
				LimitexposureBean.setLimitprefix(limitPrefix);
			} else {
				LimitexposureBean.setLimitprefix("");
			}

			if (ValidationsUtil.isValidString(limitSuffix)) {
				LimitexposureBean.setLimitsuffix(limitSuffix);
			} else {
				LimitexposureBean.setLimitsuffix("");
			}

			if (ValidationsUtil.isValidString(reservationid)) {
				LimitexposureBean.setReservationid(reservationid);
			} else {
				LimitexposureBean.setReservationid("");
			}

			// BigDecimal
			if (ValidationsUtil.isValidString(tranamount)) {
				LimitexposureBean.setTrxnamount(new BigDecimal(tranamount));
			} else {
				LimitexposureBean.setTrxnamount(null);
			}

			if (ValidationsUtil.isValidString(trxnccy)) {
				LimitexposureBean.setTrxncurrency(trxnccy);
			} else {
				LimitexposureBean.setTrxncurrency("");
			}

			if (ValidationsUtil.isValidString(rate)) {
				LimitexposureBean.setRate(rate);
			} else {
				LimitexposureBean.setRate("");
			}

			// BigDecimal
			if (ValidationsUtil.isValidString(exposureAmount)) {
				LimitexposureBean.setExposureamount(new BigDecimal(exposureAmount));
			} else {
				LimitexposureBean.setExposureamount(null);
			}

			if (ValidationsUtil.isValidString(exposureccy)) {
				LimitexposureBean.setExposurecurrency(exposureccy);
			} else {
				LimitexposureBean.setExposurecurrency("");
			}

			if (ValidationsUtil.isValidString(exposureflag)) {
				LimitexposureBean.setExposureflag(exposureflag);
			} else {
				LimitexposureBean.setExposureflag("");
			}

			// Date converted
			if (ValidationsUtil.isValidString(valueDate)) {
				Date sqlValueDate = DateTimeUtil.getSqlDateByStringDateInFormat(valueDate, "yyyy-mm-dd");
				LimitexposureBean.setValuedate(sqlValueDate);
			} else {
				LimitexposureBean.setValuedate(null);
			}

			LimitexposureBean.setProcesstime(DateTimeUtil.getTimestamp());

			if (ValidationsUtil.isValidString(liabilityType)) {
				LimitexposureBean.setLiabtype(liabilityType);
			} else {
				LimitexposureBean.setLiabtype("");
			}

			if (ValidationsUtil.isValidString(narrative1)) {
				LimitexposureBean.setNarrative1(narrative1);
			} else {
				LimitexposureBean.setNarrative1("");
			}

			LimitexposureBean.setProcesstime(DateTimeUtil.getTimestamp());

			LimitexposureAdapter LimitexposureObj = new LimitexposureAdapter();
			LimitexposureObj.addProperty(LimitexposureBean);

			logger.debug("Limit exposure details inserted successfully");
			result = true;

		} catch (Exception ex) {
			logger.error("Limit exposure details logging error " + ex.getMessage(), ex);
			ex.printStackTrace();
			return result;
		}

		return true;
	}

	/**
	 * 
	 * @param id
	 * @param master
	 * @param event
	 * @param accountid
	 * @param tranamount
	 * @param rate
	 * @param lienamount
	 * @param remarks
	 * @param lien
	 * @param lienid
	 * @return
	 */
	public static boolean updateLimitexposureLogging(BigDecimal id, String master, String event, String limitPrefix,
			String limitSuffix, String reservationid, String tranamount, String trxnccy, String rate,
			String exposureAmount, String exposureccy, String exposureflag, String valueDate, String liabilityType,
			String narrative1) {

		// logger.debug("Customer Limit Logging initiated");
		boolean result = false;
		try {
			Limitexposure LimitexposureBean = new Limitexposure();

			LimitexposureBean.setId(id);

			if (ValidationsUtil.isValidString(master)) {
				LimitexposureBean.setMasterreference(master);
			} else {
				LimitexposureBean.setMasterreference("");
			}

			if (ValidationsUtil.isValidString(event)) {
				LimitexposureBean.setEventreference(event);
			} else {
				LimitexposureBean.setEventreference("");
			}

			if (ValidationsUtil.isValidString(limitPrefix)) {
				LimitexposureBean.setLimitprefix(limitPrefix);
			} else {
				LimitexposureBean.setLimitprefix("");
			}

			if (ValidationsUtil.isValidString(limitSuffix)) {
				LimitexposureBean.setLimitsuffix(limitSuffix);
			} else {
				LimitexposureBean.setLimitsuffix("");
			}

			if (ValidationsUtil.isValidString(reservationid)) {
				LimitexposureBean.setReservationid(reservationid);
			} else {
				LimitexposureBean.setReservationid("");
			}

			// BigDecimal
			if (ValidationsUtil.isValidString(tranamount)) {
				LimitexposureBean.setTrxnamount(new BigDecimal(tranamount));
			} else {
				LimitexposureBean.setTrxnamount(null);
			}

			if (ValidationsUtil.isValidString(trxnccy)) {
				LimitexposureBean.setTrxncurrency(trxnccy);
			} else {
				LimitexposureBean.setTrxncurrency("");
			}

			if (ValidationsUtil.isValidString(rate)) {
				LimitexposureBean.setRate(rate);
			} else {
				LimitexposureBean.setRate("");
			}

			// BigDecimal
			if (ValidationsUtil.isValidString(exposureAmount)) {
				LimitexposureBean.setExposureamount(new BigDecimal(exposureAmount));
			} else {
				LimitexposureBean.setExposureamount(null);
			}

			if (ValidationsUtil.isValidString(exposureccy)) {
				LimitexposureBean.setExposurecurrency(exposureccy);
			} else {
				LimitexposureBean.setExposurecurrency("");
			}

			if (ValidationsUtil.isValidString(exposureflag)) {
				LimitexposureBean.setExposureflag(exposureflag);
			} else {
				LimitexposureBean.setExposureflag("");
			}

			// Date converted
			if (ValidationsUtil.isValidString(valueDate)) {
				Date sqlValueDate = DateTimeUtil.getSqlDateByStringDateInFormat(valueDate, "yyyy-mm-dd");
				LimitexposureBean.setValuedate(sqlValueDate);
			} else {
				LimitexposureBean.setValuedate(null);
			}

			LimitexposureBean.setProcesstime(DateTimeUtil.getTimestamp());

			if (ValidationsUtil.isValidString(liabilityType)) {
				LimitexposureBean.setLiabtype(liabilityType);
			} else {
				LimitexposureBean.setLiabtype("");
			}

			if (ValidationsUtil.isValidString(narrative1)) {
				LimitexposureBean.setNarrative1(narrative1);
			} else {
				LimitexposureBean.setNarrative1(null);
			}

			LimitexposureBean.setProcesstime(DateTimeUtil.getTimestamp());

			LimitexposureAdapter LimitexposureObj = new LimitexposureAdapter();
			LimitexposureObj.addProperty(LimitexposureBean);

			logger.debug("Limit exposure details updated successfully");
			result = true;

		} catch (Exception ex) {
			logger.error("Limit exposure details logging error " + ex.getMessage(), ex);
			ex.printStackTrace();
			return result;
		}

		return true;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Timestamp timestamp = DateTimeUtil.getTimestamp();

		boolean res = pushLimitexposureLogging("master", "event", "limitPrefix", "limitSuffix", "reservationid",
				"100.23", "USD", "66.54", "6654.32", "INR", "D", "2017-03-07", "FL", null);

		logger.debug("Loging result : " + res);
	}

}
