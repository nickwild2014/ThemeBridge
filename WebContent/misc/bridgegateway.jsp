<%-- 
  - Author:		 PRASATH RAVICHANDRAN
  - Date:		 2016-06-20  
  - Bank:		 Kotak Mahindra Bank Ltd.,
  - Description: BridgeGateway testing
--%>
<%@page import="java.util.UUID"%>
<%@page import="com.bs.themebridge.util.ThemeBridgeUtil"%>
<%@page import="com.bs.themebridge.util.ThemeBridgeSimulator"%>
<%@page import="com.bs.themebridge.server.gateway.in.BridgeGateway"%>
<%@page
	import="com.bs.themebridge.entity.servlet.util.VerificationAdapterImpl"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!--@author Prasath Ravichandran @date 2016-SEP-26 @Kotak Mahindra Bank-->
<title>BridgeGateway</title>
<link rel="shortcut icon" href="../images/custom/browserlogo.png">
<link href="../css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link type="text/css" rel="stylesheet"
	href="../css/daterangepicker-bs3.css" />
<link type="text/css" rel="stylesheet"
	href="../css/jquery.dataTables.css" />
<link type="text/css" rel="stylesheet"
	href="../css/jquery-ui.datepicker.css" />
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/dataTables.bootstrap.css" rel="stylesheet">
<link href="../css/customized.css" rel="stylesheet">

<script type="text/javascript" src="../js/respond.js"></script>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="../js/moment.js"></script>
<script type="text/javascript" src="../js/daterangepicker.js"></script>
<script type="text/javascript" src="../js/jquery.dataTables.js"></script>
<script type="text/javascript" src="../js/custom.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		removeAllActiveMenu();
		addActiveMenu("misc");
	});
</script>

<%
	String inputXML = "";
	String responseXML = "";
	if (request.getParameter("input") != null) {
		inputXML = request.getParameter("input");
		responseXML = ThemeBridgeSimulator.processBridgeGatewaySimulator(request.getParameter("input"));
	}
%>

<%-- <%
	boolean error = false;
	String responseXML = "";
	String inputXML = request.getParameter("input");
	// out.println("requestInput ->" + inputXML);	
	if (inputXML != null && !inputXML.isEmpty()) {
		String pswd = request.getParameter("pswd");
		// out.println("pswd ->" + request.getParameter("input"));
		// boolean psd = VerificationAdapterImpl.verify(pswd);
		boolean psd = true;
		if (psd) {
			responseXML = ThemeBridgeSimulator.processBridgeGatewaySimulator(request.getParameter("input"));
		} else {
			error = true;
		}
	}
%> --%>

</head>
<body>

	<div class="col-md-12">
		<jsp:include page="primarymenubar.jsp" />
		<%-- <jsp:include page="include_header.jsp" /> --%>
	</div>

	<div class="container">
		<!-- <div class="row horizontal-line">
			<div class="col-lg-11 col-md-11 col-sm-11">
				<h3>BridgeGateway Request Handler</h3>
			</div>
		</div> -->
		<%-- <%
			if (error) {
		%>
		<br>
		<div class="row">
			<div class="alert alert-danger col-sm-12">Invalid password!</div>
		</div>
		<%
			}
		%> --%>
		<div class="row">
			<div class="col-sm-12 col-md-12 col-lg-12">
				<!-- <div class="row"> -->
				<form method="POST" action="">
					<div class="col-sm-6">
						<h4>BridgeGateway Request</h4>
						<!-- <h4 style="color:#00aed7;"><font face="Times new roman">Request</font></h4> -->
						<textarea name="input" rows="25" cols="80" spellcheck="false"
							placeholder="Bridge gateway request XML" class="form-control"><%=inputXML%></textarea>
					</div>
					<div class="col-sm-1">
						<input class="btn btn-warning butpos" type="submit" value="Submit" />
						<!-- <br> <br> <input class="form-control" type="password"
							name="pswd" id="pswd" placeholder="pswd" required /> <br> <input
							class="btn btn-danger" type="reset" value="ClearAll" /> -->
					</div>
					<div class=" col-sm-5">
						<h4>BridgeGateway Response</h4>
						<textarea name="response" rows="25" cols="80" spellcheck="false"
							placeholder="Bridge gateway response XML" class="form-control"><%=responseXML%></textarea>
					</div>
				</form>
				<!-- </div> -->
			</div>
		</div>
	</div>
</body>
</html>