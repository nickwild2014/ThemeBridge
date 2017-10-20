package com.test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.bs.themebridge.util.DateTimeUtil;
import com.bs.themebridge.util.ThemeBridgeUtil;

/**
 * @author BSIT-THEMEBRIDGE(RaviPrasath)
 */
public class SwiftMailerUtil {

	private static final Logger logger = Logger.getLogger(SwiftMailerUtil.class);

	public static void main(String args[]) throws Exception {
		// String path =
		// "D:\\tiplus\\_prasath\\Task\\task 36
		// swiftmailer\\SWIFT_FILES\\103\\prasathOGT0005150035102.prt";
		// SwiftMailerUtil s = new SwiftMailerUtil();
		// int rowNumber = s.GetRowNumberFromFile_Old(path);
		// System.out.println("rowNumber>>>----->>>>>>" + rowNumber);
		// String ReferenceNumber = s.GetReferenceNumber(path, rowNumber);
		// System.out.println("ReferenceNumber>>>----->>>>>>" +
		// ReferenceNumber);
		//
		// int rowNumberEve = s.GetRowNumberFromFile(path,"23:");
		// System.out.println("rowNumber>>>----->>>>>>" + rowNumberEve);
		// String ReferenceNumberEVE = s.GetReferenceNumber(path, rowNumberEve);
		// System.out.println("ReferenceNumber>>>----->>>>>>" +
		// ReferenceNumberEVE);

		// String str = "Roja" + "\n" + ":25:PRASAfooTH 2" + "\n" + "TEST END";
		// getSwiftTagValue(str, ":25:");
		// getSwiftTagValue(str, "PRA");
		// InputStream is = new ByteArrayInputStream(str.getBytes());
		// // read it with BufferedReader
		// BufferedReader br = new BufferedReader(new InputStreamReader(is));
		//
		// int num = GetRowNumberFromFile("", br, ":25:");
		// System.out.println(num);

		// String s = ":7034:ABC[This is to extract]\n" + "TEST2\n212" +
		// ":7035:lkkhjhj";

		// System.out.println(s);
		// int startIndex = s.indexOf('[');
		// System.out.println("indexOf([) = " + startIndex);
		// int endIndex = s.indexOf(']');
		// System.out.println("indexOf(]) = " + endIndex);
		// System.out.println(s.substring(startIndex + 1, endIndex));

		// int startIndex2 = s.indexOf(":7034:");
		// System.out.println("indexOf([) = " + startIndex2);
		// int endIndex2 = s.indexOf(":7035:");
		// System.out.println("indexOf(]) = " + endIndex2);
		// System.out.println(s.substring(startIndex2 + 1, endIndex2));

		logger.debug("760COV Inward message test");

		try {
			String sfmsInMsg = ThemeBridgeUtil.readFile(
					"D:\\_Prasath\\00_TASK\\SFMSCoverInward760-767\\LKG\\ISS\\01_760COV_Inward02Actual - Copy.txt");
			logger.debug("760COV Inward : " + sfmsInMsg);

			// getMessageFieldsMap(sfmsInMsg);
			// bn.processInwardCoverMsg(sfmsInMsg, "DEF_MQ");

			StringBuilder sb = new StringBuilder();
			sb.append(sfmsInMsg);
			String temp = "";
			System.out.println((sb.substring(sb.indexOf(":7032:") + 6, sb.length())));
			temp = sb.substring(sb.indexOf(":7032:") + 6, sb.length());
			System.out.println("" + temp);

			String address = (sb.substring(sb.indexOf(":7032:") + 6, sb.length())).substring(0, temp.indexOf(":703"))
					.toString();
			System.out.println("" + address);

		} catch (Exception e) {
			logger.error("SfmsOutMsg : " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static HashMap<String, String> getMessageFieldsMap(String ifn760covMsg) {

		String eBGmessageLines[] = ifn760covMsg.split(System.getProperty("line.separator"));
		HashMap<String, String> mapList = new HashMap<String, String>();

		int lineCount = 0;
		String add = "";
		for (String lines : eBGmessageLines) {
			// System.out.println(lineCount++);

			// String add = "";
			if (lines.contains(":70")) {
				add = "";
				// System.out.println("if before : " + add);
				add = lines;
				System.out.println("if after : " + add);

			} else {
				System.out.println("else before : " + add);
				add = add + System.getProperty("line.separator") + lines;
				System.out.println("else after : " + add);
			}

			System.out.println(">>" + add);

			if (add.startsWith(":7020:")) {
				add = add.replace(":7020:", "");
				mapList.put("transactionNumber", add);

			} else if (add.startsWith(":7022:")) {
				add = add.replace(":7022:", "");
				mapList.put("theirNumber", add);
			}

		}

		System.out.println(mapList);
		return mapList;
	}

	/**
	 * 2017-FEB-21 Prasath Ravichandran
	 * 
	 * @param swiftmessage
	 *            {@code allows }{@link String}
	 * @param tagname
	 *            {@code allows }{@link String}
	 * @throws FileNotFoundException
	 *             {@code allows }{@link String}
	 */
	public static String getSwiftTagValue(String swiftmessage, String tagname) throws FileNotFoundException {

		// String str = "Roja" + "\n" + ":25:PRASAfooTH";
		InputStream is = new ByteArrayInputStream(swiftmessage.getBytes());
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String result = "";
		try {
			// File file = new File("file1.txt");
			Scanner in = null;
			in = new Scanner(br);
			// in = new Scanner(file);
			while (in.hasNext()) {
				String line = in.nextLine();
				if (line.contains(tagname)) {
					result = line.substring(4, line.length());
					// System.out.println(line);
				}
				logger.debug("Result : " + result);
			}

		} catch (Exception e) {
			logger.error("Exception e" + e.getMessage());
		}
		return result;
	}

	/**
	 * Get row number from file using keyword search
	 * 
	 * @param filepath
	 * @param swiftNum
	 * @return
	 * @throws IOException
	 */
	public static int GetRowNumberFromFile(String filepath, BufferedReader br, String swiftNum) throws IOException {
		// String words[] = new String[500];
		// FileReader fr = new FileReader(
		// "D:\\tiplus\\_prasath\\Task\\task 36
		// swiftmailer\\SWIFT_FILES\\110\\01647814.prt");

		// FileReader fr = new FileReader(filepath);
		// BufferedReader br = new BufferedReader(fr);
		String s;
		int linecount = 0;
		int rowNumber = 0;
		while ((s = br.readLine()) != null) {
			linecount++;
			int indexfound = s.indexOf(swiftNum);
			if (indexfound > -1) {
				rowNumber = linecount;
				rowNumber++;
			}
		}
		// fr.close();
		logger.info("Reference number position : " + rowNumber);
		return rowNumber;
	}

	/**
	 * Get specific line from file
	 * 
	 * @throws FileNotFoundException
	 */
	public String GetReferenceNumber(String filepath, int rowNumber) throws FileNotFoundException {
		File f = new File(filepath);
		Scanner fileScanner = new Scanner(f);
		int lineNumber = 1;
		String d = "";
		while (fileScanner.hasNextLine()) {
			fileScanner.nextLine();
			lineNumber++;
			if (lineNumber == rowNumber) {
				logger.info("\n\n");
				d = fileScanner.nextLine().trim();
				logger.info("\n\n");
			}
		}
		fileScanner.close();
		return d;
	}

	/**
	 * NOT IN USE (INDUSIND)
	 * 
	 * @return
	 * @throws IOException
	 */
	public int GetRowNumberFromFile_Old(String filepath) throws IOException {
		// String words[] = new String[500];
		// FileReader fr = new FileReader(
		// "D:\\tiplus\\_prasath\\Task\\task 36
		// swiftmailer\\SWIFT_FILES\\110\\01647814.prt");
		FileReader fr = new FileReader(filepath);
		BufferedReader br = new BufferedReader(fr);
		String s;
		int linecount = 0;
		int rowNumber = 0;
		while ((s = br.readLine()) != null) {
			linecount++;
			int indexfound = s.indexOf("20:");
			if (indexfound > -1) {
				rowNumber = linecount;
				rowNumber++;
			}
		}
		fr.close();
		logger.info("Reference number position : " + rowNumber);
		return rowNumber;
	}
}