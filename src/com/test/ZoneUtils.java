package com.test;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.bs.themebridge.util.DatabaseUtility;
import com.bs.themebridge.util.ThemeBridgeUtil;
import com.bs.themebridge.util.ValidationsUtil;

public class ZoneUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private final static Logger logger = Logger.getLogger(ZoneUtils.class);

	public static URL resource = ZoneUtils.class.getResource(".");
	public static String queryLocation = resource.getPath() + "/sql/";

	/**
	 * Get LimitReference/FacilityId number from MasterReference
	 * 
	 * @param masterReference
	 * @return {@link String}
	 */
	public static String getLimitReferenceFromMasterReference(String masterReference, String sourceSystem) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		String result = "";
		try {
			if (!ValidationsUtil.isValidString(masterReference)) {
				return result;
			}
			String query = "select a.master_ref, b.faciltyid from master a, ecmstatus b WHERE a.key97 = b.master_key AND b.master_ref = '"
					+ masterReference + "'";

			try {
				// TODO PRASATH
				con = DatabaseUtility.getTizoneConnection();
				// con = DatabaseUtil.getConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					if (ValidationsUtil.isValidObject(res.getString("faciltyid")))
						result = res.getString("faciltyid").trim();
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();

			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.debug("Exception! Check the logs for detail", ex);
		}
		return result;
	}

	/**
	 * Get LimitReference/FacilityId number from MasterReference
	 * 
	 * @param masterReference
	 *            {@code allows } {@link String}
	 * @param eventReference
	 *            {@code allows } {@link String}
	 * @param sourceSystem
	 *            {@code allows } {@link String}
	 * @return {@link String}
	 */
	public static String getLimitReferencePreAuthorizeTransaction(String masterReference, String eventReference,
			String sourceSystem) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		String result = "";
		try {
			if (!ValidationsUtil.isValidString(masterReference)) {
				return result;
			}

			String query = "SELECT facilityid FROM XMLAPISTO WHERE TYPEFLAG = '20167' AND XMLTEXT LIKE '%"
					+ masterReference + eventReference + "%'";
			try {
				// TODO PRASATH
				con = DatabaseUtility.getTizoneConnection();

				// con = DatabaseUtil.getConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					if (ValidationsUtil.isValidObject(res.getString("facilityid")))
						result = res.getString("facilityid").trim();
				}
			} catch (SQLException e) {
				logger.debug("Exception! Check the logs for details", e);
				try {
					con.rollback();
				} catch (SQLException e1) {
					logger.debug(e1.getMessage(), e1);
				}
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.debug("Exception! Check the logs for detail", ex);
		}
		return result;
	}

	public static String getLimitBreachCommentsPreAuthorizeTransaction(String masterReference, String eventReference,
			String sourceSystem) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		String result = "";
		try {
			if (!ValidationsUtil.isValidString(masterReference)) {
				return result;
			}

			String query = "SELECT xmltext as text FROM XMLAPISTO WHERE TYPEFLAG = '19684' AND XMLTEXT LIKE '%"
					+ masterReference + eventReference + "%'";
			try {
				// TODO PRASATH
				con = DatabaseUtility.getTizoneConnection();
				// con = DatabaseUtil.getConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					if (ValidationsUtil.isValidObject(res.getString("text")))
						result = res.getString("text").trim();
				}
			} catch (SQLException e) {
				logger.debug("Exception! Check the logs for details", e);
				try {
					con.rollback();
				} catch (SQLException e1) {
					logger.debug(e1.getMessage(), e1);
				}
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.debug("Exception! Check the logs for detail", ex);
		}

		if (ValidationsUtil.isValidString(result)) {
			result = ThemeBridgeUtil.getXMLTagValue(result, "extraValue");
			result = ThemeBridgeUtil.getSubStringData(result, 9, result.length() - 3);
		}

		return result;
	}

	/**
	 * Get Limit breach comments from MasterReference
	 * 
	 * @param masterReference
	 * @return {@link String}
	 */
	public static String getLimitBreachCommentsFromMasterReference(String masterReference, String sourceSystem) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		StringBuffer result = new StringBuffer("");
		try {
			if (!ValidationsUtil.isValidString(masterReference)) {
				return result.toString();
			}

			String query = "select a.master_ref as Masterreference, C.NOTE_TEXT as notes, c.active, c.emphasis, d.descri56 as notetype from master a, baseevent b, Note c, notety24 d where a.key97 = b.master_key and b.key97 = c.note_event and c.type = d.mykey95 and a.master_ref = '"
					+ masterReference + "'";

			try {
				// TODO p
				con = DatabaseUtility.getTizoneConnection();
				// con = DatabaseUtil.getConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					if (ValidationsUtil.isValidString(res.getString("notes").trim())) {
						String noteType = res.getString("notetype").trim();
						String notes = res.getString("notes").trim();
						if ("Credit Approval".equalsIgnoreCase(noteType)) {
							if (ValidationsUtil.isValidString(result.toString()))
								result.append(", ");
							result.append(noteType + " - " + notes);
						}
					}
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();

			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.debug("Exception! Check the logs for detail", ex);
		}
		return result.toString();
	}

	/**
	 * Get current date of TIPlus system
	 * 
	 * @return {@link String}
	 */
	public static String getCurrentDateofTISystem(String sourceSystem) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		String result = "";
		try {
			String query = "select TO_CHAR(procdate,'dd-MM-yyyy') as currentdate from dlyprccycl";
			try {
				// TODO PRASATH
				con = DatabaseUtility.getTizoneConnection();
				// con = DatabaseUtil.getConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					if (ValidationsUtil.isValidString(res.getString("currentdate").trim())) {
						result = res.getString("currentdate").trim();
					}
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();

			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.debug("Exception! Check the logs for detail", ex);
		}
		return result;
	}

	/**
	 * Get previous date of TIPlus system
	 * 
	 * @return {@link String}
	 */
	public static String getPreviousDateofTISystem(String sourceSystem) {
		// public static String getPreviousDateofTISystem() {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		String result = "";
		try {
			String query = "select TO_CHAR(procdate - 1,'dd-MM-yyyy') as currentdate from dlyprccycl";
			try {
				// TODO PRASATHB
				con = DatabaseUtility.getTizoneConnection();
				// con = DatabaseUtil.getConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					if (ValidationsUtil.isValidString(res.getString("currentdate").trim())) {
						result = res.getString("currentdate").trim();
					}
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();

			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.debug("Exception! Check the logs for detail", ex);
		}
		return result;
	}

	/**
	 * Get CustomerId from MasterReference used for InitiateReferral purpose
	 * 
	 * @param masterReference
	 *            {@code allows } {@link String}
	 * @return {@link String}
	 */
	public static String getCustomerIdFromMasterReferenceForReferral(String masterReference, String productId,
			String sourceSystem) {
		// public static String getCustomerIdFromMasterReferenceForReferral(
		// String masterReference, String productId) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		String result = null;

		try {
			if (!ValidationsUtil.isValidString(masterReference) || !ValidationsUtil.isValidString(productId)) {
				return null;
			}

			String query = "";

			if (productId.equalsIgnoreCase("ILC")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "ilc_pty.sql");
			} else if (productId.equalsIgnoreCase("ELC")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "elc_pty.sql");
			} else if (productId.equalsIgnoreCase("IGT")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "igt_pty.sql");
			} else if (productId.equalsIgnoreCase("EGT")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "egt_pty.sql");
			} else if (productId.equalsIgnoreCase("IDC")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "idc_pty.sql");
			} else if (productId.equalsIgnoreCase("ODC")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "odc_pty.sql");
			} else if (productId.equalsIgnoreCase("SHG")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "shg_pty.sql");
			} else if (productId.equalsIgnoreCase("ICC")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "icc_pty.sql");
			} else if (productId.equalsIgnoreCase("ICL")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "icl_pty.sql");
			} else if (productId.equalsIgnoreCase("OCC")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "occ_pty.sql");
			} else if (productId.equalsIgnoreCase("OCL")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "ocl_pty.sql");
			} else if (productId.equalsIgnoreCase("OCL")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "ocl_pty.sql");
			} else if (productId.equalsIgnoreCase("ISB")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "isb_pty.sql");
			} else if (productId.equalsIgnoreCase("ESB")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "esb_pty.sql");
			} else if (productId.equalsIgnoreCase("CBA")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "cba_pty.sql");
			} else if (productId.equalsIgnoreCase("RMB")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "rmb_pty.sql");
			} else if (productId.equalsIgnoreCase("IRF")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "irf_pty.sql");
			} else if (productId.equalsIgnoreCase("CRN")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "crn_pty.sql");
			} else if (productId.equalsIgnoreCase("INV")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "inv_pty.sql");
			} else if (productId.equalsIgnoreCase("FAC")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "fac_pty.sql");
			} else if (productId.equalsIgnoreCase("IDS")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "ids_pty.sql");
			} else if (productId.equalsIgnoreCase("FSA")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "fsa_pty.sql");
			} else {
				query = "SELECT CASE WHEN TRIM(PRICUSTMNM) IS NOT NULL THEN TRIM(PRICUSTMNM) ELSE CASE WHEN TRIM(NPRCUSTMNM) IS NOT NULL THEN TRIM(NPRCUSTMNM) ELSE '1' END END AS CUSTOMERID, MASTER_REF FROM MASTER WHERE MASTER_REF = '{referenceNumber}'";
			}

			query = ThemeBridgeUtil.replaceTokenByValue(query, "{referenceNumber}", masterReference);

			try {
				// TODO
				con = DatabaseUtility.getTizoneConnection();
				// con = DatabaseUtil.getConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					if (ValidationsUtil.isValidString(res.getString("customerid")))
						result = res.getString("customerid").trim();
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();

			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.debug("Exception! Check the logs for detail", ex);
		}
		return result;
	}

	/**
	 * Check if user have access for Themebridge application
	 * 
	 * @param userName
	 *            {@code allows } {@link String}
	 * @param extApp
	 *            {@code allows } {@link String}
	 * 
	 * @return {@link boolean}
	 */
	public static boolean isUserAccessibleForThemebridge(String userName, String extApp, String sourceSystem) {
		boolean isValid = false;
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		try {
			String query = ThemeBridgeUtil.readFile(queryLocation + "cap_usr_map.sql");
			query = ThemeBridgeUtil.replaceTokenByValue(query, "{userName}", userName);
			query = ThemeBridgeUtil.replaceTokenByValue(query, "{extApp}", extApp);
			try {
				// TODO P 2016-04-05

				con = DatabaseUtility.getThemebridgeConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);

				while (res.next()) {
					if (ValidationsUtil.isValidString(res.getString("usrs")))
						isValid = true;
				}
			} catch (SQLException e) {
				logger.debug("Exception! Check the logs for details", e);
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.debug("Exception in user external applications", ex);
		}

		return isValid;
	}

	/**
	 * Get currency decimal precision
	 * 
	 * @param currency
	 *            {@code allows } {@link String}
	 * @return {@link String}
	 */
	public static String getCurrencyDecimalPrecision(String currency, String sourceSystem) {
		String result = "";
		try {
			Connection con = null;
			Statement stmt = null;
			ResultSet res = null;
			String query = "select c8ced from c8pf where c8ccy = '" + currency + "'";
			try {
				// TODO P
				con = DatabaseUtility.getTizoneConnection();
				// con = DatabaseUtil.getConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					if (ValidationsUtil.isValidString(res.getString("c8ced"))) {
						result = res.getString("c8ced").trim();
					}
				}
			} catch (SQLException e) {
				logger.debug("Exception! Check the logs for details", e);
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.debug("Exception! Check the logs for detail", ex);
		}
		return result;
	}

}
