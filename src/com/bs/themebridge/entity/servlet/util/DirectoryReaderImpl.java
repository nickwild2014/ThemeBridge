package com.bs.themebridge.entity.servlet.util;

import java.io.File;
import java.text.SimpleDateFormat;
/*import java.io.IOException;
 import java.nio.file.Files;
 import java.nio.file.Path;
 import java.nio.file.Paths;
 import java.nio.file.attribute.BasicFileAttributes;*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.bs.themebridge.entity.model.DirectoryReaderModel;

/**
 * @author PRASATH RAVICHANDRAN
 */
public class DirectoryReaderImpl {

	private final static Logger logger = Logger.getLogger(DirectoryReaderImpl.class.getName());

	public static void main(String[] args) {
		// List<File> directoryFilesList =
		// readDirectoryList("D:\\Encore\\SQL_Queries\\");
		// attributesOfFile(directoryFilesList);
		//
		List<DirectoryReaderModel> ls = readDirectory("D:\\Encore\\SQL_Queries\\");
		logger.debug(ls.size());

		for (DirectoryReaderModel ls1 : ls) {
			logger.debug(ls1.getFileName());
			logger.debug(ls1.getFilesize());
			logger.debug(ls1.getFilePath());
		}
		//
		// for (int i = 0; i < ls.size(); i++) {
		// logger.debug(ls.get(i).getFileName());
		// logger.debug(ls.get(i).getFilesize());
		// logger.debug(ls.get(i).getFilePath());
		// }

		// filesListTest("D:\\Encore\\SQL_Queries\\");
		// List<DirectoryReaderModel> ls =
		// readDirectory("D:\\Encore\\SQL_Queries\\");
	}

	/**
	 * To delete a file which stored in it local system
	 * 
	 * @param filePath
	 *            {@code allows } {@link String}
	 * 
	 * @return {@link boolean}
	 */
	public static boolean deleteFile(String filePath) {
		boolean isSucceed = false;
		File file = null;
		try {
			file = new File(filePath);
			if (file.exists()) {
				file.delete();
			}
			isSucceed = true;
		} catch (Exception ex) {
			logger.error("Exception! Check the logs for detail", ex);
			isSucceed = false;
		} finally {
			// TODO
		}
		return isSucceed;
	}

	/**
	 * 
	 * @param dirPath
	 * @return
	 */
	public static boolean directoryExist(String dirPath) {
		boolean directoryPath = true;
		File file = new File(dirPath);
		if (file.exists() && file.isDirectory()) {
			directoryPath = true;
		} else {
			directoryPath = false;
		}
		logger.info(directoryPath);
		return directoryPath;
	}

	/**
	 * 
	 * @param dirPath
	 * @return
	 */
	public static List<DirectoryReaderModel> readDirectoryOLD(String dirPath) {
		List<DirectoryReaderModel> fileAttrList = null;

		// List<File> directoryFilesList = readDirectoryList(dirPath);
		logger.info("Step 1-2");
		// fileAttrList = attributesOfFile(directoryFilesList);

		return fileAttrList;
	}

	/**
	 * 
	 * @param dirPath
	 * @return
	 */
	public static List<DirectoryReaderModel> readDirectory(String dirPath) {
		List<DirectoryReaderModel> directoryFilesList = null;
		File file = new File(dirPath);
		if (file.exists() && file.isDirectory()) {
			directoryFilesList = filesList(dirPath);
			logger.info("Total files count : " + directoryFilesList.size());
		} else {
			logger.info("Folder does not exist");
		}
		return directoryFilesList;
	}

	/**
	 * 
	 * @param directoryName
	 * @return
	 */
	public static List<File> filesListSuccess(String directoryName) {
		logger.info("Getting FilesList from " + directoryName);
		File directory = new File(directoryName);
		List<File> resultList = new ArrayList<File>();
		// get all the files from a directory
		File[] fList = directory.listFiles();
		resultList.addAll(Arrays.asList(fList));
		for (File file : fList) {
			if (file.isFile()) {
				/** parent directory only **/
				// logger.debug((file.length()) + " Bytes");
				// logger.info("File : " + file.getAbsolutePath());
			} else if (file.isDirectory()) {
				/** including sub directory **/
				// resultList.addAll(filesList(file.getAbsolutePath()));
				// resultList.addAll(listf(file.getName()));
			}
		}
		return resultList;
	}

