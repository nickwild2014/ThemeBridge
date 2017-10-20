package com.test.extracts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import org.apache.log4j.Logger;

/**
 * 
 * @author O6831, PRASATH RAVICHANDRAN
 *
 */
public class FileHandlerUtil {

	// public static URL resource = FileHandlerUtil.class.getResource(".");
	// public static String queryLocation = resource.getPath() + "/sql/";
	private final static Logger logger = Logger.getLogger(FileHandlerUtil.class
			.getName());

	//public static void main(String[] args) {

	//}

	/**
	 * Methhod ID : 4
	 * 
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	public static String readSwiftFile(String filePath) throws Exception {
		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = null;
		StringBuilder stringBuilder = new StringBuilder();
		String ls = "\r\n";
		// CR/LF separator System.getProperty("line.separator");
		try {
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			try {
				fileReader.close();
			} catch (Exception ex) {

			}
			try {
				bufferedReader.close();
			} catch (Exception ex) {

			}
		}

		return stringBuilder.toString();
	}

	public static boolean writeFile(String filePathwithFileName,
			String messageToBeWrite) {
		boolean isSucceed = false;
		Writer output = null;
		File file = null;
		try {
			file = new File(filePathwithFileName);
			output = new BufferedWriter(new FileWriter(file));

			output.write(messageToBeWrite);

			isSucceed = true;
			logger.debug(" File has written in " + filePathwithFileName
					+ " ");
		} catch (Exception ex) {
			logger.error("WriteFile Exception! Check the logs for detail", ex);
			isSucceed = false;
		} finally {
			try {
				if (output != null)
					output.close();
			} catch (IOException e) {
				logger.error("WriteFile Exception! Check the logs for details",
						e);
			}
		}
		return isSucceed;
	}

	public static void about() {
		logger.info("***************************************************************************");
		logger.info("End of CSV Extraction.");
		logger.info(" Date : 2016-APR-10 RP v1.2");
		// logger.info(" PRASATH RAVICHANDRAN ");
		// logger.info(" prasathr@encoretheme.com");
		logger.info("***************************************************************************");
	}
}
