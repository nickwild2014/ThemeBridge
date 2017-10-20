<%-- 
  - Author:		 PRASATH RAVICHANDRAN
  - Date:		 2016-06-20  
  - Bank:		 Kotak Mahindra Bank Ltd.,
  - Description: Lookup Fiacle error code  
--%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="java.lang.String"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="javax.persistence.Query"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bs.themebridge.util.ThemeBridgeUtil"%>
<%@page import="com.bs.themebridge.entity.util.ThemeBridgeEntityManager"%>
<%@page
	import="com.bs.themebridge.entity.adapter.LookupFIErrorCodeAdapter"%>
<%@page import="com.bs.themebridge.entity.model.LookupFinacleErrorCode"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>FI Error Type Lookup</title>
<!--@author Prasath Ravichandran @date 2016-SEP-26 @Kotak Mahindra Bank-->
<!-- <link rel="shortcut icon" href="images/custom/browserlogo.png"> -->
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
<!-- <script src="../js/jquery-ui.datepicker.js" type="text/javascript"></script> -->
<script type="text/javascript">
	$(document).ready(function() {
		removeAllActiveMenu();
		addActiveMenu("lookup");
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#configuration').dataTable({
			// "sDom" : "<'row'<'col-xs-6'><'col-xs-6'f>>t<'row'<'col-xs-6'i><'col-xs-6'p>>",
			"iDisplayLength" : 50,
			"bFilter" : true,
			"bSortClasses" : false,
			"order" : [ [ 1, "asc" ] ]

		});
	});
</script>

</head>
<body>
	<%-- <h1> Start : <%=ThemeBridgeUtil.getLocalDateTime()%> </h1> --%>
	<%
		LookupFIErrorCodeAdapter fierrorLookup = new LookupFIErrorCodeAdapter();
		List<LookupFinacleErrorCode> fiErrorLookupList = fierrorLookup.getAllProperties();
	%>

	<%--<h1> End  Query  : <%=ThemeBridgeUtil.getLocalDateTime()%> </h1> --%>
	<div>
		<a name="top"></a>
	</div>
	<div class="col-md-12">
		<jsp:include page="primarymenubar.jsp" />
		<%-- <jsp:include page="include_header.jsp" /> --%>
	</div>

	<!-- Main content HTML -->
	<div class="container">
		<div class="row horizontal-line">
			<div class="col-lg-4 col-md-4 col-sm-4">
				<h3>Finacle Error code Lookup</h3>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-4">
				<jsp:include page="timezone.jsp" />
			</div>
			<!-- <legend></legend> -->
			<!-- <div class="col-lg-4 col-md-4 col-sm-4 daterangeoutstyle">
				<div id="reportrange" class="pull-right daterangeinstyle">
					<span></span> <b class="caret"></b>
				</div>
			</div> -->
		</div>
		<%
			if (fiErrorLookupList != null && fiErrorLookupList.size() == 0) {
		%>
		<div class="row">
			<div class="alert alert-danger">No record found</div>
		</div>
		<%
			}
		%>
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<table id="configuration" class="display" cellspacing="0"
						width="100%">
						<thead>
							<tr>
								<th class="col-md-1" style="color: green">Zone</th>
								<th class="col-md-1" style="color: green">FinacleErrorCode</th>
								<th class="col-md-2" style="color: green">ErrorDescription</th>
								<th class="col-md-1" style="color: green">Warn / Error</th>
							</tr>
						</thead>
						<tbody class="content">
							<%
								for (LookupFinacleErrorCode sd : fiErrorLookupList) {
							%>
							<tr>
								<td><%=sd.getZone()%></td>
								<td><%=sd.getErrorcode()%></td>
								<td><%=sd.getDescription()%></td>
								<td><%=sd.getDisplayflag()%></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
			</div>

		</div>
		<div>
			<a href="#top">Back to top of page</a>
		</div>
	</div>
	<%-- <div class="col-md-12">
		<jsp:include page="include_footer.jsp" />
	</div> --%>
</body>
</html>