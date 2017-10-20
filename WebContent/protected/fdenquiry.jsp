<%-- 
  - Author:		 PRASATH RAVICHANDRAN
  - Date:		 2016-06-20  
  - Bank:		 Kotak Mahindra Bank Ltd.,
  - Description: Transaction status.   
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.lang.String"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bs.themebridge.util.ThemeBridgeUtil"%>
<%@page import="com.bs.themebridge.entity.model.Servicelog"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Transaction status</title>
<!--@author Prasath Ravichandran @date 2016-SEP-26 @Kotak Mahindra Bank-->
<link rel="shortcut icon" href="../images/custom/browserlogo.png">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/daterangepicker-bs3.css" rel="stylesheet"
	type="text/css">
<link href="css/jquery.dataTables.css" rel="stylesheet" type="text/css">
<link href="css/jquery-ui.datepicker.css" rel="stylesheet"
	type="text/css">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="css/dataTables.bootstrap.css" rel="stylesheet"
	type="text/css">
<link href="css/customized.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="js/respond.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/moment.js"></script>
<script type="text/javascript" src="js/daterangepicker.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="js/custom.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		removeAllActiveMenu();
		addActiveMenu("timenu");
	});
</script>

<script type="text/javascript">
	$(document).ready(function() {

		//removeAllActiveMenu();
		//addActiveMenu("settings");

		$('#configuration').dataTable({
			// "sDom" : "<'row'>t<'row'<'col-xs-6'i><'col-xs-6'p>>",
			"iDisplayLength" : 100,
			"bFilter" : true,
			"bSortClasses" : false,
			"order" : [ [ 2, "asc" ] ]
		});

	});
