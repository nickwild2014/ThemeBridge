package com.bs.themebridge.logging;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.apache.log4j.Logger;

import com.bs.themebridge.entity.adapter.LiendetailsAdapter;
import com.bs.themebridge.entity.model.Liendetails;
import com.bs.themebridge.util.DateTimeUtil;
import com.bs.themebridge.util.ValidationsUtil;

public class LiendetailsLogging {

	private final static Logger logger = Logger.getLogger(LiendetailsLogging.class);

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
	public static boolean pushLiendetailsLogging(String master, String event, String accountid, String tranamount,
			String rate, String lienamount, String remarks, String lien, String lienid) {

		// logger.debug("Customer Limit Logging initiated");
		boolean result = false;
		try {
			Liendetails liendetailsBean = new Liendetails();

			if (ValidationsUtil.isValidString(master)) {
				liendetailsBean.setMasterreference(master);
			} else {
				liendetailsBean.setMasterreference("");
			}

			if (ValidationsUtil.isValidString(event)) {
				liendetailsBean.setEventreference(event);
			} else {
				liendetailsBean.setEventreference("");
			}

			if (ValidationsUtil.isValidString(accountid)) {
				liendetailsBean.setAccountid(accountid);
			} else {
				liendetailsBean.setAccountid("");
			}

			if (ValidationsUtil.isValidString(tranamount)) {
				liendetailsBean.setTranamount(tranamount);
			} else {
				liendetailsBean.setTranamount("");
			}

			if (ValidationsUtil.isValidString(rate)) {
				liendetailsBean.setRate(rate);
			} else {
				liendetailsBean.setRate("");
			}

			if (ValidationsUtil.isValidString(lienamount)) {
				liendetailsBean.setLienamount(lienamount + " INR");
			} else {
				liendetailsBean.setLienamount("");
			}

			if (ValidationsUtil.isValidString(remarks)) {
				liendetailsBean.setRemarks(remarks);
			} else {
				liendetailsBean.setRemarks("");
			}

			if (ValidationsUtil.isValidString(lien)) {
				liendetailsBean.setLien(lien);
			} else {
				liendetailsBean.setLien("");
			}

			if (ValidationsUtil.isValidString(lienid)) {
				liendetailsBean.setLienid(lienid);
			} else {
				liendetailsBean.setLienid("");
			}

			liendetailsBean.setProcesstime(DateTimeUtil.getTimestamp());

			LiendetailsAdapter lienAdapter = new LiendetailsAdapter();
			lienAdapter.addProperty(liendetailsBean);

			result = true;
			logger.debug("Lien details inserted successfully");

		} catch (Exception ex) {
			logger.error("Lien details logging error " + ex.getMessage(), ex);
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
	public static boolean updateLiendetailsLogging(BigDecimal id, String master, String event, String accountid,
			String tranamount, String rate, String lienamount, String remarks, String lien, String lienid) {

		// logger.debug("Customer Limit Logging initiated");
		boolean result = false;
		try {
			Liendetails liendetailsBean = new Liendetails();

			liendetailsBean.setId(id);

			if (ValidationsUtil.isValidString(master)) {
				liendetailsBean.setMasterreference(master);
			} else {
				liendetailsBean.setMasterreference("");
			}

			if (ValidationsUtil.isValidString(event)) {
				liendetailsBean.setEventreference(event);
			} else {
				liendetailsBean.setEventreference("");
			}

			if (ValidationsUtil.isValidString(accountid)) {
				liendetailsBean.setAccountid(accountid);
			} else {
				liendetailsBean.setAccountid("");
			}

			if (ValidationsUtil.isValidString(tranamount)) {
				liendetailsBean.setTranamount(tranamount);
			} else {
				liendetailsBean.setTranamount("");
			}

			if (ValidationsUtil.isValidString(rate)) {
				liendetailsBean.setRate(rate);
			} else {
				liendetailsBean.setRate("");
			}

			if (ValidationsUtil.isValidString(lienamount)) {
				liendetailsBean.setLienamount(lienamount + " INR");
			} else {
				liendetailsBean.setLienamount("");
			}

			if (ValidationsUtil.isValidString(remarks)) {
				liendetailsBean.setRemarks(remarks);
			} else {
				liendetailsBean.setRemarks("");
			}

			if (ValidationsUtil.isValidString(lien)) {
				liendetailsBean.setLien(lien);
			} else {
				liendetailsBean.setLien("");
			}

			if (ValidationsUtil.isValidString(lienid)) {
				liendetailsBean.setLienid(lienid);
			} else {
				liendetailsBean.setLienid("");
			}

			liendetailsBean.setProcesstime(DateTimeUtil.getTimestamp());

			LiendetailsAdapter lienAdapter = new LiendetailsAdapter();
			lienAdapter.updateProperty(liendetailsBean);

			logger.debug("Lien details updated successfully");
			result = true;

		} catch (Exception ex) {
			logger.error("Lien details logging error " + ex.getMessage(), ex);
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

		boolean res = pushLiendetailsLogging("master", "event", "accountid", "tranamount", "66.23", "500 INR",
				"Remarks", "M", "lienid");

		logger.debug("Loging result : " + res);
	}

}
