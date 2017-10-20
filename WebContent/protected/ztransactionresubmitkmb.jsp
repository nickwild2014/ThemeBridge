<%@page import="java.util.List"%>
<%@page import="java.lang.String"%>
<%@page import="com.bs.themebridge.util.ThemeBridgeUtil"%>
<%@page
	import="com.bs.theme.bob.adapter.adaptee.BackOfficeBatchAdaptee"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Transaction Data</title>
<!--@author Prasath Ravichandran @date 2016-SEP-26 @Kotak Mahindra Bank-->
</head>
<body>
	<%
		if (request.getParameter("id") != null) {
			String id = request.getParameter("id");
			out.println("Resubmit id : " + id);
			BackOfficeBatchAdaptee obj = new BackOfficeBatchAdaptee();
			// obj.doResubmitPosting(id);
			response.sendRedirect("ztransactionlogkmb.jsp");
		}
	%>
</body>
</html>
