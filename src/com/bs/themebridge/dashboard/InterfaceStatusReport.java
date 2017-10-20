package com.bs.themebridge.dashboard;

/**
 * 
 * @author Prasath Ravichandran
 *
 */
public class InterfaceStatusReport {

	String totalLogChartValue = "";
	String serviceLogChartValue = "";
	String staticDataLogChartValue = "";
	String transactionLogChartValue = "";
	String stagingDataLogChartValue = "";

	InterfaceStatus totalLogReport;
	InterfaceStatus staticDataReport;
	InterfaceStatus serviceLogReport;
	InterfaceStatus stagingDataReport;
	InterfaceStatus transactionLogReport;

	public String getStagignDataLogChartValue() {
		return stagingDataLogChartValue;
	}

	public void setStagingDataLogChartValue(String stagingDataLogChartValue) {
		this.stagingDataLogChartValue = stagingDataLogChartValue;
	}

	public InterfaceStatus getStagingDataReport() {
		return stagingDataReport;
	}

	public void setStagingDataReport(InterfaceStatus stagingDataReport) {
		this.stagingDataReport = stagingDataReport;
	}

	public String getStaticDataLogChartValue() {
		return staticDataLogChartValue;
	}

	public void setStaticDataLogChartValue(String staticDataLogChartValue) {
		this.staticDataLogChartValue = staticDataLogChartValue;
	}

	public String getServiceLogChartValue() {
		return serviceLogChartValue;
	}

	public void setServiceLogChartValue(String serviceLogChartValue) {
		this.serviceLogChartValue = serviceLogChartValue;
	}

	public String getTransactionLogChartValue() {
		return transactionLogChartValue;
	}

	public void setTransactionLogChartValue(String transactionLogChartValue) {
		this.transactionLogChartValue = transactionLogChartValue;
	}

	public InterfaceStatus getStaticDataReport() {
		return staticDataReport;
	}

	public void setStaticDataReport(InterfaceStatus staticDataReport) {
		this.staticDataReport = staticDataReport;
	}

	public InterfaceStatus getServiceLogReport() {
		return serviceLogReport;
	}

	public void setServiceLogReport(InterfaceStatus serviceLogReport) {
		this.serviceLogReport = serviceLogReport;
	}

	public InterfaceStatus getTransactionLogReport() {
		return transactionLogReport;
	}

	public void setTransactionLogReport(InterfaceStatus transactionLogReport) {
		this.transactionLogReport = transactionLogReport;
	}

	@Override
	public String toString() {
		return "InterfaceStatusReport [staticDataLogChartValue=" + staticDataLogChartValue + ", serviceLogChartValue="
				+ serviceLogChartValue + ", transactionLogChartValue=" + transactionLogChartValue
				+ ", stagingDataLogChartValue=" + stagingDataLogChartValue + ", totalLogChartValue="
				+ totalLogChartValue + ", staticDataReport=" + staticDataReport + ", serviceLogReport="
				+ serviceLogReport + ", transactionLogReport=" + transactionLogReport + ", totalLogReport="
				+ totalLogReport + ", stagingDataReport=" + stagingDataReport + "]";
	}

}
