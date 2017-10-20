package com.bs.themebridge.dashboard;

public class InterfaceStatus {

	int errorCount = 0;
	int queuedCount = 0;
	int failureCount = 0;
	int receivedCount = 0;
	int succededCount = 0;
	int suppressedCount = 0;
	int transmittedCount = 0;
	int unavailableCount = 0;

	public int getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(int errorCount) {
		this.errorCount = errorCount;
	}

	public int getQueuedCount() {
		return queuedCount;
	}

	public void setQueuedCount(int queuedCount) {
		this.queuedCount = queuedCount;
	}

	public int getFailureCount() {
		return failureCount;
	}

	public void setFailureCount(int failureCount) {
		this.failureCount = failureCount;
	}

	public int getReceivedCount() {
		return receivedCount;
	}

	public void setReceivedCount(int receivedCount) {
		this.receivedCount = receivedCount;
	}

	public int getSuccededCount() {
		return succededCount;
	}

	public void setSuccededCount(int succededCount) {
		this.succededCount = succededCount;
	}

	public int getSuppressedCount() {
		return suppressedCount;
	}

	public void setSuppressedCount(int suppressedCount) {
		this.suppressedCount = suppressedCount;
	}

	public int getTransmittedCount() {
		return transmittedCount;
	}

	public void setTransmittedCount(int transmittedCount) {
		this.transmittedCount = transmittedCount;
	}

	public int getUnavailableCount() {
		return unavailableCount;
	}

	public void setUnavailableCount(int unavailableCount) {
		this.unavailableCount = unavailableCount;
	}

}