</script>
</head>
<body>
	<%
		String statusParameter = request.getParameter("status");

		String successSelected = "";
		String failureSelected = "";
		if (statusParameter == null)
			statusParameter = "";
		if (statusParameter.trim().equals("Y"))
			successSelected = "SELECTED";
		if (statusParameter.trim().equals("N"))
			failureSelected = "SELECTED";

		String twrefParameter = "";
		if (request.getAttribute("eventref") != "" && request.getAttribute("eventref") != null) {
			twrefParameter = (String) request.getAttribute("eventref");
		}

		String refNum = "";
		if (request.getAttribute("masterref") != "" && request.getAttribute("masterref") != null) {
			refNum = (String) request.getAttribute("masterref");
		}
		// out.println(refNum);
		List<Servicelog> twlist = (List<Servicelog>) request.getAttribute("tranStatusList");
		// out.println("List size : " + twlist.size());
	%>
	<div class="col-md-12">
		<jsp:include page="primarytimenubar.jsp" />
		<%-- <jsp:include page="include_header.jsp" /> --%>
	</div>
	<br>
	<br>
	<div class="container">
		<div class="row horizontal-line">
			<div class="col-lg-8 col-md-8 col-sm-8">
				<h3>Transaction Status</h3>
			</div>
			<!-- <div class="col-lg-4 col-md-4 col-sm-4 daterangeoutstyle">
				<div id="reportrange" class="pull-right daterangeinstyle">
					<span></span> <b class="caret"></b>
				</div>
			</div> -->
		</div>

		<div class="row">
			<!-- Body content HTML -->
			<div class="col-sm-12 col-md-12 col-lg-12">
				<div class="row">
					<div class="col-sm-offset-0 col-lg-12">
						<div class="row">
							<br>

							<!-- ---------------2015-06-18----------------- -->
							<%-- <div class="col-lg-2">	
								<label>Fund Transfer</label><select name="fundtransfer" id="fundtransfer" class="form-control">
									<option value="" selected="selected"><----All Funds----></option>									
									<option value="NEFT" <%=neftSelected%>>NEFT</option>
									<option value="RTGS" <%=rtgsSelected%>>RTGS</option>								
								</select>
							</div>	--%>
							<%-- <div class="col-lg-2">	
								<label>Status</label><select name="status" id="status" class="form-control">
									<option value="" selected="selected"><----All status----></option>									
									<option value="Y" <%=successSelected%>>SUCCESS</option>
									<option value="N" <%=failureSelected%>>FAILURE</option>																	
								</select>
							</div>--%>
							<!-- ---------------2015-06-18----------------- -->
							<div class="col-lg-2">
								<label>Master Reference </label><input type="text"
									id="mastereventref" name="mastereventref" class="form-control"
									placeholder="Master Ref" value="<%=refNum%>" readonly>
							</div>

							<%
								if (!twrefParameter.isEmpty() || twrefParameter != null) {
							%>
							<div class="col-lg-2">
								<label>Event Reference </label><input type="text" id="eventref"
									name="eventref" class="form-control" placeholder="Event Ref"
									value="<%=twrefParameter%>" readonly>
							</div>
							<%
								}
							%>
							<!-- <div class="col-lg-2">
								<a href="#" class="btn btn-primary col-lg-10"
									onclick="this.href='/ThemeBridge/trandetailslookup?fromdaterange='+document.getElementById('fromdaterange').value+'&todaterange='+document.getElementById('todaterange').value+'&masterRef='+document.getElementById('mastereventref').value+'&eventRef='+document.getElementById('eventref').value+'&action=tb'; return true;">
									View Status</a>
							</div> -->
							<!--  <div class="col-lg-2">
								<a href="#" class="btn btn-success col-lg-10"
									onclick="this.href='/ThemeBridge/tradeworksreport?fromdaterange='+document.getElementById('fromdaterange').value+'&todaterange='+document.getElementById('todaterange').value+'&referencenum='+document.getElementById('mastereventref').value+'&twref='+document.getElementById('twref').value+'&status='+document.getElementById('status').value+'&action=download'+'&hitfrom=tradeworks'; return true;">
									Download CSV</a>
							</div>	-->
						</div>
						<br>
					</div>
				</div>
			</div>
		</div>
		<%
			if (twlist != null && twlist.size() == 0) {
		%>
		<div class="row">
			<div class="alert alert-danger">No record found</div>
		</div>
		<%
			}
		%>
		<!--<div class="row">
			<div class="span12" id="signLoaderDiv"
				style="text-align: center; display: none;">
				<img src="images/custom/select2-spinner.gif" alt="Loading" height="42"
					width="42">  			
			</div>
		</div>
		<div id="spinner" class="spinner" style="display: none;">
			Getting value. Please wait....<br> <img id="img-spinner"
				src="loader.gif" alt="Loading" />
		</div>-->
		<div class="row">
			<div class="col-lg-50">
				<div class="row">
					<table id="configuration" class="display" cellspacing="0"
						width="100%">
						<thead>
							<tr>
								<th class="col-md-1">Service</th>
								<th class="col-md-1">Operation</th>
								<th class="col-md-1">Zone</th>
								<th class="col-md-1">MasterReference</th>
								<th class="col-md-1">EventReference</th>
								<th class="col-md-1">Status</th>
								<th class="col-md-1">ProcessTime</th>
							</tr>
						</thead>
						<%
							if (twlist != null) {
								twlist = (List<Servicelog>) request.getAttribute("tranStatusList");
						%>
						<tbody class="content">
							<%
								for (Servicelog sd : twlist) {
							%>
							<tr>
								<td><%=sd.getService()%></td>
								<td><%=sd.getOperation()%></td>
								<td><%=sd.getZone()%></td>
								<td><%=sd.getMasterreference()%></td>
								<td><%=sd.getEventreference()%></td>
								<td><%=sd.getStatus()%></td>
								<td><%=sd.getProcesstime()%></td>
							</tr>
							<%
								}
								}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-12">
		<jsp:include page="include_footer.jsp" />
	</div>
</body>
</html>
