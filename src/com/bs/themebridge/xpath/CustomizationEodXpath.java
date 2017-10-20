package com.bs.themebridge.xpath;

public class CustomizationEodXpath {

	/** Get TI Request **/
	public static String ServiceXPath = "ServiceRequest/RequestHeader/Service";
	public static String OperationXPath = "ServiceRequest/RequestHeader/Operation";
	public static String TargetSystemXPath = "ServiceRequest/RequestHeader/TargetSystem";
	public static String SourceSystemXPath = "ServiceRequest/RequestHeader/SourceSystem";
	public static String ProcessMessage = "ServiceRequest/ProcessStartRequest/Message";

	// New Start Of Day
	public static String ACTION = "ServiceRequest/BatchJobs/Action";
	public static String MESSAGE = "ServiceRequest/BatchJobs/Message";
	public static String STEPTASK = "ServiceRequest/BatchJobs/StepTask";
	public static String STEPPHASE = "ServiceRequest/BatchJobs/StepPhase";
	public static String SHORTNAME = "ServiceRequest/BatchJobs/ShortName";
	public static String PROCDATE = "ServiceRequest/BatchJobs/ProcDate";
}
