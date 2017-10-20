package com.test;

import java.io.File;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.bs.themebridge.token.util.ConfigurationUtil;
import com.bs.themebridge.util.DatabaseUtility;
import com.bs.themebridge.util.ThemeBridgeUtil;
import com.bs.themebridge.util.ValidationsUtil;

public class CustomisationQueryUtil {

	public static Logger logger = Logger.getLogger(CustomisationQueryUtil.class);

	public static List getCustomerData(String customerMnemonic) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;

		List<LinkedHashMap> resMap = null;

		try {
			if (!ValidationsUtil.isValidString(customerMnemonic)) {
				return null;
			}

			resMap = new ArrayList<LinkedHashMap>();

			String query = "SELECT ACCT_KEY, CUS_SBB, ACC_TYPE, CURRENCY, BO_ACCTNO, EXT_ACCTNO, COUNTRY, DESCR1, DESCR2 FROM ACCOUNT WHERE CUS_MNM = '"
					+ customerMnemonic + "'";

			try {
				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				logger.debug("Query : " + query);
				while (res.next()) {
					LinkedHashMap<String, String> lhm = new LinkedHashMap<String, String>();
					lhm.put("ACCT_KEY", res.getString("ACCT_KEY").trim());
					lhm.put("CUS_SBB", res.getString("CUS_SBB").trim());
					lhm.put("ACC_TYPE", res.getString("ACC_TYPE").trim());
					lhm.put("CURRENCY", res.getString("CURRENCY").trim());
					lhm.put("BO_ACCTNO", res.getString("BO_ACCTNO").trim());
					lhm.put("EXT_ACCTNO", res.getString("EXT_ACCTNO").trim());
					lhm.put("COUNTRY", res.getString("COUNTRY").trim());
					lhm.put("DESCR1", res.getString("DESCR1").trim());
					lhm.put("DESCR2", res.getString("DESCR2").trim());
					resMap.add(lhm);
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();

			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.error("Exception! " + ex.getMessage());
			ex.printStackTrace();
		}
		return resMap;
	}

	public static List getCustomerDetails(String customerMnemonic) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;

		List<LinkedHashMap> resMap = null;

		try {
			if (!ValidationsUtil.isValidString(customerMnemonic)) {
				return null;
			}

			resMap = new ArrayList<LinkedHashMap>();

			String query = "SELECT GFC201, GFC202, GFACO, GFCA2 FROM GFPF WHERE GFCPNC = '" + customerMnemonic + "'";

			try {
				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					LinkedHashMap<String, String> lhm = new LinkedHashMap<String, String>();
					lhm.put("CUST_UID", res.getString("GFC201").trim());
					lhm.put("CUST_T24_ID", res.getString("GFC202").trim());
					lhm.put("CUST_ACCT_OFFICER", res.getString("GFACO").trim());
					lhm.put("CUST_AN_CODE", res.getString("GFCA2").trim());
					resMap.add(lhm);
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return resMap;
	}

	public static List getCustomerEmailaddr(String customerMnemonic) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;

		List<LinkedHashMap> resMap = null;

		try {
			if (!ValidationsUtil.isValidString(customerMnemonic)) {
				return null;
			}

			resMap = new ArrayList<LinkedHashMap>();

			String query = "SELECT REGEXP_REPLACE(TRIM(EMAIL), ',', ';') as email FROM SX20LF WHERE TRIM(SXCUS1) = '"
					+ customerMnemonic + "'";

			try {
				logger.debug(query);
				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					LinkedHashMap<String, String> lhm = new LinkedHashMap<String, String>();
					String mailid = res.getString("email").trim();

					lhm.put("email", mailid);
					resMap.add(lhm);
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.debug(resMap);
			logger.error(ex.getMessage(), ex);
		}
		return resMap;
	}

	/**
	 * 
	 * @param customerMnemonic
	 * @return
	 */
	public static String getCustomerMailToBranchFromCustomerId(String customerMnemonic) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;

		String result = "";

		try {
			if (!ValidationsUtil.isValidString(customerMnemonic)) {
				return null;
			}

			String query = "SELECT MAILTOBRANCH FROM GFPF WHERE GFCPNC = '" + customerMnemonic + "'";

			try {
				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					result = res.getString("MAILTOBRANCH").trim();
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return result;
	}

	/**
	 * Get customerid from masterreference
	 * 
	 * @param masterReference
	 *            {@code allows } {@link String}
	 * @return {@link String}
	 */
	public static String getCustomerIdFromMasterReference(String masterReference) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;

		String resMap = "";

		try {
			if (!ValidationsUtil.isValidString(masterReference)) {
				return null;
			}
			String query = "SELECT CASE WHEN TRIM(PRICUSTMNM) IS NOT NULL THEN TRIM(PRICUSTMNM) "
					+ " ELSE CASE WHEN TRIM(NPRCUSTMNM) IS NOT NULL THEN TRIM(NPRCUSTMNM) "
					+ " ELSE '1' END END AS CUSTMNM, MASTER_REF " + " FROM MASTER WHERE MASTER_REF = '"
					+ masterReference + "'";

			// if (masterReference.contains("ELC")
			// || masterReference.contains("EGT")) {
			// query =
			// "SELECT NPRCUSTMNM AS CUSTMNM FROM MASTER WHERE MASTER_REF = '"
			// + masterReference + "'";
			// } else {
			// query =
			// "SELECT PRICUSTMNM AS CUSTMNM FROM MASTER WHERE MASTER_REF = '"
			// + masterReference + "'";
			// }

			try {
				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					resMap = res.getString("CUSTMNM").trim();
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return resMap;
	}

	/**
	 * Get customerid from masterreference
	 * 
	 * @param boAccountNumber
	 *            {@code allows } {@link String}
	 * @return {@link String}
	 */
	public static String getCustomerIdFromBackOfficeAccountNumber(String boAccountNumber) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;

		String result = "";

		try {
			if (!ValidationsUtil.isValidString(boAccountNumber)) {
				return null;
			}

			String query = "SELECT CUS_MNM AS CUSTMNM FROM ACCOUNT WHERE BO_ACCTNO = '" + boAccountNumber + "'";

			try {
				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					result = res.getString("CUSTMNM").trim();
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
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
	public static String getCustomerIdFromMasterReferenceForReferralProcess(String masterReference) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;

		String result = null;

		try {
			if (!ValidationsUtil.isValidString(masterReference)) {
				return null;
			}

			String query = "select DISTINCT CUSTOMER AS CUSTID from ALLPARTIES_INTERFACE WHERE MASTERREFERENCE = '"
					+ masterReference + "'";

			try {
				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					if (ValidationsUtil.isValidString(res.getString("CUSTID")))
						result = res.getString("CUSTID").trim();
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return result;
	}

	/**
	 * Get inputbranch from masterreference
	 * 
	 * @param masterReference
	 *            {@code allows } {@link String}
	 * @return {@link String}
	 */
	public static String getInputBranchFromMasterReference(String masterReference) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;

		String result = "";

		try {
			if (!ValidationsUtil.isValidString(masterReference)) {
				return "";
			}
			String query = "SELECT BHALF_BRN AS BRANCH FROM MASTER WHERE MASTER_REF = '" + masterReference + "'";
			try {
				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					result = res.getString("BRANCH").trim();
				}

			} catch (SQLException e) {

			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}

		return result;
	}

	/**
	 * 
	 * @param masterReference
	 * @return
	 */
	public static String getNonCustomerIdFromMasterReference(String masterReference) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;

		String result = "";

		try {
			if (!ValidationsUtil.isValidString(masterReference)) {
				return null;
			}
			String query = "";

			if (masterReference.contains("ACILC")) {
				query = "SELECT NPRCUSTMNM AS CUSTMNM FROM MASTER WHERE MASTER_REF = '" + masterReference + "'";
			} else {
				query = "SELECT PRICUSTMNM AS CUSTMNM FROM MASTER WHERE MASTER_REF = '" + masterReference + "'";
			}
			try {
				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					result = res.getString("CUSTMNM").trim();
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return result;
	}

	/**
	 * Get Masterreference number from origreference number
	 * 
	 * @param originalReferrence
	 *            {@code allows } {@link String}
	 * @return {@link String}
	 */
	public static String getMasterReferrenceNumberFromOriginalReference(String originalReferrence) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		String result = "";
		try {
			if (!ValidationsUtil.isValidString(originalReferrence)) {
				return result;
			}

			String query = "SELECT MASTER_REF FROM MASTER WHERE ORIG_REF = '" + originalReferrence + "'";

			try {
				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					result = res.getString("MASTER_REF").trim();
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return result;
	}

	/**
	 * Get Masterreference number from Primaryreference number
	 * 
	 * @param primaryreference
	 *            {@code allows } {@link String}
	 * @return {@link String}
	 */
	public static String getMasterReferrenceNumberFromPrimaryReference(String primaryreference) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		String result = "";
		try {
			if (!ValidationsUtil.isValidString(primaryreference)) {
				return result;
			}

			String query = "SELECT MASTER_REF FROM MASTER WHERE PRI_REF = '" + primaryreference + "'";

			try {
				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					result = res.getString("MASTER_REF").trim();
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return result;
	}

	/**
	 * Get Masterreference number from bpmsreference number
	 * 
	 * @param bpmsReference
	 *            {@code allows } {@link String}
	 * @return {@link String}
	 */
	public static String getMasterReferrenceNumberFromBPMSReference(String bpmsReference) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		String result = "";
		try {
			if (!ValidationsUtil.isValidString(bpmsReference)) {
				return result;
			}

			String query = "Select trim(C.Master_ref) AS MASTER_REF from ExtEvent A, BaseEvent B, Master C Where A.Event = b.key97 And B.Master_Key = C.Key97 And trim(a.bpmsrefn) = '"
					+ bpmsReference + "' And Rownum = 1";

			try {
				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					result = res.getString("MASTER_REF").trim();
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}

		return result;
	}

	/**
	 * Get BPMSReference Number from MasterReference and EventReference
	 * 
	 * @param masterReference
	 *            {@code allows } {@link String}
	 * @param eventReference
	 *            {@code allows } {@link String}
	 * 
	 * @return {@link String}
	 */
	public static String getBPMSReferenceFromMasterReference(String masterReference, String eventReference) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;

		String result = "";
		try {
			if (!ValidationsUtil.isValidString(masterReference)) {
				return result;
			}

			String query = "Select " + "CASE WHEN trim(a.bpmsrefn) IS NOT NULL " + "THEN trim(a.bpmsrefn) "
					+ "ELSE trim(a.bpmsrfn1) END AS MASTER_REF " + "from ExtEvent A, BaseEvent B, Master C "
					+ "Where A.Event = b.key97 And " + "B.Master_Key = C.Key97 And " + "trim(C.Master_ref) = '"
					+ masterReference + "' And Rownum = 1";

			if (ValidationsUtil.isValidString(eventReference)) {
				query = "Select " + "CASE WHEN trim(c.bpmsrefn) IS NOT NULL " + "THEN trim(c.bpmsrefn) "
						+ "ELSE trim(c.bpmsrfn1) END AS MASTER_REF " + "from Master A, BaseEvent B, ExtEvent C "
						+ "Where A.Key97 = B.Master_Key And " + "B.Key97 = c.event And " + "A.Master_Ref = '"
						+ masterReference + "' And B.refno_pfix = '"
						+ ThemeBridgeUtil.getSubStringData(eventReference, 0, 3)
						+ "' And to_char(B.refno_pfix)||Case Length(B.RefNo_SERL) When 3 Then to_char(B.RefNo_SERL) When 2 Then '0'||to_char(B.RefNo_SERL) When 1 Then '00'||to_char(B.RefNo_SERL) End = '"
						+ eventReference + "'";
			}

			try {
				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					if (ValidationsUtil.isValidObject(res.getString("MASTER_REF"))
							&& ValidationsUtil.isValidString(res.getString("MASTER_REF").trim()))
						result = res.getString("MASTER_REF").trim();
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}

		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}

		logger.debug("BPMSReference Number in MasterLevel : " + result);
		return result;
	}

	/**
	 * Get BPMSReference number from MasterReference and EventReference in step
	 * level
	 * 
	 * @param masterReference
	 *            {@code allows } {@link String}
	 * @param eventReference
	 *            {@code allows } {@link String}
	 * 
	 * @return {@link String}
	 */
	public static String getBPMSReferenceFromReferenceInStepEvent(String masterReference, String eventReference) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		String result = "";
		try {
			String query = "Select trim(a.bpmsrefn) AS MASTER_REF from ExtEvent A, BaseEvent B, Master C Where A.Event = b.key97 And B.Master_Key = C.Key97 And trim(C.Master_ref) = '"
					+ masterReference + "' And Rownum = 1";

			if (ValidationsUtil.isValidString(eventReference)) {
				query = "SELECT DISTINCT(EXTST.BPMSREFR) AS MASTER_REF FROM MASTER MAS, BASEEVENT BEV, STEPHIST STP, EXTEVENT EXTEV, EXTEVSTEP EXTST "
						+ "WHERE " + "mas.key97 = bev.master_key AND " + "bev.key97 = extev.event AND "
						+ "extev.event = STP.EVENT_KEY AND " + "STP.eventstep = EXTST.EVENTSTEP AND "
						+ "(bev.refno_pfix||00||00||bev.refno_serl) = '" + eventReference + "' AND "
						+ "TRIM(mas.master_ref) = '" + masterReference + "'";
			}

			try {
				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					if (ValidationsUtil.isValidObject(res.getString("MASTER_REF"))
							&& ValidationsUtil.isValidString(res.getString("MASTER_REF").trim())) {
						result = res.getString("MASTER_REF").trim();
					}
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}

		logger.debug("BPMSReference Number in StepLevel : " + result);
		if (!ValidationsUtil.isValidString(result.trim())) {
			result = getBPMSReferenceFromMasterReference(masterReference, eventReference);
		} else {
			logger.debug("BPMSReference Number in MasterLevel : " + result);
		}

		return result;
	}

	/**
	 * Get the account list of customer
	 * 
	 * @param customerMnemonic
	 *            {@code allows } {@link String}
	 * @return {@link List}
	 */
	public static List getCustomerAccountList(String customerMnemonic) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		List<LinkedHashMap> resMap = null;
		try {
			if (!ValidationsUtil.isValidString(customerMnemonic)) {
				return null;
			}
			resMap = new ArrayList<LinkedHashMap>();
			String query = "SELECT ACCT_KEY, CUS_SBB, ACC_TYPE, CURRENCY, BO_ACCTNO, EXT_ACCTNO, COUNTRY, DESCR1, DESCR2 FROM ACCOUNT WHERE CUS_MNM = '"
					+ customerMnemonic + "'";

			try {
				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					LinkedHashMap<String, String> lhm = new LinkedHashMap<String, String>();
					lhm.put("ACCT_KEY", res.getString("ACCT_KEY").trim());
					lhm.put("CUS_SBB", res.getString("CUS_SBB").trim());
					lhm.put("ACC_TYPE", res.getString("ACC_TYPE").trim());
					lhm.put("CURRENCY", res.getString("CURRENCY").trim());
					lhm.put("BO_ACCTNO", res.getString("BO_ACCTNO").trim());
					lhm.put("EXT_ACCTNO", res.getString("EXT_ACCTNO").trim());
					lhm.put("COUNTRY", res.getString("COUNTRY").trim());
					lhm.put("DESCR1", res.getString("DESCR1").trim());
					lhm.put("DESCR2", res.getString("DESCR2").trim());
					resMap.add(lhm);
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return resMap;
	}

	/**
	 * Get the account list of customer with account type
	 * 
	 * @param customerMnemonic
	 *            {@code allows } {@link String}
	 * @param accountType
	 *            {@code allows } {@link String}
	 * @return {@link List}
	 */
	public static List getCustomerAccountListWithType(String customerMnemonic, String accountType) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		List<LinkedHashMap> resMap = null;
		try {
			if (!ValidationsUtil.isValidString(customerMnemonic)) {
				return null;
			}
			resMap = new ArrayList<LinkedHashMap>();
			String query = "SELECT ACCT_KEY, CUS_SBB, ACC_TYPE, CURRENCY, BO_ACCTNO, EXT_ACCTNO, COUNTRY, DESCR1, DESCR2 FROM ACCOUNT WHERE ACC_TYPE = '"
					+ accountType + "' AND CUS_MNM = '" + customerMnemonic + "'";

			try {
				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					LinkedHashMap<String, String> lhm = new LinkedHashMap<String, String>();
					lhm.put("ACCT_KEY", res.getString("ACCT_KEY").trim());
					lhm.put("CUS_SBB", res.getString("CUS_SBB").trim());
					lhm.put("ACC_TYPE", res.getString("ACC_TYPE").trim());
					lhm.put("CURRENCY", res.getString("CURRENCY").trim());
					lhm.put("BO_ACCTNO", res.getString("BO_ACCTNO").trim());
					lhm.put("EXT_ACCTNO", res.getString("EXT_ACCTNO").trim());
					lhm.put("COUNTRY", res.getString("COUNTRY").trim());
					lhm.put("DESCR1", res.getString("DESCR1").trim());
					lhm.put("DESCR2", res.getString("DESCR2").trim());
					resMap.add(lhm);
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return resMap;
	}

	/**
	 * Get the account details
	 * 
	 * @param accountNumber
	 *            {@code allows } {@link String}
	 * @return {@link List}
	 */
	public static List getAccountDetailsList(String accountNumber) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;

		List<LinkedHashMap> resMap = null;

		try {
			if (!ValidationsUtil.isValidString(accountNumber)) {
				return null;
			}

			resMap = new ArrayList<LinkedHashMap>();

			String query = "SELECT ACCT_KEY, CUS_SBB, ACC_TYPE, CURRENCY, BO_ACCTNO, EXT_ACCTNO, COUNTRY, DESCR1, DESCR2 FROM ACCOUNT WHERE BO_ACCTNO = '"
					+ accountNumber + "'";

			try {
				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				logger.debug("Query : " + query);
				while (res.next()) {
					LinkedHashMap<String, String> lhm = new LinkedHashMap<String, String>();
					lhm.put("ACCT_KEY", res.getString("ACCT_KEY").trim());
					lhm.put("CUS_SBB", res.getString("CUS_SBB").trim());
					lhm.put("ACC_TYPE", res.getString("ACC_TYPE").trim());
					lhm.put("CURRENCY", res.getString("CURRENCY").trim());
					lhm.put("BO_ACCTNO", res.getString("BO_ACCTNO").trim());
					lhm.put("EXT_ACCTNO", res.getString("EXT_ACCTNO").trim());
					lhm.put("COUNTRY", res.getString("COUNTRY").trim());
					lhm.put("DESCR1", res.getString("DESCR1").trim());
					lhm.put("DESCR2", res.getString("DESCR2").trim());
					resMap.add(lhm);
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return resMap;
	}

	/**
	 * 
	 * @param accountOfficerCode
	 * @return
	 */
	public static List getAccountOfficerDetailsList(String accountOfficerCode) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;

		List<LinkedHashMap> resMap = null;

		try {
			if (!ValidationsUtil.isValidString(accountOfficerCode)) {
				return null;
			}

			resMap = new ArrayList<LinkedHashMap>();

			String query = "SELECT AO_NAFF, CODE, DESCR FROM OFFICER WHERE CODE = '" + accountOfficerCode + "'";

			try {
				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					LinkedHashMap<String, String> lhm = new LinkedHashMap<String, String>();
					lhm.put("ACF_NAME", res.getString("AO_NAFF").trim());
					lhm.put("ACF_CODE", res.getString("CODE").trim());
					lhm.put("ACF_DESC", res.getString("DESCR").trim());
					resMap.add(lhm);
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return resMap;
	}

	/**
	 * 
	 * @param currencyCode
	 * @return
	 */
	public static List getMidRateOfCurrency(String currencyCode) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;

		List<LinkedHashMap> resMap = null;

		try {
			if (!ValidationsUtil.isValidString(currencyCode)) {
				return null;
			}

			resMap = new ArrayList<LinkedHashMap>();

			String query = "SELECT SPOTRATE FROM SPOTRATE WHERE BRANCH = 'FGB' AND CURRENCY = '" + currencyCode + "'";

			try {
				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					LinkedHashMap<String, String> lhm = new LinkedHashMap<String, String>();
					lhm.put("SPOTRATE", res.getString("SPOTRATE").trim());
					resMap.add(lhm);
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return resMap;
	}

	/**
	 * 
	 * @param masterReference
	 * @return
	 */
	public static String getEventValueFromMasterReference(String masterReference) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		String result = null;
		try {
			if (!ValidationsUtil.isValidString(masterReference)) {
				return null;
			}

			String query = "SELECT A.MASTER_REF, B.EV_INDEX, B.REFNO_PFIX AS EVENT_REF, B.REFNO_SERL FROM "
					+ "MASTER A, BASEEVENT B WHERE " + "A.KEY97 = B.MASTER_KEY AND " + "EV_INDEX IS NOT NULL AND "
					+ "MASTER_REF = '" + masterReference + "' ORDER BY EV_INDEX DESC";

			try {
				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					result = res.getString("EVENT_REF").trim();
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * Get the document content value from dmsId
	 * 
	 * @param dmsId
	 *            reference id of the document coming from TI
	 * @return a byte array value getting from TI Database
	 */
	public static byte[] getDocumentFromDb(String dmsId) {
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		Blob blob = null;
		byte[] blobAsBytes = null;
		try {
			connection = DatabaseUtility.getTizoneConnection();
			statement = connection.createStatement();
			String sql = "select item from CMS_ITEM where item_id = '" + dmsId + "'";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				blob = resultSet.getBlob("item");
			}
			logger.debug("Blob from DB:" + blob);
			int blobLength = (int) blob.length();
			blobAsBytes = blob.getBytes(1, blobLength);
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				logger.error(e1.getMessage(), e1);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			DatabaseUtility.surrenderConnection(connection, statement, resultSet);
		}
		return blobAsBytes;
	}

	/**
	 * Get TheirReference number from MasterReference
	 * 
	 * @param masterReference
	 * @return {@link String}
	 */
	public static String getTheirReferenceFromMasterReference(String masterReference) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		String result = "";
		try {
			if (!ValidationsUtil.isValidString(masterReference)) {
				return result;
			}

			String query = "SELECT PRI_REF FROM MASTER WHERE MASTER_REF = '" + masterReference + "'";

			try {
				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					result = res.getString("PRI_REF").trim();
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return result;
	}

	/**
	 * Get LimitReference/FacilityId number from MasterReference
	 * 
	 * @param masterReference
	 * @return {@link String}
	 */
	public static String getLimitReferenceFromMasterReference(String masterReference) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		String result = "";
		try {
			if (!ValidationsUtil.isValidString(masterReference)) {
				return result;
			}
			String query = "select a.master_ref, b.FACILTYID  FROM MASTER A, ECMSTATUS b WHERE a.key97 = b.master_key AND b.master_key = '"
					+ masterReference + "'";

			try {
				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					result = res.getString("FACILTYID").trim();
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return result;
	}

	/**
	 * Get LimitReference/FacilityId number from MasterReference
	 * 
	 * @param masterReference
	 * @return {@link LinkedHashMap}
	 */
	public static LinkedHashMap getOutstaningLimitAmountFromMasterReference(String masterReference) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		LinkedHashMap result = new LinkedHashMap();
		try {
			if (!ValidationsUtil.isValidString(masterReference)) {
				return result;
			}
			String queryLocation = "";
			File folder = new File("");
			String absolutePath = folder.getAbsolutePath();

			try {

				absolutePath = absolutePath + ConfigurationUtil.getValueFromKey("AllTBInternalQuery");
			} catch (Exception e) {
				// TODO: handle exception
				absolutePath = absolutePath + "\\Themebridge\\InternalQuery\\";
			}

			queryLocation = absolutePath;
			logger.info("\nqueryLocation:>" + absolutePath);

			// String query =
			// "select mas.refno_pfix Productcode, MAS.CCY Currency,
			// mas.amount/POWER(10,CUR.C8CED) LCamount,
			// MAS.LIAB_AMT/POWER(10,CUR.C8CED) OutstandingLiability,
			// MAS.MASTER_REF from master mas, c8pf cur where mas.ccy= cur.c8ccy
			// AND mas.master_ref = '"
			// + masterReference + "' order by mas.master_ref";

			String query = ThemeBridgeUtil.readFile(queryLocation + "osamt_qry.sql");

			query = ThemeBridgeUtil.replaceTokenByValue(query, "{referenceNumber}", masterReference);

			Double amount = 0.00;
			try {
				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					if (ValidationsUtil.isValidString(res.getString("OutstandingLiability"))) {
						amount = Double.parseDouble(res.getString("OutstandingLiability").trim());
					}

					if (ValidationsUtil.isValidString(res.getString("Currency"))) {
						result.put("OSD_CCY", res.getString("Currency").trim());
					}
				}

				result.put("OSD_AMT", amount);
			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return result;
	}

	/**
	 * Get Limit breach comments from MasterReference
	 * 
	 * @param masterReference
	 * @return {@link String}
	 */
	public static String getLimitBreachCommentsFromMasterReference(String masterReference) {
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
				con = DatabaseUtility.getTizoneConnection();
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
			logger.error(ex.getMessage(), ex);
		}
		return result.toString();
	}

	/**
	 * Get Limit breach comments from MasterReference
	 * 
	 * @param masterReference
	 * @return {@link String}
	 */
	public static String getLimitBreachCommentsFromMasterReference(String masterReference, String eventReference) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		StringBuffer result = new StringBuffer("");
		try {
			if (!ValidationsUtil.isValidString(masterReference)) {
				return result.toString();
			}

			String query = "select a.master_ref as Masterreference, C.NOTE_TEXT as notes, c.active, c.emphasis, d.descri56 as notetype, b.refno_pfix||00||00||b.refno_serl relatedevent from master a, baseevent b, Note c, notety24 d where a.key97 = b.master_key and b.key97 = c.note_event and c.type = d.mykey95 and a.master_ref = '"
					+ masterReference + "'";

			try {
				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					String relatedevent = res.getString("relatedevent").trim();
					if (eventReference.equalsIgnoreCase(relatedevent)) {
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
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return result.toString();
	}

	/**
	 * Get MasterReference number from SubsidiaryMasterReference
	 * 
	 * @param subsidiaryMasterReference
	 * @return {@link String}
	 */
	public static String getMasterReferenceBySubsidiaryMasterReference(String subsidiaryMasterReference) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		String result = "";
		String queryLocation = "";

		try {
			if (!ValidationsUtil.isValidString(subsidiaryMasterReference)) {
				return result.toString();
			}

			File folder = new File("");
			String absolutePath = folder.getAbsolutePath();

			try {

				absolutePath = absolutePath + ConfigurationUtil.getValueFromKey("AllTBInternalQuery");
			} catch (Exception e) {
				// TODO: handle exception
				absolutePath = absolutePath + "\\Themebridge\\InternalQuery\\";
			}

			queryLocation = absolutePath;
			logger.info("\nqueryLocation:>" + absolutePath);

			String query = ThemeBridgeUtil.readFile(queryLocation + "mref_by_subref.sql");
			try {

				query = ThemeBridgeUtil.replaceTokenByValue(query, "{referenceNumber}", subsidiaryMasterReference);

				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					if (ValidationsUtil.isValidObject(res.getString("MASTERREF"))
							&& ValidationsUtil.isValidString(res.getString("MASTERREF").trim())) {
						result = res.getString("MASTERREF").trim();
					}
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return result;
	}

	/**
	 * Check whether it is subsidiary event
	 * 
	 * @param subsidiaryMasterReference
	 * @return {@link boolean}
	 */
	public static boolean isSubsidiaryEvent(String subsidiaryMasterReference) {

		boolean result = false;
		String queryLocation = "";

		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;

		try {
			if (!ValidationsUtil.isValidString(subsidiaryMasterReference)) {
				return result;
			}

			File folder = new File("");
			String absolutePath = folder.getAbsolutePath();

			try {

				absolutePath = absolutePath + ConfigurationUtil.getValueFromKey("AllTBInternalQuery");
			} catch (Exception e) {
				// TODO: handle exception
				absolutePath = absolutePath + "\\Themebridge\\InternalQuery\\";
			}

			queryLocation = absolutePath;
			logger.info("\nqueryLocation:>" + absolutePath);

			String query = ThemeBridgeUtil.readFile(queryLocation + "is_subevnt.sql");
			try {
				query = ThemeBridgeUtil.replaceTokenByValue(query, "{referenceNumber}", subsidiaryMasterReference);
				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					if (ValidationsUtil.isValidObject(res.getString("MASTERREF"))
							&& ValidationsUtil.isValidString(res.getString("MASTERREF").trim())) {
						result = true;
					}
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return result;
	}

	/**
	 * Get Accounttype from Debt Account Mnemonic value
	 * 
	 * @param spskMnemonic
	 * @return {@link String}
	 */
	public static String getAccountTypeFromDebitChargeAccount(String spskMnemonic) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		String result = "";
		try {
			if (!ValidationsUtil.isValidString(spskMnemonic)) {
				return result.toString();
			}

			String query = "select DHATP AS acctype from DHPF WHERE DHANMD = '" + spskMnemonic + "'";

			try {
				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					result = res.getString("acctype").trim();
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return result;
	}

	/**
	 * Get current date of TIPlus system
	 * 
	 * @return {@link String}
	 */
	public static String getCurrentDateofTISystem() {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		String result = "";
		try {
			String query = "select TO_CHAR(procdate,'dd-MM-yyyy') as currentdate from dlyprccycl";
			try {
				con = DatabaseUtility.getTizoneConnection();
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
			logger.error(ex.getMessage(), ex);
		}
		return result;
	}

	/**
	 * Get previous date of TIPlus system
	 * 
	 * @return {@link String}
	 */
	public static String getPreviousDateofTISystem() {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		String result = "";
		try {
			String query = "select TO_CHAR(procdate - 1,'dd-MM-yyyy') as currentdate from dlyprccycl";
			try {
				con = DatabaseUtility.getTizoneConnection();
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
			logger.error(ex.getMessage(), ex);
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
	public static String getCustomerIdFromMasterReferenceForReferral(String masterReference, String productId) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		String result = "";
		String queryLocation = "";

		try {
			if (!ValidationsUtil.isValidString(masterReference) || !ValidationsUtil.isValidString(productId)) {
				return null;
			}

			String query = "";

			logger.info("productId:>" + productId);

			ClassLoader classLoader = CustomisationQueryUtil.class.getClassLoader();
			File classpathRoot = new File(classLoader.getResource("").getPath());

			String absolutePath = classpathRoot.getPath() + "\\internalQuery";

			queryLocation = absolutePath;
			logger.info("\n:>" + absolutePath);

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
			} else if (productId.equalsIgnoreCase("CPC")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "cpc_pty.sql");
			} else if (productId.equalsIgnoreCase("ICP")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "icp_pty.sql");
			} else if (productId.equalsIgnoreCase("FEL")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "fel_pty.sql");
			} else if (productId.equalsIgnoreCase("FIL")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "fil_pty.sql");
			} else if (productId.equalsIgnoreCase("FOC")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "foc_pty.sql");
			} else if (productId.equalsIgnoreCase("FRN")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "frn_pty.sql");
			} else if (productId.equalsIgnoreCase("TRF")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "trf_pty.sql");
			} else if (productId.equalsIgnoreCase("CPB")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "cpb_pty.sql");
			} else if (productId.equalsIgnoreCase("IRF")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "irf_pty.sql");
			} else if (productId.equalsIgnoreCase("POD")) {
				query = ThemeBridgeUtil.readFile(queryLocation + "pod_pty.sql");

			} else {
				query = "SELECT CASE WHEN TRIM(PRICUSTMNM) IS NOT NULL THEN TRIM(PRICUSTMNM) ELSE CASE WHEN TRIM(NPRCUSTMNM) IS NOT NULL THEN TRIM(NPRCUSTMNM) ELSE '1' END END AS CUSTOMERID, MASTER_REF FROM MASTER WHERE MASTER_REF = '{referenceNumber}'";
			}

			// SELECT CASE WHEN TRIM(PRICUSTMNM) IS NOT NULL THEN
			// TRIM(PRICUSTMNM) ELSE CASE WHEN TRIM(NPRCUSTMNM) IS NOT NULL THEN
			// TRIM(NPRCUSTMNM) ELSE '1' END END AS customerid FROM MASTER WHERE
			// MASTER_REF = '{referenceNumber}'
			// --
			// SELECT CASE WHEN TRIM(NPRCUSTMNM) IS NOT NULL THEN
			// TRIM(NPRCUSTMNM) ELSE CASE WHEN TRIM(PRICUSTMNM) IS NOT NULL THEN
			// TRIM(PRICUSTMNM) ELSE '1' END END AS customerid FROM MASTER WHERE
			// MASTER_REF = '{referenceNumber}'

			query = ThemeBridgeUtil.replaceTokenByValue(query, "{referenceNumber}", masterReference);

			logger.info("----------> InitiateReferral CustomerId query :\n " + query);
			try {

				con = DatabaseUtility.getTizoneConnection();

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
			logger.error(ex.getMessage(), ex);
		}
		return result;
	}

	/**
	 * Get sub-product type from masterreference
	 * 
	 * @param masterReference
	 *            {@code allows } {@link String}
	 * 
	 * @return {@link String}
	 */
	public static String getProductSubTypeFromMaster(String masterReference) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		String result = "";
		try {
			String query = "SELECT p.code AS code FROM MASTER m, PRODTYPE p WHERE p.key97 = m.prodtype AND m.master_ref = '"
					+ masterReference + "'";
			try {
				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					if (ValidationsUtil.isValidString(res.getString("code").trim())) {
						result = res.getString("code").trim();
					}
				}

			} catch (SQLException e) {
				logger.error("Exception! " + e.getMessage());
				e.printStackTrace();
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return result;
	}

	/**
	 * Get MasterReference by Internal RecnReference
	 * <p>
	 * {@code This method is used in Posting services }
	 * </p>
	 * 
	 * @param intrRecnReference
	 *            {@code allows } {@link String}
	 * 
	 * @return {@link String}
	 */
	public static String getMasterReferenceByPostingInternalRecnReference(String intrRecnReference) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;

		String queryLocation = "";

		String result = "";
		try {

			File folder = new File("");
			String absolutePath = folder.getAbsolutePath();

			try {

				absolutePath = absolutePath + ConfigurationUtil.getValueFromKey("AllTBInternalQuery");
			} catch (Exception e) {
				// TODO: handle exception
				absolutePath = absolutePath + "\\Themebridge\\InternalQuery\\";
			}

			queryLocation = absolutePath;
			logger.info("\nqueryLocation:>" + absolutePath);

			String query = ThemeBridgeUtil.readFile(queryLocation + "mref_post_qry.sql");

			query = ThemeBridgeUtil.replaceTokenByValue(query, "{referenceNumber}", intrRecnReference);
			try {
				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					if (ValidationsUtil.isValidString(res.getString("MREF").trim())) {
						result = res.getString("MREF").trim();
					}
				}
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return result;
	}

	/**
	 * Get MasterReference and ProductCode by Internal RecnReference
	 * <p>
	 * {@code This method is used in Posting services }
	 * </p>
	 * 
	 * @param intrRecnReference
	 *            {@code allows } {@link String}
	 * 
	 * @return {@link LinkedHashMap}
	 */
	public static LinkedHashMap getMasterReferenceProductCodeByPostingInternalRecnReference(String intrRecnReference) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		LinkedHashMap result = new LinkedHashMap();
		try {
			String queryLocation = "";
			File folder = new File("");
			String absolutePath = folder.getAbsolutePath();

			try {

				absolutePath = absolutePath + ConfigurationUtil.getValueFromKey("AllTBInternalQuery");
			} catch (Exception e) {
				// TODO: handle exception
				absolutePath = absolutePath + "\\Themebridge\\InternalQuery\\";
			}

			queryLocation = absolutePath;
			logger.info("\nqueryLocation:>" + absolutePath);

			String query = ThemeBridgeUtil.readFile(queryLocation + "mref_post_qry.sql");

			query = ThemeBridgeUtil.replaceTokenByValue(query, "{referenceNumber}", intrRecnReference);
			try {
				con = DatabaseUtility.getTizoneConnection();
				stmt = con.createStatement();
				res = stmt.executeQuery(query);
				while (res.next()) {
					if (ValidationsUtil.isValidString(res.getString("MREF").trim())) {
						result.put("Reference", res.getString("MREF").trim());
					}
					if (ValidationsUtil.isValidString(res.getString("PRODUCT").trim())) {
						result.put("Product", res.getString("PRODUCT").trim());
					}
					if (ValidationsUtil.isValidString(res.getString("EREF").trim())) {
						result.put("Event", res.getString("EREF").trim());
					}
				}
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
			} finally {
				DatabaseUtility.surrenderConnection(con, stmt, res);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return result;
	}

	/*
	 * 
	 */
	public static void main(String[] args) throws Exception {

		ClassLoader classLoader = CustomisationQueryUtil.class.getClassLoader();
		File classpathRoot = new File(classLoader.getResource("").getPath());

		// absolutePath = absolutePath + "\\Themebridge\\InternalQuery\\";

		logger.debug(classpathRoot.getPath() + "\\internalQuery");

	}
}
