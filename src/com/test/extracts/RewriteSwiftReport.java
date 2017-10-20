package com.test.extracts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.bs.theme.bob.adapter.adaptee.SWIFTSwiftInAdaptee;
import com.bs.theme.bob.adapter.util.BackofficeBatchUtil;
import com.bs.themebridge.util.ValidationsUtil;

public class RewriteSwiftReport {

	private final static Logger logger = Logger.getLogger(BackofficeBatchUtil.class.getName());

	public static void main(String[] args) {

		generateReports();
	}

	/**
	 * Methhod ID : 1, Extraction process begins here.
	 * 
	 */
	public static void generateReports() {
		logger.debug("****************EXTRACTION PROCESS INITIATED!****************");

		String inputDirectoryPath = "D:\\_Prasath\\Filezilla\\SWIFT samples";
		// String inputDirectoryPath = "D:\\_Prasath\\Filezilla\\task 14 swift
		// msg\\testinp";
		String outputDirectoryPath = "D:\\_Prasath\\Filezilla\\testout";
		// String inputDirectoryPath =
		// DatabaseUtil.getFileProperties("InputDirectoryPath");

		// String dircheck = DirectoryUtil.directoryHandler(inputDirectoryPath);
		logger.debug("InputDirectoryPath : " + inputDirectoryPath);

		boolean process = processor(inputDirectoryPath, outputDirectoryPath);
		logger.debug("****************EXTRACTION PROCESS COMPLETED!****************");
	}

	/**
	 * Methhod ID : 2
	 * 
	 * @param inputDirectoryPath
	 * @return
	 */
	public static boolean processor(String inputDirectoryPath, String outputFileLocation) {
		try {
			List<File> directoryFilesList = filesList(inputDirectoryPath);

			logger.debug("Total files : " + directoryFilesList.size());
			int totalFileCount = 0;
			if (directoryFilesList.size() > 0) {
				totalFileCount = directoryFilesList.size();
				int fileCount = 1;
				int succeededCount = 0;
				int failedCount = 0;

				for (int i = 0; i < totalFileCount; i++) {
					logger.debug("/******************* start of file " + fileCount + " ******************* /");
					logger.debug("File position : " + fileCount);
					String fileNameWithFullPath = directoryFilesList.get(i).toString();
					// logger.debug("FileNameWithFilePath : " +
					// fileNameWithFullPath);

					File f = new File(fileNameWithFullPath);
					String fileName = f.getName();
					// fName =
					// f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf("\\")+1);
					logger.debug("File name : " + f.getName());

					String fileNameWithOutExt = fileName.replaceFirst("[.][^.]+$", "");
					logger.debug("FileNameWithoutExtension : " + fileNameWithOutExt);

					String swiftMessage = FileHandlerUtil.readSwiftFile(directoryFilesList.get(i).toString());
					// logger.debug("Swift message : \n" + swiftMessage);

					String msg = "SWIFT";
					String msgTypePrefix = "MT";
					// String flowDirection = "INWARD";
					String flowDirection = "OUTWARD";

					String result = doExtractReport(outputFileLocation, swiftMessage, msgTypePrefix, flowDirection, msg,
							i, "", "");
					logger.debug("/******************* end of file " + fileCount + " ******************* /");

					if (result.equals("SUCCEEDED")) {
						succeededCount++;
					} else if (result.equals("FAILED")) {
						failedCount++;
					}

					fileCount++;
				}
				logger.debug("SUCCEEDED FILES: " + succeededCount);
				logger.debug("FAILED FILES: " + failedCount);
				logger.debug("TOTAL FILES  : " + totalFileCount);
			} else {
				logger.debug("Input directory is empty..!");
			}
		} catch (Exception e) {
			logger.debug("processor");
			// FileHandlerUtil.writeFile(inputDirectoryPath+ "exception.log",
			// e.getMessage());
			return false;
		}
		return true;
	}

	private static String doExtractReport(String outputFileLocation, String swiftMessage, String msgTypePrefix,
			String flowDirection, String msg, int totalFileCount, String masterReference, String eventReference)
					throws Exception {

		// Connection conn = getThemebridgeConnection();
		// PreparedStatement ps = conn.prepareStatement(swiftMessage);
		// ResultSet rs = ps.executeQuery(swiftMessage);

		// logger.debug(totalFileCount);

		String msgTypeSuffix = "";
		String sender = "";
		String receiver = "";
		// SWIFT
		if (msg.equals("SWIFT")) {
			if (flowDirection.equals("OUTWARD")) {
				msgTypeSuffix = getSwiftMsgType(swiftMessage);
				sender = getSwiftOutwardSender(swiftMessage);
				receiver = getSwiftOutwardReceiver(swiftMessage);
				masterReference = getSwiftOutwardMaster(swiftMessage);
				// logger.debug("a" + msgTypeSuffix);
			} else if (flowDirection.equals("INWARD")) {
				msgTypeSuffix = getSwiftMsgType(swiftMessage);
				sender = getSwiftInwardSender(swiftMessage);
				receiver = getSwiftInwardReceiver(swiftMessage);
				// logger.debug("b");
			}
		}

		boolean test = writeIntoFile(outputFileLocation, masterReference, eventReference, msgTypePrefix + msgTypeSuffix,
				swiftMessage, flowDirection, totalFileCount, sender, receiver);
		String resp = "";
		if (test)
			resp = "SUCCEEDED";
		else
			resp = "FAILED";

		return resp;
	}

