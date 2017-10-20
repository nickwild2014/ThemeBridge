package com.test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.bs.theme.bob.adapter.adaptee.SWIFTSwiftInAdaptee;


public class BreakString {

	private final static Logger logger = Logger.getLogger(SWIFTSwiftInAdaptee.class);

	public static void main(String[] args) {

		logger.debug(TimeUnit.SECONDS.toMillis(30));

		String[] ds = splitStringByCharCount("PRASATH is a good boy", 10);
		// logger.debug(ds[0]);
		// logger.debug(ds[1]);
		// logger.debug(ds[2]);
		String vd = ds[0] + "\n" + ds[1] + "\n" + ds[2];
		logger.debug("DFG:" + vd);

		// List<String> ds = getParts("PRASATH is a good boy", 10);
		// String vd = ds[0] + "\n" + ds[1] + "\n" + ds[2];
	}

	public static String[] splitStringByCharCount(String s, int interval) {
		int arrayLength = (int) Math.ceil(((s.length() / (double) interval)));
		String[] result = new String[arrayLength];

		int j = 0;
		int lastIndex = result.length - 1;
		for (int i = 0; i < lastIndex; i++) {
			result[i] = s.substring(j, j + interval);
			j += interval;
		} // Add the last bit
		result[lastIndex] = s.substring(j);

		return result;
	}

	// /**
	// *
	// * @param string
	// * @param partitionSize
	// * @return
	// */
	// private static List<String> getParts(String string, int partitionSize) {
	//
	// StringBuilder strBuild = new StringBuilder();
	// List<String> parts = new ArrayList<String>();
	// int len = string.length();
	// for (int i = 0; i < len; i += partitionSize) {
	// parts.add(string.substring(i, Math.min(len, i + partitionSize)));
	// String sd = string.substring(i, Math.min(len, i + partitionSize));
	// // logger.debug(sd);
	// // logger.debug(parts);
	// // strBuild.append(sd);
	// }
	// return parts;
	// // return strBuild.toString();
	// }
	//
	// /**
	// *
	// * @param string
	// * @param partitionSize
	// * @return
	// */
	// private static String getPartsString(String string, int partitionSize) {
	//
	// StringBuilder strBuild = new StringBuilder();
	// // List<String> parts = new ArrayList<String>();
	// int len = string.length();
	// for (int i = 0; i < len; i += partitionSize) {
	// // parts.add(string.substring(i, Math.min(len, i + partitionSize)));
	// String sd = string.substring(i, Math.min(len, i + partitionSize));
	// // logger.debug(sd);
	// // logger.debug(parts);
	// strBuild.append(sd);
	// }
	// // return parts;
	// return strBuild.toString();
	// }

}
