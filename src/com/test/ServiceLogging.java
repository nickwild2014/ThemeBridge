package com.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;

import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.sql.PreparedStatement;

import com.bs.theme.bob.adapter.adaptee.SWIFTSwiftInAdaptee;
import com.bs.themebridge.util.DatabaseUtility;

/**
 * 
 * @since 2017-03-22
 * @version v1.0.1
 * @author Prasath Ravichandran, System analyst, Bluescope.
 *
 */
public class ServiceLogging {

	private final static Logger logger = Logger.getLogger(SWIFTSwiftInAdaptee.class);

	public static void main(String[] args) {

		getBridgePropertyValue("RODDWLD");

		// themebridgeLogging("Service", "Operation", "Zone1", "0958", "Source",
		// "Target", "Master", "Event", "Status",
		// "tireq", "tires", "bankreq", "bankres", "narrative1", "narrative2",
		// "errordescription");
	}

	/**
	 * @since 2017-03-22
	 * @version v1.0.1
	 * @author Prasath Ravichandran
	 * 
	 * @param service
	 *            {@code allows }{@link String}
	 * @param operation
	 *            {@code allows }{@link String}
	 * @param zone
	 *            {@code allows }{@link String}
	 * @param branch
	 *            {@code allows }{@link String}
	 * @param sourcesystem
	 *            {@code allows }{@link String}
	 * @param targetsystem
	 *            {@code allows }{@link String}
	 * @param masterreference
	 *            {@code allows }{@link String}
	 * @param eventreference
	 *            {@code allows }{@link String}
	 * @param status
	 *            {@code allows }{@link String}
	 * @param tirequest
	 *            {@code allows }{@link String}
	 * @param tiresponse
	 *            {@code allows }{@link String}
	 * @param bankrequest
	 *            {@code allows }{@link String}
	 * @param bankresponse
	 *            {@code allows }{@link String}
	 * @param narrative1
	 *            {@code allows }{@link String}
	 * @param narrative2
	 *            {@code allows }{@link String}
	 * @param description
	 *            {@code allows }{@link String}
	 * @return
	 */
	public static boolean themebridgeLogging(String service, String operation, String zone, String branch,
			String sourcesystem, String targetsystem, String masterreference, String eventreference, String status,
			String tirequest, String tiresponse, String bankrequest, String bankresponse, String narrative1,
			String narrative2, String description) {

		logger.debug("Entering into the Servicelogging...! ");
		boolean result = true;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DatabaseUtility.getThemebridgeConnection();
			if (con != null) {
				// INSERT INTO "THEMEBRIDGE"."SERVICELOG" (ID, SERVICE,
				// OPERATION, ZONE, BRANCH, SOURCESYSTEM, TARGETSYSTEM,
				// MASTERREFERENCE, EVENTREFERENCE, STATUS, PROCESSTIME,
				// TIREQUEST, TIRESPONSE, BANKREQUEST, BANKRESPONSE, TIREQTIME,
				// BANKREQTIME, BANKRESTIME, TIRESTIME, TRANSACTIONKEY1,
				// STATICKEY1, NARRATIVE1, NARRATIVE2, ISRESUBMITTED,
				// RESUBMITTEDCOUNT, RESUBMITTEDTIME, DESCRIPTION, TYPEFLAG)
				// VALUES (servicelog_seq.nextval, 'TIEODJOB', 'RODDWLD',
				// 'ZONE1', null, 'ZONE1', 'BOB', 'Localization', 'RBIReport',
				// 'SUCCEEDED', null, null, null, null, null, null, null, null,
				// null, null, null, null, null, null, '0', null, null, null)

				String loggiingQuery = "INSERT INTO SERVICELOG (ID, SERVICE, OPERATION, ZONE, BRANCH, SOURCESYSTEM, TARGETSYSTEM, MASTERREFERENCE, EVENTREFERENCE, "
						+ " STATUS, PROCESSTIME, TIREQUEST, TIRESPONSE, BANKREQUEST, BANKRESPONSE, TIREQTIME, BANKREQTIME, BANKRESTIME, TIRESTIME,"
						+ " TRANSACTIONKEY1, STATICKEY1, NARRATIVE1, NARRATIVE2, DESCRIPTION, TYPEFLAG) "
						+ " VALUES (servicelog_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

				ps = con.prepareStatement(loggiingQuery);
				ps.setString(1, service);
				ps.setString(2, operation);
				ps.setString(3, zone);
				ps.setString(4, branch);
				ps.setString(5, sourcesystem);
				ps.setString(6, targetsystem);
				ps.setString(7, masterreference);
				ps.setString(8, eventreference);
				ps.setString(9, status);
				ps.setTimestamp(10, GetCurrentTimeStamp());
				ps.setString(11, tirequest);
				ps.setString(12, tiresponse);
				ps.setString(13, bankrequest);
				ps.setString(14, bankresponse);
				ps.setTimestamp(15, null);
				ps.setTimestamp(16, null);
				ps.setTimestamp(17, null);
				ps.setTimestamp(18, null);
				ps.setString(19, null);
				ps.setString(20, null);
				ps.setString(21, narrative1);
				ps.setString(22, narrative2);
				ps.setString(23, description);
				ps.setString(24, null);

				int insertedRows = ps.executeUpdate();
				logger.debug(insertedRows + " Row inserted successfully!!! ");

			}

		} catch (Exception ex) {
			logger.debug("Exception is :" + ex.getMessage());
			ex.printStackTrace();
			result = false;

		} finally {
			DatabaseUtility.surrenderPrepdConnection(con, ps, null);
		}

