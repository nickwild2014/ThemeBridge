package com.test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Currency;
import java.util.LinkedList;
import java.util.Locale;

import org.apache.log4j.Logger;

import com.bs.themebridge.util.ThemeBridgeUtil;
import com.bs.themebridge.util.ValidationsUtil;

public class NumberFormatting {

	private final static Logger logger = Logger.getLogger(NumberFormatting.class.getName());

	public static void main(String[] args) {

		// String testStr = "< > \" &";
		// String testStr = "<?xml version='1.0' encoding='UTF-8'?>
		// <ServiceRequest xmlns='urn:control.services.tiplus2.misys.com'
		// xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'
		// xmlns:m='urn:messages.service.ti.apps.tiplus2.misys.com'
		// xmlns:c='urn:common.service.ti.apps.tiplus2.misys.com'
		// xmlns:ns4='urn:custom.service.ti.apps.tiplus2.misys.com'>
		// <RequestHeader> <Service>TI</Service> <Operation>Customer</Operation>
		// <Credentials> <Name>SUPERVISOR</Name> </Credentials>
		// <ReplyFormat>FULL</ReplyFormat> <NoRepair>Y</NoRepair>
		// <NoOverride>Y</NoOverride>
		// <CorrelationId>d678a0b0-b729-4693-93cf-71eddf3179ee</CorrelationId>
		// <TransactionControl>NONE</TransactionControl> </RequestHeader>
		// <m:Customer> <m:MaintType>F</m:MaintType>
		// <m:MaintainedInBackOffice>N</m:MaintainedInBackOffice>
		// <m:SourceBankingBusiness>0001</m:SourceBankingBusiness>
		// <m:Mnemonic>100890332</m:Mnemonic>
		// <m:CustomerNumber>100890332</m:CustomerNumber>
		// <m:CustomerType>EA</m:CustomerType> <m:FullName>PARDHAJANARDHANA
		// GUPTA GODE</m:FullName> <m:ShortName>PARDHAJANARDHAN</m:ShortName>
		// <m:ResidenceCountry>IN</m:ResidenceCountry>
		// <m:ParentCountry>IN</m:ParentCountry> <m:Language>GB</m:Language>
		// <m:AddressDetails> <m:AddressDetail> <m:AddressType>P</m:AddressType>
		// <m:Email>customer@mail.com</m:Email>
		// <m:TransferMethod>01</m:TransferMethod> </m:AddressDetail>
		// </m:AddressDetails> <m:CustomerExtraData> <ns4:LOB>R & L</ns4:LOB>
		// <ns4:EMAILAD1>customer@mail.com</ns4:EMAILAD1>
		// <ns4:EMAILAD2>customer@mail.com</ns4:EMAILAD2>
		// <ns4:EMAILAD3>customer@mail.com</ns4:EMAILAD3>
		// <ns4:PANNO_Name>AFDPG0258G</ns4:PANNO_Name>
		// <ns4:CIFM_Name>100890332</ns4:CIFM_Name>
		// <ns4:SOLID_Name>646</ns4:SOLID_Name> </m:CustomerExtraData>
		// </m:Customer> </ServiceRequest>";
		// logger.debug("Original : " + testStr);
		// logger.debug("Escaped : " +
		// StringEscapeUtils.escapeHtml(testStr));

		// double amount = 200.0;
		// logger.debug(NumberFormat.getCurrencyInstance(new Locale("en",
		// "IN")).format(amount));

		/** SUPERB **/
		double amount = 200;
		DecimalFormat twoPlaces = new DecimalFormat("0.00");
		logger.debug(twoPlaces.format(amount));
		String x = twoPlaces.format(amount);
		logger.debug(x);

		// currencyRoundOffValue(amount, "USD");

		// testGetNumberFormatForCurrencyCode("USD", 1234.23434);
		// logger.debug(getNumberFormat("USD"));
		// logger.debug(CurrencyRoundOffValue("22222222222222222444888.1223"));
	}

	/**
	 * Remove e^9 values in while multiplication
	 * 
	 * @param amountStr
	 */
	public static String CurrencyRoundOffValue(String amountStr) {

		String roundOffINRValue = "";
		try {
			// String convertedAmount = "22222222222222222444888.86559997";
			BigDecimal bigDecimalValue = new BigDecimal(amountStr);

			// Define Formatter
			DecimalFormat diff = new DecimalFormat("#.##"); // "0.00"
			diff.setMaximumFractionDigits(2);

			// Round Off big decimal value
			roundOffINRValue = diff.format(bigDecimalValue);

		} catch (Exception e) {
			roundOffINRValue = amountStr;
			logger.debug("Exceptions..! " + e.getMessage());
			// String finalval = String.format("%.2f", convertedAmount);
		}

		// logger.debug("roundOffValue : " + roundOffINRValue);
		return roundOffINRValue;
	}

