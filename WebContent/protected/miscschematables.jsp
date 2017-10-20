<%-- 
  - Author:		 PRASATH RAVICHANDRAN
  - Date:		 2016-06-20  
  - Bank:		 Kotak Mahindra Bank Ltd.,
  - Description: Get schema details  
--%>
<%@page import="java.util.List"%>
<%@page import="java.lang.String"%>
<%@page import="com.bs.themebridge.util.ThemeBridgeUtil"%>
<%@page import="com.bs.themebridge.entity.model.SchemaAnalysisModel"%>
<%@page
	import="com.bs.themebridge.entity.servlet.util.SchemaAnalysisImpl"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<title>Schema Analysis</title>
<!--@author Prasath Ravichandran @date 2016-SEP-26 @Kotak Mahindra Bank-->
<!-- @author-Prasath Ravichandran, 2016-04-26 -->
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
	var loggedInUser = "<%=request.getRemoteUser()%>";
	if (!checkUserPrivileges(loggedInUser)) {
		window.location = "/ThemeBridge/protected/invalidaccess.jsp";
	} else {
		//do nothing
	}
</script>
<script type="text/javascript">
	$(document).ready(function() {
		removeAllActiveMenu();
		addActiveMenu("lookup");
	});
</script>
<script>
	$(document).ready(function() {

		$('#configuration').dataTable({
			// "sDom" : "<'row'>t<'row'<'col-xs-6'i><'col-xs-6'p>>",
			"iDisplayLength" : 100,
			"bFilter" : true,
			"bSortClasses" : false,
			"order" : [ [ 1, "asc" ] ]
		});
	});
</script>

</head>
<body>
	<%
		List<SchemaAnalysisModel> schemaList = null;
		String schemaName = "";
		// out.print("schemaName1 : " + request.getParameter("schemaname"));
		String TIZONESelected = "";
		String SNGSelected = "";
		String QATSelected = "";
		String THEMEBRIDGESelected = "";
		if (request.getParameter("schemaname") != "" && request.getParameter("schemaname") != null) {
			schemaName = request.getParameter("schemaname");
			// out.print("schemaName : " + schemaName);
			schemaList = SchemaAnalysisImpl.getSchemaTableSize(schemaName);
			// out.print("schemaListSize : " + schemaList.size());
			if (schemaName.equals("TIZONE"))
				TIZONESelected = "SELECTED";
			/* if (schemaName.equals("SNGZONE"))
				SNGSelected = "SELECTED";
			if (schemaName.equals("QATARZONE"))
				QATSelected = "SELECTED"; */
			if (schemaName.equals("THEMEBRIDGE"))
				THEMEBRIDGESelected = "SELECTED";
		} else {
			// do nothing
			// schemaList = SchemaTableSizeAdapter
			// .getSchemaTableSize("THEMEBRIDGE");
		}
		// out.print("schemaName2 : " + schemaName);
	%>
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
			<div class="col-lg-8 col-md-8 col-sm-8">
				<h3>Schema Analysis</h3>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-sm-offset-1 col-lg-10">
				<div class="row">
					<form method="POST" action="">
						<div class="col-sm-1">
							<label for="male">Schema</label>
						</div>
						<div class="col-sm-3">
							<select id="schemaname" name="schemaname" class="form-control"
								required>
								<option value=""><-- schema name --></option>
								<option value="TIZONE" <%=TIZONESelected%>>TIZONE</option>
								<option value="THEMEBRIDGE" <%=THEMEBRIDGESelected%>>THEMEBRIDGE</option>
							</select>
						</div>
						<div class="col-sm-2">
							<input class="btn btn-primary" type="submit" value="Fetch" />
						</div>
					</form>
				</div>
			</div>
		</div>
		<br>
		<%--<div id="loader">
			<img src="../images/custom/ajax-loader.gif" alt="loader"
						style="width: 40px; height: 40px;">
		</div>--%>
		<div class="row">
			<div class="col-sm-offset-1 col-lg-10">
				<div class="row">
					<table id="configuration" class="display" cellspacing="0"
						width="100%">
						<thead>
							<tr>
								<th class="col-md-2">SchemaName</th>
								<th class="col-md-2">TableName</th>
								<th class="col-md-1">RowsCount</th>
								<th class="col-md-1">TableSize</th>
								<!-- <th class="col-md-2">UnitSize</th> -->
							</tr>
						</thead>
						<tbody class="content">
							<%
								if (schemaList != null) {
									for (SchemaAnalysisModel schemaListLoop : schemaList) {
							%>
							<tr>							
								<td><%=schemaListLoop.getSchema_name()%></td>
								<td><%=schemaListLoop.getTable_name()%></td>
								<td><%=schemaListLoop.getNum_rows()%></td>
								<td><%=schemaListLoop.getMb()%> MB</td>								
							</tr>
							<%
								}
								}
							%>
						</tbody>

					</table>

				</div>
				<div>
					<a href="#top">Back to top of page</a>
				</div>
			</div>
		</div>
	</div>
	<div class="col-md-12">
		<jsp:include page="include_footer.jsp" />
	</div>
</body>
</html>