	public static boolean writeIntoFile(String outputFileLocation, String masterReference, String eventReference,
			String msgType, String bankRequest, String flowDirection, int totalFileCount, String sender,
			String receiver) throws IOException {

		boolean writingStatus = false;
		File folder = new File(outputFileLocation);
		// logger.debug(outputFileLocation);

		if (!folder.exists()) {
			if (folder.mkdir()) {
				// logger.debug("Folder is created!");
			} else {
				// logger.debug("Failed to create directory!");
			}
		} else {
			// logger.debug("Folder already exists");
		}
		// PrintWriter out = null;
		String locPath = outputFileLocation + "\\" + msgType + "_-_" + flowDirection + "_-_" + sender + "_-_" + receiver
				+ "_-_" + masterReference + "_-_" + totalFileCount + ".txt";
		// logger.debug(locPath);
		try {

			if (ValidationsUtil.isValidString(bankRequest)) {
				// out = new PrintWriter(locPath);
				// out.println(bankRequest);
				// logger.debug("File created");
				writingStatus = SWIFTSwiftInAdaptee.writeFile(locPath, bankRequest);
			}

		} finally {
			// out.close();
		}
		return writingStatus;
	}

	/**
	 * Method ID : 3
	 * 
	 * @param directoryName
	 * @return
	 */
	public static List<File> filesList(String directoryName) {
		// logger.debug("Getting FilesList from " + directoryName);
		File directory = new File(directoryName);
		List<File> resultList = new ArrayList<File>();
		// get all the files from a directory
		File[] fList = directory.listFiles();
		resultList.addAll(Arrays.asList(fList));
		for (File file : fList) {
			if (file.isFile()) {
				/** parent directory only **/
				// logger.debug("File : " + file.getAbsolutePath());
			} else if (file.isDirectory()) {
				/** including sub directory **/
				// resultList.addAll(filesList(file.getAbsolutePath()));
				// resultList.addAll(listf(file.getName()));
			}
		}
		return resultList;
	}

	public static String getSwiftMsgType(String msg) {
		String swiftCode = "";
		int indexCode = msg.indexOf("{2:");
		if (indexCode >= 0 && indexCode < msg.length()) {
			swiftCode = msg.substring(indexCode + 4, indexCode + 7);
		}
		return swiftCode;
	}

	public static String getSwiftOutwardSender(String msg) {
		String swiftCode = "";
		int indexCode = msg.indexOf("{1:");
		if (indexCode >= 0 && indexCode < msg.length()) {
			swiftCode = "(S)" + msg.substring(indexCode + 6, indexCode + 18);
		}
		return swiftCode;
	}

	public static String getSwiftOutwardReceiver(String msg) {
		String swiftCode = "";
		int indexCode = msg.indexOf("{2:");
		if (indexCode >= 0 && indexCode < msg.length()) {
			swiftCode = "(R)" + msg.substring(indexCode + 7, indexCode + 19);
		}
		return swiftCode;
	}

	public static String getSwiftOutwardMaster(String msg) {
		String swiftCode = "";
		int indexCode = msg.indexOf(":20:");
		// logger.debug("Master : " + indexCode + ", " + msg.length());

		if (indexCode >= 0 && indexCode < msg.length()) {
			// logger.debug("IFFFFFFFFFFFFF");
			// swiftCode = msg.substring(indexCode + 4, indexCode + 16);
			swiftCode = msg.substring(indexCode + 4, indexCode + 10);
		}

		return swiftCode;
	}

	/************ Inward ***************/
	public static String getSwiftInwardReceiver(String msg) {
		String swiftCode = "";
		int indexCode = msg.indexOf("{1:F0");
		if (indexCode >= 0 && indexCode < msg.length()) {
			swiftCode = "(R)" + msg.substring(indexCode + 6, indexCode + 18);
		}
		return swiftCode;
	}