	public static String currencyRoundOffValue(BigDecimal amountstr, String postingCurrency) {

		// BigDecimal bd = new BigDecimal("200");
		// double amount = 200;
		/** SUPERB **/
		DecimalFormat twoPlaces = new DecimalFormat("0.00");
		// String roundedValue = twoPlaces.format(amountstr); // double
		String roundedValue = twoPlaces.format(amountstr); // BigDecimal
		// logger.debug(roundedValue);

		return roundedValue;
	}

	/**
	 * DONT USE KOTAK BANK
	 * 
	 * @param ccy
	 * @param d
	 */
	public static void testGetNumberFormatForCurrencyCode(String ccy, double d) {
		NumberFormat format = NumberFormat.getInstance();
		format.setMaximumFractionDigits(3);
		Currency currency = Currency.getInstance(ccy);
		format.setCurrency(currency);

		logger.debug(format.format(d));
	}

	/**
	 * 
	 * @param currencyCode
	 * @return
	 */
	private static NumberFormat getNumberFormat(String currencyCode) {
		Currency currency = Currency.getInstance(currencyCode);

		Locale[] locales = NumberFormat.getAvailableLocales();

		for (Locale locale : locales) {
			NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);

			if (numberFormat.getCurrency() == currency)
				return numberFormat;
		}