		return result;
	}

	/**
	 * @since 2017-03-22
	 * @version v1.0.1
	 * @author Prasath Ravichandran
	 * 
	 * @param key
	 *            {@code allows }{@link String}
	 * @return
	 */
	public static String getBridgePropertyValue(String key) {

		logger.debug("Entering into the Servicelogging...! ");
		String value = "";
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			con = DatabaseUtility.getThemebridgeConnection();
			if (con != null) {

				String loggiingQuery = "SELECT ID, ZONE, BRANCH, KEY, VALUE, CATEGORY FROM BRIDGEPROPERTIES WHERE KEY = ? ";
				ps = con.prepareStatement(loggiingQuery);
				ps.setString(1, key);
				rs = ps.executeQuery();
				while (rs.next()) {
					value = rs.getString("VALUE");
				}
				logger.debug("KEY : VALUE >>> " + key + " : " + value);

			}
		} catch (Exception ex) {
			logger.debug("Exception is :" + ex.getMessage());
			ex.printStackTrace();

		} finally {
			DatabaseUtility.surrenderPrepdConnection(con, ps, null);
		}

		return value;
	}

	public static void surrenderPrepdConnection(Connection aConnection, PreparedStatement aPreparedStatement,
			ResultSet aResultset) {

		try {
			if (isValidObject(aConnection)) {
				aConnection.close();
			}
		} catch (SQLException e) {
			logger.debug("Close Connection Failed!" + e.getMessage());
		}
		try {
			if (isValidObject(aPreparedStatement))
				aPreparedStatement.close();
		} catch (SQLException e) {
			logger.debug("Close PreparedStatement Failed!" + e.getMessage());
		}
		try {
			if (isValidObject(aResultset))
				aResultset.close();
		} catch (SQLException e) {
			logger.debug("Close Resultset Failed!" + e.getMessage());
		}
	}

	public static Timestamp GetCurrentTimeStamp() {
		java.util.Date date = new java.util.Date();
		Timestamp ts = new Timestamp(date.getTime());
		return ts;
	}

	/**
	 * Checks the given object is valid
	 * 
	 * @param object
	 *            {@code allows any }{@link Object}
	 * @return {@link Boolean}
	 */
	public static boolean isValidObject(Object object) {
		if (object == null)
			return false;

		return true;
	}

}
