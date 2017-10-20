package com.bs.themebridge.logging;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import org.apache.log4j.Logger;

import com.bs.themebridge.entity.adapter.LimitsoftblockAdapter;
import com.bs.themebridge.entity.model.Limitsoftblock;
import com.bs.themebridge.util.DateTimeUtil;
import com.bs.themebridge.util.ValidationsUtil;

public class LimitsoftblockLogging {

	private final static Logger logger = Logger.getLogger(LimitsoftblockLogging.class);

	/**
	 * 
	 * @param master
	 * @param event
	 * @param facilityid
	 * @param reservationid
	 * @param tranamount
	 * @param trxnccy
	 * @param rate
	 * @param limitumlamount
	 * @param limitumlccy
	 * @param limitumlflag
	 * @param valueDate
	 * @param limitservice
	 * @param narrative1
	 * @return
	 */
	public static boolean pushLimitsoftblockLogging(String master, String event, String facilityid,
			String reservationid, String tranamount, String trxnccy, String rate, String limitumlamount,
			String limitumlccy, String limitumlflag, String valueDate, String limitservice, String narrative1) {

		// logger.debug("Customer Limit Logging initiated");
		boolean result = false;
		try {
			Limitsoftblock LimitsoftblockBean = new Limitsoftblock();

			if (ValidationsUtil.isValidString(master)) {
				LimitsoftblockBean.setMasterreference(master);
			} else {
				LimitsoftblockBean.setMasterreference("");
			}

			if (ValidationsUtil.isValidString(event)) {
				LimitsoftblockBean.setEventreference(event);
			} else {
				LimitsoftblockBean.setEventreference("");
			}

			if (ValidationsUtil.isValidString(facilityid)) {
				LimitsoftblockBean.setFacilityid(facilityid);
			} else {
				LimitsoftblockBean.setFacilityid("");
			}

			if (ValidationsUtil.isValidString(reservationid)) {
				LimitsoftblockBean.setReservationid(reservationid);
				;
			} else {
				LimitsoftblockBean.setReservationid("");
			}

			if (ValidationsUtil.isValidString(tranamount)) {
				LimitsoftblockBean.setTranamount(tranamount);
			} else {
				LimitsoftblockBean.setTranamount("");
			}

			if (ValidationsUtil.isValidString(trxnccy)) {
				LimitsoftblockBean.setTrxncurrency(trxnccy);
			} else {
				LimitsoftblockBean.setTrxncurrency("");
			}

			if (ValidationsUtil.isValidString(rate)) {
				LimitsoftblockBean.setRate(rate);
			} else {
				LimitsoftblockBean.setRate("");
			}

			if (ValidationsUtil.isValidString(limitumlamount)) {
				LimitsoftblockBean.setLimitumlamount(limitumlamount);
			} else {
				LimitsoftblockBean.setLimitumlamount("");
			}

			if (ValidationsUtil.isValidString(limitumlccy)) {
				LimitsoftblockBean.setLimitumlcurrency(limitumlccy);
			} else {
				LimitsoftblockBean.setLimitumlcurrency("");
			}

			if (ValidationsUtil.isValidString(limitumlflag)) {
				LimitsoftblockBean.setLimitumlflag(limitumlflag);
			} else {
				LimitsoftblockBean.setLimitumlflag("");
			}

			// Date converted
			if (ValidationsUtil.isValidString(valueDate)) {
				Date sqlValueDate = DateTimeUtil.getSqlDateByStringDateInFormat(valueDate, "yyyy-mm-dd");
				LimitsoftblockBean.setValuedate(sqlValueDate);
			} else {
				LimitsoftblockBean.setValuedate(null);
			}

			LimitsoftblockBean.setProcesstime(DateTimeUtil.getTimestamp());

			if (ValidationsUtil.isValidString(limitservice)) {
				LimitsoftblockBean.setLimitservice(limitservice);
			} else {
				LimitsoftblockBean.setLimitservice("");
			}

			if (ValidationsUtil.isValidString(narrative1)) {
				LimitsoftblockBean.setNarrative1(narrative1);
			} else {
				LimitsoftblockBean.setNarrative1("");
			}

			LimitsoftblockAdapter lienAdapter = new LimitsoftblockAdapter();
			lienAdapter.addProperty(LimitsoftblockBean);

			logger.debug("Limit softblock inserted successfully");
			result = true;

		} catch (Exception ex) {
			logger.error("Limit softblock logging error " + ex.getMessage(), ex);
			ex.printStackTrace();
			return result;
		}

		return true;
	}

