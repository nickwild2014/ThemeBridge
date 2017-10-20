package com.bs.themebridge.xpath;

public class LimitTreeViewXpath {

	public static final String ErrorTypeXpath = "/FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorType";

	public static final String HostStatausXpath = "FIXML/Header/ResponseHeader/HostTransaction/Status";
	public static final String FacilityStatausXpath = "FIXML/Body/executeFinacleScriptResponse/executeFinacleScript_CustomData/STATUS";

	// System Error description
	public static final String treeViewExDescXpath = "/FIXML/Body/executeFinacleScriptResponse/executeFinacleScript_CustomData/ErrorDetail/ErrorDesc";
	public static final String treeViewExCodeXpath = "/FIXML/Body/executeFinacleScriptResponse/executeFinacleScript_CustomData/ErrorDetail/ErrorCode";

	public static final String FISystemExCodeXpath = "/FIXML/Body/Error/FISystemException/ErrorDetail/ErrorCode";
	public static final String FISystemExErrorMsgDescXpath = "/FIXML/Body/Error/FISystemException/ErrorDetail/ErrorDesc";

	// Business Error description
	public static final String FIBusinessExCodeXpath = "/FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorCode";
	public static final String FIBusinessExMsgDescXpath = "FIXML/Body/Error/FIBusinessException/ErrorDetail/ErrorDesc";

	// Failure
	public static final String FIScriptResponseExCodeXpath = "/FIXML/Body/executeFinacleScriptResponse/executeFinacleScript_CustomData/Error_Code";
	public static final String FIScriptResponseExMsgDescXpath = "/FIXML/Body/executeFinacleScriptResponse/executeFinacleScript_CustomData/Error_Msg";

	/** Get Bank Response **/
	public static final String Status = "FIXML/Header/ResponseHeader/HostTransaction/Status";

}
