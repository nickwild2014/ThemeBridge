package com.bs.themebridge.entity.servlet.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bs.themebridge.entity.model.Servicelog;
import com.bs.themebridge.util.DatabaseUtility;

/**
 * @author BSIT-THEMEBRIDGE(RaviPrasath)
 * @see Get Transaction Gateway document details
 */
public class TransactionDetailsProcessor {

	private static final Logger logger = Logger.getLogger(TransactionDetailsProcessor.class);

	public static void main(String[] args) {

		TransactionDetailsProcessor obj = new TransactionDetailsProcessor();
		List<Servicelog> g = obj.getTransactionStatus("0958ILD170200520", "ISS001");
		// logger.debug(g.size());

		// List<Servicelog> scf = obj.getTransactionStatus("2596");
		// logger.debug(scf.size());
	}

	/**
	 * LIVE Method
	 * 
	 * @param masterRef
	 *            {@code allows }{@link String}
	 * @param eventRef
	 *            {@code allows }{@link String}
	 * @return {@code allows List<Servicelog> }{@link List}
	 */
	public List<Servicelog> getTransactionStatus(String masterRef, String eventRef) {

		// logger.debug("Service Log Regarding MasterReference Started");
		List<Servicelog> resultList = new ArrayList<Servicelog>();
		String transactionStatus = "SELECT * FROM BS_TRANSACTION_STATUS_ALL_VIEW WHERE MASTERREFERENCE = '" + masterRef
				+ "'  AND EVENTREFERENCE = '" + eventRef + "'";
		logger.debug("Transaction ststus Query: " + transactionStatus);

		ResultSet rs = null;
		Connection aConnection = null;
		PreparedStatement aStatement = null;
		try {
			aConnection = DatabaseUtility.getThemebridgeConnection();
			aStatement = aConnection.prepareStatement(transactionStatus);
			rs = aStatement.executeQuery();
			while (rs.next()) {
				Servicelog aServicelogModel = new Servicelog();
				aServicelogModel.setId(rs.getBigDecimal("ID"));
				aServicelogModel.setSourcesystem(rs.getString("SOURCE"));
				aServicelogModel.setService(rs.getString("SERVICE"));
				aServicelogModel.setOperation(rs.getString("OPERATION"));
				aServicelogModel.setZone(rs.getString("ZONE"));
				aServicelogModel.setMasterreference(rs.getString("MASTERREFERENCE"));
				aServicelogModel.setEventreference(rs.getString("EVENTREFERENCE"));
				aServicelogModel.setProcesstime(rs.getTimestamp("PROCESSTIME"));
				aServicelogModel.setStatus(rs.getString("STATUS"));
				resultList.add(aServicelogModel);
			}
		} catch (SQLException e) {
			logger.error("SQL exception ! " + e.getMessage());
			e.printStackTrace();

		} catch (Exception e) {
			logger.error("Exception ! " + e.getMessage());
			e.printStackTrace();

		} finally {
			DatabaseUtility.surrenderConnection(aConnection, aStatement, rs);
		}

		logger.debug(resultList);
		return resultList;
	}

	/**
	 * 
	 * @param masterRef
	 *            {@code allows }{@link String}
	 * @return {@code allows List<Servicelog> }{@link List}
	 */
	public List<Servicelog> getTransactionStatus(String batchId) {

		// logger.debug("Service Log Regarding MasterReference Started");
		List<Servicelog> resultList = new ArrayList<Servicelog>();
		String transactionStatus = "SELECT * FROM BS_TRANSACTION_STATUS_FSA_VIEW WHERE MASTERREFERENCE = '" + batchId
				+ "'";
		logger.debug("Transaction ststus Query: " + transactionStatus);
		ResultSet rs = null;
		Connection aConnection = null;
		PreparedStatement aStatement = null;
		try {
			aConnection = DatabaseUtility.getThemebridgeConnection();
			aStatement = aConnection.prepareStatement(transactionStatus);
			rs = aStatement.executeQuery();
			while (rs.next()) {
				Servicelog aServicelogModel = new Servicelog();
				aServicelogModel.setService(rs.getString("SERVICE"));
				aServicelogModel.setOperation(rs.getString("OPERATION"));
				aServicelogModel.setZone(rs.getString("ZONE"));
				aServicelogModel.setMasterreference(rs.getString("MASTERREFERENCE"));
				aServicelogModel.setEventreference(rs.getString("EVENTREFERENCE"));
				aServicelogModel.setProcesstime(rs.getTimestamp("PROCESSTIME"));
				aServicelogModel.setStatus(rs.getString("STATUS"));
				resultList.add(aServicelogModel);
			}
		} catch (SQLException e) {
			logger.error("SQL exception ! " + e.getMessage());
			e.printStackTrace();

		} catch (Exception e) {
			logger.error("Exception ! " + e.getMessage());
			e.printStackTrace();

		} finally {
			DatabaseUtility.surrenderConnection(aConnection, aStatement, rs);
		}
		return resultList;
	}

}
