package com.test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;

import org.apache.log4j.Logger;

import com.bs.themebridge.util.DatabaseUtility;

/**
 * @since 2016-November-26
 * @version 1.01
 * @author Prasath Ravichandran
 *
 */
public class NumbersConversion {

	private final static Logger logger = Logger.getLogger(NumbersConversion.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// StringLong();
		// StringAll();
		// SringBigDecimal();
		// StringBigDecimal();
		// BigDecimalLong();
		// StringAllConversion();

		// as();

		getDecimalforCurrency("USD");
	}

	public static String as() {

		// String Double
		String str2 = "50100.00";
		double d = Double.parseDouble(str2);
		logger.debug("double d : " + d * 100);// 1025550.2223
		d = d * 100;
		String DoubleString = String.valueOf(d);
		logger.debug("DoubleString : " + DoubleString);

		// String BigDecimal
		// String str4 = "12222223299999999912323.23";
		String str4 = "50100.00";
		BigDecimal bd = new BigDecimal(str4);
		// logger.debug("BigDecimal bd : " + bd);
		// logger.debug();

		// BigDecimal bd1 = bd * bd;

		String BigDecimalString = String.valueOf(bd);
		// logger.debug("BigDecimalString : " + BigDecimalString);

		return BigDecimalString;

	}

	public static void doubleLong() {

		double d = 1234.56;
		long l = Math.round(d);
		logger.debug("Long " + l);
	}

	public static void BigDecimalLong() {

		BigDecimal bg1 = new BigDecimal("429.07");
		logger.debug("Bigdecimal bd1 : " + bg1);

		long l1 = bg1.longValue();
		logger.debug("Long l1 : " + l1);
	}

	public static long StringLong(String str1) {

		// String str1 = "1025222222250.123";
		str1 = str1.replace(".", "");

		long l = Long.parseLong(str1);
		// logger.debug("Long l : " + l);

		String LongStr = String.valueOf(l);
		// logger.debug("LongString : " + LongStr);

		return l;
	}

	public static double getDecimalforCurrency(String ccy) {

		double decimlValue = 0.0;
		Connection conn = null;
		PreparedStatement prpdStmt = null;
		ResultSet res = null;
		try {
			conn = DatabaseUtility.getTizoneConnection();
			String query = "select power(10,C8CED) from C8PF where trim(c8ccy)='" + ccy + "'";
			// logger.debug("Qurey is " + query);
			prpdStmt = conn.prepareStatement(query);
			res = prpdStmt.executeQuery();
			if (res.next()) {
				decimlValue = res.getDouble(1);
			}

		} catch (Exception e) {
			logger.debug("exception is " + e.getMessage());
		}

		finally {
			DatabaseUtility.surrenderConnection(conn, prpdStmt, res);
		}

		return decimlValue;
	}

	public static void StringAllConversion() {

		// String Float
		String str1 = "1025250.223";
		float f = Float.parseFloat(str1);// 102550.23
		logger.debug("Float f : " + f);
		String FloatString = String.valueOf(f);
		logger.debug("FloatString : " + FloatString);

		// String Double
		String str2 = "102525.00";
		double d = Double.parseDouble(str2);
		logger.debug("double d : " + d);// 1025550.2223
		String DoubleString = String.valueOf(d);
		logger.debug("DoubleString : " + DoubleString);

		// String Long
		String str3 = "20000"; // 20000.00
		long l = Long.parseLong(str3);
		logger.debug("Long l : " + l);
		String LongString = String.valueOf(l);
		logger.debug("DoubleString : " + LongString);

		// String BigDecimal
		String str4 = "12222223299999999912323.23";
		BigDecimal bd = new BigDecimal(str4);
		logger.debug("BigDecimal bd : " + bd);
		String BigDecimalString = String.valueOf(bd);
		logger.debug("BigDecimalString : " + BigDecimalString);

		// String integer
		String str5 = "1000";
		int i = Integer.parseInt(str5);
		logger.debug("Integer i : " + i);
		String IntegerString = String.valueOf(i);
		logger.debug("IntegerString : " + IntegerString);

	}

	/**
	 * Remove e^9 values in while multiplication
	 * 
	 * @param amountStr
	 */
	public static void CurrencyRoundOffValue(String amountStr) {

		String roundOffValue = "";
		try {
			// String convertedAmount = "22222222222222222444888.86559997";
			BigDecimal bigDecimalValue = new BigDecimal(amountStr);

			// Define Formatter
			DecimalFormat diff = new DecimalFormat("#.##"); // "0.00"
			diff.setMaximumFractionDigits(2);

			// Round Off big decimal value
			roundOffValue = diff.format(bigDecimalValue);

		} catch (Exception e) {
			logger.debug("Exceptions..! " + e.getMessage());

		}

		logger.debug("roundOffValue : " + roundOffValue);
	}

	public static long floatLong() {

		String limitAmount = "23.56";
		float limitAmount_flot = Float.valueOf(limitAmount);
		long limitAmountlong = (long) limitAmount_flot;
		logger.debug("LimitAmountInteger : " + limitAmount + "\t" + limitAmountlong);

		return limitAmountlong;
	}

	public static long DoubleInt() {

		String limitAmount = "23.56";
		Double obj = new Double(limitAmount);
		int limitAmountInteger = obj.intValue();
		logger.debug("limitAmountInteger : " + limitAmount + "\t" + limitAmountInteger);

		return limitAmountInteger;
	}
}
