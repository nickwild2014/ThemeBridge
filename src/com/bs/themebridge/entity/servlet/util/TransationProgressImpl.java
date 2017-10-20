package com.bs.themebridge.entity.servlet.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bs.themebridge.entity.model.TransactionProgressModel;
import com.bs.themebridge.util.DatabaseUtility;

public class TransationProgressImpl {

	public static Logger logger = Logger.getLogger(TransationProgressImpl.class);

	public static void main(String[] args) {
		List<TransactionProgressModel> resultset = getZoneDetails("", "");
	}

	public static List<TransactionProgressModel> getZoneDetails(String fromdate, String todate) {
		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		List<TransactionProgressModel> resultSet = new ArrayList<TransactionProgressModel>();
		String query = "SELECT SOURCE AS ZONE, COUNT(*) AS TOTALCOUNT FROM TRANSACTIONLOG WHERE OPERATION = 'Batch' AND TRUNC(PROCESSTIME) = TRUNC(SYSDATE) GROUP BY SOURCE ORDER BY SOURCE ASC";
		logger.debug("Query : " + query);
		try {
			con = DatabaseUtility.getThemebridgeConnection();
			stmt = con.createStatement();
			res = stmt.executeQuery(query);
			while (res.next()) {
				TransactionProgressModel pm = new TransactionProgressModel();
				pm.setZone(res.getString("ZONE"));
				pm.setZone(res.getString("TOTALCOUNT"));
				resultSet.add(pm);
			}

		} catch (SQLException e) {
			logger.error("Exception while get master count!", e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				logger.error(e1.getMessage(), e1);
			}
		} finally {
			// logger.debug("Table list " + hashMapList.size());
			DatabaseUtility.surrenderConnection(con, stmt, res);
		}
		return resultSet;
	}
}
