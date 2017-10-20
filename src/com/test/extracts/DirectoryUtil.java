package com.test.extracts;

import java.io.File;
import java.io.FilePermission;
import java.security.AccessController;

import org.apache.log4j.Logger;

public class DirectoryUtil {

	private final static Logger logger = Logger.getLogger(DirectoryUtil.class
			.getName());

	// public static void main(String[] args) {
	// TODO Auto-generated method stub
	// currentDirectory();
	// }

	public static String currentDirectory() {
		String result = "";

		result = System.getProperty("user.dir");
		logger.info("Working Directory = " + result);

		return result;
	}

	public static String directoryHandler(String dir) {
		String result = "";

		// String actions = "read,write";
		// try {
		// AccessController.checkPermission(new FilePermission(dir, actions));
		// logger.debug("You have read/write permition to use : " + dir);
		// } catch (SecurityException e) {
		// logger.debug("You have no read/write permition to use : "
		// + dir);
		// }

		// File file = new File(dir);
		// if (!file.exists()) {
		// if (file.mkdir()) {
		// logger.info("Directory is created!");
		// } else {
		// logger.info("Failed to create directory!");
		// }
		// } else {
		// logger.info("Folder already exist!");
		// }

		File files = new File(dir);
		if (!files.exists()) {
			if (files.mkdirs()) {
				result = "Multiple directories are created!";
			} else {
				result = "Failed to create multiple directories!";
			}
		} else {
			result = "Multiple Folder already exist!";
		}
		logger.info("directoryHandler : " + result);
		return result;
	}

	public static boolean writeOutMessage(String filePath, String foldername,
			String fileName, String bankRequest) {
		logger.info("Starting to write file");
		boolean isSucceed = false;
		String successFilePath = filePath + foldername;
		String failureFilePath = filePath;

		String PATH = "/remote/dir/server/";
		// String directoryName = PATH.concat(this.getClassName());

		try {
			File directory = new File(successFilePath);
			if (directory.exists()) {
				logger.debug("Folder exist for write file " + successFilePath
						+ fileName);
				// writeFile(successFilePath + fileName, bankRequest);
			} else if (!directory.exists()) {
				directory.mkdir();

				logger.debug("Folder not exist for write file "
						+ failureFilePath + fileName);
				// writeFile(failureFilePath + fileName, bankRequest);
			}
			isSucceed = true;
		} catch (Exception e) {
			logger.error("Exception -> " + e.getMessage(), e);
			isSucceed = false;
		}
		return isSucceed;
	}
}
