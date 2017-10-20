package com.bs.themebridge.util;

public enum ThemeBridgeStatusEnum {

	SUCCEEDED, FAILED, QUEUED, ERROR, RECEIVED, PROCESSED, SUBMITTED, RESUBMITTED, SUPPRESSED, WAITING, AWAITING, TRANSMITTED;

	public String value() {
		return name();
	}

	public static ThemeBridgeStatusEnum fromValue(String v) {
		return valueOf(v);
	}

}
