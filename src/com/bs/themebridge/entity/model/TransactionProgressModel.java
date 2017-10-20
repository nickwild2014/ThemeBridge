package com.bs.themebridge.entity.model;

public class TransactionProgressModel {

	public String zone;
	public String totalcount;
	public String successcount;
	public String failedcount;

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(String totalcount) {
		this.totalcount = totalcount;
	}

	public String getSuccesscount() {
		return successcount;
	}

	public void setSuccesscount(String successcount) {
		this.successcount = successcount;
	}

	public String getFailedcount() {
		return failedcount;
	}

	public void setFailedcount(String failedcount) {
		this.failedcount = failedcount;
	}

}