	public static String getSwiftInwardSender(String msg) {
		String swiftCode = "";

		try {
			int indexCode = msg.indexOf("{2:O");
			logger.debug(indexCode);

			if (indexCode > 0) {
				if (indexCode >= 0 && indexCode < msg.length()) {
					swiftCode = "(S)" + msg.substring(indexCode + 17, indexCode + 28);
				}
			} else {
				int isckNakCode = msg.indexOf("{451:");
				// logger.debug("isckNakCode" + isckNakCode);
				String is_ACK_NAK = msg.substring(isckNakCode + 5, isckNakCode + 6);
				// logger.debug("is_ACK_NAK " + is_ACK_NAK);

				if (is_ACK_NAK.equals("0"))
					swiftCode = "ACK" + "_-_(S)" + msg.substring(indexCode + 6, indexCode + 18);
				else if (is_ACK_NAK.equals("1"))
					swiftCode = "NAK" + "_-_(S)" + msg.substring(indexCode + 6, indexCode + 18);
			}
		} catch (Exception e) {
			logger.debug("Error SwiftIncoming sender");
		}
		return swiftCode;
	}

	/*****************************************************/
	public static String getSFMSMsgType(String msg) {
		String swiftCode = "";
		int indexCode = msg.indexOf("{A:");
		if (indexCode >= 0 && indexCode < msg.length()) {
			swiftCode = msg.substring(indexCode + 10, indexCode + 16);
		}
		return swiftCode;
	}

	public static String getSFMSSender(String msg) {
		String swiftCode = "";
		int indexCode = msg.indexOf("{A:");
		if (indexCode >= 0 && indexCode < msg.length()) {
			swiftCode = "(S)" + msg.substring(indexCode + 16, indexCode + 27);
		}
		return swiftCode;
	}

	public static String getSFMSReceiver(String msg) {
		String swiftCode = "";
		int indexCode = msg.indexOf("{A:");
		if (indexCode >= 0 && indexCode < msg.length()) {
			swiftCode = "(R)" + msg.substring(indexCode + 27, indexCode + 38);
		}
		return swiftCode;
	}

	public static Connection getThemebridgeConnection() {

		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// String BUILD_JdbcURL =
			// "jdbc:oracle:thin:@10.10.20.137:1530:orcl";
			String UAT2_JdbcURL = "jdbc:oracle:thin:@10.10.19.179:1528:orcl2";
			// String MIG_JdbcURL = "jdbc:oracle:thin:@10.10.19.179:1530:orcl";
			// String SIT_JdbcURL = "jdbc:oracle:thin:@10.10.20.137:1528:orcl1";

			/** BUILD **/
			// connection = DriverManager.getConnection(BUILD_JdbcURL,
			// "themebridge", "themebridge_123");

			/** UAT2 **/
			connection = DriverManager.getConnection(UAT2_JdbcURL, "THEMEBRIDGE", "THEMEBRIDGE");

			/** MIG **/
			// connection = DriverManager.getConnection(MIG_JdbcURL,
			// "themebridge", "themebridge");

			/** SIT **/
			// connection = DriverManager.getConnection(SIT_JdbcURL,
			// "themebridge", "themebridge_123");

			if (connection == null) {
				logger.debug("Themebridge connection(DB) failed! >>-->> null");
			}

		} catch (ClassNotFoundException e) {
			logger.debug("ThemeBridge ClassNotFoundException!" + e.getMessage());
			e.printStackTrace();

		} catch (Exception e) {
			logger.debug("ThemeBridge Exception!" + e.getMessage());
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * 
	 * @param filePath
	 * @param bankRequest
	 * @return
	 */
	public static boolean writeFile(String filePath, String bankRequest) {

		boolean result = false;
		// logger.debug("Write swift file initiated");
		// logger.debug("filePath ->" + filePath);
		File file = null;
		Writer output = null;
		file = new File(filePath);
		try {
			output = new BufferedWriter(new FileWriter(file));
			if (ValidationsUtil.isValidString(bankRequest)) {
				StringBuilder stringBuilder = new StringBuilder();
				InputStreamReader isr = null;
				BufferedReader bufferedReader = null;
				String line = null;
				isr = new InputStreamReader(new ByteArrayInputStream(bankRequest.getBytes()));
				bufferedReader = new BufferedReader(isr);
				while ((line = bufferedReader.readLine()) != null) {
					stringBuilder.append(line + "\r\n");
				}
				output.write(stringBuilder.toString());
				// logger.debug("stringBuilder ->" + stringBuilder.toString() +
				// "<-");
			}
			result = true;
			// logger.debug("Write swift file completed");

		} catch (IOException e) {
			result = false;
			logger.debug("Write file exceptions " + e.getMessage());

		} finally {
			try {
				output.close();
			} catch (IOException e) {
				logger.debug("IOException -> " + e.getMessage());
			}
		}
		return result;
	}

}
