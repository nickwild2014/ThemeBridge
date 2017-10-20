<%-- 
  - Author:		 PRASATH RAVICHANDRAN
  - Date:		 2016-06-20  
  - Bank:		 Kotak Mahindra Bank Ltd.,
  - Description: Lookup Customer type  
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
<%@page import="com.bs.themebridge.entity.model.LookupCustomerType"%>
<%@page
	import="com.bs.themebridge.entity.adapter.LookupCustomerTypeAdapter"%>
<%@page import="com.bs.themebridge.entity.util.ThemeBridgeEntityManager"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Customer Type Lookup</title>
<!--@author Prasath Ravichandran @date 2016-SEP-26 @Kotak Mahindra Bank-->
<!-- <link rel="shortcut icon" href="images/custom/browserlogo.png"> -->
<link rel="shortcut icon" href="../images/custom/themelogo3.png">
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="../css/daterangepicker-bs3.css" rel="stylesheet"
	type="text/css">
<link href="../css/jquery.dataTables.css" rel="stylesheet"
	type="text/css">
<link href="../css/jquery-ui.datepicker.css" rel="stylesheet"
	type="text/css">
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="../css/dataTables.bootstrap.css" rel="stylesheet"
	type="text/css">
<link href="../css/customized.css" rel="stylesheet" type="text/css">

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
		LookupCustomerTypeAdapter customerTypeLookup = new LookupCustomerTypeAdapter();
		List<LookupCustomerType> custLookupList = customerTypeLookup.getAllProperties();
		ThemeBridgeEntityManager tbe = new ThemeBridgeEntityManager();
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
				<h3>Customer Type Lookup</h3>
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
			if (custLookupList != null && custLookupList.size() == 0) {
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
								<th class="col-md-1" style="color: green">TICustomerType</th>
								<th class="col-md-1" style="color: green">FICustomerType</th>
								<th class="col-md-4" style="color: green">Description</th>
							</tr>
						</thead>
						<tbody class="content">
							<%
								for (LookupCustomerType sd : custLookupList) {
							%>
							<tr>
								<td><%=sd.getZone()%></td>
								<td><%=sd.getTicustomertype()%></td>
								<td><%=sd.getFicustomertype()%></td>
								<td><%=sd.getDescription()%></td>
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