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
<%@page import="com.bs.themebridge.entity.model.FDEnquiryModel"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>CRN account enquiry</title>
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
	function goBack() {
		window.history.back();
	};
</script>

<script type="text/javascript">
	$(document).ready(function() {

		//removeAllActiveMenu();
		//addActiveMenu("settings");

		$('#StatusEnquiry').dataTable({
			//"sDom" : "<'row'>t<'row'<'col-xs-4'i><'col-xs-6'p>>",
			"iDisplayLength" : 50,
			"bFilter" : true,
			"bSortClasses" : false,
			"bSort" : true,
			"order" : [ [ 3, "desc" ] ]
		});

	});
</script>
</head>
<body>
	<%
		String customerParameter = request.getParameter("customerCIF");

		if (customerParameter != null && !customerParameter.isEmpty()) {
			// test
		}

		String statusParameter = request.getParameter("status");
		String refNum = "";

		String twrefParameter = "";
		if (request.getAttribute("eventref") != null && request.getAttribute("eventref") != "") {
			twrefParameter = (String) request.getAttribute("eventref");
		}

		List<FDEnquiryModel> fDEnquiryList = (List<FDEnquiryModel>) request.getAttribute("accDetailsList");
		// out.println("List size : " + fDEnquiryList.size());
	%>
	<div class="col-md-12">
		<jsp:include page="primarytimenubar.jsp" />
		<%-- <jsp:include page="include_header.jsp" /> --%>
	</div>
	<div class="container">
		<div class="row horizontal-line">
			<div class="col-lg-8 col-md-8 col-sm-8">
				<h3>Customer account enquiry</h3>
			</div>
		</div>

		<div class="row">
			<!-- Body content HTML -->
			<div class="col-sm-12 col-md-12 col-lg-12">
				<div class="row">
					<div class="col-sm-offset-0 col-lg-12">
						<div class="row">
							<br>
							<%-- <%
								if (customerParameter != null && !customerParameter.isEmpty()) {
							%>
							<div class="form-group">
								<label for="" class="col-md-2 control-label">Customer
									CRN</label>
								<div class="col-md-2">
									<input type="text" id="customerParameter"
										name="customerParameter" class="form-control"
										value="<%=customerParameter%>" readonly>
								</div>
							</div>
							<%
								}
							%>
						</div>
						<br> --%>
						</div>
					</div>
				</div>
			</div>
			<%
				if (fDEnquiryList == null || fDEnquiryList.size() == 0) {
			%>
			<div class="row">
				<div class="alert alert-danger">No record found</div>
			</div>
			<%
				}
			%>
			<div class="row">
				<div class="col-lg-50">
					<div class="row">
						<table id="StatusEnquiry" class="display" cellspacing="0"
							width="100%">
							<thead>
								<tr>
									<th class="col-md-1" style="color: green">Customer CIF</th>
									<th class="col-md-1" style="color: green">Account Number</th>
									<th class="col-md-1" style="color: green">Branch</th>
									<th class="col-md-1" style="color: green">ProductCode</th>
									<th class="col-md-1" style="color: green">Account Currency</th>
									<th class="col-md-1" style="color: green">ProductCategory</th>
								</tr>
							</thead>
							<%
								if (fDEnquiryList != null) {
									fDEnquiryList = (List<FDEnquiryModel>) request.getAttribute("accDetailsList");
							%>
							<tbody class="content">
								<%
									for (FDEnquiryModel fd : fDEnquiryList) {
								%>
								<tr>
									<td><%=customerParameter%></td>
									<td><%=fd.getAcctId()%></td>
									<td><%=fd.getBranch()%></td>
									<td><%=fd.getProductCode()%></td>
									<td><%=fd.getAcctCurrCode()%></td>
									<td><%=fd.getProductCode()%></td>
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
	</div>
	<div class="col-md-12">
		<jsp:include page="include_footer.jsp" />
	</div>
</body>
</html>
