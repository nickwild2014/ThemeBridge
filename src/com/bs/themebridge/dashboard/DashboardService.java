package com.bs.themebridge.dashboard;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.log4j.Logger;

import com.bs.themebridge.util.DatabaseUtility;
import com.bs.themebridge.util.DateTimeUtil;

/**
 * 
 * @author Prasath Ravichandran
 *
 */
public class DashboardService {

	private final static Logger logger = Logger.getLogger(DashboardService.class.getName());

	public static void main(String args[]) {

		InterfaceStatusReport aReport = new InterfaceStatusReport();

		getStatusCount("servicelog", aReport);
		// getStatusCount("postingstaging", aReport);
		// getStatusCount("staticdatalog", aReport);
		// getStatusCount("transactionlog", aReport);
		// logger.debug("DashboardService job ends");

		// getInterfaceStatusReport("", "");
	}

	/**
	 * @since 2016-OCT-12
	 * @version 1.2
	 * @author Prasath Ravichandran
	 * @return InterfaceStatusReport
	 */
	public static InterfaceStatusReport getInterfaceStatusReport(String fromDate, String toDate) {

		// logger.debug("FromDate/ToDate : " + fromDate + " / " + toDate);
		// logger.debug("PostingStaging : " + new java.util.Date());
		// Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		// logger.debug(timestamp);

		InterfaceStatusReport aReport = new InterfaceStatusReport();

		logger.debug("PostingStagingLog : " + new Timestamp(System.currentTimeMillis()));
		aReport = getPostingStagingStatus(aReport);

		logger.debug("TransactionLog : " + new Timestamp(System.currentTimeMillis()));
		aReport = getTransactionStatus(aReport);

		logger.debug("ServiceLog : " + new Timestamp(System.currentTimeMillis()));
		aReport = getServiceStatus(aReport);

		logger.debug("StaticLog : " + new Timestamp(System.currentTimeMillis()));
		aReport = getStaticDataStatus(aReport);

		return aReport;

	}

	public static InterfaceStatusReport getTransactionStatus(InterfaceStatusReport aReport) {
		return getStatusCount("transactionlog", aReport);
	}

	public static InterfaceStatusReport getServiceStatus(InterfaceStatusReport aReport) {
		return getStatusCount("servicelog", aReport);
	}

	public static InterfaceStatusReport getStaticDataStatus(InterfaceStatusReport aReport) {
		return getStatusCount("staticdatalog", aReport);
	}

	public static InterfaceStatusReport getPostingStagingStatus(InterfaceStatusReport aReport) {
		return getStatusCount("postingstaging", aReport);
	}

