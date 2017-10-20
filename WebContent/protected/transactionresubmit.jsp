<%-- 
  - Author:		 PRASATH RAVICHANDRAN
  - Date:		 2016-06-20  
  - Bank:		 Kotak Mahindra Bank Ltd.,
  - Description: Resubmit transaction posting and exposure   
--%>
<%@page import="java.util.List"%>
<%@page import="java.lang.String"%>
<%@page import="com.bs.themebridge.util.ThemeBridgeUtil"%>
<%@page
	import="com.bs.theme.bob.adapter.adaptee.BackOfficeBatchResubmit"%>
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
			BackOfficeBatchResubmit obj = new BackOfficeBatchResubmit();
			obj.doResubmitPosting(id);
			response.sendRedirect("transactionlog.jsp");
		}
	%>
</body>
</html>