	public static List<DirectoryReaderModel> filesList(String directoryName) {
		logger.info("Getting FilesList from " + directoryName);
		List<DirectoryReaderModel> dirFilesAttributesList = new ArrayList<DirectoryReaderModel>();

		File directory = new File(directoryName);
		List<File> resultList = new ArrayList<File>();
		// get all the files from a directory
		File[] fList = directory.listFiles();
		resultList.addAll(Arrays.asList(fList));
		for (File file : fList) {
			DirectoryReaderModel dirReaderModel = new DirectoryReaderModel();

			logger.debug(file.getName());
			logger.debug(file.lastModified());
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			logger.debug("After Format : " + sdf.format(file.lastModified()));

			logger.debug(file.getAbsolutePath());
			// logger.debug("::" + file.getTotalSpace());
			logger.debug("isDirectory::" + file.isDirectory());
			logger.debug("isFile()::" + file.isFile());
			long size = file.length();
			logger.debug("size::" + size + " bytes");

			dirReaderModel.setFileName(file.getName());
			dirReaderModel.setLastModifiedTime(file.lastModified());
			dirReaderModel.setFilePath(file.getAbsolutePath());
			if (file.isDirectory())
				dirReaderModel.setIsDirectory("Directory");
			else
				dirReaderModel.setIsDirectory("File");
			// dirReaderModel.setFilesize(size);
			dirReaderModel.setFilesize(size/1024);

			dirFilesAttributesList.add(dirReaderModel);

			// if (file.isFile()) {
			/** parent directory only **/
			// logger.debug((file.length()) + " Bytes");
			// logger.info("File : " + file.getAbsolutePath());
			// } else if (file.isDirectory()) {
			/** including sub directory **/
			// resultList.addAll(filesList(file.getAbsolutePath()));
			// resultList.addAll(listf(file.getName()));
			// }

		}
		return dirFilesAttributesList;
	}

	/**
	 * THIS WILL BE RUN ONLY IN MORE THAN VERSION JAVA 1.7
	 * 
	 * @param directoryFilesList
	 */
	// public static List<DirectoryReaderModel> attributesOfFile(
	// List<File> directoryFilesList) {
	//
	// List<DirectoryReaderModel> dirFilesAttributesList = new
	// ArrayList<DirectoryReaderModel>();
	//
	// try {
	// for (int i = 0; i < directoryFilesList.size(); i++) {
	// File file = directoryFilesList.get(i);
	// String filePath = file.getAbsolutePath();
	// String fileName = file.getName();
	// // logger.debug(fileName);
	// DirectoryReaderModel dirReaderModel = new DirectoryReaderModel();
	//
	// Path fileAttributes = Paths.get(filePath);
	// BasicFileAttributes attr;
	//
	// attr = Files.readAttributes(fileAttributes,
	// BasicFileAttributes.class);
	//
	// logger.debug("------------------------------");
	// logger.debug("fileName : " + fileName);
	// logger.debug("creationTime: " + attr.creationTime());
	// // logger.debug("lastAccessTime: " +
	// // attr.lastAccessTime());
	// logger.debug("lastModifiedTime: "
	// + attr.lastModifiedTime());
	//
	// logger.debug("isDirectory: " + attr.isDirectory());
	// // logger.debug("isOther: " + attr.isOther());
	// logger.debug("isRegularFile: " + attr.isRegularFile());
	// // logger.debug("isSymbolicLink: " +
	// // attr.isSymbolicLink());
	// logger.debug("size: " + attr.size() + " bytes");
	// logger.debug("------------------------------");
	//
	// dirReaderModel.setFileName(fileName);
	// dirReaderModel.setCreationTime(attr.creationTime().toString());
	// //
	// dirReaderModel.setLastModifiedTime(attr.lastModifiedTime().toString());
	// dirReaderModel.setLastAccessTime(attr.lastAccessTime()
	// .toString());
	// if (attr.isDirectory())
	// dirReaderModel.setIsDirectory("Directory");
	// else
	// dirReaderModel.setIsDirectory("File");
	// // dirReaderModel.setIsOther(attr.isOther());
	// dirReaderModel.setFilesize(attr.size());
	// dirReaderModel.setFilePath(file.getAbsolutePath());
	//
	// dirFilesAttributesList.add(dirReaderModel);
	//
	// }
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// return dirFilesAttributesList;
	// }

	/**
	 * 
	 * @param directoryName
	 * @param files
	 */
	public void listf(String directoryName, ArrayList<File> files) {
		File directory = new File(directoryName);
		// get all the files from a directory
		File[] fList = directory.listFiles();
		for (File file : fList) {
			if (file.isFile()) {
				files.add(file);
			} else if (file.isDirectory()) {
				listf(file.getAbsolutePath(), files);
			}
		}
	}

	/**
	 * 
	 * @return
	 */
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

	public static boolean writeOutMessage(String filePath, String foldername, String fileName, String bankRequest) {
		logger.info("Starting to write file");
		boolean isSucceed = false;
		String successFilePath = filePath + foldername;
		String failureFilePath = filePath;

		String PATH = "/remote/dir/server/";
		// String directoryName = PATH.concat(this.getClassName());

		try {
			File directory = new File(successFilePath);
			if (directory.exists()) {
				logger.debug("Folder exist for write file " + successFilePath + fileName);
				// writeFile(successFilePath + fileName, bankRequest);
			} else if (!directory.exists()) {
				directory.mkdir();

				logger.debug("Folder not exist for write file " + failureFilePath + fileName);
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