		return null;
	}

	private static Collection<Locale> getLocalesFromIso4217(String iso4217code) {
		Collection<Locale> returnValue = new LinkedList<Locale>();
		for (Locale locale : NumberFormat.getAvailableLocales()) {
			String code = NumberFormat.getCurrencyInstance(locale).getCurrency().getCurrencyCode();
			if (iso4217code.equals(code)) {
				returnValue.add(locale);
			}
		}
		return returnValue;
	}

	// tranAmount = exposureAmount.replaceAll("[^0-9.]", "");
	// String amountCcy = exposureAmount.replaceAll("[^A-Z]", "");

	/**
	 * Changed by faizal on 13-08-2015 New changes done
	 * 
	 * @param amount
	 * @return
	 */
	public static String getAmountWithPadding(String amount) {

		String result = "";
		if (ValidationsUtil.isValidString(amount)) {

			String format = "%015d";
			amount = amount.replace(".", "");
			amount = amount.replace("-", "");
			result = String.format(format, new BigInteger(amount));
		} else {
			result = "000000000000000";
		}
		logger.debug("Result : " + result);
		return result;
	}

	/**
	 * INPUT 1,000.00 USD OUTPUT 1000 AVAILABLE BALANCE
	 * 
	 * @param amount
	 *            {@code allows } {@link String}
	 * @return
	 */
	public static String getAmountValues(String amount) {

		String result = "";
		amount = amount.replace(",", "");
		amount = amount.replaceAll("\\s+", "");
		amount = amount.replaceAll("[^0-9 , .]", "");
		// BigDecimal result = new BigDecimal(amount);
		result = amount;

		return result;
	}

	/**
	 * 
	 * @param amount
	 * @param currency
	 * @return
	 */
	public String getTransactionAmount(String amount, String currency) {

		String result = "";
		BigDecimal transAmount = new BigDecimal(amount);

		if (currency.equals("OMR") || currency.equals("BHD") || currency.equals("KWD") || currency.equals("JOD")) {
			result = transAmount.divide(new BigDecimal(1000), 3, RoundingMode.CEILING).toString();
		} else if (currency.equals("JPY")) {
			result = amount;
		} else {
			result = transAmount.divide(new BigDecimal(100), 2, RoundingMode.CEILING).toString();
		}

		return result.trim();
	}

	/**
	 * <i> To check the balance </i>
	 * 
	 * @param amount
	 *            {@code allows }{@link String}
	 * @return {@code amount }
	 */
	public static String getAmountWithPaddingNoDecimal(String amount) {
		String result = "";
		if (ValidationsUtil.isValidString(amount)) {
			amount = amount.replace(".", "");
			amount = amount.replace("-", "");
			if (amount.length() > 15) {
				result = amount.substring(0, 15);
			} else {
				String format = "%015d";
				result = String.format(format, new BigInteger(amount));
			}
		}
		return result;
	}

	/**
	 * Convert amount format string to number format string
	 * <i> {@code i.e., 123,456.00 as 12,345600 } </i>
	 * 
	 * @param numberString
	 *            {@code allows } {@link String}
	 * @return {@link String}
	 */
	public static String removeAmountStringDotSpecification(String numberString) {
		if (ValidationsUtil.isValidString(numberString)) {
			Double amount = Double.parseDouble(numberString);
			amount = (amount * 100);
			numberString = new DecimalFormat("0.00").format(amount);
			if (numberString.contains(".") && numberString.indexOf(".") != 0) {
				numberString = numberString.substring(0, numberString.indexOf("."));
			} else {
				// do nothing
			}
		}
		return numberString;
	}

	/**
	 * Convert amount format string to number format string
	 * <i> {@code i.e., 123,456.00 as 123456.00 } </i>
	 * 
	 * @param numberString
	 *            {@code allows } {@link String}
	 * @return {@link String}
	 */
	public static String removeAmountStringCommaSpecification(String numberString) {
		if (ValidationsUtil.isValidString(numberString)) {
			if (numberString.contains(",") && numberString.indexOf(",") != 0) {
				numberString = numberString.replace(",", "");
			} else {
				// do nothing
			}
		}
		return numberString;
	}

	/**
	 * Convert amount format string to number format string
	 * <i> {@code i.e., 123,456.00 as 12345600 } </i>
	 * 
	 * @param numberString
	 *            {@code allows } {@link String}
	 * @return {@link String}
	 */
	public static String removeAmountStringDotAndCommaSpecification(String numberString) {
		if (ValidationsUtil.isValidString(numberString)) {
			numberString = removeAmountStringDotSpecification(numberString);
			numberString = removeAmountStringCommaSpecification(numberString);
		}
		return numberString;
	}

	/**
	 * Pad with "0" and make the out put string to contain 15chars. handles
	 * decimals of currency based on the input.
	 */
	public static String getAmountWithPadding2(String amount) {
		String result = "";
		String format = "";
		if (amount.indexOf('.') < 0) {
			format = "%015d";
			result = String.format(format, new BigInteger(amount));
		} else {
			String decimals = amount.substring(amount.indexOf('.') + 1).length() + "";
			format = "%015." + decimals + "f";
			Float floatNumber = Float.parseFloat(amount);
			result = String.format(format, floatNumber);
		}
		return result;
	}

	/**
	 * Check double amount with two precision <br>
	 * Note: This function do DecimalFormat calculation </br>
	 * 
	 * @return {@link String}
	 */
	public static Double getAmountAsDoubleWithTwoPrecision(Double value) {
		Double aDouble = Double.parseDouble(new DecimalFormat("0.00").format(value));
		return aDouble;
	}

	/**
	 * Check double amount with custom precision <br>
	 * Note: This function do DecimalFormat calculation </br>
	 * 
	 * @return {@link String}
	 */
	public static Double getAmountAsDoubleWithCustomPrecision(Double value, int decimalPrecision) {
		String decimal = "0.";
		if (ValidationsUtil.isValidObject(decimalPrecision)) {
			for (int i = 0; i < decimalPrecision; i++) {
				decimal += "0";
			}
		}
		Double aDouble = Double.parseDouble(new DecimalFormat(decimal).format(value));
		return aDouble;
	}

	/**
	 * Check double amount with two precision <br>
	 * Note: This function do Math.round(*) calculation </br>
	 * 
	 * @return {@link String}
	 */
	public static Double getAmountWithTwoPrecision(Double value) {
		Double result = Math.round(value * 100.0) / 100.0;
		return result;
	}

	/**
	 * Check double amount with custom precision <br>
	 * Note: This function do Math.round(*) calculation </br>
	 * 
	 * @return {@link String}
	 */
	public static Double getAmountWithCustomPrecision(Double value, int decimalPrecision) {
		Double denominator = 1d;
		if (ValidationsUtil.isValidObject(decimalPrecision)) {
			String amount = "1";
			for (int i = 1; i <= decimalPrecision; i++) {
				amount += "0";
			}
			denominator = denominator * Double.parseDouble(amount);
		}
		Double result = Math.round(value * denominator) / denominator;
		return result;
	}

	/**
	 * 
	 */
	public static void getDouble() {
		// TODO Auto-generated method stub

		long longValue = Double.valueOf("4.776387132E7").longValue();
		// logger.debug(longValue);

		BigDecimal bd = new BigDecimal("4.776387132E7");// 4.776387132E7,
														// //9.18E+09
		long val = bd.longValue();
		// logger.debug(val);

		double d3 = Double.parseDouble("9.78313E+2");
		// logger.debug(d3);
	}

	public static void Numbers() {

		double myvalue = 0.00000021d;

		// Option 1 Print bare double.
		// logger.debug(myvalue);

		// Option2, use decimalFormat.
		DecimalFormat df = new DecimalFormat("#");
		df.setMaximumFractionDigits(8);
		// logger.debug(df.format(myvalue));

		// Option 3, use printf.
		// logger.debug("%.9f", myvalue);
		// logger.debug();

		// Option 4, convert toBigDecimal and ask for toPlainString().
		// logger.debug(new BigDecimal(myvalue).toPlainString());
		// logger.debug();

		// Option 5, String.format
		// logger.debug(String.format("%.12f", myvalue));
	}

	/**
	 * Convert amount format string to number format string
	 * <i> {@code i.e., 123,456.00 as 123456.00 } </i>
	 * 
	 * @param numberString
	 *            {@code allows } {@link String}
	 * @return {@link String}
	 */
	public static String convertAmountStringToNumberStringFormat(String numberString) {
		if (ValidationsUtil.isValidString(numberString)) {
			numberString = numberString.replace(",", "");
		}
		return numberString;
	}

}
