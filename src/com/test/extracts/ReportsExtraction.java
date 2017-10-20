package com.test.extracts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.bs.themebridge.util.DatabaseUtility;

public class ReportsExtraction {

	private final static Logger logger = Logger.getLogger(ReportsExtraction.class.getName());

	public static void main(String[] args) {
		// logger.debug("Test");
		// DatabaseUtil.getConnection();
		// filesList("D://Encore/Reports/input/");
		generateReports();
		FileHandlerUtil.about();
		// logger.debug("timeStamp"+timeStamp);
	}

	/**
	 * Methhod ID : 1, Extraction process begins here.
	 * 
	 */
	public static void generateReports() {
		logger.info("****************EXTRACTION PROCESS INITIATED!****************");
		String inputDirectoryPath = DatabaseUtil.getFileProperties("InputDirectoryPath");

		// String dircheck = DirectoryUtil.directoryHandler(inputDirectoryPath);
		logger.info("InputDirectoryPath : " + inputDirectoryPath);

		boolean process = processor(inputDirectoryPath);
		logger.info("****************EXTRACTION PROCESS COMPLETED!****************");
	}

	/**
	 * Methhod ID : 2
	 * 
	 * @param inputDirectoryPath
	 * @return
	 */
	public static boolean processor(String inputDirectoryPath) {
		try {
			List<File> directoryFilesList = filesList(inputDirectoryPath);

			logger.info("Total files : " + directoryFilesList.size());
			int totalFileCount = 0;
			if (directoryFilesList.size() > 0) {
				totalFileCount = directoryFilesList.size();
				int fileCount = 1;
				int succeededCount = 0;
				int failedCount = 0;

				for (int i = 0; i < totalFileCount; i++) {
					logger.info("/*************************************************** start of file " + fileCount
							+ " ***************************************************/");
					logger.info("File position : " + fileCount);
					String fileNameWithFullPath = directoryFilesList.get(i).toString();
					logger.info("FileNameWithFilePath : " + fileNameWithFullPath);

					File f = new File(fileNameWithFullPath);
					String fileName = f.getName();
					// fName =
					// f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf("\\")+1);
					logger.info("File name : " + f.getName());

					String fileNameWithOutExt = fileName.replaceFirst("[.][^.]+$", "");
					logger.info("FileNameWithoutExtension : " + fileNameWithOutExt);

					String sqlQuery = FileHandlerUtil.readSwiftFile(directoryFilesList.get(i).toString());
					logger.info("SQL Query : \n" + sqlQuery);

					String result = executeQuery(sqlQuery, fileNameWithOutExt);
					logger.info("/*************************************************** end of file " + fileCount
							+ " ***************************************************/\n\n");

					if (result.equals("SUCCEEDED")) {
						succeededCount++;
					} else if (result.equals("FAILED")) {
						failedCount++;
					}

					fileCount++;
				}
				logger.info("SUCCEEDED FILES: " + succeededCount);
				logger.info("FAILED FILES: " + failedCount);
				logger.info("TOTAL FILES  : " + totalFileCount);
			} else {
				logger.info("Input directory is empty..!");
			}
		} catch (Exception e) {
			logger.error("processor", e);
			// FileHandlerUtil.writeFile(inputDirectoryPath+ "exception.log",
			// e.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * Method ID : 3
	 * 
	 * @param directoryName
	 * @return
	 */
	public static List<File> filesList(String directoryName) {
		logger.info("Getting FilesList from " + directoryName);
		File directory = new File(directoryName);
		List<File> resultList = new ArrayList<File>();
		// get all the files from a directory
		File[] fList = directory.listFiles();
		resultList.addAll(Arrays.asList(fList));
		for (File file : fList) {
			if (file.isFile()) {
				/** parent directory only **/
				logger.info("File : " + file.getAbsolutePath());
			} else if (file.isDirectory()) {
				/** including sub directory **/
				// resultList.addAll(filesList(file.getAbsolutePath()));
				// resultList.addAll(listf(file.getName()));
			}
		}
		return resultList;
	}

	/**
	 * Methhod ID : 5
	 * 
	 * @param sqlQuery
	 * @param sourceSystem
	 * @param fileLocation
	 * @param fileName
	 * @param fileType
	 * @return
	 */
	public static String executeQuery(String sqlQuery, String fileNameWithOutExt) {

		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		String fileType = DatabaseUtil.getFileProperties("OutputFileType");
		// String sourceSystem = DatabaseUtil.getFileProperties("SourceSystem");
		String fileLocation = DatabaseUtil.getFileProperties("OutputDirctoryPath");

		// fileLocation = DirectoryUtil.currentDirectory()+"/input";
		String dircheck = DirectoryUtil.directoryHandler(fileLocation);

		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;
		String result = "Exception!";

		// String query = "SELECT * FROM SOURCESYSTEMLOOKUP";
		String query = sqlQuery;
		try {
			con = DatabaseUtility.getTizoneConnection();
			// con = DatabaseUtil.getThemebridgeConnection();
			stmt = con.createStatement();
			res = stmt.executeQuery(query);

			logger.info("Query executed!");
			boolean fileWriteResult = convertToCsv(res, fileLocation, fileNameWithOutExt, fileType);

			result = "SUCCEEDED";
		} catch (SQLException e) {
			logger.error("Exception caught!", e);
			FileHandlerUtil.writeFile(fileLocation + fileNameWithOutExt + "_" + timeStamp + ".log",
					e.getMessage() + query);
			result = "FAILED";
		} catch (FileNotFoundException e) {
			logger.error("File not found exception!");
			FileHandlerUtil.writeFile(fileLocation + fileNameWithOutExt + "_" + timeStamp + ".log",
					e.getMessage() + query);
			result = "FAILED";
		} finally {
			DatabaseUtility.surrenderConnection(con, stmt, res);
			logger.info("connection closed!");
		}
		return result;
	}

	/**
	 * Method ID : 6
	 * 
	 * @param rs
	 * @param fileLocation
	 * @param fileName
	 * @param fileType
	 * @throws SQLException
	 * @throws FileNotFoundException
	 */
	public static boolean convertToCsv(ResultSet rs, String fileLocation, String fileNameWithOutExt, String fileType)
			throws SQLException, FileNotFoundException {
		logger.info("Enters into convertToCsv");
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());

		boolean result = false;
		String file = fileLocation + fileNameWithOutExt + "_" + timeStamp + "." + fileType;
		logger.info("File output directory : " + file);
		logger.info("Generating CSV file...");
		try {
			// PrintWriter csvWriterTest = new PrintWriter(new File(
			// "D://Encore/whatever.csv"));
			PrintWriter csvWriter = new PrintWriter(new File(file));
			ResultSetMetaData meta = rs.getMetaData();

			int numberOfColumns = meta.getColumnCount();
			String dataHeaders = "\"" + meta.getColumnName(1) + "\"";

			for (int i = 2; i < numberOfColumns + 1; i++) {
				dataHeaders += ",\"" + meta.getColumnName(i) + "\"";
			}
			csvWriter.println(dataHeaders);
			while (rs.next()) {
				String row = "\"" + rs.getString(1) + "\"";
				for (int i = 2; i < numberOfColumns + 1; i++) {
					row += ",\"" + rs.getString(i) + "\"";
				}
				csvWriter.println(row);
			}
			csvWriter.close();
			logger.info("File generated successfully!");
			result = true;
		} catch (Exception e) {
			logger.error("File generation failed! ", e);
			FileHandlerUtil.writeFile(fileLocation + fileNameWithOutExt + ".log", e.getMessage());
			result = false;
		}
		return result;
	}

}
