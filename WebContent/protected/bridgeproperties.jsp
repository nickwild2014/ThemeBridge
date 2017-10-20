<%-- 
  - Author:		 PRASATH RAVICHANDRAN
  - Date:		 2016-06-20  
  - Bank:		 Kotak Mahindra Bank Ltd.,
  - Description: ThemeBridge settings
--%>
<%@page import="java.util.List"%>
<%@page import="java.lang.String"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.bs.themebridge.util.ThemeBridgeUtil"%>
<%@page import="com.bs.themebridge.entity.model.Bridgeproperties"%>
<%@page
	import="com.bs.themebridge.entity.adapter.BridgepropertiesAdapter"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<title>BridgeProperties</title>
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
		addActiveMenu("bridgeproperties");
	});
	$(document).ready(function() {
		$('#configuration').dataTable({
			// "sDom" : "<'row'>t<'row'<'col-xs-4'i><'col-xs-6'p>>",
			"iDisplayLength" : 100,
			"bFilter" : true,
			"bSortClasses" : false,
			"bSort" : true,
			"order" : [ [ 3, "asc" ] ]
		});
	});

	//DONT DELETE, IT IS FOR CUSTOM FUNCTION
	function updateSettingRow(id) {
		var r = confirm("Are you sure?");
		if (r == true) {
			// alert('' + r + '' + id);
			updateSettings(id);
		} else {
			alert("Updation canceled!");
		}
	}
</script>
</head>
<body>
	<%
		BridgepropertiesAdapter bpa = new BridgepropertiesAdapter();
		List<Bridgeproperties> settingsData = bpa.getAllProperties();
	%>
	<!--  class="dt-example" -->
	<!-- Primary Menu bar HTML -->
	<div class="col-md-12">
		<jsp:include page="primarymenubar.jsp" />
		<%-- <jsp:include page="include_header.jsp" /> --%>
	</div>
	<div class="container">
		<div class="row horizontal-line">
			<div class="col-lg-4 col-md-4 col-sm-4">
				<h3>ThemeBridge Properties</h3>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-4">
				<jsp:include page="timezone.jsp" />
			</div>
			<!--<div class="col-lg-4 col-md-4 col-sm-4 daterangeoutstyle">
				<div id="reportrange" class="pull-right daterangeinstyle">
					<span></span> <b class="caret"></b>
				</div>
			</div>-->
		</div>
		<div class="row">
			<div class="col-sm-offset-1 col-lg-10">
				<!--<div class="row">
					<input type="submit" value="Update" class="btn btn-warning">
				</div>-->
				<div class="row">
					<table id="configuration" class="display" cellspacing="0"
						width="100%">
						<thead>
							<tr>
								<th class="col-md-1">ID</th>
								<th class="col-md-1">Zone</th>
								<th class="col-md-2">Category</th>
								<th class="col-md-1">Key</th>
								<th class="col-md-7">Value</th>
								<!-- <th class="col-md-1">Action</th> -->
							</tr>
						</thead>
						<tbody class="content">
							<%
								for (Bridgeproperties sd : settingsData) {
							%>
							<tr>
								<td><%=sd.getId()%></td>
								<td><%=sd.getZone()%></td>
								<td><%=sd.getCategory()%></td>
								<td><%=sd.getKey()%></td>
								<td><input type="text" id="bp_<%=sd.getId()%>"
									name="bp_<%=sd.getId()%>" class="form-control input-sm"
									value="<%=sd.getValue()%>" readonly /></td>
								<%-- <td><button onclick="updateSettingRow('<%=sd.getId()%>')"
										class="btn btn-success btn-xs" type="Submit">Update</button></td> --%>
							</tr>
							<%
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