	/**
	 *
	 * @since 2016-OCT-12
	 * @version 1.2
	 * @author Prasath Ravichandran
	 * 
	 * @param tableName
	 *            {@code allows }{@link String}
	 * @param aReport
	 *            {@code allows }{@link obj}
	 * @return InterfaceStatusReport
	 */
	private static InterfaceStatusReport getStatusCount(String tableName, InterfaceStatusReport aReport) {

		int errorCount = 0;
		int queuedCount = 0;
		int successCount = 0;
		int failureCount = 0;
		int receivedCount = 0;
		int suppressedCount = 0;
		int transmittedCount = 0;
		int unavailableCount = 0;

		String returnValue = "(0,0)";
		Statement aStatement = null;
		ResultSet aResultset = null;
		Connection aConnection = null;
		InterfaceStatus aStatus = new InterfaceStatus();
		try {
			String query = "";
			String status = "";
			aConnection = DatabaseUtility.getThemebridgeConnection();
			String date = DateTimeUtil.getStringLocalDateInFormat("dd-MMM-yy");
			query = "select status, count(*) as count from " + tableName + " group by status";
			// query = "select status,count(*) as count from " + tableName + "
			// where trunc(processtime) = '" + date
			// + "' group by status";
			// logger.debug("DashboardQuery: " + query);

			aStatement = aConnection.createStatement();
			aResultset = aStatement.executeQuery(query);

			while (aResultset.next()) {
				status = aResultset.getString("status");

				if ("SUCCEEDED".equalsIgnoreCase(status)) {
					// successCount = successCount + aResultset.getInt("count");
					successCount = successCount + aResultset.getInt("count");
					aStatus.setSuccededCount(successCount);

				} else if ("FAILED".equalsIgnoreCase(status)) {
					failureCount = failureCount + aResultset.getInt("count");
					aStatus.setFailureCount(failureCount);

				} else if ("QUEUED".equalsIgnoreCase(status)) {
					queuedCount = queuedCount + aResultset.getInt("count");
					aStatus.setQueuedCount(queuedCount);

				} else if ("TRANSMITTED".equalsIgnoreCase(status) || "PROCESSED".equalsIgnoreCase(status)) {
					transmittedCount = transmittedCount + aResultset.getInt("count");
					aStatus.setTransmittedCount(transmittedCount);

				} else if ("SUPPRESSED".equalsIgnoreCase(status)) {
					suppressedCount = suppressedCount + aResultset.getInt("count");
					aStatus.setSuppressedCount(suppressedCount);

				} else if ("UNAVAILABLE".equalsIgnoreCase(status)) {
					unavailableCount = unavailableCount + aResultset.getInt("count");
					aStatus.setUnavailableCount(unavailableCount);

				} else if ("RECEIVED".equalsIgnoreCase(status)) {
					receivedCount = receivedCount + aResultset.getInt("count");
					aStatus.setReceivedCount(receivedCount);

				} else {
					errorCount = errorCount + aResultset.getInt("count");
					aStatus.setErrorCount(errorCount);
				}
			}

			// logger.debug("Whileloop ended!!!");
			// logger.debug("successCount : " + successCount);
			// logger.debug("failureCount : " + failureCount);
			// logger.debug("queuedCount : " + queuedCount);
			// logger.debug("Transmitted+Processed : " + transmittedCount);
			// logger.debug("suppressedCount : " + suppressedCount);
			// logger.debug("unavailableCount : " + unavailableCount);
			// logger.debug("receivedCount : " + receivedCount);
			// logger.debug("errorCount : " + errorCount);

			double totalCount = successCount + failureCount + queuedCount + transmittedCount + suppressedCount
					+ unavailableCount + receivedCount + errorCount;
			double successPercentage = ((successCount + queuedCount + transmittedCount + suppressedCount
					+ receivedCount) / totalCount) * 100;
			double failurePercentage = (100 - successPercentage);

			returnValue = "(" + failurePercentage + "," + successPercentage + ")";
			logger.debug(" returning " + tableName + returnValue);

			// logger.debug("Total : " + totalCount);
			// logger.debug("successPercentage : " + successPercentage);
			// logger.debug("failurePercentage : " + failurePercentage);

			if ("transactionlog".equalsIgnoreCase(tableName)) {
				// logger.debug("Transaction" + aStatus + returnValue);
				aReport.setTransactionLogReport(aStatus);
				aReport.setTransactionLogChartValue(returnValue);

			} else if ("servicelog".equalsIgnoreCase(tableName)) {
				// logger.debug("Servicedata" + aStatus + returnValue);
				aReport.setServiceLogReport(aStatus);
				aReport.setServiceLogChartValue(returnValue);

			} else if ("staticdatalog".equalsIgnoreCase(tableName)) {
				// logger.debug("Staticdata" + aStatus + returnValue);
				aReport.setStaticDataReport(aStatus);
				aReport.setStaticDataLogChartValue(returnValue);

			} else if ("postingstaging".equalsIgnoreCase(tableName)) {
				// logger.debug("Posting staging" + aStatus + returnValue);
				aReport.setStagingDataReport(aStatus);
				aReport.setStagingDataLogChartValue(returnValue);
			}

		} catch (SQLException exp) {
			logger.error("Dashboard SQLException " + exp.getMessage());
			exp.printStackTrace();

		} finally {
			DatabaseUtility.surrenderConnection(aConnection, aStatement, aResultset);
		}

		return aReport;
	}

}
