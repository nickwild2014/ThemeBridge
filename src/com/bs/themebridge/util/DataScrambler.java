package com.bs.themebridge.util;

import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.log4j.Logger;


public class DataScrambler {

	private final static Logger logger = Logger.getLogger(DataScrambler.class);

	public static void main(String[] args) {
		String readFilePath;
		try {
			readFilePath = args[0];
			String writeFilePath = getFileName(args[1]);
			doScrambling(readFilePath, writeFilePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void doScrambling(String readFilePath, String writeFilePath) {
		try {
			logger.debug("Scrambling started...");
			String fileContent = readFile(readFilePath);
			fileContent = fileContent.replaceAll("[0-9][0-9]{6,16}", "-=###=-");
			// writeFile(writeFilePath, fileContent);
			logger.debug("Scrambling completed.");
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("Scrambling completed with exceptions");
			logger.debug("Program exits");
		} finally {
			logger.debug("Program exits");
			logger.debug("Program exits");
		}
	}

	public static String readFile(String filePath) throws Exception {
		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = null;
		StringBuilder stringBuilder = new StringBuilder();
		String ls = System.getProperty("line.separator");
		try {
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
		} catch (Exception ex) {
		} finally {
			try {
				fileReader.close();
			} catch (Exception localException1) {
			}
			try {
				bufferedReader.close();
			} catch (Exception localException2) {
			}

		}
		try {
			fileReader.close();
		} catch (Exception localException3) {
		}
		try {
			bufferedReader.close();
		} catch (Exception localException4) {
		}

		return stringBuilder.toString();
	}

	public static String getFileName(String givenFileName) {
		String result = givenFileName + "-masked.log";
		return result;
	}

}