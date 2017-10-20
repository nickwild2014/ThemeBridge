package com.test;

import java.io.UnsupportedEncodingException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bs.theme.bob.adapter.adaptee.SWIFTSwiftInAdaptee;
import com.bs.themebridge.util.DatabaseUtility;

public class ProcedureCall {

	private final static Logger logger = Logger.getLogger(SWIFTSwiftInAdaptee.class);

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub

		String requestXML = "&";
		requestXML = requestXML.replace("", "");
		String inputXML = new String(requestXML.getBytes(), "UTF-8");
		logger.debug(inputXML);

		// getUtrNoFromPaymentHubDb();
	}

	/**
	 * 
	 * @param paymentType
	 * @return
	 */
	public static String getUtrNoFromPaymentHubDb() {

		String utrNumber = "";
		Connection con = null;
		CallableStatement callableStmt = null;
		logger.debug("TEST");
		try {
			// getting connection
			con = DatabaseUtility.getThemebridgeConnection();
			logger.debug("TEST");

			// Call Oracle Database Function
			callableStmt = con.prepareCall("{call insertsplchar(?, ?)}");
			logger.debug("TEST");

			callableStmt.setString(1, "2");
			callableStmt.setString(2, "L &amp; T");
			logger.debug("TEST");

			// Execute database Function
			callableStmt.executeUpdate();
			logger.debug("TEST22");

		} catch (SQLException sqlexc) {
			logger.debug(sqlexc.getMessage());
			sqlexc.printStackTrace();

		} finally {

			try {
				if (callableStmt != null)
					callableStmt.close(); // close CallableStatement
				if (con != null)
					con.close(); // close connection

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		logger.debug("Payment Hub UTR No : >>>" + utrNumber + "<<<");
		return utrNumber;
	}

	// CREATE TABLE DBUSER2 (
	// USER_ID VARCHAR2 (5) ,
	// USERNAME VARCHAR2 (20)
	// -- CREATED_BY VARCHAR2 (20) NOT NULL,
	// -- CREATED_DATE DATE NOT NULL,
	// -- PRIMARY KEY ( USER_ID )
	// );
	// select * from DBUSER2;
	//
	//
	// CREATE OR REPLACE PROCEDURE insertsplchar(
	// p_userid IN DBUSER.USER_ID%TYPE,
	// p_username IN DBUSER.USERNAME%TYPE
	// -- p_createdby IN DBUSER.CREATED_BY%TYPE
	// -- p_date IN DBUSER.CREATED_DATE%TYPE
	// )
	// IS
	// BEGIN
	//
	// INSERT INTO DBUSER2 ("USER_ID", "USERNAME")
	// VALUES (p_userid, p_username);
	//
	// COMMIT;
	//
	// END;
	// /
	//
	// select * from DBUSER2;
	// -- TRUNCATE table DBUSER2;
	// -- commit;
	//
	// BEGIN
	// insertsplchar('1001','mkyong');
	// END;
}