	/**
	 * F
	 * 
	 * @param id
	 * @param master
	 * @param event
	 * @param facilityid
	 * @param reservationid
	 * @param tranamount
	 * @param trxnccy
	 * @param rate
	 * @param limitumlamount
	 * @param limitumlccy
	 * @param limitumlflag
	 * @param valueDate
	 * @param limitservice
	 * @param narrative1
	 * @return
	 */
	public static boolean updateLimitsoftblockLogging(BigDecimal id, String master, String event, String facilityid,
			String reservationid, String tranamount, String trxnccy, String rate, String limitumlamount,
			String limitumlccy, String limitumlflag, String valueDate, String limitservice, String narrative1) {

		// logger.debug("Customer Limit Logging initiated");
		boolean result = false;
		try {
			Limitsoftblock LimitsoftblockBean = new Limitsoftblock();

			LimitsoftblockBean.setId(id);

			if (ValidationsUtil.isValidString(master)) {
				LimitsoftblockBean.setMasterreference(master);
			} else {
				LimitsoftblockBean.setMasterreference("");
			}

			if (ValidationsUtil.isValidString(event)) {
				LimitsoftblockBean.setEventreference(event);
			} else {
				LimitsoftblockBean.setEventreference("");
			}

			if (ValidationsUtil.isValidString(facilityid)) {
				LimitsoftblockBean.setFacilityid(facilityid);
			} else {
				LimitsoftblockBean.setFacilityid("");
			}

			if (ValidationsUtil.isValidString(reservationid)) {
				LimitsoftblockBean.setReservationid(reservationid);
				;
			} else {
				LimitsoftblockBean.setReservationid("");
			}

			if (ValidationsUtil.isValidString(tranamount)) {
				LimitsoftblockBean.setTranamount(tranamount);
			} else {
				LimitsoftblockBean.setTranamount("");
			}

			if (ValidationsUtil.isValidString(trxnccy)) {
				LimitsoftblockBean.setTrxncurrency(trxnccy);
			} else {
				LimitsoftblockBean.setTrxncurrency("");
			}

			if (ValidationsUtil.isValidString(rate)) {
				LimitsoftblockBean.setRate(rate);
			} else {
				LimitsoftblockBean.setRate("");
			}

			if (ValidationsUtil.isValidString(limitumlamount)) {
				LimitsoftblockBean.setLimitumlamount(limitumlamount);
			} else {
				LimitsoftblockBean.setLimitumlamount("");
			}

			if (ValidationsUtil.isValidString(limitumlccy)) {
				LimitsoftblockBean.setLimitumlcurrency(limitumlccy);
			} else {
				LimitsoftblockBean.setLimitumlcurrency("");
			}

			if (ValidationsUtil.isValidString(limitumlflag)) {
				LimitsoftblockBean.setLimitumlflag(limitumlflag);
			} else {
				LimitsoftblockBean.setLimitumlflag("");
			}

			// Date converted
			if (ValidationsUtil.isValidString(valueDate)) {
				Date sqlValueDate = DateTimeUtil.getSqlDateByStringDateInFormat(valueDate, "yyyy-mm-dd");
				LimitsoftblockBean.setValuedate(sqlValueDate);
			} else {
				LimitsoftblockBean.setValuedate(null);
			}

			LimitsoftblockBean.setProcesstime(DateTimeUtil.getTimestamp());

			if (ValidationsUtil.isValidString(limitservice)) {
				LimitsoftblockBean.setLimitservice(limitservice);
			} else {
				LimitsoftblockBean.setLimitservice("");
			}

			if (ValidationsUtil.isValidString(narrative1)) {
				LimitsoftblockBean.setNarrative1(narrative1);
			} else {
				LimitsoftblockBean.setNarrative1("");
			}

			LimitsoftblockAdapter lienAdapter = new LimitsoftblockAdapter();
			lienAdapter.updateProperty(LimitsoftblockBean);

			logger.debug("Limit softblock updated successfully");
			result = true;

		} catch (Exception ex) {
			logger.error("Limit softblock logging error " + ex.getMessage(), ex);
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

		boolean res = pushLimitsoftblockLogging("master", "event", "facilityid", "reservationid", "100.23", "USD",
				"3.2", "4554.32", "INR", "D", "2017-03-07", null, null);

		logger.debug("Loging result : " + res);
	}

}
