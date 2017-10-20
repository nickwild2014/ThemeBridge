<%-- 
  - Author:		 PRASATH RAVICHANDRAN
  - Date:		 2016-06-20  
  - Bank:		 Kotak Mahindra Bank Ltd.,
  - Description: SWIFT/SFMS IN/OUT Gateway testing
--%>
<%@page import="java.util.Map"%>
<%@page import="java.lang.String"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.bs.themebridge.util.ThemeBridgeUtil"%>
<%@page import="com.bs.theme.bob.adapter.sfms.SFMSInwardMessageAdaptee"%>
<%@page import="com.bs.theme.bob.adapter.adaptee.SWIFTSwiftInAdaptee"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<title>Push swift message MQ</title>
<!--@author Prasath Ravichandran @date 2016-SEP-26 @Kotak Mahindra Bank-->
<link rel="shortcut icon" href="../images/custom/browserlogo.png">
<link type="text/css" href="../css/bootstrap.min.css" rel="stylesheet" />
<link type="text/css" href="../css/daterangepicker-bs3.css"
	rel="stylesheet" />
<link type="text/css" href="../css/jquery.dataTables.css"
	rel="stylesheet" />
<link type="text/css" href="../css/jquery-ui.datepicker.css"
	rel="stylesheet" />
<link type="text/css" href="../css/bootstrap.min.css" rel="stylesheet" />
<link type="text/css" href="../css/dataTables.bootstrap.css"
	rel="stylesheet">
<link href="../css/customized.css" rel="stylesheet" />

<script type="text/javascript" src="../js/respond.js"></script>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/moment.js"></script>
<script type="text/javascript" src="../js/daterangepicker.js"></script>
<script type="text/javascript" src="../js/jquery.dataTables.js"></script>
<script type="text/javascript" src="../js/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="../js/custom.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		removeAllActiveMenu();
		addActiveMenu("misc");
		$('#configuration').dataTable({
			"sDom" : "<'row'>t<'row'<'col-xs-6'i><'col-xs-6'p>>",
			"iDisplayLength" : 50,
			"bFilter" : false,
			"bSortClasses" : false,
			"bSort" : true,
			"columnDefs" : [ {
				//"targets" : [ 0 ],
				"visible" : false,
				"searchable" : false
			} ],
			"order" : [ [ 0, "asc" ] ]
		});

	});
</script>
</head>
<body>

	<%
		String serviceParameter = request.getParameter("type");
		// out.println("TEST : " + serviceParameter);
		String mqName = "";
		String swiftMessage = "";
		String swiftOutJndiName = "";
		Boolean swiftoutQueuePostingStatus = false;
		if (request.getParameter("swiftMessage") != null) {
			mqName = request.getParameter("mqName");
			swiftMessage = request.getParameter("swiftMessage");
			swiftOutJndiName = request.getParameter("swiftOutJndiName");
			// swiftoutQueuePostingStatus = MQMessageManager.pushMqMessage(swiftOutJndiName, mqName, swiftMessage);

			if (serviceParameter.equals("SFMSIN")) {
				SFMSInwardMessageAdaptee msgObj = new SFMSInwardMessageAdaptee();
				swiftoutQueuePostingStatus = msgObj.processSFMSInMessages(swiftMessage, "$", "DEF");

			} else if (serviceParameter.equals("SWIFTIN")) {
				SWIFTSwiftInAdaptee msgObj2 = new SWIFTSwiftInAdaptee();
				swiftoutQueuePostingStatus = msgObj2.processSwiftInMessages(swiftMessage, "$", "DEF");
			}
		}

		String sfmsinSelected = "";
		String swiftinSelected = "";
		if (serviceParameter == null)
			serviceParameter = "";
		if (serviceParameter.trim().equals("SFMSIN"))
			sfmsinSelected = "SELECTED";
		if (serviceParameter.trim().equals("SWIFTIN"))
			swiftinSelected = "SELECTED";
	%>

	<div class="col-md-12">
		<jsp:include page="primarymenubar.jsp" />
		<%-- <jsp:include page="include_header.jsp" /> --%>
	</div>

	<div class="container">

		<div class="row horizontal-line">
			<div class="col-lg-11 col-md-11 col-sm-11">
				<h3>Push Swift / SFMS Message - TIPLUS</h3>
			</div>
		</div>

		<form method="POST" action="">

			<div class="form-group">
				<label for="" class="col-md-2 control-label"
					style="text-align: left;">Message Type </label>
				<div class="col-md-3">
					<select name="type" class="form-control" id="type">
						<option value="" selected="selected"><----status-----></option>
						<option value="SFMSIN" <%=sfmsinSelected%>>SFMS Inward</option>
						<option value="SWIFTIN" <%=swiftinSelected%>>SWIFT Inward</option>
						<%-- <%=resubmittedSelected%> --%>
					</select>
				</div>
			</div>
			<%-- 
			<div class="form-group">
				<label for="" class="col-md-2 control-label">JNDI Name</label>
				<div class="col-md-3">
					<input type="text" class="form-control" id="swiftOutJndiName"
						name="swiftOutJndiName" value="<%=swiftOutJndiName%>"
						placeholder="JNDI-name" required>
				</div>
			</div>

			<div class="form-group">
				<label for="" class="col-md-1 control-label">MQ Name</label>
				<div class="col-md-3">
					<input type="text" class="form-control" id="mqName" name="mqName"
						value="<%=mqName%>" placeholder="MQ-Name" required>
				</div>
			</div> --%>

			<div class="col-md-1">
				<button class="btn btn-primary btn-sm" type="Submit">
					<span class="glyphicon"></span> Submit
				</button>
			</div>

			<div class="col-md-1">
				<button class="btn btn-danger btn-sm" type="reset">
					<span class="glyphicon"></span> Clear
				</button>
			</div>

			<br> <br> <br>
			<div class="form-group">
				<label for="" class="col-md-1 control-label">Message </label>
				<textarea class="form-control" id="swiftMessage" name="swiftMessage"
					cols="30" rows="14" spellcheck="false"
					placeholder="MT / IFN     MESSAGE" required><%=swiftMessage%></textarea>
				<div class="col-md-3"></div>
			</div>
			<br>

			<%-- 	<%
				if (swiftMessage != null && !swiftMessage.isEmpty()) {
			%>

			<%
				if (swiftoutQueuePostingStatus) {
			%>
			<div class="row">
				<div class="alert alert-success">
					Pushing Message into MQ Succeeded
					<%=swiftoutQueuePostingStatus%></div>
			</div>
			<%
				} else if (!swiftoutQueuePostingStatus) {
			%>
			<div class="row">
				<div class="alert alert-danger">
					Pushing Message into MQ Failure
					<%=swiftoutQueuePostingStatus%></div>
			</div>
			<%
				}
			%>

			<%
				}
			%> --%>
		</form>
	</div>
</body>
</html>